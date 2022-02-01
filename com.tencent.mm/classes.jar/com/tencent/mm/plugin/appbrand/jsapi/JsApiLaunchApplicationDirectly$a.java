package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.am;

final class JsApiLaunchApplicationDirectly$a
  implements am
{
  volatile boolean doI;
  volatile boolean gWb;
  volatile boolean jxM;
  volatile boolean jxN;
  a jyj;
  
  JsApiLaunchApplicationDirectly$a(a parama)
  {
    this.jyj = parama;
  }
  
  final void fN(boolean paramBoolean)
  {
    AppMethodBeat.i(45536);
    this.doI = paramBoolean;
    this.jxN = true;
    if ((this.gWb) && (this.jyj != null)) {
      this.jyj.t(paramBoolean, this.jxM);
    }
    AppMethodBeat.o(45536);
  }
  
  public final void u(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(195804);
    this.gWb = true;
    this.jxM = paramBoolean1;
    if ((this.jxN) && (this.jyj != null)) {
      this.jyj.t(this.doI, paramBoolean1);
    }
    AppMethodBeat.o(195804);
  }
  
  static abstract interface a
  {
    public abstract void t(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.a
 * JD-Core Version:    0.7.0.1
 */