package android.support.v4.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v4.e.m;
import android.support.v4.view.b.b;
import android.util.DisplayMetrics;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

public final class d
  extends Drawable
  implements Animatable
{
  private static final Interpolator Sv = new LinearInterpolator();
  private static final Interpolator Sw = new b();
  private static final int[] Sx = { -16777216 };
  private Animator EZ;
  float SA;
  boolean SB;
  final a Sy;
  private float Sz;
  private Resources mResources;
  
  public d(final Context paramContext)
  {
    this.mResources = ((Context)m.checkNotNull(paramContext)).getResources();
    this.Sy = new a();
    this.Sy.setColors(Sx);
    this.Sy.setStrokeWidth(2.5F);
    invalidateSelf();
    paramContext = this.Sy;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        d.a(f, paramContext);
        d.this.a(f, paramContext, false);
        d.this.invalidateSelf();
      }
    });
    localValueAnimator.setRepeatCount(-1);
    localValueAnimator.setRepeatMode(1);
    localValueAnimator.setInterpolator(Sv);
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        d.this.a(1.0F, paramContext, true);
        paramContext.fJ();
        d.a locala = paramContext;
        locala.aU(locala.fH());
        if (d.this.SB)
        {
          d.this.SB = false;
          paramAnonymousAnimator.cancel();
          paramAnonymousAnimator.setDuration(1332L);
          paramAnonymousAnimator.start();
          paramContext.O(false);
          return;
        }
        d.this.SA += 1.0F;
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        d.this.SA = 0.0F;
      }
    });
    this.EZ = localValueAnimator;
  }
  
  static void a(float paramFloat, a parama)
  {
    if (paramFloat > 0.75F)
    {
      paramFloat = (paramFloat - 0.75F) / 0.25F;
      int n = parama.fI();
      int i = parama.mColors[parama.fH()];
      int j = n >> 24 & 0xFF;
      int k = n >> 16 & 0xFF;
      int m = n >> 8 & 0xFF;
      n &= 0xFF;
      int i1 = (int)(((i >> 24 & 0xFF) - j) * paramFloat);
      int i2 = (int)(((i >> 16 & 0xFF) - k) * paramFloat);
      int i3 = (int)(((i >> 8 & 0xFF) - m) * paramFloat);
      parama.Ks = ((int)(paramFloat * ((i & 0xFF) - n)) + n | j + i1 << 24 | k + i2 << 16 | i3 + m << 8);
      return;
    }
    parama.Ks = parama.fI();
  }
  
  private void g(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    a locala = this.Sy;
    float f = this.mResources.getDisplayMetrics().density;
    locala.setStrokeWidth(paramFloat2 * f);
    locala.SQ = (paramFloat1 * f);
    locala.aU(0);
    locala.SR = ((int)(paramFloat3 * f));
    locala.SS = ((int)(f * paramFloat4));
  }
  
  public final void C(float paramFloat)
  {
    a locala = this.Sy;
    if (paramFloat != locala.SP) {
      locala.SP = paramFloat;
    }
    invalidateSelf();
  }
  
  public final void D(float paramFloat)
  {
    this.Sy.SH = 0.0F;
    this.Sy.SI = paramFloat;
    invalidateSelf();
  }
  
  public final void E(float paramFloat)
  {
    this.Sy.Sz = paramFloat;
    invalidateSelf();
  }
  
  public final void N(boolean paramBoolean)
  {
    this.Sy.O(paramBoolean);
    invalidateSelf();
  }
  
  final void a(float paramFloat, a parama, boolean paramBoolean)
  {
    float f1;
    float f2;
    if (this.SB)
    {
      a(paramFloat, parama);
      f1 = (float)(Math.floor(parama.SM / 0.8F) + 1.0D);
      parama.SH = (parama.SK + (parama.SL - 0.01F - parama.SK) * paramFloat);
      parama.SI = parama.SL;
      f2 = parama.SM;
      parama.Sz = ((f1 - parama.SM) * paramFloat + f2);
    }
    while ((paramFloat == 1.0F) && (!paramBoolean)) {
      return;
    }
    float f3 = parama.SM;
    if (paramFloat < 0.5F)
    {
      f1 = paramFloat / 0.5F;
      f2 = parama.SK;
      f1 = Sw.getInterpolation(f1) * 0.79F + 0.01F + f2;
    }
    for (;;)
    {
      float f4 = this.SA;
      parama.SH = f2;
      parama.SI = f1;
      parama.Sz = (f3 + 0.21F * paramFloat);
      this.Sz = (216.0F * (f4 + paramFloat));
      return;
      f2 = (paramFloat - 0.5F) / 0.5F;
      f1 = parama.SK + 0.79F;
      f2 = f1 - ((1.0F - Sw.getInterpolation(f2)) * 0.79F + 0.01F);
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    paramCanvas.save();
    paramCanvas.rotate(this.Sz, localRect.exactCenterX(), localRect.exactCenterY());
    a locala = this.Sy;
    RectF localRectF = locala.SE;
    float f1 = locala.SQ + locala.xq / 2.0F;
    if (locala.SQ <= 0.0F) {
      f1 = Math.min(localRect.width(), localRect.height()) / 2.0F - Math.max(locala.SR * locala.SP / 2.0F, locala.xq / 2.0F);
    }
    localRectF.set(localRect.centerX() - f1, localRect.centerY() - f1, localRect.centerX() + f1, f1 + localRect.centerY());
    f1 = (locala.SH + locala.Sz) * 360.0F;
    float f2 = (locala.SI + locala.Sz) * 360.0F - f1;
    locala.mPaint.setColor(locala.Ks);
    locala.mPaint.setAlpha(locala.mAlpha);
    float f3 = locala.xq / 2.0F;
    localRectF.inset(f3, f3);
    paramCanvas.drawCircle(localRectF.centerX(), localRectF.centerY(), localRectF.width() / 2.0F, locala.SG);
    localRectF.inset(-f3, -f3);
    paramCanvas.drawArc(localRectF, f1, f2, false, locala.mPaint);
    if (locala.SN)
    {
      if (locala.SO != null) {
        break label522;
      }
      locala.SO = new Path();
      locala.SO.setFillType(Path.FillType.EVEN_ODD);
    }
    for (;;)
    {
      f3 = Math.min(localRectF.width(), localRectF.height()) / 2.0F;
      float f4 = locala.SR * locala.SP / 2.0F;
      locala.SO.moveTo(0.0F, 0.0F);
      locala.SO.lineTo(locala.SR * locala.SP, 0.0F);
      locala.SO.lineTo(locala.SR * locala.SP / 2.0F, locala.SS * locala.SP);
      locala.SO.offset(f3 + localRectF.centerX() - f4, localRectF.centerY() + locala.xq / 2.0F);
      locala.SO.close();
      locala.SF.setColor(locala.Ks);
      locala.SF.setAlpha(locala.mAlpha);
      paramCanvas.save();
      paramCanvas.rotate(f1 + f2, localRectF.centerX(), localRectF.centerY());
      paramCanvas.drawPath(locala.SO, locala.SF);
      paramCanvas.restore();
      paramCanvas.restore();
      return;
      label522:
      locala.SO.reset();
    }
  }
  
  public final int getAlpha()
  {
    return this.Sy.mAlpha;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean isRunning()
  {
    return this.EZ.isRunning();
  }
  
  public final void setAlpha(int paramInt)
  {
    this.Sy.mAlpha = paramInt;
    invalidateSelf();
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.Sy.mPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public final void setStyle(int paramInt)
  {
    if (paramInt == 0) {
      g(11.0F, 3.0F, 12.0F, 6.0F);
    }
    for (;;)
    {
      invalidateSelf();
      return;
      g(7.5F, 2.5F, 10.0F, 5.0F);
    }
  }
  
  public final void start()
  {
    this.EZ.cancel();
    this.Sy.fJ();
    if (this.Sy.SI != this.Sy.SH)
    {
      this.SB = true;
      this.EZ.setDuration(666L);
      this.EZ.start();
      return;
    }
    this.Sy.aU(0);
    this.Sy.fK();
    this.EZ.setDuration(1332L);
    this.EZ.start();
  }
  
  public final void stop()
  {
    this.EZ.cancel();
    this.Sz = 0.0F;
    this.Sy.O(false);
    this.Sy.aU(0);
    this.Sy.fK();
    invalidateSelf();
  }
  
  static final class a
  {
    int Ks;
    final RectF SE = new RectF();
    final Paint SF = new Paint();
    final Paint SG = new Paint();
    float SH = 0.0F;
    float SI = 0.0F;
    int SJ;
    float SK;
    float SL;
    float SM;
    boolean SN;
    Path SO;
    float SP = 1.0F;
    float SQ;
    int SR;
    int SS;
    float Sz = 0.0F;
    int mAlpha = 255;
    int[] mColors;
    final Paint mPaint = new Paint();
    float xq = 5.0F;
    
    a()
    {
      this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.SF.setStyle(Paint.Style.FILL);
      this.SF.setAntiAlias(true);
      this.SG.setColor(0);
    }
    
    final void O(boolean paramBoolean)
    {
      if (this.SN != paramBoolean) {
        this.SN = paramBoolean;
      }
    }
    
    final void aU(int paramInt)
    {
      this.SJ = paramInt;
      this.Ks = this.mColors[this.SJ];
    }
    
    final int fH()
    {
      return (this.SJ + 1) % this.mColors.length;
    }
    
    final int fI()
    {
      return this.mColors[this.SJ];
    }
    
    final void fJ()
    {
      this.SK = this.SH;
      this.SL = this.SI;
      this.SM = this.Sz;
    }
    
    final void fK()
    {
      this.SK = 0.0F;
      this.SL = 0.0F;
      this.SM = 0.0F;
      this.SH = 0.0F;
      this.SI = 0.0F;
      this.Sz = 0.0F;
    }
    
    final void setColors(int[] paramArrayOfInt)
    {
      this.mColors = paramArrayOfInt;
      aU(0);
    }
    
    final void setStrokeWidth(float paramFloat)
    {
      this.xq = paramFloat;
      this.mPaint.setStrokeWidth(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.widget.d
 * JD-Core Version:    0.7.0.1
 */