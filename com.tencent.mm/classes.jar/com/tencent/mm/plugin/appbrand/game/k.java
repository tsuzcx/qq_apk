package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.i.d;
import com.tencent.mm.plugin.appbrand.i.f;
import com.tencent.mm.plugin.appbrand.i.l;
import com.tencent.mm.sdk.platformtools.y;

public final class k
{
  final c gap;
  private final k.a gaq;
  private final l gar;
  private volatile Boolean gas = null;
  
  k(c paramc, f paramf)
  {
    this.gap = paramc;
    this.gar = ((l)paramf.I(l.class));
    this.gaq = new k.a(this, this.gap, this.gar);
  }
  
  public final void agu()
  {
    if (this.gar == null)
    {
      y.e("MicroMsg.WAGameWeixinJSContextLogic", "injectWeixinJSContextLogic error. not support SubContextAddon.");
      return;
    }
    d locald = this.gar.ago();
    if ((locald == null) || (!locald.age()))
    {
      y.e("MicroMsg.WAGameWeixinJSContextLogic", "bindMainJSContext Main Context is [" + locald + "]");
      return;
    }
    locald.addJavascriptInterface(this.gaq, "WeixinJSContext");
    this.gaq.Zn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.k
 * JD-Core Version:    0.7.0.1
 */