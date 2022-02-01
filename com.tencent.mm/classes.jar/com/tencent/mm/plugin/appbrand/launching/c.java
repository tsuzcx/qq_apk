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
    g.afz();
    paramAppBrandInitConfigWC.uin = a.getUin();
    boolean bool = j.aOI().aY(paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC.iOP);
    if (j.aOJ().aV(paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC.iOP)) {
      paramAppBrandStatObject.lpL = 1;
    }
    for (;;)
    {
      if (paramAppBrandInitConfigWC.CZ()) {
        ((com.tencent.mm.plugin.boots.a.c)g.ab(com.tencent.mm.plugin.boots.a.c.class)).xw(b.mQL);
      }
      if (!paramAppBrandInitConfigWC.jdl)
      {
        ((com.tencent.mm.plugin.boots.a.c)g.ab(com.tencent.mm.plugin.boots.a.c.class)).xw(b.mQN);
        if (!paramAppBrandInitConfigWC.CZ()) {
          ((com.tencent.mm.plugin.boots.a.c)g.ab(com.tencent.mm.plugin.boots.a.c.class)).xw(b.mQO);
        }
      }
      if ("wxfe02ecfe70800f46".equalsIgnoreCase(paramAppBrandInitConfigWC.appId)) {
        ((com.tencent.mm.plugin.boots.a.c)g.ab(com.tencent.mm.plugin.boots.a.c.class)).xw(b.mQP);
      }
      AppMethodBeat.o(47067);
      return;
      if (bool) {
        paramAppBrandStatObject.lpL = 2;
      } else {
        paramAppBrandStatObject.lpL = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c
 * JD-Core Version:    0.7.0.1
 */