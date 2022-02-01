package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.ddh;
import com.tencent.mm.protocal.protobuf.dei;
import com.tencent.mm.protocal.protobuf.dej;
import com.tencent.mm.protocal.protobuf.glg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiRefreshSession
  extends c
{
  private static final int CTRL_INDEX = 118;
  private static final String NAME = "refreshSession";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45631);
    paramJSONObject = new RefreshSessionTask();
    Object localObject = (n)paramf.aN(n.class);
    if (localObject != null) {
      RefreshSessionTask.a(paramJSONObject, ((n)localObject).qYY.qHO);
    }
    localObject = paramf.getAppId();
    paramJSONObject.ros = this;
    paramJSONObject.rzi = paramf;
    paramJSONObject.ror = paramInt;
    paramJSONObject.appId = ((String)localObject);
    paramf = d.Ue((String)localObject);
    if (paramf != null) {
      paramJSONObject.rAv = paramf.scene;
    }
    paramJSONObject.bQt();
    AppMethodBeat.o(45631);
  }
  
  public static class RefreshSessionTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<RefreshSessionTask> CREATOR;
    String appId;
    private String errorMsg;
    private int euz;
    private int rAs;
    private int rAt;
    private int rAu;
    int rAv;
    int ror;
    p ros;
    f rzi;
    
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
      h(paramParcel);
      AppMethodBeat.o(45621);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(45622);
      c.a locala = new c.a();
      locala.otE = new dei();
      locala.otF = new dej();
      locala.uri = "/cgi-bin/mmbiz-bin/js-refreshsession";
      locala.funcId = 1196;
      locala.otG = 0;
      locala.respCmdId = 0;
      dei localdei = new dei();
      localdei.oOI = this.appId;
      localdei.aaJu = this.euz;
      locala.otE = localdei;
      if (this.rAv > 0)
      {
        localdei.aaJv = new glg();
        localdei.aaJv.scene = this.rAv;
      }
      Log.i("MicroMsg.JsApiRefreshSession", "refreshSession appId %s, versionType, statScene %d", new Object[] { this.appId, Integer.valueOf(this.euz), Integer.valueOf(this.rAv) });
      z.a(locala.bEF(), new z.a()
      {
        public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(45619);
          Log.d("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 0);
            JsApiRefreshSession.RefreshSessionTask.a(JsApiRefreshSession.RefreshSessionTask.this, "cgi fail");
            JsApiRefreshSession.RefreshSessionTask.a(JsApiRefreshSession.RefreshSessionTask.this);
            AppMethodBeat.o(45619);
            return 0;
          }
          paramAnonymousc = (dej)c.c.b(paramAnonymousc.otC);
          if ((paramAnonymousc == null) || (paramAnonymousc.aaJx == null))
          {
            JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 0);
            Log.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest failed, response is null!");
            JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this);
          }
          for (;;)
          {
            AppMethodBeat.o(45619);
            return 0;
            JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousc.aaJx.hGE);
            JsApiRefreshSession.RefreshSessionTask.a(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousc.aaJx.errmsg);
            if (JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this) == 0)
            {
              JsApiRefreshSession.RefreshSessionTask.d(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousc.aaJS);
              JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousc.aaJx.hGE);
              JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 1);
              JsApiRefreshSession.RefreshSessionTask.d(JsApiRefreshSession.RefreshSessionTask.this);
            }
            else
            {
              JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousc.aaJx.hGE);
              JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 2);
              Log.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest ERROR %s", new Object[] { paramAnonymousString });
              JsApiRefreshSession.RefreshSessionTask.e(JsApiRefreshSession.RefreshSessionTask.this);
            }
          }
        }
      }, true);
      AppMethodBeat.o(45622);
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(45623);
      HashMap localHashMap = new HashMap();
      switch (this.rAu)
      {
      default: 
        if (!Util.isNullOrNil(this.errorMsg)) {
          break;
        }
      }
      for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.errorMsg }))
      {
        localHashMap.put("errCode", "-1");
        this.rzi.callback(this.ror, this.ros.m(str, localHashMap));
        for (;;)
        {
          cpx();
          AppMethodBeat.o(45623);
          return;
          localHashMap.put("expireIn", this.rAs);
          localHashMap.put("errCode", this.rAt);
          this.rzi.callback(this.ror, this.ros.m("ok", localHashMap));
        }
        if (Util.isNullOrNil(this.errorMsg)) {}
        for (str = "fail";; str = String.format("fail:%s", new Object[] { this.errorMsg }))
        {
          localHashMap.put("errCode", this.rAt);
          this.rzi.callback(this.ror, this.ros.m(str, localHashMap));
          break;
        }
      }
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(45624);
      this.rAs = paramParcel.readInt();
      this.rAt = paramParcel.readInt();
      this.rAu = paramParcel.readInt();
      this.ror = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.euz = paramParcel.readInt();
      this.rAv = paramParcel.readInt();
      this.errorMsg = paramParcel.readString();
      AppMethodBeat.o(45624);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45625);
      paramParcel.writeInt(this.rAs);
      paramParcel.writeInt(this.rAt);
      paramParcel.writeInt(this.rAu);
      paramParcel.writeInt(this.ror);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.euz);
      paramParcel.writeInt(this.rAv);
      paramParcel.writeString(this.errorMsg);
      AppMethodBeat.o(45625);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiRefreshSession
 * JD-Core Version:    0.7.0.1
 */