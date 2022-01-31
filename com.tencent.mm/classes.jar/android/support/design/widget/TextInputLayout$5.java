package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class TextInputLayout$5
  implements ValueAnimator.AnimatorUpdateListener
{
  TextInputLayout$5(TextInputLayout paramTextInputLayout) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.mT.hW.h(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.widget.TextInputLayout.5
 * JD-Core Version:    0.7.0.1
 */