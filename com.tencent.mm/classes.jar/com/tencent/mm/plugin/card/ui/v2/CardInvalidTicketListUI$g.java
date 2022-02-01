package com.tencent.mm.plugin.card.ui.v2;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class CardInvalidTicketListUI$g
  implements MenuItem.OnMenuItemClickListener
{
  CardInvalidTicketListUI$g(CardInvalidTicketListUI paramCardInvalidTicketListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(112484);
    this.oSw.finish();
    AppMethodBeat.o(112484);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI.g
 * JD-Core Version:    0.7.0.1
 */