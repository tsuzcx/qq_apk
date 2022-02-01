package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/extension/reddot/RedDotDynamicConfig;", "", "()V", "currentFastEnterLevel", "", "getCurrentFastEnterLevel", "()I", "finderFastEnterTime", "", "getFinderFastEnterTime", "()J", "friendEntranceTimeMs", "getFriendEntranceTimeMs", "lastExitFinderTlTime", "getLastExitFinderTlTime", "moreTabFollowEntranceTimeMs", "getMoreTabFollowEntranceTimeMs", "moreTabFollowTabTimeMs", "getMoreTabFollowTabTimeMs", "moreTabFriendEntranceTimeMs", "getMoreTabFriendEntranceTimeMs", "newFeedTipsFastEnterFirstTimeInterval", "getNewFeedTipsFastEnterFirstTimeInterval", "newFeedTipsFastEnterSecondTimeInterval", "getNewFeedTipsFastEnterSecondTimeInterval", "newFeedTipsFastEnterThirdTimeInterval", "getNewFeedTipsFastEnterThirdTimeInterval", "newFollowTipsEnterInterval", "getNewFollowTipsEnterInterval", "newMsgEntranceInterval", "getNewMsgEntranceInterval", "newUnFollowTipsEnterInterval", "getNewUnFollowTipsEnterInterval", "refreshDiscoveryTimeMs", "getRefreshDiscoveryTimeMs", "refreshEntranceInterval", "getRefreshEntranceInterval", "addLevelTime", "setCurrentFastEnterLevel", "", "level", "testFactor", "updateLastExitTime", "plugin-finder_release"})
public final class g
{
  public static final g qtS;
  
  static
  {
    AppMethodBeat.i(178219);
    qtS = new g();
    AppMethodBeat.o(178219);
  }
  
  public static void CA(int paramInt)
  {
    AppMethodBeat.i(178214);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
    k.g(locale, "MMKernel.storage()");
    locale.afk().set(ae.a.Fws, Integer.valueOf(paramInt));
    AppMethodBeat.o(178214);
  }
  
  private static long clA()
  {
    AppMethodBeat.i(178212);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    k.g(locala, "MMKernel.service(IConfigService::class.java)");
    long l = ((com.tencent.mm.plugin.zero.b.a)locala).Zd().getInt("FinderNewFeedTipsFastEnterThirdTimeInterval", 604800) * 1000L / clF();
    AppMethodBeat.o(178212);
    return l;
  }
  
  public static int clB()
  {
    AppMethodBeat.i(178213);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
    k.g(locale, "MMKernel.storage()");
    int i = locale.afk().getInt(ae.a.Fws, 0);
    AppMethodBeat.o(178213);
    return i;
  }
  
  public static long clC()
  {
    AppMethodBeat.i(178215);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
    k.g(locale, "MMKernel.storage()");
    long l = locale.afk().a(ae.a.Fwt, 0L);
    AppMethodBeat.o(178215);
    return l;
  }
  
  public static void clD()
  {
    AppMethodBeat.i(178216);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
    k.g(locale, "MMKernel.storage()");
    locale.afk().set(ae.a.Fwt, Long.valueOf(ce.asS()));
    AppMethodBeat.o(178216);
  }
  
  private static long clE()
  {
    AppMethodBeat.i(178217);
    switch (clB())
    {
    default: 
      AppMethodBeat.o(178217);
      return 0L;
    case 1: 
      l = cly();
      AppMethodBeat.o(178217);
      return l;
    case 2: 
      l = clz();
      AppMethodBeat.o(178217);
      return l;
    }
    long l = clA();
    AppMethodBeat.o(178217);
    return l;
  }
  
  public static int clF()
  {
    AppMethodBeat.i(178218);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
    k.g(locale, "MMKernel.storage()");
    int i = locale.afk().getInt(ae.a.Fwu, 1);
    AppMethodBeat.o(178218);
    return i;
  }
  
  public static long clv()
  {
    AppMethodBeat.i(178207);
    long l1 = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.prZ, 43200) * 1000L / clF();
    long l2 = clE();
    AppMethodBeat.o(178207);
    return l1 + l2;
  }
  
  public static long clw()
  {
    AppMethodBeat.i(178208);
    long l1 = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.psa, 259200) * 1000L / clF();
    long l2 = clE();
    AppMethodBeat.o(178208);
    return l1 + l2;
  }
  
  public static long clx()
  {
    AppMethodBeat.i(178209);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    k.g(locala, "MMKernel.service(IConfigService::class.java)");
    long l = ((com.tencent.mm.plugin.zero.b.a)locala).Zd().getInt("FinderFastEnterTime", 5);
    AppMethodBeat.o(178209);
    return l * 1000L;
  }
  
  private static long cly()
  {
    AppMethodBeat.i(178210);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    k.g(locala, "MMKernel.service(IConfigService::class.java)");
    long l = ((com.tencent.mm.plugin.zero.b.a)locala).Zd().getInt("FinderNewFeedTipsFastEnterFirstTimeInterval", 86400) * 1000L / clF();
    AppMethodBeat.o(178210);
    return l;
  }
  
  private static long clz()
  {
    AppMethodBeat.i(178211);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    k.g(locala, "MMKernel.service(IConfigService::class.java)");
    long l = ((com.tencent.mm.plugin.zero.b.a)locala).Zd().getInt("FinderNewFeedTipsFastEnterSecondTimeInterval", 172800) * 1000L / clF();
    AppMethodBeat.o(178211);
    return l;
  }
  
  public static long fSR()
  {
    AppMethodBeat.i(197591);
    long l1 = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.KEt, 43200) * 1000L / clF();
    long l2 = clE();
    AppMethodBeat.o(197591);
    return l1 + l2;
  }
  
  public static long fSS()
  {
    AppMethodBeat.i(197592);
    long l1 = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.KEu, 1800) * 1000L / clF();
    long l2 = clE();
    AppMethodBeat.o(197592);
    return l1 + l2;
  }
  
  public static long fST()
  {
    AppMethodBeat.i(197593);
    long l1 = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.KEv, 86400) * 1000L / clF();
    long l2 = clE();
    AppMethodBeat.o(197593);
    return l1 + l2;
  }
  
  public static long fSU()
  {
    AppMethodBeat.i(197594);
    long l1 = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.prY, 21600) * 1000L / clF();
    long l2 = clE();
    AppMethodBeat.o(197594);
    return l1 + l2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.g
 * JD-Core Version:    0.7.0.1
 */