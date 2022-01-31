package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mm.plugin.appbrand.page.q;

final class n$3
  implements ValueAnimator.AnimatorUpdateListener
{
  n$3(n paramn, q paramq) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    double d = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.gza.q(d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.n.3
 * JD-Core Version:    0.7.0.1
 */