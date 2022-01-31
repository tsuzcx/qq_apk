package android.support.v4.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v4.f.l;
import android.support.v4.view.b.b;
import android.util.DisplayMetrics;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

public final class d
  extends Drawable
  implements Animatable
{
  private static final Interpolator Je = new b();
  private static final int[] Jf = { -16777216 };
  private static final Interpolator ek = new LinearInterpolator();
  final d.a Jg;
  private float Jh;
  private boolean Ji;
  private float gb;
  private Resources mResources;
  private Animator uP;
  
  public d(Context paramContext)
  {
    this.mResources = ((Context)l.E(paramContext)).getResources();
    this.Jg = new d.a();
    this.Jg.setColors(Jf);
    this.Jg.setStrokeWidth(2.5F);
    invalidateSelf();
    paramContext = this.Jg;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new d.1(this, paramContext));
    localValueAnimator.setRepeatCount(-1);
    localValueAnimator.setRepeatMode(1);
    localValueAnimator.setInterpolator(ek);
    localValueAnimator.addListener(new d.2(this, paramContext));
    this.uP = localValueAnimator;
  }
  
  private static void a(float paramFloat, d.a parama)
  {
    if (paramFloat > 0.75F)
    {
      paramFloat = (paramFloat - 0.75F) / 0.25F;
      int n = parama.dA();
      int i = parama.Jq[parama.dz()];
      int j = n >> 24 & 0xFF;
      int k = n >> 16 & 0xFF;
      int m = n >> 8 & 0xFF;
      n &= 0xFF;
      int i1 = (int)(((i >> 24 & 0xFF) - j) * paramFloat);
      int i2 = (int)(((i >> 16 & 0xFF) - k) * paramFloat);
      int i3 = (int)(((i >> 8 & 0xFF) - m) * paramFloat);
      parama.Aw = ((int)(paramFloat * ((i & 0xFF) - n)) + n | j + i1 << 24 | k + i2 << 16 | i3 + m << 8);
      return;
    }
    parama.Aw = parama.dA();
  }
  
  private void c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    d.a locala = this.Jg;
    float f = this.mResources.getDisplayMetrics().density;
    locala.setStrokeWidth(paramFloat2 * f);
    locala.Jy = (paramFloat1 * f);
    locala.aG(0);
    locala.Jz = ((int)(paramFloat3 * f));
    locala.JA = ((int)(f * paramFloat4));
  }
  
  public final void A(float paramFloat)
  {
    d.a locala = this.Jg;
    if (paramFloat != locala.Jx) {
      locala.Jx = paramFloat;
    }
    invalidateSelf();
  }
  
  public final void B(float paramFloat)
  {
    this.Jg.Jo = 0.0F;
    this.Jg.Jp = paramFloat;
    invalidateSelf();
  }
  
  public final void I(boolean paramBoolean)
  {
    this.Jg.J(paramBoolean);
    invalidateSelf();
  }
  
  public final void aF(int paramInt)
  {
    if (paramInt == 0) {
      c(11.0F, 3.0F, 12.0F, 6.0F);
    }
    for (;;)
    {
      invalidateSelf();
      return;
      c(7.5F, 2.5F, 10.0F, 5.0F);
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    paramCanvas.save();
    paramCanvas.rotate(this.gb, localRect.exactCenterX(), localRect.exactCenterY());
    d.a locala = this.Jg;
    RectF localRectF = locala.Jl;
    float f1 = locala.Jy + locala.na / 2.0F;
    if (locala.Jy <= 0.0F) {
      f1 = Math.min(localRect.width(), localRect.height()) / 2.0F - Math.max(locala.Jz * locala.Jx / 2.0F, locala.na / 2.0F);
    }
    localRectF.set(localRect.centerX() - f1, localRect.centerY() - f1, localRect.centerX() + f1, f1 + localRect.centerY());
    f1 = (locala.Jo + locala.gb) * 360.0F;
    float f2 = (locala.Jp + locala.gb) * 360.0F - f1;
    locala.mPaint.setColor(locala.Aw);
    locala.mPaint.setAlpha(locala.JB);
    float f3 = locala.na / 2.0F;
    localRectF.inset(f3, f3);
    paramCanvas.drawCircle(localRectF.centerX(), localRectF.centerY(), localRectF.width() / 2.0F, locala.Jn);
    localRectF.inset(-f3, -f3);
    paramCanvas.drawArc(localRectF, f1, f2, false, locala.mPaint);
    if (locala.Jv)
    {
      if (locala.Jw != null) {
        break label522;
      }
      locala.Jw = new Path();
      locala.Jw.setFillType(Path.FillType.EVEN_ODD);
    }
    for (;;)
    {
      f3 = Math.min(localRectF.width(), localRectF.height()) / 2.0F;
      float f4 = locala.Jz * locala.Jx / 2.0F;
      locala.Jw.moveTo(0.0F, 0.0F);
      locala.Jw.lineTo(locala.Jz * locala.Jx, 0.0F);
      locala.Jw.lineTo(locala.Jz * locala.Jx / 2.0F, locala.JA * locala.Jx);
      locala.Jw.offset(f3 + localRectF.centerX() - f4, localRectF.centerY() + locala.na / 2.0F);
      locala.Jw.close();
      locala.Jm.setColor(locala.Aw);
      locala.Jm.setAlpha(locala.JB);
      paramCanvas.save();
      paramCanvas.rotate(f1 + f2, localRectF.centerX(), localRectF.centerY());
      paramCanvas.drawPath(locala.Jw, locala.Jm);
      paramCanvas.restore();
      paramCanvas.restore();
      return;
      label522:
      locala.Jw.reset();
    }
  }
  
  public final int getAlpha()
  {
    return this.Jg.JB;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean isRunning()
  {
    return this.uP.isRunning();
  }
  
  public final void setAlpha(int paramInt)
  {
    this.Jg.JB = paramInt;
    invalidateSelf();
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.Jg.mPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public final void start()
  {
    this.uP.cancel();
    this.Jg.dB();
    if (this.Jg.Jp != this.Jg.Jo)
    {
      this.Ji = true;
      this.uP.setDuration(666L);
      this.uP.start();
      return;
    }
    this.Jg.aG(0);
    this.Jg.dC();
    this.uP.setDuration(1332L);
    this.uP.start();
  }
  
  public final void stop()
  {
    this.uP.cancel();
    this.gb = 0.0F;
    this.Jg.J(false);
    this.Jg.aG(0);
    this.Jg.dC();
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v4.widget.d
 * JD-Core Version:    0.7.0.1
 */