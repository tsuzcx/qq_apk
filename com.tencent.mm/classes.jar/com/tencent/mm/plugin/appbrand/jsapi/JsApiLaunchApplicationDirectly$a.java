package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.ai;

final class JsApiLaunchApplicationDirectly$a
  implements ai
{
  volatile boolean cyH;
  volatile boolean ftW;
  JsApiLaunchApplicationDirectly.a.a hyM;
  volatile boolean hyp;
  volatile boolean hyq;
  
  JsApiLaunchApplicationDirectly$a(JsApiLaunchApplicationDirectly.a.a parama)
  {
    this.hyM = parama;
  }
  
  public final void dZ(boolean paramBoolean)
  {
    AppMethodBeat.i(130476);
    this.ftW = true;
    this.hyp = paramBoolean;
    if ((this.hyq) && (this.hyM != null)) {
      this.hyM.r(this.cyH, paramBoolean);
    }
    AppMethodBeat.o(130476);
  }
  
  final void ea(boolean paramBoolean)
  {
    AppMethodBeat.i(130477);
    this.cyH = paramBoolean;
    this.hyq = true;
    if ((this.ftW) && (this.hyM != null)) {
      this.hyM.r(paramBoolean, this.hyp);
    }
    AppMethodBeat.o(130477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.a
 * JD-Core Version:    0.7.0.1
 */