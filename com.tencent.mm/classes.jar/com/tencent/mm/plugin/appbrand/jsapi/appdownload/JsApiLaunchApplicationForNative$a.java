package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.al;

final class JsApiLaunchApplicationForNative$a
  implements al
{
  volatile boolean fKm;
  volatile boolean lCY;
  volatile boolean ovo;
  volatile boolean ovp;
  a oyV;
  
  JsApiLaunchApplicationForNative$a(a parama)
  {
    this.oyV = parama;
  }
  
  final void hZ(boolean paramBoolean)
  {
    AppMethodBeat.i(45848);
    this.fKm = paramBoolean;
    this.ovp = true;
    if ((this.lCY) && (this.oyV != null)) {
      this.oyV.x(paramBoolean, this.ovo);
    }
    AppMethodBeat.o(45848);
  }
  
  public final void y(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(282158);
    this.lCY = true;
    this.ovo = paramBoolean1;
    if ((this.ovp) && (this.oyV != null)) {
      this.oyV.x(this.fKm, paramBoolean1);
    }
    AppMethodBeat.o(282158);
  }
  
  static abstract interface a
  {
    public abstract void x(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.a
 * JD-Core Version:    0.7.0.1
 */