package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

final class x$4
  extends AnimatorListenerAdapter
{
  x$4(x paramx, RecyclerView.v paramv, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.abL.setListener(null);
    this.val$view.setAlpha(1.0F);
    this.abH.w(this.abK);
    this.abH.abE.remove(this.abK);
    this.abH.gB();
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.abH.y(this.abK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.x.4
 * JD-Core Version:    0.7.0.1
 */