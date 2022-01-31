package android.support.v4.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class d$1
  implements ValueAnimator.AnimatorUpdateListener
{
  d$1(d paramd, d.a parama) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    d.b(f, this.Jj);
    d.a(this.Jk, f, this.Jj, false);
    this.Jk.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.widget.d.1
 * JD-Core Version:    0.7.0.1
 */