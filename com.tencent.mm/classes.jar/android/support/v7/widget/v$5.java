package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

final class v$5
  extends AnimatorListenerAdapter
{
  v$5(v paramv, RecyclerView.v paramv1, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.val$view.setAlpha(1.0F);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.acw.setListener(null);
    this.acs.m(this.acv);
    this.acs.acn.remove(this.acv);
    this.acs.hB();
  }
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.v.5
 * JD-Core Version:    0.7.0.1
 */