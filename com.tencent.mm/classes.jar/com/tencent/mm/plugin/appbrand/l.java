package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI2;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI3;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI4;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.xweb.ao;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/AppBrandPersistentRuntimeConfig;", "", "()V", "KEY_XWEB_INSTALLED", "", "PERSISTENT_UI_CLASS", "", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPluginUI;", "[Ljava/lang/Class;", "TAG", "canKeepPersistent", "", "container", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "isPersistentConfigOpen", "isPersistentXWebConfigOpen", "watchApp", "", "app", "Landroid/app/Application;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l qrP;
  private static final Class<? extends AppBrandPluginUI>[] qrQ;
  
  static
  {
    AppMethodBeat.i(50136);
    qrP = new l();
    qrQ = new Class[] { AppBrandPluginUI.class, AppBrandPluginUI1.class, AppBrandPluginUI2.class, AppBrandPluginUI3.class, AppBrandPluginUI4.class };
    AppMethodBeat.o(50136);
  }
  
  public static final boolean a(AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    AppMethodBeat.i(50133);
    s.u(paramAppBrandRuntimeContainerWC, "container");
    Object localObject = AndroidContextUtil.castActivityOrNull(paramAppBrandRuntimeContainerWC.mContext);
    paramAppBrandRuntimeContainerWC = (AppBrandRuntimeContainerWC)localObject;
    if (localObject == null)
    {
      Log.e("MicroMsg.AppBrandPersistentRuntimeConfig", "canKeepPersistent, container.activity == NULL");
      paramAppBrandRuntimeContainerWC = Boolean.FALSE;
    }
    localObject = new Boolean[2];
    localObject[0] = Boolean.valueOf(ao.kgm());
    if ((ao.kgn()) && (ao.aJB(2003))) {}
    for (boolean bool = true;; bool = false)
    {
      localObject[1] = Boolean.valueOf(bool);
      Log.i("MicroMsg.AppBrandPersistentRuntimeConfig", "canKeepPersistent, containerUI[" + paramAppBrandRuntimeContainerWC.getClass().getSimpleName() + "], kernelConditions[" + org.apache.commons.c.a.ca(localObject) + ']');
      if ((!org.apache.commons.c.a.contains(qrQ, paramAppBrandRuntimeContainerWC.getClass())) || (!org.apache.commons.c.a.contains((Object[])localObject, Boolean.TRUE))) {
        break;
      }
      AppMethodBeat.o(50133);
      return true;
    }
    AppMethodBeat.o(50133);
    return false;
  }
  
  public static final boolean cbn()
  {
    AppMethodBeat.i(50135);
    boolean bool = MultiProcessMMKV.getMMKV("MicroMsg.AppBrandPersistentRuntimeConfig").getBoolean("KEY_XWEB_INSTALLED", false);
    AppMethodBeat.o(50135);
    return bool;
  }
  
  public static final void k(Application paramApplication)
  {
    AppMethodBeat.i(50134);
    s.u(paramApplication, "app");
    paramApplication.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new a());
    new AppBrandPersistentRuntimeConfig.watchApp.2(f.hfK).alive();
    AppMethodBeat.o(50134);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/AppBrandPersistentRuntimeConfig$watchApp$1", "Lcom/tencent/mm/plugin/appbrand/util/ActivityLifecycleCallbacksAdapter;", "onActivityStarted", "", "activity", "Landroid/app/Activity;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends com.tencent.mm.plugin.appbrand.af.a
  {
    public final void onActivityStarted(Activity paramActivity)
    {
      AppMethodBeat.i(316795);
      s.u(paramActivity, "activity");
      if ((paramActivity instanceof AppBrandUI)) {
        l.cbo();
      }
      AppMethodBeat.o(316795);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l
 * JD-Core Version:    0.7.0.1
 */