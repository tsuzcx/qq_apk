package com.tencent.matrix.a.b.a;

import android.app.AlarmManager.OnAlarmListener;
import android.app.PendingIntent;
import android.os.Handler;
import android.util.Log;
import com.tencent.matrix.a.c.a.b;

public final class b
  extends a
  implements a.b
{
  public final a cSr = new a();
  Handler handler;
  
  public final void Se()
  {
    super.Se();
    com.tencent.matrix.a.c.a.a(this);
  }
  
  public final void Sf()
  {
    super.Sf();
    com.tencent.matrix.a.c.a.b(this);
    this.handler.removeCallbacksAndMessages(null);
    a locala = this.cSr;
    locala.cSs = 0;
    locala.cSt = 0;
    locala.cSu = 0;
    locala.cSv = 0;
  }
  
  public final int Sg()
  {
    return -2147483648;
  }
  
  public final void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2, PendingIntent arg9, AlarmManager.OnAlarmListener paramOnAlarmListener)
  {
    String str = "";
    if (this.cSq.cSe.cRV) {
      str = com.tencent.matrix.a.c.c.K(Log.getStackTraceString(new Throwable()), "at android.app.AlarmManager");
    }
    com.tencent.matrix.g.c.i("Matrix.battery.AlarmMonitorFeature", "#onAlarmSet, target = ".concat(String.valueOf(new b(paramInt1, paramLong1, paramLong2, paramLong3, paramInt2, str))), new Object[0]);
    if ((??? != null) || (paramOnAlarmListener != null))
    {
      if (??? == null) {
        break label133;
      }
      ???.hashCode();
    }
    for (;;)
    {
      paramOnAlarmListener = this.cSr;
      synchronized (paramOnAlarmListener.mLock)
      {
        paramOnAlarmListener.cSs += 1;
        paramOnAlarmListener.cSt += 1;
        return;
        label133:
        paramOnAlarmListener.hashCode();
      }
    }
  }
  
  public final void a(PendingIntent arg1, AlarmManager.OnAlarmListener paramOnAlarmListener)
  {
    if ((??? != null) || (paramOnAlarmListener != null))
    {
      if (??? == null) {
        break label42;
      }
      ???.hashCode();
    }
    for (;;)
    {
      paramOnAlarmListener = this.cSr;
      synchronized (paramOnAlarmListener.mLock)
      {
        paramOnAlarmListener.cSt -= 1;
        return;
        label42:
        paramOnAlarmListener.hashCode();
      }
    }
  }
  
  public final void d(com.tencent.matrix.a.b.c paramc)
  {
    super.d(paramc);
    this.handler = paramc.mHandler;
  }
  
  public static final class a
  {
    int cSs;
    int cSt;
    int cSu;
    int cSv;
    final byte[] mLock = new byte[0];
    
    public final b.c Sh()
    {
      b.c localc = new b.c();
      synchronized (this.mLock)
      {
        localc.cSz = g.a.c.b.b(Integer.valueOf(this.cSs));
        localc.cSA = g.a.c.b.b(Integer.valueOf(this.cSt));
        localc.cSB = g.a.c.b.b(Integer.valueOf(this.cSu));
        localc.cSC = g.a.c.b.b(Integer.valueOf(this.cSv));
        localc.cSD = g.a.c.c.Sn();
        return localc;
      }
    }
  }
  
  public static final class b
  {
    public final long cQq;
    public final long cQr;
    public final long cSw;
    public final int cSx;
    public final long cSy;
    public final String stack;
    public final int type;
    
    public b(int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2, String paramString)
    {
      this.type = paramInt1;
      this.cQq = paramLong1;
      this.cSw = paramLong2;
      this.cQr = paramLong3;
      this.cSx = paramInt2;
      this.cSy = System.currentTimeMillis();
      this.stack = paramString;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (b)paramObject;
      } while (hashCode() == paramObject.hashCode());
      return false;
    }
    
    public final String toString()
    {
      return "AlarmRecord{type=" + this.type + ", triggerAtMillis=" + this.cQq + ", windowMillis=" + this.cSw + ", intervalMillis=" + this.cQr + ", flag=" + this.cSx + ", timeBgn=" + this.cSy + ", stack='" + this.stack + '\'' + '}';
    }
  }
  
  public static final class c
    extends g.a<c>
  {
    public g.a.c.b<Integer> cSA;
    public g.a.c.b<Integer> cSB;
    public g.a.c.b<Integer> cSC;
    public g.a.c.c<g.a.c.a<b.b>> cSD;
    public g.a.c.b<Integer> cSz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */