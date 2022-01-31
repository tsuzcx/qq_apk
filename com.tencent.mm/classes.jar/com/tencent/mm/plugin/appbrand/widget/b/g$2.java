package com.tencent.mm.plugin.appbrand.widget.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class g$2
  implements ValueAnimator.AnimatorUpdateListener
{
  g$2(g paramg) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.hsG.view != null) {
      this.hsG.view.setBackgroundColor(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.g.2
 * JD-Core Version:    0.7.0.1
 */