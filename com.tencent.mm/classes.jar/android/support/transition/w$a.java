package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class w$a
  extends AnimatorListenerAdapter
{
  private final View Db;
  private final View Dc;
  private final int Dd;
  private final int De;
  private int[] Df;
  private float Dg;
  private float Dh;
  private final float Di;
  private final float Dj;
  
  w$a(View paramView1, View paramView2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    this.Dc = paramView1;
    this.Db = paramView2;
    this.Dd = (paramInt1 - Math.round(this.Dc.getTranslationX()));
    this.De = (paramInt2 - Math.round(this.Dc.getTranslationY()));
    this.Di = paramFloat1;
    this.Dj = paramFloat2;
    this.Df = ((int[])this.Db.getTag(2131306068));
    if (this.Df != null) {
      this.Db.setTag(2131306068, null);
    }
  }
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    if (this.Df == null) {
      this.Df = new int[2];
    }
    this.Df[0] = Math.round(this.Dd + this.Dc.getTranslationX());
    this.Df[1] = Math.round(this.De + this.Dc.getTranslationY());
    this.Db.setTag(2131306068, this.Df);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.Dc.setTranslationX(this.Di);
    this.Dc.setTranslationY(this.Dj);
  }
  
  public final void onAnimationPause(Animator paramAnimator)
  {
    this.Dg = this.Dc.getTranslationX();
    this.Dh = this.Dc.getTranslationY();
    this.Dc.setTranslationX(this.Di);
    this.Dc.setTranslationY(this.Dj);
  }
  
  public final void onAnimationResume(Animator paramAnimator)
  {
    this.Dc.setTranslationX(this.Dg);
    this.Dc.setTranslationY(this.Dh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.w.a
 * JD-Core Version:    0.7.0.1
 */