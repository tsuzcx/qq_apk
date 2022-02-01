package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.iq;
import com.tencent.mm.g.a.iq.a;
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
  private GetIsSupportSoterTask jHi = null;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(106588);
    ad.i("MicroMsg.JsApiCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
    this.jHi = new GetIsSupportSoterTask(paramc, paramInt, this);
    this.jHi.aXm();
    AppBrandMainProcessService.a(this.jHi);
    AppMethodBeat.o(106588);
  }
  
  static class GetIsSupportSoterTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetIsSupportSoterTask> CREATOR;
    private int bZo;
    private c jAc;
    private JsApiCheckIsSupportSoterAuthentication jHj;
    private int jHk;
    
    static
    {
      AppMethodBeat.i(106587);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(106587);
    }
    
    protected GetIsSupportSoterTask(Parcel paramParcel)
    {
      AppMethodBeat.i(106585);
      this.jAc = null;
      this.bZo = -1;
      this.jHk = 0;
      e(paramParcel);
      AppMethodBeat.o(106585);
    }
    
    public GetIsSupportSoterTask(c paramc, int paramInt, JsApiCheckIsSupportSoterAuthentication paramJsApiCheckIsSupportSoterAuthentication)
    {
      this.jAc = null;
      this.bZo = -1;
      this.jHk = 0;
      this.jAc = paramc;
      this.bZo = paramInt;
      this.jHj = paramJsApiCheckIsSupportSoterAuthentication;
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(106582);
      super.aEA();
      ad.d("MicroMsg.GetIsSupportSoterTask", "hy: callback. supportMode: %d", new Object[] { Integer.valueOf(this.jHk) });
      HashMap localHashMap = new HashMap(2);
      localHashMap.put("supportMode", a.ry(this.jHk));
      this.jAc.h(this.bZo, this.jHj.k("ok", localHashMap));
      aXn();
      AppMethodBeat.o(106582);
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(106583);
      iq localiq = new iq();
      com.tencent.mm.sdk.b.a.ESL.l(localiq);
      this.jHk = localiq.dmG.dmH;
      ad.i("MicroMsg.GetIsSupportSoterTask", "hy: supportMode: %d", new Object[] { Integer.valueOf(this.jHk) });
      aXw();
      AppMethodBeat.o(106583);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(106586);
      super.e(paramParcel);
      this.jHk = paramParcel.readInt();
      AppMethodBeat.o(106586);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(106584);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.jHk);
      AppMethodBeat.o(106584);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckIsSupportSoterAuthentication
 * JD-Core Version:    0.7.0.1
 */