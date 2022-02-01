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
  private final Matrix gR = new Matrix();
  public Interpolator iLK;
  public Rect iLL;
  public float iLQ;
  public float iLS;
  public Float iLU;
  public Float iLW;
  public Long iMA;
  public Long iMB;
  public float iMC;
  public float iMD;
  public Long iME;
  public float iMF;
  public float iMG;
  public float iMH;
  public float iMI;
  public float iMJ;
  public boolean iMK;
  public boolean iML;
  public float iMM;
  public float iMN;
  public float iMO;
  public float iMP;
  public float iMc;
  public Float iMe;
  public long iMg;
  private final Paint iMu = new Paint(1);
  public long iMv;
  public float iMw;
  public float iMx;
  public float iMy;
  public float iMz;
  public VelocityTracker oj;
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
    paramCanvas.clipRect(this.iLL);
    this.gR.reset();
    this.iMu.setAlpha(this.alpha);
    a(paramCanvas, this.gR, this.iMu, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    paramCanvas.restore();
  }
  
  protected abstract void a(Canvas paramCanvas, Matrix paramMatrix, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public abstract int getHeight();
  
  public abstract int getWidth();
  
  public final void j(Rect paramRect)
  {
    this.iLL = paramRect;
    this.iMA = a(this.iLU, this.iMy, this.iLQ);
    this.iMB = a(this.iLW, this.iMz, this.iLS);
    this.iME = a(this.iMe, this.iMD, this.iMc);
    if (this.iMF == 0.0F) {
      if (this.iMg < 0L) {
        break label199;
      }
    }
    label199:
    for (float f = (float)this.iMg;; f = 9.223372E+018F)
    {
      this.iMF = f;
      this.iMF = Math.min((float)a(this.iMw, this.iMy, this.iLQ, this.iMA, this.iLU, paramRect.left - getWidth(), paramRect.right), this.iMF);
      this.iMF = Math.min((float)a(this.iMx, this.iMz, this.iLS, this.iMB, this.iLW, paramRect.top - getHeight(), paramRect.bottom), this.iMF);
      this.iMu.setAlpha(this.alpha);
      return;
    }
  }
  
  public void reset()
  {
    this.iMv = 0L;
    this.iMx = 0.0F;
    this.iMw = 0.0F;
    this.iMz = 0.0F;
    this.iMy = 0.0F;
    this.iLS = 0.0F;
    this.iLQ = 0.0F;
    this.iLW = null;
    this.iLU = null;
    this.iMB = null;
    this.iMA = null;
    this.iMC = 0.0F;
    this.iMD = 0.0F;
    this.iMc = 0.0F;
    this.iMe = null;
    this.iME = null;
    this.iMg = 0L;
    this.iMF = 0.0F;
    this.iMG = 0.0F;
    this.iLK = null;
    this.iMI = 0.0F;
    this.iMH = 0.0F;
    this.iMJ = 0.0F;
    this.alpha = 255;
    this.iMK = false;
    this.terminated = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.particles.a.b
 * JD-Core Version:    0.7.0.1
 */