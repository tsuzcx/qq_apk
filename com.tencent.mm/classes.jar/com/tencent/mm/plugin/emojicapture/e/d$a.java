package com.tencent.mm.plugin.emojicapture.e;

import a.d.a.a;
import a.d.b.g;
import a.k;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;

final class d$a
  implements ValueAnimator.AnimatorUpdateListener
{
  d$a(d paramd, Matrix paramMatrix, float paramFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, a parama) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    d locald = this.jmX;
    g.j(paramValueAnimator, "animation");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null) {
      throw new k("null cannot be cast to non-null type kotlin.Float");
    }
    float f = ((Float)paramValueAnimator).floatValue();
    this.jmY.setTranslate(-locald.jmW[0], -locald.jmW[1]);
    this.jmY.postScale(d.j(this.jmZ, this.jna, f), d.j(this.jmZ, this.jna, f));
    this.jmY.postRotate(this.jnb);
    this.jmY.postTranslate(d.j(this.jnc[0], this.jnd[0], f), d.j(this.jnc[1], this.jnd[1], f));
    paramValueAnimator = this.jne;
    if (paramValueAnimator != null) {
      paramValueAnimator.invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.d.a
 * JD-Core Version:    0.7.0.1
 */