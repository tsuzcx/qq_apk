package android.support.transition;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;

final class b
  implements d
{
  public final void a(Animator paramAnimator, AnimatorListenerAdapter paramAnimatorListenerAdapter) {}
  
  public final void b(Animator paramAnimator)
  {
    ArrayList localArrayList = paramAnimator.getListeners();
    if (localArrayList != null)
    {
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)localArrayList.get(i);
        if ((localAnimatorListener instanceof b.a)) {
          ((b.a)localAnimatorListener).onAnimationPause(paramAnimator);
        }
        i += 1;
      }
    }
  }
  
  public final void c(Animator paramAnimator)
  {
    ArrayList localArrayList = paramAnimator.getListeners();
    if (localArrayList != null)
    {
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)localArrayList.get(i);
        if ((localAnimatorListener instanceof b.a)) {
          ((b.a)localAnimatorListener).onAnimationResume(paramAnimator);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.transition.b
 * JD-Core Version:    0.7.0.1
 */