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
  private ConcurrentHashMap<Object, a> cvE = new ConcurrentHashMap(2);
  private long cvF = 0L;
  private int cvG = 0;
  private int cvH = 0;
  private com.tencent.matrix.a.c.a cvk;
  private Handler handler = null;
  
  public final void Hc()
  {
    Objects.requireNonNull(this.cvk);
    e.a(this);
  }
  
  public final void Hd()
  {
    Objects.requireNonNull(this.cvk);
    e.b(this);
    this.handler.removeCallbacksAndMessages(null);
  }
  
  public final int He()
  {
    return -2147483648;
  }
  
  public final b Hg()
  {
    long l1 = this.cvF;
    if (this.cvG > 0)
    {
      Iterator localIterator = this.cvE.values().iterator();
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
    return new b(l2, this.cvG, this.cvH);
  }
  
  public final void a(IBinder paramIBinder, int paramInt)
  {
    c.i("Matrix.WakeLockMonitorPlugin", "[onReleaseWakeLock] token=%s flags=%s", new Object[] { Integer.valueOf(paramIBinder.hashCode()), Integer.valueOf(paramInt) });
    paramIBinder = (a)this.cvE.get(paramIBinder);
    this.handler.removeCallbacks(paramIBinder.cvK);
    long l = this.cvF;
    this.cvF = (SystemClock.uptimeMillis() - paramIBinder.time + l);
    this.cvG -= 1;
  }
  
  public final void a(IBinder paramIBinder, int paramInt, final String paramString1, final String paramString2, WorkSource paramWorkSource, String paramString3)
  {
    c.i("Matrix.WakeLockMonitorPlugin", "[onAcquireWakeLock] token=%s flags=%s tag=%s historyTag=%s packageName=%s workSource=%s stack=%s", new Object[] { Integer.valueOf(paramIBinder.hashCode()), Integer.valueOf(paramInt), paramString1, paramString3, paramString2, paramWorkSource, com.tencent.matrix.a.d.a.stackTraceToString(new Throwable().getStackTrace()) });
    paramString1 = new Runnable()
    {
      int cvI = 1;
      
      public final void run()
      {
        if (d.a(d.this).cuU.cuW != null)
        {
          d.a(d.this).cuU.cuW.e(paramString1, paramString2, this.cvI);
          this.cvI += 1;
          d.b(d.this).postDelayed(this, d.a(d.this).cuU.cuX);
        }
      }
    };
    this.cvE.put(paramIBinder, new a(paramIBinder, SystemClock.uptimeMillis(), paramString1));
    this.handler.postDelayed(paramString1, this.cvk.cuU.cuX);
    this.cvG += 1;
    this.cvH += 1;
  }
  
  public final void a(com.tencent.matrix.a.c.a parama)
  {
    this.cvk = parama;
    this.handler = new Handler(b.Ip().getLooper());
  }
  
  public final void bS(boolean paramBoolean) {}
  
  public static final class a
  {
    Runnable cvK;
    long time;
    IBinder token;
    
    a(IBinder paramIBinder, long paramLong, Runnable paramRunnable)
    {
      this.token = paramIBinder;
      this.time = paramLong;
      this.cvK = paramRunnable;
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
    public long cvF;
    public int cvG;
    public int cvH;
    
    public b(long paramLong, int paramInt1, int paramInt2)
    {
      this.cvF = paramLong;
      this.cvG = paramInt1;
      this.cvH = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.c.a.d
 * JD-Core Version:    0.7.0.1
 */