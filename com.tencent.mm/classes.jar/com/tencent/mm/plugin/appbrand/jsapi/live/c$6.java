package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.e.c;

final class c$6
  implements e.c
{
  c$6(c paramc, AppBrandLivePusherView paramAppBrandLivePusherView, e parame, g.b paramb) {}
  
  public final void onDestroy()
  {
    this.gsm.rX();
    this.gkV.b(this);
    g.b(this.gkV.getAppId(), this.gsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.c.6
 * JD-Core Version:    0.7.0.1
 */