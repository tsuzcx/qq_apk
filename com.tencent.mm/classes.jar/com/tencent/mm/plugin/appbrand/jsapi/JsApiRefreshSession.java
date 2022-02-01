package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.cdz;
import com.tencent.mm.protocal.protobuf.cew;
import com.tencent.mm.protocal.protobuf.cex;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiRefreshSession
  extends d
{
  private static final int CTRL_INDEX = 118;
  private static final String NAME = "refreshSession";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45631);
    paramJSONObject = new RefreshSessionTask();
    Object localObject = (l)paramf.av(l.class);
    if (localObject != null) {
      RefreshSessionTask.a(paramJSONObject, ((l)localObject).leE.kNW);
    }
    localObject = paramf.getAppId();
    paramJSONObject.lqf = this;
    paramJSONObject.lAx = paramf;
    paramJSONObject.lqe = paramInt;
    paramJSONObject.appId = ((String)localObject);
    paramf = a.TS((String)localObject);
    if (paramf != null) {
      paramJSONObject.lBE = paramf.scene;
    }
    paramJSONObject.bDJ();
    AppBrandMainProcessService.a(paramJSONObject);
    AppMethodBeat.o(45631);
  }
  
  public static class RefreshSessionTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<RefreshSessionTask> CREATOR;
    String appId;
    private String errorMsg;
    private int iOo;
    f lAx;
    private int lBB;
    private int lBC;
    private int lBD;
    int lBE;
    int lqe;
    p lqf;
    
    static
    {
      AppMethodBeat.i(45630);
      CREATOR = new JsApiRefreshSession.RefreshSessionTask.2();
      AppMethodBeat.o(45630);
    }
    
    public RefreshSessionTask() {}
    
    public RefreshSessionTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45621);
      f(paramParcel);
      AppMethodBeat.o(45621);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(45622);
      bDJ();
      d.a locala = new d.a();
      locala.iLN = new cew();
      locala.iLO = new cex();
      locala.uri = "/cgi-bin/mmbiz-bin/js-refreshsession";
      locala.funcId = 1196;
      locala.iLP = 0;
      locala.respCmdId = 0;
      cew localcew = new cew();
      localcew.jfi = this.appId;
      localcew.MjZ = this.iOo;
      locala.iLN = localcew;
      if (this.lBE > 0)
      {
        localcew.Mka = new fdg();
        localcew.Mka.scene = this.lBE;
      }
      Log.i("MicroMsg.JsApiRefreshSession", "refreshSession appId %s, versionType, statScene %d", new Object[] { this.appId, Integer.valueOf(this.iOo), Integer.valueOf(this.lBE) });
      aa.a(locala.aXF(), new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
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
          paramAnonymousd = (cex)paramAnonymousd.iLL.iLR;
          if ((paramAnonymousd == null) || (paramAnonymousd.Mkb == null))
          {
            JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 0);
            Log.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest failed, response is null!");
            JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this);
          }
          for (;;)
          {
            AppMethodBeat.o(45619);
            return 0;
            JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousd.Mkb.dIZ);
            JsApiRefreshSession.RefreshSessionTask.a(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousd.Mkb.dJa);
            if (JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this) == 0)
            {
              JsApiRefreshSession.RefreshSessionTask.d(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousd.Mku);
              JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousd.Mkb.dIZ);
              JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 1);
              JsApiRefreshSession.RefreshSessionTask.d(JsApiRefreshSession.RefreshSessionTask.this);
            }
            else
            {
              JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousd.Mkb.dIZ);
              JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 2);
              Log.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest ERROR %s", new Object[] { paramAnonymousString });
              JsApiRefreshSession.RefreshSessionTask.e(JsApiRefreshSession.RefreshSessionTask.this);
            }
          }
        }
      }, true);
      AppMethodBeat.o(45622);
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(45623);
      HashMap localHashMap = new HashMap();
      switch (this.lBD)
      {
      default: 
        if (!Util.isNullOrNil(this.errorMsg)) {
          break;
        }
      }
      for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.errorMsg }))
      {
        localHashMap.put("errCode", "-1");
        this.lAx.i(this.lqe, this.lqf.n(str, localHashMap));
        for (;;)
        {
          bDK();
          AppMethodBeat.o(45623);
          return;
          localHashMap.put("expireIn", this.lBB);
          localHashMap.put("errCode", this.lBC);
          this.lAx.i(this.lqe, this.lqf.n("ok", localHashMap));
        }
        if (Util.isNullOrNil(this.errorMsg)) {}
        for (str = "fail";; str = String.format("fail:%s", new Object[] { this.errorMsg }))
        {
          localHashMap.put("errCode", this.lBC);
          this.lAx.i(this.lqe, this.lqf.n(str, localHashMap));
          break;
        }
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(45624);
      this.lBB = paramParcel.readInt();
      this.lBC = paramParcel.readInt();
      this.lBD = paramParcel.readInt();
      this.lqe = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.iOo = paramParcel.readInt();
      this.lBE = paramParcel.readInt();
      this.errorMsg = paramParcel.readString();
      AppMethodBeat.o(45624);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45625);
      paramParcel.writeInt(this.lBB);
      paramParcel.writeInt(this.lBC);
      paramParcel.writeInt(this.lBD);
      paramParcel.writeInt(this.lqe);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.iOo);
      paramParcel.writeInt(this.lBE);
      paramParcel.writeString(this.errorMsg);
      AppMethodBeat.o(45625);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiRefreshSession
 * JD-Core Version:    0.7.0.1
 */