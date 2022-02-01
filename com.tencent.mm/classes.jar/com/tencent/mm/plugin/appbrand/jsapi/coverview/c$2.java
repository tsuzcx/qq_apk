package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$2
  implements ValueAnimator.AnimatorUpdateListener
{
  c$2(c paramc, View paramView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(195000);
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    this.val$view.getLayoutParams().width = paramValueAnimator.intValue();
    this.val$view.requestLayout();
    AppMethodBeat.o(195000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.c.2
 * JD-Core Version:    0.7.0.1
 */