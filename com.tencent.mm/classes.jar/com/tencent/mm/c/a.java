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
  private int cPI;
  private ValueAnimator cPJ;
  c cPK;
  public float cPL;
  public float cPM;
  public float cPN;
  public Rect cPO;
  public RectF cPP;
  Matrix cPQ;
  public long cPR;
  public Animator.AnimatorListener wR;
  
  public a(c paramc)
  {
    AppMethodBeat.i(9108);
    this.cPI = 200;
    this.cPR = 0L;
    this.cPK = paramc;
    this.cPQ = new Matrix();
    this.cPP = new RectF();
    AppMethodBeat.o(9108);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(9110);
    ad.d("MicroMsg.CropActionUpAnim", "[cancel]");
    this.aLU = false;
    this.cPV = true;
    if (this.cPJ != null) {
      this.cPJ.cancel();
    }
    AppMethodBeat.o(9110);
  }
  
  public final void play()
  {
    AppMethodBeat.i(9109);
    ad.i("MicroMsg.CropActionUpAnim", "[play]");
    if (!this.cPV)
    {
      AppMethodBeat.o(9109);
      return;
    }
    this.aLU = false;
    this.cPV = false;
    this.cPJ = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 1.0F, this.cPL }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, this.cPM }), PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, this.cPN }), PropertyValuesHolder.ofFloat("background_alpha", new float[] { 0.0F, 255.0F }) });
    this.cPJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      Matrix cPS;
      Rect cPT;
      
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(9106);
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaY")).floatValue();
        float f2 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaX")).floatValue();
        float f3 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("scale")).floatValue();
        float f4 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("background_alpha")).floatValue();
        a.this.cPQ.reset();
        a.this.cPQ.postTranslate(f2, f1);
        paramAnonymousValueAnimator = new RectF(this.cPT);
        a.this.cPQ.mapRect(paramAnonymousValueAnimator);
        paramAnonymousValueAnimator.round(a.this.cPO);
        a.this.cPQ.postScale(f3, f3, a.this.cPO.centerX(), a.this.cPO.centerY());
        paramAnonymousValueAnimator = new Matrix(this.cPS);
        paramAnonymousValueAnimator.postConcat(a.this.cPQ);
        a.this.cPK.getMainMatrix().set(paramAnonymousValueAnimator);
        com.tencent.mm.aa.a.my((int)f4);
        paramAnonymousValueAnimator = new RectF(this.cPT);
        a.this.cPQ.mapRect(paramAnonymousValueAnimator);
        paramAnonymousValueAnimator.round(a.this.cPO);
        a.this.cPK.NR();
        AppMethodBeat.o(9106);
      }
    });
    this.cPJ.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(9107);
        a.this.cPV = true;
        a.this.aLU = false;
        a.this.cPR = 0L;
        a.this.cPK.NU();
        a.this.cPK.NS();
        if (a.this.wR != null) {
          a.this.wR.onAnimationEnd(paramAnonymousAnimator);
        }
        AppMethodBeat.o(9107);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        a.this.cPK.daN = true;
        a.this.cPV = false;
        a.this.aLU = true;
      }
    });
    this.cPJ.setInterpolator(new LinearInterpolator());
    this.cPJ.setDuration(this.cPI);
    this.cPJ.setStartDelay(this.cPR);
    this.cPJ.start();
    AppMethodBeat.o(9109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.c.a
 * JD-Core Version:    0.7.0.1
 */