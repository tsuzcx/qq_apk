package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash;
import com.tencent.mm.plugin.appbrand.ui.g;
import com.tencent.mm.plugin.appbrand.widget.tabbar.AppBrandTabBarItem;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC;", "Lcom/tencent/mm/plugin/appbrand/page/PageDecorWidgetFactory$DefaultFactory;", "()V", "mKeepPersistentViews", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "[Ljava/lang/Class;", "mPreloadedWidgets", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC$PreloadWidgetPool;", "mScreenAdaptiveViews", "Landroid/view/ViewGroup;", "contains", "", "array", "objectToFind", "", "([Ljava/lang/Object;Ljava/lang/Object;)Z", "createWidgetImpl", "WIDGET", "Landroid/view/View;", "context", "Landroid/content/Context;", "clazz", "(Landroid/content/Context;Ljava/lang/Class;)Landroid/view/View;", "getFactoryContextForWidget", "originalContext", "getPreloadedWidget", "(Ljava/lang/Class;)Landroid/view/View;", "onCreateWidget", "onDestroy", "", "preloadWidget", "Companion", "PreloadWidgetPool", "plugin-appbrand-integration_release"})
public final class d
  extends bs.a
{
  private static final AtomicBoolean lzx;
  private static d lzy;
  public static final a lzz;
  private final Class<? extends ViewGroup>[] lzu;
  private final Class<? extends com.tencent.mm.ui.statusbar.b>[] lzv;
  public final b lzw;
  
  static
  {
    AppMethodBeat.i(50908);
    lzz = new a((byte)0);
    lzx = new AtomicBoolean(false);
    AppMethodBeat.o(50908);
  }
  
  public d()
  {
    AppMethodBeat.i(50907);
    lzx.set(true);
    this.lzu = new Class[] { com.tencent.mm.plugin.appbrand.widget.actionbar.b.class, com.tencent.mm.plugin.appbrand.widget.tabbar.a.class };
    this.lzv = new Class[] { com.tencent.mm.plugin.appbrand.widget.actionbar.d.class, AppBrandUILoadingSplash.class };
    this.lzw = new b();
    AppMethodBeat.o(50907);
  }
  
  public static final void a(e parame)
  {
    AppMethodBeat.i(50909);
    d locald;
    if (!lzx.getAndSet(true))
    {
      ac.i("MicroMsg.AppBrandDecorWidgetFactoryWC", "warmUpAndTryPreload type=".concat(String.valueOf(parame)));
      locald = new d();
      locald.aB(com.tencent.mm.plugin.appbrand.widget.actionbar.b.class);
      locald.aB(com.tencent.mm.plugin.appbrand.widget.actionbar.d.class);
      if (parame != null) {
        break label63;
      }
    }
    for (;;)
    {
      lzy = locald;
      AppMethodBeat.o(50909);
      return;
      label63:
      switch (e.cfA[parame.ordinal()])
      {
      default: 
        break;
      case 1: 
        locald.aB(com.tencent.mm.plugin.appbrand.widget.tabbar.a.class);
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
  
  public static final d bpO()
  {
    AppMethodBeat.i(50910);
    d locald2 = lzy;
    d locald1 = locald2;
    if (locald2 == null) {
      locald1 = new d();
    }
    lzy = null;
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
      if (k.g(paramArrayOfObject[i], paramObject))
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
    k.h(paramClass, "clazz");
    Object localObject = ai.getContext();
    k.g(localObject, "MMApplicationContext.getContext()");
    localObject = e((Context)localObject, paramClass);
    if (localObject == null)
    {
      AppMethodBeat.o(50905);
      return;
    }
    this.lzw.a(paramClass, (View)localObject);
    AppMethodBeat.o(50905);
  }
  
  public final <WIDGET extends View> WIDGET aC(Class<WIDGET> paramClass)
  {
    AppMethodBeat.i(187346);
    k.h(paramClass, "clazz");
    paramClass = this.lzw.aD(paramClass);
    AppMethodBeat.o(187346);
    return paramClass;
  }
  
  public final <WIDGET extends View> WIDGET c(Context paramContext, Class<WIDGET> paramClass)
  {
    AppMethodBeat.i(50903);
    k.h(paramContext, "context");
    k.h(paramClass, "clazz");
    long l = bs.eWj();
    View localView = this.lzw.aD(paramClass);
    if (localView == null) {}
    for (paramContext = e(paramContext, paramClass);; paramContext = localView)
    {
      paramClass = new StringBuilder("onCreateWidget class[").append(paramClass.getName()).append("] cost[").append(bs.eWj() - l).append("ms] preloaded[");
      if (localView != null) {}
      for (boolean bool = true;; bool = false)
      {
        ac.d("MicroMsg.AppBrandDecorWidgetFactoryWC", bool + ']');
        AppMethodBeat.o(50903);
        return paramContext;
      }
    }
  }
  
  public final Context d(Context paramContext, Class<? extends View> paramClass)
  {
    AppMethodBeat.i(50902);
    k.h(paramContext, "originalContext");
    k.h(paramClass, "clazz");
    Context localContext;
    if (g.bvg()) {
      if (contains(this.lzu, paramClass))
      {
        localContext = (Context)f.dI(paramContext);
        paramContext = localContext;
        if (k.g(paramClass, AppBrandUILoadingSplash.class)) {
          paramContext = (Context)f.dI(localContext);
        }
      }
    }
    for (;;)
    {
      localContext = paramContext;
      if (contains(this.lzv, paramClass)) {
        localContext = (Context)f.dJ(paramContext);
      }
      AppMethodBeat.o(50902);
      return localContext;
      localContext = paramContext;
      break;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC$Companion;", "", "()V", "TAG", "", "sAccessedMark", "Ljava/util/concurrent/atomic/AtomicBoolean;", "sProcessSharedInstance", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC;", "obtainInstance", "warmUpAndTryPreload", "", "type", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC$PreloadWidgetPool;", "", "()V", "mMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Landroid/view/View;", "Ljava/util/LinkedList;", "Lkotlin/collections/HashMap;", "clear", "", "offer", "clazz", "widget", "poll", "WIDGET", "(Ljava/lang/Class;)Landroid/view/View;", "plugin-appbrand-integration_release"})
  public static final class b
  {
    final HashMap<Class<? extends View>, LinkedList<View>> dz;
    
    public b()
    {
      AppMethodBeat.i(50901);
      this.dz = new HashMap();
      AppMethodBeat.o(50901);
    }
    
    public final void a(final Class<? extends View> paramClass, View paramView)
    {
      AppMethodBeat.i(50898);
      k.h(paramClass, "clazz");
      k.h(paramView, "widget");
      if ((LinkedList)this.dz.get(paramClass) == null) {
        ((d.g.a.a)new a(this, paramClass)).invoke();
      }
      paramClass = this.dz.get(paramClass);
      if (paramClass == null) {
        k.fOy();
      }
      ((LinkedList)paramClass).addLast(paramView);
      AppMethodBeat.o(50898);
    }
    
    public final <WIDGET extends View> WIDGET aD(Class<? extends WIDGET> paramClass)
    {
      Object localObject = null;
      AppMethodBeat.i(50899);
      k.h(paramClass, "clazz");
      paramClass = (LinkedList)this.dz.get(paramClass);
      if (paramClass != null)
      {
        paramClass = (View)paramClass.pollFirst();
        if ((paramClass instanceof View)) {
          break label58;
        }
        paramClass = localObject;
      }
      label58:
      for (;;)
      {
        AppMethodBeat.o(50899);
        return paramClass;
        paramClass = null;
        break;
      }
    }
    
    public final void clear()
    {
      AppMethodBeat.i(50900);
      Object localObject = this.dz.values();
      k.g(localObject, "mMap.values");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((LinkedList)((Iterator)localObject).next()).clear();
      }
      this.dz.clear();
      AppMethodBeat.o(50900);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Ljava/util/LinkedList;", "Landroid/view/View;", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<LinkedList<View>>
    {
      a(d.b paramb, Class paramClass)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.d
 * JD-Core Version:    0.7.0.1
 */