package com.tencent.luggage.game.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.ae;
import com.tencent.mm.plugin.appbrand.ui.z.a;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/luggage/game/ui/WAGameButtonLayoutPropertiesProvider;", "Lcom/tencent/mm/plugin/appbrand/ui/WxaMenuButtonLayoutPropertiesProvider;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getExpectedPadding", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Padding;", "luggage-wxa-game-ext_release"})
public final class a
  extends ae
{
  private final Context context;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(130753);
    this.context = paramContext;
    AppMethodBeat.o(130753);
  }
  
  public final z.a DP()
  {
    AppMethodBeat.i(130752);
    z.a locala = super.DP();
    locala = new z.a(locala.left, locala.top + vy(2131165773), vy(2131167027) + vy(2131165772), locala.bottom);
    AppMethodBeat.o(130752);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.game.f.a
 * JD-Core Version:    0.7.0.1
 */