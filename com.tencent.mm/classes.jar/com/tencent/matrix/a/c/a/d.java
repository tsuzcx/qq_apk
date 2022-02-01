package com.tencent.matrix.a.c.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.SystemClock;
import android.os.WorkSource;
import com.tencent.matrix.a.b.e;
import com.tencent.matrix.a.b.e.b;
import com.tencent.matrix.a.c.a.b;
import com.tencent.matrix.a.c.a.c;
import com.tencent.matrix.g.b;
import com.tencent.matrix.g.c;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class d
  implements e.b, a
{
  private com.tencent.matrix.a.c.a cDV;
  private ConcurrentHashMap<Object, a> cEp = new ConcurrentHashMap(2);
  private long cEq = 0L;
  private int cEr = 0;
  private int cEs = 0;
  private Handler handler = null;
  
  public final void Iq()
  {
    Objects.requireNonNull(this.cDV);
    e.a(this);
  }
  
  public final void Ir()
  {
    Objects.requireNonNull(this.cDV);
    e.b(this);
    this.handler.removeCallbacksAndMessages(null);
  }
  
  public final int Is()
  {
    return -2147483648;
  }
  
  public final b Iu()
  {
    long l1 = this.cEq;
    if (this.cEr > 0)
    {
      Iterator localIterator = this.cEp.values().iterator();
      for (;;)
      {
        l2 = l1;
        if (!localIterator.hasNext()) {
          break;
        }
        a locala = (a)localIterator.next();
        l1 = SystemClock.uptimeMillis() - locala.time + l1;
      }
    }
    long l2 = l1;
    return new b(l2, this.cEr, this.cEs);
  }
  
  public final void a(IBinder paramIBinder, int paramInt)
  {
    c.i("Matrix.WakeLockMonitorPlugin", "[onReleaseWakeLock] token=%s flags=%s", new Object[] { Integer.valueOf(paramIBinder.hashCode()), Integer.valueOf(paramInt) });
    paramIBinder = (a)this.cEp.get(paramIBinder);
    this.handler.removeCallbacks(paramIBinder.cEv);
    long l = this.cEq;
    this.cEq = (SystemClock.uptimeMillis() - paramIBinder.time + l);
    this.cEr -= 1;
  }
  
  public final void a(IBinder paramIBinder, int paramInt, final String paramString1, final String paramString2, WorkSource paramWorkSource, String paramString3)
  {
    c.i("Matrix.WakeLockMonitorPlugin", "[onAcquireWakeLock] token=%s flags=%s tag=%s historyTag=%s packageName=%s workSource=%s stack=%s", new Object[] { Integer.valueOf(paramIBinder.hashCode()), Integer.valueOf(paramInt), paramString1, paramString3, paramString2, paramWorkSource, com.tencent.matrix.a.d.a.stackTraceToString(new Throwable().getStackTrace()) });
    paramString1 = new Runnable()
    {
      int cEt = 1;
      
      public final void run()
      {
        if (d.a(d.this).cDF.cDH != null)
        {
          d.a(d.this).cDF.cDH.e(paramString1, paramString2, this.cEt);
          this.cEt += 1;
          d.b(d.this).postDelayed(this, d.a(d.this).cDF.cDI);
        }
      }
    };
    this.cEp.put(paramIBinder, new a(paramIBinder, SystemClock.uptimeMillis(), paramString1));
    this.handler.postDelayed(paramString1, this.cDV.cDF.cDI);
    this.cEr += 1;
    this.cEs += 1;
  }
  
  public final void a(com.tencent.matrix.a.c.a parama)
  {
    this.cDV = parama;
    this.handler = new Handler(b.JB().getLooper());
  }
  
  public final void bV(boolean paramBoolean) {}
  
  public static final class a
  {
    Runnable cEv;
    long time;
    IBinder token;
    
    a(IBinder paramIBinder, long paramLong, Runnable paramRunnable)
    {
      this.token = paramIBinder;
      this.time = paramLong;
      this.cEv = paramRunnable;
    }
    
    public final boolean equals(Object paramObject)
    {
      return this.token.equals(paramObject);
    }
    
    public final int hashCode()
    {
      return this.token.hashCode();
    }
  }
  
  public static final class b
  {
    public long cEq;
    public int cEr;
    public int cEs;
    
    public b(long paramLong, int paramInt1, int paramInt2)
    {
      this.cEq = paramLong;
      this.cEr = paramInt1;
      this.cEs = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.c.a.d
 * JD-Core Version:    0.7.0.1
 */