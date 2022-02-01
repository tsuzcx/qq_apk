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
  private ConcurrentHashMap<Object, a> csM = new ConcurrentHashMap(2);
  private long csN = 0L;
  private int csO = 0;
  private int csP = 0;
  private com.tencent.matrix.a.c.a css;
  private Handler handler = null;
  
  public final void GN()
  {
    Objects.requireNonNull(this.css);
    e.a(this);
  }
  
  public final void GO()
  {
    Objects.requireNonNull(this.css);
    e.b(this);
    this.handler.removeCallbacksAndMessages(null);
  }
  
  public final int GP()
  {
    return -2147483648;
  }
  
  public final b GR()
  {
    long l1 = this.csN;
    if (this.csO > 0)
    {
      Iterator localIterator = this.csM.values().iterator();
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
    return new b(l2, this.csO, this.csP);
  }
  
  public final void a(IBinder paramIBinder, int paramInt)
  {
    c.i("Matrix.WakeLockMonitorPlugin", "[onReleaseWakeLock] token=%s flags=%s", new Object[] { Integer.valueOf(paramIBinder.hashCode()), Integer.valueOf(paramInt) });
    paramIBinder = (a)this.csM.get(paramIBinder);
    this.handler.removeCallbacks(paramIBinder.csS);
    long l = this.csN;
    this.csN = (SystemClock.uptimeMillis() - paramIBinder.time + l);
    this.csO -= 1;
  }
  
  public final void a(IBinder paramIBinder, int paramInt, final String paramString1, final String paramString2, WorkSource paramWorkSource, String paramString3)
  {
    c.i("Matrix.WakeLockMonitorPlugin", "[onAcquireWakeLock] token=%s flags=%s tag=%s historyTag=%s packageName=%s workSource=%s stack=%s", new Object[] { Integer.valueOf(paramIBinder.hashCode()), Integer.valueOf(paramInt), paramString1, paramString3, paramString2, paramWorkSource, com.tencent.matrix.a.d.a.stackTraceToString(new Throwable().getStackTrace()) });
    paramString1 = new Runnable()
    {
      int csQ = 1;
      
      public final void run()
      {
        if (d.a(d.this).csc.cse != null)
        {
          d.a(d.this).csc.cse.e(paramString1, paramString2, this.csQ);
          this.csQ += 1;
          d.b(d.this).postDelayed(this, d.a(d.this).csc.csf);
        }
      }
    };
    this.csM.put(paramIBinder, new a(paramIBinder, SystemClock.uptimeMillis(), paramString1));
    this.handler.postDelayed(paramString1, this.css.csc.csf);
    this.csO += 1;
    this.csP += 1;
  }
  
  public final void a(com.tencent.matrix.a.c.a parama)
  {
    this.css = parama;
    this.handler = new Handler(b.HY().getLooper());
  }
  
  public final void bT(boolean paramBoolean) {}
  
  public static final class a
  {
    Runnable csS;
    long time;
    IBinder token;
    
    a(IBinder paramIBinder, long paramLong, Runnable paramRunnable)
    {
      this.token = paramIBinder;
      this.time = paramLong;
      this.csS = paramRunnable;
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
    public long csN;
    public int csO;
    public int csP;
    
    public b(long paramLong, int paramInt1, int paramInt2)
    {
      this.csN = paramLong;
      this.csO = paramInt1;
      this.csP = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.c.a.d
 * JD-Core Version:    0.7.0.1
 */