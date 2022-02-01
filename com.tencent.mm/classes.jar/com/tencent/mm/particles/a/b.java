package com.tencent.mm.particles.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.VelocityTracker;
import android.view.animation.Interpolator;

public abstract class b
{
  public int alpha;
  public VelocityTracker doL;
  private final Matrix matrix = new Matrix();
  public float pwF;
  public Float pwH;
  public long pwJ;
  private final Paint pwX = new Paint(1);
  public long pwY;
  public float pwZ;
  public Interpolator pwn;
  public Rect pwo;
  public float pwt;
  public float pwv;
  public Float pwx;
  public Float pwz;
  public float pxa;
  public float pxb;
  public float pxc;
  public Long pxd;
  public Long pxe;
  public float pxf;
  public float pxg;
  public Long pxh;
  public float pxi;
  public float pxj;
  public float pxk;
  public float pxl;
  public float pxm;
  public boolean pxn;
  public boolean pxo;
  public float pxp;
  public float pxq;
  public float pxr;
  public float pxs;
  public boolean terminated;
  
  public static float a(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, Long paramLong1, Float paramFloat)
  {
    if ((paramLong1 == null) || (paramLong < paramLong1.longValue())) {
      return (float)paramLong * paramFloat2 + paramFloat1 + 0.5F * paramFloat3 * (float)paramLong * (float)paramLong;
    }
    return (float)paramLong1.longValue() * paramFloat2 + paramFloat1 + 0.5F * paramFloat3 * (float)paramLong1.longValue() * (float)paramLong1.longValue() + (float)(paramLong - paramLong1.longValue()) * paramFloat.floatValue();
  }
  
  private static long a(float paramFloat1, float paramFloat2, float paramFloat3, Long paramLong, Float paramFloat, int paramInt1, int paramInt2)
  {
    double d1;
    if (paramFloat3 != 0.0F)
    {
      if (paramFloat3 > 0.0F) {}
      while ((paramLong == null) || (paramLong.longValue() < 0L))
      {
        d1 = Math.sqrt(2.0F * paramFloat3 * paramInt2 - 2.0F * paramFloat3 * paramFloat1 + paramFloat2 * paramFloat2);
        double d2 = (-d1 - paramFloat2) / paramFloat3;
        if (d2 > 0.0D)
        {
          return d2;
          paramInt2 = paramInt1;
        }
        else
        {
          d1 = (d1 - paramFloat2) / paramFloat3;
          if (d1 > 0.0D) {
            return d1;
          }
          return 9223372036854775807L;
        }
      }
      d1 = (paramInt2 - paramFloat1 - (float)paramLong.longValue() * paramFloat2 - 0.5D * paramFloat3 * paramLong.longValue() * paramLong.longValue() + paramFloat.floatValue() * (float)paramLong.longValue()) / paramFloat.floatValue();
      if (d1 > 0.0D) {
        return d1;
      }
      return 9223372036854775807L;
    }
    if (paramLong == null) {
      if (paramFloat2 <= 0.0F) {
        break label218;
      }
    }
    for (;;)
    {
      if (paramFloat2 != 0.0F)
      {
        d1 = (paramInt2 - paramFloat1) / paramFloat2;
        if (d1 > 0.0D)
        {
          return d1;
          paramFloat2 = paramFloat.floatValue();
          break;
          label218:
          paramInt2 = paramInt1;
          continue;
        }
        return 9223372036854775807L;
      }
    }
    return 9223372036854775807L;
  }
  
  private static Long a(Float paramFloat, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    long l;
    if (paramFloat != null)
    {
      if (paramFloat2 == 0.0F) {
        break label47;
      }
      l = ((paramFloat.floatValue() - paramFloat1) / paramFloat2);
      if (l <= 0L) {
        break label42;
      }
      localObject1 = Long.valueOf(l);
    }
    label42:
    label47:
    do
    {
      return localObject1;
      l = 0L;
      break;
      localObject1 = localObject2;
    } while (paramFloat.floatValue() >= paramFloat1);
    return Long.valueOf(0L);
  }
  
  public final void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramCanvas.save();
    paramCanvas.clipRect(this.pwo);
    this.matrix.reset();
    this.pwX.setAlpha(this.alpha);
    a(paramCanvas, this.matrix, this.pwX, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    paramCanvas.restore();
  }
  
  protected abstract void a(Canvas paramCanvas, Matrix paramMatrix, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public abstract int getHeight();
  
  public abstract int getWidth();
  
  public void reset()
  {
    this.pwY = 0L;
    this.pxa = 0.0F;
    this.pwZ = 0.0F;
    this.pxc = 0.0F;
    this.pxb = 0.0F;
    this.pwv = 0.0F;
    this.pwt = 0.0F;
    this.pwz = null;
    this.pwx = null;
    this.pxe = null;
    this.pxd = null;
    this.pxf = 0.0F;
    this.pxg = 0.0F;
    this.pwF = 0.0F;
    this.pwH = null;
    this.pxh = null;
    this.pwJ = 0L;
    this.pxi = 0.0F;
    this.pxj = 0.0F;
    this.pwn = null;
    this.pxl = 0.0F;
    this.pxk = 0.0F;
    this.pxm = 0.0F;
    this.alpha = 255;
    this.pxn = false;
    this.terminated = false;
  }
  
  public final void u(Rect paramRect)
  {
    this.pwo = paramRect;
    this.pxd = a(this.pwx, this.pxb, this.pwt);
    this.pxe = a(this.pwz, this.pxc, this.pwv);
    this.pxh = a(this.pwH, this.pxg, this.pwF);
    if (this.pxi == 0.0F) {
      if (this.pwJ < 0L) {
        break label199;
      }
    }
    label199:
    for (float f = (float)this.pwJ;; f = 9.223372E+018F)
    {
      this.pxi = f;
      this.pxi = Math.min((float)a(this.pwZ, this.pxb, this.pwt, this.pxd, this.pwx, paramRect.left - getWidth(), paramRect.right), this.pxi);
      this.pxi = Math.min((float)a(this.pxa, this.pxc, this.pwv, this.pxe, this.pwz, paramRect.top - getHeight(), paramRect.bottom), this.pxi);
      this.pwX.setAlpha(this.alpha);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.particles.a.b
 * JD-Core Version:    0.7.0.1
 */