package com.tencent.mm.plugin.appbrand.platform.window;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplProxy;", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "base", "windowViewImplScope", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;)V", "getBase", "()Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "getWindowViewImplScope", "()Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;", "compareTo", "", "other", "createFullscreenHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler;", "provider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", "forceLightMode", "", "getContext", "Landroid/content/Context;", "getNavigationBar", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowNavigationBar;", "getOrientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "getSafeAreaInsets", "Landroid/graphics/Rect;", "getScale", "", "getStatusBar", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowStatusBar;", "getVDisplayMetrics", "Landroid/util/DisplayMetrics;", "isInMultiWindowMode", "isLargeScreenWindow", "runInStandaloneTask", "setSoftOrientation", "", "name", "", "setWindowBackgroundColor", "backgroundColor", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "setWindowDescription", "description", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowDescription;", "setWindowLayoutParams", "params", "Lcom/tencent/mm/plugin/appbrand/platform/window/WxaWindowLayoutParams;", "shouldInLargeScreenCompatMode", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements c
{
  public final c tLq;
  public final g tLr;
  
  public f(c paramc, g paramg)
  {
    AppMethodBeat.i(317500);
    this.tLq = paramc;
    this.tLr = paramg;
    AppMethodBeat.o(317500);
  }
  
  public final d a(d.b paramb)
  {
    AppMethodBeat.i(317520);
    d locald = this.tLr.a(paramb);
    if (locald != null)
    {
      AppMethodBeat.o(317520);
      return locald;
    }
    paramb = this.tLq.a(paramb);
    s.s(paramb, "base.createFullscreenHandler(provider)");
    AppMethodBeat.o(317520);
    return paramb;
  }
  
  public final void a(int paramInt, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(317537);
    s.u(paramAppBrandRuntime, "runtime");
    this.tLq.a(paramInt, paramAppBrandRuntime);
    AppMethodBeat.o(317537);
  }
  
  public final void a(WxaWindowLayoutParams paramWxaWindowLayoutParams, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(317534);
    s.u(paramWxaWindowLayoutParams, "params");
    s.u(paramAppBrandRuntime, "runtime");
    this.tLq.a(paramWxaWindowLayoutParams, paramAppBrandRuntime);
    AppMethodBeat.o(317534);
  }
  
  public final boolean asq()
  {
    AppMethodBeat.i(317526);
    boolean bool = this.tLr.asq();
    AppMethodBeat.o(317526);
    return bool;
  }
  
  public final boolean ast()
  {
    AppMethodBeat.i(317539);
    boolean bool = this.tLr.ast();
    AppMethodBeat.o(317539);
    return bool;
  }
  
  public final boolean asu()
  {
    AppMethodBeat.i(317512);
    boolean bool = this.tLr.asu();
    AppMethodBeat.o(317512);
    return bool;
  }
  
  public final boolean ccf()
  {
    AppMethodBeat.i(317507);
    boolean bool = this.tLq.ccf();
    AppMethodBeat.o(317507);
    return bool;
  }
  
  public final boolean ccm()
  {
    AppMethodBeat.i(317515);
    boolean bool = this.tLq.ccm();
    AppMethodBeat.o(317515);
    return bool;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(317504);
    Context localContext = this.tLq.getContext();
    s.s(localContext, "base.context");
    AppMethodBeat.o(317504);
    return localContext;
  }
  
  public final e getOrientationHandler()
  {
    AppMethodBeat.i(317518);
    e locale = this.tLr.getOrientationHandler();
    if (locale != null)
    {
      AppMethodBeat.o(317518);
      return locale;
    }
    locale = this.tLq.getOrientationHandler();
    s.s(locale, "base.orientationHandler");
    AppMethodBeat.o(317518);
    return locale;
  }
  
  public final Rect getSafeAreaInsets()
  {
    AppMethodBeat.i(317530);
    Rect localRect = this.tLq.getSafeAreaInsets();
    AppMethodBeat.o(317530);
    return localRect;
  }
  
  public final float getScale()
  {
    AppMethodBeat.i(317522);
    float f = this.tLr.getScale();
    AppMethodBeat.o(317522);
    return f;
  }
  
  public final c.c getStatusBar()
  {
    AppMethodBeat.i(317528);
    c.c localc = this.tLr.getStatusBar();
    AppMethodBeat.o(317528);
    return localc;
  }
  
  public final DisplayMetrics getVDisplayMetrics()
  {
    AppMethodBeat.i(317509);
    DisplayMetrics localDisplayMetrics = this.tLr.getVDisplayMetrics();
    s.s(localDisplayMetrics, "windowViewImplScope.vDisplayMetrics");
    AppMethodBeat.o(317509);
    return localDisplayMetrics;
  }
  
  public final void setSoftOrientation(String paramString)
  {
    AppMethodBeat.i(317524);
    s.u(paramString, "name");
    this.tLr.setSoftOrientation(paramString);
    AppMethodBeat.o(317524);
  }
  
  public final void setWindowDescription(c.a parama)
  {
    AppMethodBeat.i(317532);
    s.u(parama, "description");
    this.tLq.setWindowDescription(parama);
    AppMethodBeat.o(317532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.f
 * JD-Core Version:    0.7.0.1
 */