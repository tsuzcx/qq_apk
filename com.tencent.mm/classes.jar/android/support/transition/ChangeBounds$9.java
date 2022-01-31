package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.support.v4.view.q;
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
      q.c(this.val$view, this.pK);
      av.b(this.val$view, this.pL, this.pM, this.pN, this.pO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.ChangeBounds.9
 * JD-Core Version:    0.7.0.1
 */