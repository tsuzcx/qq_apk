package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiLuggageCheckIsSupportSoterAuthentication
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 276;
  public static final String NAME = "checkIsSupportSoterAuthentication";
  private GetIsSupportSoterTask khN;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(159049);
    ac.i("MicroMsg.JsApiLuggageCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
    this.khN = new GetIsSupportSoterTask(paramc, paramInt, this);
    this.khN.bej();
    AppBrandMainProcessService.a(this.khN);
    AppMethodBeat.o(159049);
  }
  
  static class GetIsSupportSoterTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsSupportSoterTask> CREATOR;
    private int bWl;
    private c kay;
    private JsApiLuggageCheckIsSupportSoterAuthentication khO;
    private String khP;
    
    static
    {
      AppMethodBeat.i(159048);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(159048);
    }
    
    protected GetIsSupportSoterTask(Parcel paramParcel)
    {
      AppMethodBeat.i(159046);
      this.kay = null;
      this.bWl = -1;
      this.khP = "";
      e(paramParcel);
      AppMethodBeat.o(159046);
    }
    
    public GetIsSupportSoterTask(c paramc, int paramInt, JsApiLuggageCheckIsSupportSoterAuthentication paramJsApiLuggageCheckIsSupportSoterAuthentication)
    {
      this.kay = null;
      this.bWl = -1;
      this.khP = "";
      this.kay = paramc;
      this.bWl = paramInt;
      this.khO = paramJsApiLuggageCheckIsSupportSoterAuthentication;
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(159044);
      this.khP = com.tencent.soter.core.a.fDn();
      ac.i("MicroMsg.GetIsSupportSoterTask", "hy: verifyRemoteStr: %s", new Object[] { this.khP });
      bet();
      AppMethodBeat.o(159044);
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(159043);
      super.aLr();
      ac.d("MicroMsg.GetIsSupportSoterTask", "hy: callback. verifyRemoteStr: %s", new Object[] { this.khP });
      HashMap localHashMap = new HashMap(2);
      localHashMap.put("verifyRemote", this.khP);
      localHashMap.put("nativeSupport", Boolean.valueOf(com.tencent.soter.core.a.fDh()));
      ac.i("MicroMsg.GetIsSupportSoterTask", "hy: nativeSupport:" + com.tencent.soter.core.a.fDh());
      this.kay.h(this.bWl, this.khO.k("ok", localHashMap));
      bek();
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
      this.khP = paramParcel.readString();
      AppMethodBeat.o(159047);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(159045);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.khP);
      AppMethodBeat.o(159045);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckIsSupportSoterAuthentication
 * JD-Core Version:    0.7.0.1
 */