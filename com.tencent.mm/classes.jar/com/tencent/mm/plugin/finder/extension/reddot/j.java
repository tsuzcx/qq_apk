package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/extension/reddot/RedDotDynamicConfig;", "", "()V", "currentFastEnterLevel", "", "getCurrentFastEnterLevel", "()I", "finderFastEnterTime", "", "getFinderFastEnterTime", "()J", "friendEntranceTimeMs", "getFriendEntranceTimeMs", "lastExitFinderTlTime", "getLastExitFinderTlTime", "moreTabFollowEntranceTimeMs", "getMoreTabFollowEntranceTimeMs", "moreTabFollowTabTimeMs", "getMoreTabFollowTabTimeMs", "moreTabFriendEntranceTimeMs", "getMoreTabFriendEntranceTimeMs", "newFeedTipsFastEnterFirstTimeInterval", "getNewFeedTipsFastEnterFirstTimeInterval", "newFeedTipsFastEnterSecondTimeInterval", "getNewFeedTipsFastEnterSecondTimeInterval", "newFeedTipsFastEnterThirdTimeInterval", "getNewFeedTipsFastEnterThirdTimeInterval", "newFollowTipsEnterInterval", "getNewFollowTipsEnterInterval", "newMsgEntranceInterval", "getNewMsgEntranceInterval", "newUnFollowTipsEnterInterval", "getNewUnFollowTipsEnterInterval", "refreshDiscoveryTimeMs", "getRefreshDiscoveryTimeMs", "refreshEntranceInterval", "getRefreshEntranceInterval", "addLevelTime", "setCurrentFastEnterLevel", "", "level", "testFactor", "updateLastExitTime", "plugin-finder_release"})
public final class j
{
  public static final j sbM;
  
  static
  {
    AppMethodBeat.i(178219);
    sbM = new j();
    AppMethodBeat.o(178219);
  }
  
  public static void EI(int paramInt)
  {
    AppMethodBeat.i(178214);
    com.tencent.mm.kernel.e locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.JbB, Integer.valueOf(paramInt));
    AppMethodBeat.o(178214);
  }
  
  public static long cBT()
  {
    AppMethodBeat.i(202113);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHT, 0) * 1000L / cCf();
    long l2 = cCe();
    AppMethodBeat.o(202113);
    return l1 + l2;
  }
  
  public static long cBU()
  {
    AppMethodBeat.i(202114);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHU, 0) * 1000L / cCf();
    long l2 = cCe();
    AppMethodBeat.o(202114);
    return l1 + l2;
  }
  
  public static long cBV()
  {
    AppMethodBeat.i(202115);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHV, 0) * 1000L / cCf();
    long l2 = cCe();
    AppMethodBeat.o(202115);
    return l1 + l2;
  }
  
  public static long cBW()
  {
    AppMethodBeat.i(202116);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHQ, 0) * 1000L / cCf();
    long l2 = cCe();
    AppMethodBeat.o(202116);
    return l1 + l2;
  }
  
  public static long cBX()
  {
    AppMethodBeat.i(178209);
    com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(locala, "MMKernel.service(IConfigService::class.java)");
    long l = ((com.tencent.mm.plugin.zero.b.a)locala).acL().getInt("FinderFastEnterTime", 0);
    AppMethodBeat.o(178209);
    return l * 1000L;
  }
  
  private static long cBY()
  {
    AppMethodBeat.i(178210);
    com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(locala, "MMKernel.service(IConfigService::class.java)");
    long l = ((com.tencent.mm.plugin.zero.b.a)locala).acL().getInt("FinderNewFeedTipsFastEnterFirstTimeInterval", 86400) * 1000L / cCf();
    AppMethodBeat.o(178210);
    return l;
  }
  
  private static long cBZ()
  {
    AppMethodBeat.i(178211);
    com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(locala, "MMKernel.service(IConfigService::class.java)");
    long l = ((com.tencent.mm.plugin.zero.b.a)locala).acL().getInt("FinderNewFeedTipsFastEnterSecondTimeInterval", 172800) * 1000L / cCf();
    AppMethodBeat.o(178211);
    return l;
  }
  
  private static long cCa()
  {
    AppMethodBeat.i(178212);
    com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(locala, "MMKernel.service(IConfigService::class.java)");
    long l = ((com.tencent.mm.plugin.zero.b.a)locala).acL().getInt("FinderNewFeedTipsFastEnterThirdTimeInterval", 604800) * 1000L / cCf();
    AppMethodBeat.o(178212);
    return l;
  }
  
  public static int cCb()
  {
    AppMethodBeat.i(178213);
    com.tencent.mm.kernel.e locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    int i = locale.ajA().getInt(am.a.JbB, 0);
    AppMethodBeat.o(178213);
    return i;
  }
  
  public static long cCc()
  {
    AppMethodBeat.i(178215);
    com.tencent.mm.kernel.e locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    long l = locale.ajA().a(am.a.JbC, 0L);
    AppMethodBeat.o(178215);
    return l;
  }
  
  public static void cCd()
  {
    AppMethodBeat.i(178216);
    com.tencent.mm.kernel.e locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.JbC, Long.valueOf(ch.aDc()));
    AppMethodBeat.o(178216);
  }
  
  private static long cCe()
  {
    AppMethodBeat.i(178217);
    switch (cCb())
    {
    default: 
      AppMethodBeat.o(178217);
      return 0L;
    case 1: 
      l = cBY();
      AppMethodBeat.o(178217);
      return l;
    case 2: 
      l = cBZ();
      AppMethodBeat.o(178217);
      return l;
    }
    long l = cCa();
    AppMethodBeat.o(178217);
    return l;
  }
  
  public static int cCf()
  {
    AppMethodBeat.i(178218);
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    int i = ((Number)com.tencent.mm.plugin.finder.storage.b.cJp().value()).intValue();
    AppMethodBeat.o(178218);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.j
 * JD-Core Version:    0.7.0.1
 */