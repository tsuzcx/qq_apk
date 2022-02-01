package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.appbrand.ac.a;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler;
import com.tencent.mm.plugin.appbrand.task.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class e
{
  private static volatile boolean nBY = false;
  private static volatile boolean nBZ = false;
  
  public static void a(n paramn, AppBrandPreloadProfiler paramAppBrandPreloadProfiler, final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(277328);
    nBZ = true;
    if ((paramn == null) || (paramn == n.qRU))
    {
      Log.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile][preload]", "dl: AppBrandProcessPreloader said I can not preload [nil] type.");
      AppMethodBeat.o(277328);
      return;
    }
    final AppBrandPreloadProfiler localAppBrandPreloadProfiler = paramAppBrandPreloadProfiler;
    if (paramAppBrandPreloadProfiler == null) {
      localAppBrandPreloadProfiler = new AppBrandPreloadProfiler();
    }
    localAppBrandPreloadProfiler.qRo = SystemClock.elapsedRealtime();
    MMHandlerThread.postToMainThread(new e.3(new kotlin.g.a.b()
    {
      private Integer acr(String paramAnonymousString)
      {
        AppMethodBeat.i(269975);
        e.Yy();
        boolean bool = e.nBY;
        Log.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile][preload]", "start misc preload type[%s], aggressive[%b], reason[%s], skip[%b], level[%d]", new Object[] { this.nCb, Boolean.valueOf(paramBoolean), paramAnonymousString, Boolean.valueOf(bool), Integer.valueOf(paramInt) });
        if (!bool) {}
        for (;;)
        {
          try
          {
            com.tencent.mm.plugin.appbrand.ipc.b.bPe();
            if (!paramBoolean) {
              continue;
            }
            if (com.tencent.mm.plugin.appbrand.task.h.k(this.nCb)) {
              com.tencent.mm.plugin.appbrand.task.h.a(this.nCb, null, true, localAppBrandPreloadProfiler, paramInt);
            }
            e.acq("preload aggressive before keepalive");
            if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).mProcessName.endsWith(":appbrand0")) {
              com.tencent.mm.plugin.appbrand.keepalive.b.ad(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(44106);
                  e.acq("preload aggressive after keepalive");
                  AppMethodBeat.o(44106);
                }
              });
            }
          }
          catch (Exception paramAnonymousString)
          {
            if (!t.nwr) {
              continue;
            }
            AppMethodBeat.o(269975);
            throw paramAnonymousString;
            Log.printErrStackTrace("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile][preload]", paramAnonymousString, "Preload [%s] in IdleHandler encountered Exception", new Object[] { this.nCb.name() });
            continue;
          }
          AppMethodBeat.o(269975);
          return Integer.valueOf(0);
          com.tencent.mm.plugin.appbrand.task.h.a(this.nCb, null, false, localAppBrandPreloadProfiler, paramInt);
        }
      }
    }));
    AppMethodBeat.o(277328);
  }
  
  public static boolean bFn()
  {
    return nBZ;
  }
  
  public static void ho(boolean paramBoolean)
  {
    AppMethodBeat.i(44110);
    Log.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile][preload]", "setSkipMiscPreload %b", new Object[] { Boolean.valueOf(paramBoolean) });
    nBY = paramBoolean;
    AppMethodBeat.o(44110);
  }
  
  public static void m(Application paramApplication)
  {
    AppMethodBeat.i(44108);
    paramApplication.registerActivityLifecycleCallbacks(new a()
    {
      private final SparseIntArray nCa;
      
      private void A(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(44101);
        if (paramAnonymousActivity == null)
        {
          AppMethodBeat.o(44101);
          return;
        }
        this.nCa.delete(paramAnonymousActivity.hashCode());
        if (this.nCa.size() <= 0) {
          e.ho(false);
        }
        bFo();
        AppMethodBeat.o(44101);
      }
      
      private void bFo()
      {
        AppMethodBeat.i(275529);
        Log.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile][preload]", "alive activity count %d", new Object[] { Integer.valueOf(this.nCa.size()) });
        AppMethodBeat.o(275529);
      }
      
      private void z(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(44100);
        if (paramAnonymousActivity == null)
        {
          AppMethodBeat.o(44100);
          return;
        }
        this.nCa.put(paramAnonymousActivity.hashCode(), 1);
        e.ho(true);
        bFo();
        AppMethodBeat.o(44100);
      }
      
      public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(44102);
        z(paramAnonymousActivity);
        AppMethodBeat.o(44102);
      }
      
      public final void onActivityDestroyed(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(44105);
        A(paramAnonymousActivity);
        AppMethodBeat.o(44105);
      }
      
      public final void onActivityStarted(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(44103);
        z(paramAnonymousActivity);
        AppMethodBeat.o(44103);
      }
      
      public final void onActivityStopped(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(44104);
        A(paramAnonymousActivity);
        AppMethodBeat.o(44104);
      }
    });
    AppMethodBeat.o(44108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.e
 * JD-Core Version:    0.7.0.1
 */