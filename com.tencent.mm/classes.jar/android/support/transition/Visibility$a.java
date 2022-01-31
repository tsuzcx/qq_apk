package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

final class Visibility$a
  extends AnimatorListenerAdapter
  implements Transition.c, b.a
{
  private final View mView;
  boolean pP = false;
  private final int tP;
  private final ViewGroup tQ;
  private final boolean tR;
  private boolean tS;
  
  Visibility$a(View paramView, int paramInt)
  {
    this.mView = paramView;
    this.tP = paramInt;
    this.tQ = ((ViewGroup)paramView.getParent());
    this.tR = true;
    v(true);
  }
  
  private void bE()
  {
    if (!this.pP)
    {
      av.k(this.mView, this.tP);
      if (this.tQ != null) {
        this.tQ.invalidate();
      }
    }
    v(false);
  }
  
  private void v(boolean paramBoolean)
  {
    if ((this.tR) && (this.tS != paramBoolean) && (this.tQ != null))
    {
      this.tS = paramBoolean;
      ao.c(this.tQ, paramBoolean);
    }
  }
  
  public final void a(Transition paramTransition)
  {
    bE();
    paramTransition.b(this);
  }
  
  public final void bq()
  {
    v(false);
  }
  
  public final void br()
  {
    v(true);
  }
  
  public final void bv() {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.pP = true;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    bE();
  }
  
  public final void onAnimationPause(Animator paramAnimator)
  {
    if (!this.pP) {
      av.k(this.mView, this.tP);
    }
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationResume(Animator paramAnimator)
  {
    if (!this.pP) {
      av.k(this.mView, 0);
    }
  }
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.transition.Visibility.a
 * JD-Core Version:    0.7.0.1
 */