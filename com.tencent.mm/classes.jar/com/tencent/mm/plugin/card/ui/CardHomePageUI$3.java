package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CardHomePageUI$3
  implements MenuItem.OnMenuItemClickListener
{
  CardHomePageUI$3(CardHomePageUI paramCardHomePageUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(88485);
    if ((CardHomePageUI.a(this.kwf) == 1) || (CardHomePageUI.a(this.kwf) == 2)) {
      CardHomePageUI.b(this.kwf);
    }
    for (;;)
    {
      AppMethodBeat.o(88485);
      return true;
      this.kwf.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardHomePageUI.3
 * JD-Core Version:    0.7.0.1
 */