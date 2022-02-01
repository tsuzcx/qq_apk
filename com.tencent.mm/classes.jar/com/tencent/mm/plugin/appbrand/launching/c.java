package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.appusage.y;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.boots.a.b;

public final class c
{
  public static void b(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47067);
    paramAppBrandInitConfigWC.resetSession();
    g.ajA();
    paramAppBrandInitConfigWC.uin = a.getUin();
    boolean bool = j.aYV().be(paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC.dPf);
    if (j.aYW().bb(paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC.dPf)) {
      paramAppBrandStatObject.mrx = 1;
    }
    for (;;)
    {
      if (paramAppBrandInitConfigWC.Eb()) {
        ((com.tencent.mm.plugin.boots.a.c)g.ab(com.tencent.mm.plugin.boots.a.c.class)).yY(b.nTS);
      }
      if (!paramAppBrandInitConfigWC.jXu)
      {
        ((com.tencent.mm.plugin.boots.a.c)g.ab(com.tencent.mm.plugin.boots.a.c.class)).yY(b.nTU);
        if (!paramAppBrandInitConfigWC.Eb()) {
          ((com.tencent.mm.plugin.boots.a.c)g.ab(com.tencent.mm.plugin.boots.a.c.class)).yY(b.nTV);
        }
      }
      if ("wxfe02ecfe70800f46".equalsIgnoreCase(paramAppBrandInitConfigWC.appId)) {
        ((com.tencent.mm.plugin.boots.a.c)g.ab(com.tencent.mm.plugin.boots.a.c.class)).yY(b.nTW);
      }
      AppMethodBeat.o(47067);
      return;
      if (bool) {
        paramAppBrandStatObject.mrx = 2;
      } else {
        paramAppBrandStatObject.mrx = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c
 * JD-Core Version:    0.7.0.1
 */