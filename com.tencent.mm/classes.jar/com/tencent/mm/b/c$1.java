package com.tencent.mm.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PointF;
import com.tencent.mm.e.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ListIterator;

public final class c$1
  implements ValueAnimator.AnimatorUpdateListener
{
  public c$1(c paramc) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue("deltaY")).floatValue();
    float f2 = ((Float)paramValueAnimator.getAnimatedValue("deltaX")).floatValue();
    y.d("MicroMsg.StickBackAnim", "animatorValueY:%s  %s", new Object[] { Float.valueOf(f1), Float.valueOf(f1 - this.buy.buw) });
    paramValueAnimator = this.buy.but;
    float f3 = this.buy.bux;
    float f4 = this.buy.buw;
    String str = this.buy.buv;
    ListIterator localListIterator = ((com.tencent.mm.cache.c)paramValueAnimator.tI()).wS();
    while (localListIterator.hasPrevious())
    {
      com.tencent.mm.z.c localc = (com.tencent.mm.z.c)localListIterator.previous();
      if (localc.dHK.equals(str))
      {
        localc.dHN.offset(f2 - f3, f1 - f4);
        paramValueAnimator.tQ();
      }
    }
    this.buy.buw = f1;
    this.buy.bux = f2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.b.c.1
 * JD-Core Version:    0.7.0.1
 */