package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class ak$a
  extends AnimatorListenerAdapter
{
  private final View sR;
  private final View sS;
  private final int sT;
  private final int sU;
  private int[] sV;
  private float sW;
  private float sX;
  private final float sY;
  private final float sZ;
  
  private ak$a(View paramView1, View paramView2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    this.sS = paramView1;
    this.sR = paramView2;
    this.sT = (paramInt1 - Math.round(this.sS.getTranslationX()));
    this.sU = (paramInt2 - Math.round(this.sS.getTranslationY()));
    this.sY = paramFloat1;
    this.sZ = paramFloat2;
    this.sV = ((int[])this.sR.getTag(z.a.transition_position));
    if (this.sV != null) {
      this.sR.setTag(z.a.transition_position, null);
    }
  }
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    if (this.sV == null) {
      this.sV = new int[2];
    }
    this.sV[0] = Math.round(this.sT + this.sS.getTranslationX());
    this.sV[1] = Math.round(this.sU + this.sS.getTranslationY());
    this.sR.setTag(z.a.transition_position, this.sV);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.sS.setTranslationX(this.sY);
    this.sS.setTranslationY(this.sZ);
  }
  
  public final void onAnimationPause(Animator paramAnimator)
  {
    this.sW = this.sS.getTranslationX();
    this.sX = this.sS.getTranslationY();
    this.sS.setTranslationX(this.sY);
    this.sS.setTranslationY(this.sZ);
  }
  
  public final void onAnimationResume(Animator paramAnimator)
  {
    this.sS.setTranslationX(this.sW);
    this.sS.setTranslationY(this.sX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.ak.a
 * JD-Core Version:    0.7.0.1
 */