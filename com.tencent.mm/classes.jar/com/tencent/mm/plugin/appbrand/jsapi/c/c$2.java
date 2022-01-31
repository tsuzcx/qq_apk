package com.tencent.mm.plugin.appbrand.jsapi.c;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.sdk.platformtools.y;

final class c$2
  extends g.b
{
  c$2(c paramc, com.tencent.mm.plugin.appbrand.jsapi.c paramc1) {}
  
  public final void onDestroy()
  {
    y.i("MicroMsg.JsApiStartBeaconDiscovery", "onDestroy");
    g.b(this.ggE.getAppId(), this);
    a.a locala = a.ub(this.ggE.getAppId());
    if (locala != null)
    {
      locala.un();
      a.remove(this.ggE.getAppId());
    }
    this.gri.grf = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.c.2
 * JD-Core Version:    0.7.0.1
 */