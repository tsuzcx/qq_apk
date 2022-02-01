package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.al;

final class JsApiLaunchApplication$a
  implements al
{
  volatile boolean dQW;
  volatile boolean iMQ;
  a lAa;
  volatile boolean lzY;
  volatile boolean lzZ;
  
  JsApiLaunchApplication$a(a parama)
  {
    this.lAa = parama;
  }
  
  final void hj(boolean paramBoolean)
  {
    AppMethodBeat.i(45508);
    this.dQW = paramBoolean;
    this.lzZ = true;
    if ((this.iMQ) && (this.lAa != null)) {
      this.lAa.u(paramBoolean, this.lzY);
    }
    AppMethodBeat.o(45508);
  }
  
  public final void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(226670);
    this.iMQ = true;
    this.lzY = paramBoolean1;
    if ((this.lzZ) && (this.lAa != null)) {
      this.lAa.u(this.dQW, paramBoolean1);
    }
    AppMethodBeat.o(226670);
  }
  
  static abstract interface a
  {
    public abstract void u(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.a
 * JD-Core Version:    0.7.0.1
 */