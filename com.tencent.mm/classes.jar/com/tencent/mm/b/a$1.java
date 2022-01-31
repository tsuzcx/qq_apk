package com.tencent.mm.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mm.e.c;

final class a$1
  implements ValueAnimator.AnimatorUpdateListener
{
  Matrix buo = new Matrix(this.buq.bug.getMainMatrix());
  Rect bup = new Rect(this.buq.buk);
  
  a$1(a parama) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue("deltaY")).floatValue();
    float f2 = ((Float)paramValueAnimator.getAnimatedValue("deltaX")).floatValue();
    float f3 = ((Float)paramValueAnimator.getAnimatedValue("scale")).floatValue();
    float f4 = ((Float)paramValueAnimator.getAnimatedValue("background_alpha")).floatValue();
    this.buq.bum.reset();
    this.buq.bum.postTranslate(f2, f1);
    paramValueAnimator = new RectF(this.bup);
    this.buq.bum.mapRect(paramValueAnimator);
    paramValueAnimator.round(this.buq.buk);
    this.buq.bum.postScale(f3, f3, this.buq.buk.centerX(), this.buq.buk.centerY());
    paramValueAnimator = new Matrix(this.buo);
    paramValueAnimator.postConcat(this.buq.bum);
    this.buq.bug.getMainMatrix().set(paramValueAnimator);
    paramValueAnimator = this.buq.bug.bAp;
    com.tencent.mm.z.a.hh((int)f4);
    paramValueAnimator = new RectF(this.bup);
    this.buq.bum.mapRect(paramValueAnimator);
    paramValueAnimator.round(this.buq.buk);
    this.buq.bug.tQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.b.a.1
 * JD-Core Version:    0.7.0.1
 */