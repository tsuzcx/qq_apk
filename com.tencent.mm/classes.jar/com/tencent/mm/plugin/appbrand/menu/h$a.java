package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.permission.appidABTest.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/menu/MenuDelegate_GameLive$Companion;", "", "()V", "TAG", "", "isAble", "", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h$a
{
  public static boolean g(ah paramah)
  {
    AppMethodBeat.i(323884);
    s.u(paramah, "pageView");
    if (b.o((d)paramah.getRuntime()))
    {
      AppMethodBeat.o(323884);
      return true;
    }
    AppMethodBeat.o(323884);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.h.a
 * JD-Core Version:    0.7.0.1
 */