package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.bql;
import com.tencent.mm.protocal.protobuf.bri;
import com.tencent.mm.protocal.protobuf.brj;
import com.tencent.mm.protocal.protobuf.egx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
      RefreshSessionTask.a(paramJSONObject, ((k)localObject).jYh.jIU);
    }
    localObject = paramc.getAppId();
    paramJSONObject.kjf = this;
    paramJSONObject.ktc = paramc;
    paramJSONObject.kje = paramInt;
    paramJSONObject.appId = ((String)localObject);
    paramc = com.tencent.mm.plugin.appbrand.a.Kl((String)localObject);
    if (paramc != null) {
      paramJSONObject.kub = paramc.scene;
    }
    paramJSONObject.bhN();
    AppBrandMainProcessService.a(paramJSONObject);
    AppMethodBeat.o(45631);
  }
  
  public static class RefreshSessionTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<RefreshSessionTask> CREATOR;
    String appId;
    private String errorMsg;
    private int hQh;
    int kje;
    m kjf;
    private int ktY;
    private int ktZ;
    c ktc;
    private int kua;
    int kub;
    
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
    
    public final void aOA()
    {
      AppMethodBeat.i(45622);
      bhN();
      b.a locala = new b.a();
      locala.hNM = new bri();
      locala.hNN = new brj();
      locala.uri = "/cgi-bin/mmbiz-bin/js-refreshsession";
      locala.funcId = 1196;
      locala.hNO = 0;
      locala.respCmdId = 0;
      bri localbri = new bri();
      localbri.iht = this.appId;
      localbri.GLq = this.hQh;
      locala.hNM = localbri;
      if (this.kub > 0)
      {
        localbri.GLr = new egx();
        localbri.GLr.scene = this.kub;
      }
      ad.i("MicroMsg.JsApiRefreshSession", "refreshSession appId %s, versionType, statScene %d", new Object[] { this.appId, Integer.valueOf(this.hQh), Integer.valueOf(this.kub) });
      x.a(locala.aDC(), new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(45619);
          ad.d("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 0);
            JsApiRefreshSession.RefreshSessionTask.a(JsApiRefreshSession.RefreshSessionTask.this, "cgi fail");
            JsApiRefreshSession.RefreshSessionTask.a(JsApiRefreshSession.RefreshSessionTask.this);
            AppMethodBeat.o(45619);
            return 0;
          }
          paramAnonymousb = (brj)paramAnonymousb.hNL.hNQ;
          if ((paramAnonymousb == null) || (paramAnonymousb.GLs == null))
          {
            JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 0);
            ad.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest failed, response is null!");
            JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this);
          }
          for (;;)
          {
            AppMethodBeat.o(45619);
            return 0;
            JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.GLs.dqI);
            JsApiRefreshSession.RefreshSessionTask.a(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.GLs.dqJ);
            if (JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this) == 0)
            {
              JsApiRefreshSession.RefreshSessionTask.d(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.GLJ);
              JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.GLs.dqI);
              JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 1);
              JsApiRefreshSession.RefreshSessionTask.d(JsApiRefreshSession.RefreshSessionTask.this);
            }
            else
            {
              JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.GLs.dqI);
              JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 2);
              ad.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest ERROR %s", new Object[] { paramAnonymousString });
              JsApiRefreshSession.RefreshSessionTask.e(JsApiRefreshSession.RefreshSessionTask.this);
            }
          }
        }
      }, true);
      AppMethodBeat.o(45622);
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(45623);
      HashMap localHashMap = new HashMap();
      switch (this.kua)
      {
      default: 
        if (!bt.isNullOrNil(this.errorMsg)) {
          break;
        }
      }
      for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.errorMsg }))
      {
        localHashMap.put("errCode", "-1");
        this.ktc.h(this.kje, this.kjf.m(str, localHashMap));
        for (;;)
        {
          bhO();
          AppMethodBeat.o(45623);
          return;
          localHashMap.put("expireIn", this.ktY);
          localHashMap.put("errCode", this.ktZ);
          this.ktc.h(this.kje, this.kjf.m("ok", localHashMap));
        }
        if (bt.isNullOrNil(this.errorMsg)) {}
        for (str = "fail";; str = String.format("fail:%s", new Object[] { this.errorMsg }))
        {
          localHashMap.put("errCode", this.ktZ);
          this.ktc.h(this.kje, this.kjf.m(str, localHashMap));
          break;
        }
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45624);
      this.ktY = paramParcel.readInt();
      this.ktZ = paramParcel.readInt();
      this.kua = paramParcel.readInt();
      this.kje = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.hQh = paramParcel.readInt();
      this.kub = paramParcel.readInt();
      this.errorMsg = paramParcel.readString();
      AppMethodBeat.o(45624);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45625);
      paramParcel.writeInt(this.ktY);
      paramParcel.writeInt(this.ktZ);
      paramParcel.writeInt(this.kua);
      paramParcel.writeInt(this.kje);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.hQh);
      paramParcel.writeInt(this.kub);
      paramParcel.writeString(this.errorMsg);
      AppMethodBeat.o(45625);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiRefreshSession
 * JD-Core Version:    0.7.0.1
 */