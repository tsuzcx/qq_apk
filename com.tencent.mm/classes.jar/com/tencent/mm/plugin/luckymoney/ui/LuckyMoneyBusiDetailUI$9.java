package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMEditText.a;

final class LuckyMoneyBusiDetailUI$9
  implements MMEditText.a
{
  LuckyMoneyBusiDetailUI$9(LuckyMoneyBusiDetailUI paramLuckyMoneyBusiDetailUI) {}
  
  public final void bgg()
  {
    if (LuckyMoneyBusiDetailUI.f(this.lUH).getVisibility() == 0)
    {
      LuckyMoneyBusiDetailUI.f(this.lUH).setVisibility(8);
      return;
    }
    this.lUH.mController.uMN.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.9
 * JD-Core Version:    0.7.0.1
 */