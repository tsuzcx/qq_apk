package com.tencent.mm.plugin.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.core.c;
import com.tencent.mm.plugin.webview.core.d;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.stub.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webjsengine/JsApiHandlerBuilder$build$2", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "onConnected", "", "conn", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "onDisconnected", "", "webview-sdk_release"})
public final class a$b
  implements d
{
  public a$b(h paramh, int paramInt) {}
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(224853);
    p.h(paramc, "conn");
    this.IBx.b(paramc.fZs());
    paramc.fZs().a((f)new a.a(this.IBx), this.IBy);
    this.IBx.yV(true);
    AppMethodBeat.o(224853);
  }
  
  public final boolean fXa()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.a.b
 * JD-Core Version:    0.7.0.1
 */