package com.tencent.mm.e;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;

public final class c$8
  implements ValueAnimator.AnimatorUpdateListener
{
  int bAM = 0;
  float bAN;
  float bAO = 0.0F;
  float bAP;
  float bAQ = 0.0F;
  float bAR = this.bAT;
  float bAS = this.bAU;
  int buE = 0;
  float buF = (float)Math.pow(this.bAV, 0.0833333358168602D);
  
  public c$8(c paramc, float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.buE < 12)
    {
      this.bAK.getMainMatrix().postScale(this.buF, this.buF, c.d(this.bAK).centerX() + this.bAO, c.d(this.bAK).centerY() + this.bAQ);
      c.e(this.bAK).postScale(this.buF, this.buF, c.d(this.bAK).centerX() + this.bAO, c.d(this.bAK).centerY() + this.bAQ);
      this.buE += 1;
    }
    int i = ((Integer)paramValueAnimator.getAnimatedValue("rotation")).intValue();
    int j = ((Integer)paramValueAnimator.getAnimatedValue("deltaX")).intValue();
    int k = ((Integer)paramValueAnimator.getAnimatedValue("deltaY")).intValue();
    this.bAK.getMainMatrix().postRotate(i - this.bAM, this.bAT + this.bAO, this.bAU + this.bAQ);
    c.e(this.bAK).postRotate(i - this.bAM, this.bAT + this.bAO, this.bAU + this.bAQ);
    paramValueAnimator = new RectF();
    paramValueAnimator.set(c.d(this.bAK));
    c.e(this.bAK).mapRect(paramValueAnimator);
    this.bAR += j - this.bAN;
    this.bAS += k - this.bAP;
    this.bAO = (this.bAR - paramValueAnimator.centerX());
    this.bAQ = (this.bAS - paramValueAnimator.centerY());
    this.bAK.getMainMatrix().postTranslate(this.bAO, this.bAQ);
    c.e(this.bAK).postTranslate(this.bAO, this.bAQ);
    this.bAK.tQ();
    this.bAM = i;
    this.bAN = j;
    this.bAP = k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.e.c.8
 * JD-Core Version:    0.7.0.1
 */