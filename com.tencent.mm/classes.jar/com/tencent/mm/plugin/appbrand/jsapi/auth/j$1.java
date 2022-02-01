package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.protocal.protobuf.bql;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;

final class j$1
  implements IPCRunCgi.a
{
  j$1(j paramj, com.tencent.mm.plugin.appbrand.d paramd, int paramInt) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb)
  {
    AppMethodBeat.i(188278);
    if ((!this.ktg.aXt()) && (!this.ktg.isRunning()))
    {
      ad.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi callback, callbackId:%s, service not running or preloaded", new Object[] { Integer.valueOf(this.cjQ) });
      AppMethodBeat.o(188278);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0) || (!(paramb.hNL.hNQ instanceof brh)))
    {
      ad.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi fail, errType:%s, errCode:%s, errMsg:%s, response:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramb.hNL.hNQ });
      this.ktg.h(this.cjQ, this.kyf.e("fail invalid response", null));
      AppMethodBeat.o(188278);
      return;
    }
    paramb = (brh)paramb.hNL.hNQ;
    if (paramb.GLs.dqI == 0)
    {
      paramString = paramb.nCV.ffY();
      if (bt.isNullOrNil(paramString))
      {
        ad.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi success, data is null");
        this.ktg.h(this.cjQ, this.kyf.e("fail invalid response", null));
        AppMethodBeat.o(188278);
        return;
      }
      com.tencent.mm.plugin.appbrand.ad.d.N(this.ktg.getAppId(), System.currentTimeMillis());
      ad.i("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi success, callbackId:%s, callback data:%s", new Object[] { Integer.valueOf(this.cjQ), paramb.nCV });
      paramb = new HashMap();
      paramb.put("data", paramString);
      this.ktg.h(this.cjQ, this.kyf.m("ok", paramb));
      AppMethodBeat.o(188278);
      return;
    }
    this.ktg.h(this.cjQ, this.kyf.e("fail:errorCode:" + paramb.GLs.dqI + ",errorMsg:" + paramb.GLs.dqJ, null));
    AppMethodBeat.o(188278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.j.1
 * JD-Core Version:    0.7.0.1
 */