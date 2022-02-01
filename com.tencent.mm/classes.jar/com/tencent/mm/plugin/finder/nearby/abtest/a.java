package com.tencent.mm.plugin.finder.nearby.abtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.findersdk.b.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/abtest/FinderFindPageLiveABTest;", "", "()V", "FINDER_LIVE_ENTRANCE_MMKV", "", "TAG", "entranceMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getEntranceMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "entranceMMKV$delegate", "Lkotlin/Lazy;", "isRunningRequest", "", "getFinderLiveSwitch", "isEnableByDynamicConfig", "isEnableByExpt", "isEnableCardRecomAnim", "isEnableFindLive", "isEnableFinder", "isEnableFinderLiveAboveLook", "requestEntranceCheck", "", "dynamicSwitch", "", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a EHr;
  private static boolean EHs;
  private static final j EHt;
  
  static
  {
    AppMethodBeat.i(339835);
    EHr = new a();
    EHt = k.cm((kotlin.g.a.a)a.EHu);
    AppMethodBeat.o(339835);
  }
  
  private static MultiProcessMMKV eEh()
  {
    AppMethodBeat.i(339792);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)EHt.getValue();
    AppMethodBeat.o(339792);
    return localMultiProcessMMKV;
  }
  
  public static boolean eEi()
  {
    AppMethodBeat.i(339801);
    boolean bool2 = ((cn)h.az(cn.class)).showFinderEntry();
    int i = i.aRC().getInt("FinderNewLiveEntrySwitch", 0);
    int j = eEh().getInt("live_status_flag", -1);
    Log.i("FinderFindPageLiveABTest", "isEnableByDynamicConfig localSwitch: " + j + " dynamicSwitch: " + i);
    boolean bool1;
    if (j != -1)
    {
      if ((i != j) && (!EHs))
      {
        new d(i, (kotlin.g.a.b)new b(i)).bFJ();
        EHs = true;
      }
      if (j == 1) {
        bool1 = true;
      }
    }
    boolean bool3;
    for (;;)
    {
      bool3 = eEj();
      Log.i("FinderFindPageLiveABTest", "isEnableFindLive isEnableFinder: " + bool2 + " isEnableByDynamicConfig: " + bool1 + "  isEnableByExpt: " + bool3);
      if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE)) {
        break;
      }
      bool1 = eEj();
      AppMethodBeat.o(339801);
      return bool1;
      bool1 = false;
      continue;
      eEh().putInt("live_status_flag", i);
      if (i == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    if ((bool2) && ((bool1) || (bool3)))
    {
      AppMethodBeat.o(339801);
      return true;
    }
    AppMethodBeat.o(339801);
    return false;
  }
  
  private static boolean eEj()
  {
    AppMethodBeat.i(339805);
    com.tencent.mm.plugin.findersdk.storage.config.a locala = com.tencent.mm.plugin.findersdk.storage.config.a.Hds;
    if (((Number)com.tencent.mm.plugin.findersdk.storage.config.a.fsc().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(339805);
      return true;
    }
    AppMethodBeat.o(339805);
    return false;
  }
  
  public static boolean eEk()
  {
    AppMethodBeat.i(339809);
    com.tencent.mm.plugin.findersdk.storage.config.a locala = com.tencent.mm.plugin.findersdk.storage.config.a.Hds;
    if (((Number)com.tencent.mm.plugin.findersdk.storage.config.a.fsd().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(339809);
      return true;
    }
    AppMethodBeat.o(339809);
    return false;
  }
  
  public static boolean eEl()
  {
    AppMethodBeat.i(339812);
    boolean bool1;
    if (i.aRC().getInt("FinderNewLiveEntryOnTopStorySwitch", 0) == 1)
    {
      bool1 = true;
      com.tencent.mm.plugin.findersdk.storage.config.a locala = com.tencent.mm.plugin.findersdk.storage.config.a.Hds;
      if (((Number)com.tencent.mm.plugin.findersdk.storage.config.a.fse().bmg()).intValue() != 1) {
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
      AppMethodBeat.o(339812);
      return bool2;
      bool1 = false;
      break;
    }
    label107:
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(339812);
      return true;
    }
    AppMethodBeat.o(339812);
    return false;
  }
  
  public static String eEm()
  {
    AppMethodBeat.i(339819);
    if (eEl())
    {
      AppMethodBeat.o(339819);
      return "settings_finder_live_above_look_switch";
    }
    AppMethodBeat.o(339819);
    return "settings_finder_live_switch";
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<MultiProcessMMKV>
  {
    public static final a EHu;
    
    static
    {
      AppMethodBeat.i(339783);
      EHu = new a();
      AppMethodBeat.o(339783);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    b(int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.abtest.a
 * JD-Core Version:    0.7.0.1
 */