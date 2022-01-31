package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class h$1
  extends AnimatorListenerAdapter
{
  private boolean mCancelled;
  
  h$1(h paramh, h.c paramc) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.mCancelled = true;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.jL.jw = 0;
    if (!this.mCancelled)
    {
      paramAnimator = this.jL.jG;
      if (!this.jJ) {
        break label43;
      }
    }
    label43:
    for (int i = 8;; i = 4)
    {
      paramAnimator.f(i, this.jJ);
      return;
    }
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.jL.jG.f(0, this.jJ);
    this.mCancelled = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.design.widget.h.1
 * JD-Core Version:    0.7.0.1
 */