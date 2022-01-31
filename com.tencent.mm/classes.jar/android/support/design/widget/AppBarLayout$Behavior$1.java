package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class AppBarLayout$Behavior$1
  implements ValueAnimator.AnimatorUpdateListener
{
  AppBarLayout$Behavior$1(AppBarLayout.Behavior paramBehavior, CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.fJ.c(this.fH, this.fI, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.design.widget.AppBarLayout.Behavior.1
 * JD-Core Version:    0.7.0.1
 */