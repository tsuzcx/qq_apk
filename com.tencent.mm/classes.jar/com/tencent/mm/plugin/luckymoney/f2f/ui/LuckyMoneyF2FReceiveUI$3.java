package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class LuckyMoneyF2FReceiveUI$3
  implements Animator.AnimatorListener
{
  LuckyMoneyF2FReceiveUI$3(LuckyMoneyF2FReceiveUI paramLuckyMoneyF2FReceiveUI) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(42213);
    ab.i("LuckyMoneyF2FReceiveUI", "packet top in animator end");
    LuckyMoneyF2FReceiveUI.a(this.omq).start();
    AppMethodBeat.o(42213);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI.3
 * JD-Core Version:    0.7.0.1
 */