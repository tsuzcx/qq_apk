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
  boolean qM = false;
  private final int uQ;
  private final ViewGroup uR;
  private final boolean uS;
  private boolean uT;
  
  Visibility$a(View paramView, int paramInt)
  {
    this.mView = paramView;
    this.uQ = paramInt;
    this.uR = ((ViewGroup)paramView.getParent());
    this.uS = true;
    w(true);
  }
  
  private void cs()
  {
    if (!this.qM)
    {
      au.l(this.mView, this.uQ);
      if (this.uR != null) {
        this.uR.invalidate();
      }
    }
    w(false);
  }
  
  private void w(boolean paramBoolean)
  {
    if ((this.uS) && (this.uT != paramBoolean) && (this.uR != null))
    {
      this.uT = paramBoolean;
      an.c(this.uR, paramBoolean);
    }
  }
  
  public final void a(Transition paramTransition)
  {
    cs();
    paramTransition.b(this);
  }
  
  public final void ce()
  {
    w(false);
  }
  
  public final void cf()
  {
    w(true);
  }
  
  public final void cj() {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.qM = true;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    cs();
  }
  
  public final void onAnimationPause(Animator paramAnimator)
  {
    if (!this.qM) {
      au.l(this.mView, this.uQ);
    }
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationResume(Animator paramAnimator)
  {
    if (!this.qM) {
      au.l(this.mView, 0);
    }
  }
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.transition.Visibility.a
 * JD-Core Version:    0.7.0.1
 */