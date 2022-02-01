package com.tencent.mm.plugin.appbrand.q;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.api.ParcelableMultiTaskData;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.multitask.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public final class c
{
  public b nhs;
  
  public static void w(q paramq)
  {
    AppMethodBeat.i(227212);
    Log.i("MicroMsg.AppBrandMultiTaskLogic", "destroy, runtime:%s", new Object[] { paramq.mAppId });
    AppMethodBeat.o(227212);
  }
  
  public final void v(final q paramq)
  {
    AppMethodBeat.i(227211);
    Log.i("MicroMsg.AppBrandMultiTaskLogic", "init, runtime:%s", new Object[] { paramq.mAppId });
    h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(227210);
        if ((paramq.isDestroyed()) || (paramq.SO))
        {
          Log.w("MicroMsg.AppBrandMultiTaskLogic", "initFloatBallHelper in work thread, but runtime finished");
          AppMethodBeat.o(227210);
          return;
        }
        d locald = new d(AndroidContextUtil.castActivityOrNull(paramq.mContext), paramq);
        c.this.nhs = new b(locald, paramq);
        c.this.nhs.G(1, g.eP(paramq.mAppId, paramq.kAq.eix));
        if (paramq.bsC().kHP != null) {
          c.this.nhs.a(paramq.bsC().kHP.kHu);
        }
        for (;;)
        {
          paramq.O(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(227209);
              if (c.this.nhs != null) {
                c.this.nhs.bCA();
              }
              AppMethodBeat.o(227209);
            }
          });
          AppMethodBeat.o(227210);
          return;
          Log.e("MicroMsg.AppBrandMultiTaskLogic", "multiTaskData null! enter scene:%d", new Object[] { Integer.valueOf(paramq.ON().cyA.scene) });
          if ((paramq.ON().cyA.scene == 1089) || (paramq.ON().cyA.scene == 1104)) {
            c.this.nhs.AbJ = Boolean.TRUE;
          } else {
            c.this.nhs.AbJ = Boolean.FALSE;
          }
        }
      }
    }, "MultiTaskHelperThread");
    AppMethodBeat.o(227211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.c
 * JD-Core Version:    0.7.0.1
 */