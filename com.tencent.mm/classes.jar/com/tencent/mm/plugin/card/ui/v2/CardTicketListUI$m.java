package com.tencent.mm.plugin.card.ui.v2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.i;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/card/ui/v2/CardTicketListUI$weAppOpenUICallback$1", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenUICallback;", "onAppBrandPreconditionError", "", "onAppBrandProcessDied", "onAppBrandUIEnter", "onAppBrandUIExit", "isFinish", "", "plugin-card_release"})
public final class CardTicketListUI$m
  implements i
{
  public final void bFd()
  {
    AppMethodBeat.i(247925);
    Log.i("MicroMsg.CardTicketListUI", "onAppBrandPreconditionError");
    AppMethodBeat.o(247925);
  }
  
  public final void bFe()
  {
    AppMethodBeat.i(247926);
    Log.i("MicroMsg.CardTicketListUI", "onAppBrandUIEnter");
    AppMethodBeat.o(247926);
  }
  
  public final void bFf()
  {
    AppMethodBeat.i(247929);
    Log.i("MicroMsg.CardTicketListUI", "onAppBrandProcessDied");
    CardTicketListUI.n(this.tCJ);
    AppMethodBeat.o(247929);
  }
  
  public final void hn(boolean paramBoolean)
  {
    AppMethodBeat.i(247927);
    Log.i("MicroMsg.CardTicketListUI", "onAppBrandUIExit(isFinish=" + paramBoolean + ')');
    CardTicketListUI.n(this.tCJ);
    AppMethodBeat.o(247927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardTicketListUI.m
 * JD-Core Version:    0.7.0.1
 */