package com.tencent.mm.danmaku.b;

import com.tencent.mm.danmaku.c.i;
import com.tencent.mm.danmaku.c.m;

public abstract class d<DATA, CONFIG extends i>
  extends a<DATA, CONFIG>
{
  private float[] gPi = null;
  public float gPj;
  public float mLeft = 0.0F;
  public float mTop = -1.0F;
  
  public d(com.tencent.mm.danmaku.c.a parama)
  {
    super(parama);
  }
  
  private float zf(long paramLong)
  {
    long l = this.gOK;
    return com.tencent.mm.danmaku.c.a.asO().mScreenWidth - (float)(paramLong - l) * this.gPj;
  }
  
  public final void a(float paramFloat, long paramLong1, long paramLong2)
  {
    if (!yY(paramLong1))
    {
      com.tencent.mm.danmaku.e.e.d("BaseDanmaku", "onLayout, Y = " + paramFloat + ", danmaku = " + toString());
      this.mLeft = zf(paramLong2);
      if (!isShown())
      {
        this.mTop = paramFloat;
        setVisibility(true);
      }
      return;
    }
    setVisibility(false);
  }
  
  public final float asv()
  {
    return -this.gPj;
  }
  
  public final void asy()
  {
    super.asy();
    this.gPj = ((int)(com.tencent.mm.danmaku.c.a.asO().mScreenWidth + this.gOP) / (float)this.gOL.mValue);
  }
  
  public final float getBottom()
  {
    return this.mTop + this.gOQ;
  }
  
  public final float getLeft()
  {
    return this.mLeft;
  }
  
  public final float getRight()
  {
    return this.mLeft + this.gOP;
  }
  
  public final float getTop()
  {
    return this.mTop;
  }
  
  public final void zb(long paramLong)
  {
    this.mLeft = zf(paramLong);
  }
  
  public final float[] zc(long paramLong)
  {
    if (!asx()) {
      return null;
    }
    float f = zf(paramLong);
    if (this.gPi == null) {
      this.gPi = new float[4];
    }
    this.gPi[0] = (f - com.tencent.mm.danmaku.c.a.asO().gPK);
    this.gPi[1] = this.mTop;
    this.gPi[2] = (f + this.gOP + this.gOR);
    this.gPi[3] = (this.mTop + this.gOQ);
    return this.gPi;
  }
  
  public final float[] zd(long paramLong)
  {
    if (!asx()) {
      return null;
    }
    float f = zf(paramLong);
    if (this.gPi == null) {
      this.gPi = new float[4];
    }
    this.gPi[0] = f;
    this.gPi[1] = this.mTop;
    this.gPi[2] = (f + this.gOP);
    this.gPi[3] = (this.mTop + this.gOQ);
    return this.gPi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.b.d
 * JD-Core Version:    0.7.0.1
 */