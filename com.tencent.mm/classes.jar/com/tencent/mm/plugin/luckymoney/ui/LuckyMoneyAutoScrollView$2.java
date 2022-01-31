package com.tencent.mm.plugin.luckymoney.ui;

import android.widget.ImageView;

final class LuckyMoneyAutoScrollView$2
  implements Runnable
{
  LuckyMoneyAutoScrollView$2(LuckyMoneyAutoScrollView paramLuckyMoneyAutoScrollView) {}
  
  public final void run()
  {
    LuckyMoneyAutoScrollView.a(this.lUp).setVisibility(8);
    LuckyMoneyAutoScrollView.b(this.lUp).setVisibility(8);
    LuckyMoneyAutoScrollView.c(this.lUp).setVisibility(8);
    LuckyMoneyAutoScrollView.d(this.lUp).setVisibility(0);
    LuckyMoneyAutoScrollView.e(this.lUp).setVisibility(0);
    LuckyMoneyAutoScrollView.f(this.lUp).setVisibility(0);
    if (LuckyMoneyAutoScrollView.g(this.lUp) != null) {
      LuckyMoneyAutoScrollView.g(this.lUp).bga();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollView.2
 * JD-Core Version:    0.7.0.1
 */