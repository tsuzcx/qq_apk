package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.al;

final class JsApiLaunchApplication$a
  implements al
{
  volatile boolean dye;
  volatile boolean hOP;
  volatile boolean ksE;
  volatile boolean ksF;
  a ksG;
  
  JsApiLaunchApplication$a(a parama)
  {
    this.ksG = parama;
  }
  
  final void go(boolean paramBoolean)
  {
    AppMethodBeat.i(45508);
    this.dye = paramBoolean;
    this.ksF = true;
    if ((this.hOP) && (this.ksG != null)) {
      this.ksG.u(paramBoolean, this.ksE);
    }
    AppMethodBeat.o(45508);
  }
  
  public final void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(188266);
    this.hOP = true;
    this.ksE = paramBoolean1;
    if ((this.ksF) && (this.ksG != null)) {
      this.ksG.u(this.dye, paramBoolean1);
    }
    AppMethodBeat.o(188266);
  }
  
  static abstract interface a
  {
    public abstract void u(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.a
 * JD-Core Version:    0.7.0.1
 */