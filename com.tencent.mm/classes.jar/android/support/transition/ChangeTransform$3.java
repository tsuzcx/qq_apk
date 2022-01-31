package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.view.View;

final class ChangeTransform$3
  extends AnimatorListenerAdapter
{
  private boolean mIsCanceled;
  private Matrix qh = new Matrix();
  
  ChangeTransform$3(ChangeTransform paramChangeTransform, boolean paramBoolean, Matrix paramMatrix, View paramView, ChangeTransform.c paramc, ChangeTransform.b paramb) {}
  
  private void a(Matrix paramMatrix)
  {
    this.qh.set(paramMatrix);
    this.val$view.setTag(z.a.transition_transform, this.qh);
    this.qk.v(this.val$view);
  }
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.mIsCanceled = true;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.mIsCanceled)
    {
      if ((!this.qi) || (!ChangeTransform.a(this.qm))) {
        break label52;
      }
      a(this.qj);
    }
    for (;;)
    {
      av.c(this.val$view, null);
      this.qk.v(this.val$view);
      return;
      label52:
      this.val$view.setTag(z.a.transition_transform, null);
      this.val$view.setTag(z.a.parent_matrix, null);
    }
  }
  
  public final void onAnimationPause(Animator paramAnimator)
  {
    a(this.ql.mMatrix);
  }
  
  public final void onAnimationResume(Animator paramAnimator)
  {
    ChangeTransform.u(this.val$view);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.transition.ChangeTransform.3
 * JD-Core Version:    0.7.0.1
 */