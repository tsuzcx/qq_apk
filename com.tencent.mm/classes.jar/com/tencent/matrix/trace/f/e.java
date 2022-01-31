package com.tencent.matrix.trace.f;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.matrix.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.core.AppMethodBeat.a;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends f
  implements Application.ActivityLifecycleCallbacks, com.tencent.matrix.trace.e.a
{
  private final com.tencent.matrix.trace.a.a bRa;
  private long bSG = 0L;
  private long bSH = 0L;
  private int bSI;
  private boolean bSJ;
  private boolean bSK;
  private Set<String> bSL;
  private long bSM;
  private long bSN;
  
  public e(com.tencent.matrix.trace.a.a parama)
  {
    this.bRa = parama;
    this.bSK = parama.bQV;
    HashSet localHashSet;
    if (parama.bQZ == null)
    {
      if (parama.bNO == null)
      {
        localHashSet = new HashSet(Arrays.asList(new String[] { parama.bQY }));
        parama.bQZ = localHashSet;
      }
    }
    else
    {
      this.bSL = parama.bQZ;
      if (parama.bNO != null) {
        break label149;
      }
      i = 10000;
      label87:
      this.bSM = i;
      if (parama.bNO != null) {
        break label171;
      }
    }
    label149:
    label171:
    for (int i = 4000;; i = parama.bNO.get(com.tencent.mrs.b.a.a.Bay.name(), 4000))
    {
      this.bSN = i;
      return;
      localHashSet = new HashSet(Arrays.asList(parama.bNO.get(com.tencent.mrs.b.a.a.Ban.name(), parama.bQY).split(";")));
      break;
      i = parama.bNO.get(com.tencent.mrs.b.a.a.Bax.name(), 10000);
      break label87;
    }
  }
  
  public final void cB(String paramString)
  {
    int i;
    long l1;
    boolean bool;
    if (this.bSH == 0L)
    {
      i = 1;
      if (i == 0) {
        break label276;
      }
      if (this.bSG == 0L) {
        this.bSG = (SystemClock.uptimeMillis() - com.tencent.matrix.trace.c.a.zw());
      }
      if (!this.bSJ) {
        break label184;
      }
      l1 = SystemClock.uptimeMillis() - com.tencent.matrix.trace.c.a.zw();
      this.bSH = l1;
      bool = false;
    }
    for (;;)
    {
      label58:
      long l2;
      long l3;
      long[] arrayOfLong;
      if (l1 > 0L)
      {
        l2 = com.tencent.matrix.trace.c.a.zv();
        l3 = this.bSG;
        c.i("Matrix.StartupTracer", "[report] applicationCost:%s firstScreenCost:%s allCost:%s isWarmStartUp:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1), Boolean.valueOf(bool) });
        arrayOfLong = new long[0];
        if ((bool) || (l1 < this.bSM)) {
          break label329;
        }
        paramString = AppMethodBeat.getInstance().copyData(com.tencent.matrix.trace.c.a.bRH);
        com.tencent.matrix.trace.c.a.bRH.release();
      }
      for (;;)
      {
        com.tencent.matrix.g.b.zJ().post(new a(paramString, l2, l3, l1, bool, com.tencent.matrix.trace.c.a.bRI));
        return;
        i = 0;
        break;
        label184:
        if (this.bSL.contains(paramString))
        {
          this.bSJ = true;
          bool = false;
          l1 = 0L;
          break label58;
        }
        if (this.bSL.isEmpty())
        {
          c.i("Matrix.StartupTracer", "default care activity[%s]", new Object[] { paramString });
          l1 = this.bSG;
          this.bSH = l1;
          bool = false;
          break label58;
        }
        c.w("Matrix.StartupTracer", "pass this activity[%s] in duration of startup!", new Object[] { paramString });
        bool = false;
        l1 = 0L;
        break label58;
        label276:
        if (this.bSI > 1) {
          bool = false;
        }
        for (;;)
        {
          if (!bool) {
            break label368;
          }
          l1 = SystemClock.uptimeMillis() - com.tencent.matrix.trace.c.a.zx();
          break;
          if (SystemClock.uptimeMillis() - com.tencent.matrix.trace.c.a.zx() > 5000L) {
            bool = false;
          } else {
            bool = true;
          }
        }
        label329:
        paramString = arrayOfLong;
        if (bool)
        {
          paramString = arrayOfLong;
          if (l1 >= this.bSN)
          {
            paramString = AppMethodBeat.getInstance().copyData(com.tencent.matrix.trace.c.a.bRG);
            com.tencent.matrix.trace.c.a.bRG.release();
          }
        }
      }
      label368:
      l1 = 0L;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    this.bSI += 1;
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    this.bSI -= 1;
  }
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  protected final void zy()
  {
    super.zy();
    c.i("Matrix.StartupTracer", "[onAlive] isStartupEnable:%s", new Object[] { Boolean.valueOf(this.bSK) });
    if (this.bSK)
    {
      AppMethodBeat.getInstance().addListener(this);
      com.tencent.matrix.b.yD().application.registerActivityLifecycleCallbacks(this);
    }
  }
  
  protected final void zz()
  {
    super.zz();
    if (this.bSK)
    {
      AppMethodBeat.getInstance().removeListener(this);
      com.tencent.matrix.b.yD().application.unregisterActivityLifecycleCallbacks(this);
    }
  }
  
  final class a
    implements Runnable
  {
    long[] bRZ;
    long bSG;
    long bSO;
    long bSP;
    boolean bSQ;
    int scene;
    
    a(long[] paramArrayOfLong, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, int paramInt)
    {
      this.bRZ = paramArrayOfLong;
      this.scene = paramInt;
      this.bSO = paramLong1;
      this.bSG = paramLong2;
      this.bSP = paramLong3;
      this.bSQ = paramBoolean;
    }
    
    public final void run()
    {
      Object localObject2 = new LinkedList();
      if (this.bRZ.length > 0)
      {
        com.tencent.matrix.trace.g.a.a(this.bRZ, (LinkedList)localObject2, false, -1L);
        com.tencent.matrix.trace.g.a.a((List)localObject2, new com.tencent.matrix.trace.g.a.a()
        {
          public final boolean c(long paramAnonymousLong, int paramAnonymousInt)
          {
            return paramAnonymousLong < paramAnonymousInt * 5;
          }
          
          public final void e(List<com.tencent.matrix.trace.d.a> paramAnonymousList, int paramAnonymousInt)
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
      long l1 = Math.max(this.bSP, com.tencent.matrix.trace.g.a.a((LinkedList)localObject2, (StringBuilder)localObject1, (StringBuilder)localObject3));
      localObject2 = com.tencent.matrix.trace.g.a.a((List)localObject2, l1);
      if (((this.bSP > e.a(e.this)) && (!this.bSQ)) || ((this.bSP > e.b(e.this)) && (this.bSQ))) {
        c.w("Matrix.StartupTracer", "stackKey:%s \n%s", new Object[] { localObject2, ((StringBuilder)localObject3).toString() });
      }
      long l2 = this.bSO;
      long l3 = this.bSG;
      boolean bool = this.bSQ;
      int i = this.scene;
      localObject3 = (com.tencent.matrix.trace.b)com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class);
      if (localObject3 == null) {}
      for (;;)
      {
        return;
        try
        {
          JSONObject localJSONObject = com.tencent.matrix.g.a.a(new JSONObject(), com.tencent.matrix.b.yD().application);
          localJSONObject.put("application_create", l2);
          localJSONObject.put("application_create_scene", i);
          localJSONObject.put("first_activity_create", l3);
          localJSONObject.put("startup_duration", l1);
          localJSONObject.put("is_warm_start_up", bool);
          com.tencent.matrix.e.b localb = new com.tencent.matrix.e.b();
          localb.tag = "Trace_StartUp";
          localb.bOx = localJSONObject;
          ((com.tencent.matrix.trace.b)localObject3).onDetectIssue(localb);
          if (((l1 <= e.a(e.this)) || (bool)) && ((l1 <= e.b(e.this)) || (!bool))) {
            continue;
          }
          try
          {
            localJSONObject = com.tencent.matrix.g.a.a(new JSONObject(), com.tencent.matrix.b.yD().application);
            localJSONObject.put("detail", com.tencent.matrix.trace.b.a.a.bRd);
            localJSONObject.put("cost", l1);
            localJSONObject.put("stack", ((StringBuilder)localObject1).toString());
            localJSONObject.put("stackKey", localObject2);
            if (bool)
            {
              i = 2;
              localJSONObject.put("subType", i);
              localObject1 = new com.tencent.matrix.e.b();
              ((com.tencent.matrix.e.b)localObject1).tag = "Trace_EvilMethod";
              ((com.tencent.matrix.e.b)localObject1).bOx = localJSONObject;
              ((com.tencent.matrix.trace.b)localObject3).onDetectIssue((com.tencent.matrix.e.b)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.f.e
 * JD-Core Version:    0.7.0.1
 */