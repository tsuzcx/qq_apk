package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.core.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiLuggageCheckIsSupportSoterAuthentication
  extends c
{
  public static final int CTRL_INDEX = 276;
  public static final String NAME = "checkIsSupportSoterAuthentication";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(159049);
    Log.i("MicroMsg.JsApiLuggageCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
    new GetIsSupportSoterTask(paramf, paramInt, this);
    AppMethodBeat.o(159049);
    throw null;
  }
  
  static class GetIsSupportSoterTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsSupportSoterTask> CREATOR;
    private int eit;
    private f qNp;
    private JsApiLuggageCheckIsSupportSoterAuthentication rJK;
    private String rJL;
    
    static
    {
      AppMethodBeat.i(159048);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(159048);
    }
    
    protected GetIsSupportSoterTask(Parcel paramParcel)
    {
      AppMethodBeat.i(159046);
      this.qNp = null;
      this.eit = -1;
      this.rJL = "";
      h(paramParcel);
      AppMethodBeat.o(159046);
    }
    
    public GetIsSupportSoterTask(f paramf, int paramInt, JsApiLuggageCheckIsSupportSoterAuthentication paramJsApiLuggageCheckIsSupportSoterAuthentication)
    {
      this.qNp = null;
      this.eit = -1;
      this.rJL = "";
      this.qNp = paramf;
      this.eit = paramInt;
      this.rJK = paramJsApiLuggageCheckIsSupportSoterAuthentication;
    }
    
    public final void asn()
    {
      AppMethodBeat.i(159044);
      this.rJL = a.jYb();
      Log.i("MicroMsg.GetIsSupportSoterTask", "hy: verifyRemoteStr: %s", new Object[] { this.rJL });
      cpA();
      AppMethodBeat.o(159044);
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(159043);
      super.bQr();
      Log.d("MicroMsg.GetIsSupportSoterTask", "hy: callback. verifyRemoteStr: %s", new Object[] { this.rJL });
      HashMap localHashMap = new HashMap(2);
      localHashMap.put("verifyRemote", this.rJL);
      localHashMap.put("nativeSupport", Boolean.valueOf(a.jXV()));
      Log.i("MicroMsg.GetIsSupportSoterTask", "hy: nativeSupport:" + a.jXV());
      this.qNp.callback(this.eit, this.rJK.m("ok", localHashMap));
      cpx();
      AppMethodBeat.o(159043);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(159047);
      super.h(paramParcel);
      this.rJL = paramParcel.readString();
      AppMethodBeat.o(159047);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(159045);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.rJL);
      AppMethodBeat.o(159045);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckIsSupportSoterAuthentication
 * JD-Core Version:    0.7.0.1
 */