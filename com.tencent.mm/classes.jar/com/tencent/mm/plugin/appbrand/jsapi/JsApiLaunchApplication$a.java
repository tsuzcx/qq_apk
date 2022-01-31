package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.ai;

final class JsApiLaunchApplication$a
  implements ai
{
  volatile boolean cyH;
  volatile boolean ftW;
  volatile boolean hyp;
  volatile boolean hyq;
  JsApiLaunchApplication.a.a hyr;
  
  JsApiLaunchApplication$a(JsApiLaunchApplication.a.a parama)
  {
    this.hyr = parama;
  }
  
  public final void dZ(boolean paramBoolean)
  {
    AppMethodBeat.i(130448);
    this.ftW = true;
    this.hyp = paramBoolean;
    if ((this.hyq) && (this.hyr != null)) {
      this.hyr.r(this.cyH, paramBoolean);
    }
    AppMethodBeat.o(130448);
  }
  
  final void ea(boolean paramBoolean)
  {
    AppMethodBeat.i(130449);
    this.cyH = paramBoolean;
    this.hyq = true;
    if ((this.ftW) && (this.hyr != null)) {
      this.hyr.r(paramBoolean, this.hyp);
    }
    AppMethodBeat.o(130449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.a
 * JD-Core Version:    0.7.0.1
 */