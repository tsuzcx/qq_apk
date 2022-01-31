package com.tencent.mm.plugin.appbrand.jsapi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;

final class c$1
  extends e.c
{
  c$1(c paramc, com.tencent.mm.plugin.appbrand.jsapi.c paramc1) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(131484);
    AppBrandStickyBannerLogic.a.cV(this.hxW.getAppId(), "");
    AppMethodBeat.o(131484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.c.1
 * JD-Core Version:    0.7.0.1
 */