package com.tencent.mm.plugin.appbrand.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.d;
import com.tencent.mm.plugin.appbrand.n.g;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.stubs.logger.Log;
import java.net.URL;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/service/WXNativeInjector;", "", "()V", "TAG", "", "WX_NATIVE_JS", "getWXNativeJSScript", "injectWxNativeForContext", "", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "context", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "isWxNativeEnabled", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
{
  public static final ac tUj;
  
  static
  {
    AppMethodBeat.i(51061);
    tUj = new ac();
    AppMethodBeat.o(51061);
  }
  
  public static final void a(c paramc, g paramg)
  {
    AppMethodBeat.i(321530);
    s.u(paramc, "<this>");
    s.u(paramg, "context");
    if (!h(paramc))
    {
      AppMethodBeat.o(321530);
      return;
    }
    Log.i("MicroMsg.AppBrand.WXNativeInjector", "evaluate wxNative.js start. appId:" + paramc.getAppId() + ", contextId:" + paramg.czh());
    long l = Util.currentTicks();
    paramg.a(new URL(s.X("https://lib/", "wxNative.js")), s.X(d.ags("wxNative.js"), "\n;(function() { return injectNativateRet; })()"), new ac..ExternalSyntheticLambda0(paramc, paramg, l));
    AppMethodBeat.o(321530);
  }
  
  private static final void a(c paramc, g paramg, long paramLong, String paramString)
  {
    AppMethodBeat.i(321538);
    s.u(paramc, "$this_injectWxNativeForContext");
    s.u(paramg, "$context");
    if (s.p("ok", paramString)) {}
    for (int i = 4;; i = 6)
    {
      Log.println(i, "MicroMsg.AppBrand.WXNativeInjector", "evaluate wxNative.js end. appId:" + paramc.getAppId() + ", contextId:" + paramg.czh() + ", result:'" + paramString + "', cost:" + (Util.currentTicks() - paramLong) + "ms");
      AppMethodBeat.o(321538);
      return;
    }
  }
  
  public static final boolean h(c paramc)
  {
    AppMethodBeat.i(321533);
    s.u(paramc, "<this>");
    if ((paramc.getRuntime().ccB()) || (BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED))
    {
      AppMethodBeat.o(321533);
      return true;
    }
    AppMethodBeat.o(321533);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.ac
 * JD-Core Version:    0.7.0.1
 */