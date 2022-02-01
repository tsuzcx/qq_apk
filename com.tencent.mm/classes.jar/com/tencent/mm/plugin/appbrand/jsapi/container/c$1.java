package com.tencent.mm.plugin.appbrand.jsapi.container;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$1
  implements ValueAnimator.AnimatorUpdateListener
{
  c$1(c paramc, View paramView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(137509);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.val$view.setX(f);
    AppMethodBeat.o(137509);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.container.c.1
 * JD-Core Version:    0.7.0.1
 */