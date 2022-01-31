package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.v4.view.t;

final class b$3
  implements ValueAnimator.AnimatorUpdateListener
{
  private int fX = 0;
  
  b$3(b paramb) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (b.access$100()) {
      t.q(this.fW.fR, i - this.fX);
    }
    for (;;)
    {
      this.fX = i;
      return;
      this.fW.fR.setTranslationY(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.widget.b.3
 * JD-Core Version:    0.7.0.1
 */