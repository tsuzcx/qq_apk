package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class w$a
  extends AnimatorListenerAdapter
{
  private final View Bj;
  private final View Bk;
  private final int Bl;
  private final int Bm;
  private int[] Bn;
  private float Bo;
  private float Bp;
  private final float Bq;
  private final float Br;
  
  w$a(View paramView1, View paramView2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    this.Bk = paramView1;
    this.Bj = paramView2;
    this.Bl = (paramInt1 - Math.round(this.Bk.getTranslationX()));
    this.Bm = (paramInt2 - Math.round(this.Bk.getTranslationY()));
    this.Bq = paramFloat1;
    this.Br = paramFloat2;
    this.Bn = ((int[])this.Bj.getTag(2131306068));
    if (this.Bn != null) {
      this.Bj.setTag(2131306068, null);
    }
  }
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    if (this.Bn == null) {
      this.Bn = new int[2];
    }
    this.Bn[0] = Math.round(this.Bl + this.Bk.getTranslationX());
    this.Bn[1] = Math.round(this.Bm + this.Bk.getTranslationY());
    this.Bj.setTag(2131306068, this.Bn);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.Bk.setTranslationX(this.Bq);
    this.Bk.setTranslationY(this.Br);
  }
  
  public final void onAnimationPause(Animator paramAnimator)
  {
    this.Bo = this.Bk.getTranslationX();
    this.Bp = this.Bk.getTranslationY();
    this.Bk.setTranslationX(this.Bq);
    this.Bk.setTranslationY(this.Br);
  }
  
  public final void onAnimationResume(Animator paramAnimator)
  {
    this.Bk.setTranslationX(this.Bo);
    this.Bk.setTranslationY(this.Bp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.transition.w.a
 * JD-Core Version:    0.7.0.1
 */