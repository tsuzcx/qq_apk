package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.j;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLaunchInterceptor;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWCFactory;", "()V", "matchLaunchScene", "", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "scene", "", "shouldInterceptLaunch", "_context", "Landroid/content/Context;", "shouldOverrideRuntimeInitialization", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "container", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "plugin-appbrand-integration_release"})
public final class g
  implements q
{
  public static final g lSU;
  
  static
  {
    AppMethodBeat.i(50870);
    lSU = new g();
    AppMethodBeat.o(50870);
  }
  
  public static final boolean c(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(50867);
    d.g.b.p.h(paramAppBrandInitConfigWC, "config");
    d.g.b.p.h(paramAppBrandStatObject, "stat");
    if (e(paramAppBrandInitConfigWC, paramAppBrandStatObject))
    {
      f.Vl(paramAppBrandInitConfigWC.appId);
      if (paramContext != null) {
        break label202;
      }
      paramContext = ak.getContext();
    }
    label202:
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.setClass(paramContext, AppBrandPluginUI.class);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      localIntent.putExtra("key_launch_app_client_version", j.IwD);
      localIntent.putExtra("key_appbrand_init_config", (Parcelable)paramAppBrandInitConfigWC);
      localIntent.putExtra("key_appbrand_stat_object", (Parcelable)paramAppBrandStatObject);
      paramAppBrandInitConfigWC = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramAppBrandInitConfigWC.ahE(), "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLaunchInterceptor", "shouldInterceptLaunch", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramAppBrandInitConfigWC.mt(0));
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
  
  public static final boolean e(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(50869);
    d.g.b.p.h(paramAppBrandInitConfigWC, "config");
    d.g.b.p.h(paramAppBrandStatObject, "stat");
    boolean bool = uC(paramAppBrandStatObject.scene);
    AppMethodBeat.o(50869);
    return bool;
  }
  
  public static final boolean uC(int paramInt)
  {
    return 1111 == paramInt;
  }
  
  public final com.tencent.mm.plugin.appbrand.p c(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    AppMethodBeat.i(50868);
    d.g.b.p.h(paramAppBrandInitConfigWC, "config");
    d.g.b.p.h(paramAppBrandRuntimeContainerWC, "container");
    AppBrandStatObject localAppBrandStatObject = paramAppBrandInitConfigWC.Ed();
    d.g.b.p.g(localAppBrandStatObject, "config.statObject");
    if (e(paramAppBrandInitConfigWC, localAppBrandStatObject))
    {
      paramAppBrandInitConfigWC = (com.tencent.mm.plugin.appbrand.p)new l(paramAppBrandRuntimeContainerWC);
      AppMethodBeat.o(50868);
      return paramAppBrandInitConfigWC;
    }
    AppMethodBeat.o(50868);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g
 * JD-Core Version:    0.7.0.1
 */