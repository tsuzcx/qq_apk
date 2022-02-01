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
import com.tencent.matrix.a.b.o;
import com.tencent.matrix.a.b.o.a;
import com.tencent.matrix.a.b.o.a.a;
import com.tencent.matrix.a.b.o.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class d
  extends a
{
  Runnable ePY = new Runnable()
  {
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 14	com/tencent/matrix/a/a/a/d$1:eQG	Lcom/tencent/matrix/a/a/a/d;
      //   4: getfield 23	com/tencent/matrix/a/a/a/d:eQE	Ljava/util/List;
      //   7: invokeinterface 29 1 0
      //   12: aload_0
      //   13: getfield 14	com/tencent/matrix/a/a/a/d$1:eQG	Lcom/tencent/matrix/a/a/a/d;
      //   16: getfield 33	com/tencent/matrix/a/a/a/d:eNY	Lcom/tencent/matrix/a/a/d;
      //   19: getfield 39	com/tencent/matrix/a/a/d:ePD	Lcom/tencent/matrix/a/a/c;
      //   22: getfield 45	com/tencent/matrix/a/a/c:ePi	I
      //   25: if_icmplt +19 -> 44
      //   28: ldc 47
      //   30: monitorenter
      //   31: aload_0
      //   32: getfield 14	com/tencent/matrix/a/a/a/d$1:eQG	Lcom/tencent/matrix/a/a/a/d;
      //   35: getfield 23	com/tencent/matrix/a/a/a/d:eQE	Ljava/util/List;
      //   38: invokestatic 53	com/tencent/matrix/a/b/o:bg	(Ljava/util/List;)V
      //   41: ldc 47
      //   43: monitorexit
      //   44: aload_0
      //   45: getfield 14	com/tencent/matrix/a/a/a/d$1:eQG	Lcom/tencent/matrix/a/a/a/d;
      //   48: getfield 56	com/tencent/matrix/a/a/a/d:eQF	Ljava/util/List;
      //   51: invokeinterface 29 1 0
      //   56: aload_0
      //   57: getfield 14	com/tencent/matrix/a/a/a/d$1:eQG	Lcom/tencent/matrix/a/a/a/d;
      //   60: getfield 33	com/tencent/matrix/a/a/a/d:eNY	Lcom/tencent/matrix/a/a/d;
      //   63: getfield 39	com/tencent/matrix/a/a/d:ePD	Lcom/tencent/matrix/a/a/c;
      //   66: getfield 45	com/tencent/matrix/a/a/c:ePi	I
      //   69: if_icmplt +19 -> 88
      //   72: ldc 47
      //   74: monitorenter
      //   75: aload_0
      //   76: getfield 14	com/tencent/matrix/a/a/a/d$1:eQG	Lcom/tencent/matrix/a/a/a/d;
      //   79: getfield 56	com/tencent/matrix/a/a/a/d:eQF	Ljava/util/List;
      //   82: invokestatic 53	com/tencent/matrix/a/b/o:bg	(Ljava/util/List;)V
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
  int eQB = 1024;
  int eQC = 1024;
  int eQD = 100;
  List<o.a> eQE = Collections.emptyList();
  public List<o.a> eQF = Collections.emptyList();
  
  public final void awI()
  {
    super.awI();
    o.a locala1 = new o.a("1");
    o.a locala2 = new o.a(this.eNY.getScene());
    try
    {
      this.eQE = new ArrayList();
      this.eQE.add(0, locala1);
      this.eQF = new ArrayList();
      this.eQF.add(0, locala2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void awJ()
  {
    super.awJ();
    try
    {
      this.eQE.clear();
      this.eQF.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void awN()
  {
    this.eNY.mHandler.removeCallbacks(this.ePY);
    this.eNY.mHandler.postDelayed(this.ePY, 1000L);
  }
  
  public final int awQ()
  {
    return 2147483647;
  }
  
  public final void awS()
  {
    if ((this.eQB <= this.eQD) && (this.eQC <= this.eQD)) {
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
                  if (d.this.eQC > localRunningAppProcessInfo.importance)
                  {
                    com.tencent.matrix.e.c.i("Matrix.battery.AppStatMonitorFeature", "update global importance: " + d.this.eQC + " > " + localRunningAppProcessInfo.importance + ", reason = " + localRunningAppProcessInfo.importanceReasonComponent, new Object[0]);
                    d.this.eQC = localRunningAppProcessInfo.importance;
                  }
                  if ((localRunningAppProcessInfo.processName.equals(localContext.getPackageName())) && (d.this.eQB > localRunningAppProcessInfo.importance))
                  {
                    com.tencent.matrix.e.c.i("Matrix.battery.AppStatMonitorFeature", "update app importance: " + d.this.eQB + " > " + localRunningAppProcessInfo.importance + ", reason = " + localRunningAppProcessInfo.importanceReasonComponent, new Object[0]);
                    d.this.eQB = localRunningAppProcessInfo.importance;
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
      this.eNY.mHandler.post(local2);
      return;
    }
    local2.run();
  }
  
  public final void dE(long paramLong)
  {
    super.dE(paramLong);
    com.tencent.matrix.e.c.i("Matrix.battery.AppStatMonitorFeature", "#onBackgroundCheck, during = ".concat(String.valueOf(paramLong)), new Object[0]);
    Context localContext;
    Object localObject;
    if ((this.eQC > this.eQD) || (this.eQB > this.eQD))
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
            if (this.eQC > this.eQD)
            {
              com.tencent.matrix.e.c.w("Matrix.battery.AppStatMonitorFeature", "foreground service detected with low global importance: " + this.eQB + ", " + this.eQC + ", " + localRunningServiceInfo.service, new Object[0]);
              this.eNY.a(false, this.eQB, this.eQC, localRunningServiceInfo.service, paramLong);
            }
            if ((this.eQB > this.eQD) && (localRunningServiceInfo.process.equals(localContext.getPackageName())))
            {
              com.tencent.matrix.e.c.w("Matrix.battery.AppStatMonitorFeature", "foreground service detected with low app importance: " + this.eQB + ", " + this.eQC + ", " + localRunningServiceInfo.service, new Object[0]);
              this.eNY.a(true, this.eQB, this.eQC, localRunningServiceInfo.service, paramLong);
            }
          }
        }
      }
    }
  }
  
  public final b dF(long paramLong)
  {
    try
    {
      o.c localc = o.a(this.eQE, paramLong, new o.a.a()
      {
        public final o.a gr(String paramAnonymousString)
        {
          return new o.a(String.valueOf(b.k(com.tencent.matrix.a.a.d.getContext(), d.this.eNY.ePI)));
        }
      });
      b localb2 = new b();
      localb2.eSe = localc.eSe;
      localb2.eQH = m.a.c.b.c(Long.valueOf(localc.eUv));
      localb2.eQI = m.a.c.b.c(Long.valueOf(localc.gB("1")));
      localb2.eQJ = m.a.c.b.c(Long.valueOf(localc.gB("2")));
      localb2.eQK = m.a.c.b.c(Long.valueOf(localc.gB("3")));
      return localb2;
    }
    finally
    {
      com.tencent.matrix.e.c.w("Matrix.battery.AppStatMonitorFeature", "configureSnapshot fail: " + localObject.getMessage(), new Object[0]);
      b localb1 = new b();
      localb1.eSe = false;
      return localb1;
    }
  }
  
  public final o.c dG(long paramLong)
  {
    try
    {
      o.c localc = o.a(this.eQF, paramLong, new o.a.a()
      {
        public final o.a gr(String paramAnonymousString)
        {
          return new o.a(d.this.eNY.getScene());
        }
      });
      return localc;
    }
    finally
    {
      com.tencent.matrix.e.c.w("Matrix.battery.AppStatMonitorFeature", "currentSceneSnapshot fail: " + localObject.getMessage(), new Object[0]);
    }
    return o.c.axD();
  }
  
  public final void g(com.tencent.matrix.a.a.d paramd)
  {
    super.g(paramd);
    this.eQD = Math.max(paramd.ePD.ePj, 100);
  }
  
  protected final String getTag()
  {
    return "Matrix.battery.AppStatMonitorFeature";
  }
  
  public final void onForeground(boolean paramBoolean)
  {
    super.onForeground(paramBoolean);
    int i = b.l(com.tencent.matrix.a.a.d.getContext(), paramBoolean);
    b.axp().na(i);
    for (;;)
    {
      try
      {
        if (this.eQE != Collections.EMPTY_LIST)
        {
          com.tencent.matrix.e.c.i("Matrix.battery.LifeCycle", "onStat >> " + b.mY(i), new Object[0]);
          this.eQE.add(0, new o.a(String.valueOf(i)));
          awN();
        }
        StringBuilder localStringBuilder = new StringBuilder("updateAppImportance when app ");
        if (paramBoolean)
        {
          String str1 = "foreground";
          com.tencent.matrix.e.c.i("Matrix.battery.AppStatMonitorFeature", str1, new Object[0]);
          awS();
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
    extends m.a<b>
  {
    public m.a.c.b<Long> eQH = m.a.c.b.c(Long.valueOf(0L));
    public m.a.c.b<Long> eQI = m.a.c.b.c(Long.valueOf(0L));
    public m.a.c.b<Long> eQJ = m.a.c.b.c(Long.valueOf(0L));
    public m.a.c.b<Long> eQK = m.a.c.b.c(Long.valueOf(0L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */