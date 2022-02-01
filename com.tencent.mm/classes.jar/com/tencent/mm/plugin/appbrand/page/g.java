package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetPreLoader;", "", "()V", "TAG", "", "preloadedWidgetFactory", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC;", "obtainInstance", "type", "warmUpAndTryPreload", "", "plugin-appbrand-integration_release"})
public final class g
{
  private static final ConcurrentHashMap<com.tencent.mm.plugin.appbrand.task.g, e> nnJ;
  public static final g nnK;
  
  static
  {
    AppMethodBeat.i(229238);
    nnK = new g();
    nnJ = new ConcurrentHashMap();
    AppMethodBeat.o(229238);
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.task.g paramg)
  {
    AppMethodBeat.i(229236);
    p.h(paramg, "type");
    Log.i("MicroMsg.AppBrandDecorWidgetPreLoader", "warmUpAndTryPreload type=".concat(String.valueOf(paramg)));
    e locale;
    if (nnJ.get(paramg) == null)
    {
      locale = new e();
      locale.aD(b.class);
      locale.aD(d.class);
      switch (h.$EnumSwitchMapping$0[paramg.ordinal()])
      {
      }
    }
    for (;;)
    {
      ((Map)nnJ).put(paramg, locale);
      AppMethodBeat.o(229236);
      return;
      locale.aD(a.class);
      locale.aD(AppBrandUILoadingSplash.class);
      int i = 0;
      while (i <= 4)
      {
        locale.aD(AppBrandTabBarItem.class);
        i += 1;
      }
    }
  }
  
  public static e b(com.tencent.mm.plugin.appbrand.task.g paramg)
  {
    AppMethodBeat.i(229237);
    p.h(paramg, "type");
    e locale2 = (e)nnJ.get(paramg);
    e locale1 = locale2;
    if (locale2 == null)
    {
      Log.i("MicroMsg.AppBrandDecorWidgetPreLoader", "obtainInstance: no preloaded, create it [%s]", new Object[] { paramg.name() });
      locale1 = new e();
    }
    AppMethodBeat.o(229237);
    return locale1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.g
 * JD-Core Version:    0.7.0.1
 */