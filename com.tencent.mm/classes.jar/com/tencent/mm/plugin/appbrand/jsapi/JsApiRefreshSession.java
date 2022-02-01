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
import com.tencent.mm.protocal.protobuf.bij;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.protocal.protobuf.bjh;
import com.tencent.mm.protocal.protobuf.dvc;
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
      RefreshSessionTask.a(paramJSONObject, ((k)localObject).jdS.iOQ);
    }
    localObject = paramc.getAppId();
    paramJSONObject.joI = this;
    paramJSONObject.jyl = paramc;
    paramJSONObject.joH = paramInt;
    paramJSONObject.appId = ((String)localObject);
    paramc = com.tencent.mm.plugin.appbrand.a.CT((String)localObject);
    if (paramc != null) {
      paramJSONObject.jzi = paramc.scene;
    }
    paramJSONObject.aXm();
    AppBrandMainProcessService.a(paramJSONObject);
    AppMethodBeat.o(45631);
  }
  
  public static class RefreshSessionTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<RefreshSessionTask> CREATOR;
    String appId;
    private String errorMsg;
    private int gXn;
    int joH;
    m joI;
    c jyl;
    private int jzf;
    private int jzg;
    private int jzh;
    int jzi;
    
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
    
    public final void aEA()
    {
      AppMethodBeat.i(45623);
      HashMap localHashMap = new HashMap();
      switch (this.jzh)
      {
      default: 
        if (!bt.isNullOrNil(this.errorMsg)) {
          break;
        }
      }
      for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.errorMsg }))
      {
        localHashMap.put("errCode", "-1");
        this.jyl.h(this.joH, this.joI.k(str, localHashMap));
        for (;;)
        {
          aXn();
          AppMethodBeat.o(45623);
          return;
          localHashMap.put("expireIn", this.jzf);
          localHashMap.put("errCode", this.jzg);
          this.jyl.h(this.joH, this.joI.k("ok", localHashMap));
        }
        if (bt.isNullOrNil(this.errorMsg)) {}
        for (str = "fail";; str = String.format("fail:%s", new Object[] { this.errorMsg }))
        {
          localHashMap.put("errCode", this.jzg);
          this.jyl.h(this.joH, this.joI.k(str, localHashMap));
          break;
        }
      }
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(45622);
      aXm();
      b.a locala = new b.a();
      locala.gUU = new bjg();
      locala.gUV = new bjh();
      locala.uri = "/cgi-bin/mmbiz-bin/js-refreshsession";
      locala.funcId = 1196;
      locala.reqCmdId = 0;
      locala.respCmdId = 0;
      bjg localbjg = new bjg();
      localbjg.hnC = this.appId;
      localbjg.DGx = this.gXn;
      locala.gUU = localbjg;
      if (this.jzi > 0)
      {
        localbjg.DGy = new dvc();
        localbjg.DGy.scene = this.jzi;
      }
      ad.i("MicroMsg.JsApiRefreshSession", "refreshSession appId %s, versionType, statScene %d", new Object[] { this.appId, Integer.valueOf(this.gXn), Integer.valueOf(this.jzi) });
      x.a(locala.atI(), new x.a()
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
          paramAnonymousb = (bjh)paramAnonymousb.gUT.gUX;
          if ((paramAnonymousb == null) || (paramAnonymousb.DGz == null))
          {
            JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 0);
            ad.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest failed, response is null!");
            JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this);
          }
          for (;;)
          {
            AppMethodBeat.o(45619);
            return 0;
            JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.DGz.dhR);
            JsApiRefreshSession.RefreshSessionTask.a(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.DGz.dhS);
            if (JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this) == 0)
            {
              JsApiRefreshSession.RefreshSessionTask.d(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.DGP);
              JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.DGz.dhR);
              JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 1);
              JsApiRefreshSession.RefreshSessionTask.d(JsApiRefreshSession.RefreshSessionTask.this);
            }
            else
            {
              JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.DGz.dhR);
              JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 2);
              ad.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest ERROR %s", new Object[] { paramAnonymousString });
              JsApiRefreshSession.RefreshSessionTask.e(JsApiRefreshSession.RefreshSessionTask.this);
            }
          }
        }
      }, true);
      AppMethodBeat.o(45622);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45624);
      this.jzf = paramParcel.readInt();
      this.jzg = paramParcel.readInt();
      this.jzh = paramParcel.readInt();
      this.joH = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.gXn = paramParcel.readInt();
      this.jzi = paramParcel.readInt();
      this.errorMsg = paramParcel.readString();
      AppMethodBeat.o(45624);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45625);
      paramParcel.writeInt(this.jzf);
      paramParcel.writeInt(this.jzg);
      paramParcel.writeInt(this.jzh);
      paramParcel.writeInt(this.joH);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.gXn);
      paramParcel.writeInt(this.jzi);
      paramParcel.writeString(this.errorMsg);
      AppMethodBeat.o(45625);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiRefreshSession
 * JD-Core Version:    0.7.0.1
 */