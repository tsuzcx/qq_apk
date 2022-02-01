package com.tencent.matrix.a.a.a;

import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.os.WorkSource;
import com.tencent.matrix.a.a.d;
import com.tencent.matrix.a.b.b;
import com.tencent.matrix.a.b.i;
import com.tencent.matrix.a.b.i.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class p
  extends a
{
  long eSP;
  final Map<IBinder, c> eSQ = new ConcurrentHashMap(2);
  public final d eSR = new d();
  i.b eSS;
  
  private boolean gx(String paramString)
  {
    return (awK()) || (!this.eNY.ePD.ePw.contains(paramString)) || (this.eNY.ePD.ePx.contains(paramString));
  }
  
  public final void awI()
  {
    super.awI();
    if (this.eNY.ePD.ePs)
    {
      this.eSS = new i.b()
      {
        public final void a(IBinder arg1, int paramAnonymousInt)
        {
          com.tencent.matrix.e.c.i("Matrix.battery.WakeLockMonitorFeature", "[onReleaseWakeLock] token=%s flags=%s", new Object[] { Integer.valueOf(???.hashCode()), Integer.valueOf(paramAnonymousInt) });
          Object localObject4 = p.this.eSQ.entrySet().iterator();
          Object localObject1;
          while (((Iterator)localObject4).hasNext())
          {
            localObject1 = (Map.Entry)((Iterator)localObject4).next();
            if (((Map.Entry)localObject1).getKey() == ???)
            {
              localObject1 = (p.c)((Map.Entry)localObject1).getValue();
              ((Iterator)localObject4).remove();
            }
          }
          for (;;)
          {
            if (localObject1 != null)
            {
              ((p.c)localObject1).d(p.this.eNY.mHandler);
              localObject4 = p.this.eSR;
              p.c.b localb = ((p.c)localObject1).eTd;
              for (;;)
              {
                synchronized (((p.d)localObject4).mLock)
                {
                  ((p.d)localObject4).mCount += 1;
                  ((p.d)localObject4).eTl += localb.axl();
                  localObject1 = ((p.c)localObject1).eTd.tag;
                  if (p.a(p.this, (String)localObject1))
                  {
                    ??? = b.stackTraceToString(new Throwable().getStackTrace());
                    com.tencent.matrix.e.c.i("Matrix.battery.WakeLockMonitorFeature", "[onReleaseWakeLock] tag = " + (String)localObject1 + ", stack = " + ???, new Object[0]);
                    p.b(p.this, (String)localObject1);
                    return;
                  }
                }
                ??? = "";
              }
            }
            com.tencent.matrix.e.c.w("Matrix.battery.WakeLockMonitorFeature", "missing tracking, token = ".concat(String.valueOf(???)), new Object[0]);
            return;
            Object localObject3 = null;
          }
        }
        
        public final void a(IBinder paramAnonymousIBinder, int paramAnonymousInt, final String paramAnonymousString1, String paramAnonymousString2, WorkSource paramAnonymousWorkSource, String paramAnonymousString3)
        {
          String str;
          long l;
          if (p.a(p.this, paramAnonymousString1))
          {
            str = b.stackTraceToString(new Throwable().getStackTrace());
            com.tencent.matrix.e.c.i("Matrix.battery.WakeLockMonitorFeature", "[onAcquireWakeLock] token=%s flags=%s tag=%s historyTag=%s packageName=%s workSource=%s stack=%s", new Object[] { String.valueOf(paramAnonymousIBinder), Integer.valueOf(paramAnonymousInt), paramAnonymousString1, paramAnonymousString3, paramAnonymousString2, paramAnonymousWorkSource, str });
            paramAnonymousWorkSource = (p.c)p.this.eSQ.get(paramAnonymousIBinder);
            if (paramAnonymousWorkSource != null) {
              paramAnonymousWorkSource.d(p.this.eNY.mHandler);
            }
            paramAnonymousString1 = new p.c(paramAnonymousIBinder, paramAnonymousString1, paramAnonymousInt, paramAnonymousString2, str);
            paramAnonymousString1.eTh = new p.c.a()
            {
              public final void b(int paramAnonymous2Int, p.c.b paramAnonymous2b)
              {
                p.a(p.this).a(paramAnonymous2Int, paramAnonymous2b);
                paramAnonymous2b = paramAnonymousString1;
                if (paramAnonymous2b.eTe >= paramAnonymous2b.eTf) {}
                for (paramAnonymous2Int = 1;; paramAnonymous2Int = 0)
                {
                  if (paramAnonymous2Int != 0)
                  {
                    paramAnonymousString1.d(p.this.eNY.mHandler);
                    paramAnonymous2b = p.this.eSQ.entrySet().iterator();
                    while (paramAnonymous2b.hasNext()) {
                      if (((Map.Entry)paramAnonymous2b.next()).getValue() == paramAnonymousString1) {
                        paramAnonymous2b.remove();
                      }
                    }
                  }
                  return;
                }
              }
            };
            paramAnonymousString2 = p.this.eNY.mHandler;
            l = p.this.eSP;
            if ((paramAnonymousString1.eTg == null) && (!paramAnonymousString1.eTd.isFinished())) {
              break label246;
            }
            com.tencent.matrix.e.c.w("Matrix.battery.WakeLockMonitorFeature", "cant not start tracing of wakelock, target = " + paramAnonymousString1.eTd, new Object[0]);
          }
          for (;;)
          {
            p.this.eSQ.put(paramAnonymousIBinder, paramAnonymousString1);
            p.b(p.this, paramAnonymousString1.eTd.tag);
            return;
            str = "";
            break;
            label246:
            paramAnonymousString1.eTe = 0;
            paramAnonymousString1.eTg = new p.c.1(paramAnonymousString1, paramAnonymousString2, l);
            paramAnonymousString2.postDelayed(paramAnonymousString1.eTg, l);
          }
        }
      };
      i.a(this.eSS);
    }
  }
  
  public final void awJ()
  {
    super.awJ();
    i.b(this.eSS);
    this.eNY.mHandler.removeCallbacksAndMessages(null);
    this.eSQ.clear();
    d locald = this.eSR;
    locald.mCount = 0;
    locald.eTl = 0L;
    locald.eQx = 0;
    locald.eQy = 0;
  }
  
  public final int awQ()
  {
    return -2147483648;
  }
  
  public final void dE(long paramLong)
  {
    super.dE(paramLong);
    if (!this.eSQ.isEmpty())
    {
      Iterator localIterator = this.eSQ.values().iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if ((!localc.eTd.isFinished()) && (gx(localc.eTd.tag))) {
          this.eNY.a(localc.eTd, paramLong);
        }
      }
    }
  }
  
  public final void g(d paramd)
  {
    super.g(paramd);
    this.eSP = paramd.ePD.ePd;
  }
  
  protected final String getTag()
  {
    return "Matrix.battery.WakeLockMonitorFeature";
  }
  
  public static abstract interface a
  {
    @Deprecated
    public abstract void a(int paramInt, p.c.b paramb);
    
    public abstract void a(p.c.b paramb, long paramLong);
  }
  
  public static class b
    extends m.a<b>
  {
    public m.a.c.b<Long> eSW;
    public m.a.c.b<Integer> eSX;
    public m.a.c.c<m.a.c.a<p.c.b>> eSY;
    public m.a.c.b<Integer> eSZ;
    public m.a.c.b<Integer> eTa;
  }
  
  public static final class c
  {
    final IBinder eTc;
    final b eTd;
    int eTe;
    int eTf = 30;
    Runnable eTg;
    a eTh;
    
    c(IBinder paramIBinder, String paramString1, int paramInt, String paramString2, String paramString3)
    {
      this.eTc = paramIBinder;
      this.eTd = new b(paramString1, paramInt, paramString2, paramString3);
    }
    
    public final void d(Handler paramHandler)
    {
      if (this.eTg != null)
      {
        paramHandler.removeCallbacks(this.eTg);
        this.eTg = null;
      }
      this.eTd.eTk = SystemClock.uptimeMillis();
    }
    
    public final boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof c)) {
        return false;
      }
      return this.eTc.equals(paramObject);
    }
    
    public final int hashCode()
    {
      return this.eTc.hashCode();
    }
    
    public static abstract interface a
    {
      public abstract void b(int paramInt, p.c.b paramb);
    }
    
    public static final class b
    {
      public final long eQq;
      public long eTk = 0L;
      public final int flags;
      public final String packageName;
      public final String stack;
      public final String tag;
      
      public b(String paramString1, int paramInt, String paramString2, String paramString3)
      {
        this.flags = paramInt;
        this.tag = paramString1;
        this.packageName = paramString2;
        this.stack = paramString3;
        this.eQq = SystemClock.uptimeMillis();
      }
      
      public final long axl()
      {
        if (isFinished()) {}
        for (long l = this.eTk - this.eQq; l > 0L; l = SystemClock.uptimeMillis() - this.eQq) {
          return l;
        }
        return 0L;
      }
      
      public final boolean isFinished()
      {
        return this.eTk >= this.eQq;
      }
      
      public final String toString()
      {
        return "WakeLockRecord{flags=" + this.flags + ", tag='" + this.tag + '\'' + ", packageName='" + this.packageName + '\'' + ", stack='" + this.stack + '\'' + ", timeBgn=" + this.eQq + ", timeEnd=" + this.eTk + '}';
      }
    }
  }
  
  public static final class d
  {
    public int eQx;
    public int eQy;
    long eTl;
    int mCount;
    public final byte[] mLock = new byte[0];
    
    public final p.b axm()
    {
      p.b localb = new p.b();
      localb.eSW = m.a.c.b.c(Long.valueOf(this.eTl));
      localb.eSX = m.a.c.b.c(Integer.valueOf(this.mCount));
      localb.eSY = m.a.c.c.axk();
      localb.eSZ = m.a.c.b.c(Integer.valueOf(this.eQx));
      localb.eTa = m.a.c.b.c(Integer.valueOf(this.eQy));
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.p
 * JD-Core Version:    0.7.0.1
 */