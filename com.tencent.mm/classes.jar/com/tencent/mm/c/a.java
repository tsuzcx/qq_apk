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
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends b
{
  Matrix cQA;
  public long cQB;
  private int cQs;
  private ValueAnimator cQt;
  c cQu;
  public float cQv;
  public float cQw;
  public float cQx;
  public Rect cQy;
  public RectF cQz;
  public Animator.AnimatorListener wR;
  
  public a(c paramc)
  {
    AppMethodBeat.i(9108);
    this.cQs = 200;
    this.cQB = 0L;
    this.cQu = paramc;
    this.cQA = new Matrix();
    this.cQz = new RectF();
    AppMethodBeat.o(9108);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(9110);
    ae.d("MicroMsg.CropActionUpAnim", "[cancel]");
    this.aLU = false;
    this.cQF = true;
    if (this.cQt != null) {
      this.cQt.cancel();
    }
    AppMethodBeat.o(9110);
  }
  
  public final void play()
  {
    AppMethodBeat.i(9109);
    ae.i("MicroMsg.CropActionUpAnim", "[play]");
    if (!this.cQF)
    {
      AppMethodBeat.o(9109);
      return;
    }
    this.aLU = false;
    this.cQF = false;
    this.cQt = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 1.0F, this.cQv }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, this.cQw }), PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, this.cQx }), PropertyValuesHolder.ofFloat("background_alpha", new float[] { 0.0F, 255.0F }) });
    this.cQt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      Matrix cQC;
      Rect cQD;
      
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(9106);
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaY")).floatValue();
        float f2 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaX")).floatValue();
        float f3 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("scale")).floatValue();
        float f4 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("background_alpha")).floatValue();
        a.this.cQA.reset();
        a.this.cQA.postTranslate(f2, f1);
        paramAnonymousValueAnimator = new RectF(this.cQD);
        a.this.cQA.mapRect(paramAnonymousValueAnimator);
        paramAnonymousValueAnimator.round(a.this.cQy);
        a.this.cQA.postScale(f3, f3, a.this.cQy.centerX(), a.this.cQy.centerY());
        paramAnonymousValueAnimator = new Matrix(this.cQC);
        paramAnonymousValueAnimator.postConcat(a.this.cQA);
        a.this.cQu.getMainMatrix().set(paramAnonymousValueAnimator);
        com.tencent.mm.z.a.mB((int)f4);
        paramAnonymousValueAnimator = new RectF(this.cQD);
        a.this.cQA.mapRect(paramAnonymousValueAnimator);
        paramAnonymousValueAnimator.round(a.this.cQy);
        a.this.cQu.NP();
        AppMethodBeat.o(9106);
      }
    });
    this.cQt.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(9107);
        a.this.cQF = true;
        a.this.aLU = false;
        a.this.cQB = 0L;
        a.this.cQu.NS();
        a.this.cQu.NQ();
        if (a.this.wR != null) {
          a.this.wR.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(9107);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        a.this.cQu.dbP = true;
        a.this.cQF = false;
        a.this.aLU = true;
      }
    });
    this.cQt.setInterpolator(new LinearInterpolator());
    this.cQt.setDuration(this.cQs);
    this.cQt.setStartDelay(this.cQB);
    this.cQt.start();
    AppMethodBeat.o(9109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.c.a
 * JD-Core Version:    0.7.0.1
 */