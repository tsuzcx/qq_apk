package com.tencent.mm.plugin.luckymoney.ui;

import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuckyMoneyAutoScrollView$1
  implements Runnable
{
  LuckyMoneyAutoScrollView$1(LuckyMoneyAutoScrollView paramLuckyMoneyAutoScrollView) {}
  
  public final void run()
  {
    AppMethodBeat.i(42568);
    LuckyMoneyAutoScrollView.a(this.ory).setVisibility(0);
    LuckyMoneyAutoScrollView.b(this.ory).setVisibility(0);
    LuckyMoneyAutoScrollView.c(this.ory).setVisibility(0);
    LuckyMoneyAutoScrollView.d(this.ory).bNM();
    LuckyMoneyAutoScrollView.e(this.ory).bNM();
    LuckyMoneyAutoScrollView.f(this.ory).bNM();
    AppMethodBeat.o(42568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollView.1
 * JD-Core Version:    0.7.0.1
 */