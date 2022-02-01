package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/extension/reddot/RedDotDynamicConfig;", "", "()V", "currentFastEnterLevel", "", "getCurrentFastEnterLevel", "()I", "finderFastEnterTime", "", "getFinderFastEnterTime", "()J", "friendEntranceTimeMs", "getFriendEntranceTimeMs", "lastExitFinderTlTime", "getLastExitFinderTlTime", "moreTabFollowEntranceTimeMs", "getMoreTabFollowEntranceTimeMs", "moreTabFollowTabTimeMs", "getMoreTabFollowTabTimeMs", "moreTabFriendEntranceTimeMs", "getMoreTabFriendEntranceTimeMs", "newFeedTipsFastEnterFirstTimeInterval", "getNewFeedTipsFastEnterFirstTimeInterval", "newFeedTipsFastEnterSecondTimeInterval", "getNewFeedTipsFastEnterSecondTimeInterval", "newFeedTipsFastEnterThirdTimeInterval", "getNewFeedTipsFastEnterThirdTimeInterval", "newFollowTipsEnterInterval", "getNewFollowTipsEnterInterval", "newMsgEntranceInterval", "getNewMsgEntranceInterval", "newUnFollowTipsEnterInterval", "getNewUnFollowTipsEnterInterval", "refreshDiscoveryTimeMs", "getRefreshDiscoveryTimeMs", "refreshEntranceInterval", "getRefreshEntranceInterval", "addLevelTime", "setCurrentFastEnterLevel", "", "level", "testFactor", "updateLastExitTime", "plugin-finder_release"})
public final class j
{
  public static final j rTk;
  
  static
  {
    AppMethodBeat.i(178219);
    rTk = new j();
    AppMethodBeat.o(178219);
  }
  
  public static void Ev(int paramInt)
  {
    AppMethodBeat.i(178214);
    com.tencent.mm.kernel.e locale = g.ajC();
    p.g(locale, "MMKernel.storage()");
    locale.ajl().set(al.a.IHa, Integer.valueOf(paramInt));
    AppMethodBeat.o(178214);
  }
  
  public static long cAk()
  {
    AppMethodBeat.i(201661);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAJ, 0) * 1000L / cAy();
    long l2 = cAx();
    AppMethodBeat.o(201661);
    return l1 + l2;
  }
  
  public static long cAl()
  {
    AppMethodBeat.i(178207);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAH, 0) * 1000L / cAy();
    long l2 = cAx();
    AppMethodBeat.o(178207);
    return l1 + l2;
  }
  
  public static long cAm()
  {
    AppMethodBeat.i(201662);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAK, 0) * 1000L / cAy();
    long l2 = cAx();
    AppMethodBeat.o(201662);
    return l1 + l2;
  }
  
  public static long cAn()
  {
    AppMethodBeat.i(201663);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAL, 0) * 1000L / cAy();
    long l2 = cAx();
    AppMethodBeat.o(201663);
    return l1 + l2;
  }
  
  public static long cAo()
  {
    AppMethodBeat.i(201664);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAG, 0) * 1000L / cAy();
    long l2 = cAx();
    AppMethodBeat.o(201664);
    return l1 + l2;
  }
  
  public static long cAp()
  {
    AppMethodBeat.i(178208);
    long l1 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAI, 259200) * 1000L / cAy();
    long l2 = cAx();
    AppMethodBeat.o(178208);
    return l1 + l2;
  }
  
  public static long cAq()
  {
    AppMethodBeat.i(178209);
    com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(locala, "MMKernel.service(IConfigService::class.java)");
    long l = ((com.tencent.mm.plugin.zero.b.a)locala).acA().getInt("FinderFastEnterTime", 0);
    AppMethodBeat.o(178209);
    return l * 1000L;
  }
  
  private static long cAr()
  {
    AppMethodBeat.i(178210);
    com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(locala, "MMKernel.service(IConfigService::class.java)");
    long l = ((com.tencent.mm.plugin.zero.b.a)locala).acA().getInt("FinderNewFeedTipsFastEnterFirstTimeInterval", 86400) * 1000L / cAy();
    AppMethodBeat.o(178210);
    return l;
  }
  
  private static long cAs()
  {
    AppMethodBeat.i(178211);
    com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(locala, "MMKernel.service(IConfigService::class.java)");
    long l = ((com.tencent.mm.plugin.zero.b.a)locala).acA().getInt("FinderNewFeedTipsFastEnterSecondTimeInterval", 172800) * 1000L / cAy();
    AppMethodBeat.o(178211);
    return l;
  }
  
  private static long cAt()
  {
    AppMethodBeat.i(178212);
    com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(locala, "MMKernel.service(IConfigService::class.java)");
    long l = ((com.tencent.mm.plugin.zero.b.a)locala).acA().getInt("FinderNewFeedTipsFastEnterThirdTimeInterval", 604800) * 1000L / cAy();
    AppMethodBeat.o(178212);
    return l;
  }
  
  public static int cAu()
  {
    AppMethodBeat.i(178213);
    com.tencent.mm.kernel.e locale = g.ajC();
    p.g(locale, "MMKernel.storage()");
    int i = locale.ajl().getInt(al.a.IHa, 0);
    AppMethodBeat.o(178213);
    return i;
  }
  
  public static long cAv()
  {
    AppMethodBeat.i(178215);
    com.tencent.mm.kernel.e locale = g.ajC();
    p.g(locale, "MMKernel.storage()");
    long l = locale.ajl().a(al.a.IHb, 0L);
    AppMethodBeat.o(178215);
    return l;
  }
  
  public static void cAw()
  {
    AppMethodBeat.i(178216);
    com.tencent.mm.kernel.e locale = g.ajC();
    p.g(locale, "MMKernel.storage()");
    locale.ajl().set(al.a.IHb, Long.valueOf(cf.aCM()));
    AppMethodBeat.o(178216);
  }
  
  private static long cAx()
  {
    AppMethodBeat.i(178217);
    switch (cAu())
    {
    default: 
      AppMethodBeat.o(178217);
      return 0L;
    case 1: 
      l = cAr();
      AppMethodBeat.o(178217);
      return l;
    case 2: 
      l = cAs();
      AppMethodBeat.o(178217);
      return l;
    }
    long l = cAt();
    AppMethodBeat.o(178217);
    return l;
  }
  
  public static int cAy()
  {
    AppMethodBeat.i(178218);
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    int i = ((Number)com.tencent.mm.plugin.finder.storage.b.cHq().value()).intValue();
    AppMethodBeat.o(178218);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.j
 * JD-Core Version:    0.7.0.1
 */