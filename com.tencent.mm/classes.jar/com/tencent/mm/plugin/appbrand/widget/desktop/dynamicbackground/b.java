package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import a.l;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundConfig;", "", "()V", "BAN_FPS", "", "CURRENT_DRAW_FPS", "", "DEFAULT_DRAW_FPS", "FRAME_PER_SECOND", "HIGH_FPS", "LAST_APP_FPS", "LOWEST_DRAW_FPS", "LOW_FPS", "MIDDLE_FPS", "MONITOR_CHECK_FPS_DURATION", "", "MONITOR_LAST_CHECK_FPS_TIME", "SLEEP_TIME_IN_MS_PER_FRAME", "", "getSLEEP_TIME_IN_MS_PER_FRAME", "()F", "setSLEEP_TIME_IN_MS_PER_FRAME", "(F)V", "TAG", "lastAppFps", "lastCheckTime", "adjustDynamicBackgroundDrawFps", "", "appFps", "", "computeSleepTimePerFrame", "init", "needMonitorFps", "", "plugin-appbrand-integration_release"})
public final class b
{
  public static int jgt;
  private static float jgu;
  public static int jgv;
  public static final b jgw;
  private static long lastCheckTime;
  
  static
  {
    AppMethodBeat.i(135223);
    jgw = new b();
    jgt = 20;
    jgu = 16.0F;
    lastCheckTime = -1L;
    AppMethodBeat.o(135223);
  }
  
  public static float aPG()
  {
    return jgu;
  }
  
  public static boolean aPH()
  {
    AppMethodBeat.i(135221);
    SharedPreferences localSharedPreferences = ah.dsQ();
    boolean bool;
    if (localSharedPreferences != null)
    {
      long l = localSharedPreferences.getLong("monitory_last_check_time", -1L);
      if (jgv == 0) {
        jgv = localSharedPreferences.getInt("current_app_fps", 0);
      }
      ab.d("MicroMsg.DynamicBackgroundConfig", "alvinluo needMonitorFps lastAppFps: %d, lastCheckTime: %d", new Object[] { Integer.valueOf(jgv), Long.valueOf(l) });
      if ((l == -1L) || (jgv <= 45) || (System.currentTimeMillis() - l > 3600000L))
      {
        localSharedPreferences.edit().putLong("monitory_last_check_time", System.currentTimeMillis()).apply();
        bool = true;
        ab.i("MicroMsg.DynamicBackgroundConfig", "alvinluo needMonitorFps needCheck: %b", new Object[] { Boolean.valueOf(bool) });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(135221);
      return bool;
      bool = false;
      break;
      bool = false;
    }
  }
  
  public static void aPI()
  {
    AppMethodBeat.i(135222);
    Object localObject = ah.dsQ();
    if (localObject != null) {}
    for (int i = ((SharedPreferences)localObject).getInt("current_draw_fps", 20);; i = 20)
    {
      jgt = i;
      jgu = 1000.0F / jgt - 20.0F;
      if (jgt == 2)
      {
        localObject = DynamicBackgroundGLSurfaceView.b.jgL;
        ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo updateAlphaAnimation %d", new Object[] { Long.valueOf(1500L) });
        DynamicBackgroundGLSurfaceView.b.aPO();
      }
      ab.i("MicroMsg.DynamicBackgroundConfig", "alvinluo computeSleepTimePerFrame: %f, fps: %d, DEFAULT_DRAW_FPS: %d", new Object[] { Float.valueOf(jgu), Integer.valueOf(jgt), Integer.valueOf(20) });
      AppMethodBeat.o(135222);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b
 * JD-Core Version:    0.7.0.1
 */