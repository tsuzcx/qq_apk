package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CardNewMsgUI$1
  implements MenuItem.OnMenuItemClickListener
{
  CardNewMsgUI$1(CardNewMsgUI paramCardNewMsgUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(88592);
    this.kxl.finish();
    AppMethodBeat.o(88592);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI.1
 * JD-Core Version:    0.7.0.1
 */