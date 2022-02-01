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
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends b
{
  public float cHA;
  public Rect cHB;
  public RectF cHC;
  Matrix cHD;
  public long cHE;
  private int cHv;
  private ValueAnimator cHw;
  c cHx;
  public float cHy;
  public float cHz;
  public Animator.AnimatorListener tX;
  
  public a(c paramc)
  {
    AppMethodBeat.i(9108);
    this.cHv = 200;
    this.cHE = 0L;
    this.cHx = paramc;
    this.cHD = new Matrix();
    this.cHC = new RectF();
    AppMethodBeat.o(9108);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(9110);
    ad.d("MicroMsg.CropActionUpAnim", "[cancel]");
    this.aJn = false;
    this.cHI = true;
    if (this.cHw != null) {
      this.cHw.cancel();
    }
    AppMethodBeat.o(9110);
  }
  
  public final void play()
  {
    AppMethodBeat.i(9109);
    ad.i("MicroMsg.CropActionUpAnim", "[play]");
    if (!this.cHI)
    {
      AppMethodBeat.o(9109);
      return;
    }
    this.aJn = false;
    this.cHI = false;
    this.cHw = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 1.0F, this.cHy }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, this.cHz }), PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, this.cHA }), PropertyValuesHolder.ofFloat("background_alpha", new float[] { 0.0F, 255.0F }) });
    this.cHw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      Matrix cHF;
      Rect cHG;
      
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(9106);
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaY")).floatValue();
        float f2 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaX")).floatValue();
        float f3 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("scale")).floatValue();
        float f4 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("background_alpha")).floatValue();
        a.this.cHD.reset();
        a.this.cHD.postTranslate(f2, f1);
        paramAnonymousValueAnimator = new RectF(this.cHG);
        a.this.cHD.mapRect(paramAnonymousValueAnimator);
        paramAnonymousValueAnimator.round(a.this.cHB);
        a.this.cHD.postScale(f3, f3, a.this.cHB.centerX(), a.this.cHB.centerY());
        paramAnonymousValueAnimator = new Matrix(this.cHF);
        paramAnonymousValueAnimator.postConcat(a.this.cHD);
        a.this.cHx.getMainMatrix().set(paramAnonymousValueAnimator);
        com.tencent.mm.aa.a.ma((int)f4);
        paramAnonymousValueAnimator = new RectF(this.cHG);
        a.this.cHD.mapRect(paramAnonymousValueAnimator);
        paramAnonymousValueAnimator.round(a.this.cHB);
        a.this.cHx.Mk();
        AppMethodBeat.o(9106);
      }
    });
    this.cHw.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(9107);
        a.this.cHI = true;
        a.this.aJn = false;
        a.this.cHE = 0L;
        a.this.cHx.Mn();
        a.this.cHx.Ml();
        if (a.this.tX != null) {
          a.this.tX.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(9107);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        a.this.cHx.cSc = true;
        a.this.cHI = false;
        a.this.aJn = true;
      }
    });
    this.cHw.setInterpolator(new LinearInterpolator());
    this.cHw.setDuration(this.cHv);
    this.cHw.setStartDelay(this.cHE);
    this.cHw.start();
    AppMethodBeat.o(9109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.c.a
 * JD-Core Version:    0.7.0.1
 */