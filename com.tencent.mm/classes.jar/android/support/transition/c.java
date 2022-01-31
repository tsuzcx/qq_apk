package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class c
  implements d
{
  public final void a(Animator paramAnimator, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    paramAnimator.addPauseListener(paramAnimatorListenerAdapter);
  }
  
  public final void b(Animator paramAnimator)
  {
    paramAnimator.pause();
  }
  
  public final void c(Animator paramAnimator)
  {
    paramAnimator.resume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.c
 * JD-Core Version:    0.7.0.1
 */