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
  private static final Interpolator SI = new LinearInterpolator();
  private static final Interpolator SJ = new b();
  private static final int[] SK = { -16777216 };
  private Animator Fj;
  final a SL;
  private float SM;
  float SN;
  boolean SO;
  private Resources mResources;
  
  public d(final Context paramContext)
  {
    this.mResources = ((Context)m.checkNotNull(paramContext)).getResources();
    this.SL = new a();
    this.SL.setColors(SK);
    this.SL.setStrokeWidth(2.5F);
    invalidateSelf();
    paramContext = this.SL;
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
    localValueAnimator.setInterpolator(SI);
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        d.this.a(1.0F, paramContext, true);
        paramContext.fQ();
        d.a locala = paramContext;
        locala.aV(locala.fO());
        if (d.this.SO)
        {
          d.this.SO = false;
          paramAnonymousAnimator.cancel();
          paramAnonymousAnimator.setDuration(1332L);
          paramAnonymousAnimator.start();
          paramContext.N(false);
          return;
        }
        d.this.SN += 1.0F;
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        d.this.SN = 0.0F;
      }
    });
    this.Fj = localValueAnimator;
  }
  
  static void a(float paramFloat, a parama)
  {
    if (paramFloat > 0.75F)
    {
      paramFloat = (paramFloat - 0.75F) / 0.25F;
      int n = parama.fP();
      int i = parama.mColors[parama.fO()];
      int j = n >> 24 & 0xFF;
      int k = n >> 16 & 0xFF;
      int m = n >> 8 & 0xFF;
      n &= 0xFF;
      int i1 = (int)(((i >> 24 & 0xFF) - j) * paramFloat);
      int i2 = (int)(((i >> 16 & 0xFF) - k) * paramFloat);
      int i3 = (int)(((i >> 8 & 0xFF) - m) * paramFloat);
      parama.KC = ((int)(paramFloat * ((i & 0xFF) - n)) + n | j + i1 << 24 | k + i2 << 16 | i3 + m << 8);
      return;
    }
    parama.KC = parama.fP();
  }
  
  private void g(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    a locala = this.SL;
    float f = this.mResources.getDisplayMetrics().density;
    locala.setStrokeWidth(paramFloat2 * f);
    locala.Tc = (paramFloat1 * f);
    locala.aV(0);
    locala.Td = ((int)(paramFloat3 * f));
    locala.Te = ((int)(f * paramFloat4));
  }
  
  public final void C(float paramFloat)
  {
    a locala = this.SL;
    if (paramFloat != locala.Tb) {
      locala.Tb = paramFloat;
    }
    invalidateSelf();
  }
  
  public final void D(float paramFloat)
  {
    this.SL.SU = 0.0F;
    this.SL.SV = paramFloat;
    invalidateSelf();
  }
  
  public final void E(float paramFloat)
  {
    this.SL.SM = paramFloat;
    invalidateSelf();
  }
  
  public final void M(boolean paramBoolean)
  {
    this.SL.N(paramBoolean);
    invalidateSelf();
  }
  
  final void a(float paramFloat, a parama, boolean paramBoolean)
  {
    float f1;
    float f2;
    if (this.SO)
    {
      a(paramFloat, parama);
      f1 = (float)(Math.floor(parama.SZ / 0.8F) + 1.0D);
      parama.SU = (parama.SX + (parama.SY - 0.01F - parama.SX) * paramFloat);
      parama.SV = parama.SY;
      f2 = parama.SZ;
      parama.SM = ((f1 - parama.SZ) * paramFloat + f2);
    }
    while ((paramFloat == 1.0F) && (!paramBoolean)) {
      return;
    }
    float f3 = parama.SZ;
    if (paramFloat < 0.5F)
    {
      f1 = paramFloat / 0.5F;
      f2 = parama.SX;
      f1 = SJ.getInterpolation(f1) * 0.79F + 0.01F + f2;
    }
    for (;;)
    {
      float f4 = this.SN;
      parama.SU = f2;
      parama.SV = f1;
      parama.SM = (f3 + 0.21F * paramFloat);
      this.SM = (216.0F * (f4 + paramFloat));
      return;
      f2 = (paramFloat - 0.5F) / 0.5F;
      f1 = parama.SX + 0.79F;
      f2 = f1 - ((1.0F - SJ.getInterpolation(f2)) * 0.79F + 0.01F);
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    paramCanvas.save();
    paramCanvas.rotate(this.SM, localRect.exactCenterX(), localRect.exactCenterY());
    a locala = this.SL;
    RectF localRectF = locala.SR;
    float f1 = locala.Tc + locala.mStrokeWidth / 2.0F;
    if (locala.Tc <= 0.0F) {
      f1 = Math.min(localRect.width(), localRect.height()) / 2.0F - Math.max(locala.Td * locala.Tb / 2.0F, locala.mStrokeWidth / 2.0F);
    }
    localRectF.set(localRect.centerX() - f1, localRect.centerY() - f1, localRect.centerX() + f1, f1 + localRect.centerY());
    f1 = (locala.SU + locala.SM) * 360.0F;
    float f2 = (locala.SV + locala.SM) * 360.0F - f1;
    locala.mPaint.setColor(locala.KC);
    locala.mPaint.setAlpha(locala.mAlpha);
    float f3 = locala.mStrokeWidth / 2.0F;
    localRectF.inset(f3, f3);
    paramCanvas.drawCircle(localRectF.centerX(), localRectF.centerY(), localRectF.width() / 2.0F, locala.ST);
    localRectF.inset(-f3, -f3);
    paramCanvas.drawArc(localRectF, f1, f2, false, locala.mPaint);
    if (locala.mShowArrow)
    {
      if (locala.Ta != null) {
        break label522;
      }
      locala.Ta = new Path();
      locala.Ta.setFillType(Path.FillType.EVEN_ODD);
    }
    for (;;)
    {
      f3 = Math.min(localRectF.width(), localRectF.height()) / 2.0F;
      float f4 = locala.Td * locala.Tb / 2.0F;
      locala.Ta.moveTo(0.0F, 0.0F);
      locala.Ta.lineTo(locala.Td * locala.Tb, 0.0F);
      locala.Ta.lineTo(locala.Td * locala.Tb / 2.0F, locala.Te * locala.Tb);
      locala.Ta.offset(f3 + localRectF.centerX() - f4, localRectF.centerY() + locala.mStrokeWidth / 2.0F);
      locala.Ta.close();
      locala.SS.setColor(locala.KC);
      locala.SS.setAlpha(locala.mAlpha);
      paramCanvas.save();
      paramCanvas.rotate(f1 + f2, localRectF.centerX(), localRectF.centerY());
      paramCanvas.drawPath(locala.Ta, locala.SS);
      paramCanvas.restore();
      paramCanvas.restore();
      return;
      label522:
      locala.Ta.reset();
    }
  }
  
  public final int getAlpha()
  {
    return this.SL.mAlpha;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean isRunning()
  {
    return this.Fj.isRunning();
  }
  
  public final void setAlpha(int paramInt)
  {
    this.SL.mAlpha = paramInt;
    invalidateSelf();
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.SL.mPaint.setColorFilter(paramColorFilter);
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
    this.Fj.cancel();
    this.SL.fQ();
    if (this.SL.SV != this.SL.SU)
    {
      this.SO = true;
      this.Fj.setDuration(666L);
      this.Fj.start();
      return;
    }
    this.SL.aV(0);
    this.SL.fR();
    this.Fj.setDuration(1332L);
    this.Fj.start();
  }
  
  public final void stop()
  {
    this.Fj.cancel();
    this.SM = 0.0F;
    this.SL.N(false);
    this.SL.aV(0);
    this.SL.fR();
    invalidateSelf();
  }
  
  static final class a
  {
    int KC;
    float SM = 0.0F;
    final RectF SR = new RectF();
    final Paint SS = new Paint();
    final Paint ST = new Paint();
    float SU = 0.0F;
    float SV = 0.0F;
    int SW;
    float SX;
    float SY;
    float SZ;
    Path Ta;
    float Tb = 1.0F;
    float Tc;
    int Td;
    int Te;
    int mAlpha = 255;
    int[] mColors;
    final Paint mPaint = new Paint();
    boolean mShowArrow;
    float mStrokeWidth = 5.0F;
    
    a()
    {
      this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.SS.setStyle(Paint.Style.FILL);
      this.SS.setAntiAlias(true);
      this.ST.setColor(0);
    }
    
    final void N(boolean paramBoolean)
    {
      if (this.mShowArrow != paramBoolean) {
        this.mShowArrow = paramBoolean;
      }
    }
    
    final void aV(int paramInt)
    {
      this.SW = paramInt;
      this.KC = this.mColors[this.SW];
    }
    
    final int fO()
    {
      return (this.SW + 1) % this.mColors.length;
    }
    
    final int fP()
    {
      return this.mColors[this.SW];
    }
    
    final void fQ()
    {
      this.SX = this.SU;
      this.SY = this.SV;
      this.SZ = this.SM;
    }
    
    final void fR()
    {
      this.SX = 0.0F;
      this.SY = 0.0F;
      this.SZ = 0.0F;
      this.SU = 0.0F;
      this.SV = 0.0F;
      this.SM = 0.0F;
    }
    
    final void setColors(int[] paramArrayOfInt)
    {
      this.mColors = paramArrayOfInt;
      aV(0);
    }
    
    final void setStrokeWidth(float paramFloat)
    {
      this.mStrokeWidth = paramFloat;
      this.mPaint.setStrokeWidth(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.widget.d
 * JD-Core Version:    0.7.0.1
 */