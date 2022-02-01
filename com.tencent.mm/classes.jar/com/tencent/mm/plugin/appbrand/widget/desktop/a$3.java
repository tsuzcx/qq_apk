package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.c.c;
import com.tencent.mm.plugin.appbrand.widget.desktop.c.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

final class a$3
  extends com.tencent.e.i.b
{
  a$3(a parama) {}
  
  public final String getKey()
  {
    return "MicroMsg.AppBrandDesktopAnimController#stopMonitorRunnable";
  }
  
  public final void run()
  {
    AppMethodBeat.i(49388);
    Object localObject1;
    Object localObject2;
    double d;
    if (c.lYe.fWx)
    {
      ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doStop performanceMonitor");
      localObject1 = c.lYe;
      ((c)localObject1).fWt = 0L;
      ((c)localObject1).fWu = 0;
      ((c)localObject1).fWx = false;
      ad.i("MicroMsg.Metronome", "[stop] stack:%s", new Object[] { bt.eGN() });
      ((c)localObject1).adb().removeFrameCallback((Choreographer.FrameCallback)localObject1);
      d.lYh.ade();
      localObject1 = (com.tencent.mm.plugin.appbrand.widget.desktop.c.b)d.lYh.fWC.get(Integer.valueOf(1));
      if (!(localObject1 instanceof com.tencent.mm.plugin.appbrand.widget.desktop.c.a)) {
        break label354;
      }
      ((com.tencent.mm.plugin.appbrand.widget.desktop.c.b)localObject1).acZ();
      localObject1 = (com.tencent.mm.plugin.appbrand.widget.desktop.c.a)localObject1;
      if (localObject1 != null)
      {
        ad.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doStop performanceMonitor dump fps, max: %f, min: %f, average: %f", new Object[] { Double.valueOf(((com.tencent.mm.plugin.appbrand.widget.desktop.c.a)localObject1).gnA), Double.valueOf(((com.tencent.mm.plugin.appbrand.widget.desktop.c.a)localObject1).gnz), Double.valueOf(((com.tencent.mm.plugin.appbrand.widget.desktop.c.a)localObject1).lYd) });
        localObject2 = com.tencent.mm.plugin.appbrand.widget.desktop.a.a.lWw;
        d = ((com.tencent.mm.plugin.appbrand.widget.desktop.c.a)localObject1).lYd;
        ad.i("MicroMsg.DynamicBackgroundConfig", "alvinluo adjustDynamicBackgroundDrawFps currentDrawFps: %d, appFps: %f", new Object[] { Integer.valueOf(com.tencent.mm.plugin.appbrand.widget.desktop.a.a.lWt), Double.valueOf(d) });
        if (d < 45.0D) {
          break label390;
        }
        b.ht(true);
        if (d < 55.0D) {
          break label359;
        }
        com.tencent.mm.plugin.appbrand.widget.desktop.a.a.lWt = 20;
      }
    }
    label390:
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.widget.desktop.a.a.lWv = (int)d;
      localObject1 = aj.eFE();
      if (localObject1 != null)
      {
        localObject2 = ((SharedPreferences)localObject1).edit();
        if (localObject2 != null)
        {
          localObject2 = ((SharedPreferences.Editor)localObject2).putInt("current_draw_fps", com.tencent.mm.plugin.appbrand.widget.desktop.a.a.lWt);
          if (localObject2 != null) {
            ((SharedPreferences.Editor)localObject2).apply();
          }
        }
      }
      if (localObject1 != null)
      {
        localObject1 = ((SharedPreferences)localObject1).edit();
        if (localObject1 != null)
        {
          localObject1 = ((SharedPreferences.Editor)localObject1).putInt("current_app_fps", (int)d);
          if (localObject1 != null) {
            ((SharedPreferences.Editor)localObject1).apply();
          }
        }
      }
      ad.i("MicroMsg.DynamicBackgroundConfig", "alvinluo adjustDynamicBackgroundDrawFps appFps: %f, FRAME_PER_SECOND: %d", new Object[] { Double.valueOf(d), Integer.valueOf(com.tencent.mm.plugin.appbrand.widget.desktop.a.a.lWt) });
      com.tencent.mm.plugin.appbrand.widget.desktop.a.a.bsh();
      d.lYh.release();
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49387);
          a.o(a.3.this.lSQ);
          a.p(a.3.this.lSQ);
          AppMethodBeat.o(49387);
        }
      });
      AppMethodBeat.o(49388);
      return;
      label354:
      localObject1 = null;
      break;
      label359:
      if (d >= 50.0D)
      {
        com.tencent.mm.plugin.appbrand.widget.desktop.a.a.lWt = 15;
      }
      else if (d >= 45.0D)
      {
        com.tencent.mm.plugin.appbrand.widget.desktop.a.a.lWt = 5;
        continue;
        if (com.tencent.mm.plugin.appbrand.widget.desktop.a.a.lWt == 2)
        {
          ad.i("MicroMsg.DynamicBackgroundConfig", "alvinluo adjustDynamicBackgroundDrawFps disable DynamicBackground");
          b.ht(false);
        }
        else
        {
          com.tencent.mm.plugin.appbrand.widget.desktop.a.a.lWt = 2;
          b.ht(true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.3
 * JD-Core Version:    0.7.0.1
 */