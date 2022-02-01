package com.tencent.matrix.trace.f;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.SystemClock;
import com.tencent.c.a.a.a;
import com.tencent.matrix.g.c;
import com.tencent.matrix.trace.c.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.core.AppMethodBeat.a;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class e
  extends f
  implements Application.ActivityLifecycleCallbacks, a.b, com.tencent.matrix.trace.e.a
{
  private boolean cBG;
  private final com.tencent.matrix.trace.a.b cBH;
  private long cDJ = 0L;
  private long cDK = 0L;
  private int cDL;
  private boolean cDM;
  private boolean cDN;
  private boolean cDO;
  private Set<String> cDP;
  private long cDQ;
  private long cDR;
  private long cDS = 0L;
  private HashMap<String, Long> cDT = new HashMap();
  private boolean cDU = true;
  
  public e(com.tencent.matrix.trace.a.b paramb)
  {
    this.cBH = paramb;
    this.cDO = paramb.cBB;
    if (paramb.cBF == null)
    {
      paramb.cBF = new HashSet();
      if (paramb.cwi != null) {
        break label157;
      }
      if (paramb.cBE != null) {
        paramb.cBF.addAll(Arrays.asList(paramb.cBE.split(";")));
      }
    }
    this.cDP = paramb.cBF;
    if (paramb.cwi == null)
    {
      label121:
      this.cDQ = i;
      if (paramb.cwi != null) {
        break label240;
      }
    }
    label157:
    label240:
    for (i = 4000;; i = paramb.cwi.get(a.a.Ihj.name(), 4000))
    {
      this.cDR = i;
      this.cBG = paramb.cBG;
      com.tencent.matrix.trace.c.a.a(this);
      return;
      String str = paramb.cwi.get(a.a.IgY.name(), paramb.cBE);
      if (str != null) {
        paramb.cBE = str;
      }
      if (paramb.cBE == null) {
        break;
      }
      paramb.cBF.addAll(Arrays.asList(paramb.cBE.split(";")));
      break;
      i = paramb.cwi.get(a.a.Ihi.name(), 10000);
      break label121;
    }
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    c.i("Matrix.StartupTracer", "[report] applicationCost:%s firstScreenCost:%s allCost:%s isWarmStartUp:%s, createScene:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Boolean.valueOf(paramBoolean), Integer.valueOf(com.tencent.matrix.trace.c.a.cCs) });
    long[] arrayOfLong2 = new long[0];
    long[] arrayOfLong1;
    if ((!paramBoolean) && (paramLong3 >= this.cDQ))
    {
      arrayOfLong1 = AppMethodBeat.getInstance().copyData(com.tencent.matrix.trace.c.a.cCr);
      com.tencent.matrix.trace.c.a.cCr.release();
    }
    for (;;)
    {
      com.tencent.matrix.g.b.Iq().post(new e.a(this, arrayOfLong1, paramLong1, paramLong2, paramLong3, paramBoolean, com.tencent.matrix.trace.c.a.cCs));
      return;
      arrayOfLong1 = arrayOfLong2;
      if (paramBoolean)
      {
        arrayOfLong1 = arrayOfLong2;
        if (paramLong3 >= this.cDR)
        {
          arrayOfLong1 = AppMethodBeat.getInstance().copyData(com.tencent.matrix.trace.c.a.cCq);
          com.tencent.matrix.trace.c.a.cCq.release();
        }
      }
    }
  }
  
  public final void Ia()
  {
    if (!this.cBG)
    {
      long l = com.tencent.matrix.trace.c.a.HW();
      c.i("Matrix.StartupTracer", "onApplicationCreateEnd, applicationCost:%d", new Object[] { Long.valueOf(l) });
      a(l, 0L, l, false);
    }
  }
  
  public final void n(Activity paramActivity)
  {
    if (com.tencent.matrix.trace.c.a.cCs == -2147483648) {
      return;
    }
    Object localObject = paramActivity.getClass().getName();
    int i;
    boolean bool;
    String str;
    if (this.cDK == 0L)
    {
      i = 1;
      if (i == 0) {
        break label436;
      }
      bool = com.tencent.matrix.trace.c.a.HY();
      c.i("Matrix.StartupTracer", "#ColdStartup# activity:%s, splashActivities:%s, empty:%b, isCreatedByLaunchActivity:%b, hasShowSplashActivity:%b, firstScreenCost:%d, now:%d, application_create_begin_time:%d, app_cost:%d", new Object[] { localObject, this.cDP, Boolean.valueOf(this.cDP.isEmpty()), Boolean.valueOf(bool), Boolean.valueOf(this.cDN), Long.valueOf(this.cDJ), Long.valueOf(SystemClock.uptimeMillis()), Long.valueOf(com.tencent.matrix.trace.c.a.HX()), Long.valueOf(com.tencent.matrix.trace.c.a.HW()) });
      str = (String)localObject + "@" + paramActivity.hashCode();
      paramActivity = (Long)this.cDT.get(str);
      if (paramActivity != null) {
        break label519;
      }
      paramActivity = Long.valueOf(0L);
    }
    label519:
    for (;;)
    {
      this.cDT.put(str, Long.valueOf(SystemClock.uptimeMillis() - paramActivity.longValue()));
      if (this.cDJ == 0L) {
        this.cDJ = (SystemClock.uptimeMillis() - com.tencent.matrix.trace.c.a.HX());
      }
      if (this.cDN) {
        this.cDK = (SystemClock.uptimeMillis() - com.tencent.matrix.trace.c.a.HX());
      }
      for (;;)
      {
        if (this.cDK <= 0L) {
          break label417;
        }
        localObject = (Long)this.cDT.get(str);
        if ((localObject == null) || (((Long)localObject).longValue() < 30000L)) {
          break label419;
        }
        c.e("Matrix.StartupTracer", "%s cost too much time[%s] between activity create and onActivityFocused, just throw it.(createTime:%s) ", new Object[] { str, Long.valueOf(SystemClock.uptimeMillis() - paramActivity.longValue()), paramActivity });
        return;
        i = 0;
        break;
        if (this.cDP.contains(localObject))
        {
          this.cDN = true;
        }
        else if (this.cDP.isEmpty())
        {
          if (bool)
          {
            this.cDK = this.cDJ;
          }
          else
          {
            this.cDJ = 0L;
            this.cDK = com.tencent.matrix.trace.c.a.HW();
          }
        }
        else if (bool)
        {
          this.cDK = this.cDJ;
        }
        else
        {
          this.cDJ = 0L;
          this.cDK = com.tencent.matrix.trace.c.a.HW();
        }
      }
      label417:
      break;
      label419:
      a(com.tencent.matrix.trace.c.a.HW(), this.cDJ, this.cDK, false);
      return;
      label436:
      if (!this.cDM) {
        break;
      }
      this.cDM = false;
      long l = SystemClock.uptimeMillis() - this.cDS;
      c.i("Matrix.StartupTracer", "#WarmStartup# activity:%s, warmCost:%d, now:%d, lastCreateActivity:%d", new Object[] { localObject, Long.valueOf(l), Long.valueOf(SystemClock.uptimeMillis()), Long.valueOf(this.cDS) });
      if (l <= 0L) {
        break;
      }
      a(0L, 0L, l, true);
      return;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    c.i("Matrix.StartupTracer", "activeActivityCount:%d, coldCost:%d", new Object[] { Integer.valueOf(this.cDL), Long.valueOf(this.cDK) });
    if ((this.cDL == 0) && (this.cDK > 0L))
    {
      this.cDS = SystemClock.uptimeMillis();
      c.i("Matrix.StartupTracer", "lastCreateActivity:%d, activity:%s", new Object[] { Long.valueOf(this.cDS), paramActivity.getClass().getName() });
      this.cDM = true;
    }
    this.cDL += 1;
    if (this.cDU) {
      this.cDT.put(paramActivity.getClass().getName() + "@" + paramActivity.hashCode(), Long.valueOf(SystemClock.uptimeMillis()));
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    c.i("Matrix.StartupTracer", "activeActivityCount:%d", new Object[] { Integer.valueOf(this.cDL) });
    this.cDL -= 1;
  }
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  protected final void onAlive()
  {
    super.onAlive();
    c.i("Matrix.StartupTracer", "[onAlive] isStartupEnable:%s", new Object[] { Boolean.valueOf(this.cDO) });
    if (this.cDO)
    {
      AppMethodBeat.getInstance().addListener(this);
      com.tencent.matrix.b.GF().application.registerActivityLifecycleCallbacks(this);
    }
  }
  
  protected final void onDead()
  {
    super.onDead();
    if (this.cDO)
    {
      AppMethodBeat.getInstance().removeListener(this);
      com.tencent.matrix.b.GF().application.unregisterActivityLifecycleCallbacks(this);
    }
  }
  
  public final void onForeground(boolean paramBoolean)
  {
    super.onForeground(paramBoolean);
    if (!paramBoolean) {}
    try
    {
      Object localObject1 = Class.forName("android.app.ActivityThread");
      Object localObject2 = ((Class)localObject1).getDeclaredField("sCurrentActivityThread");
      ((Field)localObject2).setAccessible(true);
      localObject2 = ((Field)localObject2).get(localObject1);
      localObject1 = ((Class)localObject1).getDeclaredField("mH");
      ((Field)localObject1).setAccessible(true);
      localObject1 = ((Field)localObject1).get(localObject2);
      localObject2 = localObject1.getClass().getSuperclass().getDeclaredField("mCallback");
      ((Field)localObject2).setAccessible(true);
      c.i("Matrix.StartupTracer", "callback %s", new Object[] { (Handler.Callback)((Field)localObject2).get(localObject1) });
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.f.e
 * JD-Core Version:    0.7.0.1
 */