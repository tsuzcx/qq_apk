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
  private static final AtomicInteger jzd = new AtomicInteger();
  protected int CX;
  protected com.tencent.mm.danmaku.c.a jxO;
  private HashMap<String, Object> jzA;
  protected long jze;
  protected com.tencent.mm.danmaku.d.e jzf;
  protected final PriorityQueue<Object> jzg;
  protected int jzh;
  protected int jzi;
  protected float jzj = -1.0F;
  protected float jzk = -1.0F;
  protected float jzl;
  protected boolean jzm;
  protected Bitmap jzn;
  protected Canvas jzo;
  protected int jzp;
  protected int jzq = -1;
  protected int jzr;
  protected boolean jzs;
  protected boolean jzt = false;
  protected a jzu;
  public float jzv = -1.0F;
  public float jzw = -1.0F;
  public volatile boolean jzx = true;
  public volatile boolean jzy = true;
  protected CONFIG jzz;
  public DATA mData;
  protected final int mIndex = jzd.incrementAndGet();
  protected boolean mIsPaused;
  protected long mTime;
  
  public a(com.tencent.mm.danmaku.c.a parama)
  {
    this.jxO = parama;
    this.jzg = new PriorityQueue();
    try
    {
      this.jzz = this.jxO.ru(getType());
      reset();
      return;
    }
    catch (Exception parama)
    {
      while (!c.jxV) {}
      throw new RuntimeException("IDanmakuUIConfig should been provided by IDanmakuUIConfigCreator in DanmakuContext");
    }
  }
  
  public static boolean azt()
  {
    return com.tencent.mm.danmaku.c.a.azC().jAe;
  }
  
  public static int getScreenHeight()
  {
    return com.tencent.mm.danmaku.c.a.azC().mScreenHeight;
  }
  
  public static int getScreenWidth()
  {
    return com.tencent.mm.danmaku.c.a.azC().mScreenWidth;
  }
  
  public final void ER(long paramLong)
  {
    this.mTime = paramLong;
  }
  
  public final boolean Fc(long paramLong)
  {
    if (this.jzs) {}
    while (paramLong - this.mTime < this.jzf.mValue) {
      return false;
    }
    return true;
  }
  
  public final boolean Fd(long paramLong)
  {
    return (this.jze > 0L) && (paramLong - this.jze >= this.jzf.mValue);
  }
  
  public final boolean Fe(long paramLong)
  {
    return (this.jze > 0L) && (paramLong - this.jze < 0L);
  }
  
  public abstract void Ff(long paramLong);
  
  public abstract float[] Fg(long paramLong);
  
  public abstract float[] Fh(long paramLong);
  
  public final void Fi(long paramLong)
  {
    this.jze = paramLong;
  }
  
  public abstract void a(float paramFloat, long paramLong1, long paramLong2);
  
  public final void ai(float paramFloat)
  {
    com.tencent.mm.danmaku.d.e locale = this.jzf;
    locale.mValue = (((float)locale.mValue * paramFloat));
  }
  
  public final long aiJ()
  {
    return this.mIndex;
  }
  
  public final void aj(float paramFloat)
  {
    this.jzj = paramFloat;
  }
  
  public final void ak(float paramFloat)
  {
    this.jzk = paramFloat;
  }
  
  public final void aqk()
  {
    float f = getLeft();
    if ((!this.jzt) && (f < com.tencent.mm.danmaku.c.a.azC().mScreenWidth))
    {
      com.tencent.mm.danmaku.e.e.d("BaseDanmaku", "onFirstExposure, danmaku = " + toString());
      this.jzt = true;
    }
    if ((this.jzu != null) && (f <= 0.0F)) {
      this.jzu = null;
    }
  }
  
  public final boolean azA()
  {
    return this.jzs;
  }
  
  public final long azB()
  {
    return this.jze;
  }
  
  public final void azi()
  {
    this.jzf = new com.tencent.mm.danmaku.d.e(com.tencent.mm.danmaku.c.a.azC().alM);
  }
  
  public abstract float azj();
  
  public final long azk()
  {
    return this.jze + this.jzf.mValue;
  }
  
  public final boolean azl()
  {
    return (this.jzj >= 0.0F) && (this.jzk >= 0.0F) && (!this.jzx);
  }
  
  public void azm()
  {
    this.jzx = false;
  }
  
  public final int azn()
  {
    return this.jzh;
  }
  
  public final int azo()
  {
    return this.jzi;
  }
  
  public final float azp()
  {
    return this.jzj;
  }
  
  public final float azq()
  {
    return this.jzk;
  }
  
  public final int azr()
  {
    return this.jzp;
  }
  
  public final void azs()
  {
    this.jzp = 3000;
  }
  
  public final float azu()
  {
    return getLeft() + com.tencent.mm.danmaku.c.a.azC().jAc;
  }
  
  public final float azv()
  {
    return getTop() + com.tencent.mm.danmaku.c.a.azC().jAb;
  }
  
  public final boolean azw()
  {
    return (this.jzm) && (m.azM());
  }
  
  public final Bitmap azx()
  {
    return this.jzn;
  }
  
  public final Canvas azy()
  {
    return this.jzo;
  }
  
  public final void azz()
  {
    this.jzo.setBitmap(null);
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
    return this.CX == 1;
  }
  
  public final void n(Canvas paramCanvas)
  {
    this.jzo = paramCanvas;
    this.jzy = true;
  }
  
  public final void r(Bitmap paramBitmap)
  {
    this.jzn = paramBitmap;
  }
  
  public void reset()
  {
    Object localObject = com.tencent.mm.danmaku.c.a.azC();
    this.jzl = ((m)localObject).jzl;
    this.jzm = ((m)localObject).jzm;
    this.jzg.clear();
    this.jzh = 0;
    this.jzi = 0;
    this.jzj = -1.0F;
    this.jzk = -1.0F;
    this.CX = 0;
    this.jzn = null;
    this.jzp = 0;
    this.jzr = 0;
    this.mIsPaused = false;
    this.jzt = false;
    this.jzx = true;
    this.jzy = true;
    this.jzv = -1.0F;
    this.jzw = -1.0F;
    if (this.jzA != null)
    {
      localObject = this.jzA.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
      this.jzA.clear();
      this.jzA = null;
    }
    azi();
  }
  
  public final boolean rr(int paramInt)
  {
    if ((this.jzs) || (this.jzp - paramInt >= 0))
    {
      this.jzp -= paramInt;
      this.jze += paramInt;
      return true;
    }
    return false;
  }
  
  public final int rs(int paramInt)
  {
    if (this.jzr > paramInt) {
      return paramInt - 1;
    }
    return this.jzr;
  }
  
  public final int rt(int paramInt)
  {
    if (this.jzq >= paramInt) {
      return paramInt - 1;
    }
    return this.jzq;
  }
  
  public final void setVisibility(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.CX = 1;
      return;
    }
    this.CX = 0;
  }
  
  public String toString()
  {
    return "BaseDanmaku" + this.mIndex + "[left:" + getLeft() + ",top:" + getTop() + ",right:" + getRight() + ",bottom:" + getBottom() + ", time:" + this.mTime + ", mData=" + String.valueOf(this.mData) + "mType=" + getType() + "]";
  }
  
  public final void x(long paramLong1, long paramLong2)
  {
    if (this.mIsPaused) {
      this.jze += paramLong1;
    }
    Ff(paramLong2);
    if (!this.jzg.isEmpty())
    {
      Iterator localIterator = this.jzg.iterator();
      if (localIterator.hasNext())
      {
        localIterator.next();
        throw null;
      }
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.b.a
 * JD-Core Version:    0.7.0.1
 */