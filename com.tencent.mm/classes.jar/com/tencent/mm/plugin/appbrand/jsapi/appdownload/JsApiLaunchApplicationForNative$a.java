package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.am;

final class JsApiLaunchApplicationForNative$a
  implements am
{
  volatile boolean doI;
  volatile boolean gWb;
  a jAT;
  volatile boolean jxM;
  volatile boolean jxN;
  
  JsApiLaunchApplicationForNative$a(a parama)
  {
    this.jAT = parama;
  }
  
  final void fN(boolean paramBoolean)
  {
    AppMethodBeat.i(45848);
    this.doI = paramBoolean;
    this.jxN = true;
    if ((this.gWb) && (this.jAT != null)) {
      this.jAT.t(paramBoolean, this.jxM);
    }
    AppMethodBeat.o(45848);
  }
  
  public final void u(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(195809);
    this.gWb = true;
    this.jxM = paramBoolean1;
    if ((this.jxN) && (this.jAT != null)) {
      this.jAT.t(this.doI, paramBoolean1);
    }
    AppMethodBeat.o(195809);
  }
  
  static abstract interface a
  {
    public abstract void t(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.a
 * JD-Core Version:    0.7.0.1
 */