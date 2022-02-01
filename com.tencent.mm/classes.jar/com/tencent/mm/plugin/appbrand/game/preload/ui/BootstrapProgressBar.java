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
import com.tencent.mm.sdk.platformtools.Log;

public class BootstrapProgressBar
  extends View
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  private Paint luA;
  private Canvas luB;
  private Bitmap luC;
  private Bitmap luD;
  private int luE;
  private Paint lun;
  private Paint luo;
  private Paint lup;
  private float luq;
  private float lur;
  private float lus;
  private boolean lut;
  private boolean luu;
  private boolean luv;
  private boolean luw;
  private boolean luy;
  private ValueAnimator luz;
  
  public BootstrapProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(45297);
    this.luq = 0.0F;
    this.lur = 0.0F;
    this.lus = 100.0F;
    this.lut = false;
    this.luu = false;
    this.luv = true;
    this.luw = true;
    this.luy = true;
    bDx();
    AppMethodBeat.o(45297);
  }
  
  public BootstrapProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(45298);
    this.luq = 0.0F;
    this.lur = 0.0F;
    this.lus = 100.0F;
    this.lut = false;
    this.luu = false;
    this.luv = true;
    this.luw = true;
    this.luy = true;
    bDx();
    AppMethodBeat.o(45298);
  }
  
  private void bDx()
  {
    AppMethodBeat.i(45299);
    Log.d("BootstrapProgressBar", "initialise");
    ValueAnimator.setFrameDelay(15L);
    this.luA = new Paint();
    this.lun = new Paint();
    this.lun.setStyle(Paint.Style.FILL);
    this.lun.setAntiAlias(true);
    this.luo = new Paint();
    this.luo.setStyle(Paint.Style.FILL);
    this.luo.setAntiAlias(true);
    this.lup = new Paint();
    this.lup.setStyle(Paint.Style.FILL);
    this.lup.setARGB(38, 0, 0, 0);
    setProgress(this.luq);
    setMaxProgress(this.lus);
    AppMethodBeat.o(45299);
  }
  
  private void bDy()
  {
    AppMethodBeat.i(45303);
    if ((!this.lut) || (!this.luu))
    {
      AppMethodBeat.o(45303);
      return;
    }
    clearAnimation();
    this.luz = ValueAnimator.ofFloat(new float[] { 0.0F, 0.0F });
    this.luz.setDuration(300L);
    this.luz.setRepeatCount(-1);
    this.luz.setRepeatMode(1);
    this.luz.setInterpolator(new LinearInterpolator());
    this.luz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(45296);
        BootstrapProgressBar.this.invalidate();
        AppMethodBeat.o(45296);
      }
    });
    this.luz.start();
    AppMethodBeat.o(45303);
  }
  
  public float getMaxProgress()
  {
    return this.lus;
  }
  
  public float getProgress()
  {
    return this.luq;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(45302);
    bDy();
    AppMethodBeat.o(45302);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(45301);
    this.lur = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
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
    if (this.luC == null) {
      this.luC = Bitmap.createBitmap((int)f3, (int)f4, Bitmap.Config.ARGB_8888);
    }
    if (this.luB == null) {
      this.luB = new Canvas(this.luC);
    }
    this.luB.drawColor(0, PorterDuff.Mode.CLEAR);
    float f5 = this.luq / this.lus;
    int i = (int)(f3 * f5);
    float f2 = 0.0F;
    float f6 = (float)(System.currentTimeMillis() % 370L) / 370.0F;
    float f1 = f2;
    if (this.lut)
    {
      f1 = f2;
      if (this.luu) {
        f1 = 2.0F * f4 * (1.0F - f6);
      }
    }
    if (f5 < 1.0F)
    {
      this.luB.save();
      localObject1 = new Path();
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(i, 0.0F);
      ((Path)localObject1).lineTo(i - f4, f4);
      ((Path)localObject1).lineTo(0.0F, f4);
      this.luB.clipPath((Path)localObject1);
    }
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (this.lut)
    {
      if (this.luD == null)
      {
        localObject1 = this.luo;
        localObject2 = this.lun;
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
        this.luD = ((Bitmap)localObject3);
      }
      for (f1 = 0.0F - f1; f1 < i; f1 += this.luD.getWidth()) {
        this.luB.drawBitmap(this.luD, f1, 0.0F, this.luA);
      }
    }
    this.luB.drawRect(0.0F, 0.0F, i, f4, this.lun);
    if (f5 < 1.0F) {
      this.luB.restore();
    }
    Object localObject1 = new Path();
    ((Path)localObject1).moveTo(0.0F, 0.0F);
    ((Path)localObject1).lineTo(f3, 0.0F);
    ((Path)localObject1).lineTo(f3, f4);
    ((Path)localObject1).lineTo(0.0F, f4);
    this.luB.drawPath((Path)localObject1, this.lup);
    if (this.luv) {}
    for (f1 = f4 / 2.0F;; f1 = 0.0F)
    {
      localObject1 = this.luC;
      boolean bool1 = this.luy;
      boolean bool2 = this.luw;
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
      paramCanvas.drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, this.luA);
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
      this.luD = null;
    }
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(45305);
  }
  
  public void setAnimated(boolean paramBoolean)
  {
    AppMethodBeat.i(45309);
    this.luu = paramBoolean;
    invalidate();
    bDy();
    AppMethodBeat.o(45309);
  }
  
  public void setMaxProgress(float paramFloat)
  {
    AppMethodBeat.i(45310);
    if (getProgress() <= paramFloat)
    {
      this.lus = paramFloat;
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
      this.luq = f;
      if (!this.luu) {
        break;
      }
      clearAnimation();
      this.luz = ValueAnimator.ofFloat(new float[] { this.lur, this.luq });
      this.luz.setDuration(300L);
      this.luz.setRepeatCount(0);
      this.luz.setRepeatMode(1);
      this.luz.setInterpolator(new LinearInterpolator());
      this.luz.addUpdateListener(this);
      this.luz.addListener(this);
      this.luz.start();
      AppMethodBeat.o(45307);
      return;
      f = paramFloat;
      if (paramFloat > this.lus) {
        f = 100.0F;
      }
    }
    this.lur = f;
    invalidate();
    AppMethodBeat.o(45307);
  }
  
  public void setProgressColor(int paramInt)
  {
    AppMethodBeat.i(45300);
    this.luE = paramInt;
    this.lun.setColor(this.luE);
    Paint localPaint = this.luo;
    paramInt = this.luE;
    localPaint.setColor(Color.rgb((int)(Color.red(paramInt) * 0.7F + Color.red(-16777216) * 0.3F) / 1, (int)(Color.green(paramInt) * 0.7F + Color.green(-16777216) * 0.3F) / 1, (int)(Color.blue(paramInt) * 0.7F + Color.blue(-16777216) * 0.3F) / 1));
    this.luD = null;
    this.luC = null;
    this.luB = null;
    invalidate();
    AppMethodBeat.o(45300);
  }
  
  public void setStriped(boolean paramBoolean)
  {
    AppMethodBeat.i(45308);
    this.lut = paramBoolean;
    invalidate();
    bDy();
    AppMethodBeat.o(45308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.ui.BootstrapProgressBar
 * JD-Core Version:    0.7.0.1
 */