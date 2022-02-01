package com.tencent.matrix.a.b.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.os.WorkSource;
import com.tencent.matrix.a.b.b;
import com.tencent.matrix.a.c.d;
import com.tencent.matrix.a.c.d.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class i
  extends a
  implements d.b
{
  long cTF;
  final Map<IBinder, d> cTG = new ConcurrentHashMap(2);
  public final a cTH = new a();
  
  private boolean es(String paramString)
  {
    boolean bool = false;
    if ((com.tencent.matrix.a.b.c.getContext().getApplicationInfo().flags & 0x2) != 0) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (!this.cSq.cSe.cRX.contains(paramString)) || (this.cSq.cSe.cRY.contains(paramString))) {
        bool = true;
      }
      return bool;
    }
  }
  
  private void et(String paramString)
  {
    if (this.cSq.cSe.cRY.contains(paramString))
    {
      com.tencent.matrix.g.c.w("Matrix.battery.WakeLockMonitorFeature", "dump wakelocks tracing for tag '" + paramString + "':", new Object[0]);
      Iterator localIterator = this.cTG.values().iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if (locald.cTP.tag.equalsIgnoreCase(paramString)) {
          com.tencent.matrix.g.c.w("Matrix.battery.WakeLockMonitorFeature", " - " + locald.cTP, new Object[0]);
        }
      }
    }
  }
  
  public final void Se()
  {
    super.Se();
    d.a(this);
  }
  
  public final void Sf()
  {
    super.Sf();
    d.b(this);
    this.cSq.mHandler.removeCallbacksAndMessages(null);
    this.cTG.clear();
  }
  
  public final int Sg()
  {
    return -2147483648;
  }
  
  public final void a(IBinder arg1, int paramInt)
  {
    com.tencent.matrix.g.c.i("Matrix.battery.WakeLockMonitorFeature", "[onReleaseWakeLock] token=%s flags=%s", new Object[] { Integer.valueOf(???.hashCode()), Integer.valueOf(paramInt) });
    Object localObject4 = this.cTG.entrySet().iterator();
    Object localObject1;
    while (((Iterator)localObject4).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject4).next();
      if (((Map.Entry)localObject1).getKey() == ???)
      {
        localObject1 = (d)((Map.Entry)localObject1).getValue();
        ((Iterator)localObject4).remove();
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((d)localObject1).c(this.cSq.mHandler);
        localObject4 = this.cTH;
        i.d.b localb = ((d)localObject1).cTP;
        for (;;)
        {
          synchronized (((a)localObject4).mLock)
          {
            ((a)localObject4).mCount += 1;
            ((a)localObject4).cTK += localb.Sp();
            localObject1 = ((d)localObject1).cTP.tag;
            if (es((String)localObject1))
            {
              ??? = com.tencent.matrix.a.c.c.stackTraceToString(new Throwable().getStackTrace());
              com.tencent.matrix.g.c.i("Matrix.battery.WakeLockMonitorFeature", "[onReleaseWakeLock] tag = " + (String)localObject1 + ", stack = " + ???, new Object[0]);
              et((String)localObject1);
              return;
            }
          }
          ??? = "";
        }
      }
      com.tencent.matrix.g.c.w("Matrix.battery.WakeLockMonitorFeature", "missing tracking, token = ".concat(String.valueOf(???)), new Object[0]);
      return;
      Object localObject3 = null;
    }
  }
  
  public final void a(IBinder paramIBinder, int paramInt, final String paramString1, String paramString2, WorkSource paramWorkSource, String paramString3)
  {
    String str;
    long l;
    if (es(paramString1))
    {
      str = com.tencent.matrix.a.c.c.stackTraceToString(new Throwable().getStackTrace());
      com.tencent.matrix.g.c.i("Matrix.battery.WakeLockMonitorFeature", "[onAcquireWakeLock] token=%s flags=%s tag=%s historyTag=%s packageName=%s workSource=%s stack=%s", new Object[] { String.valueOf(paramIBinder), Integer.valueOf(paramInt), paramString1, paramString3, paramString2, paramWorkSource, str });
      paramWorkSource = (d)this.cTG.get(paramIBinder);
      if (paramWorkSource != null) {
        paramWorkSource.c(this.cSq.mHandler);
      }
      paramString1 = new d(paramIBinder, paramString1, paramInt, paramString2, str);
      paramString1.cTT = new i.d.a()
      {
        public final void b(int paramAnonymousInt, i.d.b paramAnonymousb)
        {
          i.a(i.this).a(paramAnonymousInt, paramAnonymousb);
          paramAnonymousb = paramString1;
          if (paramAnonymousb.cTQ >= paramAnonymousb.cTR) {}
          for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
          {
            if (paramAnonymousInt != 0)
            {
              paramString1.c(i.this.cSq.mHandler);
              paramAnonymousb = i.this.cTG.entrySet().iterator();
              while (paramAnonymousb.hasNext()) {
                if (((Map.Entry)paramAnonymousb.next()).getValue() == paramString1) {
                  paramAnonymousb.remove();
                }
              }
            }
            return;
          }
        }
      };
      paramString2 = this.cSq.mHandler;
      l = this.cTF;
      if ((paramString1.cTS == null) && (!paramString1.cTP.isFinished())) {
        break label228;
      }
      com.tencent.matrix.g.c.w("Matrix.battery.WakeLockMonitorFeature", "cant not start tracing of wakelock, target = " + paramString1.cTP, new Object[0]);
    }
    for (;;)
    {
      this.cTG.put(paramIBinder, paramString1);
      et(paramString1.cTP.tag);
      return;
      str = "";
      break;
      label228:
      paramString1.cTQ = 0;
      paramString1.cTS = new i.d.1(paramString1, paramString2, l);
      paramString2.postDelayed(paramString1.cTS, l);
    }
  }
  
  public final void ba(long paramLong)
  {
    super.ba(paramLong);
    if (!this.cTG.isEmpty())
    {
      Iterator localIterator = this.cTG.values().iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if ((!locald.cTP.isFinished()) && (es(locald.cTP.tag))) {
          this.cSq.a(locald.cTP, paramLong);
        }
      }
    }
  }
  
  public final void d(com.tencent.matrix.a.b.c paramc)
  {
    super.d(paramc);
    this.cTF = paramc.cSe.cRL;
  }
  
  public static final class a
  {
    long cTK;
    int mCount;
    final byte[] mLock = new byte[0];
    
    public final i.c So()
    {
      i.c localc = new i.c();
      localc.cTM = g.a.c.b.b(Integer.valueOf(this.mCount));
      localc.cTL = g.a.c.b.b(Long.valueOf(this.cTK));
      localc.cTN = g.a.c.c.Sn();
      return localc;
    }
  }
  
  public static abstract interface b
  {
    @Deprecated
    public abstract void a(int paramInt, i.d.b paramb);
    
    public abstract void a(i.d.b paramb, long paramLong);
  }
  
  public static final class c
    extends g.a<c>
  {
    public g.a.c.b<Long> cTL;
    public g.a.c.b<Integer> cTM;
    public g.a.c.c<g.a.c.a<i.d.b>> cTN;
  }
  
  public static final class d
  {
    final b cTP;
    int cTQ;
    int cTR = 30;
    Runnable cTS;
    a cTT;
    final IBinder token;
    
    d(IBinder paramIBinder, String paramString1, int paramInt, String paramString2, String paramString3)
    {
      this.token = paramIBinder;
      this.cTP = new b(paramString1, paramInt, paramString2, paramString3);
    }
    
    public final void c(Handler paramHandler)
    {
      if (this.cTS != null)
      {
        paramHandler.removeCallbacks(this.cTS);
        this.cTS = null;
      }
      this.cTP.cTV = SystemClock.uptimeMillis();
    }
    
    public final boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof d)) {
        return false;
      }
      return this.token.equals(paramObject);
    }
    
    public final int hashCode()
    {
      return this.token.hashCode();
    }
    
    public static abstract interface a
    {
      public abstract void b(int paramInt, i.d.b paramb);
    }
    
    public static final class b
    {
      public final long cSy;
      public long cTV = 0L;
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
        this.cSy = SystemClock.uptimeMillis();
      }
      
      public final long Sp()
      {
        if (isFinished()) {}
        for (long l = this.cTV - this.cSy; l > 0L; l = SystemClock.uptimeMillis() - this.cSy) {
          return l;
        }
        return 0L;
      }
      
      public final boolean isFinished()
      {
        return this.cTV >= this.cSy;
      }
      
      public final String toString()
      {
        return "WakeLockRecord{flags=" + this.flags + ", tag='" + this.tag + '\'' + ", packageName='" + this.packageName + '\'' + ", stack='" + this.stack + '\'' + ", timeBgn=" + this.cSy + ", timeEnd=" + this.cTV + '}';
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.a.b.a.i
 * JD-Core Version:    0.7.0.1
 */