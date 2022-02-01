package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.ap;

final class JsApiLaunchApplicationDirectly$a
  implements ap
{
  volatile boolean hPS;
  volatile boolean ouJ;
  volatile boolean ryI;
  volatile boolean ryJ;
  a rzf;
  
  JsApiLaunchApplicationDirectly$a(a parama)
  {
    this.rzf = parama;
  }
  
  final void iY(boolean paramBoolean)
  {
    AppMethodBeat.i(45536);
    this.hPS = paramBoolean;
    this.ryJ = true;
    if ((this.ouJ) && (this.rzf != null)) {
      this.rzf.C(paramBoolean, this.ryI);
    }
    AppMethodBeat.o(45536);
  }
  
  public final void onLaunchApp(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(325474);
    this.ouJ = true;
    this.ryI = paramBoolean1;
    if ((this.ryJ) && (this.rzf != null)) {
      this.rzf.C(this.hPS, paramBoolean1);
    }
    AppMethodBeat.o(325474);
  }
  
  static abstract interface a
  {
    public abstract void C(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.a
 * JD-Core Version:    0.7.0.1
 */