package com.tencent.luggage.game.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.ac;
import com.tencent.mm.plugin.appbrand.ui.x.a;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/luggage/game/ui/WAGameButtonLayoutPropertiesProvider;", "Lcom/tencent/mm/plugin/appbrand/ui/WxaMenuButtonLayoutPropertiesProvider;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getExpectedPadding", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Padding;", "luggage-wxa-game-ext_release"})
public final class a
  extends ac
{
  private final Context context;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(130753);
    this.context = paramContext;
    AppMethodBeat.o(130753);
  }
  
  public final x.a Cq()
  {
    AppMethodBeat.i(130752);
    x.a locala = super.Cq();
    locala = new x.a(locala.left, locala.top + uT(2131165773), uT(2131167027) + uT(2131165772), locala.bottom);
    AppMethodBeat.o(130752);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.f.a
 * JD-Core Version:    0.7.0.1
 */