package com.tencent.mm.plugin.appbrand.ui;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.PluginAppBrand;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"value", "", "PAGE_CONTAINER_NAVIGATION_PUSH_TIMEOUT", "()J", "setPAGE_CONTAINER_NAVIGATION_PUSH_TIMEOUT", "(J)V", "", "SHOW_DEBUG_HINT_FOR_WXA_APP_LAUNCH_PROCESS", "()Z", "setSHOW_DEBUG_HINT_FOR_WXA_APP_LAUNCH_PROCESS", "(Z)V", "appBrandDebugUIPrecondition", "getAppBrandDebugUIPrecondition", "plugin-appbrand-integration_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  private static long tZV = 500L;
  private static boolean tZW;
  
  public static final boolean cKM()
  {
    AppMethodBeat.i(322090);
    if (((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (WeChatEnvironment.hasDebugger())) && (!WeChatEnvironment.isMonkeyEnv()))
    {
      AppMethodBeat.o(322090);
      return true;
    }
    AppMethodBeat.o(322090);
    return false;
  }
  
  public static final long cKN()
  {
    AppMethodBeat.i(322096);
    if (!cKM())
    {
      AppMethodBeat.o(322096);
      return 500L;
    }
    long l = PluginAppBrand.getProcessSharedPrefs().getLong("AppBrandDebugUI.PAGE_CONTAINER_NAVIGATION_PUSH_TIMEOUT", 500L);
    AppMethodBeat.o(322096);
    return l;
  }
  
  public static final boolean cKO()
  {
    AppMethodBeat.i(322101);
    if (!cKM())
    {
      AppMethodBeat.o(322101);
      return false;
    }
    boolean bool = PluginAppBrand.getProcessSharedPrefs().getBoolean("AppBrandDebugUI.SHOW_DEBUG_HINT_FOR_WXA_APP_LAUNCH_PROCESS", BuildInfo.DEBUG);
    AppMethodBeat.o(322101);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.c
 * JD-Core Version:    0.7.0.1
 */