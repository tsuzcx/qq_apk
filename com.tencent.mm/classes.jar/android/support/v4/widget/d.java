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
import android.support.v4.e.l;
import android.support.v4.view.b.b;
import android.util.DisplayMetrics;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

public final class d
  extends Drawable
  implements Animatable
{
  private static final Interpolator IM = new b();
  private static final int[] IN = { -16777216 };
  private static final Interpolator fi = new LinearInterpolator();
  final d.a IP;
  float IQ;
  boolean IR;
  private float gV;
  private Resources mResources;
  private Animator vM;
  
  public d(Context paramContext)
  {
    this.mResources = ((Context)l.checkNotNull(paramContext)).getResources();
    this.IP = new d.a();
    this.IP.setColors(IN);
    this.IP.setStrokeWidth(2.5F);
    invalidateSelf();
    paramContext = this.IP;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new d.1(this, paramContext));
    localValueAnimator.setRepeatCount(-1);
    localValueAnimator.setRepeatMode(1);
    localValueAnimator.setInterpolator(fi);
    localValueAnimator.addListener(new d.2(this, paramContext));
    this.vM = localValueAnimator;
  }
  
  static void a(float paramFloat, d.a parama)
  {
    if (paramFloat > 0.75F)
    {
      paramFloat = (paramFloat - 0.75F) / 0.25F;
      int n = parama.dR();
      int i = parama.Aq[parama.dQ()];
      int j = n >> 24 & 0xFF;
      int k = n >> 16 & 0xFF;
      int m = n >> 8 & 0xFF;
      n &= 0xFF;
      int i1 = (int)(((i >> 24 & 0xFF) - j) * paramFloat);
      int i2 = (int)(((i >> 16 & 0xFF) - k) * paramFloat);
      int i3 = (int)(((i >> 8 & 0xFF) - m) * paramFloat);
      parama.Bi = ((int)(paramFloat * ((i & 0xFF) - n)) + n | j + i1 << 24 | k + i2 << 16 | i3 + m << 8);
      return;
    }
    parama.Bi = parama.dR();
  }
  
  private void d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    d.a locala = this.IP;
    float f = this.mResources.getDisplayMetrics().density;
    locala.setStrokeWidth(paramFloat2 * f);
    locala.Jg = (paramFloat1 * f);
    locala.aD(0);
    locala.Jh = ((int)(paramFloat3 * f));
    locala.Ji = ((int)(f * paramFloat4));
  }
  
  public final void A(float paramFloat)
  {
    d.a locala = this.IP;
    if (paramFloat != locala.Jf) {
      locala.Jf = paramFloat;
    }
    invalidateSelf();
  }
  
  public final void B(float paramFloat)
  {
    this.IP.IX = 0.0F;
    this.IP.IY = paramFloat;
    invalidateSelf();
  }
  
  public final void C(float paramFloat)
  {
    this.IP.gV = paramFloat;
    invalidateSelf();
  }
  
  public final void H(boolean paramBoolean)
  {
    this.IP.I(paramBoolean);
    invalidateSelf();
  }
  
  final void a(float paramFloat, d.a parama, boolean paramBoolean)
  {
    float f1;
    float f2;
    if (this.IR)
    {
      a(paramFloat, parama);
      f1 = (float)(Math.floor(parama.Jc / 0.8F) + 1.0D);
      parama.IX = (parama.Ja + (parama.Jb - 0.01F - parama.Ja) * paramFloat);
      parama.IY = parama.Jb;
      f2 = parama.Jc;
      parama.gV = ((f1 - parama.Jc) * paramFloat + f2);
    }
    while ((paramFloat == 1.0F) && (!paramBoolean)) {
      return;
    }
    float f3 = parama.Jc;
    if (paramFloat < 0.5F)
    {
      f1 = paramFloat / 0.5F;
      f2 = parama.Ja;
      f1 = IM.getInterpolation(f1) * 0.79F + 0.01F + f2;
    }
    for (;;)
    {
      float f4 = this.IQ;
      parama.IX = f2;
      parama.IY = f1;
      parama.gV = (f3 + 0.21F * paramFloat);
      this.gV = (216.0F * (f4 + paramFloat));
      return;
      f2 = (paramFloat - 0.5F) / 0.5F;
      f1 = parama.Ja + 0.79F;
      f2 = f1 - ((1.0F - IM.getInterpolation(f2)) * 0.79F + 0.01F);
    }
  }
  
  public final void aC(int paramInt)
  {
    if (paramInt == 0) {
      d(11.0F, 3.0F, 12.0F, 6.0F);
    }
    for (;;)
    {
      invalidateSelf();
      return;
      d(7.5F, 2.5F, 10.0F, 5.0F);
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    paramCanvas.save();
    paramCanvas.rotate(this.gV, localRect.exactCenterX(), localRect.exactCenterY());
    d.a locala = this.IP;
    RectF localRectF = locala.IU;
    float f1 = locala.Jg + locala.nX / 2.0F;
    if (locala.Jg <= 0.0F) {
      f1 = Math.min(localRect.width(), localRect.height()) / 2.0F - Math.max(locala.Jh * locala.Jf / 2.0F, locala.nX / 2.0F);
    }
    localRectF.set(localRect.centerX() - f1, localRect.centerY() - f1, localRect.centerX() + f1, f1 + localRect.centerY());
    f1 = (locala.IX + locala.gV) * 360.0F;
    float f2 = (locala.IY + locala.gV) * 360.0F - f1;
    locala.mPaint.setColor(locala.Bi);
    locala.mPaint.setAlpha(locala.mAlpha);
    float f3 = locala.nX / 2.0F;
    localRectF.inset(f3, f3);
    paramCanvas.drawCircle(localRectF.centerX(), localRectF.centerY(), localRectF.width() / 2.0F, locala.IW);
    localRectF.inset(-f3, -f3);
    paramCanvas.drawArc(localRectF, f1, f2, false, locala.mPaint);
    if (locala.Jd)
    {
      if (locala.Je != null) {
        break label522;
      }
      locala.Je = new Path();
      locala.Je.setFillType(Path.FillType.EVEN_ODD);
    }
    for (;;)
    {
      f3 = Math.min(localRectF.width(), localRectF.height()) / 2.0F;
      float f4 = locala.Jh * locala.Jf / 2.0F;
      locala.Je.moveTo(0.0F, 0.0F);
      locala.Je.lineTo(locala.Jh * locala.Jf, 0.0F);
      locala.Je.lineTo(locala.Jh * locala.Jf / 2.0F, locala.Ji * locala.Jf);
      locala.Je.offset(f3 + localRectF.centerX() - f4, localRectF.centerY() + locala.nX / 2.0F);
      locala.Je.close();
      locala.IV.setColor(locala.Bi);
      locala.IV.setAlpha(locala.mAlpha);
      paramCanvas.save();
      paramCanvas.rotate(f1 + f2, localRectF.centerX(), localRectF.centerY());
      paramCanvas.drawPath(locala.Je, locala.IV);
      paramCanvas.restore();
      paramCanvas.restore();
      return;
      label522:
      locala.Je.reset();
    }
  }
  
  public final int getAlpha()
  {
    return this.IP.mAlpha;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean isRunning()
  {
    return this.vM.isRunning();
  }
  
  public final void setAlpha(int paramInt)
  {
    this.IP.mAlpha = paramInt;
    invalidateSelf();
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.IP.mPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public final void start()
  {
    this.vM.cancel();
    this.IP.dS();
    if (this.IP.IY != this.IP.IX)
    {
      this.IR = true;
      this.vM.setDuration(666L);
      this.vM.start();
      return;
    }
    this.IP.aD(0);
    this.IP.dT();
    this.vM.setDuration(1332L);
    this.vM.start();
  }
  
  public final void stop()
  {
    this.vM.cancel();
    this.gV = 0.0F;
    this.IP.I(false);
    this.IP.aD(0);
    this.IP.dT();
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v4.widget.d
 * JD-Core Version:    0.7.0.1
 */