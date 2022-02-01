package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.ad.e;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.protocal.protobuf.brf;
import com.tencent.mm.protocal.protobuf.bsb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;

final class j$1
  implements IPCRunCgi.a
{
  j$1(j paramj, d paramd, int paramInt) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb)
  {
    AppMethodBeat.i(222404);
    if ((!this.kww.aXO()) && (!this.kww.isRunning()))
    {
      ae.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi callback, callbackId:%s, service not running or preloaded", new Object[] { Integer.valueOf(this.cjS) });
      AppMethodBeat.o(222404);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0) || (!(paramb.hQE.hQJ instanceof bsb)))
    {
      ae.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi fail, errType:%s, errCode:%s, errMsg:%s, response:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramb.hQE.hQJ });
      this.kww.h(this.cjS, this.kBu.e("fail invalid response", null));
      AppMethodBeat.o(222404);
      return;
    }
    paramb = (bsb)paramb.hQE.hQJ;
    if (paramb.HeT.drN == 0)
    {
      paramString = paramb.nIq.fjO();
      if (bu.isNullOrNil(paramString))
      {
        ae.e("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi success, data is null");
        this.kww.h(this.cjS, this.kBu.e("fail invalid response", null));
        AppMethodBeat.o(222404);
        return;
      }
      e.N(this.kww.getAppId(), System.currentTimeMillis());
      ae.i("MicroMsg.AppBrand.JsApiAdOperateWXData[AppBrandSplashAd]", "cgi success, callbackId:%s, callback data:%s", new Object[] { Integer.valueOf(this.cjS), paramb.nIq });
      paramb = new HashMap();
      paramb.put("data", paramString);
      this.kww.h(this.cjS, this.kBu.n("ok", paramb));
      AppMethodBeat.o(222404);
      return;
    }
    this.kww.h(this.cjS, this.kBu.e("fail:errorCode:" + paramb.HeT.drN + ",errorMsg:" + paramb.HeT.drO, null));
    AppMethodBeat.o(222404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.j.1
 * JD-Core Version:    0.7.0.1
 */