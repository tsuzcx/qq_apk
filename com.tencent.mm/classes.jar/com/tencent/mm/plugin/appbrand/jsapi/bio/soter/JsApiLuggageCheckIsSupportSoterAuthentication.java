package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiLuggageCheckIsSupportSoterAuthentication
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 276;
  public static final String NAME = "checkIsSupportSoterAuthentication";
  private GetIsSupportSoterTask kFV;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(159049);
    ae.i("MicroMsg.JsApiLuggageCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
    this.kFV = new GetIsSupportSoterTask(paramc, paramInt, this);
    this.kFV.biw();
    AppBrandMainProcessService.a(this.kFV);
    AppMethodBeat.o(159049);
  }
  
  static class GetIsSupportSoterTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsSupportSoterTask> CREATOR;
    private int cgA;
    private c jQp;
    private JsApiLuggageCheckIsSupportSoterAuthentication kFW;
    private String kFX;
    
    static
    {
      AppMethodBeat.i(159048);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(159048);
    }
    
    protected GetIsSupportSoterTask(Parcel paramParcel)
    {
      AppMethodBeat.i(159046);
      this.jQp = null;
      this.cgA = -1;
      this.kFX = "";
      e(paramParcel);
      AppMethodBeat.o(159046);
    }
    
    public GetIsSupportSoterTask(c paramc, int paramInt, JsApiLuggageCheckIsSupportSoterAuthentication paramJsApiLuggageCheckIsSupportSoterAuthentication)
    {
      this.jQp = null;
      this.cgA = -1;
      this.kFX = "";
      this.jQp = paramc;
      this.cgA = paramInt;
      this.kFW = paramJsApiLuggageCheckIsSupportSoterAuthentication;
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(159044);
      this.kFX = com.tencent.soter.core.a.fZe();
      ae.i("MicroMsg.GetIsSupportSoterTask", "hy: verifyRemoteStr: %s", new Object[] { this.kFX });
      biG();
      AppMethodBeat.o(159044);
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(159043);
      super.aOY();
      ae.d("MicroMsg.GetIsSupportSoterTask", "hy: callback. verifyRemoteStr: %s", new Object[] { this.kFX });
      HashMap localHashMap = new HashMap(2);
      localHashMap.put("verifyRemote", this.kFX);
      localHashMap.put("nativeSupport", Boolean.valueOf(com.tencent.soter.core.a.fYY()));
      ae.i("MicroMsg.GetIsSupportSoterTask", "hy: nativeSupport:" + com.tencent.soter.core.a.fYY());
      this.jQp.h(this.cgA, this.kFW.n("ok", localHashMap));
      bix();
      AppMethodBeat.o(159043);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(159047);
      super.e(paramParcel);
      this.kFX = paramParcel.readString();
      AppMethodBeat.o(159047);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(159045);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.kFX);
      AppMethodBeat.o(159045);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckIsSupportSoterAuthentication
 * JD-Core Version:    0.7.0.1
 */