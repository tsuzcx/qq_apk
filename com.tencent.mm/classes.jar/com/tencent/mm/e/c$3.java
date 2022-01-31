package com.tencent.mm.e;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mm.z.a;

final class c$3
  implements ValueAnimator.AnimatorUpdateListener
{
  c$3(c paramc) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue("bg_alpha")).intValue();
    int j = ((Integer)paramValueAnimator.getAnimatedValue("alpha")).intValue();
    c.a(this.bAK);
    a.hg(j);
    c.a(this.bAK);
    a.hh(i);
    this.bAK.tQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.e.c.3
 * JD-Core Version:    0.7.0.1
 */