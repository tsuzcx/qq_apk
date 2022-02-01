package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.w;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/menu/MenuDelegate_Restart;", "Lcom/tencent/mm/plugin/appbrand/menu/base/BaseMenuDelegate;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "attachTo", "", "context", "Landroid/content/Context;", "pageView", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "appId", "", "performItemClick", "menuInfo", "Lcom/tencent/mm/plugin/appbrand/menu/MenuInfo;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends a<ah>
{
  public l()
  {
    super(x.tkI.ordinal());
    AppMethodBeat.i(175203);
    AppMethodBeat.o(175203);
  }
  
  private static final void h(ah paramah)
  {
    AppMethodBeat.i(323834);
    s.u(paramah, "$pageView");
    paramah.getRuntime().a(null, "MenuDelegate_Restart");
    AppMethodBeat.o(323834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.l
 * JD-Core Version:    0.7.0.1
 */