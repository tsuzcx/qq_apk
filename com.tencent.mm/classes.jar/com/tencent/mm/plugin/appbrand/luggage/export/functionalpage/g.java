package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.task.i.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.x;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLaunchInterceptor;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWCFactory;", "()V", "matchLaunchScene", "", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "scene", "", "shouldInterceptLaunch", "_context", "Landroid/content/Context;", "shouldOverrideRuntimeInitialization", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "container", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements x
{
  public static final g tfQ;
  
  static
  {
    AppMethodBeat.i(50870);
    tfQ = new g();
    AppMethodBeat.o(50870);
  }
  
  public static final boolean Ci(int paramInt)
  {
    return 1111 == paramInt;
  }
  
  public static final boolean c(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(50867);
    s.u(paramAppBrandInitConfigWC, "config");
    s.u(paramAppBrandStatObject, "stat");
    if (d(paramAppBrandInitConfigWC, paramAppBrandStatObject))
    {
      Object localObject1 = i.tWq;
      localObject1 = i.a.cJV();
      int i = paramAppBrandInitConfigWC.epc;
      Object localObject2 = paramAppBrandInitConfigWC.appId;
      s.s(localObject2, "config.appId");
      ((i)localObject1).l(i, (String)localObject2);
      if (com.tencent.mm.plugin.appbrand.utils.ah.m(paramAppBrandInitConfigWC)) {
        localObject1 = com.tencent.mm.plugin.appbrand.utils.ah.l(paramAppBrandInitConfigWC);
      }
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
            paramAppBrandInitConfigWC.fk((String)localObject2);
            paramAppBrandInitConfigWC.qYm = new QualitySession(paramAppBrandInitConfigWC.eoQ, paramAppBrandInitConfigWC, paramAppBrandStatObject);
          }
          localObject1 = ((JSONObject)localObject1).optString("sessionId", "");
          localObject2 = (CharSequence)localObject1;
          if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
            break label381;
          }
          i = 1;
          if (i == 0) {
            paramAppBrandInitConfigWC.ff((String)localObject1);
          }
          if (paramContext != null) {
            break label386;
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
          paramAppBrandInitConfigWC = kotlin.ah.aiuX;
          paramAppBrandInitConfigWC = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramAppBrandInitConfigWC.aYi(), "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLaunchInterceptor", "shouldInterceptLaunch", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramAppBrandInitConfigWC.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLaunchInterceptor", "shouldInterceptLaunch", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          if (!(paramContext instanceof Activity)) {
            break label389;
          }
          paramContext = (Activity)paramContext;
          if (paramContext != null) {
            paramContext.overridePendingTransition(0, 0);
          }
          AppMethodBeat.o(50867);
          return true;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          JSONObject localJSONObject = new JSONObject();
          continue;
          i = 0;
          continue;
          label381:
          i = 0;
          continue;
          label386:
          continue;
          label389:
          paramContext = null;
        }
      }
    }
    AppMethodBeat.o(50867);
    return false;
  }
  
  public static final boolean d(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(50869);
    s.u(paramAppBrandInitConfigWC, "config");
    s.u(paramAppBrandStatObject, "stat");
    boolean bool = Ci(paramAppBrandStatObject.scene);
    AppMethodBeat.o(50869);
    return bool;
  }
  
  public final w b(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    AppMethodBeat.i(50868);
    s.u(paramAppBrandInitConfigWC, "config");
    s.u(paramAppBrandRuntimeContainerWC, "container");
    AppBrandStatObject localAppBrandStatObject = paramAppBrandInitConfigWC.epn;
    s.s(localAppBrandStatObject, "config.statObject");
    if (d(paramAppBrandInitConfigWC, localAppBrandStatObject))
    {
      paramAppBrandInitConfigWC = (w)new l(paramAppBrandRuntimeContainerWC);
      AppMethodBeat.o(50868);
      return paramAppBrandInitConfigWC;
    }
    AppMethodBeat.o(50868);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g
 * JD-Core Version:    0.7.0.1
 */