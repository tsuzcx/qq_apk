package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class CollapsingToolbarLayout$2
  implements ValueAnimator.AnimatorUpdateListener
{
  CollapsingToolbarLayout$2(CollapsingToolbarLayout paramCollapsingToolbarLayout) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.hp.setScrimAlpha(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.widget.CollapsingToolbarLayout.2
 * JD-Core Version:    0.7.0.1
 */