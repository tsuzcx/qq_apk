package com.tencent.mm.plugin.appbrand.platform.window;

import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplProxy;", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "base", "windowViewImplScope", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;)V", "getBase", "()Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "getWindowViewImplScope", "()Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;", "compareTo", "", "other", "createFullscreenHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler;", "provider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", "getContext", "Landroid/content/Context;", "getNavigationBar", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowNavigationBar;", "getOrientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "getSafeAreaInsets", "Landroid/graphics/Rect;", "getScale", "", "getStatusBar", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowStatusBar;", "getVDisplayMetrics", "Landroid/util/DisplayMetrics;", "isInMultiWindowMode", "", "isLargeScreenWindow", "runInStandaloneTask", "setSoftOrientation", "", "name", "", "setWindowBackgroundColor", "backgroundColor", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "setWindowDescription", "description", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowDescription;", "setWindowLayoutParams", "params", "Lcom/tencent/mm/plugin/appbrand/platform/window/WxaWindowLayoutParams;", "shouldInLargeScreenCompatMode", "luggage-wxa-app_release"})
public final class f
  implements c
{
  public final c mtM;
  public final g mtN;
  
  public f(c paramc, g paramg)
  {
    AppMethodBeat.i(208150);
    this.mtM = paramc;
    this.mtN = paramg;
    AppMethodBeat.o(208150);
  }
  
  public final boolean EX()
  {
    AppMethodBeat.i(208143);
    boolean bool = this.mtN.EX();
    AppMethodBeat.o(208143);
    return bool;
  }
  
  public final d a(d.b paramb)
  {
    AppMethodBeat.i(208140);
    d locald = this.mtN.a(paramb);
    if (locald != null)
    {
      AppMethodBeat.o(208140);
      return locald;
    }
    paramb = this.mtM.a(paramb);
    p.g(paramb, "base.createFullscreenHandler(provider)");
    AppMethodBeat.o(208140);
    return paramb;
  }
  
  public final void a(int paramInt, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(208148);
    p.h(paramAppBrandRuntime, "runtime");
    this.mtM.a(paramInt, paramAppBrandRuntime);
    AppMethodBeat.o(208148);
  }
  
  public final void a(WxaWindowLayoutParams paramWxaWindowLayoutParams, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(208147);
    p.h(paramWxaWindowLayoutParams, "params");
    p.h(paramAppBrandRuntime, "runtime");
    this.mtM.a(paramWxaWindowLayoutParams, paramAppBrandRuntime);
    AppMethodBeat.o(208147);
  }
  
  public final boolean aXc()
  {
    AppMethodBeat.i(208135);
    boolean bool = this.mtM.aXc();
    AppMethodBeat.o(208135);
    return bool;
  }
  
  public final boolean aXi()
  {
    AppMethodBeat.i(208137);
    boolean bool = this.mtM.aXi();
    AppMethodBeat.o(208137);
    return bool;
  }
  
  public final e getOrientationHandler()
  {
    AppMethodBeat.i(208139);
    e locale = this.mtN.getOrientationHandler();
    if (locale != null)
    {
      AppMethodBeat.o(208139);
      return locale;
    }
    locale = this.mtM.getOrientationHandler();
    p.g(locale, "base.orientationHandler");
    AppMethodBeat.o(208139);
    return locale;
  }
  
  public final Rect getSafeAreaInsets()
  {
    AppMethodBeat.i(208145);
    Rect localRect = this.mtM.getSafeAreaInsets();
    AppMethodBeat.o(208145);
    return localRect;
  }
  
  public final float getScale()
  {
    AppMethodBeat.i(208141);
    float f = this.mtN.getScale();
    AppMethodBeat.o(208141);
    return f;
  }
  
  public final c.c getStatusBar()
  {
    AppMethodBeat.i(208144);
    c.c localc = this.mtM.getStatusBar();
    AppMethodBeat.o(208144);
    return localc;
  }
  
  public final DisplayMetrics getVDisplayMetrics()
  {
    AppMethodBeat.i(208136);
    DisplayMetrics localDisplayMetrics = this.mtN.getVDisplayMetrics();
    p.g(localDisplayMetrics, "windowViewImplScope.vDisplayMetrics");
    AppMethodBeat.o(208136);
    return localDisplayMetrics;
  }
  
  public final boolean isInMultiWindowMode()
  {
    AppMethodBeat.i(208138);
    boolean bool = this.mtM.isInMultiWindowMode();
    AppMethodBeat.o(208138);
    return bool;
  }
  
  public final void setSoftOrientation(String paramString)
  {
    AppMethodBeat.i(208142);
    p.h(paramString, "name");
    this.mtN.setSoftOrientation(paramString);
    AppMethodBeat.o(208142);
  }
  
  public final void setWindowDescription(c.a parama)
  {
    AppMethodBeat.i(208146);
    p.h(parama, "description");
    this.mtM.setWindowDescription(parama);
    AppMethodBeat.o(208146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.f
 * JD-Core Version:    0.7.0.1
 */