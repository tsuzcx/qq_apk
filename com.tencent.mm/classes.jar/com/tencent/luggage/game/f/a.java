package com.tencent.luggage.game.f;

import com.tencent.luggage.wxa.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ui.af.a;
import com.tencent.mm.plugin.appbrand.ui.al;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/game/ui/WAGameButtonLayoutPropertiesProvider;", "Lcom/tencent/mm/plugin/appbrand/ui/WxaMenuButtonLayoutPropertiesProvider;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "getExpectedPadding", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Padding;", "luggage-wxa-game-ext_release"})
public final class a
  extends al
{
  public a(AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramAppBrandRuntime);
    AppMethodBeat.i(247447);
    AppMethodBeat.o(247447);
  }
  
  public final af.a Qg()
  {
    AppMethodBeat.i(130752);
    af.a locala = super.Qg();
    locala = new af.a(locala.left, locala.top + CU(a.b.app_brand_game_capsule_extra_margin_top), CU(a.b.app_brand_actionbar_capsule_view_right_margin_default) + CU(a.b.app_brand_game_capsule_extra_margin_right), locala.bottom);
    AppMethodBeat.o(130752);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.f.a
 * JD-Core Version:    0.7.0.1
 */