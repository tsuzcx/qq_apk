package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.z.a;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
{
  private static volatile boolean jjA = false;
  private static volatile boolean jjz = false;
  
  public static void a(com.tencent.mm.plugin.appbrand.task.e parame, final AppBrandPreloadProfiler paramAppBrandPreloadProfiler, final boolean paramBoolean1, final boolean paramBoolean2, final int paramInt)
  {
    AppMethodBeat.i(186290);
    jjA = true;
    if ((parame == null) || (parame == com.tencent.mm.plugin.appbrand.task.e.lYt))
    {
      ac.i("MicroMsg.AppBrandProcessProfileInit[applaunch]", "dl: AppBrandProcessPreloader said I can not preload [nil] type.");
      AppMethodBeat.o(186290);
      return;
    }
    if (paramAppBrandPreloadProfiler == null) {
      paramAppBrandPreloadProfiler = new AppBrandPreloadProfiler();
    }
    for (;;)
    {
      paramAppBrandPreloadProfiler.lXw = SystemClock.elapsedRealtime();
      com.tencent.mm.sdk.f.c.a(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(44107);
          c.adZ();
          Looper.myQueue().removeIdleHandler(this);
          boolean bool = c.jjz;
          ac.i("MicroMsg.AppBrandProcessProfileInit[applaunch]", "start misc preload [%s] aggressive[%b], skip[%b]", new Object[] { this.jjC, Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool) });
          if (!bool) {}
          for (;;)
          {
            try
            {
              AppBrandMainProcessService.bec();
              if (!paramBoolean1) {
                continue;
              }
              if (com.tencent.mm.plugin.appbrand.task.c.but()) {
                com.tencent.mm.plugin.appbrand.task.c.a(this.jjC, null, true, paramAppBrandPreloadProfiler, paramInt);
              }
              c.HG("preload aggressive before keepalive");
              if (((h)com.tencent.mm.kernel.g.agO().agp()).mProcessName.endsWith(":appbrand0")) {
                com.tencent.mm.plugin.appbrand.keepalive.b.b(AppBrandPluginUI.class.getName(), new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(44106);
                    c.HG("preload aggressive after keepalive");
                    AppMethodBeat.o(44106);
                  }
                });
              }
              if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pWX, 0) != 0) && (paramBoolean2)) {
                com.tencent.mm.plugin.appbrand.luggage.c.e.boC();
              }
            }
            catch (Exception localException)
            {
              ac.printErrStackTrace("MicroMsg.AppBrandProcessProfileInit[applaunch]", localException, "Preload [%s] in IdleHandler encountered Exception", new Object[] { this.jjC.name() });
              continue;
            }
            AppMethodBeat.o(44107);
            return false;
            com.tencent.mm.plugin.appbrand.task.c.a(this.jjC, null, false, paramAppBrandPreloadProfiler, paramInt);
          }
        }
      });
      AppMethodBeat.o(186290);
      return;
    }
  }
  
  public static boolean aVi()
  {
    return jjA;
  }
  
  public static void fE(boolean paramBoolean)
  {
    AppMethodBeat.i(44110);
    ac.i("MicroMsg.AppBrandProcessProfileInit[applaunch]", "setSkipMiscPreload %b", new Object[] { Boolean.valueOf(paramBoolean) });
    jjz = paramBoolean;
    AppMethodBeat.o(44110);
  }
  
  public static void h(Application paramApplication)
  {
    AppMethodBeat.i(44108);
    paramApplication.registerActivityLifecycleCallbacks(new a()
    {
      private final SparseIntArray jjB;
      
      private void A(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(44100);
        if (paramAnonymousActivity == null)
        {
          AppMethodBeat.o(44100);
          return;
        }
        this.jjB.put(paramAnonymousActivity.hashCode(), 1);
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
        this.jjB.delete(paramAnonymousActivity.hashCode());
        if (this.jjB.size() <= 0) {
          c.fE(false);
        }
        AppMethodBeat.o(44101);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.c
 * JD-Core Version:    0.7.0.1
 */