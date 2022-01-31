package android.support.design.widget;

import android.support.v4.view.b.b;
import android.support.v4.view.b.c;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

final class a
{
  static final Interpolator fi = new LinearInterpolator();
  static final Interpolator fj = new b();
  static final Interpolator fk = new android.support.v4.view.b.a();
  static final Interpolator fl = new c();
  static final Interpolator fn = new DecelerateInterpolator();
  
  static float b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
  
  static int b(int paramInt1, int paramInt2, float paramFloat)
  {
    return Math.round((paramInt2 - paramInt1) * paramFloat) + paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.a
 * JD-Core Version:    0.7.0.1
 */