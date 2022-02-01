package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalUIAnimationStyle;", "", "()V", "setOpenAnimation", "", "activity", "Landroid/app/Activity;", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "plugin-appbrand-integration_release"})
public final class k
{
  public static final k kPD;
  
  static
  {
    AppMethodBeat.i(50877);
    kPD = new k();
    AppMethodBeat.o(50877);
  }
  
  public static final boolean a(Activity paramActivity, AppBrandInitConfig paramAppBrandInitConfig, AppBrandStatObject paramAppBrandStatObject)
  {
    bool2 = false;
    AppMethodBeat.i(50876);
    d.g.b.k.h(paramActivity, "activity");
    d.g.b.k.h(paramAppBrandInitConfig, "config");
    d.g.b.k.h(paramAppBrandStatObject, "stat");
    if (!(paramAppBrandInitConfig instanceof AppBrandInitConfigWC))
    {
      AppMethodBeat.o(50876);
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
    AppMethodBeat.o(50876);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.k
 * JD-Core Version:    0.7.0.1
 */