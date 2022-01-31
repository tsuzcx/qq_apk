package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.report.service.h;

final class CardNewMsgUI$6
  implements MenuItem.OnMenuItemClickListener
{
  CardNewMsgUI$6(CardNewMsgUI paramCardNewMsgUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    h.nFQ.f(11582, new Object[] { "CardMsgClearMenu", Integer.valueOf(2), Integer.valueOf(0), "", "", "" });
    CardNewMsgUI.h(this.iwh);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI.6
 * JD-Core Version:    0.7.0.1
 */