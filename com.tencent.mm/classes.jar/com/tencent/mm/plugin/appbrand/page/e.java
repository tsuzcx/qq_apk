package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.capsulebar.c;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash;
import com.tencent.mm.plugin.appbrand.ui.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC;", "Lcom/tencent/mm/plugin/appbrand/page/PageDecorWidgetFactory$DefaultFactory;", "()V", "mKeepPersistentViews", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "[Ljava/lang/Class;", "mPreloadedWidgets", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC$PreloadWidgetPool;", "mScreenAdaptiveViews", "Landroid/view/ViewGroup;", "contains", "", "array", "objectToFind", "", "([Ljava/lang/Object;Ljava/lang/Object;)Z", "createWidgetImpl", "WIDGET", "Landroid/view/View;", "context", "Landroid/content/Context;", "clazz", "(Landroid/content/Context;Ljava/lang/Class;)Landroid/view/View;", "getFactoryContextForWidget", "originalContext", "getPreloadedWidget", "ctx", "(Ljava/lang/Class;Landroid/content/Context;)Landroid/view/View;", "onCreateWidget", "onDestroy", "", "preloadWidget", "Companion", "PreloadWidgetPool", "plugin-appbrand-integration_release"})
public final class e
  extends bw.a
{
  public static final a nnG;
  private final Class<? extends ViewGroup>[] nnD;
  private final Class<? extends com.tencent.mm.ui.statusbar.b>[] nnE;
  public final b nnF;
  
  static
  {
    AppMethodBeat.i(50908);
    nnG = new a((byte)0);
    AppMethodBeat.o(50908);
  }
  
  public e()
  {
    AppMethodBeat.i(50907);
    this.nnD = new Class[] { com.tencent.mm.plugin.appbrand.page.capsulebar.d.class, com.tencent.mm.plugin.appbrand.widget.actionbar.b.class, com.tencent.mm.plugin.appbrand.widget.tabbar.a.class };
    this.nnE = new Class[] { c.class, com.tencent.mm.plugin.appbrand.widget.actionbar.d.class, AppBrandUILoadingSplash.class };
    this.nnF = new b();
    AppMethodBeat.o(50907);
  }
  
  private static boolean contains(Object[] paramArrayOfObject, Object paramObject)
  {
    AppMethodBeat.i(50906);
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      if (p.j(paramArrayOfObject[i], paramObject))
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
    paramContext = super.d(c(paramContext, paramClass), paramClass);
    AppMethodBeat.o(50904);
    return paramContext;
  }
  
  public final <WIDGET extends View> WIDGET a(Class<WIDGET> paramClass, Context paramContext)
  {
    AppMethodBeat.i(229234);
    p.h(paramClass, "clazz");
    p.h(paramContext, "ctx");
    paramClass = this.nnF.b(paramClass, c(paramContext, paramClass));
    AppMethodBeat.o(229234);
    return paramClass;
  }
  
  public final <WIDGET extends View> void aD(Class<WIDGET> paramClass)
  {
    AppMethodBeat.i(50905);
    p.h(paramClass, "clazz");
    Object localObject = MMApplicationContext.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = e((Context)localObject, paramClass);
    if (localObject == null)
    {
      AppMethodBeat.o(50905);
      return;
    }
    this.nnF.a(paramClass, (View)localObject);
    AppMethodBeat.o(50905);
  }
  
  public final Context c(Context paramContext, Class<? extends View> paramClass)
  {
    AppMethodBeat.i(50902);
    p.h(paramContext, "originalContext");
    p.h(paramClass, "clazz");
    Object localObject2;
    if (k.bXf()) {
      if (contains(this.nnD, paramClass))
      {
        localObject2 = (Context)f.eh(paramContext);
        localObject1 = localObject2;
        if (!p.j(paramClass, AppBrandUILoadingSplash.class)) {}
      }
    }
    for (Object localObject1 = (Context)f.eh((Context)localObject2);; localObject1 = paramContext)
    {
      localObject2 = localObject1;
      if (contains(this.nnE, paramClass)) {
        localObject2 = (Context)f.ei((Context)localObject1);
      }
      paramClass = paramClass.getCanonicalName();
      localObject1 = ((Context)localObject2).getResources();
      p.g(localObject1, "context.resources");
      float f = ((Resources)localObject1).getDisplayMetrics().density;
      paramContext = paramContext.getResources();
      p.g(paramContext, "originalContext.resources");
      Log.i("MicroMsg.AppBrandDecorWidgetFactoryWC", "getFactoryContextForWidget: clazz [%s] adapted density [%f] original density [%f]", new Object[] { paramClass, Float.valueOf(f), Float.valueOf(paramContext.getDisplayMetrics().density) });
      AppMethodBeat.o(50902);
      return localObject2;
      localObject2 = paramContext;
      break;
    }
  }
  
  public final <WIDGET extends View> WIDGET d(Context paramContext, Class<WIDGET> paramClass)
  {
    AppMethodBeat.i(50903);
    p.h(paramContext, "context");
    p.h(paramClass, "clazz");
    long l = Util.nowMilliSecond();
    View localView = this.nnF.b(paramClass, c(paramContext, paramClass));
    if (localView == null) {}
    for (paramContext = e(paramContext, paramClass);; paramContext = localView)
    {
      paramClass = new StringBuilder("onCreateWidget class[").append(paramClass.getName()).append("] cost[").append(Util.nowMilliSecond() - l).append("ms] preloaded[");
      if (localView != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.d("MicroMsg.AppBrandDecorWidgetFactoryWC", bool + ']');
        AppMethodBeat.o(50903);
        return paramContext;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC$PreloadWidgetPool;", "", "()V", "mMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Landroid/view/View;", "Ljava/util/LinkedList;", "Lkotlin/collections/HashMap;", "clear", "", "offer", "clazz", "widget", "poll", "WIDGET", "ctx", "Landroid/content/Context;", "(Ljava/lang/Class;Landroid/content/Context;)Landroid/view/View;", "plugin-appbrand-integration_release"})
  public static final class b
  {
    final HashMap<Class<? extends View>, LinkedList<View>> mMap;
    
    public b()
    {
      AppMethodBeat.i(50901);
      this.mMap = new HashMap();
      AppMethodBeat.o(50901);
    }
    
    public final void a(final Class<? extends View> paramClass, View paramView)
    {
      AppMethodBeat.i(50898);
      p.h(paramClass, "clazz");
      p.h(paramView, "widget");
      if ((LinkedList)this.mMap.get(paramClass) == null) {
        ((kotlin.g.a.a)new a(this, paramClass)).invoke();
      }
      paramClass = this.mMap.get(paramClass);
      if (paramClass == null) {
        p.hyc();
      }
      ((LinkedList)paramClass).addLast(paramView);
      AppMethodBeat.o(50898);
    }
    
    public final <WIDGET extends View> WIDGET b(Class<? extends WIDGET> paramClass, Context paramContext)
    {
      AppMethodBeat.i(229233);
      p.h(paramClass, "clazz");
      p.h(paramContext, "ctx");
      Object localObject1 = (LinkedList)this.mMap.get(paramClass);
      if (localObject1 != null) {}
      Object localObject2;
      for (localObject1 = (View)((LinkedList)localObject1).pollFirst();; localObject1 = null)
      {
        localObject2 = localObject1;
        if (!(localObject1 instanceof View)) {
          localObject2 = null;
        }
        if (localObject2 == null) {
          break;
        }
        paramContext = paramContext.getResources();
        p.g(paramContext, "ctx.resources");
        float f1 = paramContext.getDisplayMetrics().density;
        paramContext = localObject2.getContext();
        p.g(paramContext, "widget.context");
        paramContext = paramContext.getResources();
        p.g(paramContext, "widget.context.resources");
        float f2 = paramContext.getDisplayMetrics().density;
        if (f1 == f2) {
          break;
        }
        Log.i("MicroMsg.AppBrandDecorWidgetFactoryWC", "getPreloadedWidget: [%s]([%f]) preloaded but outer density([%f]) has changed, ret null", new Object[] { paramClass.getCanonicalName(), Float.valueOf(f2), Float.valueOf(f1) });
        AppMethodBeat.o(229233);
        return null;
      }
      AppMethodBeat.o(229233);
      return localObject2;
    }
    
    public final void clear()
    {
      AppMethodBeat.i(50900);
      Object localObject = this.mMap.values();
      p.g(localObject, "mMap.values");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((LinkedList)((Iterator)localObject).next()).clear();
      }
      this.mMap.clear();
      AppMethodBeat.o(50900);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/LinkedList;", "Landroid/view/View;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<LinkedList<View>>
    {
      a(e.b paramb, Class paramClass)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.e
 * JD-Core Version:    0.7.0.1
 */