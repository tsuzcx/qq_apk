package com.tencent.mm.plugin.appbrand.widget.c;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/HalfScreenDebugger;", "", "()V", "KEY_FORCE_FINDER_SCENE", "", "KEY_FORCE_FIRST_PAGE_NAVIGATION_STYLE_CUSTOM", "KEY_FORCE_HALF_SCREEN", "TAG", "canWork", "", "isForceFinderScene", "isForceFirstPageNavigationStyleCustom", "isForceHalfScreen", "setForceFinderScene", "", "force", "setForceFirstPageNavigationStyleCustom", "setForceHalfScreen", "plugin-appbrand-integration_release"})
public final class c
{
  public static final c rsW;
  
  static
  {
    AppMethodBeat.i(265478);
    rsW = new c();
    AppMethodBeat.o(265478);
  }
  
  public static boolean bLz()
  {
    AppMethodBeat.i(265477);
    if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      AppMethodBeat.o(265477);
      return true;
    }
    AppMethodBeat.o(265477);
    return false;
  }
  
  public static boolean cnL()
  {
    boolean bool = false;
    AppMethodBeat.i(265476);
    if (bLz()) {
      bool = MultiProcessMMKV.getDefault().getBoolean("appbrand_half_screen_debug_force_firstPageNavigationStyleCustom", false);
    }
    Log.i("MicroMsg.HalfScreenDebugger", "isForceFirstPageNavigationStyleCustom[" + bool + ']');
    AppMethodBeat.o(265476);
    return bool;
  }
  
  public static void kk(boolean paramBoolean)
  {
    AppMethodBeat.i(265471);
    Log.i("MicroMsg.HalfScreenDebugger", "setForceHalfScreen[" + paramBoolean + ']');
    MultiProcessMMKV.getDefault().putBoolean("appbrand_half_screen_debug_force_half_screen", paramBoolean).commit();
    AppMethodBeat.o(265471);
  }
  
  public static void kl(boolean paramBoolean)
  {
    AppMethodBeat.i(265473);
    Log.i("MicroMsg.HalfScreenDebugger", "setForceFinderScene[" + paramBoolean + ']');
    MultiProcessMMKV.getDefault().putBoolean("appbrand_half_screen_debug_force_finder_scene", paramBoolean).commit();
    AppMethodBeat.o(265473);
  }
  
  public static void km(boolean paramBoolean)
  {
    AppMethodBeat.i(265475);
    Log.i("MicroMsg.HalfScreenDebugger", "setForceFirstPageNavigationStyleCustom[" + paramBoolean + ']');
    MultiProcessMMKV.getDefault().putBoolean("appbrand_half_screen_debug_force_firstPageNavigationStyleCustom", paramBoolean).commit();
    AppMethodBeat.o(265475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.c.c
 * JD-Core Version:    0.7.0.1
 */