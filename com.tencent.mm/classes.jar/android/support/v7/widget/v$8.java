package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

final class v$8
  extends AnimatorListenerAdapter
{
  v$8(v paramv, v.a parama, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.acB.setListener(null);
    this.acC.setAlpha(1.0F);
    this.acC.setTranslationX(0.0F);
    this.acC.setTranslationY(0.0F);
    this.acs.m(this.acz.acE);
    this.acs.acq.remove(this.acz.acE);
    this.acs.hB();
  }
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.v.8
 * JD-Core Version:    0.7.0.1
 */