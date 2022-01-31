package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CardConsumeSuccessUI$1
  implements MenuItem.OnMenuItemClickListener
{
  CardConsumeSuccessUI$1(CardConsumeSuccessUI paramCardConsumeSuccessUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(88117);
    this.krj.finish();
    CardConsumeSuccessUI.bcL();
    AppMethodBeat.o(88117);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI.1
 * JD-Core Version:    0.7.0.1
 */