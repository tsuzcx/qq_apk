package com.tencent.matrix.trace.f;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.SystemClock;
import com.tencent.matrix.e.c;
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
  private boolean deU;
  private final com.tencent.matrix.trace.a.b deV;
  private long dha = 0L;
  private long dhb = 0L;
  private int dhc;
  private boolean dhd;
  private boolean dhe;
  private boolean dhf;
  private Set<String> dhg;
  private long dhh;
  private long dhi;
  private long dhj = 0L;
  private HashMap<String, Long> dhk = new HashMap();
  private boolean dhl = true;
  
  public e(com.tencent.matrix.trace.a.b paramb)
  {
    this.deV = paramb;
    this.dhf = paramb.deO;
    if (paramb.deT == null)
    {
      paramb.deT = new HashSet();
      if (paramb.dcH != null) {
        break label157;
      }
      if (paramb.deS != null) {
        paramb.deT.addAll(Arrays.asList(paramb.deS.split(";")));
      }
    }
    this.dhg = paramb.deT;
    if (paramb.dcH == null)
    {
      label121:
      this.dhh = i;
      if (paramb.dcH != null) {
        break label240;
      }
    }
    label157:
    label240:
    for (i = 4000;; i = paramb.dcH.D(com.tencent.b.a.a.a.ZbC.name(), 4000))
    {
      this.dhi = i;
      this.deU = paramb.deU;
      com.tencent.matrix.trace.c.a.a(this);
      return;
      String str = paramb.dcH.L(com.tencent.b.a.a.a.Zbr.name(), paramb.deS);
      if (str != null) {
        paramb.deS = str;
      }
      if (paramb.deS == null) {
        break;
      }
      paramb.deT.addAll(Arrays.asList(paramb.deS.split(";")));
      break;
      i = paramb.dcH.D(com.tencent.b.a.a.a.ZbB.name(), 10000);
      break label121;
    }
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    c.i("Matrix.StartupTracer", "[report] applicationCost:%s firstScreenCost:%s allCost:%s isWarmStartUp:%s, createScene:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Boolean.valueOf(paramBoolean), Integer.valueOf(com.tencent.matrix.trace.c.a.dfG) });
    long[] arrayOfLong2 = new long[0];
    long[] arrayOfLong1;
    if ((!paramBoolean) && (paramLong3 >= this.dhh))
    {
      arrayOfLong1 = AppMethodBeat.getInstance().copyData(com.tencent.matrix.trace.c.a.dfF);
      com.tencent.matrix.trace.c.a.dfF.release();
    }
    for (;;)
    {
      com.tencent.matrix.e.b.Yu().post(new a(arrayOfLong1, paramLong1, paramLong2, paramLong3, paramBoolean, com.tencent.matrix.trace.c.a.dfG));
      return;
      arrayOfLong1 = arrayOfLong2;
      if (paramBoolean)
      {
        arrayOfLong1 = arrayOfLong2;
        if (paramLong3 >= this.dhi)
        {
          arrayOfLong1 = AppMethodBeat.getInstance().copyData(com.tencent.matrix.trace.c.a.dfE);
          com.tencent.matrix.trace.c.a.dfE.release();
        }
      }
    }
  }
  
  public final void Yg()
  {
    if (!this.deU)
    {
      long l = com.tencent.matrix.trace.c.a.Yc();
      c.i("Matrix.StartupTracer", "onApplicationCreateEnd, applicationCost:%d", new Object[] { Long.valueOf(l) });
      a(l, 0L, l, false);
    }
  }
  
  public final void m(Activity paramActivity)
  {
    if (com.tencent.matrix.trace.c.a.dfG == -2147483648) {
      return;
    }
    Object localObject = paramActivity.getClass().getName();
    int i;
    boolean bool;
    String str;
    if (this.dhb == 0L)
    {
      i = 1;
      if (i == 0) {
        break label436;
      }
      bool = com.tencent.matrix.trace.c.a.Ye();
      c.i("Matrix.StartupTracer", "#ColdStartup# activity:%s, splashActivities:%s, empty:%b, isCreatedByLaunchActivity:%b, hasShowSplashActivity:%b, firstScreenCost:%d, now:%d, application_create_begin_time:%d, app_cost:%d", new Object[] { localObject, this.dhg, Boolean.valueOf(this.dhg.isEmpty()), Boolean.valueOf(bool), Boolean.valueOf(this.dhe), Long.valueOf(this.dha), Long.valueOf(SystemClock.uptimeMillis()), Long.valueOf(com.tencent.matrix.trace.c.a.Yd()), Long.valueOf(com.tencent.matrix.trace.c.a.Yc()) });
      str = (String)localObject + "@" + paramActivity.hashCode();
      paramActivity = (Long)this.dhk.get(str);
      if (paramActivity != null) {
        break label519;
      }
      paramActivity = Long.valueOf(0L);
    }
    label519:
    for (;;)
    {
      this.dhk.put(str, Long.valueOf(SystemClock.uptimeMillis() - paramActivity.longValue()));
      if (this.dha == 0L) {
        this.dha = (SystemClock.uptimeMillis() - com.tencent.matrix.trace.c.a.Yd());
      }
      if (this.dhe) {
        this.dhb = (SystemClock.uptimeMillis() - com.tencent.matrix.trace.c.a.Yd());
      }
      for (;;)
      {
        if (this.dhb <= 0L) {
          break label417;
        }
        localObject = (Long)this.dhk.get(str);
        if ((localObject == null) || (((Long)localObject).longValue() < 30000L)) {
          break label419;
        }
        c.e("Matrix.StartupTracer", "%s cost too much time[%s] between activity create and onActivityFocused, just throw it.(createTime:%s) ", new Object[] { str, Long.valueOf(SystemClock.uptimeMillis() - paramActivity.longValue()), paramActivity });
        return;
        i = 0;
        break;
        if (this.dhg.contains(localObject))
        {
          this.dhe = true;
        }
        else if (this.dhg.isEmpty())
        {
          if (bool)
          {
            this.dhb = this.dha;
          }
          else
          {
            this.dha = 0L;
            this.dhb = com.tencent.matrix.trace.c.a.Yc();
          }
        }
        else if (bool)
        {
          this.dhb = this.dha;
        }
        else
        {
          this.dha = 0L;
          this.dhb = com.tencent.matrix.trace.c.a.Yc();
        }
      }
      label417:
      break;
      label419:
      a(com.tencent.matrix.trace.c.a.Yc(), this.dha, this.dhb, false);
      return;
      label436:
      if (!this.dhd) {
        break;
      }
      this.dhd = false;
      long l = SystemClock.uptimeMillis() - this.dhj;
      c.i("Matrix.StartupTracer", "#WarmStartup# activity:%s, warmCost:%d, now:%d, lastCreateActivity:%d", new Object[] { localObject, Long.valueOf(l), Long.valueOf(SystemClock.uptimeMillis()), Long.valueOf(this.dhj) });
      if (l <= 0L) {
        break;
      }
      a(0L, 0L, l, true);
      return;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    c.i("Matrix.StartupTracer", "activeActivityCount:%d, coldCost:%d", new Object[] { Integer.valueOf(this.dhc), Long.valueOf(this.dhb) });
    if ((this.dhc == 0) && (this.dhb > 0L))
    {
      this.dhj = SystemClock.uptimeMillis();
      c.i("Matrix.StartupTracer", "lastCreateActivity:%d, activity:%s", new Object[] { Long.valueOf(this.dhj), paramActivity.getClass().getName() });
      this.dhd = true;
    }
    this.dhc += 1;
    if (this.dhl) {
      this.dhk.put(paramActivity.getClass().getName() + "@" + paramActivity.hashCode(), Long.valueOf(SystemClock.uptimeMillis()));
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    c.i("Matrix.StartupTracer", "activeActivityCount:%d", new Object[] { Integer.valueOf(this.dhc) });
    this.dhc -= 1;
  }
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  protected final void onAlive()
  {
    super.onAlive();
    c.i("Matrix.StartupTracer", "[onAlive] isStartupEnable:%s", new Object[] { Boolean.valueOf(this.dhf) });
    if (this.dhf)
    {
      AppMethodBeat.getInstance().addListener(this);
      com.tencent.matrix.b.Vu().application.registerActivityLifecycleCallbacks(this);
    }
  }
  
  protected final void onDead()
  {
    super.onDead();
    if (this.dhf)
    {
      AppMethodBeat.getInstance().removeListener(this);
      com.tencent.matrix.b.Vu().application.unregisterActivityLifecycleCallbacks(this);
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
  
  final class a
    implements Runnable
  {
    long[] data;
    long dha;
    boolean dhd;
    long dhm;
    long dhn;
    int scene;
    
    a(long[] paramArrayOfLong, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, int paramInt)
    {
      this.data = paramArrayOfLong;
      this.scene = paramInt;
      this.dhm = paramLong1;
      this.dha = paramLong2;
      this.dhn = paramLong3;
      this.dhd = paramBoolean;
    }
    
    public final void run()
    {
      Object localObject2 = new LinkedList();
      if (this.data.length > 0)
      {
        com.tencent.matrix.trace.g.a.a(this.data, (LinkedList)localObject2, false, -1L);
        com.tencent.matrix.trace.g.a.a((List)localObject2, new com.tencent.matrix.trace.g.a.a()
        {
          public final boolean c(long paramAnonymousLong, int paramAnonymousInt)
          {
            return paramAnonymousLong < paramAnonymousInt * 5;
          }
          
          public final void d(List<com.tencent.matrix.trace.d.a> paramAnonymousList, int paramAnonymousInt)
          {
            c.w("Matrix.StartupTracer", "[fallback] size:%s targetSize:%s stack:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(30), paramAnonymousList });
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
      long l1 = Math.max(this.dhn, com.tencent.matrix.trace.g.a.a((LinkedList)localObject2, (StringBuilder)localObject1, (StringBuilder)localObject3));
      localObject2 = com.tencent.matrix.trace.g.a.a((List)localObject2, l1);
      if (((this.dhn > e.a(e.this)) && (!this.dhd)) || ((this.dhn > e.b(e.this)) && (this.dhd))) {
        c.w("Matrix.StartupTracer", "stackKey:%s \n%s", new Object[] { localObject2, ((StringBuilder)localObject3).toString() });
      }
      long l2 = this.dhm;
      long l3 = this.dha;
      boolean bool = this.dhd;
      int i = this.scene;
      localObject3 = (com.tencent.matrix.trace.b)com.tencent.matrix.b.Vu().Y(com.tencent.matrix.trace.b.class);
      if (localObject3 == null) {}
      for (;;)
      {
        return;
        try
        {
          JSONObject localJSONObject = com.tencent.matrix.e.a.a(new JSONObject(), com.tencent.matrix.b.Vu().application);
          localJSONObject.put("application_create", l2);
          localJSONObject.put("application_create_scene", i);
          localJSONObject.put("first_activity_create", l3);
          localJSONObject.put("startup_duration", l1);
          localJSONObject.put("is_warm_start_up", bool);
          com.tencent.matrix.report.f localf = new com.tencent.matrix.report.f();
          localf.tag = "Trace_StartUp";
          localf.cZZ = localJSONObject;
          ((com.tencent.matrix.trace.b)localObject3).onDetectIssue(localf);
          if (((l1 <= e.a(e.this)) || (bool)) && ((l1 <= e.b(e.this)) || (!bool))) {
            continue;
          }
          try
          {
            localJSONObject = com.tencent.matrix.e.a.a(new JSONObject(), com.tencent.matrix.b.Vu().application);
            localJSONObject.put("detail", com.tencent.matrix.trace.b.a.a.deY);
            localJSONObject.put("cost", l1);
            localJSONObject.put("stack", ((StringBuilder)localObject1).toString());
            localJSONObject.put("stackKey", localObject2);
            if (bool)
            {
              i = 2;
              localJSONObject.put("subType", i);
              localObject1 = new com.tencent.matrix.report.f();
              ((com.tencent.matrix.report.f)localObject1).tag = "Trace_EvilMethod";
              ((com.tencent.matrix.report.f)localObject1).cZZ = localJSONObject;
              ((com.tencent.matrix.trace.b)localObject3).onDetectIssue((com.tencent.matrix.report.f)localObject1);
              return;
            }
          }
          catch (JSONException localJSONException1)
          {
            c.e("Matrix.StartupTracer", "[JSONException error: %s", new Object[] { localJSONException1 });
            return;
          }
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            c.e("Matrix.StartupTracer", "[JSONException for StartUpReportTask error: %s", new Object[] { localJSONException2 });
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