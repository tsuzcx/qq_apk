package com.tencent.mm.plugin.luckymoney.particles.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.VelocityTracker;
import android.view.animation.Interpolator;

public abstract class b
{
  public int alpha;
  private final Matrix aqv = new Matrix();
  public float lSF;
  public Float lSH;
  public long lSJ;
  private final Paint lSX = new Paint(1);
  public long lSY;
  public float lSZ;
  public Interpolator lSn;
  public Rect lSo;
  public float lSt;
  public float lSv;
  public Float lSx;
  public Float lSz;
  public float lTa;
  public float lTb;
  public float lTc;
  public Long lTd;
  public Long lTe;
  public float lTf;
  public float lTg;
  public Long lTh;
  public float lTi;
  public float lTj;
  public float lTk;
  public float lTl;
  public float lTm;
  public boolean lTn;
  public boolean lTo;
  public VelocityTracker lTp;
  public float lTq;
  public float lTr;
  public float lTs;
  public float lTt;
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
  
  public final void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramCanvas.save();
    paramCanvas.clipRect(this.lSo);
    this.aqv.reset();
    this.lSX.setAlpha(this.alpha);
    a(paramCanvas, this.aqv, this.lSX, paramFloat1, paramFloat2, paramFloat3);
    paramCanvas.restore();
  }
  
  protected abstract void a(Canvas paramCanvas, Matrix paramMatrix, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract int getHeight();
  
  public abstract int getWidth();
  
  public final void i(Rect paramRect)
  {
    this.lSo = paramRect;
    this.lTd = a(this.lSx, this.lTb, this.lSt);
    this.lTe = a(this.lSz, this.lTc, this.lSv);
    this.lTh = a(this.lSH, this.lTg, this.lSF);
    if (this.lTi == 0.0F) {
      if (this.lSJ < 0L) {
        break label199;
      }
    }
    label199:
    for (float f = (float)this.lSJ;; f = 9.223372E+018F)
    {
      this.lTi = f;
      this.lTi = Math.min((float)a(this.lSZ, this.lTb, this.lSt, this.lTd, this.lSx, paramRect.left - getWidth(), paramRect.right), this.lTi);
      this.lTi = Math.min((float)a(this.lTa, this.lTc, this.lSv, this.lTe, this.lSz, paramRect.top - getHeight(), paramRect.bottom), this.lTi);
      this.lSX.setAlpha(this.alpha);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.particles.a.b
 * JD-Core Version:    0.7.0.1
 */