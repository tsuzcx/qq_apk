package com.tencent.mm.plugin.appbrand.game.c;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class b$4
  implements ValueAnimator.AnimatorUpdateListener
{
  int height = b.agx();
  
  b$4(b paramb) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.gbg.setTranslationY(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * this.height);
    this.gbg.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.b.4
 * JD-Core Version:    0.7.0.1
 */