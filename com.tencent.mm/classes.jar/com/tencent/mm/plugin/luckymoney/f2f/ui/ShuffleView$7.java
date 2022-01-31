package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShuffleView$7
  implements ValueAnimator.AnimatorUpdateListener
{
  ShuffleView$7(ShuffleView paramShuffleView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(42232);
    if (ShuffleView.A(this.omN) != null) {
      ShuffleView.A(this.omN).a(paramValueAnimator, ShuffleView.u(this.omN));
    }
    AppMethodBeat.o(42232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.7
 * JD-Core Version:    0.7.0.1
 */