package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.al;

final class JsApiLaunchApplicationForNative$a
  implements al
{
  volatile boolean dye;
  volatile boolean hOP;
  volatile boolean ksE;
  volatile boolean ksF;
  a kvL;
  
  JsApiLaunchApplicationForNative$a(a parama)
  {
    this.kvL = parama;
  }
  
  final void go(boolean paramBoolean)
  {
    AppMethodBeat.i(45848);
    this.dye = paramBoolean;
    this.ksF = true;
    if ((this.hOP) && (this.kvL != null)) {
      this.kvL.u(paramBoolean, this.ksE);
    }
    AppMethodBeat.o(45848);
  }
  
  public final void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(188277);
    this.hOP = true;
    this.ksE = paramBoolean1;
    if ((this.ksF) && (this.kvL != null)) {
      this.kvL.u(this.dye, paramBoolean1);
    }
    AppMethodBeat.o(188277);
  }
  
  static abstract interface a
  {
    public abstract void u(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.a
 * JD-Core Version:    0.7.0.1
 */