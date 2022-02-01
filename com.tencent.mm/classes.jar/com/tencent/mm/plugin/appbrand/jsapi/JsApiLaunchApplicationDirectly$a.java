package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.al;

final class JsApiLaunchApplicationDirectly$a
  implements al
{
  volatile boolean fKm;
  volatile boolean lCY;
  a ovL;
  volatile boolean ovo;
  volatile boolean ovp;
  
  JsApiLaunchApplicationDirectly$a(a parama)
  {
    this.ovL = parama;
  }
  
  final void hZ(boolean paramBoolean)
  {
    AppMethodBeat.i(45536);
    this.fKm = paramBoolean;
    this.ovp = true;
    if ((this.lCY) && (this.ovL != null)) {
      this.ovL.x(paramBoolean, this.ovo);
    }
    AppMethodBeat.o(45536);
  }
  
  public final void y(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(272830);
    this.lCY = true;
    this.ovo = paramBoolean1;
    if ((this.ovp) && (this.ovL != null)) {
      this.ovL.x(this.fKm, paramBoolean1);
    }
    AppMethodBeat.o(272830);
  }
  
  static abstract interface a
  {
    public abstract void x(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.a
 * JD-Core Version:    0.7.0.1
 */