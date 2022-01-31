package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.plugin.luckymoney.particles.a.a;
import com.tencent.mm.plugin.wxpay.a.e;
import java.util.Random;

final class LuckyMoneyDetailUI$12
  implements com.tencent.mm.plugin.luckymoney.particles.b
{
  LuckyMoneyDetailUI$12(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final com.tencent.mm.plugin.luckymoney.particles.a.b b(Random paramRandom)
  {
    switch (paramRandom.nextInt(8))
    {
    default: 
      return null;
    case 0: 
      if (LuckyMoneyDetailUI.e(this.lVz) == null) {
        LuckyMoneyDetailUI.a(this.lVz, LuckyMoneyDetailUI.a(this.lVz, a.e.lucky_money_f2f_firework_ribbon_1));
      }
      return new a(LuckyMoneyDetailUI.e(this.lVz));
    case 1: 
      if (LuckyMoneyDetailUI.f(this.lVz) == null) {
        LuckyMoneyDetailUI.b(this.lVz, LuckyMoneyDetailUI.a(this.lVz, a.e.lucky_money_f2f_firework_ribbon_2));
      }
      return new a(LuckyMoneyDetailUI.f(this.lVz));
    case 2: 
      if (LuckyMoneyDetailUI.g(this.lVz) == null) {
        LuckyMoneyDetailUI.c(this.lVz, LuckyMoneyDetailUI.a(this.lVz, a.e.lucky_money_f2f_firework_ribbon_3));
      }
      return new a(LuckyMoneyDetailUI.g(this.lVz));
    case 3: 
      if (LuckyMoneyDetailUI.h(this.lVz) == null) {
        LuckyMoneyDetailUI.d(this.lVz, LuckyMoneyDetailUI.a(this.lVz, a.e.lucky_money_f2f_firework_leaf_top_1));
      }
      return new a(LuckyMoneyDetailUI.h(this.lVz));
    case 4: 
      if (LuckyMoneyDetailUI.i(this.lVz) == null) {
        LuckyMoneyDetailUI.e(this.lVz, LuckyMoneyDetailUI.a(this.lVz, a.e.lucky_money_f2f_firework_leaf_top_2));
      }
      return new a(LuckyMoneyDetailUI.i(this.lVz));
    case 5: 
      if (LuckyMoneyDetailUI.j(this.lVz) == null) {
        LuckyMoneyDetailUI.f(this.lVz, LuckyMoneyDetailUI.a(this.lVz, a.e.lucky_money_f2f_firework_leaf_top_3));
      }
      return new a(LuckyMoneyDetailUI.j(this.lVz));
    case 6: 
      if (LuckyMoneyDetailUI.k(this.lVz) == null) {
        LuckyMoneyDetailUI.g(this.lVz, LuckyMoneyDetailUI.a(this.lVz, a.e.lucky_money_f2f_firework_leaf_top_4));
      }
      return new a(LuckyMoneyDetailUI.k(this.lVz));
    }
    if (LuckyMoneyDetailUI.l(this.lVz) == null) {
      LuckyMoneyDetailUI.h(this.lVz, LuckyMoneyDetailUI.a(this.lVz, a.e.lucky_money_f2f_firework_leaf_top_5));
    }
    return new a(LuckyMoneyDetailUI.l(this.lVz));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.12
 * JD-Core Version:    0.7.0.1
 */