package com.tencent.matrix.resource.e;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.resource.CanaryWorkerService;
import com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends com.tencent.matrix.c.a
{
  final int boU;
  public final com.tencent.matrix.resource.c bpR;
  public final e bpS;
  private final d bpT;
  final c bpU;
  final c.a bpV;
  final ConcurrentLinkedQueue<DestroyedActivityInfo> bpW;
  final AtomicLong bpX;
  public final Application.ActivityLifecycleCallbacks bpY = new a()
  {
    public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
    {
      b.this.bpX.incrementAndGet();
    }
    
    public final void onActivityDestroyed(Activity paramAnonymousActivity)
    {
      b localb = b.this;
      String str = paramAnonymousActivity.getClass().getName();
      if (localb.by(str))
      {
        com.tencent.matrix.d.b.d("Matrix.ActivityRefWatcher", "activity leak with name %s had published, just ignore", new Object[] { str });
        return;
      }
      UUID localUUID = UUID.randomUUID();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MATRIX_RESCANARY_REFKEY_").append(str).append('_').append(Long.toHexString(localUUID.getMostSignificantBits())).append(Long.toHexString(localUUID.getLeastSignificantBits()));
      paramAnonymousActivity = new DestroyedActivityInfo(localStringBuilder.toString(), paramAnonymousActivity, str, localb.bpX.get());
      localb.bpW.add(paramAnonymousActivity);
    }
  };
  public final e.a bpZ = new e.a()
  {
    public final e.a.a rj()
    {
      if (Debug.isDebuggerConnected())
      {
        com.tencent.matrix.d.b.w("Matrix.ActivityRefWatcher", "debugger is connected, to avoid fake result, detection was delayed.", new Object[0]);
        return e.a.a.bqp;
      }
      if (b.this.bpW.isEmpty()) {
        return e.a.a.bqp;
      }
      Object localObject1 = new WeakReference(new Object());
      com.tencent.matrix.d.b.v("Matrix.ActivityRefWatcher", "triggering gc...", new Object[0]);
      Runtime.getRuntime().gc();
      Runtime.getRuntime().runFinalization();
      com.tencent.matrix.d.b.v("Matrix.ActivityRefWatcher", "gc was triggered.", new Object[0]);
      if (((WeakReference)localObject1).get() != null)
      {
        com.tencent.matrix.d.b.d("Matrix.ActivityRefWatcher", "system ignore our gc request, wait for next detection.", new Object[0]);
        return e.a.a.bqp;
      }
      localObject1 = b.this.bpW.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (DestroyedActivityInfo)((Iterator)localObject1).next();
          if (b.this.by(((DestroyedActivityInfo)localObject2).mActivityName))
          {
            com.tencent.matrix.d.b.v("Matrix.ActivityRefWatcher", "activity with key [%s] was already published.", new Object[] { ((DestroyedActivityInfo)localObject2).mActivityName });
            ((Iterator)localObject1).remove();
            continue;
          }
          if (((DestroyedActivityInfo)localObject2).mActivityRef.get() == null)
          {
            com.tencent.matrix.d.b.v("Matrix.ActivityRefWatcher", "activity with key [%s] was already recycled.", new Object[] { ((DestroyedActivityInfo)localObject2).mKey });
            ((Iterator)localObject1).remove();
            continue;
          }
          ((DestroyedActivityInfo)localObject2).mDetectedCount += 1;
          long l = b.this.bpX.get() - ((DestroyedActivityInfo)localObject2).mLastCreatedActivityCount;
          if ((((DestroyedActivityInfo)localObject2).mDetectedCount < b.this.boU) || (l < 2L))
          {
            com.tencent.matrix.d.b.i("Matrix.ActivityRefWatcher", "activity with key [%s] should be recycled but actually still \nexists in %s times detection with %s created activities during destroy, wait for next detection to confirm.", new Object[] { ((DestroyedActivityInfo)localObject2).mKey, Integer.valueOf(((DestroyedActivityInfo)localObject2).mDetectedCount), Long.valueOf(l) });
            continue;
          }
          com.tencent.matrix.d.b.i("Matrix.ActivityRefWatcher", "activity with key [%s] was suspected to be a leaked instance.", new Object[] { ((DestroyedActivityInfo)localObject2).mKey });
          if (b.this.bpU != null)
          {
            localObject3 = b.this.bpU.rk();
            if (localObject3 != null)
            {
              b.this.bx(((DestroyedActivityInfo)localObject2).mActivityName);
              localObject2 = new com.tencent.matrix.resource.analyzer.model.a((File)localObject3, ((DestroyedActivityInfo)localObject2).mKey, ((DestroyedActivityInfo)localObject2).mActivityName);
              b.this.bpV.a((com.tencent.matrix.resource.analyzer.model.a)localObject2);
              ((Iterator)localObject1).remove();
              continue;
            }
            com.tencent.matrix.d.b.i("Matrix.ActivityRefWatcher", "heap dump for further analyzing activity with key [%s] was failed, just ignore.", new Object[] { ((DestroyedActivityInfo)localObject2).mKey });
            ((Iterator)localObject1).remove();
            continue;
          }
          com.tencent.matrix.d.b.i("Matrix.ActivityRefWatcher", "lightweight mode, just report leaked activity name.", new Object[0]);
          b.this.bx(((DestroyedActivityInfo)localObject2).mActivityName);
          if (b.this.bpR == null) {
            continue;
          }
          Object localObject3 = new JSONObject();
          try
          {
            ((JSONObject)localObject3).put("activity", ((DestroyedActivityInfo)localObject2).mActivityName);
            b.this.bpR.a(new com.tencent.matrix.c.b((JSONObject)localObject3));
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              com.tencent.matrix.d.b.printErrStackTrace("Matrix.ActivityRefWatcher", localJSONException, "unexpected exception.", new Object[0]);
            }
          }
        }
      }
      return e.a.a.bqp;
    }
  };
  
  public b(Application paramApplication, com.tencent.matrix.resource.c paramc)
  {
    this(paramApplication, paramc, new a()
    {
      protected final c.a a(Context paramAnonymousContext, com.tencent.matrix.resource.b.a paramAnonymousa)
      {
        if (paramAnonymousa.boV) {
          return super.a(paramAnonymousContext, paramAnonymousa);
        }
        return null;
      }
      
      protected final c a(Context paramAnonymousContext, d paramAnonymousd)
      {
        if (b.this.boO.boV) {
          return super.a(paramAnonymousContext, paramAnonymousd);
        }
        return null;
      }
      
      protected final d ah(Context paramAnonymousContext)
      {
        if (b.this.boO.boV) {
          return super.ah(paramAnonymousContext);
        }
        return null;
      }
    });
  }
  
  private b(Application paramApplication, com.tencent.matrix.resource.c paramc, a parama)
  {
    super(paramApplication, "memory", paramc);
    this.bpR = paramc;
    paramc = paramc.boO;
    HandlerThread localHandlerThread = com.tencent.matrix.d.a.rt();
    this.bpS = new e(paramc.boT, localHandlerThread);
    this.boU = paramc.boU;
    this.bpT = parama.ah(paramApplication);
    this.bpU = parama.a(paramApplication, this.bpT);
    this.bpV = parama.a(paramApplication, paramc);
    this.bpW = new ConcurrentLinkedQueue();
    this.bpX = new AtomicLong(0L);
  }
  
  public final void ri()
  {
    Object localObject = this.bpR.application;
    if (localObject != null)
    {
      ((Application)localObject).unregisterActivityLifecycleCallbacks(this.bpY);
      localObject = this.bpS;
      ((e)localObject).bqj.removeCallbacksAndMessages(null);
      ((e)localObject).mMainHandler.removeCallbacksAndMessages(null);
      this.bpW.clear();
      this.bpX.set(0L);
    }
  }
  
  public static class a
  {
    protected c.a a(final Context paramContext, com.tencent.matrix.resource.b.a parama)
    {
      new c.a()
      {
        public final void a(com.tencent.matrix.resource.analyzer.model.a paramAnonymousa)
        {
          CanaryWorkerService.a(paramContext, paramAnonymousa);
        }
      };
    }
    
    protected c a(Context paramContext, d paramd)
    {
      return new c(paramContext, paramd);
    }
    
    protected d ah(Context paramContext)
    {
      return new d(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.resource.e.b
 * JD-Core Version:    0.7.0.1
 */