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
  public Animator.AnimatorListener atS;
  private RectF eYA;
  Matrix eYB;
  public long eYC;
  private int eYt;
  private ValueAnimator eYu;
  c eYv;
  private float eYw;
  private float eYx;
  private float eYy;
  Rect eYz;
  
  public a(c paramc)
  {
    AppMethodBeat.i(9108);
    this.eYt = 200;
    this.eYC = 0L;
    this.eYv = paramc;
    this.eYB = new Matrix();
    this.eYA = new RectF();
    AppMethodBeat.o(9108);
  }
  
  public final void a(float paramFloat1, Rect paramRect, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(259755);
    this.eYx = paramFloat2;
    this.eYy = paramFloat3;
    this.eYz = paramRect;
    this.eYA.set(this.eYz);
    this.eYw = paramFloat1;
    AppMethodBeat.o(259755);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(9110);
    Log.d("MicroMsg.CropActionUpAnim", "[cancel]");
    this.isStarted = false;
    this.eYG = true;
    if (this.eYu != null) {
      this.eYu.cancel();
    }
    AppMethodBeat.o(9110);
  }
  
  public final void play()
  {
    AppMethodBeat.i(9109);
    Log.i("MicroMsg.CropActionUpAnim", "[play]");
    if (!this.eYG)
    {
      AppMethodBeat.o(9109);
      return;
    }
    this.isStarted = false;
    this.eYG = false;
    this.eYu = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 1.0F, this.eYw }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, this.eYx }), PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, this.eYy }), PropertyValuesHolder.ofFloat("background_alpha", new float[] { 0.0F, 255.0F }) });
    this.eYu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      Matrix eYD;
      Rect eYE;
      
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(9106);
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaY")).floatValue();
        float f2 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaX")).floatValue();
        float f3 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("scale")).floatValue();
        float f4 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("background_alpha")).floatValue();
        a.this.eYB.reset();
        a.this.eYB.postTranslate(f2, f1);
        paramAnonymousValueAnimator = new RectF(this.eYE);
        a.this.eYB.mapRect(paramAnonymousValueAnimator);
        paramAnonymousValueAnimator.round(a.this.eYz);
        a.this.eYB.postScale(f3, f3, a.this.eYz.centerX(), a.this.eYz.centerY());
        paramAnonymousValueAnimator = new Matrix(this.eYD);
        paramAnonymousValueAnimator.postConcat(a.this.eYB);
        a.this.eYv.getMainMatrix().set(paramAnonymousValueAnimator);
        com.tencent.mm.ab.a.sn((int)f4);
        paramAnonymousValueAnimator = new RectF(this.eYE);
        a.this.eYB.mapRect(paramAnonymousValueAnimator);
        paramAnonymousValueAnimator.round(a.this.eYz);
        a.this.eYv.acH();
        AppMethodBeat.o(9106);
      }
    });
    this.eYu.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(9107);
        a.this.eYG = true;
        a.this.isStarted = false;
        a.this.eYC = 0L;
        a.this.eYv.acK();
        a.this.eYv.acI();
        if (a.this.atS != null) {
          a.this.atS.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(9107);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        a.this.eYv.flj = true;
        a.this.eYG = false;
        a.this.isStarted = true;
      }
    });
    this.eYu.setInterpolator(new LinearInterpolator());
    this.eYu.setDuration(this.eYt);
    this.eYu.setStartDelay(this.eYC);
    this.eYu.start();
    AppMethodBeat.o(9109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.c.a
 * JD-Core Version:    0.7.0.1
 */