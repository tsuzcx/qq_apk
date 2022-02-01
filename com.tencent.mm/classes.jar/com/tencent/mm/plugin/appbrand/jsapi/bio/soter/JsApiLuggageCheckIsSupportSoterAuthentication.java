package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.core.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiLuggageCheckIsSupportSoterAuthentication
  extends d
{
  public static final int CTRL_INDEX = 276;
  public static final String NAME = "checkIsSupportSoterAuthentication";
  private GetIsSupportSoterTask lKw;
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(159049);
    Log.i("MicroMsg.JsApiLuggageCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
    this.lKw = new GetIsSupportSoterTask(paramf, paramInt, this);
    this.lKw.bDJ();
    AppBrandMainProcessService.a(this.lKw);
    AppMethodBeat.o(159049);
  }
  
  static class GetIsSupportSoterTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsSupportSoterTask> CREATOR;
    private int csv;
    private f kSY;
    private JsApiLuggageCheckIsSupportSoterAuthentication lKx;
    private String lKy;
    
    static
    {
      AppMethodBeat.i(159048);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(159048);
    }
    
    protected GetIsSupportSoterTask(Parcel paramParcel)
    {
      AppMethodBeat.i(159046);
      this.kSY = null;
      this.csv = -1;
      this.lKy = "";
      f(paramParcel);
      AppMethodBeat.o(159046);
    }
    
    public GetIsSupportSoterTask(f paramf, int paramInt, JsApiLuggageCheckIsSupportSoterAuthentication paramJsApiLuggageCheckIsSupportSoterAuthentication)
    {
      this.kSY = null;
      this.csv = -1;
      this.lKy = "";
      this.kSY = paramf;
      this.csv = paramInt;
      this.lKx = paramJsApiLuggageCheckIsSupportSoterAuthentication;
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(159044);
      this.lKy = a.hlp();
      Log.i("MicroMsg.GetIsSupportSoterTask", "hy: verifyRemoteStr: %s", new Object[] { this.lKy });
      bDU();
      AppMethodBeat.o(159044);
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(159043);
      super.bjk();
      Log.d("MicroMsg.GetIsSupportSoterTask", "hy: callback. verifyRemoteStr: %s", new Object[] { this.lKy });
      HashMap localHashMap = new HashMap(2);
      localHashMap.put("verifyRemote", this.lKy);
      localHashMap.put("nativeSupport", Boolean.valueOf(a.hlj()));
      Log.i("MicroMsg.GetIsSupportSoterTask", "hy: nativeSupport:" + a.hlj());
      this.kSY.i(this.csv, this.lKx.n("ok", localHashMap));
      bDK();
      AppMethodBeat.o(159043);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(159047);
      super.f(paramParcel);
      this.lKy = paramParcel.readString();
      AppMethodBeat.o(159047);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(159045);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.lKy);
      AppMethodBeat.o(159045);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckIsSupportSoterAuthentication
 * JD-Core Version:    0.7.0.1
 */