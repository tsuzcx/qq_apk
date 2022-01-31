package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuckyMoneyF2FReceiveUI$1
  implements View.OnClickListener
{
  LuckyMoneyF2FReceiveUI$1(LuckyMoneyF2FReceiveUI paramLuckyMoneyF2FReceiveUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42211);
    LuckyMoneyF2FReceiveUI.a(this.omq).cancel();
    this.omq.finish();
    AppMethodBeat.o(42211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI.1
 * JD-Core Version:    0.7.0.1
 */