package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class w$a
  extends AnimatorListenerAdapter
{
  private final View Al;
  private final View Am;
  private final int An;
  private final int Ao;
  private int[] Ap;
  private float Aq;
  private float Ar;
  private final float As;
  private final float At;
  
  w$a(View paramView1, View paramView2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    this.Am = paramView1;
    this.Al = paramView2;
    this.An = (paramInt1 - Math.round(this.Am.getTranslationX()));
    this.Ao = (paramInt2 - Math.round(this.Am.getTranslationY()));
    this.As = paramFloat1;
    this.At = paramFloat2;
    this.Ap = ((int[])this.Al.getTag(2131306068));
    if (this.Ap != null) {
      this.Al.setTag(2131306068, null);
    }
  }
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    if (this.Ap == null) {
      this.Ap = new int[2];
    }
    this.Ap[0] = Math.round(this.An + this.Am.getTranslationX());
    this.Ap[1] = Math.round(this.Ao + this.Am.getTranslationY());
    this.Al.setTag(2131306068, this.Ap);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.Am.setTranslationX(this.As);
    this.Am.setTranslationY(this.At);
  }
  
  public final void onAnimationPause(Animator paramAnimator)
  {
    this.Aq = this.Am.getTranslationX();
    this.Ar = this.Am.getTranslationY();
    this.Am.setTranslationX(this.As);
    this.Am.setTranslationY(this.At);
  }
  
  public final void onAnimationResume(Animator paramAnimator)
  {
    this.Am.setTranslationX(this.Aq);
    this.Am.setTranslationY(this.Ar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.transition.w.a
 * JD-Core Version:    0.7.0.1
 */