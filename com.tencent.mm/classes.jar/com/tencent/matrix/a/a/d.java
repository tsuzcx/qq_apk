package com.tencent.matrix.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.matrix.a;
import com.tencent.matrix.a.a.a.j.a;
import com.tencent.matrix.a.a.a.j.b.a;
import com.tencent.matrix.a.a.a.m;
import com.tencent.matrix.a.a.a.m.a.c.c;
import com.tencent.matrix.a.a.a.n.a;
import com.tencent.matrix.a.a.a.n.b;
import com.tencent.matrix.a.a.a.p.a;
import com.tencent.matrix.a.a.a.p.c.b;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public class d
  implements Handler.Callback, com.tencent.matrix.a.a.a.d.a, j.a, n.b, p.a
{
  public final c ePD;
  public b ePE;
  public a ePF;
  Callable<String> ePG = new Callable() {};
  public volatile boolean ePH = false;
  public boolean ePI = a.eLw.eLx;
  public boolean ePJ;
  public boolean ePK;
  public final long ePL;
  private final long ePM;
  public final long ePN;
  public final Handler mHandler;
  
  public d(c paramc)
  {
    this.ePD = paramc;
    if ((paramc.ePb instanceof b.a)) {
      ((b.a)paramc.ePb).a(this);
    }
    if (paramc.ePc != null) {
      this.ePG = paramc.ePc;
    }
    this.mHandler = new Handler(com.tencent.matrix.e.b.aAo().getLooper(), this);
    this.ePJ = paramc.ePm;
    if (this.ePJ) {
      this.ePE = new b((byte)0);
    }
    this.ePK = paramc.ePn;
    this.ePL = paramc.ePf;
    this.ePM = paramc.ePg;
    this.ePN = paramc.ePh;
    paramc = paramc.ePA.iterator();
    while (paramc.hasNext()) {
      ((m)paramc.next()).g(this);
    }
  }
  
  public static int bR(Context paramContext)
  {
    try
    {
      int i = com.tencent.matrix.a.b.b.bU(paramContext);
      com.tencent.matrix.e.c.i("Matrix.battery.BatteryMonitorCore", "onGetTemperature, battery = ".concat(String.valueOf(i)), new Object[0]);
      return i;
    }
    finally
    {
      com.tencent.matrix.e.c.printErrStackTrace("Matrix.battery.BatteryMonitorCore", paramContext, "#currentBatteryTemperature error", new Object[0]);
    }
    return 0;
  }
  
  public static Context getContext()
  {
    return com.tencent.matrix.c.avW().application;
  }
  
  public final void a(int paramInt, p.c.b paramb)
  {
    this.ePD.ePb.a(paramInt, paramb);
  }
  
  public final void a(m.a.c.c<? extends j.b.a> paramc)
  {
    this.ePD.ePb.a(paramc);
  }
  
  public final void a(n.a parama)
  {
    this.ePD.ePb.a(parama);
  }
  
  public final void a(p.c.b paramb, long paramLong)
  {
    this.ePD.ePb.a(paramb, paramLong);
  }
  
  public final void a(boolean paramBoolean, int paramInt1, int paramInt2, ComponentName paramComponentName, long paramLong)
  {
    this.ePD.ePb.a(paramBoolean, paramInt1, paramInt2, paramComponentName, paramLong);
  }
  
  public final <T extends m> T aj(Class<T> paramClass)
  {
    Iterator localIterator = this.ePD.ePA.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (paramClass.isAssignableFrom(localm.getClass())) {
        return localm;
      }
    }
    return null;
  }
  
  public final boolean awH()
  {
    try
    {
      boolean bool = this.ePH;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String getScene()
  {
    try
    {
      String str = (String)this.ePG.call();
      return str;
    }
    catch (Exception localException) {}
    return "unknown";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      com.tencent.matrix.e.c.d("Matrix.battery.BatteryMonitorCore", "#onTraceBegin", new Object[0]);
      this.ePD.ePb.awC();
      return true;
    }
    if (paramMessage.what == 2)
    {
      if (paramMessage.arg1 == 3) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.matrix.e.c.d("Matrix.battery.BatteryMonitorCore", "#onTraceEnd", new Object[0]);
        this.ePD.ePb.dx(bool);
        return true;
      }
    }
    return false;
  }
  
  public final class a
    implements Runnable
  {
    int ePP = 0;
    
    private a() {}
    
    public final void run()
    {
      this.ePP += 1;
      com.tencent.matrix.e.c.i("Matrix.battery.BatteryMonitorCore", "#onBackgroundLoopCheck, round = " + this.ePP, new Object[0]);
      if (!d.this.ePI) {
        try
        {
          Iterator localIterator = d.e(d.this).ePA.iterator();
          while (localIterator.hasNext()) {
            ((m)localIterator.next()).dE(d.f(d.this) * this.ePP);
          }
        }
        finally {}
      }
      if (!d.this.ePI) {
        d.c(d.this).postDelayed(this, d.f(d.this));
      }
    }
  }
  
  public final class b
    implements Runnable
  {
    public int ePQ = 1;
    
    private b() {}
    
    public final void run()
    {
      int i = 2;
      if (d.b(d.this))
      {
        Message localMessage = Message.obtain(d.c(d.this));
        localMessage.what = this.ePQ;
        localMessage.arg1 = 3;
        d.c(d.this).sendMessageAtFrontOfQueue(localMessage);
        if (this.ePQ == 2) {
          i = 1;
        }
        this.ePQ = i;
        d.c(d.this).postDelayed(this, d.d(d.this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.a.d
 * JD-Core Version:    0.7.0.1
 */