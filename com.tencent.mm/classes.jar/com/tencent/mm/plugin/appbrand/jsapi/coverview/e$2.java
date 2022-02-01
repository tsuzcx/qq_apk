package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$2
  implements ValueAnimator.AnimatorUpdateListener
{
  e$2(e parame, View paramView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(193665);
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    this.val$view.getLayoutParams().width = paramValueAnimator.intValue();
    this.val$view.requestLayout();
    AppMethodBeat.o(193665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.e.2
 * JD-Core Version:    0.7.0.1
 */