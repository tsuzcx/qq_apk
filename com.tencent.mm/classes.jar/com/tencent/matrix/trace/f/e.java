package com.tencent.matrix.trace.f;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.SystemClock;
import com.tencent.matrix.trace.c.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.core.AppMethodBeat.a;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends f
  implements Application.ActivityLifecycleCallbacks, a.b, com.tencent.matrix.trace.e.a
{
  private long cAR = 0L;
  private long cAS = 0L;
  private int cAT;
  private boolean cAU;
  private boolean cAV;
  private boolean cAW;
  private Set<String> cAX;
  private long cAY;
  private long cAZ;
  private long cBa = 0L;
  private HashMap<String, Long> cBb = new HashMap();
  private boolean cBc = true;
  private boolean cyP;
  private final com.tencent.matrix.trace.a.b cyQ;
  
  public e(com.tencent.matrix.trace.a.b paramb)
  {
    this.cyQ = paramb;
    this.cAW = paramb.cyK;
    if (paramb.cyO == null)
    {
      paramb.cyO = new HashSet();
      if (paramb.ctq != null) {
        break label157;
      }
      if (paramb.cyN != null) {
        paramb.cyO.addAll(Arrays.asList(paramb.cyN.split(";")));
      }
    }
    this.cAX = paramb.cyO;
    if (paramb.ctq == null)
    {
      label121:
      this.cAY = i;
      if (paramb.ctq != null) {
        break label240;
      }
    }
    label157:
    label240:
    for (i = 4000;; i = paramb.ctq.get(com.tencent.c.a.a.a.JIR.name(), 4000))
    {
      this.cAZ = i;
      this.cyP = paramb.cyP;
      com.tencent.matrix.trace.c.a.a(this);
      return;
      String str = paramb.ctq.get(com.tencent.c.a.a.a.JIG.name(), paramb.cyN);
      if (str != null) {
        paramb.cyN = str;
      }
      if (paramb.cyN == null) {
        break;
      }
      paramb.cyO.addAll(Arrays.asList(paramb.cyN.split(";")));
      break;
      i = paramb.ctq.get(com.tencent.c.a.a.a.JIQ.name(), 10000);
      break label121;
    }
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    com.tencent.matrix.g.c.i("Matrix.StartupTracer", "[report] applicationCost:%s firstScreenCost:%s allCost:%s isWarmStartUp:%s, createScene:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Boolean.valueOf(paramBoolean), Integer.valueOf(com.tencent.matrix.trace.c.a.czB) });
    long[] arrayOfLong2 = new long[0];
    long[] arrayOfLong1;
    if ((!paramBoolean) && (paramLong3 >= this.cAY))
    {
      arrayOfLong1 = AppMethodBeat.getInstance().copyData(com.tencent.matrix.trace.c.a.czA);
      com.tencent.matrix.trace.c.a.czA.release();
    }
    for (;;)
    {
      com.tencent.matrix.g.b.HZ().post(new a(arrayOfLong1, paramLong1, paramLong2, paramLong3, paramBoolean, com.tencent.matrix.trace.c.a.czB));
      return;
      arrayOfLong1 = arrayOfLong2;
      if (paramBoolean)
      {
        arrayOfLong1 = arrayOfLong2;
        if (paramLong3 >= this.cAZ)
        {
          arrayOfLong1 = AppMethodBeat.getInstance().copyData(com.tencent.matrix.trace.c.a.czz);
          com.tencent.matrix.trace.c.a.czz.release();
        }
      }
    }
  }
  
  public final void HL()
  {
    if (!this.cyP)
    {
      long l = com.tencent.matrix.trace.c.a.HH();
      com.tencent.matrix.g.c.i("Matrix.StartupTracer", "onApplicationCreateEnd, applicationCost:%d", new Object[] { Long.valueOf(l) });
      a(l, 0L, l, false);
    }
  }
  
  public final void n(Activity paramActivity)
  {
    if (com.tencent.matrix.trace.c.a.czB == -2147483648) {
      return;
    }
    Object localObject = paramActivity.getClass().getName();
    int i;
    boolean bool;
    String str;
    if (this.cAS == 0L)
    {
      i = 1;
      if (i == 0) {
        break label436;
      }
      bool = com.tencent.matrix.trace.c.a.HJ();
      com.tencent.matrix.g.c.i("Matrix.StartupTracer", "#ColdStartup# activity:%s, splashActivities:%s, empty:%b, isCreatedByLaunchActivity:%b, hasShowSplashActivity:%b, firstScreenCost:%d, now:%d, application_create_begin_time:%d, app_cost:%d", new Object[] { localObject, this.cAX, Boolean.valueOf(this.cAX.isEmpty()), Boolean.valueOf(bool), Boolean.valueOf(this.cAV), Long.valueOf(this.cAR), Long.valueOf(SystemClock.uptimeMillis()), Long.valueOf(com.tencent.matrix.trace.c.a.HI()), Long.valueOf(com.tencent.matrix.trace.c.a.HH()) });
      str = (String)localObject + "@" + paramActivity.hashCode();
      paramActivity = (Long)this.cBb.get(str);
      if (paramActivity != null) {
        break label519;
      }
      paramActivity = Long.valueOf(0L);
    }
    label519:
    for (;;)
    {
      this.cBb.put(str, Long.valueOf(SystemClock.uptimeMillis() - paramActivity.longValue()));
      if (this.cAR == 0L) {
        this.cAR = (SystemClock.uptimeMillis() - com.tencent.matrix.trace.c.a.HI());
      }
      if (this.cAV) {
        this.cAS = (SystemClock.uptimeMillis() - com.tencent.matrix.trace.c.a.HI());
      }
      for (;;)
      {
        if (this.cAS <= 0L) {
          break label417;
        }
        localObject = (Long)this.cBb.get(str);
        if ((localObject == null) || (((Long)localObject).longValue() < 30000L)) {
          break label419;
        }
        com.tencent.matrix.g.c.e("Matrix.StartupTracer", "%s cost too much time[%s] between activity create and onActivityFocused, just throw it.(createTime:%s) ", new Object[] { str, Long.valueOf(SystemClock.uptimeMillis() - paramActivity.longValue()), paramActivity });
        return;
        i = 0;
        break;
        if (this.cAX.contains(localObject))
        {
          this.cAV = true;
        }
        else if (this.cAX.isEmpty())
        {
          if (bool)
          {
            this.cAS = this.cAR;
          }
          else
          {
            this.cAR = 0L;
            this.cAS = com.tencent.matrix.trace.c.a.HH();
          }
        }
        else if (bool)
        {
          this.cAS = this.cAR;
        }
        else
        {
          this.cAR = 0L;
          this.cAS = com.tencent.matrix.trace.c.a.HH();
        }
      }
      label417:
      break;
      label419:
      a(com.tencent.matrix.trace.c.a.HH(), this.cAR, this.cAS, false);
      return;
      label436:
      if (!this.cAU) {
        break;
      }
      this.cAU = false;
      long l = SystemClock.uptimeMillis() - this.cBa;
      com.tencent.matrix.g.c.i("Matrix.StartupTracer", "#WarmStartup# activity:%s, warmCost:%d, now:%d, lastCreateActivity:%d", new Object[] { localObject, Long.valueOf(l), Long.valueOf(SystemClock.uptimeMillis()), Long.valueOf(this.cBa) });
      if (l <= 0L) {
        break;
      }
      a(0L, 0L, l, true);
      return;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    com.tencent.matrix.g.c.i("Matrix.StartupTracer", "activeActivityCount:%d, coldCost:%d", new Object[] { Integer.valueOf(this.cAT), Long.valueOf(this.cAS) });
    if ((this.cAT == 0) && (this.cAS > 0L))
    {
      this.cBa = SystemClock.uptimeMillis();
      com.tencent.matrix.g.c.i("Matrix.StartupTracer", "lastCreateActivity:%d, activity:%s", new Object[] { Long.valueOf(this.cBa), paramActivity.getClass().getName() });
      this.cAU = true;
    }
    this.cAT += 1;
    if (this.cBc) {
      this.cBb.put(paramActivity.getClass().getName() + "@" + paramActivity.hashCode(), Long.valueOf(SystemClock.uptimeMillis()));
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    com.tencent.matrix.g.c.i("Matrix.StartupTracer", "activeActivityCount:%d", new Object[] { Integer.valueOf(this.cAT) });
    this.cAT -= 1;
  }
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  protected final void onAlive()
  {
    super.onAlive();
    com.tencent.matrix.g.c.i("Matrix.StartupTracer", "[onAlive] isStartupEnable:%s", new Object[] { Boolean.valueOf(this.cAW) });
    if (this.cAW)
    {
      AppMethodBeat.getInstance().addListener(this);
      com.tencent.matrix.b.Gq().application.registerActivityLifecycleCallbacks(this);
    }
  }
  
  protected final void onDead()
  {
    super.onDead();
    if (this.cAW)
    {
      AppMethodBeat.getInstance().removeListener(this);
      com.tencent.matrix.b.Gq().application.unregisterActivityLifecycleCallbacks(this);
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
      com.tencent.matrix.g.c.i("Matrix.StartupTracer", "callback %s", new Object[] { (Handler.Callback)((Field)localObject2).get(localObject1) });
      return;
    }
    catch (Exception localException) {}
  }
  
  final class a
    implements Runnable
  {
    long cAR;
    boolean cAU;
    long[] cAf;
    long cBd;
    long cBe;
    int scene;
    
    a(long[] paramArrayOfLong, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, int paramInt)
    {
      this.cAf = paramArrayOfLong;
      this.scene = paramInt;
      this.cBd = paramLong1;
      this.cAR = paramLong2;
      this.cBe = paramLong3;
      this.cAU = paramBoolean;
    }
    
    public final void run()
    {
      Object localObject2 = new LinkedList();
      if (this.cAf.length > 0)
      {
        com.tencent.matrix.trace.g.a.a(this.cAf, (LinkedList)localObject2, false, -1L);
        com.tencent.matrix.trace.g.a.a((List)localObject2, new com.tencent.matrix.trace.g.a.a()
        {
          public final boolean b(long paramAnonymousLong, int paramAnonymousInt)
          {
            return paramAnonymousLong < paramAnonymousInt * 5;
          }
          
          public final void d(List<com.tencent.matrix.trace.d.a> paramAnonymousList, int paramAnonymousInt)
          {
            com.tencent.matrix.g.c.w("Matrix.StartupTracer", "[fallback] size:%s targetSize:%s stack:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(30), paramAnonymousList });
            paramAnonymousList = paramAnonymousList.listIterator(Math.min(paramAnonymousInt, 30));
            while (paramAnonymousList.hasNext())
            {
              paramAnonymousList.next();
              paramAnonymousList.remove();
            }
          }
        });
      }
      Object localObject1 = new StringBuilder();
      Object localObject3 = new StringBuilder();
      long l1 = Math.max(this.cBe, com.tencent.matrix.trace.g.a.a((LinkedList)localObject2, (StringBuilder)localObject1, (StringBuilder)localObject3));
      localObject2 = com.tencent.matrix.trace.g.a.a((List)localObject2, l1);
      if (((this.cBe > e.a(e.this)) && (!this.cAU)) || ((this.cBe > e.b(e.this)) && (this.cAU))) {
        com.tencent.matrix.g.c.w("Matrix.StartupTracer", "stackKey:%s \n%s", new Object[] { localObject2, ((StringBuilder)localObject3).toString() });
      }
      long l2 = this.cBd;
      long l3 = this.cAR;
      boolean bool = this.cAU;
      int i = this.scene;
      localObject3 = (com.tencent.matrix.trace.a)com.tencent.matrix.b.Gq().V(com.tencent.matrix.trace.a.class);
      if (localObject3 == null) {}
      for (;;)
      {
        return;
        try
        {
          JSONObject localJSONObject = com.tencent.matrix.g.a.a(new JSONObject(), com.tencent.matrix.b.Gq().application);
          localJSONObject.put("application_create", l2);
          localJSONObject.put("application_create_scene", i);
          localJSONObject.put("first_activity_create", l3);
          localJSONObject.put("startup_duration", l1);
          localJSONObject.put("is_warm_start_up", bool);
          com.tencent.matrix.report.c localc = new com.tencent.matrix.report.c();
          localc.tag = "Trace_StartUp";
          localc.cue = localJSONObject;
          ((com.tencent.matrix.trace.a)localObject3).onDetectIssue(localc);
          if (((l1 <= e.a(e.this)) || (bool)) && ((l1 <= e.b(e.this)) || (!bool))) {
            continue;
          }
          try
          {
            localJSONObject = com.tencent.matrix.g.a.a(new JSONObject(), com.tencent.matrix.b.Gq().application);
            localJSONObject.put("detail", com.tencent.matrix.trace.b.a.a.cyT);
            localJSONObject.put("cost", l1);
            localJSONObject.put("stack", ((StringBuilder)localObject1).toString());
            localJSONObject.put("stackKey", localObject2);
            if (bool)
            {
              i = 2;
              localJSONObject.put("subType", i);
              localObject1 = new com.tencent.matrix.report.c();
              ((com.tencent.matrix.report.c)localObject1).tag = "Trace_EvilMethod";
              ((com.tencent.matrix.report.c)localObject1).cue = localJSONObject;
              ((com.tencent.matrix.trace.a)localObject3).onDetectIssue((com.tencent.matrix.report.c)localObject1);
              return;
            }
          }
          catch (JSONException localJSONException1)
          {
            com.tencent.matrix.g.c.e("Matrix.StartupTracer", "[JSONException error: %s", new Object[] { localJSONException1 });
            return;
          }
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            com.tencent.matrix.g.c.e("Matrix.StartupTracer", "[JSONException for StartUpReportTask error: %s", new Object[] { localJSONException2 });
            continue;
            i = 1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.f.e
 * JD-Core Version:    0.7.0.1
 */