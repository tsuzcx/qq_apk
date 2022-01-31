package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ad;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.sdk.platformtools.ah;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLaunchInterceptor;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWCFactory;", "()V", "matchLaunchScene", "", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "scene", "", "shouldInterceptLaunch", "_context", "Landroid/content/Context;", "shouldOverrideRuntimeInitialization", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "container", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "plugin-appbrand-integration_release"})
public final class f
  implements q
{
  public static final f ioC;
  
  static
  {
    AppMethodBeat.i(134741);
    ioC = new f();
    AppMethodBeat.o(134741);
  }
  
  public static final boolean c(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(134738);
    a.f.b.j.q(paramAppBrandInitConfigWC, "config");
    a.f.b.j.q(paramAppBrandStatObject, "stat");
    Context localContext;
    if (d(paramAppBrandInitConfigWC, paramAppBrandStatObject))
    {
      h.EU(paramAppBrandInitConfigWC.appId);
      localContext = paramContext;
      if (paramContext == null) {
        localContext = ah.getContext();
      }
      paramContext = new Intent();
      paramContext.setClass(localContext, AppBrandPluginUI.class);
      if (!(localContext instanceof Activity)) {
        paramContext.addFlags(268435456);
      }
      paramContext.putExtra("key_launch_app_client_version", com.tencent.mm.sdk.platformtools.f.ymG);
      paramContext.putExtra("key_appbrand_init_config", (Parcelable)paramAppBrandInitConfigWC);
      paramContext.putExtra("key_appbrand_stat_object", (Parcelable)paramAppBrandStatObject);
      localContext.startActivity(paramContext);
      if ((localContext instanceof Activity)) {
        break label147;
      }
    }
    label147:
    for (paramContext = null;; paramContext = localContext)
    {
      paramContext = (Activity)paramContext;
      if (paramContext != null) {
        paramContext.overridePendingTransition(0, 0);
      }
      AppMethodBeat.o(134738);
      return true;
      AppMethodBeat.o(134738);
      return false;
    }
  }
  
  public static final boolean d(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(134740);
    a.f.b.j.q(paramAppBrandInitConfigWC, "config");
    a.f.b.j.q(paramAppBrandStatObject, "stat");
    if (1111 == paramAppBrandStatObject.scene)
    {
      AppMethodBeat.o(134740);
      return true;
    }
    AppMethodBeat.o(134740);
    return false;
  }
  
  public static final boolean oN(int paramInt)
  {
    return 1111 == paramInt;
  }
  
  public final o a(AppBrandInitConfigWC paramAppBrandInitConfigWC, com.tencent.mm.plugin.appbrand.l paraml)
  {
    AppMethodBeat.i(134739);
    a.f.b.j.q(paramAppBrandInitConfigWC, "config");
    a.f.b.j.q(paraml, "container");
    AppBrandStatObject localAppBrandStatObject = paramAppBrandInitConfigWC.vX();
    a.f.b.j.p(localAppBrandStatObject, "config.statObject");
    if (d(paramAppBrandInitConfigWC, localAppBrandStatObject))
    {
      paramAppBrandInitConfigWC = (o)new j(paraml.getContext(), (ad)paraml);
      AppMethodBeat.o(134739);
      return paramAppBrandInitConfigWC;
    }
    AppMethodBeat.o(134739);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.f
 * JD-Core Version:    0.7.0.1
 */