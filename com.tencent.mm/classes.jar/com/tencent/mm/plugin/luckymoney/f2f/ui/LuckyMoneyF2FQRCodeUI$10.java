package com.tencent.mm.plugin.luckymoney.f2f.ui;

import com.tencent.mm.plugin.luckymoney.particles.a.a;
import com.tencent.mm.plugin.wxpay.a.e;
import java.util.Random;

final class LuckyMoneyF2FQRCodeUI$10
  implements com.tencent.mm.plugin.luckymoney.particles.b
{
  LuckyMoneyF2FQRCodeUI$10(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI) {}
  
  public final com.tencent.mm.plugin.luckymoney.particles.a.b b(Random paramRandom)
  {
    int i = paramRandom.nextInt(100);
    if (i < 16)
    {
      if (LuckyMoneyF2FQRCodeUI.i(this.lOE) == null) {
        LuckyMoneyF2FQRCodeUI.a(this.lOE, LuckyMoneyF2FQRCodeUI.a(this.lOE, a.e.lucky_money_f2f_firework_ribbon_1, 36));
      }
      return new a(LuckyMoneyF2FQRCodeUI.i(this.lOE));
    }
    if (i < 33)
    {
      if (LuckyMoneyF2FQRCodeUI.j(this.lOE) == null) {
        LuckyMoneyF2FQRCodeUI.b(this.lOE, LuckyMoneyF2FQRCodeUI.a(this.lOE, a.e.lucky_money_f2f_firework_ribbon_2, 36));
      }
      return new a(LuckyMoneyF2FQRCodeUI.j(this.lOE));
    }
    if (i < 50)
    {
      if (LuckyMoneyF2FQRCodeUI.k(this.lOE) == null) {
        LuckyMoneyF2FQRCodeUI.c(this.lOE, LuckyMoneyF2FQRCodeUI.a(this.lOE, a.e.lucky_money_f2f_firework_ribbon_3, 36));
      }
      return new a(LuckyMoneyF2FQRCodeUI.k(this.lOE));
    }
    if (i < 70)
    {
      if (LuckyMoneyF2FQRCodeUI.l(this.lOE) == null) {
        LuckyMoneyF2FQRCodeUI.d(this.lOE, LuckyMoneyF2FQRCodeUI.a(this.lOE, a.e.lucky_money_f2f_firework_leaf_top_1, 36));
      }
      return new a(LuckyMoneyF2FQRCodeUI.l(this.lOE));
    }
    if (i < 90)
    {
      if (LuckyMoneyF2FQRCodeUI.m(this.lOE) == null) {
        LuckyMoneyF2FQRCodeUI.e(this.lOE, LuckyMoneyF2FQRCodeUI.a(this.lOE, a.e.lucky_money_f2f_firework_leaf_top_2, 36));
      }
      return new a(LuckyMoneyF2FQRCodeUI.m(this.lOE));
    }
    if (LuckyMoneyF2FQRCodeUI.n(this.lOE) == null) {
      LuckyMoneyF2FQRCodeUI.f(this.lOE, LuckyMoneyF2FQRCodeUI.a(this.lOE, a.e.lucky_money_f2f_firework_leaf_top_3, 36));
    }
    return new a(LuckyMoneyF2FQRCodeUI.n(this.lOE));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.10
 * JD-Core Version:    0.7.0.1
 */