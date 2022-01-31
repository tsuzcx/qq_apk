package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.ai;

final class JsApiLaunchApplicationForNative$a
  implements ai
{
  volatile boolean cyH;
  volatile boolean ftW;
  JsApiLaunchApplicationForNative.a.a hBp;
  volatile boolean hyp;
  volatile boolean hyq;
  
  JsApiLaunchApplicationForNative$a(JsApiLaunchApplicationForNative.a.a parama)
  {
    this.hBp = parama;
  }
  
  public final void dZ(boolean paramBoolean)
  {
    AppMethodBeat.i(143345);
    this.ftW = true;
    this.hyp = paramBoolean;
    if ((this.hyq) && (this.hBp != null)) {
      this.hBp.r(this.cyH, paramBoolean);
    }
    AppMethodBeat.o(143345);
  }
  
  final void ea(boolean paramBoolean)
  {
    AppMethodBeat.i(143346);
    this.cyH = paramBoolean;
    this.hyq = true;
    if ((this.ftW) && (this.hBp != null)) {
      this.hBp.r(paramBoolean, this.hyp);
    }
    AppMethodBeat.o(143346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.a
 * JD-Core Version:    0.7.0.1
 */