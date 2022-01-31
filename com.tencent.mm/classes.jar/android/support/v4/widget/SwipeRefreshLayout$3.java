package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

final class SwipeRefreshLayout$3
  extends Animation
{
  SwipeRefreshLayout$3(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    this.Mk.setAnimationProgress(1.0F - paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout.3
 * JD-Core Version:    0.7.0.1
 */