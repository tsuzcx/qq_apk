package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import a.f.b.j;
import a.l;
import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalUIAnimationStyle;", "", "()V", "setOpenAnimation", "", "activity", "Landroid/app/Activity;", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "plugin-appbrand-integration_release"})
public final class k
{
  public static final k ioL;
  
  static
  {
    AppMethodBeat.i(134748);
    ioL = new k();
    AppMethodBeat.o(134748);
  }
  
  public static final boolean a(Activity paramActivity, AppBrandInitConfig paramAppBrandInitConfig, AppBrandStatObject paramAppBrandStatObject)
  {
    bool2 = false;
    AppMethodBeat.i(134747);
    j.q(paramActivity, "activity");
    j.q(paramAppBrandInitConfig, "config");
    j.q(paramAppBrandStatObject, "stat");
    if (!(paramAppBrandInitConfig instanceof AppBrandInitConfigWC))
    {
      AppMethodBeat.o(134747);
      return false;
    }
    bool1 = bool2;
    try
    {
      if (f.d((AppBrandInitConfigWC)paramAppBrandInitConfig, paramAppBrandStatObject))
      {
        paramActivity.overridePendingTransition(0, 0);
        bool1 = true;
      }
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(134747);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.k
 * JD-Core Version:    0.7.0.1
 */