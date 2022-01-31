package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.pluginsdk.model.app.am;

final class JsApiLaunchApplication$a
  implements am
{
  volatile boolean bRf;
  volatile boolean edU;
  volatile boolean ggq;
  volatile boolean ggr;
  JsApiLaunchApplication.a.a ggs;
  
  JsApiLaunchApplication$a(JsApiLaunchApplication.a.a parama)
  {
    this.ggs = parama;
  }
  
  public final void cW(boolean paramBoolean)
  {
    this.edU = true;
    this.ggq = paramBoolean;
    if ((this.ggr) && (this.ggs != null)) {
      this.ggs.q(this.bRf, paramBoolean);
    }
  }
  
  final void cX(boolean paramBoolean)
  {
    this.bRf = paramBoolean;
    this.ggr = true;
    if ((this.edU) && (this.ggs != null)) {
      this.ggs.q(paramBoolean, this.ggq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.a
 * JD-Core Version:    0.7.0.1
 */