package com.tencent.mm.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.e.c;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends b
{
  private int bue = 200;
  c bug;
  public float buh;
  public float bui;
  public float buj;
  public Rect buk;
  public RectF bul;
  Matrix bum;
  public long bun = 0L;
  private ValueAnimator jQ;
  public Animator.AnimatorListener mA;
  
  public a(c paramc)
  {
    this.bug = paramc;
    this.bum = new Matrix();
    this.bul = new RectF();
  }
  
  public final void cancel()
  {
    y.d("MicroMsg.CropActionUpAnim", "[cancel]");
    this.bus = false;
    this.bur = true;
    if (this.jQ != null) {
      this.jQ.cancel();
    }
  }
  
  public final void play()
  {
    y.i("MicroMsg.CropActionUpAnim", "[play]");
    if (!this.bur) {
      return;
    }
    this.bus = false;
    this.bur = false;
    this.jQ = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 1.0F, this.buh }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, this.bui }), PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, this.buj }), PropertyValuesHolder.ofFloat("background_alpha", new float[] { 0.0F, 255.0F }) });
    this.jQ.addUpdateListener(new a.1(this));
    this.jQ.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        a.this.bur = true;
        a.this.bus = false;
        a.this.bun = 0L;
        a.this.bug.tT();
        a.this.bug.tR();
        if (a.this.mA != null) {
          a.this.mA.onAnimationEnd(paramAnonymousAnimator);
        }
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        a.this.bug.bAy = true;
        a.this.bur = false;
        a.this.bus = true;
      }
    });
    this.jQ.setInterpolator(new LinearInterpolator());
    this.jQ.setDuration(this.bue);
    this.jQ.setStartDelay(this.bun);
    this.jQ.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.b.a
 * JD-Core Version:    0.7.0.1
 */