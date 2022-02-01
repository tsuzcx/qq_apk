package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.am;

final class JsApiLaunchApplicationForNative$a
  implements am
{
  volatile boolean dmq;
  volatile boolean hwA;
  volatile boolean jYi;
  volatile boolean jYj;
  a kbp;
  
  JsApiLaunchApplicationForNative$a(a parama)
  {
    this.kbp = parama;
  }
  
  final void gj(boolean paramBoolean)
  {
    AppMethodBeat.i(45848);
    this.dmq = paramBoolean;
    this.jYj = true;
    if ((this.hwA) && (this.kbp != null)) {
      this.kbp.u(paramBoolean, this.jYi);
    }
    AppMethodBeat.o(45848);
  }
  
  public final void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(186572);
    this.hwA = true;
    this.jYi = paramBoolean1;
    if ((this.jYj) && (this.kbp != null)) {
      this.kbp.u(this.dmq, paramBoolean1);
    }
    AppMethodBeat.o(186572);
  }
  
  static abstract interface a
  {
    public abstract void u(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.a
 * JD-Core Version:    0.7.0.1
 */