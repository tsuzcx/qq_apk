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
  private static final Interpolator PL = new LinearInterpolator();
  private static final Interpolator PM = new b();
  private static final int[] PN = { -16777216 };
  private Animator Cj;
  final a PO;
  private float PP;
  float PQ;
  boolean PR;
  private Resources mResources;
  
  public d(final Context paramContext)
  {
    this.mResources = ((Context)m.checkNotNull(paramContext)).getResources();
    this.PO = new a();
    this.PO.setColors(PN);
    this.PO.setStrokeWidth(2.5F);
    invalidateSelf();
    paramContext = this.PO;
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
    localValueAnimator.setInterpolator(PL);
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        d.this.a(1.0F, paramContext, true);
        paramContext.fk();
        d.a locala = paramContext;
        locala.aU(locala.fi());
        if (d.this.PR)
        {
          d.this.PR = false;
          paramAnonymousAnimator.cancel();
          paramAnonymousAnimator.setDuration(1332L);
          paramAnonymousAnimator.start();
          paramContext.O(false);
          return;
        }
        d.this.PQ += 1.0F;
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        d.this.PQ = 0.0F;
      }
    });
    this.Cj = localValueAnimator;
  }
  
  static void a(float paramFloat, a parama)
  {
    if (paramFloat > 0.75F)
    {
      paramFloat = (paramFloat - 0.75F) / 0.25F;
      int n = parama.fj();
      int i = parama.mColors[parama.fi()];
      int j = n >> 24 & 0xFF;
      int k = n >> 16 & 0xFF;
      int m = n >> 8 & 0xFF;
      n &= 0xFF;
      int i1 = (int)(((i >> 24 & 0xFF) - j) * paramFloat);
      int i2 = (int)(((i >> 16 & 0xFF) - k) * paramFloat);
      int i3 = (int)(((i >> 8 & 0xFF) - m) * paramFloat);
      parama.HE = ((int)(paramFloat * ((i & 0xFF) - n)) + n | j + i1 << 24 | k + i2 << 16 | i3 + m << 8);
      return;
    }
    parama.HE = parama.fj();
  }
  
  private void g(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    a locala = this.PO;
    float f = this.mResources.getDisplayMetrics().density;
    locala.setStrokeWidth(paramFloat2 * f);
    locala.Qg = (paramFloat1 * f);
    locala.aU(0);
    locala.Qh = ((int)(paramFloat3 * f));
    locala.Qi = ((int)(f * paramFloat4));
  }
  
  public final void A(float paramFloat)
  {
    a locala = this.PO;
    if (paramFloat != locala.Qf) {
      locala.Qf = paramFloat;
    }
    invalidateSelf();
  }
  
  public final void B(float paramFloat)
  {
    this.PO.PX = 0.0F;
    this.PO.PY = paramFloat;
    invalidateSelf();
  }
  
  public final void C(float paramFloat)
  {
    this.PO.PP = paramFloat;
    invalidateSelf();
  }
  
  public final void N(boolean paramBoolean)
  {
    this.PO.O(paramBoolean);
    invalidateSelf();
  }
  
  final void a(float paramFloat, a parama, boolean paramBoolean)
  {
    float f1;
    float f2;
    if (this.PR)
    {
      a(paramFloat, parama);
      f1 = (float)(Math.floor(parama.Qc / 0.8F) + 1.0D);
      parama.PX = (parama.Qa + (parama.Qb - 0.01F - parama.Qa) * paramFloat);
      parama.PY = parama.Qb;
      f2 = parama.Qc;
      parama.PP = ((f1 - parama.Qc) * paramFloat + f2);
    }
    while ((paramFloat == 1.0F) && (!paramBoolean)) {
      return;
    }
    float f3 = parama.Qc;
    if (paramFloat < 0.5F)
    {
      f1 = paramFloat / 0.5F;
      f2 = parama.Qa;
      f1 = PM.getInterpolation(f1) * 0.79F + 0.01F + f2;
    }
    for (;;)
    {
      float f4 = this.PQ;
      parama.PX = f2;
      parama.PY = f1;
      parama.PP = (f3 + 0.21F * paramFloat);
      this.PP = (216.0F * (f4 + paramFloat));
      return;
      f2 = (paramFloat - 0.5F) / 0.5F;
      f1 = parama.Qa + 0.79F;
      f2 = f1 - ((1.0F - PM.getInterpolation(f2)) * 0.79F + 0.01F);
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    paramCanvas.save();
    paramCanvas.rotate(this.PP, localRect.exactCenterX(), localRect.exactCenterY());
    a locala = this.PO;
    RectF localRectF = locala.PU;
    float f1 = locala.Qg + locala.uz / 2.0F;
    if (locala.Qg <= 0.0F) {
      f1 = Math.min(localRect.width(), localRect.height()) / 2.0F - Math.max(locala.Qh * locala.Qf / 2.0F, locala.uz / 2.0F);
    }
    localRectF.set(localRect.centerX() - f1, localRect.centerY() - f1, localRect.centerX() + f1, f1 + localRect.centerY());
    f1 = (locala.PX + locala.PP) * 360.0F;
    float f2 = (locala.PY + locala.PP) * 360.0F - f1;
    locala.mPaint.setColor(locala.HE);
    locala.mPaint.setAlpha(locala.mAlpha);
    float f3 = locala.uz / 2.0F;
    localRectF.inset(f3, f3);
    paramCanvas.drawCircle(localRectF.centerX(), localRectF.centerY(), localRectF.width() / 2.0F, locala.PW);
    localRectF.inset(-f3, -f3);
    paramCanvas.drawArc(localRectF, f1, f2, false, locala.mPaint);
    if (locala.Qd)
    {
      if (locala.Qe != null) {
        break label522;
      }
      locala.Qe = new Path();
      locala.Qe.setFillType(Path.FillType.EVEN_ODD);
    }
    for (;;)
    {
      f3 = Math.min(localRectF.width(), localRectF.height()) / 2.0F;
      float f4 = locala.Qh * locala.Qf / 2.0F;
      locala.Qe.moveTo(0.0F, 0.0F);
      locala.Qe.lineTo(locala.Qh * locala.Qf, 0.0F);
      locala.Qe.lineTo(locala.Qh * locala.Qf / 2.0F, locala.Qi * locala.Qf);
      locala.Qe.offset(f3 + localRectF.centerX() - f4, localRectF.centerY() + locala.uz / 2.0F);
      locala.Qe.close();
      locala.PV.setColor(locala.HE);
      locala.PV.setAlpha(locala.mAlpha);
      paramCanvas.save();
      paramCanvas.rotate(f1 + f2, localRectF.centerX(), localRectF.centerY());
      paramCanvas.drawPath(locala.Qe, locala.PV);
      paramCanvas.restore();
      paramCanvas.restore();
      return;
      label522:
      locala.Qe.reset();
    }
  }
  
  public final int getAlpha()
  {
    return this.PO.mAlpha;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean isRunning()
  {
    return this.Cj.isRunning();
  }
  
  public final void setAlpha(int paramInt)
  {
    this.PO.mAlpha = paramInt;
    invalidateSelf();
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.PO.mPaint.setColorFilter(paramColorFilter);
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
    this.Cj.cancel();
    this.PO.fk();
    if (this.PO.PY != this.PO.PX)
    {
      this.PR = true;
      this.Cj.setDuration(666L);
      this.Cj.start();
      return;
    }
    this.PO.aU(0);
    this.PO.fl();
    this.Cj.setDuration(1332L);
    this.Cj.start();
  }
  
  public final void stop()
  {
    this.Cj.cancel();
    this.PP = 0.0F;
    this.PO.O(false);
    this.PO.aU(0);
    this.PO.fl();
    invalidateSelf();
  }
  
  static final class a
  {
    int HE;
    float PP = 0.0F;
    final RectF PU = new RectF();
    final Paint PV = new Paint();
    final Paint PW = new Paint();
    float PX = 0.0F;
    float PY = 0.0F;
    int PZ;
    float Qa;
    float Qb;
    float Qc;
    boolean Qd;
    Path Qe;
    float Qf = 1.0F;
    float Qg;
    int Qh;
    int Qi;
    int mAlpha = 255;
    int[] mColors;
    final Paint mPaint = new Paint();
    float uz = 5.0F;
    
    a()
    {
      this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.PV.setStyle(Paint.Style.FILL);
      this.PV.setAntiAlias(true);
      this.PW.setColor(0);
    }
    
    final void O(boolean paramBoolean)
    {
      if (this.Qd != paramBoolean) {
        this.Qd = paramBoolean;
      }
    }
    
    final void aU(int paramInt)
    {
      this.PZ = paramInt;
      this.HE = this.mColors[this.PZ];
    }
    
    final int fi()
    {
      return (this.PZ + 1) % this.mColors.length;
    }
    
    final int fj()
    {
      return this.mColors[this.PZ];
    }
    
    final void fk()
    {
      this.Qa = this.PX;
      this.Qb = this.PY;
      this.Qc = this.PP;
    }
    
    final void fl()
    {
      this.Qa = 0.0F;
      this.Qb = 0.0F;
      this.Qc = 0.0F;
      this.PX = 0.0F;
      this.PY = 0.0F;
      this.PP = 0.0F;
    }
    
    final void setColors(int[] paramArrayOfInt)
    {
      this.mColors = paramArrayOfInt;
      aU(0);
    }
    
    final void setStrokeWidth(float paramFloat)
    {
      this.uz = paramFloat;
      this.mPaint.setStrokeWidth(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.widget.d
 * JD-Core Version:    0.7.0.1
 */