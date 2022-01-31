package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CardConsumeCodeUI$1
  implements MenuItem.OnMenuItemClickListener
{
  CardConsumeCodeUI$1(CardConsumeCodeUI paramCardConsumeCodeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(88098);
    this.kqR.setResult(-1);
    this.kqR.finish();
    AppMethodBeat.o(88098);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.CardConsumeCodeUI.1
 * JD-Core Version:    0.7.0.1
 */