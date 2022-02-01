package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/reddot/RedDotDynamicConfig;", "", "()V", "currentFastEnterLevel", "", "getCurrentFastEnterLevel", "()I", "finderFastEnterTime", "", "getFinderFastEnterTime", "()J", "friendEntranceTimeMs", "getFriendEntranceTimeMs", "fullScreenTabShowed", "", "getFullScreenTabShowed", "()Z", "lastExitFinderTlTime", "getLastExitFinderTlTime", "lastExitNearbyTime", "getLastExitNearbyTime", "moreTabFollowEntranceTimeMs", "getMoreTabFollowEntranceTimeMs", "moreTabFollowTabTimeMs", "getMoreTabFollowTabTimeMs", "moreTabFriendEntranceTimeMs", "getMoreTabFriendEntranceTimeMs", "moreTabHotEntranceTimeMs", "getMoreTabHotEntranceTimeMs", "moreTabLiveEntranceTimeMs", "getMoreTabLiveEntranceTimeMs", "moreTabNearbyEntranceTimeMs", "getMoreTabNearbyEntranceTimeMs", "moreTabNewsEntranceTimeMs", "getMoreTabNewsEntranceTimeMs", "newFeedTipsFastEnterFirstTimeInterval", "getNewFeedTipsFastEnterFirstTimeInterval", "newFeedTipsFastEnterSecondTimeInterval", "getNewFeedTipsFastEnterSecondTimeInterval", "newFeedTipsFastEnterThirdTimeInterval", "getNewFeedTipsFastEnterThirdTimeInterval", "newFollowTipsEnterInterval", "getNewFollowTipsEnterInterval", "newMsgEntranceInterval", "getNewMsgEntranceInterval", "newUnFollowTipsEnterInterval", "getNewUnFollowTipsEnterInterval", "refreshDiscoveryTimeMs", "getRefreshDiscoveryTimeMs", "refreshEntranceInterval", "getRefreshEntranceInterval", "addLevelTime", "setCurrentFastEnterLevel", "", "level", "setFullScreenTabShowed", "isShowed", "testFactor", "updateLastExitTime", "updateNearbyLastExitTime", "plugin-finder_release"})
public final class l
{
  public static final l tLu;
  
  static
  {
    AppMethodBeat.i(178219);
    tLu = new l();
    AppMethodBeat.o(178219);
  }
  
