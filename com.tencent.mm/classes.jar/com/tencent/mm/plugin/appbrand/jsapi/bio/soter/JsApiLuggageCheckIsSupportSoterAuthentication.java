package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiLuggageCheckIsSupportSoterAuthentication
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 276;
  public static final String NAME = "checkIsSupportSoterAuthentication";
  private GetIsSupportSoterTask kCG;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(159049);
    ad.i("MicroMsg.JsApiLuggageCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
    this.kCG = new GetIsSupportSoterTask(paramc, paramInt, this);
    this.kCG.bhN();
    AppBrandMainProcessService.a(this.kCG);
    AppMethodBeat.o(159049);
  }
  
  static class GetIsSupportSoterTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsSupportSoterTask> CREATOR;
    private int cgA;
    private JsApiLuggageCheckIsSupportSoterAuthentication kCH;
    private String kCI;
    private c kuU;
    
    static
    {
      AppMethodBeat.i(159048);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(159048);
    }
    
    protected GetIsSupportSoterTask(Parcel paramParcel)
    {
      AppMethodBeat.i(159046);
      this.kuU = null;
      this.cgA = -1;
      this.kCI = "";
      e(paramParcel);
      AppMethodBeat.o(159046);
    }
    
    public GetIsSupportSoterTask(c paramc, int paramInt, JsApiLuggageCheckIsSupportSoterAuthentication paramJsApiLuggageCheckIsSupportSoterAuthentication)
    {
      this.kuU = null;
      this.cgA = -1;
      this.kCI = "";
      this.kuU = paramc;
      this.cgA = paramInt;
      this.kCH = paramJsApiLuggageCheckIsSupportSoterAuthentication;
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(159044);
      this.kCI = com.tencent.soter.core.a.fUF();
      ad.i("MicroMsg.GetIsSupportSoterTask", "hy: verifyRemoteStr: %s", new Object[] { this.kCI });
      bhX();
      AppMethodBeat.o(159044);
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(159043);
      super.aOB();
      ad.d("MicroMsg.GetIsSupportSoterTask", "hy: callback. verifyRemoteStr: %s", new Object[] { this.kCI });
      HashMap localHashMap = new HashMap(2);
      localHashMap.put("verifyRemote", this.kCI);
      localHashMap.put("nativeSupport", Boolean.valueOf(com.tencent.soter.core.a.fUz()));
      ad.i("MicroMsg.GetIsSupportSoterTask", "hy: nativeSupport:" + com.tencent.soter.core.a.fUz());
      this.kuU.h(this.cgA, this.kCH.m("ok", localHashMap));
      bhO();
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
      this.kCI = paramParcel.readString();
      AppMethodBeat.o(159047);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(159045);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.kCI);
      AppMethodBeat.o(159045);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckIsSupportSoterAuthentication
 * JD-Core Version:    0.7.0.1
 */