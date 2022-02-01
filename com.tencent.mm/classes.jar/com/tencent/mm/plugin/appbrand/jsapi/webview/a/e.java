package com.tencent.mm.plugin.appbrand.jsapi.webview.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.g;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLWebViewJsApiPool;", "Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "()V", "compatJsApiPool", "Lcom/tencent/mm/plugin/webview/jsapi/WebViewJsApiPool;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "support", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements g
{
  public static final e sME;
  private static final com.tencent.mm.plugin.webview.jsapi.s sMF;
  
  static
  {
    AppMethodBeat.i(327554);
    sME = new e();
    sMF = com.tencent.mm.plugin.webview.jsapi.s.WEN;
    AppMethodBeat.o(327554);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(327562);
    kotlin.g.b.s.u(paramh, "env");
    kotlin.g.b.s.u(paramp, "msg");
    boolean bool = sMF.a(paramh, paramp);
    AppMethodBeat.o(327562);
    return bool;
  }
  
  public final boolean b(h paramh, p paramp)
  {
    AppMethodBeat.i(327567);
    kotlin.g.b.s.u(paramh, "env");
    kotlin.g.b.s.u(paramp, "msg");
    boolean bool = sMF.b(paramh, paramp);
    AppMethodBeat.o(327567);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.a.e
 * JD-Core Version:    0.7.0.1
 */