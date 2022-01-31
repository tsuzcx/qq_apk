package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mm.plugin.appbrand.page.q;

final class n$1
  implements ValueAnimator.AnimatorUpdateListener
{
  n$1(n paramn, q paramq) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.gza.kY(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.gza.kW(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.n.1
 * JD-Core Version:    0.7.0.1
 */