package com.tencent.liteav.basic.b;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class a
{
  private long A = 0L;
  private long B = 0L;
  private long C = 0L;
  private long D = 0L;
  private long E = 0L;
  private long F = 0L;
  private ReadWriteLock G = new ReentrantReadWriteLock();
  private b a = null;
  private LinkedList<com.tencent.liteav.basic.f.b> b = new LinkedList();
  private LinkedList<com.tencent.liteav.basic.f.b> c = new LinkedList();
  private long d = 0L;
  private long e = 15L;
  private volatile boolean f = false;
  private volatile float g = 1.0F;
  private long h = 0L;
  private long i = 0L;
  private long j = 0L;
  private long k = 0L;
  private long l = 0L;
  private long m = 0L;
  private long n = 0L;
  private long o = 0L;
  private boolean p = false;
  private HandlerThread q = null;
  private Handler r = null;
  private boolean s = false;
  private long t = 20L;
  private long u = 0L;
  private volatile long v = 0L;
  private volatile long w = 0L;
  private int x = 0;
  private int y = 0;
  private long z = 0L;
  
  public a()
  {
    this.q.start();
    this.G.writeLock().lock();
    this.r = new Handler(this.q.getLooper());
    this.G.writeLock().unlock();
  }
  
  private long a(long paramLong1, long paramLong2)
  {
    long l1;
    if (this.e > 0L)
    {
      l1 = 1000L / this.e;
      if (paramLong1 < l1) {
        paramLong1 = l1;
      }
    }
    for (;;)
    {
      l1 = paramLong2;
      if (paramLong1 > paramLong2) {
        l1 = paramLong1;
      }
      return l1;
    }
  }
  
  private long b(long paramLong)
  {
    long l2 = 500L;
    long l1 = paramLong;
    if (paramLong > 500L) {
      l1 = 500L;
    }
    if (l1 <= 0L)
    {
      if (this.e > 0L) {
        return 1000L / this.e;
      }
      return 0L;
    }
    if (this.a != null) {}
    for (paramLong = this.a.n();; paramLong = 0L)
    {
      if (paramLong > 0L)
      {
        paramLong = 50L;
        paramLong = a(l1, paramLong);
        if (!this.f) {
          break label120;
        }
      }
      label120:
      for (float f1 = d(paramLong);; f1 = c(paramLong))
      {
        return ((float)l1 / f1);
        paramLong = l2;
        if (!this.f) {
          break;
        }
        paramLong = 200L;
        break;
      }
    }
  }
  
  private float c(long paramLong)
  {
    long l3 = 0L;
    int i1 = 0;
    if (this.a != null) {
      i1 = this.a.o();
    }
    if (i1 > 24)
    {
      TXCLog.e("TXCVideoJitterBuffer", "videojitter pull nal with speed : 0.1");
      return 0.1F;
    }
    if (this.a != null) {}
    for (long l1 = this.a.n();; l1 = 0L)
    {
      if (l1 > 0L)
      {
        if (l1 >= this.v + paramLong)
        {
          if (l1 >= this.v + paramLong + 200L) {
            return 2.2F;
          }
          return 1.2F;
        }
        if (this.v >= l1 + paramLong)
        {
          if (this.v >= l1 + paramLong + 200L) {
            return 0.5F;
          }
          return 0.9F;
        }
      }
      else
      {
        if (this.w > this.v) {}
        for (long l2 = this.w - this.v;; l2 = 0L)
        {
          long l4 = (this.g * 1000.0F);
          l1 = l3;
          if (this.a != null) {
            l1 = this.n * this.a.o();
          }
          l3 = l4;
          if (l1 > l4) {
            l3 = l1;
          }
          if (l2 > l3 + paramLong) {}
          for (float f1 = 1.1F;; f1 = 1.0F)
          {
            if (l2 <= l3) {
              return 1.0F;
            }
            return f1;
          }
        }
      }
      return 1.0F;
    }
  }
  
  private float d(long paramLong)
  {
    long l3 = 0L;
    int i1 = 0;
    if (this.a != null) {
      i1 = this.a.o();
    }
    if (i1 > 24)
    {
      TXCLog.e("TXCVideoJitterBuffer", "videojitter pull nal with speed : 0.1");
      return 0.1F;
    }
    if (this.a != null) {}
    for (long l1 = this.a.n();; l1 = 0L)
    {
      if (l1 > 0L)
      {
        if (l1 >= this.v + paramLong)
        {
          if (l1 >= this.v + paramLong + 200L) {
            return 2.2F;
          }
          return 1.5F;
        }
        if (this.v >= l1 + paramLong)
        {
          if (this.v >= l1 + paramLong + 200L) {
            return 0.5F;
          }
          return 0.7F;
        }
      }
      else
      {
        if (this.w > this.v) {}
        for (long l2 = this.w - this.v;; l2 = 0L)
        {
          long l4 = (this.g * 1000.0F);
          l1 = l3;
          if (this.a != null) {
            l1 = this.n * this.a.o();
          }
          l3 = l4;
          if (l1 > l4) {
            l3 = l1;
          }
          if (l2 > l3 + paramLong) {}
          for (float f1 = 1.2F;; f1 = 1.0F)
          {
            if (l2 <= l3) {
              return 1.0F;
            }
            return f1;
          }
        }
      }
      return 1.0F;
    }
  }
  
  private void e(long paramLong)
  {
    if (this.j != 0L)
    {
      if (this.i < 5L) {
        break label113;
      }
      this.e = (this.h / this.i);
      if (this.e <= 200L) {
        break label96;
      }
      this.e = 200L;
      if ((this.e >= 30L) && (this.t != 5L)) {
        this.t = 5L;
      }
      this.h = 0L;
      this.i = 0L;
    }
    for (;;)
    {
      this.j = paramLong;
      return;
      label96:
      if (this.e >= 1L) {
        break;
      }
      this.e = 1L;
      break;
      label113:
      long l1 = paramLong - this.j;
      if (l1 > 0L)
      {
        long l2 = this.h;
        this.h = (1000L / l1 + l2);
        this.i += 1L;
      }
    }
  }
  
  private void f(long paramLong)
  {
    long l1;
    if (this.k != 0L)
    {
      if (paramLong <= this.k) {
        break label120;
      }
      long l2 = paramLong - this.k;
      l1 = l2;
      if (l2 > 500L) {
        l1 = 500L;
      }
    }
    for (;;)
    {
      this.l = (l1 + this.l);
      this.m += 1L;
      if (this.m >= 5L)
      {
        this.n = (this.l / this.m);
        if (this.n <= 500L) {
          break label141;
        }
        this.n = 500L;
      }
      for (;;)
      {
        this.l = 0L;
        this.m = 0L;
        this.k = paramLong;
        return;
        label120:
        if (this.e <= 0L) {
          break label162;
        }
        l1 = 1000L / this.e;
        break;
        label141:
        if (this.n < 5L) {
          this.n = 5L;
        }
      }
      label162:
      l1 = 0L;
    }
  }
  
  private void l()
  {
    this.b.clear();
    this.d = 0L;
    this.c.clear();
    this.e = 15L;
    this.h = 0L;
    this.i = 0L;
    this.j = 0L;
    this.v = 0L;
    this.w = 0L;
    this.y = 0;
    this.x = 0;
    this.f = false;
    this.g = 1.0F;
    this.k = 0L;
    this.o = 0L;
    this.l = 0L;
    this.m = 0L;
    this.C = 0L;
    this.D = 0L;
    this.E = 0L;
    this.F = 0L;
    this.p = false;
  }
  
  private void m()
  {
    this.G.readLock().lock();
    if (this.r != null) {
      this.r.postDelayed(new a.4(this), this.t);
    }
    this.G.readLock().unlock();
  }
  
  private com.tencent.liteav.basic.f.b n()
  {
    if ((this.b == null) || (this.b.isEmpty())) {
      return null;
    }
    if (this.v > this.w) {
      this.v = this.w;
    }
    long l2 = TXCTimeUtil.getTimeTick();
    int i1;
    if (this.k == 0L) {
      i1 = 1;
    }
    for (;;)
    {
      if (i1 != 0)
      {
        com.tencent.liteav.basic.f.b localb = o();
        f(localb.h);
        this.o = l2;
        return localb;
        localb = (com.tencent.liteav.basic.f.b)this.b.getFirst();
        long l1;
        if (localb.h > this.k) {
          l1 = b(localb.h - this.k);
        }
        for (;;)
        {
          if (this.o + l1 > this.u + l2) {
            break label237;
          }
          this.u = (this.u + l2 - (this.o + l1));
          if (this.u > l1) {
            this.u = l1;
          }
          i1 = 1;
          break;
          l1 = b(0L);
          TXCLog.w("TXCVideoJitterBuffer", "videojitter pull nal with invalid ts, current dts [" + localb.h + "] < last dts[ " + this.k + "]!!! decInterval is " + l1);
        }
      }
      return null;
      label237:
      i1 = 0;
    }
  }
  
  private com.tencent.liteav.basic.f.b o()
  {
    Object localObject = null;
    if (!this.b.isEmpty())
    {
      com.tencent.liteav.basic.f.b localb = (com.tencent.liteav.basic.f.b)this.b.getFirst();
      this.b.removeFirst();
      this.d = this.b.size();
      localObject = localb;
      if (this.a != null)
      {
        this.d += this.a.o();
        localObject = localb;
      }
    }
    return localObject;
  }
  
  public void a()
  {
    this.G.readLock().lock();
    if (this.r != null) {
      this.r.post(new a.2(this));
    }
    this.G.readLock().unlock();
    m();
  }
  
  public void a(float paramFloat)
  {
    this.g = paramFloat;
  }
  
  public void a(long paramLong)
  {
    this.v = paramLong;
    if (this.v > this.w) {
      this.v = this.w;
    }
  }
  
  public void a(b paramb)
  {
    this.G.readLock().lock();
    if (this.r != null) {
      this.r.post(new a.1(this, paramb));
    }
    this.G.readLock().unlock();
  }
  
  public void a(com.tencent.liteav.basic.f.b paramb)
  {
    if (paramb == null) {
      return;
    }
    if ((paramb.g > this.w) || (paramb.g + 500L < this.w)) {
      this.w = paramb.g;
    }
    if (this.v > this.w) {
      this.v = this.w;
    }
    if (paramb.b == 0) {
      this.x = this.y;
    }
    for (this.y = 1;; this.y += 1) {
      do
      {
        this.G.readLock().lock();
        if (this.r != null) {
          this.r.post(new a.5(this, paramb));
        }
        this.G.readLock().unlock();
        return;
      } while ((paramb.b != 2) && (paramb.b != 1));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void b()
  {
    this.G.writeLock().lock();
    if (this.r != null) {
      this.r.post(new a.3(this));
    }
    this.r = null;
    this.G.writeLock().unlock();
  }
  
  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  void c()
  {
    if (this.b.size() == 0) {}
    label249:
    for (;;)
    {
      return;
      this.b.getFirst();
      this.b.getLast();
      if (this.a != null) {}
      for (int i1 = this.a.o();; i1 = 0)
      {
        if ((this.b.isEmpty()) || (i1 < 24)) {
          break label249;
        }
        i1 = 0;
        int i2 = 0;
        while (i1 < this.b.size())
        {
          if (((com.tencent.liteav.basic.f.b)this.b.get(i1)).b == 0) {
            i2 = i1;
          }
          i1 += 1;
        }
        i1 = 0;
        while ((!this.b.isEmpty()) && (i1 < i2))
        {
          this.k = ((com.tencent.liteav.basic.f.b)this.b.getFirst()).h;
          while (!this.c.isEmpty())
          {
            com.tencent.liteav.basic.f.b localb = (com.tencent.liteav.basic.f.b)this.c.getFirst();
            if (localb.g > ((com.tencent.liteav.basic.f.b)this.b.getFirst()).h) {
              break;
            }
            this.a.c(localb);
            this.c.removeFirst();
          }
          this.b.removeFirst();
          i1 += 1;
        }
        if (i1 <= 0) {
          break;
        }
        TXCLog.w("TXCVideoJitterBuffer", "videojitter cache too maney ， so drop " + i1 + " frames");
        return;
      }
    }
  }
  
  public long d()
  {
    return this.w - this.v;
  }
  
  public long e()
  {
    return this.d;
  }
  
  public long f()
  {
    return this.v;
  }
  
  protected void finalize()
  {
    super.finalize();
    try
    {
      b();
      return;
    }
    catch (Exception localException) {}
  }
  
  public long g()
  {
    return this.w;
  }
  
  public int h()
  {
    return this.x;
  }
  
  public long i()
  {
    return this.C;
  }
  
  public long j()
  {
    return this.F;
  }
  
  public long k()
  {
    if (this.A != 0L) {}
    for (long l1 = this.z / this.A;; l1 = 0L)
    {
      this.A = 0L;
      this.z = 0L;
      return l1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.basic.b.a
 * JD-Core Version:    0.7.0.1
 */