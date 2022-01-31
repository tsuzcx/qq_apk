package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class CardHomePageUI$3
  implements MenuItem.OnMenuItemClickListener
{
  CardHomePageUI$3(CardHomePageUI paramCardHomePageUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if ((CardHomePageUI.a(this.ivb) == 1) || (CardHomePageUI.a(this.ivb) == 2))
    {
      CardHomePageUI.b(this.ivb);
      return true;
    }
    this.ivb.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardHomePageUI.3
 * JD-Core Version:    0.7.0.1
 */