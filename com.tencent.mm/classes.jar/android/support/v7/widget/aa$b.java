package android.support.v7.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

final class aa$b
  implements ValueAnimator.AnimatorUpdateListener
{
  private aa$b(aa paramaa) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 255.0F);
    aa.d(this.acR).setAlpha(i);
    aa.e(this.acR).setAlpha(i);
    aa.c(this.acR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.aa.b
 * JD-Core Version:    0.7.0.1
 */