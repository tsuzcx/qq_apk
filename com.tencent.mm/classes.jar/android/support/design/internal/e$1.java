package android.support.design.internal;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;

final class e$1
  implements ValueAnimator.AnimatorUpdateListener
{
  e$1(e parame, TextView paramTextView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.fg.setScaleX(f);
    this.fg.setScaleY(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.design.internal.e.1
 * JD-Core Version:    0.7.0.1
 */