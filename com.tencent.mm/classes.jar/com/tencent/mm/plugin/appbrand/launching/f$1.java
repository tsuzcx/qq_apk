package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.f;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.k;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class f$1
  implements Runnable
{
  f$1(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(131770);
    Context localContext = this.val$context;
    AppBrandInitConfigWC localAppBrandInitConfigWC = this.ikC;
    AppBrandStatObject localAppBrandStatObject = this.ikD;
    localAppBrandInitConfigWC.hiE = bo.aoy();
    if (f.c(localContext, localAppBrandInitConfigWC, localAppBrandStatObject))
    {
      if ((localContext instanceof Activity))
      {
        localAppBrandInitConfigWC.bDh = localAppBrandStatObject;
        k.a((Activity)localContext, localAppBrandInitConfigWC, localAppBrandStatObject);
      }
      ab.i("MicroMsg.AppBrand.AppLaunchLogic", "startAppImpl [applaunch] start functional runtime, config[%s]", new Object[] { localAppBrandInitConfigWC });
      AppMethodBeat.o(131770);
      return;
    }
    int i = com.tencent.mm.plugin.appbrand.task.h.d(localContext, localAppBrandInitConfigWC, localAppBrandStatObject);
    if ((localContext instanceof Activity))
    {
      localAppBrandInitConfigWC.bDh = localAppBrandStatObject;
      ((s)e.q(s.class)).a((Activity)localContext, localAppBrandInitConfigWC);
    }
    ab.i("MicroMsg.AppBrand.AppLaunchLogic", "[applaunch] startAppOnInitConfigGot %s", new Object[] { localAppBrandInitConfigWC });
    if (i == 1)
    {
      new g(localAppBrandInitConfigWC, localAppBrandStatObject).aGK();
      com.tencent.mm.plugin.report.service.h.qsU.cT(369, 21);
    }
    AppMethodBeat.o(131770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.f.1
 * JD-Core Version:    0.7.0.1
 */