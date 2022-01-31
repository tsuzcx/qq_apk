package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.a.d;

final class LuckyMoneyF2FQRCodeUI$3
  implements MenuItem.OnMenuItemClickListener
{
  LuckyMoneyF2FQRCodeUI$3(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    LuckyMoneyF2FQRCodeUI.a(this.lOE, new d(this.lOE, 1, false));
    LuckyMoneyF2FQRCodeUI.y(this.lOE).phH = LuckyMoneyF2FQRCodeUI.x(this.lOE);
    LuckyMoneyF2FQRCodeUI.y(this.lOE).phI = LuckyMoneyF2FQRCodeUI.z(this.lOE);
    LuckyMoneyF2FQRCodeUI.y(this.lOE).cfU();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.3
 * JD-Core Version:    0.7.0.1
 */