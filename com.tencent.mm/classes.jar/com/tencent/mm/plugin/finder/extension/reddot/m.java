package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/RedDotDynamicConfig;", "", "()V", "currentFastEnterLevel", "", "getCurrentFastEnterLevel", "()I", "finderFastEnterTime", "", "getFinderFastEnterTime", "()J", "finderLiveEntranceEntranceTimeMs", "getFinderLiveEntranceEntranceTimeMs", "friendEntranceTimeMs", "getFriendEntranceTimeMs", "fullScreenTabShowed", "", "getFullScreenTabShowed", "()Z", "lastExitFinderLiveTime", "getLastExitFinderLiveTime", "lastExitFinderTlTime", "getLastExitFinderTlTime", "lastExitNearbyTime", "getLastExitNearbyTime", "moreTabFollowEntranceTimeMs", "getMoreTabFollowEntranceTimeMs", "moreTabFollowTabTimeMs", "getMoreTabFollowTabTimeMs", "moreTabFriendEntranceTimeMs", "getMoreTabFriendEntranceTimeMs", "moreTabFriendPostTimeMs", "getMoreTabFriendPostTimeMs", "moreTabHotEntranceTimeMs", "getMoreTabHotEntranceTimeMs", "moreTabLiveEntranceTimeMs", "getMoreTabLiveEntranceTimeMs", "moreTabNearbyEntranceTimeMs", "getMoreTabNearbyEntranceTimeMs", "moreTabNewsEntranceTimeMs", "getMoreTabNewsEntranceTimeMs", "newFeedTipsFastEnterFirstTimeInterval", "getNewFeedTipsFastEnterFirstTimeInterval", "newFeedTipsFastEnterSecondTimeInterval", "getNewFeedTipsFastEnterSecondTimeInterval", "newFeedTipsFastEnterThirdTimeInterval", "getNewFeedTipsFastEnterThirdTimeInterval", "newFollowTipsEnterInterval", "getNewFollowTipsEnterInterval", "newMsgEntranceInterval", "getNewMsgEntranceInterval", "newUnFollowTipsEnterInterval", "getNewUnFollowTipsEnterInterval", "refreshDiscoveryTimeMs", "getRefreshDiscoveryTimeMs", "refreshEntranceInterval", "getRefreshEntranceInterval", "addLevelTime", "setCurrentFastEnterLevel", "", "level", "setFullScreenTabShowed", "isShowed", "testFactor", "updateFinderLiveLastExitTime", "updateLastExitTime", "updateNearbyLastExitTime", "plugin-finder_release"})
public final class m
{
  public static final m xuU;
  
  static
  {
    AppMethodBeat.i(178219);
    xuU = new m();
    AppMethodBeat.o(178219);
  }
  
