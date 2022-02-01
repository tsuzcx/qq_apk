package com.tencent.mm.plugin.appbrand.q;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.api.ParcelableMultiTaskData;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.multitask.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  public b qib;
  
  public static void x(t paramt)
  {
    AppMethodBeat.i(276859);
    Log.i("MicroMsg.AppBrandMultiTaskLogic", "destroy, runtime:%s", new Object[] { paramt.mAppId });
    AppMethodBeat.o(276859);
  }
  
  public final void w(final t paramt)
  {
    AppMethodBeat.i(276858);
    Log.i("MicroMsg.AppBrandMultiTaskLogic", "init, runtime:%s", new Object[] { paramt.mAppId });
    h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(277629);
        if ((paramt.ntU.get()) || (paramt.aol))
        {
          Log.w("MicroMsg.AppBrandMultiTaskLogic", "initFloatBallHelper in work thread, but runtime finished");
          AppMethodBeat.o(277629);
          return;
        }
        d locald = new d(paramt);
        c.this.qib = new b(locald, paramt);
        c.this.qib.I(1, g.fq(paramt.mAppId, paramt.ntz.cBI));
        if (paramt.bDy().nBI != null) {
          c.this.qib.b(paramt.bDy().nBI.nBo);
        }
        for (;;)
        {
          paramt.O(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(284378);
              if (c.this.qib != null) {
                c.this.qib.bNV();
              }
              AppMethodBeat.o(284378);
            }
          });
          AppMethodBeat.o(277629);
          return;
          Log.e("MicroMsg.AppBrandMultiTaskLogic", "multiTaskData null! enter scene:%d", new Object[] { Integer.valueOf(paramt.Sk().cxf.scene) });
          if ((paramt.Sk().cxf.scene == 1089) || (paramt.Sk().cxf.scene == 1104)) {
            c.this.qib.FHw = Boolean.TRUE;
          } else {
            c.this.qib.FHw = Boolean.FALSE;
          }
        }
      }
    }, "MultiTaskHelperThread");
    AppMethodBeat.o(276858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.c
 * JD-Core Version:    0.7.0.1
 */