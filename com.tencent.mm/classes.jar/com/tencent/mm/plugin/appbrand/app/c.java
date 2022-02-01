package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.y.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;

public final class c
{
  private static volatile boolean jGl = false;
  private static volatile boolean jGm = false;
  
  public static void a(com.tencent.mm.plugin.appbrand.task.e parame, final AppBrandPreloadProfiler paramAppBrandPreloadProfiler, final boolean paramBoolean1, final boolean paramBoolean2, final int paramInt)
  {
    AppMethodBeat.i(222091);
    jGm = true;
    if ((parame == null) || (parame == com.tencent.mm.plugin.appbrand.task.e.mDg))
    {
      ae.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile]", "dl: AppBrandProcessPreloader said I can not preload [nil] type.");
      AppMethodBeat.o(222091);
      return;
    }
    if (paramAppBrandPreloadProfiler == null) {
      paramAppBrandPreloadProfiler = new AppBrandPreloadProfiler();
    }
    for (;;)
    {
      paramAppBrandPreloadProfiler.mCi = SystemClock.elapsedRealtime();
      ar.f(new Runnable()
      {
        private Integer Ly(String paramAnonymousString)
        {
          AppMethodBeat.i(222088);
          c.JG();
          boolean bool = c.jGl;
          ae.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile]", "start misc preload type[%s], aggressive[%b], reason[%s], skip[%b]", new Object[] { this.jGo, Boolean.valueOf(paramBoolean1), paramAnonymousString, Boolean.valueOf(bool) });
          if (!bool) {}
          for (;;)
          {
            try
            {
              AppBrandMainProcessService.bio();
              if (!paramBoolean1) {
                continue;
              }
              if (com.tencent.mm.plugin.appbrand.task.c.bzr()) {
                com.tencent.mm.plugin.appbrand.task.c.a(this.jGo, null, true, paramAppBrandPreloadProfiler, paramInt);
              }
              c.Lx("preload aggressive before keepalive");
              if (((h)com.tencent.mm.kernel.g.ajO().ajq()).mProcessName.endsWith(":appbrand0")) {
                com.tencent.mm.plugin.appbrand.keepalive.b.b(AppBrandPluginUI.class.getName(), new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(44106);
                    c.Lx("preload aggressive after keepalive");
                    AppMethodBeat.o(44106);
                  }
                });
              }
              if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qJv, 0) != 0) && (paramBoolean2)) {
                com.tencent.mm.plugin.appbrand.luggage.c.e.btm();
              }
            }
            catch (Exception paramAnonymousString)
            {
              ae.printErrStackTrace("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile]", paramAnonymousString, "Preload [%s] in IdleHandler encountered Exception", new Object[] { this.jGo.name() });
              continue;
            }
            AppMethodBeat.o(222088);
            return Integer.valueOf(0);
            com.tencent.mm.plugin.appbrand.task.c.a(this.jGo, null, false, paramAppBrandPreloadProfiler, paramInt);
          }
        }
      }
      {
        public final void run()
        {
          AppMethodBeat.i(222090);
          this.jGu.invoke("MMHandlerThread.postToMainThread");
          AppMethodBeat.o(222090);
        }
      });
      AppMethodBeat.o(222091);
      return;
    }
  }
  
  public static boolean aYY()
  {
    return jGm;
  }
  
  public static void fH(boolean paramBoolean)
  {
    AppMethodBeat.i(44110);
    ae.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile]", "setSkipMiscPreload %b", new Object[] { Boolean.valueOf(paramBoolean) });
    jGl = paramBoolean;
    AppMethodBeat.o(44110);
  }
  
  public static void k(Application paramApplication)
  {
    AppMethodBeat.i(44108);
    paramApplication.registerActivityLifecycleCallbacks(new a()
    {
      private final SparseIntArray jGn;
      
      private void A(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(44100);
        if (paramAnonymousActivity == null)
        {
          AppMethodBeat.o(44100);
          return;
        }
        this.jGn.put(paramAnonymousActivity.hashCode(), 1);
        c.fH(true);
        aYZ();
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
        this.jGn.delete(paramAnonymousActivity.hashCode());
        if (this.jGn.size() <= 0) {
          c.fH(false);
        }
        aYZ();
        AppMethodBeat.o(44101);
      }
      
      private void aYZ()
      {
        AppMethodBeat.i(222087);
        ae.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile]", "alive activity count %d", new Object[] { Integer.valueOf(this.jGn.size()) });
        AppMethodBeat.o(222087);
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