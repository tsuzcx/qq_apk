package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.am;

final class JsApiLaunchApplication$a
  implements am
{
  volatile boolean doI;
  volatile boolean gWb;
  volatile boolean jxM;
  volatile boolean jxN;
  a jxO;
  
  JsApiLaunchApplication$a(a parama)
  {
    this.jxO = parama;
  }
  
  final void fN(boolean paramBoolean)
  {
    AppMethodBeat.i(45508);
    this.doI = paramBoolean;
    this.jxN = true;
    if ((this.gWb) && (this.jxO != null)) {
      this.jxO.t(paramBoolean, this.jxM);
    }
    AppMethodBeat.o(45508);
  }
  
  public final void u(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(195800);
    this.gWb = true;
    this.jxM = paramBoolean1;
    if ((this.jxN) && (this.jxO != null)) {
      this.jxO.t(this.doI, paramBoolean1);
    }
    AppMethodBeat.o(195800);
  }
  
  static abstract interface a
  {
    public abstract void t(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.a
 * JD-Core Version:    0.7.0.1
 */