package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
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
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(159049);
    Log.i("MicroMsg.JsApiLuggageCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
    new GetIsSupportSoterTask(parame, paramInt, this);
    AppMethodBeat.o(159049);
    throw null;
  }
  
  static class GetIsSupportSoterTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsSupportSoterTask> CREATOR;
    private int cqA;
    private e nNw;
    private JsApiLuggageCheckIsSupportSoterAuthentication oGL;
    private String oGM;
    
    static
    {
      AppMethodBeat.i(159048);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(159048);
    }
    
    protected GetIsSupportSoterTask(Parcel paramParcel)
    {
      AppMethodBeat.i(159046);
      this.nNw = null;
      this.cqA = -1;
      this.oGM = "";
      f(paramParcel);
      AppMethodBeat.o(159046);
    }
    
    public GetIsSupportSoterTask(e parame, int paramInt, JsApiLuggageCheckIsSupportSoterAuthentication paramJsApiLuggageCheckIsSupportSoterAuthentication)
    {
      this.nNw = null;
      this.cqA = -1;
      this.oGM = "";
      this.nNw = parame;
      this.cqA = paramInt;
      this.oGL = paramJsApiLuggageCheckIsSupportSoterAuthentication;
    }
    
    public final void RW()
    {
      AppMethodBeat.i(159044);
      this.oGM = a.ioO();
      Log.i("MicroMsg.GetIsSupportSoterTask", "hy: verifyRemoteStr: %s", new Object[] { this.oGM });
      bPt();
      AppMethodBeat.o(159044);
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(159043);
      super.bsK();
      Log.d("MicroMsg.GetIsSupportSoterTask", "hy: callback. verifyRemoteStr: %s", new Object[] { this.oGM });
      HashMap localHashMap = new HashMap(2);
      localHashMap.put("verifyRemote", this.oGM);
      localHashMap.put("nativeSupport", Boolean.valueOf(a.ioI()));
      Log.i("MicroMsg.GetIsSupportSoterTask", "hy: nativeSupport:" + a.ioI());
      this.nNw.j(this.cqA, this.oGL.m("ok", localHashMap));
      bPk();
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
      this.oGM = paramParcel.readString();
      AppMethodBeat.o(159047);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(159045);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.oGM);
      AppMethodBeat.o(159045);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckIsSupportSoterAuthentication
 * JD-Core Version:    0.7.0.1
 */