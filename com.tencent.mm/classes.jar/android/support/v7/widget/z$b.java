package android.support.v7.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

final class z$b
  implements ValueAnimator.AnimatorUpdateListener
{
  private z$b(z paramz) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 255.0F);
    z.d(this.adB).setAlpha(i);
    z.e(this.adB).setAlpha(i);
    z.c(this.adB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.z.b
 * JD-Core Version:    0.7.0.1
 */