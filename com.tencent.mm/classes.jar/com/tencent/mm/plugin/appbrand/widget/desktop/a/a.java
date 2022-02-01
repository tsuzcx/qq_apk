package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.a.c;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundConfig;", "", "()V", "BAN_FPS", "", "CURRENT_DRAW_FPS", "", "DEFAULT_DRAW_FPS", "FRAME_PER_SECOND", "HIGH_FPS", "LAST_APP_FPS", "LOWEST_DRAW_FPS", "LOW_FPS", "MIDDLE_FPS", "MONITOR_CHECK_FPS_DURATION", "", "MONITOR_LAST_CHECK_FPS_TIME", "SLEEP_TIME_IN_MS_PER_FRAME", "", "getSLEEP_TIME_IN_MS_PER_FRAME", "()F", "setSLEEP_TIME_IN_MS_PER_FRAME", "(F)V", "TAG", "lastAppFps", "lastCheckTime", "adjustDynamicBackgroundDrawFps", "", "appFps", "", "computeSleepTimePerFrame", "init", "needMonitorFps", "", "plugin-appbrand-integration_release"})
public final class a
{
  private static long lastCheckTime;
  public static int nek;
  private static float nel;
  public static int nem;
  public static final a nen;
  
  static
  {
    AppMethodBeat.i(51418);
    nen = new a();
    nek = 20;
    nel = 16.0F;
    lastCheckTime = -1L;
    AppMethodBeat.o(51418);
  }
  
  public static float bEb()
  {
    return nel;
  }
  
  public static boolean bEc()
  {
    AppMethodBeat.i(51416);
    SharedPreferences localSharedPreferences = ak.fox();
    boolean bool;
    if (localSharedPreferences != null)
    {
      long l = localSharedPreferences.getLong("monitory_last_check_time", -1L);
      if (nem == 0) {
        nem = localSharedPreferences.getInt("current_app_fps", 0);
      }
      ae.d("MicroMsg.DynamicBackgroundConfig", "alvinluo needMonitorFps lastAppFps: %d, lastCheckTime: %d", new Object[] { Integer.valueOf(nem), Long.valueOf(l) });
      if ((l == -1L) || (nem <= 45) || (System.currentTimeMillis() - l > 3600000L))
      {
        localSharedPreferences.edit().putLong("monitory_last_check_time", System.currentTimeMillis()).apply();
        bool = true;
        ae.i("MicroMsg.DynamicBackgroundConfig", "alvinluo needMonitorFps needCheck: %b", new Object[] { Boolean.valueOf(bool) });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(51416);
      return bool;
      bool = false;
      break;
      bool = false;
    }
  }
  
  public static void bEd()
  {
    AppMethodBeat.i(51417);
    Object localObject = ak.fox();
    if (localObject != null) {}
    for (int i = ((SharedPreferences)localObject).getInt("current_draw_fps", 20);; i = 20)
    {
      nek = i;
      nel = 1000.0F / nek - 20.0F;
      if (nek == 2)
      {
        localObject = DynamicBackgroundGLSurfaceView.b.gix;
        c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo updateAlphaAnimation %d", new Object[] { Long.valueOf(1500L) });
        DynamicBackgroundGLSurfaceView.b.aeo();
      }
      ae.i("MicroMsg.DynamicBackgroundConfig", "alvinluo computeSleepTimePerFrame: %f, fps: %d, DEFAULT_DRAW_FPS: %d", new Object[] { Float.valueOf(nel), Integer.valueOf(nek), Integer.valueOf(20) });
      AppMethodBeat.o(51417);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.a
 * JD-Core Version:    0.7.0.1
 */