package com.tencent.mm.plugin.appbrand.r;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.api.ParcelableMultiTaskData;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.multitask.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  public b tmN;
  
  public static void D(w paramw)
  {
    AppMethodBeat.i(317616);
    Log.i("MicroMsg.AppBrandMultiTaskLogic", "destroy, runtime:%s", new Object[] { paramw.mAppId });
    AppMethodBeat.o(317616);
  }
  
  public final void C(final w paramw)
  {
    AppMethodBeat.i(317621);
    Log.i("MicroMsg.AppBrandMultiTaskLogic", "init, runtime:%s", new Object[] { paramw.mAppId });
    h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(317609);
        if ((paramw.qsE.get()) || (paramw.ccV))
        {
          Log.w("MicroMsg.AppBrandMultiTaskLogic", "initFloatBallHelper in work thread, but runtime finished");
          AppMethodBeat.o(317609);
          return;
        }
        d locald = new d(paramw);
        c.this.tmN = new b(locald, paramw);
        c.this.tmN.J(1, g.gj(paramw.mAppId, paramw.qsh.eul));
        if (paramw.getInitConfig().qAW != null) {
          c.this.tmN.b(paramw.getInitConfig().qAW.qAD);
        }
        for (;;)
        {
          paramw.U(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(317597);
              if (c.this.tmN != null) {
                c.this.tmN.coi();
              }
              AppMethodBeat.o(317597);
            }
          });
          AppMethodBeat.o(317609);
          return;
          Log.e("MicroMsg.AppBrandMultiTaskLogic", "multiTaskData null! enter scene:%d", new Object[] { Integer.valueOf(paramw.asA().epn.scene) });
          if ((paramw.asA().epn.scene == 1089) || (paramw.asA().epn.scene == 1104)) {
            c.this.tmN.LCW = Boolean.TRUE;
          } else {
            c.this.tmN.LCW = Boolean.FALSE;
          }
        }
      }
    }, "MultiTaskHelperThread");
    AppMethodBeat.o(317621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.c
 * JD-Core Version:    0.7.0.1
 */