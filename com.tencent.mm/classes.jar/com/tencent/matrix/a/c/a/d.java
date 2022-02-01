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
  private ConcurrentHashMap<Object, a> cDI = new ConcurrentHashMap(2);
  private long cDJ = 0L;
  private int cDK = 0;
  private int cDL = 0;
  private com.tencent.matrix.a.c.a cDo;
  private Handler handler = null;
  
  public final void Ii()
  {
    Objects.requireNonNull(this.cDo);
    e.a(this);
  }
  
  public final void Ij()
  {
    Objects.requireNonNull(this.cDo);
    e.b(this);
    this.handler.removeCallbacksAndMessages(null);
  }
  
  public final int Ik()
  {
    return -2147483648;
  }
  
  public final b Im()
  {
    long l1 = this.cDJ;
    if (this.cDK > 0)
    {
      Iterator localIterator = this.cDI.values().iterator();
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
    return new b(l2, this.cDK, this.cDL);
  }
  
  public final void a(IBinder paramIBinder, int paramInt)
  {
    c.i("Matrix.WakeLockMonitorPlugin", "[onReleaseWakeLock] token=%s flags=%s", new Object[] { Integer.valueOf(paramIBinder.hashCode()), Integer.valueOf(paramInt) });
    paramIBinder = (a)this.cDI.get(paramIBinder);
    this.handler.removeCallbacks(paramIBinder.cDO);
    long l = this.cDJ;
    this.cDJ = (SystemClock.uptimeMillis() - paramIBinder.time + l);
    this.cDK -= 1;
  }
  
  public final void a(IBinder paramIBinder, int paramInt, final String paramString1, final String paramString2, WorkSource paramWorkSource, String paramString3)
  {
    c.i("Matrix.WakeLockMonitorPlugin", "[onAcquireWakeLock] token=%s flags=%s tag=%s historyTag=%s packageName=%s workSource=%s stack=%s", new Object[] { Integer.valueOf(paramIBinder.hashCode()), Integer.valueOf(paramInt), paramString1, paramString3, paramString2, paramWorkSource, com.tencent.matrix.a.d.a.stackTraceToString(new Throwable().getStackTrace()) });
    paramString1 = new Runnable()
    {
      int cDM = 1;
      
      public final void run()
      {
        if (d.a(d.this).cCY.cDa != null)
        {
          d.a(d.this).cCY.cDa.e(paramString1, paramString2, this.cDM);
          this.cDM += 1;
          d.b(d.this).postDelayed(this, d.a(d.this).cCY.cDb);
        }
      }
    };
    this.cDI.put(paramIBinder, new a(paramIBinder, SystemClock.uptimeMillis(), paramString1));
    this.handler.postDelayed(paramString1, this.cDo.cCY.cDb);
    this.cDK += 1;
    this.cDL += 1;
  }
  
  public final void a(com.tencent.matrix.a.c.a parama)
  {
    this.cDo = parama;
    this.handler = new Handler(b.Jt().getLooper());
  }
  
  public final void bV(boolean paramBoolean) {}
  
  public static final class a
  {
    Runnable cDO;
    long time;
    IBinder token;
    
    a(IBinder paramIBinder, long paramLong, Runnable paramRunnable)
    {
      this.token = paramIBinder;
      this.time = paramLong;
      this.cDO = paramRunnable;
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
    public long cDJ;
    public int cDK;
    public int cDL;
    
    public b(long paramLong, int paramInt1, int paramInt2)
    {
      this.cDJ = paramLong;
      this.cDK = paramInt1;
      this.cDL = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.c.a.d
 * JD-Core Version:    0.7.0.1
 */