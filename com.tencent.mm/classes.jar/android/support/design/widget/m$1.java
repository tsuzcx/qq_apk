package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class m$1
  extends AnimatorListenerAdapter
{
  m$1(m paramm) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jO.jM == paramAnimator) {
      this.jO.jM = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.m.1
 * JD-Core Version:    0.7.0.1
 */