package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash;
import com.tencent.mm.plugin.appbrand.ui.h;
import com.tencent.mm.plugin.appbrand.widget.tabbar.AppBrandTabBarItem;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import java.util.concurrent.atomic.AtomicBoolean;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC;", "Lcom/tencent/mm/plugin/appbrand/page/PageDecorWidgetFactory$DefaultFactory;", "()V", "mKeepPersistentViews", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "[Ljava/lang/Class;", "mPreloadedWidgets", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC$PreloadWidgetPool;", "mScreenAdaptiveViews", "Landroid/view/ViewGroup;", "contains", "", "array", "objectToFind", "", "([Ljava/lang/Object;Ljava/lang/Object;)Z", "createWidgetImpl", "WIDGET", "Landroid/view/View;", "context", "Landroid/content/Context;", "clazz", "(Landroid/content/Context;Ljava/lang/Class;)Landroid/view/View;", "getFactoryContextForWidget", "originalContext", "getPreloadedWidget", "(Ljava/lang/Class;)Landroid/view/View;", "onCreateWidget", "onDestroy", "", "preloadWidget", "Companion", "PreloadWidgetPool", "plugin-appbrand-integration_release"})
public final class d
  extends br.a
{
  private static final AtomicBoolean lYV;
  private static d lYW;
  public static final d.a lYX;
  private final Class<? extends ViewGroup>[] lYS;
  private final Class<? extends com.tencent.mm.ui.statusbar.b>[] lYT;
  public final d.b lYU;
  
  static
  {
    AppMethodBeat.i(50908);
    lYX = new d.a((byte)0);
    lYV = new AtomicBoolean(false);
    AppMethodBeat.o(50908);
  }
  
  public d()
  {
    AppMethodBeat.i(50907);
    lYV.set(true);
    this.lYS = new Class[] { com.tencent.mm.plugin.appbrand.widget.actionbar.b.class, a.class };
    this.lYT = new Class[] { com.tencent.mm.plugin.appbrand.widget.actionbar.d.class, AppBrandUILoadingSplash.class };
    this.lYU = new d.b();
    AppMethodBeat.o(50907);
  }
  
  public static final void a(e parame)
  {
    AppMethodBeat.i(50909);
    d locald;
    if (!lYV.getAndSet(true))
    {
      ad.i("MicroMsg.AppBrandDecorWidgetFactoryWC", "warmUpAndTryPreload type=".concat(String.valueOf(parame)));
      locald = new d();
      locald.aB(com.tencent.mm.plugin.appbrand.widget.actionbar.b.class);
      locald.aB(com.tencent.mm.plugin.appbrand.widget.actionbar.d.class);
      if (parame != null) {
        break label63;
      }
    }
    for (;;)
    {
      lYW = locald;
      AppMethodBeat.o(50909);
      return;
      label63:
      switch (e.cpQ[parame.ordinal()])
      {
      default: 
        break;
      case 1: 
        locald.aB(a.class);
        locald.aB(AppBrandUILoadingSplash.class);
        int i = 0;
        while (i <= 4)
        {
          locald.aB(AppBrandTabBarItem.class);
          i += 1;
        }
      }
    }
  }
  
  public static final d btO()
  {
    AppMethodBeat.i(50910);
    d locald2 = lYW;
    d locald1 = locald2;
    if (locald2 == null) {
      locald1 = new d();
    }
    lYW = null;
    AppMethodBeat.o(50910);
    return locald1;
  }
  
  private static boolean contains(Object[] paramArrayOfObject, Object paramObject)
  {
    AppMethodBeat.i(50906);
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      if (p.i(paramArrayOfObject[i], paramObject))
      {
        AppMethodBeat.o(50906);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(50906);
    return false;
  }
  
  private final <WIDGET extends View> WIDGET e(Context paramContext, Class<WIDGET> paramClass)
  {
    AppMethodBeat.i(50904);
    paramContext = super.c(d(paramContext, paramClass), paramClass);
    AppMethodBeat.o(50904);
    return paramContext;
  }
  
  public final <WIDGET extends View> void aB(Class<WIDGET> paramClass)
  {
    AppMethodBeat.i(50905);
    p.h(paramClass, "clazz");
    Object localObject = aj.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = e((Context)localObject, paramClass);
    if (localObject == null)
    {
      AppMethodBeat.o(50905);
      return;
    }
    this.lYU.a(paramClass, (View)localObject);
    AppMethodBeat.o(50905);
  }
  
  public final <WIDGET extends View> WIDGET aC(Class<WIDGET> paramClass)
  {
    AppMethodBeat.i(189548);
    p.h(paramClass, "clazz");
    paramClass = this.lYU.aD(paramClass);
    AppMethodBeat.o(189548);
    return paramClass;
  }
  
  public final <WIDGET extends View> WIDGET c(Context paramContext, Class<WIDGET> paramClass)
  {
    AppMethodBeat.i(50903);
    p.h(paramContext, "context");
    p.h(paramClass, "clazz");
    long l = bt.flT();
    View localView = this.lYU.aD(paramClass);
    if (localView == null) {}
    for (paramContext = e(paramContext, paramClass);; paramContext = localView)
    {
      paramClass = new StringBuilder("onCreateWidget class[").append(paramClass.getName()).append("] cost[").append(bt.flT() - l).append("ms] preloaded[");
      if (localView != null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.d("MicroMsg.AppBrandDecorWidgetFactoryWC", bool + ']');
        AppMethodBeat.o(50903);
        return paramContext;
      }
    }
  }
  
  public final Context d(Context paramContext, Class<? extends View> paramClass)
  {
    AppMethodBeat.i(50902);
    p.h(paramContext, "originalContext");
    p.h(paramClass, "clazz");
    Context localContext;
    if (h.bzm()) {
      if (contains(this.lYS, paramClass))
      {
        localContext = (Context)f.dH(paramContext);
        paramContext = localContext;
        if (p.i(paramClass, AppBrandUILoadingSplash.class)) {
          paramContext = (Context)f.dH(localContext);
        }
      }
    }
    for (;;)
    {
      localContext = paramContext;
      if (contains(this.lYT, paramClass)) {
        localContext = (Context)f.dI(paramContext);
      }
      AppMethodBeat.o(50902);
      return localContext;
      localContext = paramContext;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.d
 * JD-Core Version:    0.7.0.1
 */