package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.appusage.x;
import com.tencent.mm.plugin.appbrand.backgroundfetch.j;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.WebRenderingCacheDirectoryDescriptor;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.h;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public final class c
{
  public static void b(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47067);
    if (com.tencent.mm.plugin.appbrand.backgroundfetch.b.d(paramAppBrandInitConfigWC)) {
      com.tencent.mm.plugin.appbrand.backgroundfetch.b.a(paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC.eix, paramAppBrandInitConfigWC.kHw, paramAppBrandStatObject.scene, new j());
    }
    g.aAf();
    paramAppBrandInitConfigWC.uin = a.getUin();
    boolean bool = n.buJ().bm(paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC.eix);
    if (n.buK().bj(paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC.eix)) {
      paramAppBrandStatObject.nHt = 1;
    }
    for (;;)
    {
      if (paramAppBrandInitConfigWC.NA()) {
        ((com.tencent.mm.plugin.boots.a.c)g.af(com.tencent.mm.plugin.boots.a.c.class)).CN(com.tencent.mm.plugin.boots.a.b.pkw);
      }
      if (!paramAppBrandInitConfigWC.ldN)
      {
        ((com.tencent.mm.plugin.boots.a.c)g.af(com.tencent.mm.plugin.boots.a.c.class)).CN(com.tencent.mm.plugin.boots.a.b.pky);
        if (!paramAppBrandInitConfigWC.NA()) {
          ((com.tencent.mm.plugin.boots.a.c)g.af(com.tencent.mm.plugin.boots.a.c.class)).CN(com.tencent.mm.plugin.boots.a.b.pkz);
        }
      }
      if ("wxfe02ecfe70800f46".equalsIgnoreCase(paramAppBrandInitConfigWC.appId)) {
        ((com.tencent.mm.plugin.boots.a.c)g.af(com.tencent.mm.plugin.boots.a.c.class)).CN(com.tencent.mm.plugin.boots.a.b.pkA);
      }
      if (!paramAppBrandInitConfigWC.NA()) {
        break;
      }
      paramAppBrandInitConfigWC.ldV = null;
      if (paramAppBrandInitConfigWC.launchMode != 1) {
        break label264;
      }
      paramAppBrandInitConfigWC.cBG = "portrait";
      AppMethodBeat.o(47067);
      return;
      if (bool) {
        paramAppBrandStatObject.nHt = 2;
      } else {
        paramAppBrandStatObject.nHt = 3;
      }
    }
    paramAppBrandInitConfigWC.ldV = new WebRenderingCacheDirectoryDescriptor();
    paramAppBrandInitConfigWC.ldV.nwn = h.aeh(paramAppBrandInitConfigWC.appId);
    label264:
    AppMethodBeat.o(47067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c
 * JD-Core Version:    0.7.0.1
 */