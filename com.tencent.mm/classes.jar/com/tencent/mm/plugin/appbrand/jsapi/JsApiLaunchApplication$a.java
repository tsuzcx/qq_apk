package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.ap;

final class JsApiLaunchApplication$a
  implements ap
{
  volatile boolean hPS;
  volatile boolean ouJ;
  volatile boolean ryI;
  volatile boolean ryJ;
  a ryK;
  
  JsApiLaunchApplication$a(a parama)
  {
    this.ryK = parama;
  }
  
  final void iY(boolean paramBoolean)
  {
    AppMethodBeat.i(45508);
    this.hPS = paramBoolean;
    this.ryJ = true;
    if ((this.ouJ) && (this.ryK != null)) {
      this.ryK.C(paramBoolean, this.ryI);
    }
    AppMethodBeat.o(45508);
  }
  
  public final void onLaunchApp(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(325470);
    this.ouJ = true;
    this.ryI = paramBoolean1;
    if ((this.ryJ) && (this.ryK != null)) {
      this.ryK.C(this.hPS, paramBoolean1);
    }
    AppMethodBeat.o(325470);
  }
  
  static abstract interface a
  {
    public abstract void C(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.a
 * JD-Core Version:    0.7.0.1
 */