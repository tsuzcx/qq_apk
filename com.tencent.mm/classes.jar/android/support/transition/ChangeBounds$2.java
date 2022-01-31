package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;

final class ChangeBounds$2
  extends AnimatorListenerAdapter
{
  ChangeBounds$2(ChangeBounds paramChangeBounds, ViewGroup paramViewGroup, BitmapDrawable paramBitmapDrawable, View paramView, float paramFloat) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    av.F(this.pE).remove(this.pF);
    av.c(this.val$view, this.pG);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.ChangeBounds.2
 * JD-Core Version:    0.7.0.1
 */