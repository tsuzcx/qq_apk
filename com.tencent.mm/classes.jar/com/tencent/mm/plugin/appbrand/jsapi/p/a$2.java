package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Log;

final class a$2
  implements com.tencent.mm.plugin.appbrand.q.a.a
{
  a$2(a parama, String paramString1, k paramk, String paramString2) {}
  
  public final void b(WxaPkgLoadProgress paramWxaPkgLoadProgress)
  {
    AppMethodBeat.i(325618);
    Log.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: module name: %s progress: %s", new Object[] { this.val$moduleName, paramWxaPkgLoadProgress.toString() });
    a.a.a(this.erJ, this.ruW, "progressUpdate", this.val$moduleName, paramWxaPkgLoadProgress.progress, paramWxaPkgLoadProgress.qHf, paramWxaPkgLoadProgress.qHg);
    AppMethodBeat.o(325618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.a.2
 * JD-Core Version:    0.7.0.1
 */