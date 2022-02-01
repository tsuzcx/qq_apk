package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.view.t;
import android.view.View;

final class Fade$a
  extends AnimatorListenerAdapter
{
  private final View mView;
  private boolean yV = false;
  
  Fade$a(View paramView)
  {
    this.mView = paramView;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    ag.d(this.mView, 1.0F);
    if (this.yV) {
      this.mView.setLayerType(0, null);
    }
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    if ((t.ar(this.mView)) && (this.mView.getLayerType() == 0))
    {
      this.yV = true;
      this.mView.setLayerType(2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.Fade.a
 * JD-Core Version:    0.7.0.1
 */