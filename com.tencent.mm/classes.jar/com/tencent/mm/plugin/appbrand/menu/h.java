package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.permission.appidABTest.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/menu/MenuDelegate_GameLive;", "Lcom/tencent/mm/plugin/appbrand/menu/base/BaseMenuDelegate;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "attachTo", "", "context", "Landroid/content/Context;", "pageView", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "appId", "", "performItemClick", "menuInfo", "Lcom/tencent/mm/plugin/appbrand/menu/MenuInfo;", "Companion", "EventOnGameStateChange", "GameLiveStateChangeEndReason", "GameLiveStateChangeEvent", "plugin-appbrand-integration_release"})
public final class h
  extends a<ah>
{
  public static final a qfd;
  
  static
  {
    AppMethodBeat.i(269191);
    qfd = new a((byte)0);
    AppMethodBeat.o(269191);
  }
  
  public h()
  {
    super(w.qgk.ordinal());
    AppMethodBeat.i(269190);
    AppMethodBeat.o(269190);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/menu/MenuDelegate_GameLive$Companion;", "", "()V", "TAG", "", "isAble", "", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static boolean h(ah paramah)
    {
      AppMethodBeat.i(277355);
      p.k(paramah, "pageView");
      if (b.o((d)paramah.getRuntime()))
      {
        AppMethodBeat.o(277355);
        return true;
      }
      AppMethodBeat.o(277355);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.h
 * JD-Core Version:    0.7.0.1
 */