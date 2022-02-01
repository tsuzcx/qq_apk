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
  private final Matrix gT = new Matrix();
  public float jIE;
  public float jIG;
  public Float jII;
  public Float jIK;
  public float jIQ;
  public Float jIS;
  public long jIU;
  public Interpolator jIy;
  public Rect jIz;
  public float jJA;
  public float jJB;
  public float jJC;
  public float jJD;
  private final Paint jJi = new Paint(1);
  public long jJj;
  public float jJk;
  public float jJl;
  public float jJm;
  public float jJn;
  public Long jJo;
  public Long jJp;
  public float jJq;
  public float jJr;
  public Long jJs;
  public float jJt;
  public float jJu;
  public float jJv;
  public float jJw;
  public float jJx;
  public boolean jJy;
  public boolean jJz;
  public VelocityTracker ol;
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
    paramCanvas.clipRect(this.jIz);
    this.gT.reset();
    this.jJi.setAlpha(this.alpha);
    a(paramCanvas, this.gT, this.jJi, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    paramCanvas.restore();
  }
  
  protected abstract void a(Canvas paramCanvas, Matrix paramMatrix, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public final float bkP()
  {
    return this.jJk;
  }
  
  public final float bkQ()
  {
    return this.jJl;
  }
  
  public abstract int getHeight();
  
  public abstract int getWidth();
  
  public final void k(Rect paramRect)
  {
    this.jIz = paramRect;
    this.jJo = a(this.jII, this.jJm, this.jIE);
    this.jJp = a(this.jIK, this.jJn, this.jIG);
    this.jJs = a(this.jIS, this.jJr, this.jIQ);
    if (this.jJt == 0.0F) {
      if (this.jIU < 0L) {
        break label199;
      }
    }
    label199:
    for (float f = (float)this.jIU;; f = 9.223372E+018F)
    {
      this.jJt = f;
      this.jJt = Math.min((float)a(this.jJk, this.jJm, this.jIE, this.jJo, this.jII, paramRect.left - getWidth(), paramRect.right), this.jJt);
      this.jJt = Math.min((float)a(this.jJl, this.jJn, this.jIG, this.jJp, this.jIK, paramRect.top - getHeight(), paramRect.bottom), this.jJt);
      this.jJi.setAlpha(this.alpha);
      return;
    }
  }
  
  public void reset()
  {
    this.jJj = 0L;
    this.jJl = 0.0F;
    this.jJk = 0.0F;
    this.jJn = 0.0F;
    this.jJm = 0.0F;
    this.jIG = 0.0F;
    this.jIE = 0.0F;
    this.jIK = null;
    this.jII = null;
    this.jJp = null;
    this.jJo = null;
    this.jJq = 0.0F;
    this.jJr = 0.0F;
    this.jIQ = 0.0F;
    this.jIS = null;
    this.jJs = null;
    this.jIU = 0L;
    this.jJt = 0.0F;
    this.jJu = 0.0F;
    this.jIy = null;
    this.jJw = 0.0F;
    this.jJv = 0.0F;
    this.jJx = 0.0F;
    this.alpha = 255;
    this.jJy = false;
    this.terminated = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.particles.a.b
 * JD-Core Version:    0.7.0.1
 */