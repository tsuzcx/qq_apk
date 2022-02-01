package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.plugin.appbrand.ac.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class e
{
  private static volatile boolean kIi = false;
  private static volatile boolean kIj = false;
  
  public static void a(com.tencent.mm.plugin.appbrand.task.g paramg, AppBrandPreloadProfiler paramAppBrandPreloadProfiler, final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(226298);
    kIj = true;
    if ((paramg == null) || (paramg == com.tencent.mm.plugin.appbrand.task.g.nPF))
    {
      Log.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile][preload]", "dl: AppBrandProcessPreloader said I can not preload [nil] type.");
      AppMethodBeat.o(226298);
      return;
    }
    final AppBrandPreloadProfiler localAppBrandPreloadProfiler = paramAppBrandPreloadProfiler;
    if (paramAppBrandPreloadProfiler == null) {
      localAppBrandPreloadProfiler = new AppBrandPreloadProfiler();
    }
    localAppBrandPreloadProfiler.nOE = SystemClock.elapsedRealtime();
    MMHandlerThread.postToMainThread(new Runnable()
    {
      private Integer UH(String paramAnonymousString)
      {
        AppMethodBeat.i(226295);
        e.TT();
        boolean bool = e.kIi;
        Log.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile][preload]", "start misc preload type[%s], aggressive[%b], reason[%s], skip[%b], level[%d]", new Object[] { this.kIl, Boolean.valueOf(paramBoolean), paramAnonymousString, Boolean.valueOf(bool), Integer.valueOf(paramInt) });
        if (!bool) {}
        for (;;)
        {
          try
          {
            AppBrandMainProcessService.bDD();
            if (!paramBoolean) {
              continue;
            }
            if (com.tencent.mm.plugin.appbrand.task.e.l(this.kIl)) {
              com.tencent.mm.plugin.appbrand.task.e.a(this.kIl, null, true, localAppBrandPreloadProfiler, paramInt);
            }
            e.UG("preload aggressive before keepalive");
            if (((h)com.tencent.mm.kernel.g.aAe().azG()).mProcessName.endsWith(":appbrand0")) {
              com.tencent.mm.plugin.appbrand.keepalive.b.c(AppBrandPluginUI.class.getName(), new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(44106);
                  e.UG("preload aggressive after keepalive");
                  AppMethodBeat.o(44106);
                }
              });
            }
          }
          catch (Exception paramAnonymousString)
          {
            if (!q.kDg) {
              continue;
            }
            AppMethodBeat.o(226295);
            throw paramAnonymousString;
            Log.printErrStackTrace("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile][preload]", paramAnonymousString, "Preload [%s] in IdleHandler encountered Exception", new Object[] { this.kIl.name() });
            continue;
          }
          AppMethodBeat.o(226295);
          return Integer.valueOf(0);
          com.tencent.mm.plugin.appbrand.task.e.a(this.kIl, null, false, localAppBrandPreloadProfiler, paramInt);
        }
      }
    }
    {
      public final void run()
      {
        AppMethodBeat.i(226297);
        this.kIq.invoke("MMHandlerThread.postToMainThread");
        AppMethodBeat.o(226297);
      }
    });
    AppMethodBeat.o(226298);
  }
  
  public static boolean bun()
  {
    return kIj;
  }
  
  public static void gD(boolean paramBoolean)
  {
    AppMethodBeat.i(44110);
    Log.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile][preload]", "setSkipMiscPreload %b", new Object[] { Boolean.valueOf(paramBoolean) });
    kIi = paramBoolean;
    AppMethodBeat.o(44110);
  }
  
  public static void j(Application paramApplication)
  {
    AppMethodBeat.i(44108);
    paramApplication.registerActivityLifecycleCallbacks(new a()
    {
      private final SparseIntArray kIk;
      
      private void A(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(44100);
        if (paramAnonymousActivity == null)
        {
          AppMethodBeat.o(44100);
          return;
        }
        this.kIk.put(paramAnonymousActivity.hashCode(), 1);
        e.gD(true);
        buo();
        AppMethodBeat.o(44100);
      }
      
      private void B(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(44101);
        if (paramAnonymousActivity == null)
        {
          AppMethodBeat.o(44101);
          return;
        }
        this.kIk.delete(paramAnonymousActivity.hashCode());
        if (this.kIk.size() <= 0) {
          e.gD(false);
        }
        buo();
        AppMethodBeat.o(44101);
      }
      
      private void buo()
      {
        AppMethodBeat.i(226294);
        Log.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile][preload]", "alive activity count %d", new Object[] { Integer.valueOf(this.kIk.size()) });
        AppMethodBeat.o(226294);
      }
      
      public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(44102);
        A(paramAnonymousActivity);
        AppMethodBeat.o(44102);
      }
      
      public final void onActivityDestroyed(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(44105);
        B(paramAnonymousActivity);
        AppMethodBeat.o(44105);
      }
      
      public final void onActivityStarted(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(44103);
        A(paramAnonymousActivity);
        AppMethodBeat.o(44103);
      }
      
      public final void onActivityStopped(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(44104);
        B(paramAnonymousActivity);
        AppMethodBeat.o(44104);
      }
    });
    AppMethodBeat.o(44108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.e
 * JD-Core Version:    0.7.0.1
 */