  public static void Mu(int paramInt)
  {
    AppMethodBeat.i(178214);
    com.tencent.mm.kernel.f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.Vzu, Integer.valueOf(paramInt));
    AppMethodBeat.o(178214);
  }
  
  public static long drT()
  {
    AppMethodBeat.i(178209);
    com.tencent.mm.kernel.c.a locala = h.ae(com.tencent.mm.plugin.zero.b.a.class);
    p.j(locala, "MMKernel.service(IConfigService::class.java)");
    long l = ((com.tencent.mm.plugin.zero.b.a)locala).axc().getInt("FinderFastEnterTime", 0);
    AppMethodBeat.o(178209);
    return l * 1000L;
  }
  
  private static long drU()
  {
    AppMethodBeat.i(178210);
    com.tencent.mm.kernel.c.a locala = h.ae(com.tencent.mm.plugin.zero.b.a.class);
    p.j(locala, "MMKernel.service(IConfigService::class.java)");
    long l = ((com.tencent.mm.plugin.zero.b.a)locala).axc().getInt("FinderNewFeedTipsFastEnterFirstTimeInterval", 86400) * 1000L / dsg();
    AppMethodBeat.o(178210);
    return l;
  }
  
  private static long drV()
  {
    AppMethodBeat.i(178211);
    com.tencent.mm.kernel.c.a locala = h.ae(com.tencent.mm.plugin.zero.b.a.class);
    p.j(locala, "MMKernel.service(IConfigService::class.java)");
    long l = ((com.tencent.mm.plugin.zero.b.a)locala).axc().getInt("FinderNewFeedTipsFastEnterSecondTimeInterval", 172800) * 1000L / dsg();
    AppMethodBeat.o(178211);
    return l;
  }
  
  private static long drW()
  {
    AppMethodBeat.i(178212);
    com.tencent.mm.kernel.c.a locala = h.ae(com.tencent.mm.plugin.zero.b.a.class);
    p.j(locala, "MMKernel.service(IConfigService::class.java)");
    long l = ((com.tencent.mm.plugin.zero.b.a)locala).axc().getInt("FinderNewFeedTipsFastEnterThirdTimeInterval", 604800) * 1000L / dsg();
    AppMethodBeat.o(178212);
    return l;
  }
  
  public static int drX()
  {
    AppMethodBeat.i(178213);
    com.tencent.mm.kernel.f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    int i = localf.aHp().getInt(ar.a.Vzu, 0);
    AppMethodBeat.o(178213);
    return i;
  }
  
  public static boolean drY()
  {
    AppMethodBeat.i(281140);
    com.tencent.mm.kernel.f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    boolean bool = localf.aHp().getBoolean(ar.a.VAi, false);
    AppMethodBeat.o(281140);
    return bool;
  }
  
  public static long drZ()
  {
    AppMethodBeat.i(178215);
    com.tencent.mm.kernel.f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    long l = localf.aHp().a(ar.a.Vzv, 0L);
    AppMethodBeat.o(178215);
    return l;
  }
  
  public static long dsa()
  {
    AppMethodBeat.i(281142);
    com.tencent.mm.kernel.f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    long l = localf.aHp().a(ar.a.Vzw, 0L);
    AppMethodBeat.o(281142);
    return l;
  }
  
  public static long dsb()
  {
    AppMethodBeat.i(281143);
    com.tencent.mm.kernel.f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    long l = localf.aHp().a(ar.a.Vzx, 0L);
    AppMethodBeat.o(281143);
    return l;
  }
  
  public static void dsc()
  {
    AppMethodBeat.i(178216);
    com.tencent.mm.kernel.f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.Vzv, Long.valueOf(cm.bfE()));
    AppMethodBeat.o(178216);
  }
  
  public static void dsd()
  {
    AppMethodBeat.i(281144);
    com.tencent.mm.kernel.f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.Vzw, Long.valueOf(cm.bfE()));
    AppMethodBeat.o(281144);
  }
  
  public static void dse()
  {
    AppMethodBeat.i(281145);
    com.tencent.mm.kernel.f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.Vzx, Long.valueOf(cm.bfE()));
    AppMethodBeat.o(281145);
  }
  
  private static long dsf()
  {
    AppMethodBeat.i(178217);
    switch (drX())
    {
    default: 
      AppMethodBeat.o(178217);
      return 0L;
    case 1: 
      l = drU();
      AppMethodBeat.o(178217);
      return l;
    case 2: 
      l = drV();
      AppMethodBeat.o(178217);
      return l;
    }
    long l = drW();
    AppMethodBeat.o(178217);
    return l;
  }
  
  private static int dsg()
  {
    AppMethodBeat.i(178218);
    d locald = d.AjH;
    int i = ((Number)d.dUt().aSr()).intValue();
    AppMethodBeat.o(178218);
    return i;
  }
  
  public static void oo(boolean paramBoolean)
  {
    AppMethodBeat.i(281141);
    com.tencent.mm.kernel.f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VAi, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(281141);
  }
  
  public final long drJ()
  {
    AppMethodBeat.i(281128);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vJY, 7200) * 1000L / dsg();
    long l2 = dsf();
    AppMethodBeat.o(281128);
    return l1 + l2;
  }
  
  public final long drK()
  {
    AppMethodBeat.i(281129);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vJZ, 0) * 1000L / dsg();
    long l2 = dsf();
    AppMethodBeat.o(281129);
    return l1 + l2;
  }
  
  public final long drL()
  {
    AppMethodBeat.i(281130);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKa, 7200) * 1000L / dsg();
    long l2 = dsf();
    AppMethodBeat.o(281130);
    return l1 + l2;
  }
  
  public final long drM()
  {
    AppMethodBeat.i(281131);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKb, 7200) * 1000L / dsg();
    long l2 = dsf();
    AppMethodBeat.o(281131);
    return l1 + l2;
  }
  
  public final long drN()
  {
    AppMethodBeat.i(281132);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKc, 7200) * 1000L / dsg();
    long l2 = dsf();
    AppMethodBeat.o(281132);
    return l1 + l2;
  }
  
  public final long drO()
  {
    AppMethodBeat.i(281133);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKe, 7200) * 1000L / dsg();
    long l2 = dsf();
    AppMethodBeat.o(281133);
    return l1 + l2;
  }
  
  public final long drP()
  {
    AppMethodBeat.i(281135);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKd, 7200) * 1000L / dsg();
    long l2 = dsf();
    AppMethodBeat.o(281135);
    return l1 + l2;
  }
  
  public final long drQ()
  {
    AppMethodBeat.i(281136);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKf, 7200) * 1000L / dsg();
    long l2 = dsf();
    AppMethodBeat.o(281136);
    return l1 + l2;
  }
  
  public final long drR()
  {
    AppMethodBeat.i(281137);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKg, 7200) * 1000L / dsg();
    long l2 = dsf();
    AppMethodBeat.o(281137);
    return l1 + l2;
  }
  
  public final long drS()
  {
    AppMethodBeat.i(281138);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vJV, 7200) * 1000L / dsg();
    long l2 = dsf();
    AppMethodBeat.o(281138);
    return l1 + l2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.m
 * JD-Core Version:    0.7.0.1
 */