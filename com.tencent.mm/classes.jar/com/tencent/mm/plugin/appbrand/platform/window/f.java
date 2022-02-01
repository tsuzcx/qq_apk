package com.tencent.mm.plugin.appbrand.platform.window;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplProxy;", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "base", "windowViewImplScope", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;)V", "getBase", "()Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "getWindowViewImplScope", "()Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;", "compareTo", "", "other", "createFullscreenHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler;", "provider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", "forceLightMode", "", "getContext", "Landroid/content/Context;", "getNavigationBar", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowNavigationBar;", "getOrientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "getSafeAreaInsets", "Landroid/graphics/Rect;", "getScale", "", "getStatusBar", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowStatusBar;", "getVDisplayMetrics", "Landroid/util/DisplayMetrics;", "isInMultiWindowMode", "isLargeScreenWindow", "runInStandaloneTask", "setSoftOrientation", "", "name", "", "setWindowBackgroundColor", "backgroundColor", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "setWindowDescription", "description", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowDescription;", "setWindowLayoutParams", "params", "Lcom/tencent/mm/plugin/appbrand/platform/window/WxaWindowLayoutParams;", "shouldInLargeScreenCompatMode", "luggage-wxa-app_release"})
public final class f
  implements c
{
  public final c qGE;
  public final g qGF;
  
  public f(c paramc, g paramg)
  {
    AppMethodBeat.i(244126);
    this.qGE = paramc;
    this.qGF = paramg;
    AppMethodBeat.o(244126);
  }
  
  public final boolean RZ()
  {
    AppMethodBeat.i(244118);
    boolean bool = this.qGF.RZ();
    AppMethodBeat.o(244118);
    return bool;
  }
  
  public final boolean Sc()
  {
    AppMethodBeat.i(244125);
    boolean bool = this.qGF.Sc();
    AppMethodBeat.o(244125);
    return bool;
  }
  
  public final boolean Sd()
  {
    AppMethodBeat.i(244110);
    boolean bool = this.qGF.Sd();
    AppMethodBeat.o(244110);
    return bool;
  }
  
  public final d a(d.b paramb)
  {
    AppMethodBeat.i(244115);
    d locald = this.qGF.a(paramb);
    if (locald != null)
    {
      AppMethodBeat.o(244115);
      return locald;
    }
    paramb = this.qGE.a(paramb);
    p.j(paramb, "base.createFullscreenHandler(provider)");
    AppMethodBeat.o(244115);
    return paramb;
  }
  
  public final void a(int paramInt, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(244123);
    p.k(paramAppBrandRuntime, "runtime");
    this.qGE.a(paramInt, paramAppBrandRuntime);
    AppMethodBeat.o(244123);
  }
  
  public final void a(WxaWindowLayoutParams paramWxaWindowLayoutParams, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(244122);
    p.k(paramWxaWindowLayoutParams, "params");
    p.k(paramAppBrandRuntime, "runtime");
    this.qGE.a(paramWxaWindowLayoutParams, paramAppBrandRuntime);
    AppMethodBeat.o(244122);
  }
  
  public final boolean bCS()
  {
    AppMethodBeat.i(244106);
    boolean bool = this.qGE.bCS();
    AppMethodBeat.o(244106);
    return bool;
  }
  
  public final boolean bCZ()
  {
    AppMethodBeat.i(244112);
    boolean bool = this.qGE.bCZ();
    AppMethodBeat.o(244112);
    return bool;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(244105);
    Context localContext = this.qGE.getContext();
    p.j(localContext, "base.context");
    AppMethodBeat.o(244105);
    return localContext;
  }
  
  public final e getOrientationHandler()
  {
    AppMethodBeat.i(244114);
    e locale = this.qGF.getOrientationHandler();
    if (locale != null)
    {
      AppMethodBeat.o(244114);
      return locale;
    }
    locale = this.qGE.getOrientationHandler();
    p.j(locale, "base.orientationHandler");
    AppMethodBeat.o(244114);
    return locale;
  }
  
  public final Rect getSafeAreaInsets()
  {
    AppMethodBeat.i(244120);
    Rect localRect = this.qGE.getSafeAreaInsets();
    AppMethodBeat.o(244120);
    return localRect;
  }
  
  public final float getScale()
  {
    AppMethodBeat.i(244116);
    float f = this.qGF.getScale();
    AppMethodBeat.o(244116);
    return f;
  }
  
  public final c.c getStatusBar()
  {
    AppMethodBeat.i(244119);
    c.c localc = this.qGF.getStatusBar();
    AppMethodBeat.o(244119);
    return localc;
  }
  
  public final DisplayMetrics getVDisplayMetrics()
  {
    AppMethodBeat.i(244109);
    DisplayMetrics localDisplayMetrics = this.qGF.getVDisplayMetrics();
    p.j(localDisplayMetrics, "windowViewImplScope.vDisplayMetrics");
    AppMethodBeat.o(244109);
    return localDisplayMetrics;
  }
  
  public final void setSoftOrientation(String paramString)
  {
    AppMethodBeat.i(244117);
    p.k(paramString, "name");
    this.qGF.setSoftOrientation(paramString);
    AppMethodBeat.o(244117);
  }
  
  public final void setWindowDescription(c.a parama)
  {
    AppMethodBeat.i(244121);
    p.k(parama, "description");
    this.qGE.setWindowDescription(parama);
    AppMethodBeat.o(244121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.f
 * JD-Core Version:    0.7.0.1
 */