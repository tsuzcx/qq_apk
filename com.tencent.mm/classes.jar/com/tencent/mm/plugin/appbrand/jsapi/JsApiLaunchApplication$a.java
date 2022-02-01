package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.al;

final class JsApiLaunchApplication$a
  implements al
{
  volatile boolean fKm;
  volatile boolean lCY;
  volatile boolean ovo;
  volatile boolean ovp;
  a ovq;
  
  JsApiLaunchApplication$a(a parama)
  {
    this.ovq = parama;
  }
  
  final void hZ(boolean paramBoolean)
  {
    AppMethodBeat.i(45508);
    this.fKm = paramBoolean;
    this.ovp = true;
    if ((this.lCY) && (this.ovq != null)) {
      this.ovq.x(paramBoolean, this.ovo);
    }
    AppMethodBeat.o(45508);
  }
  
  public final void y(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(272149);
    this.lCY = true;
    this.ovo = paramBoolean1;
    if ((this.ovp) && (this.ovq != null)) {
      this.ovq.x(this.fKm, paramBoolean1);
    }
    AppMethodBeat.o(272149);
  }
  
  static abstract interface a
  {
    public abstract void x(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.a
 * JD-Core Version:    0.7.0.1
 */