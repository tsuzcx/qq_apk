package com.tencent.matrix.resource.e;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.os.HandlerThread;
import com.tencent.matrix.resource.CanaryWorkerService;
import com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo;
import com.tencent.mrs.b.a.a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends com.tencent.matrix.e.a
{
  public final com.tencent.matrix.resource.b bPS;
  public final e bPT;
  final int bPU;
  private final d bPV;
  final c bPW;
  final c.a bPX;
  final ConcurrentLinkedQueue<DestroyedActivityInfo> bPY;
  final AtomicLong bPZ;
  public final Application.ActivityLifecycleCallbacks bQa = new a()
  {
    private int bQd = 0;
    private int bQe = 0;
    
    public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
    {
      b.this.bPZ.incrementAndGet();
    }
    
    public final void onActivityDestroyed(Activity arg1)
    {
      b localb = b.this;
      String str = ???.getClass().getName();
      if (localb.cA(str)) {
        com.tencent.matrix.g.c.d("Matrix.ActivityRefWatcher", "activity leak with name %s had published, just ignore", new Object[] { str });
      }
      synchronized (b.this.bPY)
      {
        b.this.bPY.notifyAll();
        return;
        UUID localUUID = UUID.randomUUID();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MATRIX_RESCANARY_REFKEY_").append(str).append('_').append(Long.toHexString(localUUID.getMostSignificantBits())).append(Long.toHexString(localUUID.getLeastSignificantBits()));
        ??? = new DestroyedActivityInfo(localStringBuilder.toString(), ???, str, localb.bPZ.get());
        localb.bPY.add(???);
      }
    }
    
    public final void onActivityStarted(Activity paramAnonymousActivity)
    {
      if (this.bQd <= 0)
      {
        com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "we are in foreground, start watcher task.", new Object[0]);
        b.this.bPT.a(b.this.bQb, 0);
      }
      if (this.bQe < 0)
      {
        this.bQe += 1;
        return;
      }
      this.bQd += 1;
    }
    
    public final void onActivityStopped(Activity paramAnonymousActivity)
    {
      if (paramAnonymousActivity.isChangingConfigurations()) {
        this.bQe -= 1;
      }
      do
      {
        return;
        this.bQd -= 1;
      } while (this.bQd > 0);
      com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "we are in background, stop watcher task.", new Object[0]);
      b.this.bPT.zp();
    }
  };
  public final e.a bQb = new e.a()
  {
    public final e.a.a zm()
    {
      if (b.this.bPY.isEmpty()) {}
      try
      {
        label33:
        synchronized (b.this.bPY)
        {
          b.this.bPY.wait();
        }
        if ((Debug.isDebuggerConnected()) && (!b.this.bPS.bOS.bOY))
        {
          com.tencent.matrix.g.c.w("Matrix.ActivityRefWatcher", "debugger is connected, to avoid fake result, detection was delayed.", new Object[0]);
          return e.a.a.bQt;
        }
        ??? = new WeakReference(new Object());
        com.tencent.matrix.g.c.v("Matrix.ActivityRefWatcher", "triggering gc...", new Object[0]);
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        com.tencent.matrix.g.c.v("Matrix.ActivityRefWatcher", "gc was triggered.", new Object[0]);
        if (((WeakReference)???).get() != null)
        {
          com.tencent.matrix.g.c.d("Matrix.ActivityRefWatcher", "system ignore our gc request, wait for next detection.", new Object[0]);
          return e.a.a.bQt;
        }
        ??? = b.this.bPY.iterator();
        for (;;)
        {
          if (((Iterator)???).hasNext())
          {
            Object localObject3 = (DestroyedActivityInfo)((Iterator)???).next();
            if (b.this.cA(((DestroyedActivityInfo)localObject3).mActivityName))
            {
              com.tencent.matrix.g.c.v("Matrix.ActivityRefWatcher", "activity with key [%s] was already published.", new Object[] { ((DestroyedActivityInfo)localObject3).mActivityName });
              ((Iterator)???).remove();
              continue;
            }
            if (((DestroyedActivityInfo)localObject3).mActivityRef.get() == null)
            {
              com.tencent.matrix.g.c.v("Matrix.ActivityRefWatcher", "activity with key [%s] was already recycled.", new Object[] { ((DestroyedActivityInfo)localObject3).mKey });
              ((Iterator)???).remove();
              continue;
            }
            ((DestroyedActivityInfo)localObject3).mDetectedCount += 1;
            long l = b.this.bPZ.get() - ((DestroyedActivityInfo)localObject3).mLastCreatedActivityCount;
            if ((((DestroyedActivityInfo)localObject3).mDetectedCount < b.this.bPU) || ((l < 2L) && (!b.this.bPS.bOS.bOY)))
            {
              com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "activity with key [%s] should be recycled but actually still \nexists in %s times detection with %s created activities during destroy, wait for next detection to confirm.", new Object[] { ((DestroyedActivityInfo)localObject3).mKey, Integer.valueOf(((DestroyedActivityInfo)localObject3).mDetectedCount), Long.valueOf(l) });
              continue;
            }
            com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "activity with key [%s] was suspected to be a leaked instance.", new Object[] { ((DestroyedActivityInfo)localObject3).mKey });
            if (b.this.bPW != null)
            {
              localObject4 = b.this.bPW.zn();
              if (localObject4 != null)
              {
                b.this.cz(((DestroyedActivityInfo)localObject3).mActivityName);
                localObject3 = new com.tencent.matrix.resource.analyzer.model.a((File)localObject4, ((DestroyedActivityInfo)localObject3).mKey, ((DestroyedActivityInfo)localObject3).mActivityName);
                b.this.bPX.a((com.tencent.matrix.resource.analyzer.model.a)localObject3);
                ((Iterator)???).remove();
                continue;
              }
              com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "heap dump for further analyzing activity with key [%s] was failed, just ignore.", new Object[] { ((DestroyedActivityInfo)localObject3).mKey });
              ((Iterator)???).remove();
              continue;
            }
            com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "lightweight mode, just report leaked activity name.", new Object[0]);
            b.this.cz(((DestroyedActivityInfo)localObject3).mActivityName);
            if (b.this.bPS == null) {
              continue;
            }
            Object localObject4 = new JSONObject();
            try
            {
              ((JSONObject)localObject4).put("activity", ((DestroyedActivityInfo)localObject3).mActivityName);
              b.this.bPS.onDetectIssue(new com.tencent.matrix.e.b((JSONObject)localObject4));
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                com.tencent.matrix.g.c.printErrStackTrace("Matrix.ActivityRefWatcher", localJSONException, "unexpected exception.", new Object[0]);
              }
            }
          }
        }
        return e.a.a.bQt;
      }
      catch (Throwable localThrowable)
      {
        break label33;
      }
    }
  };
  
  public b(Application paramApplication, com.tencent.matrix.resource.b paramb)
  {
    this(paramApplication, paramb, new a()
    {
      protected final c.a a(Context paramAnonymousContext, com.tencent.matrix.resource.b.a paramAnonymousa)
      {
        if (paramAnonymousa.bOX) {
          return super.a(paramAnonymousContext, paramAnonymousa);
        }
        return null;
      }
      
      protected final c a(Context paramAnonymousContext, d paramAnonymousd)
      {
        if (b.this.bOS.bOX) {
          return super.a(paramAnonymousContext, paramAnonymousd);
        }
        return null;
      }
      
      protected final d az(Context paramAnonymousContext)
      {
        if (b.this.bOS.bOX) {
          return super.az(paramAnonymousContext);
        }
        return null;
      }
    });
  }
  
  private b(Application paramApplication, com.tencent.matrix.resource.b paramb, a parama)
  {
    super(paramApplication, paramb.getTag(), paramb);
    this.bPS = paramb;
    paramb = paramb.bOS;
    HandlerThread localHandlerThread = com.tencent.matrix.g.b.zI();
    this.bPT = new e(paramb.bMc.get(a.a.BaU.name(), com.tencent.matrix.resource.b.a.bOW), localHandlerThread);
    this.bPU = paramb.bMc.get(a.a.BaV.name(), 3);
    this.bPV = parama.az(paramApplication);
    this.bPW = parama.a(paramApplication, this.bPV);
    this.bPX = parama.a(paramApplication, paramb);
    this.bPY = new ConcurrentLinkedQueue();
    this.bPZ = new AtomicLong(0L);
  }
  
  private void zl()
  {
    this.bPT.zp();
    this.bPY.clear();
    this.bPZ.set(0L);
  }
  
  public final void zk()
  {
    Application localApplication = this.bPS.getApplication();
    if (localApplication != null)
    {
      localApplication.unregisterActivityLifecycleCallbacks(this.bQa);
      zl();
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
    
    protected d az(Context paramContext)
    {
      return new d(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.resource.e.b
 * JD-Core Version:    0.7.0.1
 */