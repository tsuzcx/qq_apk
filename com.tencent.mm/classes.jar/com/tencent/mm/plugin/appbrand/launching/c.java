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
  public static void a(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47067);
    paramAppBrandInitConfigWC.resetSession();
    g.agP();
    paramAppBrandInitConfigWC.uin = a.getUin();
    boolean bool = j.aVA().bc(paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC.joY);
    if (j.aVB().aZ(paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC.joY)) {
      paramAppBrandStatObject.lRH = 1;
    }
    for (;;)
    {
      if (paramAppBrandInitConfigWC.CC()) {
        ((com.tencent.mm.plugin.boots.a.c)g.ab(com.tencent.mm.plugin.boots.a.c.class)).yo(b.nsW);
      }
      if (!paramAppBrandInitConfigWC.jDy)
      {
        ((com.tencent.mm.plugin.boots.a.c)g.ab(com.tencent.mm.plugin.boots.a.c.class)).yo(b.nsY);
        if (!paramAppBrandInitConfigWC.CC()) {
          ((com.tencent.mm.plugin.boots.a.c)g.ab(com.tencent.mm.plugin.boots.a.c.class)).yo(b.nsZ);
        }
      }
      if ("wxfe02ecfe70800f46".equalsIgnoreCase(paramAppBrandInitConfigWC.appId)) {
        ((com.tencent.mm.plugin.boots.a.c)g.ab(com.tencent.mm.plugin.boots.a.c.class)).yo(b.nta);
      }
      AppMethodBeat.o(47067);
      return;
      if (bool) {
        paramAppBrandStatObject.lRH = 2;
      } else {
        paramAppBrandStatObject.lRH = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c
 * JD-Core Version:    0.7.0.1
 */