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
import com.tencent.mm.sdk.platformtools.ae;

public class BootstrapProgressBar
  extends View
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  private Paint kqF;
  private Paint kqG;
  private Paint kqH;
  private float kqI;
  private float kqJ;
  private float kqK;
  private boolean kqL;
  private boolean kqM;
  private boolean kqN;
  private boolean kqO;
  private boolean kqP;
  private ValueAnimator kqQ;
  private Paint kqR;
  private Canvas kqS;
  private Bitmap kqT;
  private Bitmap kqU;
  private int kqV;
  
  public BootstrapProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(45297);
    this.kqI = 0.0F;
    this.kqJ = 0.0F;
    this.kqK = 100.0F;
    this.kqL = false;
    this.kqM = false;
    this.kqN = true;
    this.kqO = true;
    this.kqP = true;
    bii();
    AppMethodBeat.o(45297);
  }
  
  public BootstrapProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(45298);
    this.kqI = 0.0F;
    this.kqJ = 0.0F;
    this.kqK = 100.0F;
    this.kqL = false;
    this.kqM = false;
    this.kqN = true;
    this.kqO = true;
    this.kqP = true;
    bii();
    AppMethodBeat.o(45298);
  }
  
  private void bii()
  {
    AppMethodBeat.i(45299);
    ae.d("BootstrapProgressBar", "initialise");
    ValueAnimator.setFrameDelay(15L);
    this.kqR = new Paint();
    this.kqF = new Paint();
    this.kqF.setStyle(Paint.Style.FILL);
    this.kqF.setAntiAlias(true);
    this.kqG = new Paint();
    this.kqG.setStyle(Paint.Style.FILL);
    this.kqG.setAntiAlias(true);
    this.kqH = new Paint();
    this.kqH.setStyle(Paint.Style.FILL);
    this.kqH.setARGB(38, 0, 0, 0);
    setProgress(this.kqI);
    setMaxProgress(this.kqK);
    AppMethodBeat.o(45299);
  }
  
  private void bij()
  {
    AppMethodBeat.i(45303);
    if ((!this.kqL) || (!this.kqM))
    {
      AppMethodBeat.o(45303);
      return;
    }
    clearAnimation();
    this.kqQ = ValueAnimator.ofFloat(new float[] { 0.0F, 0.0F });
    this.kqQ.setDuration(300L);
    this.kqQ.setRepeatCount(-1);
    this.kqQ.setRepeatMode(1);
    this.kqQ.setInterpolator(new LinearInterpolator());
    this.kqQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(45296);
        BootstrapProgressBar.this.invalidate();
        AppMethodBeat.o(45296);
      }
    });
    this.kqQ.start();
    AppMethodBeat.o(45303);
  }
  
  public float getMaxProgress()
  {
    return this.kqK;
  }
  
  public float getProgress()
  {
    return this.kqI;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(45302);
    bij();
    AppMethodBeat.o(45302);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(45301);
    this.kqJ = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
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
    if (this.kqT == null) {
      this.kqT = Bitmap.createBitmap((int)f3, (int)f4, Bitmap.Config.ARGB_8888);
    }
    if (this.kqS == null) {
      this.kqS = new Canvas(this.kqT);
    }
    this.kqS.drawColor(0, PorterDuff.Mode.CLEAR);
    float f5 = this.kqI / this.kqK;
    int i = (int)(f3 * f5);
    float f2 = 0.0F;
    float f6 = (float)(System.currentTimeMillis() % 370L) / 370.0F;
    float f1 = f2;
    if (this.kqL)
    {
      f1 = f2;
      if (this.kqM) {
        f1 = 2.0F * f4 * (1.0F - f6);
      }
    }
    if (f5 < 1.0F)
    {
      this.kqS.save();
      localObject1 = new Path();
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(i, 0.0F);
      ((Path)localObject1).lineTo(i - f4, f4);
      ((Path)localObject1).lineTo(0.0F, f4);
      this.kqS.clipPath((Path)localObject1);
    }
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (this.kqL)
    {
      if (this.kqU == null)
      {
        localObject1 = this.kqG;
        localObject2 = this.kqF;
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
        this.kqU = ((Bitmap)localObject3);
      }
      for (f1 = 0.0F - f1; f1 < i; f1 += this.kqU.getWidth()) {
        this.kqS.drawBitmap(this.kqU, f1, 0.0F, this.kqR);
      }
    }
    this.kqS.drawRect(0.0F, 0.0F, i, f4, this.kqF);
    if (f5 < 1.0F) {
      this.kqS.restore();
    }
    Object localObject1 = new Path();
    ((Path)localObject1).moveTo(0.0F, 0.0F);
    ((Path)localObject1).lineTo(f3, 0.0F);
    ((Path)localObject1).lineTo(f3, f4);
    ((Path)localObject1).lineTo(0.0F, f4);
    this.kqS.drawPath((Path)localObject1, this.kqH);
    if (this.kqN) {}
    for (f1 = f4 / 2.0F;; f1 = 0.0F)
    {
      localObject1 = this.kqT;
      boolean bool1 = this.kqP;
      boolean bool2 = this.kqO;
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
      paramCanvas.drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, this.kqR);
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
      this.kqU = null;
    }
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(45305);
  }
  
  public void setAnimated(boolean paramBoolean)
  {
    AppMethodBeat.i(45309);
    this.kqM = paramBoolean;
    invalidate();
    bij();
    AppMethodBeat.o(45309);
  }
  
  public void setMaxProgress(float paramFloat)
  {
    AppMethodBeat.i(45310);
    if (getProgress() <= paramFloat)
    {
      this.kqK = paramFloat;
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
      this.kqI = f;
      if (!this.kqM) {
        break;
      }
      clearAnimation();
      this.kqQ = ValueAnimator.ofFloat(new float[] { this.kqJ, this.kqI });
      this.kqQ.setDuration(300L);
      this.kqQ.setRepeatCount(0);
      this.kqQ.setRepeatMode(1);
      this.kqQ.setInterpolator(new LinearInterpolator());
      this.kqQ.addUpdateListener(this);
      this.kqQ.addListener(this);
      this.kqQ.start();
      AppMethodBeat.o(45307);
      return;
      f = paramFloat;
      if (paramFloat > this.kqK) {
        f = 100.0F;
      }
    }
    this.kqJ = f;
    invalidate();
    AppMethodBeat.o(45307);
  }
  
  public void setProgressColor(int paramInt)
  {
    AppMethodBeat.i(45300);
    this.kqV = paramInt;
    this.kqF.setColor(this.kqV);
    Paint localPaint = this.kqG;
    paramInt = this.kqV;
    localPaint.setColor(Color.rgb((int)(Color.red(paramInt) * 0.7F + Color.red(-16777216) * 0.3F) / 1, (int)(Color.green(paramInt) * 0.7F + Color.green(-16777216) * 0.3F) / 1, (int)(Color.blue(paramInt) * 0.7F + Color.blue(-16777216) * 0.3F) / 1));
    this.kqU = null;
    this.kqT = null;
    this.kqS = null;
    invalidate();
    AppMethodBeat.o(45300);
  }
  
  public void setStriped(boolean paramBoolean)
  {
    AppMethodBeat.i(45308);
    this.kqL = paramBoolean;
    invalidate();
    bij();
    AppMethodBeat.o(45308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.ui.BootstrapProgressBar
 * JD-Core Version:    0.7.0.1
 */