package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.capsulebar.c;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash;
import com.tencent.mm.plugin.appbrand.ui.h;
import com.tencent.mm.plugin.appbrand.widget.tabbar.AppBrandTabBarItem;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC;", "Lcom/tencent/mm/plugin/appbrand/page/PageDecorWidgetFactory$DefaultFactory;", "()V", "mKeepPersistentViews", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "[Ljava/lang/Class;", "mPreloadedWidgets", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC$PreloadWidgetPool;", "mScreenAdaptiveViews", "Landroid/view/ViewGroup;", "contains", "", "array", "objectToFind", "", "([Ljava/lang/Object;Ljava/lang/Object;)Z", "createWidgetImpl", "WIDGET", "Landroid/view/View;", "context", "Landroid/content/Context;", "clazz", "(Landroid/content/Context;Ljava/lang/Class;)Landroid/view/View;", "getFactoryContextForWidget", "originalContext", "getPreloadedWidget", "ctx", "(Ljava/lang/Class;Landroid/content/Context;)Landroid/view/View;", "onCreateWidget", "onDestroy", "", "preloadWidget", "Companion", "PreloadWidgetPool", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends ca.a
{
  public static final f.a ttN;
  private final Class<? extends ViewGroup>[] ttO;
  private final Class<? extends com.tencent.mm.ui.statusbar.b>[] ttP;
  public final f.b ttQ;
  
  static
  {
    AppMethodBeat.i(50908);
    ttN = new f.a((byte)0);
    AppMethodBeat.o(50908);
  }
  
  public f()
  {
    AppMethodBeat.i(50907);
    this.ttO = new Class[] { com.tencent.mm.plugin.appbrand.page.capsulebar.d.class, com.tencent.mm.plugin.appbrand.widget.actionbar.b.class, a.class, AppBrandTabBarItem.class };
    this.ttP = new Class[] { c.class, com.tencent.mm.plugin.appbrand.widget.actionbar.d.class, AppBrandUILoadingSplash.class };
    this.ttQ = new f.b();
    AppMethodBeat.o(50907);
  }
  
  private static boolean contains(Object[] paramArrayOfObject, Object paramObject)
  {
    AppMethodBeat.i(50906);
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      if (s.p(paramArrayOfObject[i], paramObject))
      {
        AppMethodBeat.o(50906);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(50906);
    return false;
  }
  
  private final <WIDGET extends View> WIDGET f(Context paramContext, Class<WIDGET> paramClass)
  {
    AppMethodBeat.i(50904);
    paramContext = super.e(d(paramContext, paramClass), paramClass);
    AppMethodBeat.o(50904);
    return paramContext;
  }
  
  public final <WIDGET extends View> WIDGET a(Class<WIDGET> paramClass, Context paramContext)
  {
    AppMethodBeat.i(324903);
    s.u(paramClass, "clazz");
    f.b localb = this.ttQ;
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = MMApplicationContext.getContext();
    }
    s.s(localContext, "ctx ?: MMApplicationContext.getContext()");
    paramClass = localb.b(paramClass, d(localContext, paramClass));
    AppMethodBeat.o(324903);
    return paramClass;
  }
  
  public final <WIDGET extends View> void aW(Class<WIDGET> paramClass)
  {
    AppMethodBeat.i(50905);
    s.u(paramClass, "clazz");
    Object localObject = MMApplicationContext.getContext();
    s.s(localObject, "getContext()");
    localObject = f((Context)localObject, paramClass);
    if (localObject == null)
    {
      AppMethodBeat.o(50905);
      return;
    }
    this.ttQ.a(paramClass, (View)localObject);
    AppMethodBeat.o(50905);
  }
  
  public final Context d(Context paramContext, Class<? extends View> paramClass)
  {
    AppMethodBeat.i(50902);
    s.u(paramContext, "originalContext");
    s.u(paramClass, "clazz");
    Object localObject2;
    if (h.cKV()) {
      if (contains(this.ttO, paramClass))
      {
        localObject2 = (Context)g.fa(paramContext);
        localObject1 = localObject2;
        if (!s.p(paramClass, AppBrandUILoadingSplash.class)) {}
      }
    }
    for (Object localObject1 = (Context)g.fa((Context)localObject2);; localObject1 = paramContext)
    {
      localObject2 = localObject1;
      if (contains(this.ttP, paramClass)) {
        localObject2 = (Context)g.fb((Context)localObject1);
      }
      Log.i("MicroMsg.AppBrandDecorWidgetFactoryWC", "getFactoryContextForWidget: clazz [%s] adapted density [%f] original density [%f]", new Object[] { paramClass.getCanonicalName(), Float.valueOf(((Context)localObject2).getResources().getDisplayMetrics().density), Float.valueOf(paramContext.getResources().getDisplayMetrics().density) });
      AppMethodBeat.o(50902);
      return localObject2;
      localObject2 = paramContext;
      break;
    }
  }
  
  public final <WIDGET extends View> WIDGET e(Context paramContext, Class<WIDGET> paramClass)
  {
    AppMethodBeat.i(50903);
    s.u(paramContext, "context");
    s.u(paramClass, "clazz");
    long l = Util.nowMilliSecond();
    View localView = this.ttQ.b(paramClass, d(paramContext, paramClass));
    if (localView == null)
    {
      paramContext = f(paramContext, paramClass);
      paramClass = new StringBuilder("onCreateWidget class[").append(paramClass.getName()).append("] cost[").append(Util.nowMilliSecond() - l).append("ms] preloaded[");
      if (localView == null) {
        break label124;
      }
    }
    label124:
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.AppBrandDecorWidgetFactoryWC", bool + ']');
      AppMethodBeat.o(50903);
      return paramContext;
      paramContext = localView;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.f
 * JD-Core Version:    0.7.0.1
 */