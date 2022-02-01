package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.task.i.a;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.utils.ac;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLaunchInterceptor;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWCFactory;", "()V", "matchLaunchScene", "", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "scene", "", "shouldInterceptLaunch", "_context", "Landroid/content/Context;", "shouldOverrideRuntimeInitialization", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "container", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "plugin-appbrand-integration_release"})
public final class g
  implements u
{
  public static final g qaK;
  
  static
  {
    AppMethodBeat.i(50870);
    qaK = new g();
    AppMethodBeat.o(50870);
  }
  
  public static final boolean BT(int paramInt)
  {
    return 1111 == paramInt;
  }
  
  public static final boolean c(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(50867);
    p.k(paramAppBrandInitConfigWC, "config");
    p.k(paramAppBrandStatObject, "stat");
    Object localObject1;
    int i;
    Object localObject2;
    if (e(paramAppBrandInitConfigWC, paramAppBrandStatObject))
    {
      localObject1 = i.qRL;
      localObject1 = i.a.cjb();
      i = paramAppBrandInitConfigWC.cxa;
      localObject2 = paramAppBrandInitConfigWC.appId;
      p.j(localObject2, "config.appId");
      ((i)localObject1).l(i, (String)localObject2);
      if (ac.i(paramAppBrandInitConfigWC)) {
        localObject1 = ac.h(paramAppBrandInitConfigWC);
      }
    }
    label393:
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        localObject2 = ((JSONObject)localObject1).optString("instanceId", "");
        CharSequence localCharSequence = (CharSequence)localObject2;
        if ((localCharSequence == null) || (localCharSequence.length() == 0))
        {
          i = 1;
          if (i == 0)
          {
            paramAppBrandInitConfigWC.dW((String)localObject2);
            paramAppBrandInitConfigWC.nYk = new QualitySession(paramAppBrandInitConfigWC.Qx(), paramAppBrandInitConfigWC, paramAppBrandStatObject);
          }
          localObject1 = ((JSONObject)localObject1).optString("sessionId", "");
          localObject2 = (CharSequence)localObject1;
          if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
            continue;
          }
          i = 1;
          if (i == 0) {
            paramAppBrandInitConfigWC.dV((String)localObject1);
          }
          if (paramContext != null) {
            break label393;
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
          paramAppBrandInitConfigWC = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramAppBrandInitConfigWC.aFh(), "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLaunchInterceptor", "shouldInterceptLaunch", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramAppBrandInitConfigWC.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLaunchInterceptor", "shouldInterceptLaunch", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
        i = 0;
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
    p.k(paramAppBrandInitConfigWC, "config");
    p.k(paramAppBrandStatObject, "stat");
    boolean bool = BT(paramAppBrandStatObject.scene);
    AppMethodBeat.o(50869);
    return bool;
  }
  
  public final t b(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    AppMethodBeat.i(50868);
    p.k(paramAppBrandInitConfigWC, "config");
    p.k(paramAppBrandRuntimeContainerWC, "container");
    AppBrandStatObject localAppBrandStatObject = paramAppBrandInitConfigWC.Qu();
    p.j(localAppBrandStatObject, "config.statObject");
    if (e(paramAppBrandInitConfigWC, localAppBrandStatObject))
    {
      paramAppBrandInitConfigWC = (t)new l(paramAppBrandRuntimeContainerWC);
      AppMethodBeat.o(50868);
      return paramAppBrandInitConfigWC;
    }
    AppMethodBeat.o(50868);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g
 * JD-Core Version:    0.7.0.1
 */