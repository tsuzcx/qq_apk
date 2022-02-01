package com.tencent.mm.openglapihook;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a
  implements Application.ActivityLifecycleCallbacks
{
  private static a mxl;
  private Handler mH;
  private Map<WeakReference<Activity>, List<OpenGLInfo>> maps;
  private HandlerThread mxm;
  String mxn;
  private final long mxo;
  private final long mxp;
  private Runnable mxq;
  
  private a()
  {
    AppMethodBeat.i(204055);
    this.mxn = "";
    this.mxo = 1800000L;
    this.mxp = 600000L;
    this.mxq = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(204054);
        long l = System.currentTimeMillis();
        Object localObject = b.bun().buo();
        com.tencent.mm.openglapihook.a.a.i("GPU_LeakMonitor", "double check list size:" + ((List)localObject).size());
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          OpenGLInfo localOpenGLInfo = (OpenGLInfo)((Iterator)localObject).next();
          if ((localOpenGLInfo != null) && (localOpenGLInfo.mxC) && (l - localOpenGLInfo.mxD > 1800000L)) {
            b.bun().m(localOpenGLInfo);
          }
        }
        a.b(a.this).postDelayed(a.a(a.this), 600000L);
        AppMethodBeat.o(204054);
      }
    };
    this.mxm = new HandlerThread("LeakMonitor");
    this.mxm.start();
    this.mH = new Handler(this.mxm.getLooper());
    this.mH.postDelayed(this.mxq, 600000L);
    this.maps = new HashMap();
    AppMethodBeat.o(204055);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(204057);
    b.bun().mxL = parama;
    AppMethodBeat.o(204057);
  }
  
  public static a bul()
  {
    AppMethodBeat.i(204056);
    if (mxl == null) {
      mxl = new a();
    }
    a locala = mxl;
    AppMethodBeat.o(204056);
    return locala;
  }
  
  public static void k(Application paramApplication)
  {
    AppMethodBeat.i(204058);
    com.tencent.mm.openglapihook.a.a.i("GPU_LeakMonitor", "start");
    if (Build.VERSION.SDK_INT >= 14) {
      paramApplication.registerActivityLifecycleCallbacks(mxl);
    }
    AppMethodBeat.o(204058);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(204059);
    this.mxn = paramActivity.getLocalClassName();
    com.tencent.mm.openglapihook.a.a.i("GPU_LeakMonitor", "activity oncreate:" + this.mxn + "  :" + paramActivity.hashCode());
    paramActivity = new WeakReference(paramActivity);
    paramBundle = b.bun().buo();
    this.maps.put(paramActivity, paramBundle);
    AppMethodBeat.o(204059);
  }
  
  public final void onActivityDestroyed(final Activity paramActivity)
  {
    AppMethodBeat.i(204062);
    com.tencent.mm.openglapihook.a.a.i("GPU_LeakMonitor", "activity ondestroy:" + paramActivity.getLocalClassName() + "  :" + paramActivity.hashCode());
    Object localObject2 = null;
    Object localObject3 = this.maps.keySet().iterator();
    Object localObject1;
    Activity localActivity;
    do
    {
      for (;;)
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break label112;
        }
        localObject1 = (WeakReference)((Iterator)localObject3).next();
        localActivity = (Activity)((WeakReference)localObject1).get();
        if (localActivity != null) {
          break;
        }
        ((Iterator)localObject3).remove();
      }
    } while (localActivity != paramActivity);
    label112:
    if (localObject1 == null)
    {
      AppMethodBeat.o(204062);
      return;
    }
    paramActivity = "";
    localObject2 = (Activity)((WeakReference)localObject1).get();
    if (localObject2 != null) {
      paramActivity = ((Activity)localObject2).getLocalClassName();
    }
    localObject2 = (List)this.maps.get(localObject1);
    localObject3 = b.bun().buo();
    this.mH.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(204053);
        if (a.g(this.mxr, this.mxs)) {
          com.tencent.mm.openglapihook.a.a.i("GPU_LeakMonitor", paramActivity + " leak! ");
        }
        AppMethodBeat.o(204053);
      }
    });
    this.maps.remove(localObject1);
    AppMethodBeat.o(204062);
  }
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(204064);
    this.mxn = paramActivity.getLocalClassName();
    AppMethodBeat.o(204064);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public static abstract interface a
  {
    public abstract void a(OpenGLInfo paramOpenGLInfo);
    
    public abstract void b(OpenGLInfo paramOpenGLInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.openglapihook.a
 * JD-Core Version:    0.7.0.1
 */