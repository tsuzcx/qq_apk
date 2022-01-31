package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CardDetailBaseUI$1
  implements View.OnClickListener
{
  CardDetailBaseUI$1(CardDetailBaseUI paramCardDetailBaseUI, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(88255);
    if (this.ksX != null) {
      this.ksX.onMenuItemClick(null);
    }
    AppMethodBeat.o(88255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailBaseUI.1
 * JD-Core Version:    0.7.0.1
 */