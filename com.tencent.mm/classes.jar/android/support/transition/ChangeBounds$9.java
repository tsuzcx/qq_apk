package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.support.v4.view.t;
import android.view.View;

final class ChangeBounds$9
  extends AnimatorListenerAdapter
{
  private boolean mIsCanceled;
  
  ChangeBounds$9(ChangeBounds paramChangeBounds, View paramView, Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.mIsCanceled = true;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.mIsCanceled)
    {
      t.c(this.val$view, this.qH);
      au.b(this.val$view, this.qI, this.qJ, this.qK, this.qL);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.ChangeBounds.9
 * JD-Core Version:    0.7.0.1
 */