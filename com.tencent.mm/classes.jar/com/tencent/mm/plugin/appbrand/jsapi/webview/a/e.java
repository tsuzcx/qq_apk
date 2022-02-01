package com.tencent.mm.plugin.appbrand.jsapi.webview.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.d.q;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLWebViewJsApiPool;", "Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "()V", "compatJsApiPool", "Lcom/tencent/mm/plugin/webview/jsapi/WebViewJsApiPool;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "support", "plugin-appbrand-integration_release"})
public final class e
  implements com.tencent.mm.plugin.webview.d.e
{
  private static final q pHJ;
  public static final e pHK;
  
  static
  {
    AppMethodBeat.i(274475);
    pHK = new e();
    pHJ = q.POB;
    AppMethodBeat.o(274475);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(274473);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    boolean bool = pHJ.a(paramf, paramn);
    AppMethodBeat.o(274473);
    return bool;
  }
  
  public final boolean b(f paramf, n paramn)
  {
    AppMethodBeat.i(274474);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    boolean bool = pHJ.b(paramf, paramn);
    AppMethodBeat.o(274474);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.a.e
 * JD-Core Version:    0.7.0.1
 */