package android.support.design.a;

import android.animation.TimeInterpolator;
import android.support.v4.view.b.b;
import android.support.v4.view.b.c;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public final class a
{
  public static final TimeInterpolator dP = new LinearInterpolator();
  public static final TimeInterpolator dQ = new b();
  public static final TimeInterpolator dR = new android.support.v4.view.b.a();
  public static final TimeInterpolator dS = new c();
  public static final TimeInterpolator dT = new DecelerateInterpolator();
  
  public static int b(int paramInt1, int paramInt2, float paramFloat)
  {
    return Math.round((paramInt2 - paramInt1) * paramFloat) + paramInt1;
  }
  
  public static float lerp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.a.a
 * JD-Core Version:    0.7.0.1
 */