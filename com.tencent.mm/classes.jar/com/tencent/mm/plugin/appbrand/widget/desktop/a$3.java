package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.c;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

final class a$3
  implements Runnable
{
  a$3(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(143626);
    Object localObject1;
    Object localObject2;
    double d;
    if (c.jiO.eAT)
    {
      ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doStop performanceMonitor");
      localObject1 = c.jiO;
      ((c)localObject1).frameStartTime = 0L;
      ((c)localObject1).eAQ = 0;
      ((c)localObject1).eAT = false;
      ab.i("MicroMsg.Metronome", "[stop] stack:%s", new Object[] { bo.dtY() });
      ((c)localObject1).choreographer.removeFrameCallback((Choreographer.FrameCallback)localObject1);
      d.jiQ.Py();
      localObject1 = (com.tencent.mm.plugin.appbrand.widget.desktop.b.b)d.jiQ.eAX.get(Integer.valueOf(1));
      if (!(localObject1 instanceof com.tencent.mm.plugin.appbrand.widget.desktop.b.a)) {
        break label354;
      }
      ((com.tencent.mm.plugin.appbrand.widget.desktop.b.b)localObject1).Pv();
      localObject1 = (com.tencent.mm.plugin.appbrand.widget.desktop.b.a)localObject1;
      if (localObject1 != null)
      {
        ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doStop performanceMonitor dump fps, max: %f, min: %f, average: %f", new Object[] { Double.valueOf(((com.tencent.mm.plugin.appbrand.widget.desktop.b.a)localObject1).jiN), Double.valueOf(((com.tencent.mm.plugin.appbrand.widget.desktop.b.a)localObject1).jiM), Double.valueOf(((com.tencent.mm.plugin.appbrand.widget.desktop.b.a)localObject1).jiL) });
        localObject2 = com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.jgw;
        d = ((com.tencent.mm.plugin.appbrand.widget.desktop.b.a)localObject1).jiL;
        ab.i("MicroMsg.DynamicBackgroundConfig", "alvinluo adjustDynamicBackgroundDrawFps currentDrawFps: %d, appFps: %f", new Object[] { Integer.valueOf(com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.jgt), Double.valueOf(d) });
        if (d < 45.0D) {
          break label390;
        }
        b.ff(true);
        if (d < 55.0D) {
          break label359;
        }
        com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.jgt = 20;
      }
    }
    label390:
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.jgv = (int)d;
      localObject1 = ah.dsQ();
      if (localObject1 != null)
      {
        localObject2 = ((SharedPreferences)localObject1).edit();
        if (localObject2 != null)
        {
          localObject2 = ((SharedPreferences.Editor)localObject2).putInt("current_draw_fps", com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.jgt);
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
      ab.i("MicroMsg.DynamicBackgroundConfig", "alvinluo adjustDynamicBackgroundDrawFps appFps: %f, FRAME_PER_SECOND: %d", new Object[] { Double.valueOf(d), Integer.valueOf(com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.jgt) });
      com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.aPI();
      d.jiQ.release();
      al.d(new a.3.1(this));
      AppMethodBeat.o(143626);
      return;
      label354:
      localObject1 = null;
      break;
      label359:
      if (d >= 50.0D)
      {
        com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.jgt = 15;
      }
      else if (d >= 45.0D)
      {
        com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.jgt = 5;
        continue;
        if (com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.jgt == 2)
        {
          ab.i("MicroMsg.DynamicBackgroundConfig", "alvinluo adjustDynamicBackgroundDrawFps disable DynamicBackground");
          b.ff(false);
        }
        else
        {
          com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b.jgt = 2;
          b.ff(true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.3
 * JD-Core Version:    0.7.0.1
 */