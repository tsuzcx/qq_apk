package com.tencent.mm.plugin.appbrand.app;

import android.app.Application;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

public final class c
{
  private static volatile boolean jDn = false;
  private static volatile boolean jDo = false;
  
  public static void a(com.tencent.mm.plugin.appbrand.task.e parame, final AppBrandPreloadProfiler paramAppBrandPreloadProfiler, final boolean paramBoolean1, final boolean paramBoolean2, final int paramInt)
  {
    AppMethodBeat.i(187977);
    jDo = true;
    if ((parame == null) || (parame == com.tencent.mm.plugin.appbrand.task.e.myi))
    {
      ad.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile]", "dl: AppBrandProcessPreloader said I can not preload [nil] type.");
      AppMethodBeat.o(187977);
      return;
    }
    if (paramAppBrandPreloadProfiler == null) {
      paramAppBrandPreloadProfiler = new AppBrandPreloadProfiler();
    }
    for (;;)
    {
      paramAppBrandPreloadProfiler.mxl = SystemClock.elapsedRealtime();
      aq.f(new c.3(new d.g.a.b()
      {
        private Integer KY(String paramAnonymousString)
        {
          AppMethodBeat.i(187974);
          c.Jy();
          boolean bool = c.jDn;
          ad.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile]", "start misc preload type[%s], aggressive[%b], reason[%s], skip[%b]", new Object[] { this.jDq, Boolean.valueOf(paramBoolean1), paramAnonymousString, Boolean.valueOf(bool) });
          if (!bool) {}
          for (;;)
          {
            try
            {
              AppBrandMainProcessService.bhG();
              if (!paramBoolean1) {
                continue;
              }
              if (com.tencent.mm.plugin.appbrand.task.c.byy()) {
                com.tencent.mm.plugin.appbrand.task.c.a(this.jDq, null, true, paramAppBrandPreloadProfiler, paramInt);
              }
              c.KX("preload aggressive before keepalive");
              if (((h)com.tencent.mm.kernel.g.ajz().ajb()).mProcessName.endsWith(":appbrand0")) {
                com.tencent.mm.plugin.appbrand.keepalive.b.b(AppBrandPluginUI.class.getName(), new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(44106);
                    c.KX("preload aggressive after keepalive");
                    AppMethodBeat.o(44106);
                  }
                });
              }
              if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBZ, 0) != 0) && (paramBoolean2)) {
                com.tencent.mm.plugin.appbrand.luggage.c.e.bsB();
              }
            }
            catch (Exception paramAnonymousString)
            {
              ad.printErrStackTrace("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile]", paramAnonymousString, "Preload [%s] in IdleHandler encountered Exception", new Object[] { this.jDq.name() });
              continue;
            }
            AppMethodBeat.o(187974);
            return Integer.valueOf(0);
            com.tencent.mm.plugin.appbrand.task.c.a(this.jDq, null, false, paramAppBrandPreloadProfiler, paramInt);
          }
        }
      }));
      AppMethodBeat.o(187977);
      return;
    }
  }
  
  public static boolean aYC()
  {
    return jDo;
  }
  
  public static void fI(boolean paramBoolean)
  {
    AppMethodBeat.i(44110);
    ad.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile]", "setSkipMiscPreload %b", new Object[] { Boolean.valueOf(paramBoolean) });
    jDn = paramBoolean;
    AppMethodBeat.o(44110);
  }
  
  public static void j(Application paramApplication)
  {
    AppMethodBeat.i(44108);
    paramApplication.registerActivityLifecycleCallbacks(new c.1());
    AppMethodBeat.o(44108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.c
 * JD-Core Version:    0.7.0.1
 */