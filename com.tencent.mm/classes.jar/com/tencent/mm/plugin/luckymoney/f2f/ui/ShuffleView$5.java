package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class ShuffleView$5
  implements Animator.AnimatorListener
{
  ShuffleView$5(ShuffleView paramShuffleView) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(42230);
    ShuffleView.e(this.omN).remove(ShuffleView.w(this.omN));
    if (ShuffleView.x(this.omN) != null) {
      ShuffleView.x(this.omN).start();
    }
    ShuffleView.f(this.omN, ShuffleView.f(this.omN));
    if (ShuffleView.d(this.omN) > 0)
    {
      ShuffleView.e(this.omN, ShuffleView.y(this.omN));
      ShuffleView.b(this.omN, (View)ShuffleView.e(this.omN).get(ShuffleView.f(this.omN)));
      AppMethodBeat.o(42230);
      return;
    }
    ShuffleView.b(this.omN, null);
    ShuffleView.e(this.omN, 0);
    AppMethodBeat.o(42230);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.5
 * JD-Core Version:    0.7.0.1
 */