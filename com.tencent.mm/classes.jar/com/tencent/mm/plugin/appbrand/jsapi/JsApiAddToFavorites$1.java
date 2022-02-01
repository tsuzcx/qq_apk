package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.menu.r;
import com.tencent.mm.plugin.appbrand.menu.s;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.utils.c.a;
import com.tencent.mm.sdk.platformtools.ae;

final class JsApiAddToFavorites$1
  implements c.a
{
  JsApiAddToFavorites$1(JsApiAddToFavorites paramJsApiAddToFavorites, ad paramad, String paramString1, String paramString2, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2) {}
  
  public final void Nr(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(222373);
    ae.i("MicroMsg.JsApiAddToFavorites", "onLoad %s", new Object[] { paramString });
    AppBrandInitConfigWC localAppBrandInitConfigWC = this.kux.getRuntime().aXx();
    int j = this.kux.getRuntime().aXw().kaX;
    JsApiAddToFavorites.IPCFavRequest localIPCFavRequest = new JsApiAddToFavorites.IPCFavRequest();
    localIPCFavRequest.username = localAppBrandInitConfigWC.username;
    localIPCFavRequest.appId = localAppBrandInitConfigWC.appId;
    localIPCFavRequest.dlk = this.val$path;
    localIPCFavRequest.iconUrl = localAppBrandInitConfigWC.iconUrl;
    localIPCFavRequest.kuD = paramString;
    localIPCFavRequest.title = this.cZw;
    localIPCFavRequest.version = localAppBrandInitConfigWC.aDD;
    localIPCFavRequest.hSZ = localAppBrandInitConfigWC.dQv;
    if ((this.kux.uS(s.lXl.ordinal()).lXh) || (this.kuy)) {
      i = 1;
    }
    localIPCFavRequest.kuE = i;
    localIPCFavRequest.kaX = j;
    localIPCFavRequest.scene = localAppBrandInitConfigWC.cmE.scene;
    localIPCFavRequest.dLl = localAppBrandInitConfigWC.cmx.dLl;
    localIPCFavRequest.subType = this.kuz;
    localIPCFavRequest.kuF = this.kuA;
    a.a(this.kux.getContext(), localIPCFavRequest, new AppBrandProxyUIProcessTask.b()
    {
      public final void a(AppBrandProxyUIProcessTask.ProcessResult paramAnonymousProcessResult)
      {
        AppMethodBeat.i(222372);
        if (!(paramAnonymousProcessResult instanceof JsApiAddToFavorites.IPCFavResult))
        {
          AppMethodBeat.o(222372);
          return;
        }
        int i = ((JsApiAddToFavorites.IPCFavResult)paramAnonymousProcessResult).ret;
        if (i == 0)
        {
          JsApiAddToFavorites.1.this.kux.h(JsApiAddToFavorites.1.this.cjS, JsApiAddToFavorites.1.this.kuB.e("ok", null));
          AppMethodBeat.o(222372);
          return;
        }
        JsApiAddToFavorites.1.this.kux.h(JsApiAddToFavorites.1.this.cjS, JsApiAddToFavorites.1.this.kuB.e(String.format("fail internal error:%d", new Object[] { Integer.valueOf(i) }), null));
        AppMethodBeat.o(222372);
      }
    });
    AppMethodBeat.o(222373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites.1
 * JD-Core Version:    0.7.0.1
 */