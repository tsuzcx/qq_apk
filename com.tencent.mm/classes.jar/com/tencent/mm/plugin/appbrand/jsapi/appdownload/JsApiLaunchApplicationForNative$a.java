package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.ap;

final class JsApiLaunchApplicationForNative$a
  implements ap
{
  volatile boolean hPS;
  volatile boolean ouJ;
  a rCN;
  volatile boolean ryI;
  volatile boolean ryJ;
  
  JsApiLaunchApplicationForNative$a(a parama)
  {
    this.rCN = parama;
  }
  
  final void iY(boolean paramBoolean)
  {
    AppMethodBeat.i(45848);
    this.hPS = paramBoolean;
    this.ryJ = true;
    if ((this.ouJ) && (this.rCN != null)) {
      this.rCN.C(paramBoolean, this.ryI);
    }
    AppMethodBeat.o(45848);
  }
  
  public final void onLaunchApp(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(327662);
    this.ouJ = true;
    this.ryI = paramBoolean1;
    if ((this.ryJ) && (this.rCN != null)) {
      this.rCN.C(this.hPS, paramBoolean1);
    }
    AppMethodBeat.o(327662);
  }
  
  static abstract interface a
  {
    public abstract void C(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.a
 * JD-Core Version:    0.7.0.1
 */