package com.tencent.matrix.a.b;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.matrix.a.b.a.e.a;
import com.tencent.matrix.a.b.a.f.a;
import com.tencent.matrix.a.b.a.f.c;
import com.tencent.matrix.a.b.a.g;
import com.tencent.matrix.a.b.a.i.b;
import com.tencent.matrix.a.b.a.i.d.b;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public class c
  implements Handler.Callback, com.tencent.matrix.a.b.a.c.a, e.a, f.a, i.b
{
  public static long cSk;
  private static long cSl;
  public static long cSm;
  public b cSc;
  public a cSd;
  public final b cSe;
  Callable<String> cSf = new Callable() {};
  public volatile boolean cSg = false;
  public boolean cSh = com.tencent.matrix.a.cPA.cPB;
  public boolean cSi;
  public boolean cSj;
  public Handler mHandler;
  
  public c(b paramb)
  {
    this.cSe = paramb;
    if ((paramb.cRJ instanceof a.a)) {
      ((a.a)paramb.cRJ).cRw = this;
    }
    if (paramb.cRK != null) {
      this.cSf = paramb.cRK;
    }
    this.mHandler = new Handler(com.tencent.matrix.g.b.TP().getLooper(), this);
    this.cSi = paramb.cRS;
    if (this.cSi) {
      this.cSc = new b((byte)0);
    }
    this.cSj = paramb.cRT;
    cSk = paramb.cRN;
    cSl = paramb.cRO;
    cSm = paramb.cRP;
    paramb = paramb.cRZ.iterator();
    while (paramb.hasNext()) {
      ((g)paramb.next()).d(this);
    }
  }
  
  public static int aW(Context paramContext)
  {
    try
    {
      int i = com.tencent.matrix.a.c.c.ba(paramContext);
      return i;
    }
    catch (Throwable paramContext)
    {
      com.tencent.matrix.g.c.printErrStackTrace("Matrix.battery.BatteryMonitorCore", paramContext, "#currentBatteryTemperature error", new Object[0]);
    }
    return 0;
  }
  
  public static Context getContext()
  {
    return com.tencent.matrix.b.RG().application;
  }
  
  public final boolean Sd()
  {
    try
    {
      boolean bool = this.cSg;
      return bool;
    }
    finally {}
  }
  
  public final void a(int paramInt, i.d.b paramb)
  {
    com.tencent.matrix.g.c.d("Matrix.battery.BatteryMonitorCore", "#onWakeLockTimeout, tag = " + paramb.tag + ", pkg = " + paramb.packageName + ", count = " + paramInt, new Object[0]);
    this.cSe.cRJ.a(paramInt, paramb);
  }
  
  public final void a(i.d.b paramb, long paramLong)
  {
    com.tencent.matrix.g.c.d("Matrix.battery.BatteryMonitorCore", "#onWakeLockTimeout, tag = " + paramb.tag + ", pkg = " + paramb.packageName + ", backgroundMillis = " + paramLong, new Object[0]);
    this.cSe.cRJ.a(paramb, paramLong);
  }
  
  public final void a(Thread paramThread, List<f.c> paramList)
  {
    com.tencent.matrix.g.c.d("Matrix.battery.BatteryMonitorCore", "#onTaskTrace, thread = " + paramThread.getName(), new Object[0]);
    this.cSe.cRJ.a(paramThread, paramList);
  }
  
  public final void a(boolean paramBoolean, int paramInt1, int paramInt2, ComponentName paramComponentName, long paramLong)
  {
    this.cSe.cRJ.a(paramBoolean, paramInt1, paramInt2, paramComponentName, paramLong);
  }
  
  public final <T extends g> T aa(Class<T> paramClass)
  {
    Iterator localIterator = this.cSe.cRZ.iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      if (paramClass.isAssignableFrom(localg.getClass())) {
        return localg;
      }
    }
    return null;
  }
  
  public final void ce(int paramInt1, int paramInt2)
  {
    com.tencent.matrix.g.c.d("Matrix.battery.BatteryMonitorCore", "#onParseError, tid = ".concat(String.valueOf(paramInt2)), new Object[0]);
    this.cSe.cRJ.ce(paramInt1, paramInt2);
  }
  
  public final String getScene()
  {
    try
    {
      String str = (String)this.cSf.call();
      return str;
    }
    catch (Exception localException) {}
    return "unknown";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      com.tencent.matrix.g.c.d("Matrix.battery.BatteryMonitorCore", "#onTraceBegin", new Object[0]);
      this.cSe.cRJ.Sa();
      return true;
    }
    if (paramMessage.what == 2)
    {
      if (paramMessage.arg1 == 3) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.matrix.g.c.d("Matrix.battery.BatteryMonitorCore", "#onTraceEnd", new Object[0]);
        this.cSe.cRJ.cz(bool);
        return true;
      }
    }
    return false;
  }
  
  public final class a
    implements Runnable
  {
    int cSo = 0;
    
    private a() {}
    
    public final void run()
    {
      this.cSo += 1;
      com.tencent.matrix.g.c.i("Matrix.battery.BatteryMonitorCore", "#onBackgroundLoopCheck, round = " + this.cSo, new Object[0]);
      if (!c.this.cSh) {
        try
        {
          Iterator localIterator = c.c(c.this).cRZ.iterator();
          while (localIterator.hasNext()) {
            ((g)localIterator.next()).ba(c.cSm * this.cSo);
          }
        }
        finally {}
      }
      if (!c.this.cSh) {
        c.b(c.this).postDelayed(this, c.cSm);
      }
    }
  }
  
  public final class b
    implements Runnable
  {
    public int cSp = 1;
    
    private b() {}
    
    public final void run()
    {
      int i = 2;
      if (c.a(c.this))
      {
        Message localMessage = Message.obtain(c.b(c.this));
        localMessage.what = this.cSp;
        localMessage.arg1 = 3;
        c.b(c.this).sendMessageAtFrontOfQueue(localMessage);
        if (this.cSp == 2) {
          i = 1;
        }
        this.cSp = i;
        c.b(c.this).postDelayed(this, c.cSl);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void Sa();
    
    public abstract void cz(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.a.b.c
 * JD-Core Version:    0.7.0.1
 */