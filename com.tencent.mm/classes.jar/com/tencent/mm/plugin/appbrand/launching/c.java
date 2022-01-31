package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public final class c
  extends b
{
  public static void a(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(131717);
    paramAppBrandInitConfigWC.resetSession();
    paramAppBrandInitConfigWC.resetSession();
    com.tencent.mm.kernel.g.RJ();
    paramAppBrandInitConfigWC.uin = a.getUin();
    boolean bool = com.tencent.mm.plugin.appbrand.app.g.auK().aJ(paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC.gXd);
    if (com.tencent.mm.plugin.appbrand.app.g.auL().aG(paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC.gXd)) {
      paramAppBrandStatObject.iFX = 1;
    }
    for (;;)
    {
      if (paramAppBrandInitConfigWC.vY()) {
        ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.boots.a.c.class)).rQ(com.tencent.mm.plugin.boots.a.b.jRI);
      }
      if (!paramAppBrandInitConfigWC.hiD)
      {
        ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.boots.a.c.class)).rQ(com.tencent.mm.plugin.boots.a.b.jRK);
        if (!paramAppBrandInitConfigWC.vY()) {
          ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.boots.a.c.class)).rQ(com.tencent.mm.plugin.boots.a.b.jRL);
        }
      }
      AppMethodBeat.o(131717);
      return;
      if (bool) {
        paramAppBrandStatObject.iFX = 2;
      } else {
        paramAppBrandStatObject.iFX = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c
 * JD-Core Version:    0.7.0.1
 */