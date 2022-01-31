package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;

final class LuckyMoneyMyRecordUI$2
  implements MenuItem.OnMenuItemClickListener
{
  LuckyMoneyMyRecordUI$2(LuckyMoneyMyRecordUI paramLuckyMoneyMyRecordUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new d(this.lVW.mController.uMN, 1, false);
    paramMenuItem.phH = new LuckyMoneyMyRecordUI.2.1(this);
    paramMenuItem.phI = new LuckyMoneyMyRecordUI.2.2(this);
    paramMenuItem.cfU();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.2
 * JD-Core Version:    0.7.0.1
 */