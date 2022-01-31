package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.v4.view.q;

final class b$3
  implements ValueAnimator.AnimatorUpdateListener
{
  private int eY = 0;
  
  b$3(b paramb) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (b.access$100()) {
      q.p(this.eX.eS, i - this.eY);
    }
    for (;;)
    {
      this.eY = i;
      return;
      this.eX.eS.setTranslationY(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.widget.b.3
 * JD-Core Version:    0.7.0.1
 */