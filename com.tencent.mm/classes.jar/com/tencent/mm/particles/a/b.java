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
  private final Matrix asO = new Matrix();
  private final Paint ghM = new Paint(1);
  public long ghN;
  public float ghO;
  public float ghP;
  public float ghQ;
  public float ghR;
  public Long ghS;
  public Long ghT;
  public float ghU;
  public float ghV;
  public Long ghW;
  public float ghX;
  public float ghY;
  public float ghZ;
  public Interpolator ghc;
  public Rect ghd;
  public float ghi;
  public float ghk;
  public Float ghm;
  public Float gho;
  public float ghu;
  public Float ghw;
  public long ghy;
  public float gia;
  public float gib;
  public boolean gic;
  public boolean gid;
  public VelocityTracker gie;
  public float gif;
  public float gig;
  public float gih;
  public float gii;
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
    paramCanvas.clipRect(this.ghd);
    this.asO.reset();
    this.ghM.setAlpha(this.alpha);
    a(paramCanvas, this.asO, this.ghM, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    paramCanvas.restore();
  }
  
  protected abstract void a(Canvas paramCanvas, Matrix paramMatrix, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public abstract int getHeight();
  
  public abstract int getWidth();
  
  public final void j(Rect paramRect)
  {
    this.ghd = paramRect;
    this.ghS = a(this.ghm, this.ghQ, this.ghi);
    this.ghT = a(this.gho, this.ghR, this.ghk);
    this.ghW = a(this.ghw, this.ghV, this.ghu);
    if (this.ghX == 0.0F) {
      if (this.ghy < 0L) {
        break label199;
      }
    }
    label199:
    for (float f = (float)this.ghy;; f = 9.223372E+018F)
    {
      this.ghX = f;
      this.ghX = Math.min((float)a(this.ghO, this.ghQ, this.ghi, this.ghS, this.ghm, paramRect.left - getWidth(), paramRect.right), this.ghX);
      this.ghX = Math.min((float)a(this.ghP, this.ghR, this.ghk, this.ghT, this.gho, paramRect.top - getHeight(), paramRect.bottom), this.ghX);
      this.ghM.setAlpha(this.alpha);
      return;
    }
  }
  
  public void reset()
  {
    this.ghN = 0L;
    this.ghP = 0.0F;
    this.ghO = 0.0F;
    this.ghR = 0.0F;
    this.ghQ = 0.0F;
    this.ghk = 0.0F;
    this.ghi = 0.0F;
    this.gho = null;
    this.ghm = null;
    this.ghT = null;
    this.ghS = null;
    this.ghU = 0.0F;
    this.ghV = 0.0F;
    this.ghu = 0.0F;
    this.ghw = null;
    this.ghW = null;
    this.ghy = 0L;
    this.ghX = 0.0F;
    this.ghY = 0.0F;
    this.ghc = null;
    this.gia = 0.0F;
    this.ghZ = 0.0F;
    this.gib = 0.0F;
    this.alpha = 255;
    this.gic = false;
    this.terminated = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.particles.a.b
 * JD-Core Version:    0.7.0.1
 */