package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class TabLayout$1
  implements ValueAnimator.AnimatorUpdateListener
{
  TabLayout$1(TabLayout paramTabLayout) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.kI.scrollTo(((Integer)paramValueAnimator.getAnimatedValue()).intValue(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.design.widget.TabLayout.1
 * JD-Core Version:    0.7.0.1
 */