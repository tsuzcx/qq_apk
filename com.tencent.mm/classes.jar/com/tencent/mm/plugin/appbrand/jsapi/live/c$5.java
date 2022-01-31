package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.y;

final class c$5
  extends g.b
{
  c$5(c paramc, AppBrandLivePusherView paramAppBrandLivePusherView, e parame) {}
  
  public final void a(g.c paramc)
  {
    AppBrandLivePusherView localAppBrandLivePusherView = this.gsm;
    y.i("MicroMsg.AppBrandLivePusherView.javayhu", "onAppBrandPause pauseType:%s", new Object[] { paramc });
    if ((paramc == g.c.fya) || (paramc == g.c.fxZ) || (paramc == g.c.fyf)) {
      localAppBrandLivePusherView.gsc.de(true);
    }
  }
  
  public final void onDestroy()
  {
    g.b(this.gkV.getAppId(), this);
  }
  
  public final void onResume()
  {
    this.gsm.gsc.aje();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.c.5
 * JD-Core Version:    0.7.0.1
 */