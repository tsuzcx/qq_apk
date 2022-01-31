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
    this.iS.iD = 0;
    if (!this.mCancelled)
    {
      paramAnimator = this.iS.iN;
      if (!this.iQ) {
        break label43;
      }
    }
    label43:
    for (int i = 8;; i = 4)
    {
      paramAnimator.j(i, this.iQ);
      return;
    }
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.iS.iN.j(0, this.iQ);
    this.mCancelled = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.design.widget.h.1
 * JD-Core Version:    0.7.0.1
 */