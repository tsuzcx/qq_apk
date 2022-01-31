package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

final class x$8
  extends AnimatorListenerAdapter
{
  x$8(x paramx, x.a parama, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.abQ.setListener(null);
    this.abR.setAlpha(1.0F);
    this.abR.setTranslationX(0.0F);
    this.abR.setTranslationY(0.0F);
    this.abH.l(this.abO.abT);
    this.abH.abF.remove(this.abO.abT);
    this.abH.gB();
  }
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.x.8
 * JD-Core Version:    0.7.0.1
 */