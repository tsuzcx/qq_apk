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
  private final Matrix dY = new Matrix();
  public Interpolator hOZ;
  private final Paint hPJ = new Paint(1);
  public long hPK;
  public float hPL;
  public float hPM;
  public float hPN;
  public float hPO;
  public Long hPP;
  public Long hPQ;
  public float hPR;
  public float hPS;
  public Long hPT;
  public float hPU;
  public float hPV;
  public float hPW;
  public float hPX;
  public float hPY;
  public boolean hPZ;
  public Rect hPa;
  public float hPf;
  public float hPh;
  public Float hPj;
  public Float hPl;
  public float hPr;
  public Float hPt;
  public long hPv;
  public boolean hQa;
  public float hQb;
  public float hQc;
  public float hQd;
  public float hQe;
  public VelocityTracker lr;
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
    paramCanvas.clipRect(this.hPa);
    this.dY.reset();
    this.hPJ.setAlpha(this.alpha);
    a(paramCanvas, this.dY, this.hPJ, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    paramCanvas.restore();
  }
  
  protected abstract void a(Canvas paramCanvas, Matrix paramMatrix, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public abstract int getHeight();
  
  public abstract int getWidth();
  
  public final void k(Rect paramRect)
  {
    this.hPa = paramRect;
    this.hPP = a(this.hPj, this.hPN, this.hPf);
    this.hPQ = a(this.hPl, this.hPO, this.hPh);
    this.hPT = a(this.hPt, this.hPS, this.hPr);
    if (this.hPU == 0.0F) {
      if (this.hPv < 0L) {
        break label199;
      }
    }
    label199:
    for (float f = (float)this.hPv;; f = 9.223372E+018F)
    {
      this.hPU = f;
      this.hPU = Math.min((float)a(this.hPL, this.hPN, this.hPf, this.hPP, this.hPj, paramRect.left - getWidth(), paramRect.right), this.hPU);
      this.hPU = Math.min((float)a(this.hPM, this.hPO, this.hPh, this.hPQ, this.hPl, paramRect.top - getHeight(), paramRect.bottom), this.hPU);
      this.hPJ.setAlpha(this.alpha);
      return;
    }
  }
  
  public void reset()
  {
    this.hPK = 0L;
    this.hPM = 0.0F;
    this.hPL = 0.0F;
    this.hPO = 0.0F;
    this.hPN = 0.0F;
    this.hPh = 0.0F;
    this.hPf = 0.0F;
    this.hPl = null;
    this.hPj = null;
    this.hPQ = null;
    this.hPP = null;
    this.hPR = 0.0F;
    this.hPS = 0.0F;
    this.hPr = 0.0F;
    this.hPt = null;
    this.hPT = null;
    this.hPv = 0L;
    this.hPU = 0.0F;
    this.hPV = 0.0F;
    this.hOZ = null;
    this.hPX = 0.0F;
    this.hPW = 0.0F;
    this.hPY = 0.0F;
    this.alpha = 255;
    this.hPZ = false;
    this.terminated = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.particles.a.b
 * JD-Core Version:    0.7.0.1
 */