  public static void ID(int paramInt)
  {
    AppMethodBeat.i(178214);
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.OkA, Integer.valueOf(paramInt));
    AppMethodBeat.o(178214);
  }
  
  public static long dbI()
  {
    AppMethodBeat.i(178209);
    com.tencent.mm.kernel.c.a locala = g.af(com.tencent.mm.plugin.zero.b.a.class);
    p.g(locala, "MMKernel.service(IConfigService::class.java)");
    long l = ((com.tencent.mm.plugin.zero.b.a)locala).aqJ().getInt("FinderFastEnterTime", 0);
    AppMethodBeat.o(178209);
    return l * 1000L;
  }
  
  private static long dbJ()
  {
    AppMethodBeat.i(178210);
    com.tencent.mm.kernel.c.a locala = g.af(com.tencent.mm.plugin.zero.b.a.class);
    p.g(locala, "MMKernel.service(IConfigService::class.java)");
    long l = ((com.tencent.mm.plugin.zero.b.a)locala).aqJ().getInt("FinderNewFeedTipsFastEnterFirstTimeInterval", 86400) * 1000L / dbT();
    AppMethodBeat.o(178210);
    return l;
  }
  
  private static long dbK()
  {
    AppMethodBeat.i(178211);
    com.tencent.mm.kernel.c.a locala = g.af(com.tencent.mm.plugin.zero.b.a.class);
    p.g(locala, "MMKernel.service(IConfigService::class.java)");
    long l = ((com.tencent.mm.plugin.zero.b.a)locala).aqJ().getInt("FinderNewFeedTipsFastEnterSecondTimeInterval", 172800) * 1000L / dbT();
    AppMethodBeat.o(178211);
    return l;
  }
  
  private static long dbL()
  {
    AppMethodBeat.i(178212);
    com.tencent.mm.kernel.c.a locala = g.af(com.tencent.mm.plugin.zero.b.a.class);
    p.g(locala, "MMKernel.service(IConfigService::class.java)");
    long l = ((com.tencent.mm.plugin.zero.b.a)locala).aqJ().getInt("FinderNewFeedTipsFastEnterThirdTimeInterval", 604800) * 1000L / dbT();
    AppMethodBeat.o(178212);
    return l;
  }
  
  public static int dbM()
  {
    AppMethodBeat.i(178213);
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    int i = locale.azQ().getInt(ar.a.OkA, 0);
    AppMethodBeat.o(178213);
    return i;
  }
  
  public static boolean dbN()
  {
    AppMethodBeat.i(243650);
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    boolean bool = locale.azQ().getBoolean(ar.a.Oln, false);
    AppMethodBeat.o(243650);
    return bool;
  }
  
  public static long dbO()
  {
    AppMethodBeat.i(178215);
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    long l = locale.azQ().a(ar.a.OkB, 0L);
    AppMethodBeat.o(178215);
    return l;
  }
  
  public static long dbP()
  {
    AppMethodBeat.i(243652);
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    long l = locale.azQ().a(ar.a.OkC, 0L);
    AppMethodBeat.o(243652);
    return l;
  }
  
  public static void dbQ()
  {
    AppMethodBeat.i(178216);
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.OkB, Long.valueOf(cl.aWA()));
    AppMethodBeat.o(178216);
  }
  
  public static void dbR()
  {
    AppMethodBeat.i(243653);
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.OkC, Long.valueOf(cl.aWA()));
    AppMethodBeat.o(243653);
  }
  
  private static long dbS()
  {
    AppMethodBeat.i(178217);
    switch (dbM())
    {
    default: 
      AppMethodBeat.o(178217);
      return 0L;
    case 1: 
      l = dbJ();
      AppMethodBeat.o(178217);
      return l;
    case 2: 
      l = dbK();
      AppMethodBeat.o(178217);
      return l;
    }
    long l = dbL();
    AppMethodBeat.o(178217);
    return l;
  }
  
  private static int dbT()
  {
    AppMethodBeat.i(178218);
    c localc = c.vCb;
    int i = ((Number)c.dte().value()).intValue();
    AppMethodBeat.o(178218);
    return i;
  }
  
  public static void mU(boolean paramBoolean)
  {
    AppMethodBeat.i(243651);
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.Oln, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(243651);
  }
  
  public final long dbA()
  {
    AppMethodBeat.i(243642);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbP, 7200) * 1000L / dbT();
    long l2 = dbS();
    AppMethodBeat.o(243642);
    return l1 + l2;
  }
  
  public final long dbB()
  {
    AppMethodBeat.i(243643);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbQ, 0) * 1000L / dbT();
    long l2 = dbS();
    AppMethodBeat.o(243643);
    return l1 + l2;
  }
  
  public final long dbC()
  {
    AppMethodBeat.i(243644);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbR, 7200) * 1000L / dbT();
    long l2 = dbS();
    AppMethodBeat.o(243644);
    return l1 + l2;
  }
  
  public final long dbD()
  {
    AppMethodBeat.i(243645);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbS, 7200) * 1000L / dbT();
    long l2 = dbS();
    AppMethodBeat.o(243645);
    return l1 + l2;
  }
  
  public final long dbE()
  {
    AppMethodBeat.i(243646);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbU, 7200) * 1000L / dbT();
    long l2 = dbS();
    AppMethodBeat.o(243646);
    return l1 + l2;
  }
  
  public final long dbF()
  {
    AppMethodBeat.i(243647);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbT, 7200) * 1000L / dbT();
    long l2 = dbS();
    AppMethodBeat.o(243647);
    return l1 + l2;
  }
  
  public final long dbG()
  {
    AppMethodBeat.i(243648);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbV, 7200) * 1000L / dbT();
    long l2 = dbS();
    AppMethodBeat.o(243648);
    return l1 + l2;
  }
  
  public final long dbH()
  {
    AppMethodBeat.i(243649);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbM, 7200) * 1000L / dbT();
    long l2 = dbS();
    AppMethodBeat.o(243649);
    return l1 + l2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.l
 * JD-Core Version:    0.7.0.1
 */