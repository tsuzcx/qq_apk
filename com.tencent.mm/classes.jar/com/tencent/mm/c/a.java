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
  private int dgM;
  private ValueAnimator dgN;
  c dgO;
  private float dgP;
  private float dgQ;
  private float dgR;
  Rect dgS;
  private RectF dgT;
  Matrix dgU;
  public long dgV;
  public Animator.AnimatorListener wY;
  
  public a(c paramc)
  {
    AppMethodBeat.i(9108);
    this.dgM = 200;
    this.dgV = 0L;
    this.dgO = paramc;
    this.dgU = new Matrix();
    this.dgT = new RectF();
    AppMethodBeat.o(9108);
  }
  
  public final void a(float paramFloat1, Rect paramRect, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(204715);
    this.dgQ = paramFloat2;
    this.dgR = paramFloat3;
    this.dgS = paramRect;
    this.dgT.set(this.dgS);
    this.dgP = paramFloat1;
    AppMethodBeat.o(204715);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(9110);
    Log.d("MicroMsg.CropActionUpAnim", "[cancel]");
    this.isStarted = false;
    this.dgZ = true;
    if (this.dgN != null) {
      this.dgN.cancel();
    }
    AppMethodBeat.o(9110);
  }
  
  public final void play()
  {
    AppMethodBeat.i(9109);
    Log.i("MicroMsg.CropActionUpAnim", "[play]");
    if (!this.dgZ)
    {
      AppMethodBeat.o(9109);
      return;
    }
    this.isStarted = false;
    this.dgZ = false;
    this.dgN = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 1.0F, this.dgP }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, this.dgQ }), PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, this.dgR }), PropertyValuesHolder.ofFloat("background_alpha", new float[] { 0.0F, 255.0F }) });
    this.dgN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      Matrix dgW;
      Rect dgX;
      
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(9106);
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaY")).floatValue();
        float f2 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaX")).floatValue();
        float f3 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("scale")).floatValue();
        float f4 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("background_alpha")).floatValue();
        a.this.dgU.reset();
        a.this.dgU.postTranslate(f2, f1);
        paramAnonymousValueAnimator = new RectF(this.dgX);
        a.this.dgU.mapRect(paramAnonymousValueAnimator);
        paramAnonymousValueAnimator.round(a.this.dgS);
        a.this.dgU.postScale(f3, f3, a.this.dgS.centerX(), a.this.dgS.centerY());
        paramAnonymousValueAnimator = new Matrix(this.dgW);
        paramAnonymousValueAnimator.postConcat(a.this.dgU);
        a.this.dgO.getMainMatrix().set(paramAnonymousValueAnimator);
        com.tencent.mm.z.a.pO((int)f4);
        paramAnonymousValueAnimator = new RectF(this.dgX);
        a.this.dgU.mapRect(paramAnonymousValueAnimator);
        paramAnonymousValueAnimator.round(a.this.dgS);
        a.this.dgO.Yb();
        AppMethodBeat.o(9106);
      }
    });
    this.dgN.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(9107);
        a.this.dgZ = true;
        a.this.isStarted = false;
        a.this.dgV = 0L;
        a.this.dgO.Ye();
        a.this.dgO.Yc();
        if (a.this.wY != null) {
          a.this.wY.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(9107);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        a.this.dgO.dsx = true;
        a.this.dgZ = false;
        a.this.isStarted = true;
      }
    });
    this.dgN.setInterpolator(new LinearInterpolator());
    this.dgN.setDuration(this.dgM);
    this.dgN.setStartDelay(this.dgV);
    this.dgN.start();
    AppMethodBeat.o(9109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.c.a
 * JD-Core Version:    0.7.0.1
 */