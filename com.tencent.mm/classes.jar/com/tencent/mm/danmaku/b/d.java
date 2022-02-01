package com.tencent.mm.danmaku.b;

import com.tencent.mm.danmaku.c.i;
import com.tencent.mm.danmaku.c.m;

public abstract class d<DATA, CONFIG extends i>
  extends a<DATA, CONFIG>
{
  private float[] jzB = null;
  public float jzC;
  public float mLeft = 0.0F;
  public float mTop = -1.0F;
  
  public d(com.tencent.mm.danmaku.c.a parama)
  {
    super(parama);
  }
  
  private float Fj(long paramLong)
  {
    long l = this.jze;
    return com.tencent.mm.danmaku.c.a.azC().mScreenWidth - (float)(paramLong - l) * this.jzC;
  }
  
  public final void Ff(long paramLong)
  {
    this.mLeft = Fj(paramLong);
  }
  
  public final float[] Fg(long paramLong)
  {
    if (!azl()) {
      return null;
    }
    float f = Fj(paramLong);
    if (this.jzB == null) {
      this.jzB = new float[4];
    }
    this.jzB[0] = (f - com.tencent.mm.danmaku.c.a.azC().jAd);
    this.jzB[1] = this.mTop;
    this.jzB[2] = (f + this.jzj + this.jzl);
    this.jzB[3] = (this.mTop + this.jzk);
    return this.jzB;
  }
  
  public final float[] Fh(long paramLong)
  {
    if (!azl()) {
      return null;
    }
    float f = Fj(paramLong);
    if (this.jzB == null) {
      this.jzB = new float[4];
    }
    this.jzB[0] = f;
    this.jzB[1] = this.mTop;
    this.jzB[2] = (f + this.jzj);
    this.jzB[3] = (this.mTop + this.jzk);
    return this.jzB;
  }
  
  public final void a(float paramFloat, long paramLong1, long paramLong2)
  {
    if (!Fc(paramLong1))
    {
      com.tencent.mm.danmaku.e.e.d("BaseDanmaku", "onLayout, Y = " + paramFloat + ", danmaku = " + toString());
      this.mLeft = Fj(paramLong2);
      if (!isShown())
      {
        this.mTop = paramFloat;
        setVisibility(true);
      }
      return;
    }
    setVisibility(false);
  }
  
  public final float azj()
  {
    return -this.jzC;
  }
  
  public final void azm()
  {
    super.azm();
    this.jzC = ((int)(com.tencent.mm.danmaku.c.a.azC().mScreenWidth + this.jzj) / (float)this.jzf.mValue);
  }
  
  public final float getBottom()
  {
    return this.mTop + this.jzk;
  }
  
  public final float getLeft()
  {
    return this.mLeft;
  }
  
  public final float getRight()
  {
    return this.mLeft + this.jzj;
  }
  
  public final float getTop()
  {
    return this.mTop;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.b.d
 * JD-Core Version:    0.7.0.1
 */