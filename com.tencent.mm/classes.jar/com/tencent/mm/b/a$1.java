package com.tencent.mm.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.e.c;

final class a$1
  implements ValueAnimator.AnimatorUpdateListener
{
  Rect bVA;
  Matrix bVz;
  
  a$1(a parama)
  {
    AppMethodBeat.i(116135);
    this.bVz = new Matrix(this.bVB.bVr.getMainMatrix());
    this.bVA = new Rect(this.bVB.bVv);
    AppMethodBeat.o(116135);
  }
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(116136);
    float f1 = ((Float)paramValueAnimator.getAnimatedValue("deltaY")).floatValue();
    float f2 = ((Float)paramValueAnimator.getAnimatedValue("deltaX")).floatValue();
    float f3 = ((Float)paramValueAnimator.getAnimatedValue("scale")).floatValue();
    float f4 = ((Float)paramValueAnimator.getAnimatedValue("background_alpha")).floatValue();
    this.bVB.bVx.reset();
    this.bVB.bVx.postTranslate(f2, f1);
    paramValueAnimator = new RectF(this.bVA);
    this.bVB.bVx.mapRect(paramValueAnimator);
    paramValueAnimator.round(this.bVB.bVv);
    this.bVB.bVx.postScale(f3, f3, this.bVB.bVv.centerX(), this.bVB.bVv.centerY());
    paramValueAnimator = new Matrix(this.bVz);
    paramValueAnimator.postConcat(this.bVB.bVx);
    this.bVB.bVr.getMainMatrix().set(paramValueAnimator);
    com.tencent.mm.y.a.jx((int)f4);
    paramValueAnimator = new RectF(this.bVA);
    this.bVB.bVx.mapRect(paramValueAnimator);
    paramValueAnimator.round(this.bVB.bVv);
    this.bVB.bVr.CI();
    AppMethodBeat.o(116136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.b.a.1
 * JD-Core Version:    0.7.0.1
 */