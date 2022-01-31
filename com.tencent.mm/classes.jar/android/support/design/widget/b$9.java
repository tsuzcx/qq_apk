package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.v4.view.q;

final class b$9
  implements ValueAnimator.AnimatorUpdateListener
{
  private int eY = this.fa;
  
  b$9(b paramb, int paramInt) {}
  
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
 * Qualified Name:     android.support.design.widget.b.9
 * JD-Core Version:    0.7.0.1
 */