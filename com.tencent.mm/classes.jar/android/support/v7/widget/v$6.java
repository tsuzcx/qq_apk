package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

final class v$6
  extends AnimatorListenerAdapter
{
  v$6(v paramv, RecyclerView.v paramv1, int paramInt1, View paramView, int paramInt2, ViewPropertyAnimator paramViewPropertyAnimator) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    if (this.acx != 0) {
      this.val$view.setTranslationX(0.0F);
    }
    if (this.acy != 0) {
      this.val$view.setTranslationY(0.0F);
    }
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.acw.setListener(null);
    this.acs.C(this.acv);
    this.acs.aco.remove(this.acv);
    this.acs.hB();
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.acs.F(this.acv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.v.6
 * JD-Core Version:    0.7.0.1
 */