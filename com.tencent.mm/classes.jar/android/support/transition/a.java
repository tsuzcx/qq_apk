package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build.VERSION;

final class a
{
  private static final d qg = new b();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      qg = new c();
      return;
    }
  }
  
  static void a(Animator paramAnimator, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    qg.a(paramAnimator, paramAnimatorListenerAdapter);
  }
  
  static void b(Animator paramAnimator)
  {
    qg.b(paramAnimator);
  }
  
  static void c(Animator paramAnimator)
  {
    qg.c(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.a
 * JD-Core Version:    0.7.0.1
 */