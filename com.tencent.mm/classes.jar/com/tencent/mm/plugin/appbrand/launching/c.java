package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.appusage.y;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public final class c
{
  public static void b(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47067);
    if (com.tencent.mm.plugin.appbrand.backgroundfetch.b.d(paramAppBrandInitConfigWC)) {
      com.tencent.mm.plugin.appbrand.backgroundfetch.b.a(paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC.dQv, paramAppBrandInitConfigWC.jFL, paramAppBrandStatObject.scene, new com.tencent.mm.plugin.appbrand.backgroundfetch.j());
    }
    paramAppBrandInitConfigWC.resetSession();
    g.ajP();
    paramAppBrandInitConfigWC.uin = a.getUin();
    boolean bool = com.tencent.mm.plugin.appbrand.app.j.aZs().bh(paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC.dQv);
    if (com.tencent.mm.plugin.appbrand.app.j.aZt().be(paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC.dQv)) {
      paramAppBrandStatObject.mwv = 1;
    }
    for (;;)
    {
      if (paramAppBrandInitConfigWC.Ee()) {
        ((com.tencent.mm.plugin.boots.a.c)g.ab(com.tencent.mm.plugin.boots.a.c.class)).zh(com.tencent.mm.plugin.boots.a.b.nZy);
      }
      if (!paramAppBrandInitConfigWC.kaJ)
      {
        ((com.tencent.mm.plugin.boots.a.c)g.ab(com.tencent.mm.plugin.boots.a.c.class)).zh(com.tencent.mm.plugin.boots.a.b.nZA);
        if (!paramAppBrandInitConfigWC.Ee()) {
          ((com.tencent.mm.plugin.boots.a.c)g.ab(com.tencent.mm.plugin.boots.a.c.class)).zh(com.tencent.mm.plugin.boots.a.b.nZB);
        }
      }
      if ("wxfe02ecfe70800f46".equalsIgnoreCase(paramAppBrandInitConfigWC.appId)) {
        ((com.tencent.mm.plugin.boots.a.c)g.ab(com.tencent.mm.plugin.boots.a.c.class)).zh(com.tencent.mm.plugin.boots.a.b.nZC);
      }
      AppMethodBeat.o(47067);
      return;
      if (bool) {
        paramAppBrandStatObject.mwv = 2;
      } else {
        paramAppBrandStatObject.mwv = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c
 * JD-Core Version:    0.7.0.1
 */