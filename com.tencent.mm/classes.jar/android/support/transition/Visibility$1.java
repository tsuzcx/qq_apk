package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class Visibility$1
  extends AnimatorListenerAdapter
{
  Visibility$1(Visibility paramVisibility, am paramam, View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.uN.remove(this.uO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.transition.Visibility.1
 * JD-Core Version:    0.7.0.1
 */