package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class CardListSelectedUI$1
  implements MenuItem.OnMenuItemClickListener
{
  CardListSelectedUI$1(CardListSelectedUI paramCardListSelectedUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    this.ivL.setResult(0);
    CardListSelectedUI.a(this.ivL, "");
    this.ivL.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardListSelectedUI.1
 * JD-Core Version:    0.7.0.1
 */