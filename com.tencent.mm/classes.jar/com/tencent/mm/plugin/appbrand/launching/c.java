package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.appusage.x;
import com.tencent.mm.plugin.appbrand.backgroundfetch.j;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.WebRenderingCacheDirectoryDescriptor;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public final class c
{
  public static void b(AppBrandInitConfigWC paramAppBrandInitConfigWC, final AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47067);
    if (com.tencent.mm.plugin.appbrand.backgroundfetch.b.d(paramAppBrandInitConfigWC)) {
      com.tencent.e.h.ZvG.bg(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(280683);
          com.tencent.mm.plugin.appbrand.backgroundfetch.b.a(this.pRm.appId, this.pRm.username, this.pRm.cBI, this.pRm.nBq, paramAppBrandStatObject.scene, new j());
          AppMethodBeat.o(280683);
        }
      });
    }
    com.tencent.mm.kernel.h.aHE();
    paramAppBrandInitConfigWC.uin = com.tencent.mm.kernel.b.getUin();
    boolean bool = m.bFN().bF(paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC.cBI);
    if (m.bFO().bC(paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC.cBI)) {
      paramAppBrandStatObject.qJF = 1;
    }
    for (;;)
    {
      com.tencent.e.h.ZvG.bg(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(273263);
          if (this.pRm.Qv()) {
            ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.boots.a.c.class)).Gs(com.tencent.mm.plugin.boots.a.b.smF);
          }
          if (!this.pRm.nYb)
          {
            ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.boots.a.c.class)).Gs(com.tencent.mm.plugin.boots.a.b.smH);
            if (!this.pRm.Qv()) {
              ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.boots.a.c.class)).Gs(com.tencent.mm.plugin.boots.a.b.smI);
            }
          }
          if ("wxfe02ecfe70800f46".equalsIgnoreCase(this.pRm.appId)) {
            ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.boots.a.c.class)).Gs(com.tencent.mm.plugin.boots.a.b.smJ);
          }
          AppMethodBeat.o(273263);
        }
      });
      if (!paramAppBrandInitConfigWC.Qv()) {
        break;
      }
      paramAppBrandInitConfigWC.nYj = null;
      if (paramAppBrandInitConfigWC.launchMode != 1) {
        break label172;
      }
      paramAppBrandInitConfigWC.cCi = "portrait";
      AppMethodBeat.o(47067);
      return;
      if (bool) {
        paramAppBrandStatObject.qJF = 2;
      } else {
        paramAppBrandStatObject.qJF = 3;
      }
    }
    paramAppBrandInitConfigWC.nYj = new WebRenderingCacheDirectoryDescriptor();
    paramAppBrandInitConfigWC.nYj.qyq = g.amb(paramAppBrandInitConfigWC.appId);
    label172:
    AppMethodBeat.o(47067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c
 * JD-Core Version:    0.7.0.1
 */