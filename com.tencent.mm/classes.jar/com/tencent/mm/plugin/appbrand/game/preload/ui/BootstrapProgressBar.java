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

public class BootstrapProgressBar
  extends View
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  private boolean huA;
  private boolean huB;
  private boolean huC;
  private boolean huD;
  private ValueAnimator huE;
  private Paint huF;
  private Canvas huG;
  private Bitmap huH;
  private Bitmap huI;
  private int huJ;
  private Paint hut;
  private Paint huu;
  private Paint huv;
  private float huw;
  private float hux;
  private float huy;
  private boolean huz;
  
  public BootstrapProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(130310);
    this.huw = 0.0F;
    this.hux = 0.0F;
    this.huy = 100.0F;
    this.huz = true;
    this.huA = true;
    this.huB = true;
    this.huC = true;
    this.huD = true;
    aAU();
    AppMethodBeat.o(130310);
  }
  
  public BootstrapProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(130311);
    this.huw = 0.0F;
    this.hux = 0.0F;
    this.huy = 100.0F;
    this.huz = true;
    this.huA = true;
    this.huB = true;
    this.huC = true;
    this.huD = true;
    aAU();
    AppMethodBeat.o(130311);
  }
  
  private void aAU()
  {
    AppMethodBeat.i(130312);
    ValueAnimator.setFrameDelay(15L);
    this.huF = new Paint();
    this.hut = new Paint();
    this.hut.setStyle(Paint.Style.FILL);
    this.hut.setAntiAlias(true);
    this.huu = new Paint();
    this.huu.setStyle(Paint.Style.FILL);
    this.huu.setAntiAlias(true);
    this.huv = new Paint();
    this.huv.setStyle(Paint.Style.FILL);
    this.huv.setARGB(38, 0, 0, 0);
    setProgress(this.huw);
    setMaxProgress(this.huy);
    AppMethodBeat.o(130312);
  }
  
  private void aAV()
  {
    AppMethodBeat.i(130316);
    if ((!this.huz) || (!this.huA))
    {
      AppMethodBeat.o(130316);
      return;
    }
    clearAnimation();
    this.huE = ValueAnimator.ofFloat(new float[] { 0.0F, 0.0F });
    this.huE.setDuration(300L);
    this.huE.setRepeatCount(-1);
    this.huE.setRepeatMode(1);
    this.huE.setInterpolator(new LinearInterpolator());
    this.huE.addUpdateListener(new BootstrapProgressBar.1(this));
    this.huE.start();
    AppMethodBeat.o(130316);
  }
  
  public float getMaxProgress()
  {
    return this.huy;
  }
  
  public float getProgress()
  {
    return this.huw;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(130315);
    aAV();
    AppMethodBeat.o(130315);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(130314);
    this.hux = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    invalidate();
    AppMethodBeat.o(130314);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(130319);
    float f3 = getWidth();
    float f4 = getHeight();
    if ((f3 <= 0.0F) || (f4 <= 0.0F))
    {
      AppMethodBeat.o(130319);
      return;
    }
    if (this.huH == null) {
      this.huH = Bitmap.createBitmap((int)f3, (int)f4, Bitmap.Config.ARGB_8888);
    }
    if (this.huG == null) {
      this.huG = new Canvas(this.huH);
    }
    this.huG.drawColor(0, PorterDuff.Mode.CLEAR);
    float f5 = this.huw / this.huy;
    int i = (int)(f3 * f5);
    float f2 = 0.0F;
    float f6 = (float)(System.currentTimeMillis() % 370L) / 370.0F;
    float f1 = f2;
    if (this.huz)
    {
      f1 = f2;
      if (this.huA) {
        f1 = 2.0F * f4 * (1.0F - f6);
      }
    }
    if (f5 < 1.0F)
    {
      this.huG.save();
      localObject1 = new Path();
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(i, 0.0F);
      ((Path)localObject1).lineTo(i - f4, f4);
      ((Path)localObject1).lineTo(0.0F, f4);
      this.huG.clipPath((Path)localObject1);
    }
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (this.huz)
    {
      if (this.huI == null)
      {
        localObject1 = this.huu;
        localObject2 = this.hut;
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
        this.huI = ((Bitmap)localObject3);
      }
      for (f1 = 0.0F - f1; f1 < i; f1 += this.huI.getWidth()) {
        this.huG.drawBitmap(this.huI, f1, 0.0F, this.huF);
      }
    }
    this.huG.drawRect(0.0F, 0.0F, i, f4, this.hut);
    if (f5 < 1.0F) {
      this.huG.restore();
    }
    Object localObject1 = new Path();
    ((Path)localObject1).moveTo(0.0F, 0.0F);
    ((Path)localObject1).lineTo(f3, 0.0F);
    ((Path)localObject1).lineTo(f3, f4);
    ((Path)localObject1).lineTo(0.0F, f4);
    this.huG.drawPath((Path)localObject1, this.huv);
    if (this.huB) {}
    for (f1 = f4 / 2.0F;; f1 = 0.0F)
    {
      localObject1 = this.huH;
      boolean bool1 = this.huD;
      boolean bool2 = this.huC;
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
      paramCanvas.drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, this.huF);
      AppMethodBeat.o(130319);
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130317);
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
    AppMethodBeat.o(130317);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(130318);
    if (paramInt2 != paramInt4) {
      this.huI = null;
    }
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(130318);
  }
  
  public void setAnimated(boolean paramBoolean)
  {
    AppMethodBeat.i(130322);
    this.huA = paramBoolean;
    invalidate();
    aAV();
    AppMethodBeat.o(130322);
  }
  
  public void setMaxProgress(float paramFloat)
  {
    AppMethodBeat.i(130323);
    if (getProgress() <= paramFloat)
    {
      this.huy = paramFloat;
      invalidate();
      AppMethodBeat.o(130323);
      return;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException(String.format("MaxProgress cant be smaller than the current progress %d<%d", new Object[] { Float.valueOf(getProgress()), Float.valueOf(paramFloat) }));
    AppMethodBeat.o(130323);
    throw localIllegalArgumentException;
  }
  
  @SuppressLint({"DefaultLocale"})
  public void setProgress(float paramFloat)
  {
    AppMethodBeat.i(130320);
    float f;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    for (;;)
    {
      this.huw = f;
      if (!this.huA) {
        break;
      }
      clearAnimation();
      this.huE = ValueAnimator.ofFloat(new float[] { this.hux, this.huw });
      this.huE.setDuration(300L);
      this.huE.setRepeatCount(0);
      this.huE.setRepeatMode(1);
      this.huE.setInterpolator(new LinearInterpolator());
      this.huE.addUpdateListener(this);
      this.huE.addListener(this);
      this.huE.start();
      AppMethodBeat.o(130320);
      return;
      f = paramFloat;
      if (paramFloat > this.huy) {
        f = 100.0F;
      }
    }
    this.hux = f;
    invalidate();
    AppMethodBeat.o(130320);
  }
  
  public void setProgressColor(int paramInt)
  {
    AppMethodBeat.i(130313);
    this.huJ = paramInt;
    this.hut.setColor(this.huJ);
    Paint localPaint = this.huu;
    paramInt = this.huJ;
    localPaint.setColor(Color.rgb((int)(Color.red(paramInt) * 0.7F + Color.red(-16777216) * 0.3F) / 1, (int)(Color.green(paramInt) * 0.7F + Color.green(-16777216) * 0.3F) / 1, (int)(Color.blue(paramInt) * 0.7F + Color.blue(-16777216) * 0.3F) / 1));
    this.huI = null;
    this.huH = null;
    this.huG = null;
    invalidate();
    AppMethodBeat.o(130313);
  }
  
  public void setStriped(boolean paramBoolean)
  {
    AppMethodBeat.i(130321);
    this.huz = paramBoolean;
    invalidate();
    aAV();
    AppMethodBeat.o(130321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.ui.BootstrapProgressBar
 * JD-Core Version:    0.7.0.1
 */