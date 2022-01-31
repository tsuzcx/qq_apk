package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

final class SwipeRefreshLayout$6
  extends Animation
{
  SwipeRefreshLayout$6(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (!this.MA.Mv) {}
    for (int i = this.MA.Mm - Math.abs(this.MA.Ml);; i = this.MA.Mm)
    {
      int j = this.MA.mFrom;
      i = (int)((i - this.MA.mFrom) * paramFloat);
      int k = this.MA.Mi.getTop();
      this.MA.setTargetOffsetTopAndBottom(i + j - k);
      this.MA.Mn.A(1.0F - paramFloat);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout.6
 * JD-Core Version:    0.7.0.1
 */