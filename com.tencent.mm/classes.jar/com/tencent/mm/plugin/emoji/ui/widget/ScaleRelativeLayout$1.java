package com.tencent.mm.plugin.emoji.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class ScaleRelativeLayout$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ScaleRelativeLayout$1(ScaleRelativeLayout paramScaleRelativeLayout) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ScaleRelativeLayout.a(this.jjO, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.jjO.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.widget.ScaleRelativeLayout.1
 * JD-Core Version:    0.7.0.1
 */