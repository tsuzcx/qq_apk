package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import com.tencent.mm.sdk.platformtools.y;

final class LuckyMoneyF2FReceiveUI$3
  implements Animator.AnimatorListener
{
  LuckyMoneyF2FReceiveUI$3(LuckyMoneyF2FReceiveUI paramLuckyMoneyF2FReceiveUI) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    y.i("LuckyMoneyF2FReceiveUI", "packet top in animator end");
    LuckyMoneyF2FReceiveUI.a(this.lOW).start();
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI.3
 * JD-Core Version:    0.7.0.1
 */