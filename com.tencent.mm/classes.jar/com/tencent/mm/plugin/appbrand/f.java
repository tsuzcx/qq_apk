package com.tencent.mm.plugin.appbrand;

import a.f.b.j;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.weishi.AppBrandWeishiUI;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.xweb.WebView;
import org.xwalk.core.XWalkCoreWrapper;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/AppBrandPersistentRuntimeConfig;", "", "()V", "KEY_XWEB_INSTALLED", "", "PERSISTENT_UI_CLASS", "", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPluginUI;", "[Ljava/lang/Class;", "TAG", "canKeepPersistent", "", "container", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "isPersistentConfigOpen", "isPersistentXWebConfigOpen", "watchApp", "", "app", "Landroid/app/Application;", "plugin-appbrand-integration_release"})
public final class f
{
  private static final Class<? extends AppBrandPluginUI>[] gPo;
  public static final f gPp;
  
  static
  {
    AppMethodBeat.i(143714);
    gPp = new f();
    gPo = new Class[] { AppBrandPluginUI.class, AppBrandWeishiUI.class };
    AppMethodBeat.o(143714);
  }
  
  public static final boolean a(l paraml)
  {
    AppMethodBeat.i(143710);
    j.q(paraml, "container");
    if (!atd())
    {
      ab.i("MicroMsg.AppBrandPersistentRuntimeConfig", "canKeepPersistent, close by ExptService");
      AppMethodBeat.o(143710);
      return false;
    }
    Boolean[] arrayOfBoolean = new Boolean[2];
    arrayOfBoolean[0] = Boolean.valueOf(WebView.isX5());
    if ((WebView.isXWalk()) && (XWalkCoreWrapper.getInstance().hasFeature(2003))) {}
    for (boolean bool = true;; bool = false)
    {
      arrayOfBoolean[1] = Boolean.valueOf(bool);
      ab.i("MicroMsg.AppBrandPersistentRuntimeConfig", "canKeepPersistent, containerUI[" + paraml.getContext().getClass().getSimpleName() + "], kernelConditions[" + org.apache.commons.b.a.toString(arrayOfBoolean) + ']');
      if ((!org.apache.commons.b.a.contains(gPo, paraml.getContext().getClass())) || (!org.apache.commons.b.a.contains(arrayOfBoolean, Boolean.TRUE))) {
        break;
      }
      AppMethodBeat.o(143710);
      return true;
    }
    AppMethodBeat.o(143710);
    return false;
  }
  
  public static final boolean atc()
  {
    AppMethodBeat.i(143712);
    if (!atd())
    {
      ab.i("MicroMsg.AppBrandPersistentRuntimeConfig", "isPersistentXWebConfigOpen, close by ExptService");
      AppMethodBeat.o(143712);
      return false;
    }
    boolean bool = as.eu("MicroMsg.AppBrandPersistentRuntimeConfig", 2).getBoolean("KEY_XWEB_INSTALLED", false);
    AppMethodBeat.o(143712);
    return bool;
  }
  
  private static boolean atd()
  {
    AppMethodBeat.i(143713);
    if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVt, 1) > 0)
    {
      AppMethodBeat.o(143713);
      return true;
    }
    AppMethodBeat.o(143713);
    return false;
  }
  
  public static final void e(Application paramApplication)
  {
    AppMethodBeat.i(143711);
    j.q(paramApplication, "app");
    f.a locala = f.a.gPq;
    paramApplication.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new f.b());
    new f.c().alive();
    AppMethodBeat.o(143711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.f
 * JD-Core Version:    0.7.0.1
 */