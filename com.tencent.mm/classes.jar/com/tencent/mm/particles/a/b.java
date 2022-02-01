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
  public Interpolator iIR;
  public Rect iIS;
  public float iIX;
  public float iIZ;
  private final Paint iJB = new Paint(1);
  public long iJC;
  public float iJD;
  public float iJE;
  public float iJF;
  public float iJG;
  public Long iJH;
  public Long iJI;
  public float iJJ;
  public float iJK;
  public Long iJL;
  public float iJM;
  public float iJN;
  public float iJO;
  public float iJP;
  public float iJQ;
  public boolean iJR;
  public boolean iJS;
  public float iJT;
  public float iJU;
  public float iJV;
  public float iJW;
  public Float iJb;
  public Float iJd;
  public float iJj;
  public Float iJl;
  public long iJn;
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
    paramCanvas.clipRect(this.iIS);
    this.gR.reset();
    this.iJB.setAlpha(this.alpha);
    a(paramCanvas, this.gR, this.iJB, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    paramCanvas.restore();
  }
  
  protected abstract void a(Canvas paramCanvas, Matrix paramMatrix, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public abstract int getHeight();
  
  public abstract int getWidth();
  
  public final void j(Rect paramRect)
  {
    this.iIS = paramRect;
    this.iJH = a(this.iJb, this.iJF, this.iIX);
    this.iJI = a(this.iJd, this.iJG, this.iIZ);
    this.iJL = a(this.iJl, this.iJK, this.iJj);
    if (this.iJM == 0.0F) {
      if (this.iJn < 0L) {
        break label199;
      }
    }
    label199:
    for (float f = (float)this.iJn;; f = 9.223372E+018F)
    {
      this.iJM = f;
      this.iJM = Math.min((float)a(this.iJD, this.iJF, this.iIX, this.iJH, this.iJb, paramRect.left - getWidth(), paramRect.right), this.iJM);
      this.iJM = Math.min((float)a(this.iJE, this.iJG, this.iIZ, this.iJI, this.iJd, paramRect.top - getHeight(), paramRect.bottom), this.iJM);
      this.iJB.setAlpha(this.alpha);
      return;
    }
  }
  
  public void reset()
  {
    this.iJC = 0L;
    this.iJE = 0.0F;
    this.iJD = 0.0F;
    this.iJG = 0.0F;
    this.iJF = 0.0F;
    this.iIZ = 0.0F;
    this.iIX = 0.0F;
    this.iJd = null;
    this.iJb = null;
    this.iJI = null;
    this.iJH = null;
    this.iJJ = 0.0F;
    this.iJK = 0.0F;
    this.iJj = 0.0F;
    this.iJl = null;
    this.iJL = null;
    this.iJn = 0L;
    this.iJM = 0.0F;
    this.iJN = 0.0F;
    this.iIR = null;
    this.iJP = 0.0F;
    this.iJO = 0.0F;
    this.iJQ = 0.0F;
    this.alpha = 255;
    this.iJR = false;
    this.terminated = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.particles.a.b
 * JD-Core Version:    0.7.0.1
 */