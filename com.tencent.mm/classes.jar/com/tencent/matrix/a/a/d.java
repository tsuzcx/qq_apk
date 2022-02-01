package com.tencent.matrix.a.a;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import com.tencent.matrix.a;
import com.tencent.matrix.a.a.a.g.a;
import com.tencent.matrix.a.a.a.g.b.a;
import com.tencent.matrix.a.a.a.j;
import com.tencent.matrix.a.a.a.j.a;
import com.tencent.matrix.a.a.a.j.a.a;
import com.tencent.matrix.a.a.a.j.a.c.b;
import com.tencent.matrix.a.a.a.j.a.c.c;
import com.tencent.matrix.a.a.a.k.a;
import com.tencent.matrix.a.a.a.k.b;
import com.tencent.matrix.a.a.a.m.a;
import com.tencent.matrix.a.a.a.m.c.b;
import com.tencent.matrix.a.b.h;
import com.tencent.matrix.a.b.h.c;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public class d
  implements Handler.Callback, com.tencent.matrix.a.a.a.d.a, g.a, k.b, m.a
{
  public final c cUb;
  public c cUc;
  public a cUd;
  public com.tencent.matrix.a.a.a.b.a cUe;
  Callable<String> cUf = new Callable() {};
  public volatile boolean cUg = false;
  public boolean cUh = a.cQs.cQt;
  public boolean cUi;
  public boolean cUj;
  public final long cUk;
  private final long cUl;
  public final long cUm;
  public int cUn = -1;
  public final Handler mHandler;
  
  @SuppressLint({"VisibleForTests"})
  public d(c paramc)
  {
    this.cUb = paramc;
    if ((paramc.cTz instanceof b.a)) {
      ((b.a)paramc.cTz).cTa = this;
    }
    if (paramc.cTA != null) {
      this.cUf = paramc.cTA;
    }
    this.mHandler = new Handler(com.tencent.matrix.e.b.Yt().getLooper(), this);
    this.cUi = paramc.cTK;
    if (this.cUi) {
      this.cUc = new c((byte)0);
    }
    this.cUj = paramc.cTL;
    this.cUk = paramc.cTD;
    this.cUl = paramc.cTE;
    this.cUm = paramc.cTF;
    paramc = paramc.cTY.iterator();
    while (paramc.hasNext()) {
      ((j)paramc.next()).f(this);
    }
  }
  
  public static int bh(Context paramContext)
  {
    try
    {
      int i = com.tencent.matrix.a.b.b.bk(paramContext);
      return i;
    }
    catch (Throwable paramContext)
    {
      com.tencent.matrix.e.c.printErrStackTrace("Matrix.battery.BatteryMonitorCore", paramContext, "#currentBatteryTemperature error", new Object[0]);
    }
    return 0;
  }
  
  public static Context getContext()
  {
    return com.tencent.matrix.b.Vu().application;
  }
  
  public final c VX()
  {
    return this.cUb;
  }
  
  public final boolean VY()
  {
    try
    {
      boolean bool = this.cUg;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final <T extends j> T Z(Class<T> paramClass)
  {
    Iterator localIterator = this.cUb.cTY.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if (paramClass.isAssignableFrom(localj.getClass())) {
        return localj;
      }
    }
    return null;
  }
  
  public final void a(int paramInt, m.c.b paramb)
  {
    this.cUb.cTz.a(paramInt, paramb);
  }
  
  public final void a(j.a.c.c<? extends g.b.a> paramc)
  {
    this.cUb.cTz.a(paramc);
  }
  
  public final void a(k.a parama)
  {
    this.cUb.cTz.a(parama);
  }
  
  public final void a(m.c.b paramb, long paramLong)
  {
    this.cUb.cTz.a(paramb, paramLong);
  }
  
  public final void a(boolean paramBoolean, int paramInt1, int paramInt2, ComponentName paramComponentName, long paramLong)
  {
    this.cUb.cTz.a(paramBoolean, paramInt1, paramInt2, paramComponentName, paramLong);
  }
  
  public final String getScene()
  {
    try
    {
      String str = (String)this.cUf.call();
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
      this.cUb.cTz.VT();
      return true;
    }
    if (paramMessage.what == 2)
    {
      if (paramMessage.arg1 == 3) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.matrix.e.c.d("Matrix.battery.BatteryMonitorCore", "#onTraceEnd", new Object[0]);
        this.cUb.cTz.cQ(bool);
        return true;
      }
    }
    return false;
  }
  
  public final com.tencent.matrix.a.a.a.b.a jq(int paramInt)
  {
    com.tencent.matrix.a.a.a.b.a locala = new com.tencent.matrix.a.a.a.b.a();
    locala.tid = paramInt;
    locala.cUD = com.tencent.matrix.a.b.b.k(com.tencent.matrix.b.Vu().application, this.cUh);
    locala.cUE = com.tencent.matrix.a.b.b.bl(com.tencent.matrix.b.Vu().application);
    for (;;)
    {
      try
      {
        localObject = this.cUb.cTA;
        if (localObject != null) {
          continue;
        }
        localObject = "";
        locala.scene = ((String)localObject);
      }
      catch (Exception localException)
      {
        Object localObject;
        locala.scene = "";
        continue;
        locala.cUC = j.a.c.b.c(Long.valueOf(localException.WF()));
        locala.name = localException.cXB;
      }
      localObject = h.cy(Process.myPid(), paramInt);
      if (localObject != null) {
        continue;
      }
      return null;
      localObject = (String)((Callable)localObject).call();
    }
    return locala;
  }
  
  public final class a
    implements Runnable
  {
    int cUp = 0;
    
    private a() {}
    
    public final void run()
    {
      this.cUp += 1;
      com.tencent.matrix.e.c.i("Matrix.battery.BatteryMonitorCore", "#onBackgroundLoopCheck, round = " + this.cUp, new Object[0]);
      if (!d.this.cUh) {
        try
        {
          Iterator localIterator = d.d(d.this).cTY.iterator();
          while (localIterator.hasNext()) {
            ((j)localIterator.next()).bm(d.e(d.this) * this.cUp);
          }
        }
        finally {}
      }
      if (!d.this.cUh) {
        d.b(d.this).postDelayed(this, d.e(d.this));
      }
    }
  }
  
  public static abstract interface b<T extends j.a<T>>
  {
    public abstract void a(T paramT);
  }
  
  public final class c
    implements Runnable
  {
    public int cUq = 1;
    
    private c() {}
    
    public final void run()
    {
      int i = 2;
      if (d.a(d.this))
      {
        Message localMessage = Message.obtain(d.b(d.this));
        localMessage.what = this.cUq;
        localMessage.arg1 = 3;
        d.b(d.this).sendMessageAtFrontOfQueue(localMessage);
        if (this.cUq == 2) {
          i = 1;
        }
        this.cUq = i;
        d.b(d.this).postDelayed(this, d.c(d.this));
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void VT();
    
    public abstract void a(j.a.a<com.tencent.matrix.a.a.a.b.a> parama);
    
    public abstract void cQ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.a.d
 * JD-Core Version:    0.7.0.1
 */