package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jg;
import com.tencent.mm.g.a.jg.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiCheckIsSupportSoterAuthentication
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 276;
  public static final String NAME = "checkIsSupportSoterAuthentication";
  private GetIsSupportSoterTask kFP = null;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(106588);
    ae.i("MicroMsg.JsApiCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
    this.kFP = new GetIsSupportSoterTask(paramc, paramInt, this);
    this.kFP.biw();
    AppBrandMainProcessService.a(this.kFP);
    AppMethodBeat.o(106588);
  }
  
  static class GetIsSupportSoterTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsSupportSoterTask> CREATOR;
    private int cgA;
    private c jQp;
    private JsApiCheckIsSupportSoterAuthentication kFQ;
    private int kFR;
    
    static
    {
      AppMethodBeat.i(106587);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106587);
    }
    
    protected GetIsSupportSoterTask(Parcel paramParcel)
    {
      AppMethodBeat.i(106585);
      this.jQp = null;
      this.cgA = -1;
      this.kFR = 0;
      e(paramParcel);
      AppMethodBeat.o(106585);
    }
    
    public GetIsSupportSoterTask(c paramc, int paramInt, JsApiCheckIsSupportSoterAuthentication paramJsApiCheckIsSupportSoterAuthentication)
    {
      this.jQp = null;
      this.cgA = -1;
      this.kFR = 0;
      this.jQp = paramc;
      this.cgA = paramInt;
      this.kFQ = paramJsApiCheckIsSupportSoterAuthentication;
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(106583);
      jg localjg = new jg();
      com.tencent.mm.sdk.b.a.IvT.l(localjg);
      this.kFR = localjg.dxg.dxh;
      ae.i("MicroMsg.GetIsSupportSoterTask", "hy: supportMode: %d", new Object[] { Integer.valueOf(this.kFR) });
      biG();
      AppMethodBeat.o(106583);
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(106582);
      super.aOY();
      ae.d("MicroMsg.GetIsSupportSoterTask", "hy: callback. supportMode: %d", new Object[] { Integer.valueOf(this.kFR) });
      HashMap localHashMap = new HashMap(2);
      localHashMap.put("supportMode", a.sS(this.kFR));
      this.jQp.h(this.cgA, this.kFQ.n("ok", localHashMap));
      bix();
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
      this.kFR = paramParcel.readInt();
      AppMethodBeat.o(106586);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106584);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.kFR);
      AppMethodBeat.o(106584);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckIsSupportSoterAuthentication
 * JD-Core Version:    0.7.0.1
 */