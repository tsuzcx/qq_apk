package com.tencent.mm.plugin.finder.nearby.abtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/abtest/FinderFindPageLiveABTest;", "", "()V", "TAG", "", "getFinderLiveSwitch", "isEnableByDynamicConfig", "", "isEnableByExpt", "isEnableFindLive", "isEnableFinder", "isEnableFinderLiveAboveLook", "finder-sdk_release"})
public final class a
{
  public static final a zDp;
  
  static
  {
    AppMethodBeat.i(209850);
    zDp = new a();
    AppMethodBeat.o(209850);
  }
  
  public static boolean cFx()
  {
    AppMethodBeat.i(292894);
    boolean bool1;
    if (com.tencent.mm.n.h.axc().getInt("FinderNewLiveEntryOnTopStorySwitch", 0) == 1)
    {
      bool1 = true;
      com.tencent.mm.plugin.findersdk.d.a.a locala = com.tencent.mm.plugin.findersdk.d.a.a.Bwj;
      if (((Number)com.tencent.mm.plugin.findersdk.d.a.a.etL().aSr()).intValue() != 1) {
        break label102;
      }
    }
    label102:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i("FinderFindPageLiveABTest", "isEnableFinderLiveAboveLook isEnableDynamicConfig:" + bool1 + " isEnableExpt:" + bool2);
      if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE)) {
        break label107;
      }
      AppMethodBeat.o(292894);
      return bool2;
      bool1 = false;
      break;
    }
    label107:
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(292894);
      return true;
    }
    AppMethodBeat.o(292894);
    return false;
  }
  
  public static boolean dLo()
  {
    AppMethodBeat.i(209845);
    Log.i("FinderFindPageLiveABTest", "isEnableFindLive isEnableFinder:" + dLp() + " isEnableByDynamicConfig:" + dLq() + " isEnableByExpt:" + dLr());
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      boolean bool = dLr();
      AppMethodBeat.o(209845);
      return bool;
    }
    if ((dLp()) && ((dLq()) || (dLr())))
    {
      AppMethodBeat.o(209845);
      return true;
    }
    AppMethodBeat.o(209845);
    return false;
  }
  
  private static boolean dLp()
  {
    AppMethodBeat.i(209846);
    boolean bool = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).showFinderEntry();
    AppMethodBeat.o(209846);
    return bool;
  }
  
  private static boolean dLq()
  {
    boolean bool = true;
    AppMethodBeat.i(209847);
    if (com.tencent.mm.n.h.axc().getInt("FinderNewLiveEntrySwitch", 0) == 1) {}
    for (;;)
    {
      Log.i("FinderFindPageLiveABTest", "isEnableByDynamicConfig isEnable:".concat(String.valueOf(bool)));
      AppMethodBeat.o(209847);
      return bool;
      bool = false;
    }
  }
  
  private static boolean dLr()
  {
    AppMethodBeat.i(209848);
    com.tencent.mm.plugin.findersdk.d.a.a locala = com.tencent.mm.plugin.findersdk.d.a.a.Bwj;
    if (((Number)com.tencent.mm.plugin.findersdk.d.a.a.ens().aSr()).intValue() == 1)
    {
      AppMethodBeat.o(209848);
      return true;
    }
    AppMethodBeat.o(209848);
    return false;
  }
  
  public static String eoO()
  {
    AppMethodBeat.i(292895);
    if (cFx())
    {
      AppMethodBeat.o(292895);
      return "settings_finder_live_above_look_switch";
    }
    AppMethodBeat.o(292895);
    return "settings_finder_live_switch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.abtest.a
 * JD-Core Version:    0.7.0.1
 */