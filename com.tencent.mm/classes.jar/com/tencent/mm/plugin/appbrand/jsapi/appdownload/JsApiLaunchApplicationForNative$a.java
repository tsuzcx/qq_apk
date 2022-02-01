package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.al;

final class JsApiLaunchApplicationForNative$a
  implements al
{
  volatile boolean dQW;
  volatile boolean iMQ;
  a lDt;
  volatile boolean lzY;
  volatile boolean lzZ;
  
  JsApiLaunchApplicationForNative$a(a parama)
  {
    this.lDt = parama;
  }
  
  final void hj(boolean paramBoolean)
  {
    AppMethodBeat.i(45848);
    this.dQW = paramBoolean;
    this.lzZ = true;
    if ((this.iMQ) && (this.lDt != null)) {
      this.lDt.u(paramBoolean, this.lzY);
    }
    AppMethodBeat.o(45848);
  }
  
  public final void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(226686);
    this.iMQ = true;
    this.lzY = paramBoolean1;
    if ((this.lzZ) && (this.lDt != null)) {
      this.lDt.u(this.dQW, paramBoolean1);
    }
    AppMethodBeat.o(226686);
  }
  
  static abstract interface a
  {
    public abstract void u(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.a
 * JD-Core Version:    0.7.0.1
 */