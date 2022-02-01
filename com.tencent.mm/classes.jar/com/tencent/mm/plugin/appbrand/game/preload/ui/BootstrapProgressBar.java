package com.tencent.mm.plugin.appbrand.game.preload.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public class BootstrapProgressBar
  extends View
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  private Paint jTb;
  private Paint jTc;
  private Paint jTd;
  private float jTe;
  private float jTf;
  private float jTg;
  private boolean jTh;
  private boolean jTi;
  private boolean jTj;
  private boolean jTk;
  private boolean jTl;
  private ValueAnimator jTm;
  private Paint jTn;
  private Canvas jTo;
  private Bitmap jTp;
  private Bitmap jTq;
  private int jTr;
  
  public BootstrapProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(45297);
    this.jTe = 0.0F;
    this.jTf = 0.0F;
    this.jTg = 100.0F;
    this.jTh = false;
    this.jTi = false;
    this.jTj = true;
    this.jTk = true;
    this.jTl = true;
    bdW();
    AppMethodBeat.o(45297);
  }
  
  public BootstrapProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(45298);
    this.jTe = 0.0F;
    this.jTf = 0.0F;
    this.jTg = 100.0F;
    this.jTh = false;
    this.jTi = false;
    this.jTj = true;
    this.jTk = true;
    this.jTl = true;
    bdW();
    AppMethodBeat.o(45298);
  }
  
  private void bdW()
  {
    AppMethodBeat.i(45299);
    ac.d("BootstrapProgressBar", "initialise");
    ValueAnimator.setFrameDelay(15L);
    this.jTn = new Paint();
    this.jTb = new Paint();
    this.jTb.setStyle(Paint.Style.FILL);
    this.jTb.setAntiAlias(true);
    this.jTc = new Paint();
    this.jTc.setStyle(Paint.Style.FILL);
    this.jTc.setAntiAlias(true);
    this.jTd = new Paint();
    this.jTd.setStyle(Paint.Style.FILL);
    this.jTd.setARGB(38, 0, 0, 0);
    setProgress(this.jTe);
    setMaxProgress(this.jTg);
    AppMethodBeat.o(45299);
  }
  
  private void bdX()
  {
    AppMethodBeat.i(45303);
    if ((!this.jTh) || (!this.jTi))
    {
      AppMethodBeat.o(45303);
      return;
    }
    clearAnimation();
    this.jTm = ValueAnimator.ofFloat(new float[] { 0.0F, 0.0F });
    this.jTm.setDuration(300L);
    this.jTm.setRepeatCount(-1);
    this.jTm.setRepeatMode(1);
    this.jTm.setInterpolator(new LinearInterpolator());
    this.jTm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(45296);
        BootstrapProgressBar.this.invalidate();
        AppMethodBeat.o(45296);
      }
    });
    this.jTm.start();
    AppMethodBeat.o(45303);
  }
  
  public float getMaxProgress()
  {
    return this.jTg;
  }
  
  public float getProgress()
  {
    return this.jTe;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(45302);
    bdX();
    AppMethodBeat.o(45302);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(45301);
    this.jTf = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    invalidate();
    AppMethodBeat.o(45301);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(45306);
    float f3 = getWidth();
    float f4 = getHeight();
    if ((f3 <= 0.0F) || (f4 <= 0.0F))
    {
      AppMethodBeat.o(45306);
      return;
    }
    if (this.jTp == null) {
      this.jTp = Bitmap.createBitmap((int)f3, (int)f4, Bitmap.Config.ARGB_8888);
    }
    if (this.jTo == null) {
      this.jTo = new Canvas(this.jTp);
    }
    this.jTo.drawColor(0, PorterDuff.Mode.CLEAR);
    float f5 = this.jTe / this.jTg;
    int i = (int)(f3 * f5);
    float f2 = 0.0F;
    float f6 = (float)(System.currentTimeMillis() % 370L) / 370.0F;
    float f1 = f2;
    if (this.jTh)
    {
      f1 = f2;
      if (this.jTi) {
        f1 = 2.0F * f4 * (1.0F - f6);
      }
    }
    if (f5 < 1.0F)
    {
      this.jTo.save();
      localObject1 = new Path();
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(i, 0.0F);
      ((Path)localObject1).lineTo(i - f4, f4);
      ((Path)localObject1).lineTo(0.0F, f4);
      this.jTo.clipPath((Path)localObject1);
    }
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (this.jTh)
    {
      if (this.jTq == null)
      {
        localObject1 = this.jTc;
        localObject2 = this.jTb;
        localObject3 = Bitmap.createBitmap((int)f4 * 2, (int)f4, Bitmap.Config.ARGB_8888);
        localObject4 = new Canvas((Bitmap)localObject3);
        localObject5 = new Path();
        ((Path)localObject5).moveTo(0.0F, 0.0F);
        ((Path)localObject5).lineTo(f4, 0.0F);
        ((Path)localObject5).lineTo(0.0F, f4);
        ((Canvas)localObject4).drawPath((Path)localObject5, (Paint)localObject1);
        ((Path)localObject5).reset();
        ((Path)localObject5).moveTo(0.0F + f4, 0.0F);
        ((Path)localObject5).lineTo(0.0F, f4);
        ((Path)localObject5).lineTo(0.0F + f4, f4);
        ((Path)localObject5).lineTo(0.0F + 2.0F * f4, 0.0F);
        ((Canvas)localObject4).drawPath((Path)localObject5, (Paint)localObject2);
        f2 = 0.0F + 2.0F * f4;
        ((Path)localObject5).reset();
        ((Path)localObject5).moveTo(f2, 0.0F);
        ((Path)localObject5).lineTo(f2 - f4, f4);
        ((Path)localObject5).lineTo(f2, f4);
        ((Canvas)localObject4).drawPath((Path)localObject5, (Paint)localObject1);
        this.jTq = ((Bitmap)localObject3);
      }
      for (f1 = 0.0F - f1; f1 < i; f1 += this.jTq.getWidth()) {
        this.jTo.drawBitmap(this.jTq, f1, 0.0F, this.jTn);
      }
    }
    this.jTo.drawRect(0.0F, 0.0F, i, f4, this.jTb);
    if (f5 < 1.0F) {
      this.jTo.restore();
    }
    Object localObject1 = new Path();
    ((Path)localObject1).moveTo(0.0F, 0.0F);
    ((Path)localObject1).lineTo(f3, 0.0F);
    ((Path)localObject1).lineTo(f3, f4);
    ((Path)localObject1).lineTo(0.0F, f4);
    this.jTo.drawPath((Path)localObject1, this.jTd);
    if (this.jTj) {}
    for (f1 = f4 / 2.0F;; f1 = 0.0F)
    {
      localObject1 = this.jTp;
      boolean bool1 = this.jTl;
      boolean bool2 = this.jTk;
      localObject2 = Bitmap.createBitmap(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), Bitmap.Config.ARGB_8888);
      localObject3 = new Canvas((Bitmap)localObject2);
      localObject4 = new Paint();
      localObject5 = new Rect(0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      Rect localRect1 = new Rect(0, 0, ((Bitmap)localObject1).getWidth() / 2, ((Bitmap)localObject1).getHeight());
      Rect localRect2 = new Rect(((Bitmap)localObject1).getWidth() / 2, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      ((Paint)localObject4).setAntiAlias(true);
      ((Paint)localObject4).setColor(-1);
      ((Paint)localObject4).setStyle(Paint.Style.FILL);
      ((Canvas)localObject3).drawARGB(0, 0, 0, 0);
      ((Canvas)localObject3).drawRoundRect(new RectF((Rect)localObject5), f1, f1, (Paint)localObject4);
      if (!bool2) {
        ((Canvas)localObject3).drawRect(localRect1, (Paint)localObject4);
      }
      if (!bool1) {
        ((Canvas)localObject3).drawRect(localRect2, (Paint)localObject4);
      }
      ((Paint)localObject4).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      ((Canvas)localObject3).drawBitmap((Bitmap)localObject1, (Rect)localObject5, (Rect)localObject5, (Paint)localObject4);
      paramCanvas.drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, this.jTn);
      AppMethodBeat.o(45306);
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(45304);
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
    AppMethodBeat.o(45304);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(45305);
    if (paramInt2 != paramInt4) {
      this.jTq = null;
    }
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(45305);
  }
  
  public void setAnimated(boolean paramBoolean)
  {
    AppMethodBeat.i(45309);
    this.jTi = paramBoolean;
    invalidate();
    bdX();
    AppMethodBeat.o(45309);
  }
  
  public void setMaxProgress(float paramFloat)
  {
    AppMethodBeat.i(45310);
    if (getProgress() <= paramFloat)
    {
      this.jTg = paramFloat;
      invalidate();
      AppMethodBeat.o(45310);
      return;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException(String.format("MaxProgress cant be smaller than the current progress %d<%d", new Object[] { Float.valueOf(getProgress()), Float.valueOf(paramFloat) }));
    AppMethodBeat.o(45310);
    throw localIllegalArgumentException;
  }
  
  @SuppressLint({"DefaultLocale"})
  public void setProgress(float paramFloat)
  {
    AppMethodBeat.i(45307);
    float f;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    for (;;)
    {
      this.jTe = f;
      if (!this.jTi) {
        break;
      }
      clearAnimation();
      this.jTm = ValueAnimator.ofFloat(new float[] { this.jTf, this.jTe });
      this.jTm.setDuration(300L);
      this.jTm.setRepeatCount(0);
      this.jTm.setRepeatMode(1);
      this.jTm.setInterpolator(new LinearInterpolator());
      this.jTm.addUpdateListener(this);
      this.jTm.addListener(this);
      this.jTm.start();
      AppMethodBeat.o(45307);
      return;
      f = paramFloat;
      if (paramFloat > this.jTg) {
        f = 100.0F;
      }
    }
    this.jTf = f;
    invalidate();
    AppMethodBeat.o(45307);
  }
  
  public void setProgressColor(int paramInt)
  {
    AppMethodBeat.i(45300);
    this.jTr = paramInt;
    this.jTb.setColor(this.jTr);
    Paint localPaint = this.jTc;
    paramInt = this.jTr;
    localPaint.setColor(Color.rgb((int)(Color.red(paramInt) * 0.7F + Color.red(-16777216) * 0.3F) / 1, (int)(Color.green(paramInt) * 0.7F + Color.green(-16777216) * 0.3F) / 1, (int)(Color.blue(paramInt) * 0.7F + Color.blue(-16777216) * 0.3F) / 1));
    this.jTq = null;
    this.jTp = null;
    this.jTo = null;
    invalidate();
    AppMethodBeat.o(45300);
  }
  
  public void setStriped(boolean paramBoolean)
  {
    AppMethodBeat.i(45308);
    this.jTh = paramBoolean;
    invalidate();
    bdX();
    AppMethodBeat.o(45308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.ui.BootstrapProgressBar
 * JD-Core Version:    0.7.0.1
 */