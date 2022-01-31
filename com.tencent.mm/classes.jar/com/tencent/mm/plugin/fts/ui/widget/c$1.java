package com.tencent.mm.plugin.fts.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class c$1
  implements ValueAnimator.AnimatorUpdateListener
{
  c$1(c paramc) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    c.a(this.kFW, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.kFW.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.c.1
 * JD-Core Version:    0.7.0.1
 */