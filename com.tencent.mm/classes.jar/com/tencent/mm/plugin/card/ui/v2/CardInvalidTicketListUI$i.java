package com.tencent.mm.plugin.card.ui.v2;

import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cyp;
import com.tencent.mm.ui.base.o.g;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardInvalidTicketListUI$showDeleteCardAlert$1$2"})
final class CardInvalidTicketListUI$i
  implements o.g
{
  CardInvalidTicketListUI$i(CardInvalidTicketListUI paramCardInvalidTicketListUI, View paramView, cyp paramcyp) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(201391);
    CardInvalidTicketListUI.a(this.qgk, this.qgn);
    AppMethodBeat.o(201391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI.i
 * JD-Core Version:    0.7.0.1
 */