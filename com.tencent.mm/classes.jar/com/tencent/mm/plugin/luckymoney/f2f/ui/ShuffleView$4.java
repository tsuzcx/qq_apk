package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShuffleView$4
  implements Animator.AnimatorListener
{
  ShuffleView$4(ShuffleView paramShuffleView) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(42229);
    ShuffleView.a(this.omN, false);
    ShuffleView.u(this.omN).setVisibility(0);
    if (ShuffleView.v(this.omN) != null) {
      ShuffleView.v(this.omN).start();
    }
    AppMethodBeat.o(42229);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(42228);
    ShuffleView.a(this.omN, true);
    AppMethodBeat.o(42228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.4
 * JD-Core Version:    0.7.0.1
 */