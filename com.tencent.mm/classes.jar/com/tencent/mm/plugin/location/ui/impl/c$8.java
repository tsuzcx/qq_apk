package com.tencent.mm.plugin.location.ui.impl;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$8
  implements ValueAnimator.AnimatorUpdateListener
{
  c$8(c paramc) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(182058);
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = c.x(this.vgy).getLayoutParams();
    paramValueAnimator.height = i;
    c.x(this.vgy).setLayoutParams(paramValueAnimator);
    AppMethodBeat.o(182058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.8
 * JD-Core Version:    0.7.0.1
 */