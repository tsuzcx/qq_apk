package com.tencent.matrix.a;

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
  static volatile b eNT;
  static long eNU = 0L;
  final List<c> eNV = new LinkedList();
  final a eNW = new a();
  boolean eNX = true;
  public d eNY;
  final Context mContext;
  final Handler mUiHandler = new Handler(Looper.getMainLooper());
  
  private b(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalStateException("Context should not be null");
    }
    this.mContext = paramContext;
  }
  
  public static b awt()
  {
    if (eNT == null) {
      try
      {
        if (eNT == null) {
          throw new IllegalStateException("Call #init() first!");
        }
      }
      finally {}
    }
    return eNT;
  }
  
  public static void c(Application paramApplication)
  {
    if (eNT == null) {}
    try
    {
      if (eNT == null) {
        eNT = new b(paramApplication);
      }
      return;
    }
    finally {}
  }
  
  public static boolean isInit()
  {
    boolean bool = true;
    if (eNT != null) {
      return true;
    }
    for (;;)
    {
      try
      {
        if (eNT != null) {
          return bool;
        }
      }
      finally {}
      bool = false;
    }
  }
  
  public final void a(c paramc)
  {
    synchronized (this.eNV)
    {
      if (!this.eNV.contains(paramc)) {
        this.eNV.add(paramc);
      }
      return;
    }
  }
  
  public final b awu()
  {
    b localb = new b(this.mContext);
    d locald = this.eNY;
    if (locald != null) {
      localb.eNY = locald;
    }
    return localb;
  }
  
  public final void b(c paramc)
  {
    synchronized (this.eNV)
    {
      ListIterator localListIterator = this.eNV.listIterator();
      while (localListIterator.hasNext()) {
        if ((c)localListIterator.next() == paramc) {
          localListIterator.remove();
        }
      }
    }
  }
  
  final void dB(long paramLong)
  {
    synchronized (this.eNV)
    {
      Iterator localIterator = this.eNV.iterator();
      while (localIterator.hasNext()) {
        if (((c)localIterator.next()).a(awu(), paramLong)) {
          return;
        }
      }
      return;
    }
  }
  
  final void n(Intent paramIntent)
  {
    c.i("Matrix.battery.LifeCycle", "onSateChanged >> " + paramIntent.getAction(), new Object[0]);
    synchronized (this.eNV)
    {
      Iterator localIterator = this.eNV.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.gl(paramIntent.getAction())) {
          b(localc);
        }
      }
    }
  }
  
  public final class a
    implements Runnable
  {
    long eOb;
    
    public a() {}
    
    final long dC(long paramLong)
    {
      this.eOb += paramLong;
      return paramLong;
    }
    
    public final void run()
    {
      if (!b.this.eNX)
      {
        if (!com.tencent.matrix.a.b.b.bZ(b.this.mContext)) {
          b.a(b.this, this.eOb);
        }
        if (this.eOb > 300000L) {
          break label65;
        }
        b.this.mUiHandler.postDelayed(this, dC(300000L));
      }
      label65:
      while (this.eOb > 600000L) {
        return;
      }
      b.this.mUiHandler.postDelayed(this, dC(1200000L));
    }
  }
  
  public static final class b
  {
    d eNY;
    public final Context mContext;
    
    public b(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public final long awv()
    {
      if (isForeground()) {}
      while (b.eNU <= 0L) {
        return 0L;
      }
      return SystemClock.uptimeMillis() - b.eNU;
    }
    
    public final boolean isForeground()
    {
      return (this.eNY == null) || (this.eNY.ePI);
    }
    
    public final String toString()
    {
      return "BatteryState{fg=" + isForeground() + ", charge=" + com.tencent.matrix.a.b.b.bZ(this.mContext) + ", screen=" + com.tencent.matrix.a.b.b.ca(this.mContext) + ", doze=" + com.tencent.matrix.a.b.b.cb(this.mContext) + ", bgMillis=" + awv() + '}';
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean a(b.b paramb, long paramLong);
    
    public abstract boolean gl(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.b
 * JD-Core Version:    0.7.0.1
 */