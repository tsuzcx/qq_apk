package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.al;

final class JsApiLaunchApplicationDirectly$a
  implements al
{
  volatile boolean dzj;
  volatile boolean hRI;
  volatile boolean kvU;
  volatile boolean kvV;
  a kwq;
  
  JsApiLaunchApplicationDirectly$a(a parama)
  {
    this.kwq = parama;
  }
  
  final void gm(boolean paramBoolean)
  {
    AppMethodBeat.i(45536);
    this.dzj = paramBoolean;
    this.kvV = true;
    if ((this.hRI) && (this.kwq != null)) {
      this.kwq.u(paramBoolean, this.kvU);
    }
    AppMethodBeat.o(45536);
  }
  
  public final void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(222396);
    this.hRI = true;
    this.kvU = paramBoolean1;
    if ((this.kvV) && (this.kwq != null)) {
      this.kwq.u(this.dzj, paramBoolean1);
    }
    AppMethodBeat.o(222396);
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