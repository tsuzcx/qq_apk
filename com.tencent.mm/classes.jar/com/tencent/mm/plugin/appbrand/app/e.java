package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.appbrand.af.a;
import com.tencent.mm.plugin.appbrand.ipc.c;
import com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler;
import com.tencent.mm.plugin.appbrand.task.l;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class e
{
  private static volatile boolean qBn = false;
  private static volatile boolean qBo = false;
  
  public static void a(l paraml, AppBrandPreloadProfiler paramAppBrandPreloadProfiler, final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(317804);
    qBo = true;
    if ((paraml == null) || (paraml == l.tWy))
    {
      Log.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile][preload]", "dl: AppBrandProcessPreloader said I can not preload [nil] type.");
      AppMethodBeat.o(317804);
      return;
    }
    final AppBrandPreloadProfiler localAppBrandPreloadProfiler = paramAppBrandPreloadProfiler;
    if (paramAppBrandPreloadProfiler == null) {
      localAppBrandPreloadProfiler = new AppBrandPreloadProfiler();
    }
    localAppBrandPreloadProfiler.tVW = SystemClock.elapsedRealtime();
    MMHandlerThread.postToMainThread(new e.3(new kotlin.g.a.b()
    {
      private Integer US(String paramAnonymousString)
      {
        AppMethodBeat.i(317722);
        e.aAs();
        boolean bool = e.qBn;
        Log.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile][preload]", "start misc preload type[%s], aggressive[%b], reason[%s], skip[%b], level[%d]", new Object[] { e.this, Boolean.valueOf(paramBoolean), paramAnonymousString, Boolean.valueOf(bool), Integer.valueOf(paramInt) });
        if (!bool) {}
        for (;;)
        {
          try
          {
            c.cpt();
            if (!paramBoolean) {
              continue;
            }
            if (com.tencent.mm.plugin.appbrand.task.h.k(e.this)) {
              com.tencent.mm.plugin.appbrand.task.h.a(e.this, null, true, localAppBrandPreloadProfiler, paramInt);
            }
            e.UR("preload aggressive before keepalive");
            if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).mProcessName.endsWith(":appbrand0")) {
              com.tencent.mm.plugin.appbrand.keepalive.b.aj(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(44106);
                  e.UR("preload aggressive after keepalive");
                  AppMethodBeat.o(44106);
                }
              });
            }
          }
          catch (Exception paramAnonymousString)
          {
            if (!w.qvw) {
              continue;
            }
            AppMethodBeat.o(317722);
            throw paramAnonymousString;
            Log.printErrStackTrace("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile][preload]", paramAnonymousString, "Preload [%s] in IdleHandler encountered Exception", new Object[] { e.this.name() });
            continue;
          }
          AppMethodBeat.o(317722);
          return Integer.valueOf(0);
          com.tencent.mm.plugin.appbrand.task.h.a(e.this, null, false, localAppBrandPreloadProfiler, paramInt);
        }
      }
    }));
    AppMethodBeat.o(317804);
  }
  
  public static boolean ceB()
  {
    return qBo;
  }
  
  public static void jdMethod_if(boolean paramBoolean)
  {
    AppMethodBeat.i(44110);
    Log.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile][preload]", "setSkipMiscPreload %b", new Object[] { Boolean.valueOf(paramBoolean) });
    qBn = paramBoolean;
    AppMethodBeat.o(44110);
  }
  
  public static void l(Application paramApplication)
  {
    AppMethodBeat.i(44108);
    paramApplication.registerActivityLifecycleCallbacks(new a()
    {
      private final SparseIntArray qBp;
      
      private void F(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(44100);
        if (paramAnonymousActivity == null)
        {
          AppMethodBeat.o(44100);
          return;
        }
        this.qBp.put(paramAnonymousActivity.hashCode(), 1);
        e.jdMethod_if(true);
        ceC();
        AppMethodBeat.o(44100);
      }
      
      private void G(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(44101);
        if (paramAnonymousActivity == null)
        {
          AppMethodBeat.o(44101);
          return;
        }
        this.qBp.delete(paramAnonymousActivity.hashCode());
        if (this.qBp.size() <= 0) {
          e.jdMethod_if(false);
        }
        ceC();
        AppMethodBeat.o(44101);
      }
      
      private void ceC()
      {
        AppMethodBeat.i(317719);
        Log.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile][preload]", "alive activity count %d", new Object[] { Integer.valueOf(this.qBp.size()) });
        AppMethodBeat.o(317719);
      }
      
      public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(44102);
        F(paramAnonymousActivity);
        AppMethodBeat.o(44102);
      }
      
      public final void onActivityDestroyed(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(44105);
        G(paramAnonymousActivity);
        AppMethodBeat.o(44105);
      }
      
      public final void onActivityStarted(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(44103);
        F(paramAnonymousActivity);
        AppMethodBeat.o(44103);
      }
      
      public final void onActivityStopped(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(44104);
        G(paramAnonymousActivity);
        AppMethodBeat.o(44104);
      }
    });
    AppMethodBeat.o(44108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.e
 * JD-Core Version:    0.7.0.1
 */