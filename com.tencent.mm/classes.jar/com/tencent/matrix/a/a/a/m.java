package com.tencent.matrix.a.a.a;

import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.os.WorkSource;
import com.tencent.matrix.a.a.d;
import com.tencent.matrix.a.b.b;
import com.tencent.matrix.a.b.g;
import com.tencent.matrix.a.b.g.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class m
  extends a
{
  long cWI;
  final Map<IBinder, c> cWJ = new ConcurrentHashMap(2);
  public final d cWK = new d();
  g.b cWL;
  
  private boolean eZ(String paramString)
  {
    return (Wb()) || (!this.cSI.cUb.cTU.contains(paramString)) || (this.cSI.cUb.cTV.contains(paramString));
  }
  
  public final void VZ()
  {
    super.VZ();
    if (this.cSI.cUb.cTQ)
    {
      this.cWL = new g.b()
      {
        public final void a(IBinder arg1, int paramAnonymousInt)
        {
          com.tencent.matrix.e.c.i("Matrix.battery.WakeLockMonitorFeature", "[onReleaseWakeLock] token=%s flags=%s", new Object[] { Integer.valueOf(???.hashCode()), Integer.valueOf(paramAnonymousInt) });
          Object localObject4 = m.this.cWJ.entrySet().iterator();
          Object localObject1;
          while (((Iterator)localObject4).hasNext())
          {
            localObject1 = (Map.Entry)((Iterator)localObject4).next();
            if (((Map.Entry)localObject1).getKey() == ???)
            {
              localObject1 = (m.c)((Map.Entry)localObject1).getValue();
              ((Iterator)localObject4).remove();
            }
          }
          for (;;)
          {
            if (localObject1 != null)
            {
              ((m.c)localObject1).b(m.this.cSI.mHandler);
              localObject4 = m.this.cWK;
              m.c.b localb = ((m.c)localObject1).cWW;
              for (;;)
              {
                synchronized (((m.d)localObject4).mLock)
                {
                  ((m.d)localObject4).mCount += 1;
                  ((m.d)localObject4).cXe += localb.Wv();
                  localObject1 = ((m.c)localObject1).cWW.tag;
                  if (m.a(m.this, (String)localObject1))
                  {
                    ??? = b.stackTraceToString(new Throwable().getStackTrace());
                    com.tencent.matrix.e.c.i("Matrix.battery.WakeLockMonitorFeature", "[onReleaseWakeLock] tag = " + (String)localObject1 + ", stack = " + ???, new Object[0]);
                    m.b(m.this, (String)localObject1);
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
          if (m.a(m.this, paramAnonymousString1))
          {
            str = b.stackTraceToString(new Throwable().getStackTrace());
            com.tencent.matrix.e.c.i("Matrix.battery.WakeLockMonitorFeature", "[onAcquireWakeLock] token=%s flags=%s tag=%s historyTag=%s packageName=%s workSource=%s stack=%s", new Object[] { String.valueOf(paramAnonymousIBinder), Integer.valueOf(paramAnonymousInt), paramAnonymousString1, paramAnonymousString3, paramAnonymousString2, paramAnonymousWorkSource, str });
            paramAnonymousWorkSource = (m.c)m.this.cWJ.get(paramAnonymousIBinder);
            if (paramAnonymousWorkSource != null) {
              paramAnonymousWorkSource.b(m.this.cSI.mHandler);
            }
            paramAnonymousString1 = new m.c(paramAnonymousIBinder, paramAnonymousString1, paramAnonymousInt, paramAnonymousString2, str);
            paramAnonymousString1.cXa = new m.c.a()
            {
              public final void b(int paramAnonymous2Int, m.c.b paramAnonymous2b)
              {
                m.a(m.this).a(paramAnonymous2Int, paramAnonymous2b);
                paramAnonymous2b = paramAnonymousString1;
                if (paramAnonymous2b.cWX >= paramAnonymous2b.cWY) {}
                for (paramAnonymous2Int = 1;; paramAnonymous2Int = 0)
                {
                  if (paramAnonymous2Int != 0)
                  {
                    paramAnonymousString1.b(m.this.cSI.mHandler);
                    paramAnonymous2b = m.this.cWJ.entrySet().iterator();
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
            paramAnonymousString2 = m.this.cSI.mHandler;
            l = m.this.cWI;
            if ((paramAnonymousString1.cWZ == null) && (!paramAnonymousString1.cWW.isFinished())) {
              break label246;
            }
            com.tencent.matrix.e.c.w("Matrix.battery.WakeLockMonitorFeature", "cant not start tracing of wakelock, target = " + paramAnonymousString1.cWW, new Object[0]);
          }
          for (;;)
          {
            m.this.cWJ.put(paramAnonymousIBinder, paramAnonymousString1);
            m.b(m.this, paramAnonymousString1.cWW.tag);
            return;
            str = "";
            break;
            label246:
            paramAnonymousString1.cWX = 0;
            paramAnonymousString1.cWZ = new m.c.1(paramAnonymousString1, paramAnonymousString2, l);
            paramAnonymousString2.postDelayed(paramAnonymousString1.cWZ, l);
          }
        }
      };
      g.a(this.cWL);
    }
  }
  
  public final void Wa()
  {
    super.Wa();
    g.b(this.cWL);
    this.cSI.mHandler.removeCallbacksAndMessages(null);
    this.cWJ.clear();
    d locald = this.cWK;
    locald.mCount = 0;
    locald.cXe = 0L;
    locald.cUX = 0;
    locald.cUY = 0;
  }
  
  public final int Wh()
  {
    return -2147483648;
  }
  
  public final void bm(long paramLong)
  {
    super.bm(paramLong);
    if (!this.cWJ.isEmpty())
    {
      Iterator localIterator = this.cWJ.values().iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if ((!localc.cWW.isFinished()) && (eZ(localc.cWW.tag))) {
          this.cSI.a(localc.cWW, paramLong);
        }
      }
    }
  }
  
  public final void f(d paramd)
  {
    super.f(paramd);
    this.cWI = paramd.cUb.cTB;
  }
  
  protected final String getTag()
  {
    return "Matrix.battery.WakeLockMonitorFeature";
  }
  
  public static abstract interface a
  {
    @Deprecated
    public abstract void a(int paramInt, m.c.b paramb);
    
    public abstract void a(m.c.b paramb, long paramLong);
  }
  
  public static final class b
    extends j.a<b>
  {
    public j.a.c.b<Long> cWP;
    public j.a.c.b<Integer> cWQ;
    public j.a.c.c<j.a.c.a<m.c.b>> cWR;
    public j.a.c.b<Integer> cWS;
    public j.a.c.b<Integer> cWT;
  }
  
  public static final class c
  {
    final IBinder cWV;
    final b cWW;
    int cWX;
    int cWY = 30;
    Runnable cWZ;
    a cXa;
    
    c(IBinder paramIBinder, String paramString1, int paramInt, String paramString2, String paramString3)
    {
      this.cWV = paramIBinder;
      this.cWW = new b(paramString1, paramInt, paramString2, paramString3);
    }
    
    public final void b(Handler paramHandler)
    {
      if (this.cWZ != null)
      {
        paramHandler.removeCallbacks(this.cWZ);
        this.cWZ = null;
      }
      this.cWW.cXd = SystemClock.uptimeMillis();
    }
    
    public final boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof c)) {
        return false;
      }
      return this.cWV.equals(paramObject);
    }
    
    public final int hashCode()
    {
      return this.cWV.hashCode();
    }
    
    public static abstract interface a
    {
      public abstract void b(int paramInt, m.c.b paramb);
    }
    
    public static final class b
    {
      public final long cUQ;
      public long cXd = 0L;
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
        this.cUQ = SystemClock.uptimeMillis();
      }
      
      public final long Wv()
      {
        if (isFinished()) {}
        for (long l = this.cXd - this.cUQ; l > 0L; l = SystemClock.uptimeMillis() - this.cUQ) {
          return l;
        }
        return 0L;
      }
      
      public final boolean isFinished()
      {
        return this.cXd >= this.cUQ;
      }
      
      public final String toString()
      {
        return "WakeLockRecord{flags=" + this.flags + ", tag='" + this.tag + '\'' + ", packageName='" + this.packageName + '\'' + ", stack='" + this.stack + '\'' + ", timeBgn=" + this.cUQ + ", timeEnd=" + this.cXd + '}';
      }
    }
  }
  
  public static final class d
  {
    public int cUX;
    public int cUY;
    long cXe;
    int mCount;
    public final byte[] mLock = new byte[0];
    
    public final m.b Ww()
    {
      m.b localb = new m.b();
      localb.cWP = j.a.c.b.c(Long.valueOf(this.cXe));
      localb.cWQ = j.a.c.b.c(Integer.valueOf(this.mCount));
      localb.cWR = j.a.c.c.Wu();
      localb.cWS = j.a.c.b.c(Integer.valueOf(this.cUX));
      localb.cWT = j.a.c.b.c(Integer.valueOf(this.cUY));
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.m
 * JD-Core Version:    0.7.0.1
 */