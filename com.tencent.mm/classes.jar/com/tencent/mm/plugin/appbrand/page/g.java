package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.task.n;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;
import com.tencent.mm.plugin.appbrand.widget.tabbar.AppBrandTabBarItem;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetPreLoader;", "", "()V", "TAG", "", "preloadedWidgetFactory", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC;", "obtainInstance", "type", "warmUpAndTryPreload", "", "plugin-appbrand-integration_release"})
public final class g
{
  private static final ConcurrentHashMap<n, e> qpq;
  public static final g qpr;
  
  static
  {
    AppMethodBeat.i(268828);
    qpr = new g();
    qpq = new ConcurrentHashMap();
    AppMethodBeat.o(268828);
  }
  
  public static void a(n paramn)
  {
    AppMethodBeat.i(268826);
    p.k(paramn, "type");
    Log.i("MicroMsg.AppBrandDecorWidgetPreLoader", "warmUpAndTryPreload type=".concat(String.valueOf(paramn)));
    e locale;
    if (qpq.get(paramn) == null)
    {
      locale = new e();
      locale.aC(b.class);
      locale.aC(d.class);
      switch (h.$EnumSwitchMapping$0[paramn.ordinal()])
      {
      }
    }
    for (;;)
    {
      ((Map)qpq).put(paramn, locale);
      AppMethodBeat.o(268826);
      return;
      locale.aC(a.class);
      locale.aC(AppBrandUILoadingSplash.class);
      int i = 0;
      while (i <= 4)
      {
        locale.aC(AppBrandTabBarItem.class);
        i += 1;
      }
    }
  }
  
  public static e b(n paramn)
  {
    AppMethodBeat.i(268827);
    p.k(paramn, "type");
    e locale2 = (e)qpq.get(paramn);
    e locale1 = locale2;
    if (locale2 == null)
    {
      Log.i("MicroMsg.AppBrandDecorWidgetPreLoader", "obtainInstance: no preloaded, create it [%s]", new Object[] { paramn.name() });
      locale1 = new e();
    }
    AppMethodBeat.o(268827);
    return locale1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.g
 * JD-Core Version:    0.7.0.1
 */