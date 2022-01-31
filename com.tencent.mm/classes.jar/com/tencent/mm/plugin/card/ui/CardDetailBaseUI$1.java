package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;

final class CardDetailBaseUI$1
  implements View.OnClickListener
{
  CardDetailBaseUI$1(CardDetailBaseUI paramCardDetailBaseUI, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener) {}
  
  public final void onClick(View paramView)
  {
    if (this.irQ != null) {
      this.irQ.onMenuItemClick(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailBaseUI.1
 * JD-Core Version:    0.7.0.1
 */