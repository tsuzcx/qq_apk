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
  private static final Interpolator QG = new LinearInterpolator();
  private static final Interpolator QH = new b();
  private static final int[] QI = { -16777216 };
  private Animator Di;
  final a QJ;
  private float QK;
  float QL;
  boolean QM;
  private Resources mResources;
  
  public d(final Context paramContext)
  {
    this.mResources = ((Context)m.checkNotNull(paramContext)).getResources();
    this.QJ = new a();
    this.QJ.setColors(QI);
    this.QJ.setStrokeWidth(2.5F);
    invalidateSelf();
    paramContext = this.QJ;
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
    localValueAnimator.setInterpolator(QG);
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        d.this.a(1.0F, paramContext, true);
        paramContext.fs();
        d.a locala = paramContext;
        locala.aU(locala.fq());
        if (d.this.QM)
        {
          d.this.QM = false;
          paramAnonymousAnimator.cancel();
          paramAnonymousAnimator.setDuration(1332L);
          paramAnonymousAnimator.start();
          paramContext.O(false);
          return;
        }
        d.this.QL += 1.0F;
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        d.this.QL = 0.0F;
      }
    });
    this.Di = localValueAnimator;
  }
  
  static void a(float paramFloat, a parama)
  {
    if (paramFloat > 0.75F)
    {
      paramFloat = (paramFloat - 0.75F) / 0.25F;
      int n = parama.fr();
      int i = parama.mColors[parama.fq()];
      int j = n >> 24 & 0xFF;
      int k = n >> 16 & 0xFF;
      int m = n >> 8 & 0xFF;
      n &= 0xFF;
      int i1 = (int)(((i >> 24 & 0xFF) - j) * paramFloat);
      int i2 = (int)(((i >> 16 & 0xFF) - k) * paramFloat);
      int i3 = (int)(((i >> 8 & 0xFF) - m) * paramFloat);
      parama.IA = ((int)(paramFloat * ((i & 0xFF) - n)) + n | j + i1 << 24 | k + i2 << 16 | i3 + m << 8);
      return;
    }
    parama.IA = parama.fr();
  }
  
  private void g(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    a locala = this.QJ;
    float f = this.mResources.getDisplayMetrics().density;
    locala.setStrokeWidth(paramFloat2 * f);
    locala.Rb = (paramFloat1 * f);
    locala.aU(0);
    locala.Rc = ((int)(paramFloat3 * f));
    locala.Rd = ((int)(f * paramFloat4));
  }
  
  public final void E(float paramFloat)
  {
    a locala = this.QJ;
    if (paramFloat != locala.Ra) {
      locala.Ra = paramFloat;
    }
    invalidateSelf();
  }
  
  public final void F(float paramFloat)
  {
    this.QJ.QS = 0.0F;
    this.QJ.QT = paramFloat;
    invalidateSelf();
  }
  
  public final void G(float paramFloat)
  {
    this.QJ.QK = paramFloat;
    invalidateSelf();
  }
  
  public final void N(boolean paramBoolean)
  {
    this.QJ.O(paramBoolean);
    invalidateSelf();
  }
  
  final void a(float paramFloat, a parama, boolean paramBoolean)
  {
    float f1;
    float f2;
    if (this.QM)
    {
      a(paramFloat, parama);
      f1 = (float)(Math.floor(parama.QX / 0.8F) + 1.0D);
      parama.QS = (parama.QV + (parama.QW - 0.01F - parama.QV) * paramFloat);
      parama.QT = parama.QW;
      f2 = parama.QX;
      parama.QK = ((f1 - parama.QX) * paramFloat + f2);
    }
    while ((paramFloat == 1.0F) && (!paramBoolean)) {
      return;
    }
    float f3 = parama.QX;
    if (paramFloat < 0.5F)
    {
      f1 = paramFloat / 0.5F;
      f2 = parama.QV;
      f1 = QH.getInterpolation(f1) * 0.79F + 0.01F + f2;
    }
    for (;;)
    {
      float f4 = this.QL;
      parama.QS = f2;
      parama.QT = f1;
      parama.QK = (f3 + 0.21F * paramFloat);
      this.QK = (216.0F * (f4 + paramFloat));
      return;
      f2 = (paramFloat - 0.5F) / 0.5F;
      f1 = parama.QV + 0.79F;
      f2 = f1 - ((1.0F - QH.getInterpolation(f2)) * 0.79F + 0.01F);
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    paramCanvas.save();
    paramCanvas.rotate(this.QK, localRect.exactCenterX(), localRect.exactCenterY());
    a locala = this.QJ;
    RectF localRectF = locala.QP;
    float f1 = locala.Rb + locala.vx / 2.0F;
    if (locala.Rb <= 0.0F) {
      f1 = Math.min(localRect.width(), localRect.height()) / 2.0F - Math.max(locala.Rc * locala.Ra / 2.0F, locala.vx / 2.0F);
    }
    localRectF.set(localRect.centerX() - f1, localRect.centerY() - f1, localRect.centerX() + f1, f1 + localRect.centerY());
    f1 = (locala.QS + locala.QK) * 360.0F;
    float f2 = (locala.QT + locala.QK) * 360.0F - f1;
    locala.mPaint.setColor(locala.IA);
    locala.mPaint.setAlpha(locala.mAlpha);
    float f3 = locala.vx / 2.0F;
    localRectF.inset(f3, f3);
    paramCanvas.drawCircle(localRectF.centerX(), localRectF.centerY(), localRectF.width() / 2.0F, locala.QR);
    localRectF.inset(-f3, -f3);
    paramCanvas.drawArc(localRectF, f1, f2, false, locala.mPaint);
    if (locala.QY)
    {
      if (locala.QZ != null) {
        break label522;
      }
      locala.QZ = new Path();
      locala.QZ.setFillType(Path.FillType.EVEN_ODD);
    }
    for (;;)
    {
      f3 = Math.min(localRectF.width(), localRectF.height()) / 2.0F;
      float f4 = locala.Rc * locala.Ra / 2.0F;
      locala.QZ.moveTo(0.0F, 0.0F);
      locala.QZ.lineTo(locala.Rc * locala.Ra, 0.0F);
      locala.QZ.lineTo(locala.Rc * locala.Ra / 2.0F, locala.Rd * locala.Ra);
      locala.QZ.offset(f3 + localRectF.centerX() - f4, localRectF.centerY() + locala.vx / 2.0F);
      locala.QZ.close();
      locala.QQ.setColor(locala.IA);
      locala.QQ.setAlpha(locala.mAlpha);
      paramCanvas.save();
      paramCanvas.rotate(f1 + f2, localRectF.centerX(), localRectF.centerY());
      paramCanvas.drawPath(locala.QZ, locala.QQ);
      paramCanvas.restore();
      paramCanvas.restore();
      return;
      label522:
      locala.QZ.reset();
    }
  }
  
  public final int getAlpha()
  {
    return this.QJ.mAlpha;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean isRunning()
  {
    return this.Di.isRunning();
  }
  
  public final void setAlpha(int paramInt)
  {
    this.QJ.mAlpha = paramInt;
    invalidateSelf();
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.QJ.mPaint.setColorFilter(paramColorFilter);
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
    this.Di.cancel();
    this.QJ.fs();
    if (this.QJ.QT != this.QJ.QS)
    {
      this.QM = true;
      this.Di.setDuration(666L);
      this.Di.start();
      return;
    }
    this.QJ.aU(0);
    this.QJ.ft();
    this.Di.setDuration(1332L);
    this.Di.start();
  }
  
  public final void stop()
  {
    this.Di.cancel();
    this.QK = 0.0F;
    this.QJ.O(false);
    this.QJ.aU(0);
    this.QJ.ft();
    invalidateSelf();
  }
  
  static final class a
  {
    int IA;
    float QK = 0.0F;
    final RectF QP = new RectF();
    final Paint QQ = new Paint();
    final Paint QR = new Paint();
    float QS = 0.0F;
    float QT = 0.0F;
    int QU;
    float QV;
    float QW;
    float QX;
    boolean QY;
    Path QZ;
    float Ra = 1.0F;
    float Rb;
    int Rc;
    int Rd;
    int mAlpha = 255;
    int[] mColors;
    final Paint mPaint = new Paint();
    float vx = 5.0F;
    
    a()
    {
      this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.QQ.setStyle(Paint.Style.FILL);
      this.QQ.setAntiAlias(true);
      this.QR.setColor(0);
    }
    
    final void O(boolean paramBoolean)
    {
      if (this.QY != paramBoolean) {
        this.QY = paramBoolean;
      }
    }
    
    final void aU(int paramInt)
    {
      this.QU = paramInt;
      this.IA = this.mColors[this.QU];
    }
    
    final int fq()
    {
      return (this.QU + 1) % this.mColors.length;
    }
    
    final int fr()
    {
      return this.mColors[this.QU];
    }
    
    final void fs()
    {
      this.QV = this.QS;
      this.QW = this.QT;
      this.QX = this.QK;
    }
    
    final void ft()
    {
      this.QV = 0.0F;
      this.QW = 0.0F;
      this.QX = 0.0F;
      this.QS = 0.0F;
      this.QT = 0.0F;
      this.QK = 0.0F;
    }
    
    final void setColors(int[] paramArrayOfInt)
    {
      this.mColors = paramArrayOfInt;
      aU(0);
    }
    
    final void setStrokeWidth(float paramFloat)
    {
      this.vx = paramFloat;
      this.mPaint.setStrokeWidth(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.widget.d
 * JD-Core Version:    0.7.0.1
 */