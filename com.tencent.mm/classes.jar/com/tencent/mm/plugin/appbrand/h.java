package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yw;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.xweb.WebView;
import d.g.b.k;
import d.y;
import org.xwalk.core.XWalkCoreWrapper;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/AppBrandPersistentRuntimeConfig;", "", "()V", "KEY_XWEB_INSTALLED", "", "PERSISTENT_UI_CLASS", "", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPluginUI;", "[Ljava/lang/Class;", "TAG", "canKeepPersistent", "", "container", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "isPersistentConfigOpen", "isPersistentXWebConfigOpen", "watchApp", "", "app", "Landroid/app/Application;", "plugin-appbrand-integration_release"})
public final class h
{
  private static final Class<AppBrandPluginUI>[] jdl;
  public static final h jdm;
  
  static
  {
    AppMethodBeat.i(50136);
    jdm = new h();
    jdl = new Class[] { AppBrandPluginUI.class };
    AppMethodBeat.o(50136);
  }
  
  public static final boolean a(AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    AppMethodBeat.i(50133);
    k.h(paramAppBrandRuntimeContainerWC, "container");
    paramAppBrandRuntimeContainerWC = paramAppBrandRuntimeContainerWC.getActivity();
    Boolean[] arrayOfBoolean = new Boolean[2];
    arrayOfBoolean[0] = Boolean.valueOf(WebView.isX5());
    if ((WebView.isXWalk()) && (XWalkCoreWrapper.getInstance().hasFeature(2003))) {}
    for (boolean bool = true;; bool = false)
    {
      arrayOfBoolean[1] = Boolean.valueOf(bool);
      ac.i("MicroMsg.AppBrandPersistentRuntimeConfig", "canKeepPersistent, containerUI[" + paramAppBrandRuntimeContainerWC.getClass().getSimpleName() + "], kernelConditions[" + org.apache.commons.b.a.toString(arrayOfBoolean) + ']');
      if ((!org.apache.commons.b.a.contains(jdl, paramAppBrandRuntimeContainerWC.getClass())) || (!org.apache.commons.b.a.contains(arrayOfBoolean, Boolean.TRUE))) {
        break;
      }
      AppMethodBeat.o(50133);
      return true;
    }
    AppMethodBeat.o(50133);
    return false;
  }
  
  public static final boolean aSv()
  {
    AppMethodBeat.i(50135);
    boolean bool = aw.aKT("MicroMsg.AppBrandPersistentRuntimeConfig").getBoolean("KEY_XWEB_INSTALLED", false);
    AppMethodBeat.o(50135);
    return bool;
  }
  
  public static final void g(Application paramApplication)
  {
    AppMethodBeat.i(50134);
    k.h(paramApplication, "app");
    a locala = a.jdn;
    paramApplication.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new b());
    new c().alive();
    AppMethodBeat.o(50134);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"checkSaveXWebInstallState", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final a jdn;
    
    static
    {
      AppMethodBeat.i(50130);
      jdn = new a();
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
        aw.aKT("MicroMsg.AppBrandPersistentRuntimeConfig").putBoolean("KEY_XWEB_INSTALLED", XWalkCoreWrapper.getInstance().hasFeature(2003)).commit();
      }
      AppMethodBeat.o(50129);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/AppBrandPersistentRuntimeConfig$watchApp$2", "Lcom/tencent/mm/plugin/appbrand/util/ActivityLifecycleCallbacksAdapter;", "onActivityStarted", "", "activity", "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
  public static final class b
    extends com.tencent.mm.plugin.appbrand.z.a
  {
    public final void onActivityStarted(Activity paramActivity)
    {
      AppMethodBeat.i(50131);
      if ((paramActivity instanceof AppBrandUI))
      {
        paramActivity = h.a.jdn;
        h.a.invoke();
      }
      AppMethodBeat.o(50131);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/AppBrandPersistentRuntimeConfig$watchApp$3", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/XWebViewInitCompleteEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class c
    extends c<yw>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h
 * JD-Core Version:    0.7.0.1
 */