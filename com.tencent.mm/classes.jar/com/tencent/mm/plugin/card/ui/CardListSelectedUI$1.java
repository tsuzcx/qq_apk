package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CardListSelectedUI$1
  implements MenuItem.OnMenuItemClickListener
{
  CardListSelectedUI$1(CardListSelectedUI paramCardListSelectedUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(88555);
    this.kwP.setResult(0);
    CardListSelectedUI.a(this.kwP, "");
    this.kwP.finish();
    AppMethodBeat.o(88555);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardListSelectedUI.1
 * JD-Core Version:    0.7.0.1
 */