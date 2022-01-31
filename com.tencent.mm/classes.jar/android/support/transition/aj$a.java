package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class aj$a
  extends AnimatorListenerAdapter
{
  private final View tT;
  private final View tU;
  private final int tV;
  private final int tW;
  private int[] tX;
  private float tY;
  private float tZ;
  private final float ua;
  private final float ub;
  
  private aj$a(View paramView1, View paramView2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    this.tU = paramView1;
    this.tT = paramView2;
    this.tV = (paramInt1 - Math.round(this.tU.getTranslationX()));
    this.tW = (paramInt2 - Math.round(this.tU.getTranslationY()));
    this.ua = paramFloat1;
    this.ub = paramFloat2;
    this.tX = ((int[])this.tT.getTag(2131820684));
    if (this.tX != null) {
      this.tT.setTag(2131820684, null);
    }
  }
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    if (this.tX == null) {
      this.tX = new int[2];
    }
    this.tX[0] = Math.round(this.tV + this.tU.getTranslationX());
    this.tX[1] = Math.round(this.tW + this.tU.getTranslationY());
    this.tT.setTag(2131820684, this.tX);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.tU.setTranslationX(this.ua);
    this.tU.setTranslationY(this.ub);
  }
  
  public final void onAnimationPause(Animator paramAnimator)
  {
    this.tY = this.tU.getTranslationX();
    this.tZ = this.tU.getTranslationY();
    this.tU.setTranslationX(this.ua);
    this.tU.setTranslationY(this.ub);
  }
  
  public final void onAnimationResume(Animator paramAnimator)
  {
    this.tU.setTranslationX(this.tY);
    this.tU.setTranslationY(this.tZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.transition.aj.a
 * JD-Core Version:    0.7.0.1
 */