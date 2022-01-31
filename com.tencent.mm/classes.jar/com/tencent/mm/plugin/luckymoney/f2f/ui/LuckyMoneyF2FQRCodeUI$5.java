package com.tencent.mm.plugin.luckymoney.f2f.ui;

import com.tencent.mm.plugin.luckymoney.f2f.a;

final class LuckyMoneyF2FQRCodeUI$5
  implements ShuffleView.b
{
  LuckyMoneyF2FQRCodeUI$5(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI) {}
  
  public final void dc(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 8)
    {
      LuckyMoneyF2FQRCodeUI.F(this.lOE).eE("music" + (paramInt1 + 1) + ".m4a");
      arrayOfInt = LuckyMoneyF2FQRCodeUI.I(this.lOE);
      arrayOfInt[4] += 1;
      return;
    }
    LuckyMoneyF2FQRCodeUI.F(this.lOE).eE("touch_card.m4a");
    int[] arrayOfInt = LuckyMoneyF2FQRCodeUI.I(this.lOE);
    arrayOfInt[2] += 1;
  }
  
  public final void dd(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 8)
    {
      LuckyMoneyF2FQRCodeUI.F(this.lOE).eE("music" + (paramInt1 + 1) + ".m4a");
      return;
    }
    LuckyMoneyF2FQRCodeUI.F(this.lOE).eE("select_card.m4a");
  }
  
  public final void th(int paramInt)
  {
    LuckyMoneyF2FQRCodeUI.J(this.lOE);
    if (paramInt != 8)
    {
      LuckyMoneyF2FQRCodeUI.F(this.lOE).eE("select_card.m4a");
      arrayOfInt = LuckyMoneyF2FQRCodeUI.I(this.lOE);
      arrayOfInt[3] += 1;
      return;
    }
    int[] arrayOfInt = LuckyMoneyF2FQRCodeUI.I(this.lOE);
    arrayOfInt[5] += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.5
 * JD-Core Version:    0.7.0.1
 */