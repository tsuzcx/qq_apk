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
  private boolean cJK;
  private final com.tencent.matrix.trace.a.b cJL;
  private long cLQ = 0L;
  private long cLR = 0L;
  private int cLS;
  private boolean cLT;
  private boolean cLU;
  private boolean cLV;
  private Set<String> cLW;
  private long cLX;
  private long cLY;
  private long cLZ = 0L;
  private HashMap<String, Long> cMa = new HashMap();
  private boolean cMb = true;
  
  public e(com.tencent.matrix.trace.a.b paramb)
  {
    this.cJL = paramb;
    this.cLV = paramb.cJF;
    if (paramb.cJJ == null)
    {
      paramb.cJJ = new HashSet();
      if (paramb.cEm != null) {
        break label157;
      }
      if (paramb.cJI != null) {
        paramb.cJJ.addAll(Arrays.asList(paramb.cJI.split(";")));
      }
    }
    this.cLW = paramb.cJJ;
    if (paramb.cEm == null)
    {
      label121:
      this.cLX = i;
      if (paramb.cEm != null) {
        break label240;
      }
    }
    label157:
    label240:
    for (i = 4000;; i = paramb.cEm.get(com.tencent.c.a.a.a.LCA.name(), 4000))
    {
      this.cLY = i;
      this.cJK = paramb.cJK;
      com.tencent.matrix.trace.c.a.a(this);
      return;
      String str = paramb.cEm.get(com.tencent.c.a.a.a.LCp.name(), paramb.cJI);
      if (str != null) {
        paramb.cJI = str;
      }
      if (paramb.cJI == null) {
        break;
      }
      paramb.cJJ.addAll(Arrays.asList(paramb.cJI.split(";")));
      break;
      i = paramb.cEm.get(com.tencent.c.a.a.a.LCz.name(), 10000);
      break label121;
    }
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    com.tencent.matrix.g.c.i("Matrix.StartupTracer", "[report] applicationCost:%s firstScreenCost:%s allCost:%s isWarmStartUp:%s, createScene:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Boolean.valueOf(paramBoolean), Integer.valueOf(com.tencent.matrix.trace.c.a.cKx) });
    long[] arrayOfLong2 = new long[0];
    long[] arrayOfLong1;
    if ((!paramBoolean) && (paramLong3 >= this.cLX))
    {
      arrayOfLong1 = AppMethodBeat.getInstance().copyData(com.tencent.matrix.trace.c.a.cKw);
      com.tencent.matrix.trace.c.a.cKw.release();
    }
    for (;;)
    {
      com.tencent.matrix.g.b.Ju().post(new a(arrayOfLong1, paramLong1, paramLong2, paramLong3, paramBoolean, com.tencent.matrix.trace.c.a.cKx));
      return;
      arrayOfLong1 = arrayOfLong2;
      if (paramBoolean)
      {
        arrayOfLong1 = arrayOfLong2;
        if (paramLong3 >= this.cLY)
        {
          arrayOfLong1 = AppMethodBeat.getInstance().copyData(com.tencent.matrix.trace.c.a.cKv);
          com.tencent.matrix.trace.c.a.cKv.release();
        }
      }
    }
  }
  
  public final void Jg()
  {
    if (!this.cJK)
    {
      long l = com.tencent.matrix.trace.c.a.Jc();
      com.tencent.matrix.g.c.i("Matrix.StartupTracer", "onApplicationCreateEnd, applicationCost:%d", new Object[] { Long.valueOf(l) });
      a(l, 0L, l, false);
    }
  }
  
  public final void n(Activity paramActivity)
  {
    if (com.tencent.matrix.trace.c.a.cKx == -2147483648) {
      return;
    }
    Object localObject = paramActivity.getClass().getName();
    int i;
    boolean bool;
    String str;
    if (this.cLR == 0L)
    {
      i = 1;
      if (i == 0) {
        break label436;
      }
      bool = com.tencent.matrix.trace.c.a.Je();
      com.tencent.matrix.g.c.i("Matrix.StartupTracer", "#ColdStartup# activity:%s, splashActivities:%s, empty:%b, isCreatedByLaunchActivity:%b, hasShowSplashActivity:%b, firstScreenCost:%d, now:%d, application_create_begin_time:%d, app_cost:%d", new Object[] { localObject, this.cLW, Boolean.valueOf(this.cLW.isEmpty()), Boolean.valueOf(bool), Boolean.valueOf(this.cLU), Long.valueOf(this.cLQ), Long.valueOf(SystemClock.uptimeMillis()), Long.valueOf(com.tencent.matrix.trace.c.a.Jd()), Long.valueOf(com.tencent.matrix.trace.c.a.Jc()) });
      str = (String)localObject + "@" + paramActivity.hashCode();
      paramActivity = (Long)this.cMa.get(str);
      if (paramActivity != null) {
        break label519;
      }
      paramActivity = Long.valueOf(0L);
    }
    label519:
    for (;;)
    {
      this.cMa.put(str, Long.valueOf(SystemClock.uptimeMillis() - paramActivity.longValue()));
      if (this.cLQ == 0L) {
        this.cLQ = (SystemClock.uptimeMillis() - com.tencent.matrix.trace.c.a.Jd());
      }
      if (this.cLU) {
        this.cLR = (SystemClock.uptimeMillis() - com.tencent.matrix.trace.c.a.Jd());
      }
      for (;;)
      {
        if (this.cLR <= 0L) {
          break label417;
        }
        localObject = (Long)this.cMa.get(str);
        if ((localObject == null) || (((Long)localObject).longValue() < 30000L)) {
          break label419;
        }
        com.tencent.matrix.g.c.e("Matrix.StartupTracer", "%s cost too much time[%s] between activity create and onActivityFocused, just throw it.(createTime:%s) ", new Object[] { str, Long.valueOf(SystemClock.uptimeMillis() - paramActivity.longValue()), paramActivity });
        return;
        i = 0;
        break;
        if (this.cLW.contains(localObject))
        {
          this.cLU = true;
        }
        else if (this.cLW.isEmpty())
        {
          if (bool)
          {
            this.cLR = this.cLQ;
          }
          else
          {
            this.cLQ = 0L;
            this.cLR = com.tencent.matrix.trace.c.a.Jc();
          }
        }
        else if (bool)
        {
          this.cLR = this.cLQ;
        }
        else
        {
          this.cLQ = 0L;
          this.cLR = com.tencent.matrix.trace.c.a.Jc();
        }
      }
      label417:
      break;
      label419:
      a(com.tencent.matrix.trace.c.a.Jc(), this.cLQ, this.cLR, false);
      return;
      label436:
      if (!this.cLT) {
        break;
      }
      this.cLT = false;
      long l = SystemClock.uptimeMillis() - this.cLZ;
      com.tencent.matrix.g.c.i("Matrix.StartupTracer", "#WarmStartup# activity:%s, warmCost:%d, now:%d, lastCreateActivity:%d", new Object[] { localObject, Long.valueOf(l), Long.valueOf(SystemClock.uptimeMillis()), Long.valueOf(this.cLZ) });
      if (l <= 0L) {
        break;
      }
      a(0L, 0L, l, true);
      return;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    com.tencent.matrix.g.c.i("Matrix.StartupTracer", "activeActivityCount:%d, coldCost:%d", new Object[] { Integer.valueOf(this.cLS), Long.valueOf(this.cLR) });
    if ((this.cLS == 0) && (this.cLR > 0L))
    {
      this.cLZ = SystemClock.uptimeMillis();
      com.tencent.matrix.g.c.i("Matrix.StartupTracer", "lastCreateActivity:%d, activity:%s", new Object[] { Long.valueOf(this.cLZ), paramActivity.getClass().getName() });
      this.cLT = true;
    }
    this.cLS += 1;
    if (this.cMb) {
      this.cMa.put(paramActivity.getClass().getName() + "@" + paramActivity.hashCode(), Long.valueOf(SystemClock.uptimeMillis()));
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    com.tencent.matrix.g.c.i("Matrix.StartupTracer", "activeActivityCount:%d", new Object[] { Integer.valueOf(this.cLS) });
    this.cLS -= 1;
  }
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  protected final void onAlive()
  {
    super.onAlive();
    com.tencent.matrix.g.c.i("Matrix.StartupTracer", "[onAlive] isStartupEnable:%s", new Object[] { Boolean.valueOf(this.cLV) });
    if (this.cLV)
    {
      AppMethodBeat.getInstance().addListener(this);
      com.tencent.matrix.b.HL().application.registerActivityLifecycleCallbacks(this);
    }
  }
  
  protected final void onDead()
  {
    super.onDead();
    if (this.cLV)
    {
      AppMethodBeat.getInstance().removeListener(this);
      com.tencent.matrix.b.HL().application.unregisterActivityLifecycleCallbacks(this);
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
    long cLQ;
    boolean cLT;
    long cMc;
    long cMd;
    long[] data;
    int scene;
    
    a(long[] paramArrayOfLong, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, int paramInt)
    {
      this.data = paramArrayOfLong;
      this.scene = paramInt;
      this.cMc = paramLong1;
      this.cLQ = paramLong2;
      this.cMd = paramLong3;
      this.cLT = paramBoolean;
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
      long l1 = Math.max(this.cMd, com.tencent.matrix.trace.g.a.a((LinkedList)localObject2, (StringBuilder)localObject1, (StringBuilder)localObject3));
      localObject2 = com.tencent.matrix.trace.g.a.a((List)localObject2, l1);
      if (((this.cMd > e.a(e.this)) && (!this.cLT)) || ((this.cMd > e.b(e.this)) && (this.cLT))) {
        com.tencent.matrix.g.c.w("Matrix.StartupTracer", "stackKey:%s \n%s", new Object[] { localObject2, ((StringBuilder)localObject3).toString() });
      }
      long l2 = this.cMc;
      long l3 = this.cLQ;
      boolean bool = this.cLT;
      int i = this.scene;
      localObject3 = (com.tencent.matrix.trace.a)com.tencent.matrix.b.HL().V(com.tencent.matrix.trace.a.class);
      if (localObject3 == null) {}
      for (;;)
      {
        return;
        try
        {
          JSONObject localJSONObject = com.tencent.matrix.g.a.a(new JSONObject(), com.tencent.matrix.b.HL().application);
          localJSONObject.put("application_create", l2);
          localJSONObject.put("application_create_scene", i);
          localJSONObject.put("first_activity_create", l3);
          localJSONObject.put("startup_duration", l1);
          localJSONObject.put("is_warm_start_up", bool);
          com.tencent.matrix.report.c localc = new com.tencent.matrix.report.c();
          localc.tag = "Trace_StartUp";
          localc.cEZ = localJSONObject;
          ((com.tencent.matrix.trace.a)localObject3).onDetectIssue(localc);
          if (((l1 <= e.a(e.this)) || (bool)) && ((l1 <= e.b(e.this)) || (!bool))) {
            continue;
          }
          try
          {
            localJSONObject = com.tencent.matrix.g.a.a(new JSONObject(), com.tencent.matrix.b.HL().application);
            localJSONObject.put("detail", com.tencent.matrix.trace.b.a.a.cJO);
            localJSONObject.put("cost", l1);
            localJSONObject.put("stack", ((StringBuilder)localObject1).toString());
            localJSONObject.put("stackKey", localObject2);
            if (bool)
            {
              i = 2;
              localJSONObject.put("subType", i);
              localObject1 = new com.tencent.matrix.report.c();
              ((com.tencent.matrix.report.c)localObject1).tag = "Trace_EvilMethod";
              ((com.tencent.matrix.report.c)localObject1).cEZ = localJSONObject;
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