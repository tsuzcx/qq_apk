package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

final class SwipeRefreshLayout$8
  extends Animation
{
  SwipeRefreshLayout$8(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.MA.Mk;
    float f2 = -this.MA.Mk;
    this.MA.setAnimationProgress(f1 + f2 * paramFloat);
    this.MA.J(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout.8
 * JD-Core Version:    0.7.0.1
 */