package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

final class SwipeRefreshLayout$4
  extends Animation
{
  SwipeRefreshLayout$4(SwipeRefreshLayout paramSwipeRefreshLayout, int paramInt1, int paramInt2) {}
  
  public final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    this.MA.Mn.setAlpha((int)(this.MB + (this.MC - this.MB) * paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout.4
 * JD-Core Version:    0.7.0.1
 */