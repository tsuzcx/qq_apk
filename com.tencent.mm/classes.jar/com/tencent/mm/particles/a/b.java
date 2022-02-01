package com.tencent.mm.particles.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.VelocityTracker;
import android.view.animation.Interpolator;

public abstract class b
{
  private final Matrix aHZ = new Matrix();
  public int alpha;
  public VelocityTracker bvI;
  public float mAA;
  public float mAB;
  public float mAC;
  public boolean mAD;
  public boolean mAE;
  public float mAF;
  public float mAG;
  public float mAH;
  public float mAI;
  private final Paint mAn = new Paint(1);
  public long mAo;
  public float mAp;
  public float mAq;
  public float mAr;
  public float mAs;
  public Long mAt;
  public Long mAu;
  public float mAv;
  public float mAw;
  public Long mAx;
  public float mAy;
  public float mAz;
  public Interpolator mzD;
  public Rect mzE;
  public float mzJ;
  public float mzL;
  public Float mzN;
  public Float mzP;
  public float mzV;
  public Float mzX;
  public long mzZ;
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
    paramCanvas.clipRect(this.mzE);
    this.aHZ.reset();
    this.mAn.setAlpha(this.alpha);
    a(paramCanvas, this.aHZ, this.mAn, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    paramCanvas.restore();
  }
  
  protected abstract void a(Canvas paramCanvas, Matrix paramMatrix, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public final float buD()
  {
    return this.mAp;
  }
  
  public final float buE()
  {
    return this.mAq;
  }
  
  public abstract int getHeight();
  
  public abstract int getWidth();
  
  public final void p(Rect paramRect)
  {
    this.mzE = paramRect;
    this.mAt = a(this.mzN, this.mAr, this.mzJ);
    this.mAu = a(this.mzP, this.mAs, this.mzL);
    this.mAx = a(this.mzX, this.mAw, this.mzV);
    if (this.mAy == 0.0F) {
      if (this.mzZ < 0L) {
        break label199;
      }
    }
    label199:
    for (float f = (float)this.mzZ;; f = 9.223372E+018F)
    {
      this.mAy = f;
      this.mAy = Math.min((float)a(this.mAp, this.mAr, this.mzJ, this.mAt, this.mzN, paramRect.left - getWidth(), paramRect.right), this.mAy);
      this.mAy = Math.min((float)a(this.mAq, this.mAs, this.mzL, this.mAu, this.mzP, paramRect.top - getHeight(), paramRect.bottom), this.mAy);
      this.mAn.setAlpha(this.alpha);
      return;
    }
  }
  
  public void reset()
  {
    this.mAo = 0L;
    this.mAq = 0.0F;
    this.mAp = 0.0F;
    this.mAs = 0.0F;
    this.mAr = 0.0F;
    this.mzL = 0.0F;
    this.mzJ = 0.0F;
    this.mzP = null;
    this.mzN = null;
    this.mAu = null;
    this.mAt = null;
    this.mAv = 0.0F;
    this.mAw = 0.0F;
    this.mzV = 0.0F;
    this.mzX = null;
    this.mAx = null;
    this.mzZ = 0L;
    this.mAy = 0.0F;
    this.mAz = 0.0F;
    this.mzD = null;
    this.mAB = 0.0F;
    this.mAA = 0.0F;
    this.mAC = 0.0F;
    this.alpha = 255;
    this.mAD = false;
    this.terminated = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.particles.a.b
 * JD-Core Version:    0.7.0.1
 */