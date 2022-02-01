package com.tencent.mm.plugin.card.ui.v2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.i;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/card/ui/v2/CardTicketListUI$weAppOpenUICallback$1", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenUICallback;", "onAppBrandPreconditionError", "", "onAppBrandProcessDied", "onAppBrandUIEnter", "onAppBrandUIExit", "isFinish", "", "plugin-card_release"})
public final class CardTicketListUI$m
  implements i
{
  public final void bud()
  {
    AppMethodBeat.i(201411);
    Log.i("MicroMsg.CardTicketListUI", "onAppBrandPreconditionError");
    AppMethodBeat.o(201411);
  }
  
  public final void bue()
  {
    AppMethodBeat.i(201412);
    Log.i("MicroMsg.CardTicketListUI", "onAppBrandUIEnter");
    AppMethodBeat.o(201412);
  }
  
  public final void buf()
  {
    AppMethodBeat.i(201414);
    Log.i("MicroMsg.CardTicketListUI", "onAppBrandProcessDied");
    CardTicketListUI.n(this.qgN);
    AppMethodBeat.o(201414);
  }
  
  public final void gC(boolean paramBoolean)
  {
    AppMethodBeat.i(201413);
    Log.i("MicroMsg.CardTicketListUI", "onAppBrandUIExit(isFinish=" + paramBoolean + ')');
    CardTicketListUI.n(this.qgN);
    AppMethodBeat.o(201413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardTicketListUI.m
 * JD-Core Version:    0.7.0.1
 */