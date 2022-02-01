package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.a.c;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundConfig;", "", "()V", "BAN_FPS", "", "CURRENT_DRAW_FPS", "", "DEFAULT_DRAW_FPS", "FRAME_PER_SECOND", "HIGH_FPS", "LAST_APP_FPS", "LOWEST_DRAW_FPS", "LOW_FPS", "MIDDLE_FPS", "MONITOR_CHECK_FPS_DURATION", "", "MONITOR_LAST_CHECK_FPS_TIME", "SLEEP_TIME_IN_MS_PER_FRAME", "", "getSLEEP_TIME_IN_MS_PER_FRAME", "()F", "setSLEEP_TIME_IN_MS_PER_FRAME", "(F)V", "TAG", "lastAppFps", "lastCheckTime", "adjustDynamicBackgroundDrawFps", "", "appFps", "", "computeSleepTimePerFrame", "init", "needMonitorFps", "", "plugin-appbrand-integration_release"})
public final class a
{
  public static int lWt;
  private static float lWu;
  public static int lWv;
  public static final a lWw;
  private static long lastCheckTime;
  
  static
  {
    AppMethodBeat.i(51418);
    lWw = new a();
    lWt = 20;
    lWu = 16.0F;
    lastCheckTime = -1L;
    AppMethodBeat.o(51418);
  }
  
  public static float bsf()
  {
    return lWu;
  }
  
  public static boolean bsg()
  {
    AppMethodBeat.i(51416);
    SharedPreferences localSharedPreferences = aj.eFE();
    boolean bool;
    if (localSharedPreferences != null)
    {
      long l = localSharedPreferences.getLong("monitory_last_check_time", -1L);
      if (lWv == 0) {
        lWv = localSharedPreferences.getInt("current_app_fps", 0);
      }
      ad.d("MicroMsg.DynamicBackgroundConfig", "alvinluo needMonitorFps lastAppFps: %d, lastCheckTime: %d", new Object[] { Integer.valueOf(lWv), Long.valueOf(l) });
      if ((l == -1L) || (lWv <= 45) || (System.currentTimeMillis() - l > 3600000L))
      {
        localSharedPreferences.edit().putLong("monitory_last_check_time", System.currentTimeMillis()).apply();
        bool = true;
        ad.i("MicroMsg.DynamicBackgroundConfig", "alvinluo needMonitorFps needCheck: %b", new Object[] { Boolean.valueOf(bool) });
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
  
  public static void bsh()
  {
    AppMethodBeat.i(51417);
    Object localObject = aj.eFE();
    if (localObject != null) {}
    for (int i = ((SharedPreferences)localObject).getInt("current_draw_fps", 20);; i = 20)
    {
      lWt = i;
      lWu = 1000.0F / lWt - 20.0F;
      if (lWt == 2)
      {
        localObject = DynamicBackgroundGLSurfaceView.b.fIZ;
        c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo updateAlphaAnimation %d", new Object[] { Long.valueOf(1500L) });
        DynamicBackgroundGLSurfaceView.b.aaz();
      }
      ad.i("MicroMsg.DynamicBackgroundConfig", "alvinluo computeSleepTimePerFrame: %f, fps: %d, DEFAULT_DRAW_FPS: %d", new Object[] { Float.valueOf(lWu), Integer.valueOf(lWt), Integer.valueOf(20) });
      AppMethodBeat.o(51417);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.a
 * JD-Core Version:    0.7.0.1
 */