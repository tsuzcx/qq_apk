package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.bmb;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.protocal.protobuf.bmz;
import com.tencent.mm.protocal.protobuf.eat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiRefreshSession
  extends a
{
  private static final int CTRL_INDEX = 118;
  private static final String NAME = "refreshSession";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45631);
    paramJSONObject = new RefreshSessionTask();
    Object localObject = (k)paramc.ar(k.class);
    if (localObject != null) {
      RefreshSessionTask.a(paramJSONObject, ((k)localObject).jEg.jpa);
    }
    localObject = paramc.getAppId();
    paramJSONObject.jOU = this;
    paramJSONObject.jYG = paramc;
    paramJSONObject.jOT = paramInt;
    paramJSONObject.appId = ((String)localObject);
    paramc = com.tencent.mm.plugin.appbrand.a.GW((String)localObject);
    if (paramc != null) {
      paramJSONObject.jZF = paramc.scene;
    }
    paramJSONObject.bej();
    AppBrandMainProcessService.a(paramJSONObject);
    AppMethodBeat.o(45631);
  }
  
  public static class RefreshSessionTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<RefreshSessionTask> CREATOR;
    String appId;
    private String errorMsg;
    private int hxM;
    int jOT;
    m jOU;
    c jYG;
    private int jZC;
    private int jZD;
    private int jZE;
    int jZF;
    
    static
    {
      AppMethodBeat.i(45630);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45630);
    }
    
    public RefreshSessionTask() {}
    
    public RefreshSessionTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45621);
      e(paramParcel);
      AppMethodBeat.o(45621);
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(45622);
      bej();
      b.a locala = new b.a();
      locala.hvt = new bmy();
      locala.hvu = new bmz();
      locala.uri = "/cgi-bin/mmbiz-bin/js-refreshsession";
      locala.funcId = 1196;
      locala.reqCmdId = 0;
      locala.respCmdId = 0;
      bmy localbmy = new bmy();
      localbmy.hOf = this.appId;
      localbmy.FbR = this.hxM;
      locala.hvt = localbmy;
      if (this.jZF > 0)
      {
        localbmy.FbS = new eat();
        localbmy.FbS.scene = this.jZF;
      }
      ac.i("MicroMsg.JsApiRefreshSession", "refreshSession appId %s, versionType, statScene %d", new Object[] { this.appId, Integer.valueOf(this.hxM), Integer.valueOf(this.jZF) });
      x.a(locala.aAz(), new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(45619);
          ac.d("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 0);
            JsApiRefreshSession.RefreshSessionTask.a(JsApiRefreshSession.RefreshSessionTask.this, "cgi fail");
            JsApiRefreshSession.RefreshSessionTask.a(JsApiRefreshSession.RefreshSessionTask.this);
            AppMethodBeat.o(45619);
            return 0;
          }
          paramAnonymousb = (bmz)paramAnonymousb.hvs.hvw;
          if ((paramAnonymousb == null) || (paramAnonymousb.FbT == null))
          {
            JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 0);
            ac.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest failed, response is null!");
            JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this);
          }
          for (;;)
          {
            AppMethodBeat.o(45619);
            return 0;
            JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.FbT.dfm);
            JsApiRefreshSession.RefreshSessionTask.a(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.FbT.dfn);
            if (JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this) == 0)
            {
              JsApiRefreshSession.RefreshSessionTask.d(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.Fcj);
              JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.FbT.dfm);
              JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 1);
              JsApiRefreshSession.RefreshSessionTask.d(JsApiRefreshSession.RefreshSessionTask.this);
            }
            else
            {
              JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.FbT.dfm);
              JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 2);
              ac.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest ERROR %s", new Object[] { paramAnonymousString });
              JsApiRefreshSession.RefreshSessionTask.e(JsApiRefreshSession.RefreshSessionTask.this);
            }
          }
        }
      }, true);
      AppMethodBeat.o(45622);
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(45623);
      HashMap localHashMap = new HashMap();
      switch (this.jZE)
      {
      default: 
        if (!bs.isNullOrNil(this.errorMsg)) {
          break;
        }
      }
      for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.errorMsg }))
      {
        localHashMap.put("errCode", "-1");
        this.jYG.h(this.jOT, this.jOU.k(str, localHashMap));
        for (;;)
        {
          bek();
          AppMethodBeat.o(45623);
          return;
          localHashMap.put("expireIn", this.jZC);
          localHashMap.put("errCode", this.jZD);
          this.jYG.h(this.jOT, this.jOU.k("ok", localHashMap));
        }
        if (bs.isNullOrNil(this.errorMsg)) {}
        for (str = "fail";; str = String.format("fail:%s", new Object[] { this.errorMsg }))
        {
          localHashMap.put("errCode", this.jZD);
          this.jYG.h(this.jOT, this.jOU.k(str, localHashMap));
          break;
        }
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45624);
      this.jZC = paramParcel.readInt();
      this.jZD = paramParcel.readInt();
      this.jZE = paramParcel.readInt();
      this.jOT = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.hxM = paramParcel.readInt();
      this.jZF = paramParcel.readInt();
      this.errorMsg = paramParcel.readString();
      AppMethodBeat.o(45624);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45625);
      paramParcel.writeInt(this.jZC);
      paramParcel.writeInt(this.jZD);
      paramParcel.writeInt(this.jZE);
      paramParcel.writeInt(this.jOT);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.hxM);
      paramParcel.writeInt(this.jZF);
      paramParcel.writeString(this.errorMsg);
      AppMethodBeat.o(45625);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiRefreshSession
 * JD-Core Version:    0.7.0.1
 */