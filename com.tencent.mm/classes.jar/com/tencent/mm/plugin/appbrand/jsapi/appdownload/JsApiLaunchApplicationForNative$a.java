package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.al;

final class JsApiLaunchApplicationForNative$a
  implements al
{
  volatile boolean dzj;
  volatile boolean hRI;
  volatile boolean kvU;
  volatile boolean kvV;
  a kza;
  
  JsApiLaunchApplicationForNative$a(a parama)
  {
    this.kza = parama;
  }
  
  final void gm(boolean paramBoolean)
  {
    AppMethodBeat.i(45848);
    this.dzj = paramBoolean;
    this.kvV = true;
    if ((this.hRI) && (this.kza != null)) {
      this.kza.u(paramBoolean, this.kvU);
    }
    AppMethodBeat.o(45848);
  }
  
  public final void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(222403);
    this.hRI = true;
    this.kvU = paramBoolean1;
    if ((this.kvV) && (this.kza != null)) {
      this.kza.u(this.dzj, paramBoolean1);
    }
    AppMethodBeat.o(222403);
  }
  
  static abstract interface a
  {
    public abstract void u(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.a
 * JD-Core Version:    0.7.0.1
 */