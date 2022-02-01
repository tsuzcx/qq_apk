package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.h;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLaunchInterceptor;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWCFactory;", "()V", "matchLaunchScene", "", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "scene", "", "shouldInterceptLaunch", "_context", "Landroid/content/Context;", "shouldOverrideRuntimeInitialization", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "container", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "plugin-appbrand-integration_release"})
public final class f
  implements p
{
  public static final f kPv;
  
  static
  {
    AppMethodBeat.i(50870);
    kPv = new f();
    AppMethodBeat.o(50870);
  }
  
  public static final boolean c(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(50867);
    k.h(paramAppBrandInitConfigWC, "config");
    k.h(paramAppBrandStatObject, "stat");
    if (d(paramAppBrandInitConfigWC, paramAppBrandStatObject))
    {
      com.tencent.mm.plugin.appbrand.task.f.MK(paramAppBrandInitConfigWC.appId);
      if (paramContext != null) {
        break label202;
      }
      paramContext = aj.getContext();
    }
    label202:
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.setClass(paramContext, AppBrandPluginUI.class);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      localIntent.putExtra("key_launch_app_client_version", h.ETr);
      localIntent.putExtra("key_appbrand_init_config", (Parcelable)paramAppBrandInitConfigWC);
      localIntent.putExtra("key_appbrand_stat_object", (Parcelable)paramAppBrandStatObject);
      paramAppBrandInitConfigWC = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramAppBrandInitConfigWC.adn(), "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLaunchInterceptor", "shouldInterceptLaunch", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramAppBrandInitConfigWC.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLaunchInterceptor", "shouldInterceptLaunch", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramAppBrandInitConfigWC = paramContext;
      if (!(paramContext instanceof Activity)) {
        paramAppBrandInitConfigWC = null;
      }
      paramContext = (Activity)paramAppBrandInitConfigWC;
      if (paramContext != null) {
        paramContext.overridePendingTransition(0, 0);
      }
      AppMethodBeat.o(50867);
      return true;
      AppMethodBeat.o(50867);
      return false;
    }
  }
  
  public static final boolean d(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(50869);
    k.h(paramAppBrandInitConfigWC, "config");
    k.h(paramAppBrandStatObject, "stat");
    boolean bool = tb(paramAppBrandStatObject.scene);
    AppMethodBeat.o(50869);
    return bool;
  }
  
  public static final boolean tb(int paramInt)
  {
    return 1111 == paramInt;
  }
  
  public final o c(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    AppMethodBeat.i(50868);
    k.h(paramAppBrandInitConfigWC, "config");
    k.h(paramAppBrandRuntimeContainerWC, "container");
    AppBrandStatObject localAppBrandStatObject = paramAppBrandInitConfigWC.CY();
    k.g(localAppBrandStatObject, "config.statObject");
    if (d(paramAppBrandInitConfigWC, localAppBrandStatObject))
    {
      paramAppBrandInitConfigWC = (o)new j(paramAppBrandRuntimeContainerWC);
      AppMethodBeat.o(50868);
      return paramAppBrandInitConfigWC;
    }
    AppMethodBeat.o(50868);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.f
 * JD-Core Version:    0.7.0.1
 */