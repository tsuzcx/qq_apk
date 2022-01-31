package android.support.v7.widget;

import android.view.animation.Interpolator;

final class RecyclerView$3
  implements Interpolator
{
  public final float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * (paramFloat * paramFloat * paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.3
 * JD-Core Version:    0.7.0.1
 */