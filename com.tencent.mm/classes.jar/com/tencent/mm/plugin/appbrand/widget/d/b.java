package com.tencent.mm.plugin.appbrand.widget.d;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/HalfScreenDebugger;", "", "()V", "KEY_FORCE_FINDER_SCENE", "", "KEY_FORCE_FIRST_PAGE_NAVIGATION_STYLE_CUSTOM", "KEY_FORCE_FORBID_SLIDING_UP_GESTURE", "KEY_FORCE_HALF_SCREEN", "TAG", "canWork", "", "isForbidSlidingUpGesture", "isForceFinderScene", "isForceFirstPageNavigationStyleCustom", "isForceHalfScreen", "setForceFinderScene", "", "force", "setForceFirstPageNavigationStyleCustom", "setForceForbidSlidingUpGesture", "setForceHalfScreen", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b uDz;
  
  static
  {
    AppMethodBeat.i(324331);
    uDz = new b();
    AppMethodBeat.o(324331);
  }
  
  public static boolean cPW()
  {
    boolean bool = false;
    AppMethodBeat.i(324320);
    if (ckW()) {
      bool = MultiProcessMMKV.getDefault().getBoolean("appbrand_half_screen_debug_force_firstPageNavigationStyleCustom", false);
    }
    Log.i("MicroMsg.HalfScreenDebugger", "isForceFirstPageNavigationStyleCustom[" + bool + ']');
    AppMethodBeat.o(324320);
    return bool;
  }
  
  public static boolean ckW()
  {
    AppMethodBeat.i(324327);
    if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      AppMethodBeat.o(324327);
      return true;
    }
    AppMethodBeat.o(324327);
    return false;
  }
  
  public static void lu(boolean paramBoolean)
  {
    AppMethodBeat.i(324293);
    Log.i("MicroMsg.HalfScreenDebugger", "setForceHalfScreen[" + paramBoolean + ']');
    MultiProcessMMKV.getDefault().putBoolean("appbrand_half_screen_debug_force_half_screen", paramBoolean).commit();
    AppMethodBeat.o(324293);
  }
  
  public static void lv(boolean paramBoolean)
  {
    AppMethodBeat.i(324299);
    Log.i("MicroMsg.HalfScreenDebugger", "setForceFinderScene[" + paramBoolean + ']');
    MultiProcessMMKV.getDefault().putBoolean("appbrand_half_screen_debug_force_finder_scene", paramBoolean).commit();
    AppMethodBeat.o(324299);
  }
  
  public static void lw(boolean paramBoolean)
  {
    AppMethodBeat.i(324304);
    Log.i("MicroMsg.HalfScreenDebugger", "setForceFirstPageNavigationStyleCustom[" + paramBoolean + ']');
    MultiProcessMMKV.getDefault().putBoolean("appbrand_half_screen_debug_force_firstPageNavigationStyleCustom", paramBoolean).commit();
    AppMethodBeat.o(324304);
  }
  
  public static void lx(boolean paramBoolean)
  {
    AppMethodBeat.i(324311);
    Log.i("MicroMsg.HalfScreenDebugger", "setForceForbidSlidingUpGesture[" + paramBoolean + ']');
    MultiProcessMMKV.getDefault().putBoolean("appbrand_half_screen_debug_force_forbid_sliding_up_gesture", paramBoolean).commit();
    AppMethodBeat.o(324311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.b
 * JD-Core Version:    0.7.0.1
 */