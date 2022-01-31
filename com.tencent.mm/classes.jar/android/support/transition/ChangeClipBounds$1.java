package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.view.q;
import android.view.View;

final class ChangeClipBounds$1
  extends AnimatorListenerAdapter
{
  ChangeClipBounds$1(ChangeClipBounds paramChangeClipBounds, View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    q.c(this.pX, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.transition.ChangeClipBounds.1
 * JD-Core Version:    0.7.0.1
 */