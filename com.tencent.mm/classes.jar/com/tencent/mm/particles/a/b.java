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
  private final Matrix eY = new Matrix();
  public float ipA;
  public float ipC;
  public Float ipE;
  public Float ipG;
  public float ipM;
  public Float ipO;
  public long ipQ;
  public Interpolator ipu;
  public Rect ipv;
  private final Paint iqe = new Paint(1);
  public long iqf;
  public float iqg;
  public float iqh;
  public float iqi;
  public float iqj;
  public Long iqk;
  public Long iql;
  public float iqm;
  public float iqn;
  public Long iqo;
  public float iqp;
  public float iqq;
  public float iqr;
  public float iqs;
  public float iqt;
  public boolean iqu;
  public boolean iqv;
  public float iqw;
  public float iqx;
  public float iqy;
  public float iqz;
  public VelocityTracker mq;
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
    paramCanvas.clipRect(this.ipv);
    this.eY.reset();
    this.iqe.setAlpha(this.alpha);
    a(paramCanvas, this.eY, this.iqe, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    paramCanvas.restore();
  }
  
  protected abstract void a(Canvas paramCanvas, Matrix paramMatrix, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public abstract int getHeight();
  
  public abstract int getWidth();
  
  public final void j(Rect paramRect)
  {
    this.ipv = paramRect;
    this.iqk = a(this.ipE, this.iqi, this.ipA);
    this.iql = a(this.ipG, this.iqj, this.ipC);
    this.iqo = a(this.ipO, this.iqn, this.ipM);
    if (this.iqp == 0.0F) {
      if (this.ipQ < 0L) {
        break label199;
      }
    }
    label199:
    for (float f = (float)this.ipQ;; f = 9.223372E+018F)
    {
      this.iqp = f;
      this.iqp = Math.min((float)a(this.iqg, this.iqi, this.ipA, this.iqk, this.ipE, paramRect.left - getWidth(), paramRect.right), this.iqp);
      this.iqp = Math.min((float)a(this.iqh, this.iqj, this.ipC, this.iql, this.ipG, paramRect.top - getHeight(), paramRect.bottom), this.iqp);
      this.iqe.setAlpha(this.alpha);
      return;
    }
  }
  
  public void reset()
  {
    this.iqf = 0L;
    this.iqh = 0.0F;
    this.iqg = 0.0F;
    this.iqj = 0.0F;
    this.iqi = 0.0F;
    this.ipC = 0.0F;
    this.ipA = 0.0F;
    this.ipG = null;
    this.ipE = null;
    this.iql = null;
    this.iqk = null;
    this.iqm = 0.0F;
    this.iqn = 0.0F;
    this.ipM = 0.0F;
    this.ipO = null;
    this.iqo = null;
    this.ipQ = 0L;
    this.iqp = 0.0F;
    this.iqq = 0.0F;
    this.ipu = null;
    this.iqs = 0.0F;
    this.iqr = 0.0F;
    this.iqt = 0.0F;
    this.alpha = 255;
    this.iqu = false;
    this.terminated = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.particles.a.b
 * JD-Core Version:    0.7.0.1
 */