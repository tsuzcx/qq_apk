package com.tencent.matrix.trace.tracer;

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
import com.tencent.matrix.trace.f.b.a;
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

public final class f
  extends g
  implements Application.ActivityLifecycleCallbacks, a.b, com.tencent.matrix.trace.e.a
{
  private boolean fdS;
  private final com.tencent.matrix.trace.a.b fdU;
  private long fgI = 0L;
  private long fgJ = 0L;
  private int fgK;
  private boolean fgL;
  private boolean fgM;
  private boolean fgN;
  private Set<String> fgO;
  private long fgP;
  private long fgQ;
  private long fgR = 0L;
  private HashMap<String, Long> fgS = new HashMap();
  private boolean fgT = true;
  
  public f(com.tencent.matrix.trace.a.b paramb)
  {
    this.fdU = paramb;
    this.fgN = paramb.fdD;
    if (paramb.fdP == null)
    {
      paramb.fdP = new HashSet();
      if (paramb.fbi != null) {
        break label157;
      }
      if (paramb.fdO != null) {
        paramb.fdP.addAll(Arrays.asList(paramb.fdO.split(";")));
      }
    }
    this.fgO = paramb.fdP;
    if (paramb.fbi == null)
    {
      label121:
      this.fgP = i;
      if (paramb.fbi != null) {
        break label240;
      }
    }
    label157:
    label240:
    for (i = 4000;; i = paramb.fbi.L(com.tencent.b.a.a.a.ahaj.name(), 4000))
    {
      this.fgQ = i;
      this.fdS = paramb.fdS;
      com.tencent.matrix.trace.c.a.a(this);
      return;
      String str = paramb.fbi.O(com.tencent.b.a.a.a.agZY.name(), paramb.fdO);
      if (str != null) {
        paramb.fdO = str;
      }
      if (paramb.fdO == null) {
        break;
      }
      paramb.fdP.addAll(Arrays.asList(paramb.fdO.split(";")));
      break;
      i = paramb.fbi.L(com.tencent.b.a.a.a.ahai.name(), 10000);
      break label121;
    }
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    com.tencent.matrix.e.c.i("Matrix.StartupTracer", "[report] applicationCost:%s firstScreenCost:%s allCost:%s isWarmStartUp:%s, createScene:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Boolean.valueOf(paramBoolean), Integer.valueOf(com.tencent.matrix.trace.c.a.feV) });
    long[] arrayOfLong2 = new long[0];
    long[] arrayOfLong1;
    if ((!paramBoolean) && (paramLong3 >= this.fgP))
    {
      arrayOfLong1 = AppMethodBeat.getInstance().copyData(com.tencent.matrix.trace.c.a.feU);
      com.tencent.matrix.trace.c.a.feU.release();
    }
    for (;;)
    {
      com.tencent.matrix.e.b.aAp().post(new a(arrayOfLong1, paramLong1, paramLong2, paramLong3, paramBoolean, com.tencent.matrix.trace.c.a.feV));
      return;
      arrayOfLong1 = arrayOfLong2;
      if (paramBoolean)
      {
        arrayOfLong1 = arrayOfLong2;
        if (paramLong3 >= this.fgQ)
        {
          arrayOfLong1 = AppMethodBeat.getInstance().copyData(com.tencent.matrix.trace.c.a.feT);
          com.tencent.matrix.trace.c.a.feT.release();
        }
      }
    }
  }
  
  public final void azR()
  {
    if (!this.fdS)
    {
      long l = com.tencent.matrix.trace.c.a.azN();
      com.tencent.matrix.e.c.i("Matrix.StartupTracer", "onApplicationCreateEnd, applicationCost:%d", new Object[] { Long.valueOf(l) });
      a(l, 0L, l, false);
    }
  }
  
  public final void n(Activity paramActivity)
  {
    if (com.tencent.matrix.trace.c.a.feV == -2147483648) {
      return;
    }
    Object localObject = paramActivity.getClass().getName();
    int i;
    boolean bool;
    String str;
    if (this.fgJ == 0L)
    {
      i = 1;
      if (i == 0) {
        break label436;
      }
      bool = com.tencent.matrix.trace.c.a.azP();
      com.tencent.matrix.e.c.i("Matrix.StartupTracer", "#ColdStartup# activity:%s, splashActivities:%s, empty:%b, isCreatedByLaunchActivity:%b, hasShowSplashActivity:%b, firstScreenCost:%d, now:%d, application_create_begin_time:%d, app_cost:%d", new Object[] { localObject, this.fgO, Boolean.valueOf(this.fgO.isEmpty()), Boolean.valueOf(bool), Boolean.valueOf(this.fgM), Long.valueOf(this.fgI), Long.valueOf(SystemClock.uptimeMillis()), Long.valueOf(com.tencent.matrix.trace.c.a.azO()), Long.valueOf(com.tencent.matrix.trace.c.a.azN()) });
      str = (String)localObject + "@" + paramActivity.hashCode();
      paramActivity = (Long)this.fgS.get(str);
      if (paramActivity != null) {
        break label519;
      }
      paramActivity = Long.valueOf(0L);
    }
    label519:
    for (;;)
    {
      this.fgS.put(str, Long.valueOf(SystemClock.uptimeMillis() - paramActivity.longValue()));
      if (this.fgI == 0L) {
        this.fgI = (SystemClock.uptimeMillis() - com.tencent.matrix.trace.c.a.azO());
      }
      if (this.fgM) {
        this.fgJ = (SystemClock.uptimeMillis() - com.tencent.matrix.trace.c.a.azO());
      }
      for (;;)
      {
        if (this.fgJ <= 0L) {
          break label417;
        }
        localObject = (Long)this.fgS.get(str);
        if ((localObject == null) || (((Long)localObject).longValue() < 30000L)) {
          break label419;
        }
        com.tencent.matrix.e.c.e("Matrix.StartupTracer", "%s cost too much time[%s] between activity create and onActivityFocused, just throw it.(createTime:%s) ", new Object[] { str, Long.valueOf(SystemClock.uptimeMillis() - paramActivity.longValue()), paramActivity });
        return;
        i = 0;
        break;
        if (this.fgO.contains(localObject))
        {
          this.fgM = true;
        }
        else if (this.fgO.isEmpty())
        {
          if (bool)
          {
            this.fgJ = this.fgI;
          }
          else
          {
            this.fgI = 0L;
            this.fgJ = com.tencent.matrix.trace.c.a.azN();
          }
        }
        else if (bool)
        {
          this.fgJ = this.fgI;
        }
        else
        {
          this.fgI = 0L;
          this.fgJ = com.tencent.matrix.trace.c.a.azN();
        }
      }
      label417:
      break;
      label419:
      a(com.tencent.matrix.trace.c.a.azN(), this.fgI, this.fgJ, false);
      return;
      label436:
      if (!this.fgL) {
        break;
      }
      this.fgL = false;
      long l = SystemClock.uptimeMillis() - this.fgR;
      com.tencent.matrix.e.c.i("Matrix.StartupTracer", "#WarmStartup# activity:%s, warmCost:%d, now:%d, lastCreateActivity:%d", new Object[] { localObject, Long.valueOf(l), Long.valueOf(SystemClock.uptimeMillis()), Long.valueOf(this.fgR) });
      if (l <= 0L) {
        break;
      }
      a(0L, 0L, l, true);
      return;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    com.tencent.matrix.e.c.i("Matrix.StartupTracer", "activeActivityCount:%d, coldCost:%d", new Object[] { Integer.valueOf(this.fgK), Long.valueOf(this.fgJ) });
    if ((this.fgK == 0) && (this.fgJ > 0L))
    {
      this.fgR = SystemClock.uptimeMillis();
      com.tencent.matrix.e.c.i("Matrix.StartupTracer", "lastCreateActivity:%d, activity:%s", new Object[] { Long.valueOf(this.fgR), paramActivity.getClass().getName() });
      this.fgL = true;
    }
    this.fgK += 1;
    if (this.fgT) {
      this.fgS.put(paramActivity.getClass().getName() + "@" + paramActivity.hashCode(), Long.valueOf(SystemClock.uptimeMillis()));
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    com.tencent.matrix.e.c.i("Matrix.StartupTracer", "activeActivityCount:%d", new Object[] { Integer.valueOf(this.fgK) });
    this.fgK -= 1;
  }
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  protected final void onAlive()
  {
    super.onAlive();
    com.tencent.matrix.e.c.i("Matrix.StartupTracer", "[onAlive] isStartupEnable:%s", new Object[] { Boolean.valueOf(this.fgN) });
    if (this.fgN)
    {
      AppMethodBeat.getInstance().addListener(this);
      com.tencent.matrix.c.avW().application.registerActivityLifecycleCallbacks(this);
    }
  }
  
  protected final void onDead()
  {
    super.onDead();
    if (this.fgN)
    {
      AppMethodBeat.getInstance().removeListener(this);
      com.tencent.matrix.c.avW().application.unregisterActivityLifecycleCallbacks(this);
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
      com.tencent.matrix.e.c.i("Matrix.StartupTracer", "callback %s", new Object[] { (Handler.Callback)((Field)localObject2).get(localObject1) });
      return;
    }
    catch (Exception localException) {}
  }
  
  final class a
    implements Runnable
  {
    long[] fft;
    long fgI;
    boolean fgL;
    long fgU;
    long fgV;
    int scene;
    
    a(long[] paramArrayOfLong, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, int paramInt)
    {
      this.fft = paramArrayOfLong;
      this.scene = paramInt;
      this.fgU = paramLong1;
      this.fgI = paramLong2;
      this.fgV = paramLong3;
      this.fgL = paramBoolean;
    }
    
    public final void run()
    {
      Object localObject2 = new LinkedList();
      if (this.fft.length > 0)
      {
        com.tencent.matrix.trace.f.b.a(this.fft, (LinkedList)localObject2, false, -1L);
        com.tencent.matrix.trace.f.b.a((List)localObject2, new b.a()
        {
          public final int azV()
          {
            return 60;
          }
          
          public final boolean k(long paramAnonymousLong, int paramAnonymousInt)
          {
            return paramAnonymousLong < paramAnonymousInt * 5;
          }
          
          public final void l(List<com.tencent.matrix.trace.d.a> paramAnonymousList, int paramAnonymousInt)
          {
            com.tencent.matrix.e.c.w("Matrix.StartupTracer", "[fallback] size:%s targetSize:%s stack:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(30), paramAnonymousList });
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
      long l1 = Math.max(this.fgV, com.tencent.matrix.trace.f.b.a((LinkedList)localObject2, (StringBuilder)localObject1, (StringBuilder)localObject3));
      localObject2 = com.tencent.matrix.trace.f.b.b((List)localObject2, l1);
      if (((this.fgV > f.a(f.this)) && (!this.fgL)) || ((this.fgV > f.b(f.this)) && (this.fgL))) {
        com.tencent.matrix.e.c.w("Matrix.StartupTracer", "stackKey:%s \n%s", new Object[] { localObject2, ((StringBuilder)localObject3).toString() });
      }
      long l2 = this.fgU;
      long l3 = this.fgI;
      boolean bool = this.fgL;
      int i = this.scene;
      localObject3 = (com.tencent.matrix.trace.b)com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class);
      if (localObject3 == null) {}
      for (;;)
      {
        return;
        try
        {
          JSONObject localJSONObject = com.tencent.matrix.e.a.a(new JSONObject(), com.tencent.matrix.c.avW().application);
          localJSONObject.put("application_create", l2);
          localJSONObject.put("application_create_scene", i);
          localJSONObject.put("first_activity_create", l3);
          localJSONObject.put("startup_duration", l1);
          localJSONObject.put("is_warm_start_up", bool);
          com.tencent.matrix.report.g localg = new com.tencent.matrix.report.g();
          localg.tag = "Trace_StartUp";
          localg.eYz = localJSONObject;
          ((com.tencent.matrix.trace.b)localObject3).onDetectIssue(localg);
          if (((l1 <= f.a(f.this)) || (bool)) && ((l1 <= f.b(f.this)) || (!bool))) {
            continue;
          }
          try
          {
            localJSONObject = com.tencent.matrix.e.a.a(new JSONObject(), com.tencent.matrix.c.avW().application);
            localJSONObject.put("detail", com.tencent.matrix.trace.b.a.a.fdX);
            localJSONObject.put("cost", l1);
            localJSONObject.put("stack", ((StringBuilder)localObject1).toString());
            localJSONObject.put("stackKey", localObject2);
            if (bool)
            {
              i = 2;
              localJSONObject.put("subType", i);
              localObject1 = new com.tencent.matrix.report.g();
              ((com.tencent.matrix.report.g)localObject1).tag = "Trace_EvilMethod";
              ((com.tencent.matrix.report.g)localObject1).eYz = localJSONObject;
              ((com.tencent.matrix.trace.b)localObject3).onDetectIssue((com.tencent.matrix.report.g)localObject1);
              return;
            }
          }
          catch (JSONException localJSONException1)
          {
            com.tencent.matrix.e.c.e("Matrix.StartupTracer", "[JSONException error: %s", new Object[] { localJSONException1 });
            return;
          }
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            com.tencent.matrix.e.c.e("Matrix.StartupTracer", "[JSONException for StartUpReportTask error: %s", new Object[] { localJSONException2 });
            continue;
            i = 1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.trace.tracer.f
 * JD-Core Version:    0.7.0.1
 */