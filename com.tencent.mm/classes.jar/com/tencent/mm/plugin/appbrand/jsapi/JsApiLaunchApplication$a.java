package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.al;

final class JsApiLaunchApplication$a
  implements al
{
  volatile boolean dzj;
  volatile boolean hRI;
  volatile boolean kvU;
  volatile boolean kvV;
  a kvW;
  
  JsApiLaunchApplication$a(a parama)
  {
    this.kvW = parama;
  }
  
  final void gm(boolean paramBoolean)
  {
    AppMethodBeat.i(45508);
    this.dzj = paramBoolean;
    this.kvV = true;
    if ((this.hRI) && (this.kvW != null)) {
      this.kvW.u(paramBoolean, this.kvU);
    }
    AppMethodBeat.o(45508);
  }
  
  public final void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(222392);
    this.hRI = true;
    this.kvU = paramBoolean1;
    if ((this.kvV) && (this.kvW != null)) {
      this.kvW.u(this.dzj, paramBoolean1);
    }
    AppMethodBeat.o(222392);
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