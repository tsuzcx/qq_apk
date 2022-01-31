package com.tencent.mm.plugin.appbrand.page;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class w$4
  implements ValueAnimator.AnimatorUpdateListener
{
  w$4(w paramw) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.gVh.getView().setScrollY(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.w.4
 * JD-Core Version:    0.7.0.1
 */