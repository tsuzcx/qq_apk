package com.tencent.matrix.a.a.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.a.b.b;
import com.tencent.matrix.a.b.b.a;
import com.tencent.matrix.a.b.k;
import com.tencent.matrix.a.b.k.a;
import com.tencent.matrix.a.b.k.a.a;
import com.tencent.matrix.a.b.k.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class d
  extends a
{
  Runnable cUy = new Runnable()
  {
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 14	com/tencent/matrix/a/a/a/d$1:cVg	Lcom/tencent/matrix/a/a/a/d;
      //   4: getfield 23	com/tencent/matrix/a/a/a/d:cVe	Ljava/util/List;
      //   7: invokeinterface 29 1 0
      //   12: aload_0
      //   13: getfield 14	com/tencent/matrix/a/a/a/d$1:cVg	Lcom/tencent/matrix/a/a/a/d;
      //   16: getfield 33	com/tencent/matrix/a/a/a/d:cSI	Lcom/tencent/matrix/a/a/d;
      //   19: getfield 39	com/tencent/matrix/a/a/d:cUb	Lcom/tencent/matrix/a/a/c;
      //   22: getfield 45	com/tencent/matrix/a/a/c:cTG	I
      //   25: if_icmplt +19 -> 44
      //   28: ldc 47
      //   30: monitorenter
      //   31: aload_0
      //   32: getfield 14	com/tencent/matrix/a/a/a/d$1:cVg	Lcom/tencent/matrix/a/a/a/d;
      //   35: getfield 23	com/tencent/matrix/a/a/a/d:cVe	Ljava/util/List;
      //   38: invokestatic 52	com/tencent/matrix/a/b/k:I	(Ljava/util/List;)V
      //   41: ldc 47
      //   43: monitorexit
      //   44: aload_0
      //   45: getfield 14	com/tencent/matrix/a/a/a/d$1:cVg	Lcom/tencent/matrix/a/a/a/d;
      //   48: getfield 55	com/tencent/matrix/a/a/a/d:cVf	Ljava/util/List;
      //   51: invokeinterface 29 1 0
      //   56: aload_0
      //   57: getfield 14	com/tencent/matrix/a/a/a/d$1:cVg	Lcom/tencent/matrix/a/a/a/d;
      //   60: getfield 33	com/tencent/matrix/a/a/a/d:cSI	Lcom/tencent/matrix/a/a/d;
      //   63: getfield 39	com/tencent/matrix/a/a/d:cUb	Lcom/tencent/matrix/a/a/c;
      //   66: getfield 45	com/tencent/matrix/a/a/c:cTG	I
      //   69: if_icmplt +19 -> 88
      //   72: ldc 47
      //   74: monitorenter
      //   75: aload_0
      //   76: getfield 14	com/tencent/matrix/a/a/a/d$1:cVg	Lcom/tencent/matrix/a/a/a/d;
      //   79: getfield 55	com/tencent/matrix/a/a/a/d:cVf	Ljava/util/List;
      //   82: invokestatic 52	com/tencent/matrix/a/b/k:I	(Ljava/util/List;)V
      //   85: ldc 47
      //   87: monitorexit
      //   88: return
      //   89: astore_1
      //   90: ldc 47
      //   92: monitorexit
      //   93: aload_1
      //   94: athrow
      //   95: astore_1
      //   96: ldc 47
      //   98: monitorexit
      //   99: aload_1
      //   100: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	101	0	this	1
      //   89	5	1	localObject1	Object
      //   95	5	1	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   31	44	89	finally
      //   75	88	95	finally
    }
  };
  int cVb = 1024;
  int cVc = 1024;
  int cVd = 100;
  List<k.a> cVe = Collections.emptyList();
  public List<k.a> cVf = Collections.emptyList();
  
  public final void VZ()
  {
    super.VZ();
    k.a locala1 = new k.a("1");
    k.a locala2 = new k.a(this.cSI.getScene());
    try
    {
      this.cVe = new ArrayList();
      this.cVe.add(0, locala1);
      this.cVf = new ArrayList();
      this.cVf.add(0, locala2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void Wa()
  {
    super.Wa();
    try
    {
      this.cVe.clear();
      this.cVf.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void We()
  {
    this.cSI.mHandler.removeCallbacks(this.cUy);
    this.cSI.mHandler.postDelayed(this.cUy, 1000L);
  }
  
  public final int Wh()
  {
    return 2147483647;
  }
  
  public final void Wj()
  {
    if ((this.cVb <= this.cVd) && (this.cVc <= this.cVd)) {
      return;
    }
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        Context localContext = com.tencent.matrix.a.a.d.getContext();
        String str = localContext.getPackageName();
        if (str.contains(":")) {
          str = str.substring(0, str.indexOf(":"));
        }
        for (;;)
        {
          Object localObject = (ActivityManager)localContext.getSystemService("activity");
          if (localObject == null) {}
          for (;;)
          {
            return;
            localObject = ((ActivityManager)localObject).getRunningAppProcesses();
            if (localObject != null)
            {
              localObject = ((List)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
                if (localRunningAppProcessInfo.processName.startsWith(str))
                {
                  if (d.this.cVc > localRunningAppProcessInfo.importance)
                  {
                    com.tencent.matrix.e.c.i("Matrix.battery.AppStatMonitorFeature", "update global importance: " + d.this.cVc + " > " + localRunningAppProcessInfo.importance + ", reason = " + localRunningAppProcessInfo.importanceReasonComponent, new Object[0]);
                    d.this.cVc = localRunningAppProcessInfo.importance;
                  }
                  if ((localRunningAppProcessInfo.processName.equals(localContext.getPackageName())) && (d.this.cVb > localRunningAppProcessInfo.importance))
                  {
                    com.tencent.matrix.e.c.i("Matrix.battery.AppStatMonitorFeature", "update app importance: " + d.this.cVb + " > " + localRunningAppProcessInfo.importance + ", reason = " + localRunningAppProcessInfo.importanceReasonComponent, new Object[0]);
                    d.this.cVb = localRunningAppProcessInfo.importance;
                  }
                }
              }
            }
          }
        }
      }
    };
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.cSI.mHandler.post(local2);
      return;
    }
    local2.run();
  }
  
  public final void bm(long paramLong)
  {
    super.bm(paramLong);
    com.tencent.matrix.e.c.i("Matrix.battery.AppStatMonitorFeature", "#onBackgroundCheck, during = ".concat(String.valueOf(paramLong)), new Object[0]);
    Context localContext;
    Object localObject;
    if ((this.cVc > this.cVd) || (this.cVb > this.cVd))
    {
      localContext = com.tencent.matrix.a.a.d.getContext();
      localObject = (ActivityManager)localContext.getSystemService("activity");
      if (localObject != null) {
        break label66;
      }
    }
    for (;;)
    {
      return;
      label66:
      localObject = ((ActivityManager)localObject).getRunningServices(2147483647);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)((Iterator)localObject).next();
          if ((!TextUtils.isEmpty(localRunningServiceInfo.process)) && (localRunningServiceInfo.process.startsWith(localContext.getPackageName())) && (localRunningServiceInfo.foreground))
          {
            com.tencent.matrix.e.c.i("Matrix.battery.AppStatMonitorFeature", "checkForegroundService whether app importance is low, during = ".concat(String.valueOf(paramLong)), new Object[0]);
            if (this.cVc > this.cVd)
            {
              com.tencent.matrix.e.c.w("Matrix.battery.AppStatMonitorFeature", "foreground service detected with low global importance: " + this.cVb + ", " + this.cVc + ", " + localRunningServiceInfo.service, new Object[0]);
              this.cSI.a(false, this.cVb, this.cVc, localRunningServiceInfo.service, paramLong);
            }
            if ((this.cVb > this.cVd) && (localRunningServiceInfo.process.equals(localContext.getPackageName())))
            {
              com.tencent.matrix.e.c.w("Matrix.battery.AppStatMonitorFeature", "foreground service detected with low app importance: " + this.cVb + ", " + this.cVc + ", " + localRunningServiceInfo.service, new Object[0]);
              this.cSI.a(true, this.cVb, this.cVc, localRunningServiceInfo.service, paramLong);
            }
          }
        }
      }
    }
  }
  
  public final b bn(long paramLong)
  {
    try
    {
      k.c localc = k.a(this.cVe, paramLong, new k.a.a()
      {
        public final k.a eT(String paramAnonymousString)
        {
          return new k.a(String.valueOf(b.k(com.tencent.matrix.a.a.d.getContext(), d.this.cSI.cUh)));
        }
      });
      b localb2 = new b();
      localb2.cWl = localc.cWl;
      localb2.cVh = j.a.c.b.c(Long.valueOf(localc.cXW));
      localb2.cVi = j.a.c.b.c(Long.valueOf(localc.fd("1")));
      localb2.cVj = j.a.c.b.c(Long.valueOf(localc.fd("2")));
      localb2.cVk = j.a.c.b.c(Long.valueOf(localc.fd("3")));
      return localb2;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.matrix.e.c.w("Matrix.battery.AppStatMonitorFeature", "configureSnapshot fail: " + localThrowable.getMessage(), new Object[0]);
      b localb1 = new b();
      localb1.cWl = false;
      return localb1;
    }
  }
  
  public final k.c bo(long paramLong)
  {
    try
    {
      k.c localc = k.a(this.cVf, paramLong, new k.a.a()
      {
        public final k.a eT(String paramAnonymousString)
        {
          return new k.a(d.this.cSI.getScene());
        }
      });
      return localc;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.matrix.e.c.w("Matrix.battery.AppStatMonitorFeature", "currentSceneSnapshot fail: " + localThrowable.getMessage(), new Object[0]);
    }
    return k.c.WG();
  }
  
  public final void f(com.tencent.matrix.a.a.d paramd)
  {
    super.f(paramd);
    this.cVd = Math.max(paramd.cUb.cTH, 100);
  }
  
  protected final String getTag()
  {
    return "Matrix.battery.AppStatMonitorFeature";
  }
  
  public final void onForeground(boolean paramBoolean)
  {
    super.onForeground(paramBoolean);
    int i = b.l(com.tencent.matrix.a.a.d.getContext(), paramBoolean);
    b.WA().jx(i);
    for (;;)
    {
      try
      {
        if (this.cVe != Collections.EMPTY_LIST)
        {
          com.tencent.matrix.e.c.i("Matrix.battery.LifeCycle", "onStat >> " + b.jv(i), new Object[0]);
          this.cVe.add(0, new k.a(String.valueOf(i)));
          We();
        }
        StringBuilder localStringBuilder = new StringBuilder("updateAppImportance when app ");
        if (paramBoolean)
        {
          String str1 = "foreground";
          com.tencent.matrix.e.c.i("Matrix.battery.AppStatMonitorFeature", str1, new Object[0]);
          Wj();
          return;
        }
      }
      finally {}
      String str2 = "background";
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, int paramInt1, int paramInt2, ComponentName paramComponentName, long paramLong);
  }
  
  public static final class b
    extends j.a<b>
  {
    public j.a.c.b<Long> cVh = j.a.c.b.c(Long.valueOf(0L));
    public j.a.c.b<Long> cVi = j.a.c.b.c(Long.valueOf(0L));
    public j.a.c.b<Long> cVj = j.a.c.b.c(Long.valueOf(0L));
    public j.a.c.b<Long> cVk = j.a.c.b.c(Long.valueOf(0L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */