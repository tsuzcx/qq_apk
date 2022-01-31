package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

final class SwipeRefreshLayout$6
  extends Animation
{
  SwipeRefreshLayout$6(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (!this.Mk.Mf) {}
    for (int i = this.Mk.LV - Math.abs(this.Mk.LU);; i = this.Mk.LV)
    {
      int j = this.Mk.mFrom;
      i = (int)((i - this.Mk.mFrom) * paramFloat);
      int k = this.Mk.LQ.getTop();
      this.Mk.setTargetOffsetTopAndBottom(i + j - k);
      this.Mk.LX.A(1.0F - paramFloat);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout.6
 * JD-Core Version:    0.7.0.1
 */