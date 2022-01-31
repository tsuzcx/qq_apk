package com.tencent.mm.plugin.appbrand.page;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class aa$1
  implements ValueAnimator.AnimatorUpdateListener
{
  aa$1(aa paramaa) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(87277);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.ixW.pd((int)f);
    AppMethodBeat.o(87277);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aa.1
 * JD-Core Version:    0.7.0.1
 */