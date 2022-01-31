package com.tencent.mm.plugin.appbrand.app;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.sdk.platformtools.ab;

final class c$1
  implements Runnable
{
  c$1(g paramg, boolean paramBoolean, AppBrandPreloadProfiler paramAppBrandPreloadProfiler) {}
  
  public final void run()
  {
    AppMethodBeat.i(129193);
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(129192);
        c.Pt();
        Looper.myQueue().removeIdleHandler(this);
        boolean bool = c.access$100();
        ab.i("MicroMsg.AppBrandProcessProfileInit[applaunch]", "start misc preload [%s] aggressive[%b], skip[%b]", new Object[] { c.1.this.gSx, Boolean.valueOf(c.1.this.gSy), Boolean.valueOf(bool) });
        if ((!bool) || (c.1.this.gSy)) {}
        try
        {
          AppBrandMainProcessService.aBa();
          if (c.1.this.gSy) {
            if (e.aLM()) {
              e.a(c.1.this.gSx, null, true, c.1.this.gSz);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(129192);
            return false;
            e.a(c.1.this.gSx, null, false, c.1.this.gSz);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.AppBrandProcessProfileInit[applaunch]", localException, "Preload [%s] in IdleHandler encountered Exception", new Object[] { c.1.this.gSx.name() });
          }
        }
      }
    });
    AppMethodBeat.o(129193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.c.1
 * JD-Core Version:    0.7.0.1
 */