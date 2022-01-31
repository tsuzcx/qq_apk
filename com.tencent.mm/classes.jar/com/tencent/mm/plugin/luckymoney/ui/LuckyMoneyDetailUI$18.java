package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.plugin.luckymoney.b.ac;
import com.tencent.mm.sdk.platformtools.bk;

final class LuckyMoneyDetailUI$18
  implements LuckyMoneyWishFooter.b
{
  LuckyMoneyDetailUI$18(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void GP(String paramString)
  {
    if ((!bk.bl(paramString)) && (!bk.bl(LuckyMoneyDetailUI.p(this.lVz))))
    {
      paramString = new ac(LuckyMoneyDetailUI.q(this.lVz), paramString, LuckyMoneyDetailUI.p(this.lVz), "v1.0");
      this.lVz.l(paramString);
      LuckyMoneyDetailUI.n(this.lVz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.18
 * JD-Core Version:    0.7.0.1
 */