package com.tencent.mm.danmaku.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.mm.danmaku.a.c;
import com.tencent.mm.danmaku.c.i;
import com.tencent.mm.danmaku.c.m;
import com.tencent.mm.danmaku.d.b;
import com.tencent.mm.danmaku.d.h;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a<DATA, CONFIG extends i>
{
  private static final AtomicInteger gOJ = new AtomicInteger();
  protected com.tencent.mm.danmaku.c.a gNt;
  protected long gOK;
  protected com.tencent.mm.danmaku.d.e gOL;
  protected final PriorityQueue<a.b> gOM;
  protected int gON;
  protected int gOO;
  protected float gOP = -1.0F;
  protected float gOQ = -1.0F;
  protected float gOR;
  protected boolean gOS;
  protected Bitmap gOT;
  protected Canvas gOU;
  protected int gOV;
  protected int gOW = -1;
  protected int gOX;
  protected boolean gOY;
  protected boolean gOZ = false;
  protected a gPa;
  public float gPb = -1.0F;
  public float gPc = -1.0F;
  public volatile boolean gPd = true;
  public volatile boolean gPe = true;
  protected CONFIG gPf;
  private HashMap<String, Object> gPg;
  public DATA mData;
  protected final int mIndex = gOJ.incrementAndGet();
  protected boolean mIsPaused;
  protected long mTime;
  protected int mVisibility;
  
  public a(com.tencent.mm.danmaku.c.a parama)
  {
    this.gNt = parama;
    this.gOM = new PriorityQueue();
    try
    {
      this.gPf = this.gNt.oZ(getType());
      reset();
      return;
    }
    catch (Exception parama)
    {
      while (!c.gNA) {}
      throw new RuntimeException("IDanmakuUIConfig should been provided by IDanmakuUIConfigCreator in DanmakuContext");
    }
  }
  
  public static boolean asF()
  {
    return com.tencent.mm.danmaku.c.a.asO().gPL;
  }
  
  public static int getScreenHeight()
  {
    return com.tencent.mm.danmaku.c.a.asO().mScreenHeight;
  }
  
  public static int getScreenWidth()
  {
    return com.tencent.mm.danmaku.c.a.asO().mScreenWidth;
  }
  
  public abstract void a(float paramFloat, long paramLong1, long paramLong2);
  
  public final long adU()
  {
    return this.mIndex;
  }
  
  public final void aj(float paramFloat)
  {
    com.tencent.mm.danmaku.d.e locale = this.gOL;
    locale.mValue = (((float)locale.mValue * paramFloat));
  }
  
  public final void ak(float paramFloat)
  {
    this.gOP = paramFloat;
  }
  
  public final void ako()
  {
    float f = getLeft();
    if ((!this.gOZ) && (f < com.tencent.mm.danmaku.c.a.asO().mScreenWidth))
    {
      com.tencent.mm.danmaku.e.e.d("BaseDanmaku", "onFirstExposure, danmaku = " + toString());
      this.gOZ = true;
    }
    if ((this.gPa != null) && (f <= 0.0F)) {
      this.gPa = null;
    }
  }
  
  public final void al(float paramFloat)
  {
    this.gOQ = paramFloat;
  }
  
  public final int asA()
  {
    return this.gOO;
  }
  
  public final float asB()
  {
    return this.gOP;
  }
  
  public final float asC()
  {
    return this.gOQ;
  }
  
  public final int asD()
  {
    return this.gOV;
  }
  
  public final void asE()
  {
    this.gOV = 3000;
  }
  
  public final float asG()
  {
    return getLeft() + com.tencent.mm.danmaku.c.a.asO().gPJ;
  }
  
  public final float asH()
  {
    return getTop() + com.tencent.mm.danmaku.c.a.asO().gPI;
  }
  
  public final boolean asI()
  {
    return (this.gOS) && (m.asY());
  }
  
  public final Bitmap asJ()
  {
    return this.gOT;
  }
  
  public final Canvas asK()
  {
    return this.gOU;
  }
  
  public final void asL()
  {
    this.gOU.setBitmap(null);
  }
  
  public final boolean asM()
  {
    return this.gOY;
  }
  
  public final long asN()
  {
    return this.gOK;
  }
  
  public final void asu()
  {
    this.gOL = new com.tencent.mm.danmaku.d.e(com.tencent.mm.danmaku.c.a.asO().atU);
  }
  
  public abstract float asv();
  
  public final long asw()
  {
    return this.gOK + this.gOL.mValue;
  }
  
  public final boolean asx()
  {
    return (this.gOP >= 0.0F) && (this.gOQ >= 0.0F) && (!this.gPd);
  }
  
  public void asy()
  {
    this.gPd = false;
  }
  
  public final int asz()
  {
    return this.gON;
  }
  
  public b b(h paramh)
  {
    return new b(-1);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (a)paramObject;
      if (this.mData != null) {
        return this.mData.equals(paramObject.mData);
      }
    } while (paramObject.mData == null);
    return false;
  }
  
  public abstract float getBottom();
  
  public final DATA getData()
  {
    return this.mData;
  }
  
  public abstract float getLeft();
  
  public abstract float getRight();
  
  public final long getTime()
  {
    return this.mTime;
  }
  
  public abstract float getTop();
  
  public abstract int getType();
  
  public int hashCode()
  {
    if (this.mData == null) {
      return 0;
    }
    return this.mData.hashCode();
  }
  
  public final boolean isPaused()
  {
    return this.mIsPaused;
  }
  
  public final boolean isShown()
  {
    return this.mVisibility == 1;
  }
  
  public final void m(Canvas paramCanvas)
  {
    this.gOU = paramCanvas;
    this.gPe = true;
  }
  
  public final boolean oW(int paramInt)
  {
    if ((this.gOY) || (this.gOV - paramInt >= 0))
    {
      this.gOV -= paramInt;
      this.gOK += paramInt;
      return true;
    }
    return false;
  }
  
  public final int oX(int paramInt)
  {
    if (this.gOX > paramInt) {
      return paramInt - 1;
    }
    return this.gOX;
  }
  
  public final int oY(int paramInt)
  {
    if (this.gOW >= paramInt) {
      return paramInt - 1;
    }
    return this.gOW;
  }
  
  public void reset()
  {
    Object localObject = com.tencent.mm.danmaku.c.a.asO();
    this.gOR = ((m)localObject).gOR;
    this.gOS = ((m)localObject).gOS;
    this.gOM.clear();
    this.gON = 0;
    this.gOO = 0;
    this.gOP = -1.0F;
    this.gOQ = -1.0F;
    this.mVisibility = 0;
    this.gOT = null;
    this.gOV = 0;
    this.gOX = 0;
    this.mIsPaused = false;
    this.gOZ = false;
    this.gPd = true;
    this.gPe = true;
    this.gPb = -1.0F;
    this.gPc = -1.0F;
    if (this.gPg != null)
    {
      localObject = this.gPg.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
      this.gPg.clear();
      this.gPg = null;
    }
    asu();
  }
  
  public final void setTime(long paramLong)
  {
    this.mTime = paramLong;
  }
  
  public final void setVisibility(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mVisibility = 1;
      return;
    }
    this.mVisibility = 0;
  }
  
  public String toString()
  {
    return "BaseDanmaku" + this.mIndex + "[left:" + getLeft() + ",top:" + getTop() + ",right:" + getRight() + ",bottom:" + getBottom() + ", time:" + this.mTime + ", mData=" + String.valueOf(this.mData) + "mType=" + getType() + "]";
  }
  
  public final void w(Bitmap paramBitmap)
  {
    this.gOT = paramBitmap;
  }
  
  public final void x(long paramLong1, long paramLong2)
  {
    if (this.mIsPaused) {
      this.gOK += paramLong1;
    }
    zb(paramLong2);
    if (!this.gOM.isEmpty())
    {
      Iterator localIterator = this.gOM.iterator();
      while (localIterator.hasNext())
      {
        a.b localb = (a.b)localIterator.next();
        localb.gPh -= paramLong1;
        if (localb.gPh <= 0L) {
          localIterator.remove();
        }
      }
    }
  }
  
  public final boolean yY(long paramLong)
  {
    if (this.gOY) {}
    while (paramLong - this.mTime < this.gOL.mValue) {
      return false;
    }
    return true;
  }
  
  public final boolean yZ(long paramLong)
  {
    return (this.gOK > 0L) && (paramLong - this.gOK >= this.gOL.mValue);
  }
  
  public final boolean za(long paramLong)
  {
    return (this.gOK > 0L) && (paramLong - this.gOK < 0L);
  }
  
  public abstract void zb(long paramLong);
  
  public abstract float[] zc(long paramLong);
  
  public abstract float[] zd(long paramLong);
  
  public final void ze(long paramLong)
  {
    this.gOK = paramLong;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.b.a
 * JD-Core Version:    0.7.0.1
 */