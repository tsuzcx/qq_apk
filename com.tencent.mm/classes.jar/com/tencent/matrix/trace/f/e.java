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
  private boolean cKt;
  private final com.tencent.matrix.trace.a.b cKu;
  private long cMA = 0L;
  private int cMB;
  private boolean cMC;
  private boolean cMD;
  private boolean cME;
  private Set<String> cMF;
  private long cMG;
  private long cMH;
  private long cMI = 0L;
  private HashMap<String, Long> cMJ = new HashMap();
  private boolean cMK = true;
  private long cMz = 0L;
  
  public e(com.tencent.matrix.trace.a.b paramb)
  {
    this.cKu = paramb;
    this.cME = paramb.cKo;
    if (paramb.cKs == null)
    {
      paramb.cKs = new HashSet();
      if (paramb.cET != null) {
        break label157;
      }
      if (paramb.cKr != null) {
        paramb.cKs.addAll(Arrays.asList(paramb.cKr.split(";")));
      }
    }
    this.cMF = paramb.cKs;
    if (paramb.cET == null)
    {
      label121:
      this.cMG = i;
      if (paramb.cET != null) {
        break label240;
      }
    }
    label157:
    label240:
    for (i = 4000;; i = paramb.cET.get(com.tencent.c.a.a.a.LZE.name(), 4000))
    {
      this.cMH = i;
      this.cKt = paramb.cKt;
      com.tencent.matrix.trace.c.a.a(this);
      return;
      String str = paramb.cET.get(com.tencent.c.a.a.a.LZt.name(), paramb.cKr);
      if (str != null) {
        paramb.cKr = str;
      }
      if (paramb.cKr == null) {
        break;
      }
      paramb.cKs.addAll(Arrays.asList(paramb.cKr.split(";")));
      break;
      i = paramb.cET.get(com.tencent.c.a.a.a.LZD.name(), 10000);
      break label121;
    }
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    com.tencent.matrix.g.c.i("Matrix.StartupTracer", "[report] applicationCost:%s firstScreenCost:%s allCost:%s isWarmStartUp:%s, createScene:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Boolean.valueOf(paramBoolean), Integer.valueOf(com.tencent.matrix.trace.c.a.cLg) });
    long[] arrayOfLong2 = new long[0];
    long[] arrayOfLong1;
    if ((!paramBoolean) && (paramLong3 >= this.cMG))
    {
      arrayOfLong1 = AppMethodBeat.getInstance().copyData(com.tencent.matrix.trace.c.a.cLf);
      com.tencent.matrix.trace.c.a.cLf.release();
    }
    for (;;)
    {
      com.tencent.matrix.g.b.JC().post(new a(arrayOfLong1, paramLong1, paramLong2, paramLong3, paramBoolean, com.tencent.matrix.trace.c.a.cLg));
      return;
      arrayOfLong1 = arrayOfLong2;
      if (paramBoolean)
      {
        arrayOfLong1 = arrayOfLong2;
        if (paramLong3 >= this.cMH)
        {
          arrayOfLong1 = AppMethodBeat.getInstance().copyData(com.tencent.matrix.trace.c.a.cLe);
          com.tencent.matrix.trace.c.a.cLe.release();
        }
      }
    }
  }
  
  public final void Jo()
  {
    if (!this.cKt)
    {
      long l = com.tencent.matrix.trace.c.a.Jk();
      com.tencent.matrix.g.c.i("Matrix.StartupTracer", "onApplicationCreateEnd, applicationCost:%d", new Object[] { Long.valueOf(l) });
      a(l, 0L, l, false);
    }
  }
  
  public final void n(Activity paramActivity)
  {
    if (com.tencent.matrix.trace.c.a.cLg == -2147483648) {
      return;
    }
    Object localObject = paramActivity.getClass().getName();
    int i;
    boolean bool;
    String str;
    if (this.cMA == 0L)
    {
      i = 1;
      if (i == 0) {
        break label436;
      }
      bool = com.tencent.matrix.trace.c.a.Jm();
      com.tencent.matrix.g.c.i("Matrix.StartupTracer", "#ColdStartup# activity:%s, splashActivities:%s, empty:%b, isCreatedByLaunchActivity:%b, hasShowSplashActivity:%b, firstScreenCost:%d, now:%d, application_create_begin_time:%d, app_cost:%d", new Object[] { localObject, this.cMF, Boolean.valueOf(this.cMF.isEmpty()), Boolean.valueOf(bool), Boolean.valueOf(this.cMD), Long.valueOf(this.cMz), Long.valueOf(SystemClock.uptimeMillis()), Long.valueOf(com.tencent.matrix.trace.c.a.Jl()), Long.valueOf(com.tencent.matrix.trace.c.a.Jk()) });
      str = (String)localObject + "@" + paramActivity.hashCode();
      paramActivity = (Long)this.cMJ.get(str);
      if (paramActivity != null) {
        break label519;
      }
      paramActivity = Long.valueOf(0L);
    }
    label519:
    for (;;)
    {
      this.cMJ.put(str, Long.valueOf(SystemClock.uptimeMillis() - paramActivity.longValue()));
      if (this.cMz == 0L) {
        this.cMz = (SystemClock.uptimeMillis() - com.tencent.matrix.trace.c.a.Jl());
      }
      if (this.cMD) {
        this.cMA = (SystemClock.uptimeMillis() - com.tencent.matrix.trace.c.a.Jl());
      }
      for (;;)
      {
        if (this.cMA <= 0L) {
          break label417;
        }
        localObject = (Long)this.cMJ.get(str);
        if ((localObject == null) || (((Long)localObject).longValue() < 30000L)) {
          break label419;
        }
        com.tencent.matrix.g.c.e("Matrix.StartupTracer", "%s cost too much time[%s] between activity create and onActivityFocused, just throw it.(createTime:%s) ", new Object[] { str, Long.valueOf(SystemClock.uptimeMillis() - paramActivity.longValue()), paramActivity });
        return;
        i = 0;
        break;
        if (this.cMF.contains(localObject))
        {
          this.cMD = true;
        }
        else if (this.cMF.isEmpty())
        {
          if (bool)
          {
            this.cMA = this.cMz;
          }
          else
          {
            this.cMz = 0L;
            this.cMA = com.tencent.matrix.trace.c.a.Jk();
          }
        }
        else if (bool)
        {
          this.cMA = this.cMz;
        }
        else
        {
          this.cMz = 0L;
          this.cMA = com.tencent.matrix.trace.c.a.Jk();
        }
      }
      label417:
      break;
      label419:
      a(com.tencent.matrix.trace.c.a.Jk(), this.cMz, this.cMA, false);
      return;
      label436:
      if (!this.cMC) {
        break;
      }
      this.cMC = false;
      long l = SystemClock.uptimeMillis() - this.cMI;
      com.tencent.matrix.g.c.i("Matrix.StartupTracer", "#WarmStartup# activity:%s, warmCost:%d, now:%d, lastCreateActivity:%d", new Object[] { localObject, Long.valueOf(l), Long.valueOf(SystemClock.uptimeMillis()), Long.valueOf(this.cMI) });
      if (l <= 0L) {
        break;
      }
      a(0L, 0L, l, true);
      return;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    com.tencent.matrix.g.c.i("Matrix.StartupTracer", "activeActivityCount:%d, coldCost:%d", new Object[] { Integer.valueOf(this.cMB), Long.valueOf(this.cMA) });
    if ((this.cMB == 0) && (this.cMA > 0L))
    {
      this.cMI = SystemClock.uptimeMillis();
      com.tencent.matrix.g.c.i("Matrix.StartupTracer", "lastCreateActivity:%d, activity:%s", new Object[] { Long.valueOf(this.cMI), paramActivity.getClass().getName() });
      this.cMC = true;
    }
    this.cMB += 1;
    if (this.cMK) {
      this.cMJ.put(paramActivity.getClass().getName() + "@" + paramActivity.hashCode(), Long.valueOf(SystemClock.uptimeMillis()));
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    com.tencent.matrix.g.c.i("Matrix.StartupTracer", "activeActivityCount:%d", new Object[] { Integer.valueOf(this.cMB) });
    this.cMB -= 1;
  }
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  protected final void onAlive()
  {
    super.onAlive();
    com.tencent.matrix.g.c.i("Matrix.StartupTracer", "[onAlive] isStartupEnable:%s", new Object[] { Boolean.valueOf(this.cME) });
    if (this.cME)
    {
      AppMethodBeat.getInstance().addListener(this);
      com.tencent.matrix.b.HT().application.registerActivityLifecycleCallbacks(this);
    }
  }
  
  protected final void onDead()
  {
    super.onDead();
    if (this.cME)
    {
      AppMethodBeat.getInstance().removeListener(this);
      com.tencent.matrix.b.HT().application.unregisterActivityLifecycleCallbacks(this);
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
    boolean cMC;
    long cML;
    long cMM;
    long cMz;
    long[] data;
    int scene;
    
    a(long[] paramArrayOfLong, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, int paramInt)
    {
      this.data = paramArrayOfLong;
      this.scene = paramInt;
      this.cML = paramLong1;
      this.cMz = paramLong2;
      this.cMM = paramLong3;
      this.cMC = paramBoolean;
    }
    
    public final void run()
    {
      Object localObject2 = new LinkedList();
      if (this.data.length > 0)
      {
        com.tencent.matrix.trace.g.a.a(this.data, (LinkedList)localObject2, false, -1L);
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
      long l1 = Math.max(this.cMM, com.tencent.matrix.trace.g.a.a((LinkedList)localObject2, (StringBuilder)localObject1, (StringBuilder)localObject3));
      localObject2 = com.tencent.matrix.trace.g.a.a((List)localObject2, l1);
      if (((this.cMM > e.a(e.this)) && (!this.cMC)) || ((this.cMM > e.b(e.this)) && (this.cMC))) {
        com.tencent.matrix.g.c.w("Matrix.StartupTracer", "stackKey:%s \n%s", new Object[] { localObject2, ((StringBuilder)localObject3).toString() });
      }
      long l2 = this.cML;
      long l3 = this.cMz;
      boolean bool = this.cMC;
      int i = this.scene;
      localObject3 = (com.tencent.matrix.trace.a)com.tencent.matrix.b.HT().V(com.tencent.matrix.trace.a.class);
      if (localObject3 == null) {}
      for (;;)
      {
        return;
        try
        {
          JSONObject localJSONObject = com.tencent.matrix.g.a.a(new JSONObject(), com.tencent.matrix.b.HT().application);
          localJSONObject.put("application_create", l2);
          localJSONObject.put("application_create_scene", i);
          localJSONObject.put("first_activity_create", l3);
          localJSONObject.put("startup_duration", l1);
          localJSONObject.put("is_warm_start_up", bool);
          com.tencent.matrix.report.c localc = new com.tencent.matrix.report.c();
          localc.tag = "Trace_StartUp";
          localc.cFG = localJSONObject;
          ((com.tencent.matrix.trace.a)localObject3).onDetectIssue(localc);
          if (((l1 <= e.a(e.this)) || (bool)) && ((l1 <= e.b(e.this)) || (!bool))) {
            continue;
          }
          try
          {
            localJSONObject = com.tencent.matrix.g.a.a(new JSONObject(), com.tencent.matrix.b.HT().application);
            localJSONObject.put("detail", com.tencent.matrix.trace.b.a.a.cKx);
            localJSONObject.put("cost", l1);
            localJSONObject.put("stack", ((StringBuilder)localObject1).toString());
            localJSONObject.put("stackKey", localObject2);
            if (bool)
            {
              i = 2;
              localJSONObject.put("subType", i);
              localObject1 = new com.tencent.matrix.report.c();
              ((com.tencent.matrix.report.c)localObject1).tag = "Trace_EvilMethod";
              ((com.tencent.matrix.report.c)localObject1).cFG = localJSONObject;
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