package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.xweb.WebView;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import org.xwalk.core.XWalkCoreWrapper;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/AppBrandPersistentRuntimeConfig;", "", "()V", "KEY_XWEB_INSTALLED", "", "PERSISTENT_UI_CLASS", "", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPluginUI;", "[Ljava/lang/Class;", "TAG", "canKeepPersistent", "", "container", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "isPersistentConfigOpen", "isPersistentXWebConfigOpen", "watchApp", "", "app", "Landroid/app/Application;", "plugin-appbrand-integration_release"})
public final class h
{
  private static final Class<AppBrandPluginUI>[] jwu;
  public static final h jwv;
  
  static
  {
    AppMethodBeat.i(50136);
    jwv = new h();
    jwu = new Class[] { AppBrandPluginUI.class };
    AppMethodBeat.o(50136);
  }
  
  public static final boolean a(AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    AppMethodBeat.i(50133);
    p.h(paramAppBrandRuntimeContainerWC, "container");
    paramAppBrandRuntimeContainerWC = paramAppBrandRuntimeContainerWC.getActivity();
    Boolean[] arrayOfBoolean = new Boolean[2];
    arrayOfBoolean[0] = Boolean.valueOf(WebView.isX5());
    if ((WebView.isXWalk()) && (XWalkCoreWrapper.getInstance().hasFeature(2003))) {}
    for (boolean bool = true;; bool = false)
    {
      arrayOfBoolean[1] = Boolean.valueOf(bool);
      ad.i("MicroMsg.AppBrandPersistentRuntimeConfig", "canKeepPersistent, containerUI[" + paramAppBrandRuntimeContainerWC.getClass().getSimpleName() + "], kernelConditions[" + org.apache.commons.b.a.toString(arrayOfBoolean) + ']');
      if ((!org.apache.commons.b.a.contains(jwu, paramAppBrandRuntimeContainerWC.getClass())) || (!org.apache.commons.b.a.contains(arrayOfBoolean, Boolean.TRUE))) {
        break;
      }
      AppMethodBeat.o(50133);
      return true;
    }
    AppMethodBeat.o(50133);
    return false;
  }
  
  public static final boolean aVH()
  {
    AppMethodBeat.i(50135);
    boolean bool = ax.aQz("MicroMsg.AppBrandPersistentRuntimeConfig").getBoolean("KEY_XWEB_INSTALLED", false);
    AppMethodBeat.o(50135);
    return bool;
  }
  
  public static final void i(Application paramApplication)
  {
    AppMethodBeat.i(50134);
    p.h(paramApplication, "app");
    a locala = a.jww;
    paramApplication.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new b());
    new c().alive();
    AppMethodBeat.o(50134);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"checkSaveXWebInstallState", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    public static final a jww;
    
    static
    {
      AppMethodBeat.i(50130);
      jww = new a();
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
        ax.aQz("MicroMsg.AppBrandPersistentRuntimeConfig").putBoolean("KEY_XWEB_INSTALLED", XWalkCoreWrapper.getInstance().hasFeature(2003)).commit();
      }
      AppMethodBeat.o(50129);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/AppBrandPersistentRuntimeConfig$watchApp$2", "Lcom/tencent/mm/plugin/appbrand/util/ActivityLifecycleCallbacksAdapter;", "onActivityStarted", "", "activity", "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
  public static final class b
    extends com.tencent.mm.plugin.appbrand.z.a
  {
    public final void onActivityStarted(Activity paramActivity)
    {
      AppMethodBeat.i(50131);
      if ((paramActivity instanceof AppBrandUI))
      {
        paramActivity = h.a.jww;
        h.a.invoke();
      }
      AppMethodBeat.o(50131);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/AppBrandPersistentRuntimeConfig$watchApp$3", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/XWebViewInitCompleteEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class c
    extends c<zt>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h
 * JD-Core Version:    0.7.0.1
 */