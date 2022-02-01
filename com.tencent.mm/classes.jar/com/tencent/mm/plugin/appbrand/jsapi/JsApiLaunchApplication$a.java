package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.am;

final class JsApiLaunchApplication$a
  implements am
{
  volatile boolean dmq;
  volatile boolean hwA;
  volatile boolean jYi;
  volatile boolean jYj;
  a jYk;
  
  JsApiLaunchApplication$a(a parama)
  {
    this.jYk = parama;
  }
  
  final void gj(boolean paramBoolean)
  {
    AppMethodBeat.i(45508);
    this.dmq = paramBoolean;
    this.jYj = true;
    if ((this.hwA) && (this.jYk != null)) {
      this.jYk.u(paramBoolean, this.jYi);
    }
    AppMethodBeat.o(45508);
  }
  
  public final void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(186563);
    this.hwA = true;
    this.jYi = paramBoolean1;
    if ((this.jYj) && (this.jYk != null)) {
      this.jYk.u(this.dmq, paramBoolean1);
    }
    AppMethodBeat.o(186563);
  }
  
  static abstract interface a
  {
    public abstract void u(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.a
 * JD-Core Version:    0.7.0.1
 */