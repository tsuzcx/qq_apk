package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash;
import com.tencent.mm.plugin.appbrand.ui.i;
import com.tencent.mm.plugin.appbrand.widget.tabbar.AppBrandTabBarItem;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC;", "Lcom/tencent/mm/plugin/appbrand/page/PageDecorWidgetFactory$DefaultFactory;", "()V", "mKeepPersistentViews", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "[Ljava/lang/Class;", "mPreloadedWidgets", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC$PreloadWidgetPool;", "mScreenAdaptiveViews", "Landroid/view/ViewGroup;", "contains", "", "array", "objectToFind", "", "([Ljava/lang/Object;Ljava/lang/Object;)Z", "createWidgetImpl", "WIDGET", "Landroid/view/View;", "context", "Landroid/content/Context;", "clazz", "(Landroid/content/Context;Ljava/lang/Class;)Landroid/view/View;", "getFactoryContextForWidget", "originalContext", "getPreloadedWidget", "(Ljava/lang/Class;)Landroid/view/View;", "onCreateWidget", "onDestroy", "", "preloadWidget", "Companion", "PreloadWidgetPool", "plugin-appbrand-integration_release"})
public final class c
  extends bq.a
{
  private static final AtomicBoolean mdo;
  private static c mdp;
  public static final a mdq;
  private final Class<? extends ViewGroup>[] mdl;
  private final Class<? extends com.tencent.mm.ui.statusbar.b>[] mdm;
  public final b mdn;
  
  static
  {
    AppMethodBeat.i(50908);
    mdq = new a((byte)0);
    mdo = new AtomicBoolean(false);
    AppMethodBeat.o(50908);
  }
  
  public c()
  {
    AppMethodBeat.i(50907);
    mdo.set(true);
    this.mdl = new Class[] { com.tencent.mm.plugin.appbrand.page.capsulebar.d.class, com.tencent.mm.plugin.appbrand.widget.actionbar.b.class, com.tencent.mm.plugin.appbrand.widget.tabbar.a.class };
    this.mdm = new Class[] { com.tencent.mm.plugin.appbrand.page.capsulebar.c.class, com.tencent.mm.plugin.appbrand.widget.actionbar.d.class, AppBrandUILoadingSplash.class };
    this.mdn = new b();
    AppMethodBeat.o(50907);
  }
  
  public static final void a(com.tencent.mm.plugin.appbrand.task.e parame)
  {
    AppMethodBeat.i(50909);
    c localc;
    if (!mdo.getAndSet(true))
    {
      ae.i("MicroMsg.AppBrandDecorWidgetFactoryWC", "warmUpAndTryPreload type=".concat(String.valueOf(parame)));
      localc = new c();
      localc.aB(com.tencent.mm.plugin.appbrand.widget.actionbar.b.class);
      localc.aB(com.tencent.mm.plugin.appbrand.widget.actionbar.d.class);
      if (parame != null) {
        break label63;
      }
    }
    for (;;)
    {
      mdp = localc;
      AppMethodBeat.o(50909);
      return;
      label63:
      switch (d.cqt[parame.ordinal()])
      {
      default: 
        break;
      case 1: 
        localc.aB(com.tencent.mm.plugin.appbrand.widget.tabbar.a.class);
        localc.aB(AppBrandUILoadingSplash.class);
        int i = 0;
        while (i <= 4)
        {
          localc.aB(AppBrandTabBarItem.class);
          i += 1;
        }
      }
    }
  }
  
  public static final c buz()
  {
    AppMethodBeat.i(50910);
    c localc2 = mdp;
    c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new c();
    }
    mdp = null;
    AppMethodBeat.o(50910);
    return localc1;
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
    Object localObject = ak.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = e((Context)localObject, paramClass);
    if (localObject == null)
    {
      AppMethodBeat.o(50905);
      return;
    }
    this.mdn.a(paramClass, (View)localObject);
    AppMethodBeat.o(50905);
  }
  
  public final <WIDGET extends View> WIDGET aC(Class<WIDGET> paramClass)
  {
    AppMethodBeat.i(223817);
    p.h(paramClass, "clazz");
    paramClass = this.mdn.aD(paramClass);
    AppMethodBeat.o(223817);
    return paramClass;
  }
  
  public final <WIDGET extends View> WIDGET c(Context paramContext, Class<WIDGET> paramClass)
  {
    AppMethodBeat.i(50903);
    p.h(paramContext, "context");
    p.h(paramClass, "clazz");
    long l = bu.fpO();
    View localView = this.mdn.aD(paramClass);
    if (localView == null) {}
    for (paramContext = e(paramContext, paramClass);; paramContext = localView)
    {
      paramClass = new StringBuilder("onCreateWidget class[").append(paramClass.getName()).append("] cost[").append(bu.fpO() - l).append("ms] preloaded[");
      if (localView != null) {}
      for (boolean bool = true;; bool = false)
      {
        ae.d("MicroMsg.AppBrandDecorWidgetFactoryWC", bool + ']');
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
    if (i.bAh()) {
      if (contains(this.mdl, paramClass))
      {
        localContext = (Context)e.dL(paramContext);
        paramContext = localContext;
        if (p.i(paramClass, AppBrandUILoadingSplash.class)) {
          paramContext = (Context)e.dL(localContext);
        }
      }
    }
    for (;;)
    {
      localContext = paramContext;
      if (contains(this.mdm, paramClass)) {
        localContext = (Context)e.dM(paramContext);
      }
      AppMethodBeat.o(50902);
      return localContext;
      localContext = paramContext;
      break;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC$Companion;", "", "()V", "TAG", "", "sAccessedMark", "Ljava/util/concurrent/atomic/AtomicBoolean;", "sProcessSharedInstance", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC;", "obtainInstance", "warmUpAndTryPreload", "", "type", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC$PreloadWidgetPool;", "", "()V", "mMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Landroid/view/View;", "Ljava/util/LinkedList;", "Lkotlin/collections/HashMap;", "clear", "", "offer", "clazz", "widget", "poll", "WIDGET", "(Ljava/lang/Class;)Landroid/view/View;", "plugin-appbrand-integration_release"})
  public static final class b
  {
    public final HashMap<Class<? extends View>, LinkedList<View>> dz;
    
    public b()
    {
      AppMethodBeat.i(50901);
      this.dz = new HashMap();
      AppMethodBeat.o(50901);
    }
    
    public final void a(final Class<? extends View> paramClass, View paramView)
    {
      AppMethodBeat.i(50898);
      p.h(paramClass, "clazz");
      p.h(paramView, "widget");
      if ((LinkedList)this.dz.get(paramClass) == null) {
        ((d.g.a.a)new a(this, paramClass)).invoke();
      }
      paramClass = this.dz.get(paramClass);
      if (paramClass == null) {
        p.gkB();
      }
      ((LinkedList)paramClass).addLast(paramView);
      AppMethodBeat.o(50898);
    }
    
    public final <WIDGET extends View> WIDGET aD(Class<? extends WIDGET> paramClass)
    {
      Object localObject = null;
      AppMethodBeat.i(50899);
      p.h(paramClass, "clazz");
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
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Ljava/util/LinkedList;", "Landroid/view/View;", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<LinkedList<View>>
    {
      a(c.b paramb, Class paramClass)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c
 * JD-Core Version:    0.7.0.1
 */