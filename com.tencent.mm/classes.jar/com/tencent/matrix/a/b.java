package com.tencent.matrix.a;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.a.a.d;
import com.tencent.matrix.e.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public final class b
{
  @SuppressLint({"StaticFieldLeak"})
  static volatile b cSD;
  static long cSE = 0L;
  final List<c> cSF = new LinkedList();
  final a cSG = new a();
  boolean cSH = true;
  public d cSI;
  final Context mContext;
  final Handler mUiHandler = new Handler(Looper.getMainLooper());
  
  private b(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalStateException("Context should not be null");
    }
    this.mContext = paramContext;
  }
  
  public static b VJ()
  {
    if (cSD == null) {
      try
      {
        if (cSD == null) {
          throw new IllegalStateException("Call #init() first!");
        }
      }
      finally {}
    }
    return cSD;
  }
  
  public static void c(Application paramApplication)
  {
    if (cSD == null) {}
    try
    {
      if (cSD == null) {
        cSD = new b(paramApplication);
      }
      return;
    }
    finally {}
  }
  
  public static boolean isInit()
  {
    boolean bool = true;
    if (cSD != null) {
      return true;
    }
    for (;;)
    {
      try
      {
        if (cSD != null) {
          return bool;
        }
      }
      finally {}
      bool = false;
    }
  }
  
  public final b VK()
  {
    b localb = new b(this.mContext);
    d locald = this.cSI;
    if (locald != null) {
      localb.cSI = locald;
    }
    return localb;
  }
  
  public final void a(c paramc)
  {
    synchronized (this.cSF)
    {
      if (!this.cSF.contains(paramc)) {
        this.cSF.add(paramc);
      }
      return;
    }
  }
  
  public final void b(c paramc)
  {
    synchronized (this.cSF)
    {
      ListIterator localListIterator = this.cSF.listIterator();
      while (localListIterator.hasNext()) {
        if ((c)localListIterator.next() == paramc) {
          localListIterator.remove();
        }
      }
    }
  }
  
  final void bj(long paramLong)
  {
    synchronized (this.cSF)
    {
      Iterator localIterator = this.cSF.iterator();
      if (localIterator.hasNext()) {
        ((c)localIterator.next()).a(VK(), paramLong);
      }
    }
  }
  
  final void m(Intent paramIntent)
  {
    c.i("Matrix.battery.LifeCycle", "onSateChanged >> " + paramIntent.getAction(), new Object[0]);
    synchronized (this.cSF)
    {
      Iterator localIterator = this.cSF.iterator();
      if (localIterator.hasNext()) {
        ((c)localIterator.next()).eM(paramIntent.getAction());
      }
    }
  }
  
  public final class a
    implements Runnable
  {
    long cSL;
    
    public a() {}
    
    final long bk(long paramLong)
    {
      this.cSL += paramLong;
      return paramLong;
    }
    
    public final void run()
    {
      if (!b.this.cSH)
      {
        if (!com.tencent.matrix.a.b.b.bo(b.this.mContext)) {
          b.a(b.this, this.cSL);
        }
        if (this.cSL > 300000L) {
          break label65;
        }
        b.this.mUiHandler.postDelayed(this, bk(300000L));
      }
      label65:
      while (this.cSL > 600000L) {
        return;
      }
      b.this.mUiHandler.postDelayed(this, bk(1200000L));
    }
  }
  
  public static final class b
  {
    d cSI;
    public final Context mContext;
    
    public b(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public final boolean isForeground()
    {
      return (this.cSI == null) || (this.cSI.cUh);
    }
    
    public final String toString()
    {
      long l = 0L;
      StringBuilder localStringBuilder = new StringBuilder("BatteryState{fg=").append(isForeground()).append(", charge=").append(com.tencent.matrix.a.b.b.bo(this.mContext)).append(", screen=").append(com.tencent.matrix.a.b.b.bp(this.mContext)).append(", doze=").append(com.tencent.matrix.a.b.b.bq(this.mContext)).append(", bgMillis=");
      if (isForeground()) {}
      for (;;)
      {
        return l + '}';
        if (b.cSE > 0L) {
          l = SystemClock.uptimeMillis() - b.cSE;
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean a(b.b paramb, long paramLong);
    
    public abstract boolean eM(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.b
 * JD-Core Version:    0.7.0.1
 */