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
import com.tencent.mm.sdk.platformtools.ad;

public class BootstrapProgressBar
  extends View
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  private Paint jsH;
  private Paint jsI;
  private Paint jsJ;
  private float jsK;
  private float jsL;
  private float jsM;
  private boolean jsN;
  private boolean jsO;
  private boolean jsP;
  private boolean jsQ;
  private boolean jsR;
  private ValueAnimator jsS;
  private Paint jsT;
  private Canvas jsU;
  private Bitmap jsV;
  private Bitmap jsW;
  private int jsX;
  
  public BootstrapProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(45297);
    this.jsK = 0.0F;
    this.jsL = 0.0F;
    this.jsM = 100.0F;
    this.jsN = false;
    this.jsO = false;
    this.jsP = true;
    this.jsQ = true;
    this.jsR = true;
    aWY();
    AppMethodBeat.o(45297);
  }
  
  public BootstrapProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(45298);
    this.jsK = 0.0F;
    this.jsL = 0.0F;
    this.jsM = 100.0F;
    this.jsN = false;
    this.jsO = false;
    this.jsP = true;
    this.jsQ = true;
    this.jsR = true;
    aWY();
    AppMethodBeat.o(45298);
  }
  
  private void aWY()
  {
    AppMethodBeat.i(45299);
    ad.d("BootstrapProgressBar", "initialise");
    ValueAnimator.setFrameDelay(15L);
    this.jsT = new Paint();
    this.jsH = new Paint();
    this.jsH.setStyle(Paint.Style.FILL);
    this.jsH.setAntiAlias(true);
    this.jsI = new Paint();
    this.jsI.setStyle(Paint.Style.FILL);
    this.jsI.setAntiAlias(true);
    this.jsJ = new Paint();
    this.jsJ.setStyle(Paint.Style.FILL);
    this.jsJ.setARGB(38, 0, 0, 0);
    setProgress(this.jsK);
    setMaxProgress(this.jsM);
    AppMethodBeat.o(45299);
  }
  
  private void aWZ()
  {
    AppMethodBeat.i(45303);
    if ((!this.jsN) || (!this.jsO))
    {
      AppMethodBeat.o(45303);
      return;
    }
    clearAnimation();
    this.jsS = ValueAnimator.ofFloat(new float[] { 0.0F, 0.0F });
    this.jsS.setDuration(300L);
    this.jsS.setRepeatCount(-1);
    this.jsS.setRepeatMode(1);
    this.jsS.setInterpolator(new LinearInterpolator());
    this.jsS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(45296);
        BootstrapProgressBar.this.invalidate();
        AppMethodBeat.o(45296);
      }
    });
    this.jsS.start();
    AppMethodBeat.o(45303);
  }
  
  public float getMaxProgress()
  {
    return this.jsM;
  }
  
  public float getProgress()
  {
    return this.jsK;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(45302);
    aWZ();
    AppMethodBeat.o(45302);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(45301);
    this.jsL = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
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
    if (this.jsV == null) {
      this.jsV = Bitmap.createBitmap((int)f3, (int)f4, Bitmap.Config.ARGB_8888);
    }
    if (this.jsU == null) {
      this.jsU = new Canvas(this.jsV);
    }
    this.jsU.drawColor(0, PorterDuff.Mode.CLEAR);
    float f5 = this.jsK / this.jsM;
    int i = (int)(f3 * f5);
    float f2 = 0.0F;
    float f6 = (float)(System.currentTimeMillis() % 370L) / 370.0F;
    float f1 = f2;
    if (this.jsN)
    {
      f1 = f2;
      if (this.jsO) {
        f1 = 2.0F * f4 * (1.0F - f6);
      }
    }
    if (f5 < 1.0F)
    {
      this.jsU.save();
      localObject1 = new Path();
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(i, 0.0F);
      ((Path)localObject1).lineTo(i - f4, f4);
      ((Path)localObject1).lineTo(0.0F, f4);
      this.jsU.clipPath((Path)localObject1);
    }
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (this.jsN)
    {
      if (this.jsW == null)
      {
        localObject1 = this.jsI;
        localObject2 = this.jsH;
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
        this.jsW = ((Bitmap)localObject3);
      }
      for (f1 = 0.0F - f1; f1 < i; f1 += this.jsW.getWidth()) {
        this.jsU.drawBitmap(this.jsW, f1, 0.0F, this.jsT);
      }
    }
    this.jsU.drawRect(0.0F, 0.0F, i, f4, this.jsH);
    if (f5 < 1.0F) {
      this.jsU.restore();
    }
    Object localObject1 = new Path();
    ((Path)localObject1).moveTo(0.0F, 0.0F);
    ((Path)localObject1).lineTo(f3, 0.0F);
    ((Path)localObject1).lineTo(f3, f4);
    ((Path)localObject1).lineTo(0.0F, f4);
    this.jsU.drawPath((Path)localObject1, this.jsJ);
    if (this.jsP) {}
    for (f1 = f4 / 2.0F;; f1 = 0.0F)
    {
      localObject1 = this.jsV;
      boolean bool1 = this.jsR;
      boolean bool2 = this.jsQ;
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
      paramCanvas.drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, this.jsT);
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
      this.jsW = null;
    }
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(45305);
  }
  
  public void setAnimated(boolean paramBoolean)
  {
    AppMethodBeat.i(45309);
    this.jsO = paramBoolean;
    invalidate();
    aWZ();
    AppMethodBeat.o(45309);
  }
  
  public void setMaxProgress(float paramFloat)
  {
    AppMethodBeat.i(45310);
    if (getProgress() <= paramFloat)
    {
      this.jsM = paramFloat;
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
      this.jsK = f;
      if (!this.jsO) {
        break;
      }
      clearAnimation();
      this.jsS = ValueAnimator.ofFloat(new float[] { this.jsL, this.jsK });
      this.jsS.setDuration(300L);
      this.jsS.setRepeatCount(0);
      this.jsS.setRepeatMode(1);
      this.jsS.setInterpolator(new LinearInterpolator());
      this.jsS.addUpdateListener(this);
      this.jsS.addListener(this);
      this.jsS.start();
      AppMethodBeat.o(45307);
      return;
      f = paramFloat;
      if (paramFloat > this.jsM) {
        f = 100.0F;
      }
    }
    this.jsL = f;
    invalidate();
    AppMethodBeat.o(45307);
  }
  
  public void setProgressColor(int paramInt)
  {
    AppMethodBeat.i(45300);
    this.jsX = paramInt;
    this.jsH.setColor(this.jsX);
    Paint localPaint = this.jsI;
    paramInt = this.jsX;
    localPaint.setColor(Color.rgb((int)(Color.red(paramInt) * 0.7F + Color.red(-16777216) * 0.3F) / 1, (int)(Color.green(paramInt) * 0.7F + Color.green(-16777216) * 0.3F) / 1, (int)(Color.blue(paramInt) * 0.7F + Color.blue(-16777216) * 0.3F) / 1));
    this.jsW = null;
    this.jsV = null;
    this.jsU = null;
    invalidate();
    AppMethodBeat.o(45300);
  }
  
  public void setStriped(boolean paramBoolean)
  {
    AppMethodBeat.i(45308);
    this.jsN = paramBoolean;
    invalidate();
    aWZ();
    AppMethodBeat.o(45308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.ui.BootstrapProgressBar
 * JD-Core Version:    0.7.0.1
 */