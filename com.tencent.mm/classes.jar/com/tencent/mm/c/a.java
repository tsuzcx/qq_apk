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
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends b
{
  private int cED;
  private ValueAnimator cEE;
  c cEF;
  public float cEG;
  public float cEH;
  public float cEI;
  public Rect cEJ;
  public RectF cEK;
  Matrix cEL;
  public long cEM;
  public Animator.AnimatorListener uY;
  
  public a(c paramc)
  {
    AppMethodBeat.i(9108);
    this.cED = 200;
    this.cEM = 0L;
    this.cEF = paramc;
    this.cEL = new Matrix();
    this.cEK = new RectF();
    AppMethodBeat.o(9108);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(9110);
    ac.d("MicroMsg.CropActionUpAnim", "[cancel]");
    this.aKd = false;
    this.cEQ = true;
    if (this.cEE != null) {
      this.cEE.cancel();
    }
    AppMethodBeat.o(9110);
  }
  
  public final void play()
  {
    AppMethodBeat.i(9109);
    ac.i("MicroMsg.CropActionUpAnim", "[play]");
    if (!this.cEQ)
    {
      AppMethodBeat.o(9109);
      return;
    }
    this.aKd = false;
    this.cEQ = false;
    this.cEE = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 1.0F, this.cEG }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, this.cEH }), PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, this.cEI }), PropertyValuesHolder.ofFloat("background_alpha", new float[] { 0.0F, 255.0F }) });
    this.cEE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      Matrix cEN;
      Rect cEO;
      
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(9106);
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaY")).floatValue();
        float f2 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaX")).floatValue();
        float f3 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("scale")).floatValue();
        float f4 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("background_alpha")).floatValue();
        a.this.cEL.reset();
        a.this.cEL.postTranslate(f2, f1);
        paramAnonymousValueAnimator = new RectF(this.cEO);
        a.this.cEL.mapRect(paramAnonymousValueAnimator);
        paramAnonymousValueAnimator.round(a.this.cEJ);
        a.this.cEL.postScale(f3, f3, a.this.cEJ.centerX(), a.this.cEJ.centerY());
        paramAnonymousValueAnimator = new Matrix(this.cEN);
        paramAnonymousValueAnimator.postConcat(a.this.cEL);
        a.this.cEF.getMainMatrix().set(paramAnonymousValueAnimator);
        com.tencent.mm.z.a.lZ((int)f4);
        paramAnonymousValueAnimator = new RectF(this.cEO);
        a.this.cEL.mapRect(paramAnonymousValueAnimator);
        paramAnonymousValueAnimator.round(a.this.cEJ);
        a.this.cEF.Mi();
        AppMethodBeat.o(9106);
      }
    });
    this.cEE.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(9107);
        a.this.cEQ = true;
        a.this.aKd = false;
        a.this.cEM = 0L;
        a.this.cEF.Ml();
        a.this.cEF.Mj();
        if (a.this.uY != null) {
          a.this.uY.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(9107);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        a.this.cEF.cPx = true;
        a.this.cEQ = false;
        a.this.aKd = true;
      }
    });
    this.cEE.setInterpolator(new LinearInterpolator());
    this.cEE.setDuration(this.cED);
    this.cEE.setStartDelay(this.cEM);
    this.cEE.start();
    AppMethodBeat.o(9109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.c.a
 * JD-Core Version:    0.7.0.1
 */