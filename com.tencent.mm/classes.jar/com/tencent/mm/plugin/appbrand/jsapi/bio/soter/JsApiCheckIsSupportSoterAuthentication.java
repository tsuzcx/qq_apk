package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jf;
import com.tencent.mm.g.a.jf.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiCheckIsSupportSoterAuthentication
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 276;
  public static final String NAME = "checkIsSupportSoterAuthentication";
  private GetIsSupportSoterTask kCA = null;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(106588);
    ad.i("MicroMsg.JsApiCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
    this.kCA = new GetIsSupportSoterTask(paramc, paramInt, this);
    this.kCA.bhN();
    AppBrandMainProcessService.a(this.kCA);
    AppMethodBeat.o(106588);
  }
  
  static class GetIsSupportSoterTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsSupportSoterTask> CREATOR;
    private int cgA;
    private JsApiCheckIsSupportSoterAuthentication kCB;
    private int kCC;
    private c kuU;
    
    static
    {
      AppMethodBeat.i(106587);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106587);
    }
    
    protected GetIsSupportSoterTask(Parcel paramParcel)
    {
      AppMethodBeat.i(106585);
      this.kuU = null;
      this.cgA = -1;
      this.kCC = 0;
      e(paramParcel);
      AppMethodBeat.o(106585);
    }
    
    public GetIsSupportSoterTask(c paramc, int paramInt, JsApiCheckIsSupportSoterAuthentication paramJsApiCheckIsSupportSoterAuthentication)
    {
      this.kuU = null;
      this.cgA = -1;
      this.kCC = 0;
      this.kuU = paramc;
      this.cgA = paramInt;
      this.kCB = paramJsApiCheckIsSupportSoterAuthentication;
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(106583);
      jf localjf = new jf();
      com.tencent.mm.sdk.b.a.IbL.l(localjf);
      this.kCC = localjf.dwb.dwc;
      ad.i("MicroMsg.GetIsSupportSoterTask", "hy: supportMode: %d", new Object[] { Integer.valueOf(this.kCC) });
      bhX();
      AppMethodBeat.o(106583);
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(106582);
      super.aOB();
      ad.d("MicroMsg.GetIsSupportSoterTask", "hy: callback. supportMode: %d", new Object[] { Integer.valueOf(this.kCC) });
      HashMap localHashMap = new HashMap(2);
      localHashMap.put("supportMode", a.sP(this.kCC));
      this.kuU.h(this.cgA, this.kCB.m("ok", localHashMap));
      bhO();
      AppMethodBeat.o(106582);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(106586);
      super.e(paramParcel);
      this.kCC = paramParcel.readInt();
      AppMethodBeat.o(106586);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106584);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.kCC);
      AppMethodBeat.o(106584);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckIsSupportSoterAuthentication
 * JD-Core Version:    0.7.0.1
 */