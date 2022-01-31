package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.e.a;
import java.util.ArrayList;

final class Transition$2
  extends AnimatorListenerAdapter
{
  Transition$2(Transition paramTransition, a parama) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.tu.remove(paramAnimator);
    Transition.c(this.tv).remove(paramAnimator);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    Transition.c(this.tv).add(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.Transition.2
 * JD-Core Version:    0.7.0.1
 */