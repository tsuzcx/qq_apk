package com.tencent.mm.c;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.e.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends b
{
  public Animator.AnimatorListener cip;
  private int hbT;
  private ValueAnimator hbU;
  c hbV;
  private float hbW;
  private float hbX;
  private float hbY;
  Rect hbZ;
  private RectF hca;
  Matrix hcb;
  public long hcc;
  
  public a(c paramc)
  {
    AppMethodBeat.i(9108);
    this.hbT = 200;
    this.hcc = 0L;
    this.hbV = paramc;
    this.hcb = new Matrix();
    this.hca = new RectF();
    AppMethodBeat.o(9108);
  }
  
  public final void a(float paramFloat1, Rect paramRect, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(236241);
    this.hbX = paramFloat2;
    this.hbY = paramFloat3;
    this.hbZ = paramRect;
    this.hca.set(this.hbZ);
    this.hbW = paramFloat1;
    AppMethodBeat.o(236241);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(9110);
    Log.d("MicroMsg.CropActionUpAnim", "[cancel]");
    this.isStarted = false;
    this.hcg = true;
    if (this.hbU != null) {
      this.hbU.cancel();
    }
    AppMethodBeat.o(9110);
  }
  
  public final void play()
  {
    AppMethodBeat.i(9109);
    Log.i("MicroMsg.CropActionUpAnim", "[play]");
    if (!this.hcg)
    {
      AppMethodBeat.o(9109);
      return;
    }
    this.isStarted = false;
    this.hcg = false;
    this.hbU = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 1.0F, this.hbW }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, this.hbX }), PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, this.hbY }), PropertyValuesHolder.ofFloat("background_alpha", new float[] { 0.0F, 255.0F }) });
    this.hbU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      Matrix hcd;
      Rect hce;
      
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(9106);
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaY")).floatValue();
        float f2 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaX")).floatValue();
        float f3 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("scale")).floatValue();
        float f4 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("background_alpha")).floatValue();
        a.this.hcb.reset();
        a.this.hcb.postTranslate(f2, f1);
        paramAnonymousValueAnimator = new RectF(this.hce);
        a.this.hcb.mapRect(paramAnonymousValueAnimator);
        paramAnonymousValueAnimator.round(a.this.hbZ);
        a.this.hcb.postScale(f3, f3, a.this.hbZ.centerX(), a.this.hbZ.centerY());
        paramAnonymousValueAnimator = new Matrix(this.hcd);
        paramAnonymousValueAnimator.postConcat(a.this.hcb);
        a.this.hbV.getMainMatrix().set(paramAnonymousValueAnimator);
        com.tencent.mm.ab.a.sj((int)f4);
        paramAnonymousValueAnimator = new RectF(this.hce);
        a.this.hcb.mapRect(paramAnonymousValueAnimator);
        paramAnonymousValueAnimator.round(a.this.hbZ);
        a.this.hbV.aEH();
        AppMethodBeat.o(9106);
      }
    });
    this.hbU.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(9107);
        a.this.hcg = true;
        a.this.isStarted = false;
        a.this.hcc = 0L;
        a.this.hbV.aEK();
        a.this.hbV.aEI();
        if (a.this.cip != null) {
          a.this.cip.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(9107);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        a.this.hbV.hpw = true;
        a.this.hcg = false;
        a.this.isStarted = true;
      }
    });
    this.hbU.setInterpolator(new LinearInterpolator());
    this.hbU.setDuration(this.hbT);
    this.hbU.setStartDelay(this.hcc);
    this.hbU.start();
    AppMethodBeat.o(9109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.c.a
 * JD-Core Version:    0.7.0.1
 */