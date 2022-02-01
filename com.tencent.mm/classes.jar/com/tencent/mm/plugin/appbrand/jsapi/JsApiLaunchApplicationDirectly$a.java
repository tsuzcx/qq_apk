package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.al;

final class JsApiLaunchApplicationDirectly$a
  implements al
{
  volatile boolean dye;
  volatile boolean hOP;
  volatile boolean ksE;
  volatile boolean ksF;
  a kta;
  
  JsApiLaunchApplicationDirectly$a(a parama)
  {
    this.kta = parama;
  }
  
  final void go(boolean paramBoolean)
  {
    AppMethodBeat.i(45536);
    this.dye = paramBoolean;
    this.ksF = true;
    if ((this.hOP) && (this.kta != null)) {
      this.kta.u(paramBoolean, this.ksE);
    }
    AppMethodBeat.o(45536);
  }
  
  public final void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(188270);
    this.hOP = true;
    this.ksE = paramBoolean1;
    if ((this.ksF) && (this.kta != null)) {
      this.kta.u(this.dye, paramBoolean1);
    }
    AppMethodBeat.o(188270);
  }
  
  static abstract interface a
  {
    public abstract void u(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.a
 * JD-Core Version:    0.7.0.1
 */