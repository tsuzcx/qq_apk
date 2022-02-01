package android.support.v7.widget.a;

import android.view.animation.Interpolator;

final class a$a$2
  implements Interpolator
{
  public final float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * (paramFloat * paramFloat * paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.a.a.a.2
 * JD-Core Version:    0.7.0.1
 */