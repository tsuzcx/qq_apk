package com.tencent.mm.plugin.appbrand.service;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.m.g;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.stubs.logger.Log;
import java.net.URL;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/service/WXNativeInjector;", "", "()V", "TAG", "", "WX_NATIVE_JS", "getWXNativeJSScript", "injectWxNativeForContext", "", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "context", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "isWxNativeEnabled", "", "plugin-appbrand-integration_release"})
public final class aa
{
  public static final aa qPr;
  
  static
  {
    AppMethodBeat.i(51061);
    qPr = new aa();
    AppMethodBeat.o(51061);
  }
  
  public static final void a(c paramc, final g paramg)
  {
    AppMethodBeat.i(283069);
    p.k(paramc, "$this$injectWxNativeForContext");
    p.k(paramg, "context");
    if (!g(paramc))
    {
      AppMethodBeat.o(283069);
      return;
    }
    Log.i("MicroMsg.AppBrand.WXNativeInjector", "evaluate wxNative.js start. appId:" + paramc.getAppId() + ", contextId:" + paramg.bYT());
    final long l = Util.currentTicks();
    paramg.a(new URL(paramc.Rs() + "wxNative.js"), d.anc("wxNative.js") + "\n;(function() { return injectNativateRet; })()", (ValueCallback)new a(paramc, paramg, l));
    AppMethodBeat.o(283069);
  }
  
  public static final boolean g(c paramc)
  {
    AppMethodBeat.i(283070);
    p.k(paramc, "$this$isWxNativeEnabled");
    paramc = paramc.getRuntime();
    p.j(paramc, "runtime");
    if ((paramc.bDl()) || (BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED))
    {
      AppMethodBeat.o(283070);
      return true;
    }
    AppMethodBeat.o(283070);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "value", "", "onReceiveValue"})
  static final class a<T>
    implements ValueCallback<String>
  {
    a(c paramc, g paramg, long paramLong) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.aa
 * JD-Core Version:    0.7.0.1
 */