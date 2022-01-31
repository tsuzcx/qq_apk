package com.tencent.mm.plugin.luckymoney.ui;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuckyMoneyAutoScrollView$2
  implements Runnable
{
  LuckyMoneyAutoScrollView$2(LuckyMoneyAutoScrollView paramLuckyMoneyAutoScrollView) {}
  
  public final void run()
  {
    AppMethodBeat.i(42569);
    LuckyMoneyAutoScrollView.a(this.ory).setVisibility(8);
    LuckyMoneyAutoScrollView.b(this.ory).setVisibility(8);
    LuckyMoneyAutoScrollView.c(this.ory).setVisibility(8);
    LuckyMoneyAutoScrollView.d(this.ory).setVisibility(8);
    LuckyMoneyAutoScrollView.e(this.ory).setVisibility(8);
    LuckyMoneyAutoScrollView.f(this.ory).setVisibility(8);
    LuckyMoneyAutoScrollView.g(this.ory).setVisibility(0);
    LuckyMoneyAutoScrollView.h(this.ory).setVisibility(0);
    LuckyMoneyAutoScrollView.i(this.ory).setVisibility(0);
    if (LuckyMoneyAutoScrollView.j(this.ory) != null) {
      LuckyMoneyAutoScrollView.j(this.ory).bNO();
    }
    AppMethodBeat.o(42569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollView.2
 * JD-Core Version:    0.7.0.1
 */