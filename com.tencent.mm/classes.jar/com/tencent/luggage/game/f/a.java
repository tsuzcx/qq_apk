package com.tencent.luggage.game.f;

import android.graphics.Rect;
import com.tencent.luggage.wxa.a.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.ui.am.a;
import com.tencent.mm.plugin.appbrand.ui.at;
import com.tencent.mm.plugin.appbrand.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/game/ui/WAGameButtonLayoutPropertiesProvider;", "Lcom/tencent/mm/plugin/appbrand/ui/WxaMenuButtonLayoutPropertiesProvider;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "getExpectedCapsuleMarginTop", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "getExpectedPadding", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Padding;", "luggage-wxa-game-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  extends at
{
  public a(AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramAppBrandRuntime);
    AppMethodBeat.i(220106);
    AppMethodBeat.o(220106);
  }
  
  public final am.a aqq()
  {
    AppMethodBeat.i(130752);
    am.a locala = super.aqq();
    locala = new am.a(locala.left, locala.top + Do(a.c.app_brand_game_capsule_extra_margin_top), Do(a.c.app_brand_actionbar_capsule_view_right_margin_default) + Do(a.c.app_brand_game_capsule_extra_margin_right), locala.bottom);
    AppMethodBeat.o(130752);
    return locala;
  }
  
  public final int c(y paramy)
  {
    AppMethodBeat.i(220111);
    s.u(paramy, "service");
    int j = super.c(paramy);
    if (j <= 0)
    {
      paramy = paramy.qwF.getSafeAreaInsets();
      if (paramy == null) {}
      for (int i = 0;; i = paramy.top)
      {
        i = Math.max(j, i);
        AppMethodBeat.o(220111);
        return i;
      }
    }
    AppMethodBeat.o(220111);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.f.a
 * JD-Core Version:    0.7.0.1
 */