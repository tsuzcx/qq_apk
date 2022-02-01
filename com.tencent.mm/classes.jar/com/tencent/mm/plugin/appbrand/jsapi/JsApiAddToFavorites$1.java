package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.menu.x;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.utils.g.a;
import com.tencent.mm.sdk.platformtools.Log;

final class JsApiAddToFavorites$1
  implements g.a
{
  JsApiAddToFavorites$1(JsApiAddToFavorites paramJsApiAddToFavorites, ah paramah, String paramString1, String paramString2, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2) {}
  
  public final void onLoad(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(325611);
    Log.i("MicroMsg.JsApiAddToFavorites", "onLoad %s", new Object[] { paramString });
    AppBrandInitConfigWC localAppBrandInitConfigWC = this.rxl.getRuntime().getInitConfig();
    int j = this.rxl.getRuntime().ccM().nOX;
    JsApiAddToFavorites.IPCFavRequest localIPCFavRequest = new JsApiAddToFavorites.IPCFavRequest();
    localIPCFavRequest.username = localAppBrandInitConfigWC.username;
    localIPCFavRequest.appId = localAppBrandInitConfigWC.appId;
    localIPCFavRequest.hzy = this.val$path;
    localIPCFavRequest.iconUrl = localAppBrandInitConfigWC.iconUrl;
    localIPCFavRequest.rxr = paramString;
    localIPCFavRequest.title = this.eSG;
    localIPCFavRequest.version = localAppBrandInitConfigWC.appVersion;
    localIPCFavRequest.euz = localAppBrandInitConfigWC.eul;
    if ((this.rxl.CF(x.tkk.ordinal()).disable) || (this.rxm)) {
      i = 1;
    }
    localIPCFavRequest.rxs = i;
    localIPCFavRequest.nOX = j;
    localIPCFavRequest.scene = localAppBrandInitConfigWC.epn.scene;
    localIPCFavRequest.idf = localAppBrandInitConfigWC.eoV.idf;
    localIPCFavRequest.subType = this.rxn;
    localIPCFavRequest.rxt = this.rxo;
    a.a(this.rxl.getContext(), localIPCFavRequest, new AppBrandProxyUIProcessTask.b()
    {
      public final void onReceiveResult(AppBrandProxyUIProcessTask.ProcessResult paramAnonymousProcessResult)
      {
        AppMethodBeat.i(325800);
        if (!(paramAnonymousProcessResult instanceof JsApiAddToFavorites.IPCFavResult))
        {
          AppMethodBeat.o(325800);
          return;
        }
        int i = ((JsApiAddToFavorites.IPCFavResult)paramAnonymousProcessResult).ret;
        if (i == 0)
        {
          JsApiAddToFavorites.1.this.rxl.callback(JsApiAddToFavorites.1.this.elZ, JsApiAddToFavorites.1.this.rxp.ZP("ok"));
          AppMethodBeat.o(325800);
          return;
        }
        JsApiAddToFavorites.1.this.rxl.callback(JsApiAddToFavorites.1.this.elZ, JsApiAddToFavorites.1.this.rxp.ZP(String.format("fail internal error:%d", new Object[] { Integer.valueOf(i) })));
        AppMethodBeat.o(325800);
      }
    });
    AppMethodBeat.o(325611);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites.1
 * JD-Core Version:    0.7.0.1
 */