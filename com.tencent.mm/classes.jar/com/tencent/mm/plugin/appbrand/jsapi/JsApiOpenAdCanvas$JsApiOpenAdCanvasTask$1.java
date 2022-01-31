package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.g.a.lw.b;
import com.tencent.mm.sdk.b.a;

final class JsApiOpenAdCanvas$JsApiOpenAdCanvasTask$1
  implements Runnable
{
  JsApiOpenAdCanvas$JsApiOpenAdCanvasTask$1(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask paramJsApiOpenAdCanvasTask) {}
  
  public final void run()
  {
    AppMethodBeat.i(130502);
    lw locallw = new lw();
    locallw.cBS.pageId = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.a(this.hyZ);
    locallw.cBS.cpH = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.b(this.hyZ);
    locallw.cBS.cBU = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.c(this.hyZ);
    locallw.cBS.cBV = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.d(this.hyZ);
    locallw.cBS.cpt = 0;
    a.ymk.l(locallw);
    JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.a(this.hyZ, locallw.cBT.cBW);
    JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.e(this.hyZ);
    AppMethodBeat.o(130502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.1
 * JD-Core Version:    0.7.0.1
 */