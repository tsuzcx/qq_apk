package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.cmt;
import com.tencent.mm.protocal.protobuf.cnq;
import com.tencent.mm.protocal.protobuf.cnr;
import com.tencent.mm.protocal.protobuf.foh;
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
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45631);
    paramJSONObject = new RefreshSessionTask();
    Object localObject = (l)parame.au(l.class);
    if (localObject != null) {
      RefreshSessionTask.a(paramJSONObject, ((l)localObject).nYR.nHY);
    }
    localObject = parame.getAppId();
    paramJSONObject.okP = this;
    paramJSONObject.ovO = parame;
    paramJSONObject.okO = paramInt;
    paramJSONObject.appId = ((String)localObject);
    parame = com.tencent.mm.plugin.appbrand.d.abC((String)localObject);
    if (parame != null) {
      paramJSONObject.owU = parame.scene;
    }
    paramJSONObject.bsM();
    AppMethodBeat.o(45631);
  }
  
  public static class RefreshSessionTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<RefreshSessionTask> CREATOR;
    String appId;
    private int cBU;
    private String errorMsg;
    int okO;
    o okP;
    e ovO;
    private int owR;
    private int owS;
    private int owT;
    int owU;
    
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
      f(paramParcel);
      AppMethodBeat.o(45621);
    }
    
    public final void RW()
    {
      AppMethodBeat.i(45622);
      d.a locala = new d.a();
      locala.lBU = new cnq();
      locala.lBV = new cnr();
      locala.uri = "/cgi-bin/mmbiz-bin/js-refreshsession";
      locala.funcId = 1196;
      locala.lBW = 0;
      locala.respCmdId = 0;
      cnq localcnq = new cnq();
      localcnq.lVG = this.appId;
      localcnq.TuP = this.cBU;
      locala.lBU = localcnq;
      if (this.owU > 0)
      {
        localcnq.TuQ = new foh();
        localcnq.TuQ.scene = this.owU;
      }
      Log.i("MicroMsg.JsApiRefreshSession", "refreshSession appId %s, versionType, statScene %d", new Object[] { this.appId, Integer.valueOf(this.cBU), Integer.valueOf(this.owU) });
      aa.a(locala.bgN(), new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, q paramAnonymousq)
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
          paramAnonymousd = (cnr)d.c.b(paramAnonymousd.lBS);
          if ((paramAnonymousd == null) || (paramAnonymousd.TuR == null))
          {
            JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 0);
            Log.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest failed, response is null!");
            JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this);
          }
          for (;;)
          {
            AppMethodBeat.o(45619);
            return 0;
            JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousd.TuR.fBP);
            JsApiRefreshSession.RefreshSessionTask.a(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousd.TuR.errmsg);
            if (JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this) == 0)
            {
              JsApiRefreshSession.RefreshSessionTask.d(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousd.Tvm);
              JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousd.TuR.fBP);
              JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 1);
              JsApiRefreshSession.RefreshSessionTask.d(JsApiRefreshSession.RefreshSessionTask.this);
            }
            else
            {
              JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousd.TuR.fBP);
              JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 2);
              Log.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest ERROR %s", new Object[] { paramAnonymousString });
              JsApiRefreshSession.RefreshSessionTask.e(JsApiRefreshSession.RefreshSessionTask.this);
            }
          }
        }
      }, true);
      AppMethodBeat.o(45622);
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(45623);
      HashMap localHashMap = new HashMap();
      switch (this.owT)
      {
      default: 
        if (!Util.isNullOrNil(this.errorMsg)) {
          break;
        }
      }
      for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.errorMsg }))
      {
        localHashMap.put("errCode", "-1");
        this.ovO.j(this.okO, this.okP.m(str, localHashMap));
        for (;;)
        {
          bPk();
          AppMethodBeat.o(45623);
          return;
          localHashMap.put("expireIn", this.owR);
          localHashMap.put("errCode", this.owS);
          this.ovO.j(this.okO, this.okP.m("ok", localHashMap));
        }
        if (Util.isNullOrNil(this.errorMsg)) {}
        for (str = "fail";; str = String.format("fail:%s", new Object[] { this.errorMsg }))
        {
          localHashMap.put("errCode", this.owS);
          this.ovO.j(this.okO, this.okP.m(str, localHashMap));
          break;
        }
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(45624);
      this.owR = paramParcel.readInt();
      this.owS = paramParcel.readInt();
      this.owT = paramParcel.readInt();
      this.okO = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.cBU = paramParcel.readInt();
      this.owU = paramParcel.readInt();
      this.errorMsg = paramParcel.readString();
      AppMethodBeat.o(45624);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45625);
      paramParcel.writeInt(this.owR);
      paramParcel.writeInt(this.owS);
      paramParcel.writeInt(this.owT);
      paramParcel.writeInt(this.okO);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.cBU);
      paramParcel.writeInt(this.owU);
      paramParcel.writeString(this.errorMsg);
      AppMethodBeat.o(45625);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiRefreshSession
 * JD-Core Version:    0.7.0.1
 */