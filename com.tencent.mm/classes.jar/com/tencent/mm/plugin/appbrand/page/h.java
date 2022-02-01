package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.task.l;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;
import com.tencent.mm.plugin.appbrand.widget.tabbar.AppBrandTabBarItem;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetPreLoader;", "", "()V", "TAG", "", "preloadedWidgetFactory", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandDecorWidgetFactoryWC;", "obtainInstance", "type", "warmUpAndTryPreload", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h ttR;
  private static final ConcurrentHashMap<l, f> ttS;
  
  static
  {
    AppMethodBeat.i(324895);
    ttR = new h();
    ttS = new ConcurrentHashMap();
    AppMethodBeat.o(324895);
  }
  
  public static void a(l paraml)
  {
    AppMethodBeat.i(324889);
    s.u(paraml, "type");
    Log.i("MicroMsg.AppBrandDecorWidgetPreLoader", s.X("warmUpAndTryPreload type=", paraml));
    f localf;
    if (ttS.get(paraml) == null)
    {
      localf = new f();
      localf.aW(b.class);
      localf.aW(d.class);
      switch (a.$EnumSwitchMapping$0[paraml.ordinal()])
      {
      }
    }
    for (;;)
    {
      ((Map)ttS).put(paraml, localf);
      AppMethodBeat.o(324889);
      return;
      localf.aW(a.class);
      localf.aW(AppBrandUILoadingSplash.class);
      int i = 0;
      int j;
      do
      {
        j = i + 1;
        localf.aW(AppBrandTabBarItem.class);
        i = j;
      } while (j <= 4);
    }
  }
  
  public static f b(l paraml)
  {
    AppMethodBeat.i(324892);
    s.u(paraml, "type");
    f localf2 = (f)ttS.get(paraml);
    f localf1 = localf2;
    if (localf2 == null)
    {
      Log.i("MicroMsg.AppBrandDecorWidgetPreLoader", "obtainInstance: no preloaded, create it [%s]", new Object[] { paraml.name() });
      localf1 = new f();
    }
    AppMethodBeat.o(324892);
    return localf1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.h
 * JD-Core Version:    0.7.0.1
 */