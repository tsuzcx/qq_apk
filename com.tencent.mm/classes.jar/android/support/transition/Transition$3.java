package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class Transition$3
  extends AnimatorListenerAdapter
{
  Transition$3(Transition paramTransition) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.tv.end();
    paramAnimator.removeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.transition.Transition.3
 * JD-Core Version:    0.7.0.1
 */