package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class SwipeRefreshLayout$1
  implements Animation.AnimationListener
{
  SwipeRefreshLayout$1(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (this.MA.LV)
    {
      this.MA.Mn.setAlpha(255);
      this.MA.Mn.start();
      if ((this.MA.Mt) && (this.MA.LU != null)) {
        paramAnimation = this.MA.LU;
      }
      this.MA.Md = this.MA.Mi.getTop();
      return;
    }
    this.MA.reset();
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout.1
 * JD-Core Version:    0.7.0.1
 */