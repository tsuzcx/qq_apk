package com.tencent.luggage.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class e$1
  extends AnimatorListenerAdapter
{
  e$1(e parame, Runnable paramRunnable) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (this.val$runnable != null) {
      this.val$runnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.e.e.1
 * JD-Core Version:    0.7.0.1
 */