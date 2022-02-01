package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.t;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.WebRenderingCacheDirectoryDescriptor;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.threadpool.i;

public final class e
{
  public static void a(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47067);
    if (com.tencent.mm.plugin.appbrand.backgroundfetch.b.f(paramAppBrandInitConfigWC)) {
      com.tencent.threadpool.h.ahAA.bo(new e.1(paramAppBrandInitConfigWC, paramAppBrandStatObject));
    }
    com.tencent.mm.kernel.h.baC();
    paramAppBrandInitConfigWC.uin = com.tencent.mm.kernel.b.getUin();
    boolean bool = n.cfk().bX(paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC.eul);
    if (n.cfl().bU(paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC.eul)) {
      paramAppBrandStatObject.tOj = 1;
    }
    for (;;)
    {
      com.tencent.threadpool.h.ahAA.bo(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(320873);
          if (e.this.aqJ()) {
            ((c)com.tencent.mm.kernel.h.ax(c.class)).GR(com.tencent.mm.plugin.boots.a.b.vyE);
          }
          if (!e.this.qYd)
          {
            ((c)com.tencent.mm.kernel.h.ax(c.class)).GR(com.tencent.mm.plugin.boots.a.b.vyG);
            if (!e.this.aqJ()) {
              ((c)com.tencent.mm.kernel.h.ax(c.class)).GR(com.tencent.mm.plugin.boots.a.b.vyH);
            }
          }
          if ("wxfe02ecfe70800f46".equalsIgnoreCase(e.this.appId)) {
            ((c)com.tencent.mm.kernel.h.ax(c.class)).GR(com.tencent.mm.plugin.boots.a.b.vyI);
          }
          AppMethodBeat.o(320873);
        }
      });
      if (!paramAppBrandInitConfigWC.aqJ()) {
        break;
      }
      paramAppBrandInitConfigWC.qYl = null;
      if (paramAppBrandInitConfigWC.launchMode != 1) {
        break label172;
      }
      paramAppBrandInitConfigWC.euP = "portrait";
      AppMethodBeat.o(47067);
      return;
      if (bool) {
        paramAppBrandStatObject.tOj = 2;
      } else {
        paramAppBrandStatObject.tOj = 3;
      }
    }
    paramAppBrandInitConfigWC.qYl = new WebRenderingCacheDirectoryDescriptor();
    paramAppBrandInitConfigWC.qYl.tDl = g.afj(paramAppBrandInitConfigWC.appId);
    label172:
    AppMethodBeat.o(47067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e
 * JD-Core Version:    0.7.0.1
 */