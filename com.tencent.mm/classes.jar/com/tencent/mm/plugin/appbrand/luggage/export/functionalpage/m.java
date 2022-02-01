package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.ui.MMFragmentActivity.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalUIAnimationStyle;", "", "()V", "setOpenAnimation", "", "activity", "Landroid/app/Activity;", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public static final m tgb;
  
  static
  {
    AppMethodBeat.i(50877);
    tgb = new m();
    AppMethodBeat.o(50877);
  }
  
  public static final boolean a(Activity paramActivity, AppBrandInitConfig paramAppBrandInitConfig, AppBrandStatObject paramAppBrandStatObject)
  {
    bool2 = false;
    AppMethodBeat.i(50876);
    s.u(paramActivity, "activity");
    s.u(paramAppBrandInitConfig, "config");
    s.u(paramAppBrandStatObject, "stat");
    if (!(paramAppBrandInitConfig instanceof AppBrandInitConfigWC))
    {
      AppMethodBeat.o(50876);
      return false;
    }
    bool1 = bool2;
    try
    {
      if (g.d((AppBrandInitConfigWC)paramAppBrandInitConfig, paramAppBrandStatObject))
      {
        paramActivity.overridePendingTransition(MMFragmentActivity.a.upU, MMFragmentActivity.a.upV);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.m
 * JD-Core Version:    0.7.0.1
 */