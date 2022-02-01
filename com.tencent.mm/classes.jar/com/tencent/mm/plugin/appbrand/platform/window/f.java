package com.tencent.mm.plugin.appbrand.platform.window;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplProxy;", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "base", "windowViewImplScope", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;)V", "getBase", "()Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "getWindowViewImplScope", "()Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;", "compareTo", "", "other", "createFullscreenHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler;", "provider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", "forceLightMode", "", "getContext", "Landroid/content/Context;", "getNavigationBar", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowNavigationBar;", "getOrientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "getSafeAreaInsets", "Landroid/graphics/Rect;", "getScale", "", "getStatusBar", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowStatusBar;", "getVDisplayMetrics", "Landroid/util/DisplayMetrics;", "isInMultiWindowMode", "isLargeScreenWindow", "runInStandaloneTask", "setSoftOrientation", "", "name", "", "setWindowBackgroundColor", "backgroundColor", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "setWindowDescription", "description", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowDescription;", "setWindowLayoutParams", "params", "Lcom/tencent/mm/plugin/appbrand/platform/window/WxaWindowLayoutParams;", "shouldInLargeScreenCompatMode", "luggage-wxa-app_release"})
public final class f
  implements c
{
  public final c nEu;
  public final g nEv;
  
  public f(c paramc, g paramg)
  {
    AppMethodBeat.i(219768);
    this.nEu = paramc;
    this.nEv = paramg;
    AppMethodBeat.o(219768);
  }
  
  public final boolean OD()
  {
    AppMethodBeat.i(219760);
    boolean bool = this.nEv.OD();
    AppMethodBeat.o(219760);
    return bool;
  }
  
  public final boolean OG()
  {
    AppMethodBeat.i(219767);
    boolean bool = this.nEv.OG();
    AppMethodBeat.o(219767);
    return bool;
  }
  
  public final d a(d.b paramb)
  {
    AppMethodBeat.i(219757);
    d locald = this.nEv.a(paramb);
    if (locald != null)
    {
      AppMethodBeat.o(219757);
      return locald;
    }
    paramb = this.nEu.a(paramb);
    p.g(paramb, "base.createFullscreenHandler(provider)");
    AppMethodBeat.o(219757);
    return paramb;
  }
  
  public final void a(int paramInt, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(219765);
    p.h(paramAppBrandRuntime, "runtime");
    this.nEu.a(paramInt, paramAppBrandRuntime);
    AppMethodBeat.o(219765);
  }
  
  public final void a(WxaWindowLayoutParams paramWxaWindowLayoutParams, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(219764);
    p.h(paramWxaWindowLayoutParams, "params");
    p.h(paramAppBrandRuntime, "runtime");
    this.nEu.a(paramWxaWindowLayoutParams, paramAppBrandRuntime);
    AppMethodBeat.o(219764);
  }
  
  public final boolean bsc()
  {
    AppMethodBeat.i(219752);
    boolean bool = this.nEu.bsc();
    AppMethodBeat.o(219752);
    return bool;
  }
  
  public final boolean bsj()
  {
    AppMethodBeat.i(219754);
    boolean bool = this.nEu.bsj();
    AppMethodBeat.o(219754);
    return bool;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(219751);
    Context localContext = this.nEu.getContext();
    p.g(localContext, "base.context");
    AppMethodBeat.o(219751);
    return localContext;
  }
  
  public final e getOrientationHandler()
  {
    AppMethodBeat.i(219756);
    e locale = this.nEv.getOrientationHandler();
    if (locale != null)
    {
      AppMethodBeat.o(219756);
      return locale;
    }
    locale = this.nEu.getOrientationHandler();
    p.g(locale, "base.orientationHandler");
    AppMethodBeat.o(219756);
    return locale;
  }
  
  public final Rect getSafeAreaInsets()
  {
    AppMethodBeat.i(219762);
    Rect localRect = this.nEu.getSafeAreaInsets();
    AppMethodBeat.o(219762);
    return localRect;
  }
  
  public final float getScale()
  {
    AppMethodBeat.i(219758);
    float f = this.nEv.getScale();
    AppMethodBeat.o(219758);
    return f;
  }
  
  public final c.c getStatusBar()
  {
    AppMethodBeat.i(219761);
    c.c localc = this.nEv.getStatusBar();
    AppMethodBeat.o(219761);
    return localc;
  }
  
  public final DisplayMetrics getVDisplayMetrics()
  {
    AppMethodBeat.i(219753);
    DisplayMetrics localDisplayMetrics = this.nEv.getVDisplayMetrics();
    p.g(localDisplayMetrics, "windowViewImplScope.vDisplayMetrics");
    AppMethodBeat.o(219753);
    return localDisplayMetrics;
  }
  
  public final boolean isInMultiWindowMode()
  {
    AppMethodBeat.i(219755);
    boolean bool = this.nEu.isInMultiWindowMode();
    AppMethodBeat.o(219755);
    return bool;
  }
  
  public final void setSoftOrientation(String paramString)
  {
    AppMethodBeat.i(219759);
    p.h(paramString, "name");
    this.nEv.setSoftOrientation(paramString);
    AppMethodBeat.o(219759);
  }
  
  public final void setWindowDescription(c.a parama)
  {
    AppMethodBeat.i(219763);
    p.h(parama, "description");
    this.nEu.setWindowDescription(parama);
    AppMethodBeat.o(219763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.f
 * JD-Core Version:    0.7.0.1
 */