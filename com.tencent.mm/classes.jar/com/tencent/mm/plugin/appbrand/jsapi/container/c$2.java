package com.tencent.mm.plugin.appbrand.jsapi.container;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class c$2
  implements ValueAnimator.AnimatorUpdateListener
{
  c$2(c paramc, View paramView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.val$view.setY(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.container.c.2
 * JD-Core Version:    0.7.0.1
 */