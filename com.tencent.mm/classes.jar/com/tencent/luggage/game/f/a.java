package com.tencent.luggage.game.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.aa.a;
import com.tencent.mm.plugin.appbrand.ui.af;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/luggage/game/ui/WAGameButtonLayoutPropertiesProvider;", "Lcom/tencent/mm/plugin/appbrand/ui/WxaMenuButtonLayoutPropertiesProvider;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getExpectedPadding", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Padding;", "luggage-wxa-game-ext_release"})
public final class a
  extends af
{
  private final Context context;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(130753);
    this.context = paramContext;
    AppMethodBeat.o(130753);
  }
  
  public final aa.a DS()
  {
    AppMethodBeat.i(130752);
    aa.a locala = super.DS();
    locala = new aa.a(locala.left, locala.top + vD(2131165773), vD(2131167027) + vD(2131165772), locala.bottom);
    AppMethodBeat.o(130752);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.f.a
 * JD-Core Version:    0.7.0.1
 */