package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class LuckyMoneyDetailUI$13
  implements MenuItem.OnMenuItemClickListener
{
  LuckyMoneyDetailUI$13(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    h.nFQ.f(11701, new Object[] { Integer.valueOf(LuckyMoneyDetailUI.ts(LuckyMoneyDetailUI.m(this.lVz))), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4) });
    paramMenuItem = new Intent();
    paramMenuItem.setClass(this.lVz.mController.uMN, LuckyMoneyMyRecordUI.class);
    paramMenuItem.putExtra("key_type", 2);
    this.lVz.startActivity(paramMenuItem);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.13
 * JD-Core Version:    0.7.0.1
 */