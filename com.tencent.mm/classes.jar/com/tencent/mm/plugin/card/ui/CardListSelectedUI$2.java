package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.a;
import com.tencent.mm.plugin.card.model.am;

final class CardListSelectedUI$2
  implements MenuItem.OnMenuItemClickListener
{
  CardListSelectedUI$2(CardListSelectedUI paramCardListSelectedUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if ((!this.ivL.ivx) && (CardListSelectedUI.b(this.ivL).ily))
    {
      this.ivL.ew(true);
      am.aAE().I(CardListSelectedUI.b(this.ivL).ilt, l.yY(CardListSelectedUI.b(this.ivL).userName), 3);
      return true;
    }
    CardListSelectedUI.a(this.ivL);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardListSelectedUI.2
 * JD-Core Version:    0.7.0.1
 */