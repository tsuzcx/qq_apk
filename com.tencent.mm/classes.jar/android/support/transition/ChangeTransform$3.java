package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.view.View;

final class ChangeTransform$3
  extends AnimatorListenerAdapter
{
  private boolean mIsCanceled;
  private Matrix re = new Matrix();
  
  ChangeTransform$3(ChangeTransform paramChangeTransform, boolean paramBoolean, Matrix paramMatrix, View paramView, ChangeTransform.c paramc, ChangeTransform.b paramb) {}
  
  private void a(Matrix paramMatrix)
  {
    this.re.set(paramMatrix);
    this.val$view.setTag(2131820686, this.re);
    this.rh.y(this.val$view);
  }
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.mIsCanceled = true;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.mIsCanceled)
    {
      if ((!this.rf) || (!ChangeTransform.a(this.rj))) {
        break label52;
      }
      a(this.rg);
    }
    for (;;)
    {
      au.c(this.val$view, null);
      this.rh.y(this.val$view);
      return;
      label52:
      this.val$view.setTag(2131820686, null);
      this.val$view.setTag(2131820648, null);
    }
  }
  
  public final void onAnimationPause(Animator paramAnimator)
  {
    a(this.ri.mMatrix);
  }
  
  public final void onAnimationResume(Animator paramAnimator)
  {
    ChangeTransform.x(this.val$view);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.ChangeTransform.3
 * JD-Core Version:    0.7.0.1
 */