package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.aco;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI2;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI3;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI4;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.xweb.WebView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;
import org.xwalk.core.XWalkCoreWrapper;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/AppBrandPersistentRuntimeConfig;", "", "()V", "KEY_XWEB_INSTALLED", "", "PERSISTENT_UI_CLASS", "", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPluginUI;", "[Ljava/lang/Class;", "TAG", "canKeepPersistent", "", "container", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "isPersistentConfigOpen", "isPersistentXWebConfigOpen", "watchApp", "", "app", "Landroid/app/Application;", "plugin-appbrand-integration_release"})
public final class l
{
  private static final Class<? extends AppBrandPluginUI>[] ntk;
  public static final l ntl;
  
  static
  {
    AppMethodBeat.i(50136);
    ntl = new l();
    ntk = new Class[] { AppBrandPluginUI.class, AppBrandPluginUI1.class, AppBrandPluginUI2.class, AppBrandPluginUI3.class, AppBrandPluginUI4.class };
    AppMethodBeat.o(50136);
  }
  
  public static final boolean a(AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    AppMethodBeat.i(50133);
    p.k(paramAppBrandRuntimeContainerWC, "container");
    Object localObject = paramAppBrandRuntimeContainerWC.getActivity();
    paramAppBrandRuntimeContainerWC = (AppBrandRuntimeContainerWC)localObject;
    if (localObject == null)
    {
      Log.e("MicroMsg.AppBrandPersistentRuntimeConfig", "canKeepPersistent, container.activity == NULL");
      paramAppBrandRuntimeContainerWC = Boolean.FALSE;
    }
    localObject = new Boolean[2];
    localObject[0] = Boolean.valueOf(WebView.isX5());
    if ((WebView.isXWalk()) && (XWalkCoreWrapper.getInstance().hasFeature(2003))) {}
    for (boolean bool = true;; bool = false)
    {
      localObject[1] = Boolean.valueOf(bool);
      Log.i("MicroMsg.AppBrandPersistentRuntimeConfig", "canKeepPersistent, containerUI[" + paramAppBrandRuntimeContainerWC.getClass().getSimpleName() + "], kernelConditions[" + org.apache.commons.b.a.cG(localObject) + ']');
      if ((!org.apache.commons.b.a.contains(ntk, paramAppBrandRuntimeContainerWC.getClass())) || (!org.apache.commons.b.a.contains((Object[])localObject, Boolean.TRUE))) {
        break;
      }
      AppMethodBeat.o(50133);
      return true;
    }
    AppMethodBeat.o(50133);
    return false;
  }
  
  public static final boolean bBR()
  {
    AppMethodBeat.i(50135);
    boolean bool = MultiProcessMMKV.getMMKV("MicroMsg.AppBrandPersistentRuntimeConfig").getBoolean("KEY_XWEB_INSTALLED", false);
    AppMethodBeat.o(50135);
    return bool;
  }
  
  public static final void l(Application paramApplication)
  {
    AppMethodBeat.i(50134);
    p.k(paramApplication, "app");
    a locala = a.ntm;
    paramApplication.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new b());
    new c().alive();
    AppMethodBeat.o(50134);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"checkSaveXWebInstallState", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final a ntm;
    
    static
    {
      AppMethodBeat.i(50130);
      ntm = new a();
      AppMethodBeat.o(50130);
    }
    
    a()
    {
      super();
    }
    
    public static void invoke()
    {
      AppMethodBeat.i(50129);
      if (WebView.isXWalk()) {
        MultiProcessMMKV.getMMKV("MicroMsg.AppBrandPersistentRuntimeConfig").putBoolean("KEY_XWEB_INSTALLED", XWalkCoreWrapper.getInstance().hasFeature(2003)).commit();
      }
      AppMethodBeat.o(50129);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/AppBrandPersistentRuntimeConfig$watchApp$2", "Lcom/tencent/mm/plugin/appbrand/util/ActivityLifecycleCallbacksAdapter;", "onActivityStarted", "", "activity", "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
  public static final class b
    extends com.tencent.mm.plugin.appbrand.ac.a
  {
    public final void onActivityStarted(Activity paramActivity)
    {
      AppMethodBeat.i(50131);
      if ((paramActivity instanceof AppBrandUI))
      {
        paramActivity = l.a.ntm;
        l.a.invoke();
      }
      AppMethodBeat.o(50131);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/AppBrandPersistentRuntimeConfig$watchApp$3", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/XWebViewInitCompleteEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class c
    extends IListener<aco>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l
 * JD-Core Version:    0.7.0.1
 */