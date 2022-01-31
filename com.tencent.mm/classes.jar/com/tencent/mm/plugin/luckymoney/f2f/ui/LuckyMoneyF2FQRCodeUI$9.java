package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

final class LuckyMoneyF2FQRCodeUI$9
  implements n.d
{
  LuckyMoneyF2FQRCodeUI$9(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    }
    if (LuckyMoneyF2FQRCodeUI.g(this.lOE) > 0)
    {
      LuckyMoneyF2FQRCodeUI.h(this.lOE);
      return;
    }
    h.bC(this.lOE, this.lOE.getString(a.i.lucky_money_f2f_clear_zero_packet_tips));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.9
 * JD-Core Version:    0.7.0.1
 */