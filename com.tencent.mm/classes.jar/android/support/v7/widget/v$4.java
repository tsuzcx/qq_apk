package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

final class v$4
  extends AnimatorListenerAdapter
{
  v$4(v paramv, RecyclerView.v paramv1, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.acw.setListener(null);
    this.val$view.setAlpha(1.0F);
    this.acs.B(this.acv);
    this.acs.acp.remove(this.acv);
    this.acs.hB();
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.acs.D(this.acv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.v.4
 * JD-Core Version:    0.7.0.1
 */