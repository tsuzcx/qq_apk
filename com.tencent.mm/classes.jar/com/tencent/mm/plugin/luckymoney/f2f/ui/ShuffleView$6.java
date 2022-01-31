package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShuffleView$6
  implements ValueAnimator.AnimatorUpdateListener
{
  ShuffleView$6(ShuffleView paramShuffleView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(42231);
    if (ShuffleView.z(this.omN) != null) {
      ShuffleView.z(this.omN).a(paramValueAnimator, ShuffleView.w(this.omN));
    }
    AppMethodBeat.o(42231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.6
 * JD-Core Version:    0.7.0.1
 */