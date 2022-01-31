package com.tencent.mm.plugin.appbrand.page;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class ac$2
  implements ValueAnimator.AnimatorUpdateListener
{
  ac$2(ac paramac) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.gVF.getContentView().setScrollY(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ac.2
 * JD-Core Version:    0.7.0.1
 */