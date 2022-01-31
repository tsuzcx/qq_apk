package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.boots.a.c;

public final class b
{
  public static void b(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    paramAppBrandInitConfigWC.aee();
    g.DN();
    paramAppBrandInitConfigWC.uin = a.CK();
    boolean bool = e.aaZ().aw(paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC.fEL);
    if (e.aba().at(paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC.fEL)) {
      paramAppBrandStatObject.gXG = 1;
    }
    for (;;)
    {
      if (paramAppBrandInitConfigWC.ZH()) {
        ((c)g.r(c.class)).oc(com.tencent.mm.plugin.boots.a.b.hXN);
      }
      if (!paramAppBrandInitConfigWC.fPs)
      {
        ((c)g.r(c.class)).oc(com.tencent.mm.plugin.boots.a.b.hXP);
        if (!paramAppBrandInitConfigWC.ZH()) {
          ((c)g.r(c.class)).oc(com.tencent.mm.plugin.boots.a.b.hXQ);
        }
      }
      return;
      if (bool) {
        paramAppBrandStatObject.gXG = 2;
      } else {
        paramAppBrandStatObject.gXG = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b
 * JD-Core Version:    0.7.0.1
 */