package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class TabLayout$d$1
  implements ValueAnimator.AnimatorUpdateListener
{
  TabLayout$d$1(TabLayout.d paramd, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    this.lT.i(a.b(this.lP, this.lQ, f), a.b(this.lR, this.lS, f));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.widget.TabLayout.d.1
 * JD-Core Version:    0.7.0.1
 */