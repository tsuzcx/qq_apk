package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.utils.aa;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLaunchInterceptor;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWCFactory;", "()V", "matchLaunchScene", "", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "scene", "", "shouldInterceptLaunch", "_context", "Landroid/content/Context;", "shouldOverrideRuntimeInitialization", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "container", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "plugin-appbrand-integration_release"})
public final class g
  implements r
{
  public static final g nav;
  
  static
  {
    AppMethodBeat.i(50870);
    nav = new g();
    AppMethodBeat.o(50870);
  }
  
  public static final boolean c(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(50867);
    kotlin.g.b.p.h(paramAppBrandInitConfigWC, "config");
    kotlin.g.b.p.h(paramAppBrandStatObject, "stat");
    Object localObject1;
    if (e(paramAppBrandInitConfigWC, paramAppBrandStatObject))
    {
      h.bWb().afe(paramAppBrandInitConfigWC.appId);
      if (aa.n(paramAppBrandInitConfigWC)) {
        localObject1 = aa.m(paramAppBrandInitConfigWC);
      }
    }
    label369:
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        Object localObject2 = ((JSONObject)localObject1).optString("instanceId", "");
        CharSequence localCharSequence = (CharSequence)localObject2;
        if ((localCharSequence == null) || (localCharSequence.length() == 0))
        {
          i = 1;
          if (i == 0)
          {
            paramAppBrandInitConfigWC.dC((String)localObject2);
            paramAppBrandInitConfigWC.ldW = new QualitySession(paramAppBrandInitConfigWC.NC(), paramAppBrandInitConfigWC, paramAppBrandStatObject);
          }
          localObject1 = ((JSONObject)localObject1).optString("sessionId", "");
          localObject2 = (CharSequence)localObject1;
          if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
            continue;
          }
          i = 1;
          if (i == 0) {
            paramAppBrandInitConfigWC.dB((String)localObject1);
          }
          if (paramContext != null) {
            break label369;
          }
          paramContext = MMApplicationContext.getContext();
          localObject1 = new Intent();
          ((Intent)localObject1).setClass(paramContext, AppBrandPluginUI.class);
          if (!(paramContext instanceof Activity)) {
            ((Intent)localObject1).addFlags(268435456);
          }
          ((Intent)localObject1).putExtra("key_launch_app_client_version", BuildInfo.CLIENT_VERSION_INT);
          ((Intent)localObject1).putExtra("key_appbrand_init_config", (Parcelable)paramAppBrandInitConfigWC);
          ((Intent)localObject1).putExtra("key_appbrand_stat_object", (Parcelable)paramAppBrandStatObject);
          paramAppBrandInitConfigWC = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramAppBrandInitConfigWC.axQ(), "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLaunchInterceptor", "shouldInterceptLaunch", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramAppBrandInitConfigWC.pG(0));
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
        }
      }
      catch (Exception localException)
      {
        JSONObject localJSONObject = new JSONObject();
        continue;
        int i = 0;
        continue;
        i = 0;
        continue;
      }
      AppMethodBeat.o(50867);
      return false;
    }
  }
  
  public static final boolean e(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(50869);
    kotlin.g.b.p.h(paramAppBrandInitConfigWC, "config");
    kotlin.g.b.p.h(paramAppBrandStatObject, "stat");
    boolean bool = yt(paramAppBrandStatObject.scene);
    AppMethodBeat.o(50869);
    return bool;
  }
  
  public static final boolean yt(int paramInt)
  {
    return 1111 == paramInt;
  }
  
  public final q b(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    AppMethodBeat.i(50868);
    kotlin.g.b.p.h(paramAppBrandInitConfigWC, "config");
    kotlin.g.b.p.h(paramAppBrandRuntimeContainerWC, "container");
    AppBrandStatObject localAppBrandStatObject = paramAppBrandInitConfigWC.Nz();
    kotlin.g.b.p.g(localAppBrandStatObject, "config.statObject");
    if (e(paramAppBrandInitConfigWC, localAppBrandStatObject))
    {
      paramAppBrandInitConfigWC = (q)new l(paramAppBrandRuntimeContainerWC);
      AppMethodBeat.o(50868);
      return paramAppBrandInitConfigWC;
    }
    AppMethodBeat.o(50868);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g
 * JD-Core Version:    0.7.0.1
 */