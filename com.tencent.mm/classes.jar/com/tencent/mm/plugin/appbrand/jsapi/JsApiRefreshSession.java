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
import com.tencent.mm.protocal.protobuf.brf;
import com.tencent.mm.protocal.protobuf.bsc;
import com.tencent.mm.protocal.protobuf.bsd;
import com.tencent.mm.protocal.protobuf.eio;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
      RefreshSessionTask.a(paramJSONObject, ((k)localObject).kbw.jLV);
    }
    localObject = paramc.getAppId();
    paramJSONObject.kmv = this;
    paramJSONObject.kws = paramc;
    paramJSONObject.kmu = paramInt;
    paramJSONObject.appId = ((String)localObject);
    paramc = com.tencent.mm.plugin.appbrand.a.KK((String)localObject);
    if (paramc != null) {
      paramJSONObject.kxr = paramc.scene;
    }
    paramJSONObject.biw();
    AppBrandMainProcessService.a(paramJSONObject);
    AppMethodBeat.o(45631);
  }
  
  public static class RefreshSessionTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<RefreshSessionTask> CREATOR;
    String appId;
    private String errorMsg;
    private int hSZ;
    int kmu;
    m kmv;
    c kws;
    private int kxo;
    private int kxp;
    private int kxq;
    int kxr;
    
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
    
    public final void aOX()
    {
      AppMethodBeat.i(45622);
      biw();
      b.a locala = new b.a();
      locala.hQF = new bsc();
      locala.hQG = new bsd();
      locala.uri = "/cgi-bin/mmbiz-bin/js-refreshsession";
      locala.funcId = 1196;
      locala.hQH = 0;
      locala.respCmdId = 0;
      bsc localbsc = new bsc();
      localbsc.ikm = this.appId;
      localbsc.HeR = this.hSZ;
      locala.hQF = localbsc;
      if (this.kxr > 0)
      {
        localbsc.HeS = new eio();
        localbsc.HeS.scene = this.kxr;
      }
      ae.i("MicroMsg.JsApiRefreshSession", "refreshSession appId %s, versionType, statScene %d", new Object[] { this.appId, Integer.valueOf(this.hSZ), Integer.valueOf(this.kxr) });
      x.a(locala.aDS(), new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(45619);
          ae.d("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 0);
            JsApiRefreshSession.RefreshSessionTask.a(JsApiRefreshSession.RefreshSessionTask.this, "cgi fail");
            JsApiRefreshSession.RefreshSessionTask.a(JsApiRefreshSession.RefreshSessionTask.this);
            AppMethodBeat.o(45619);
            return 0;
          }
          paramAnonymousb = (bsd)paramAnonymousb.hQE.hQJ;
          if ((paramAnonymousb == null) || (paramAnonymousb.HeT == null))
          {
            JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 0);
            ae.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest failed, response is null!");
            JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this);
          }
          for (;;)
          {
            AppMethodBeat.o(45619);
            return 0;
            JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.HeT.drN);
            JsApiRefreshSession.RefreshSessionTask.a(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.HeT.drO);
            if (JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this) == 0)
            {
              JsApiRefreshSession.RefreshSessionTask.d(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.Hfk);
              JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.HeT.drN);
              JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 1);
              JsApiRefreshSession.RefreshSessionTask.d(JsApiRefreshSession.RefreshSessionTask.this);
            }
            else
            {
              JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.HeT.drN);
              JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 2);
              ae.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest ERROR %s", new Object[] { paramAnonymousString });
              JsApiRefreshSession.RefreshSessionTask.e(JsApiRefreshSession.RefreshSessionTask.this);
            }
          }
        }
      }, true);
      AppMethodBeat.o(45622);
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(45623);
      HashMap localHashMap = new HashMap();
      switch (this.kxq)
      {
      default: 
        if (!bu.isNullOrNil(this.errorMsg)) {
          break;
        }
      }
      for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.errorMsg }))
      {
        localHashMap.put("errCode", "-1");
        this.kws.h(this.kmu, this.kmv.n(str, localHashMap));
        for (;;)
        {
          bix();
          AppMethodBeat.o(45623);
          return;
          localHashMap.put("expireIn", this.kxo);
          localHashMap.put("errCode", this.kxp);
          this.kws.h(this.kmu, this.kmv.n("ok", localHashMap));
        }
        if (bu.isNullOrNil(this.errorMsg)) {}
        for (str = "fail";; str = String.format("fail:%s", new Object[] { this.errorMsg }))
        {
          localHashMap.put("errCode", this.kxp);
          this.kws.h(this.kmu, this.kmv.n(str, localHashMap));
          break;
        }
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45624);
      this.kxo = paramParcel.readInt();
      this.kxp = paramParcel.readInt();
      this.kxq = paramParcel.readInt();
      this.kmu = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.hSZ = paramParcel.readInt();
      this.kxr = paramParcel.readInt();
      this.errorMsg = paramParcel.readString();
      AppMethodBeat.o(45624);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45625);
      paramParcel.writeInt(this.kxo);
      paramParcel.writeInt(this.kxp);
      paramParcel.writeInt(this.kxq);
      paramParcel.writeInt(this.kmu);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.hSZ);
      paramParcel.writeInt(this.kxr);
      paramParcel.writeString(this.errorMsg);
      AppMethodBeat.o(45625);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiRefreshSession
 * JD-Core Version:    0.7.0.1
 */