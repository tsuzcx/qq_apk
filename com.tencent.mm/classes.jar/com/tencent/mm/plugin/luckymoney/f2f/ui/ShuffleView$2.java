package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShuffleView$2
  implements Animator.AnimatorListener
{
  ShuffleView$2(ShuffleView paramShuffleView) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(42226);
    ShuffleView.a(this.omN, false);
    ShuffleView.a(this.omN, null);
    ShuffleView.d(this.omN, -1);
    AppMethodBeat.o(42226);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(42225);
    ShuffleView.a(this.omN, true);
    AppMethodBeat.o(42225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.2
 * JD-Core Version:    0.7.0.1
 */