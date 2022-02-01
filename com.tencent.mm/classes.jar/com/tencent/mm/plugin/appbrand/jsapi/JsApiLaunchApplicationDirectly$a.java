package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.al;

final class JsApiLaunchApplicationDirectly$a
  implements al
{
  volatile boolean dQW;
  volatile boolean iMQ;
  a lAu;
  volatile boolean lzY;
  volatile boolean lzZ;
  
  JsApiLaunchApplicationDirectly$a(a parama)
  {
    this.lAu = parama;
  }
  
  final void hj(boolean paramBoolean)
  {
    AppMethodBeat.i(45536);
    this.dQW = paramBoolean;
    this.lzZ = true;
    if ((this.iMQ) && (this.lAu != null)) {
      this.lAu.u(paramBoolean, this.lzY);
    }
    AppMethodBeat.o(45536);
  }
  
  public final void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(226674);
    this.iMQ = true;
    this.lzY = paramBoolean1;
    if ((this.lzZ) && (this.lAu != null)) {
      this.lAu.u(this.dQW, paramBoolean1);
    }
    AppMethodBeat.o(226674);
  }
  
  static abstract interface a
  {
    public abstract void u(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.a
 * JD-Core Version:    0.7.0.1
 */