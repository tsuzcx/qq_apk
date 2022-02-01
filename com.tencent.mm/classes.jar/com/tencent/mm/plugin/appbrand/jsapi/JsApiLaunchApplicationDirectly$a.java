package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.am;

final class JsApiLaunchApplicationDirectly$a
  implements am
{
  volatile boolean dmq;
  volatile boolean hwA;
  a jYE;
  volatile boolean jYi;
  volatile boolean jYj;
  
  JsApiLaunchApplicationDirectly$a(a parama)
  {
    this.jYE = parama;
  }
  
  final void gj(boolean paramBoolean)
  {
    AppMethodBeat.i(45536);
    this.dmq = paramBoolean;
    this.jYj = true;
    if ((this.hwA) && (this.jYE != null)) {
      this.jYE.u(paramBoolean, this.jYi);
    }
    AppMethodBeat.o(45536);
  }
  
  public final void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(186567);
    this.hwA = true;
    this.jYi = paramBoolean1;
    if ((this.jYj) && (this.jYE != null)) {
      this.jYE.u(this.dmq, paramBoolean1);
    }
    AppMethodBeat.o(186567);
  }
  
  static abstract interface a
  {
    public abstract void u(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.a
 * JD-Core Version:    0.7.0.1
 */