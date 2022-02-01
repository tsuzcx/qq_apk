package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class CardAcceptCardListUI$1
  implements MenuItem.OnMenuItemClickListener
{
  CardAcceptCardListUI$1(CardAcceptCardListUI paramCardAcceptCardListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(113150);
    ae.v("MicroMsg.CardAcceptCardListUI", "setBackBtn cancel");
    CardAcceptCardListUI.a(this.oLa, 1);
    AppMethodBeat.o(113150);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardAcceptCardListUI.1
 * JD-Core Version:    0.7.0.1
 */