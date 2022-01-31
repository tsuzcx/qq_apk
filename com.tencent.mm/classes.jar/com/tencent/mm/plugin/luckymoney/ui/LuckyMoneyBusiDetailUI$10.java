package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.plugin.luckymoney.b.ac;
import com.tencent.mm.sdk.platformtools.bk;

final class LuckyMoneyBusiDetailUI$10
  implements LuckyMoneyWishFooter.b
{
  LuckyMoneyBusiDetailUI$10(LuckyMoneyBusiDetailUI paramLuckyMoneyBusiDetailUI) {}
  
  public final void GP(String paramString)
  {
    if ((!bk.bl(paramString)) && (!bk.bl(LuckyMoneyBusiDetailUI.g(this.lUH))))
    {
      paramString = new ac(LuckyMoneyBusiDetailUI.h(this.lUH), paramString, LuckyMoneyBusiDetailUI.g(this.lUH), "v1.0");
      this.lUH.l(paramString);
      LuckyMoneyBusiDetailUI.e(this.lUH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.10
 * JD-Core Version:    0.7.0.1
 */