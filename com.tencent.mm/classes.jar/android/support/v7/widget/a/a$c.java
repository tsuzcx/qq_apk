package android.support.v7.widget.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.support.v7.widget.RecyclerView.v;

class a$c
  implements Animator.AnimatorListener
{
  final RecyclerView.v ahi;
  final int anO;
  final float aoj;
  final float aok;
  final float aol;
  final float aom;
  final ValueAnimator aon;
  final int aoo;
  public boolean aop;
  float aoq;
  float aor;
  boolean aos = false;
  float aot;
  boolean so = false;
  
  a$c(RecyclerView.v paramv, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.anO = paramInt2;
    this.aoo = paramInt1;
    this.ahi = paramv;
    this.aoj = paramFloat1;
    this.aok = paramFloat2;
    this.aol = paramFloat3;
    this.aom = paramFloat4;
    this.aon = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.aon.addUpdateListener(new a.c.1(this));
    this.aon.setTarget(paramv.aie);
    this.aon.addListener(this);
    this.aot = 0.0F;
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.aot = 1.0F;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.so) {
      this.ahi.ag(true);
    }
    this.so = true;
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.a.a.c
 * JD-Core Version:    0.7.0.1
 */