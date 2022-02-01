package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/extension/reddot/RedDotDynamicConfig;", "", "()V", "currentFastEnterLevel", "", "getCurrentFastEnterLevel", "()I", "finderFastEnterTime", "", "getFinderFastEnterTime", "()J", "friendEntranceTimeMs", "getFriendEntranceTimeMs", "lastExitFinderTlTime", "getLastExitFinderTlTime", "moreTabFollowEntranceTimeMs", "getMoreTabFollowEntranceTimeMs", "moreTabFollowTabTimeMs", "getMoreTabFollowTabTimeMs", "moreTabFriendEntranceTimeMs", "getMoreTabFriendEntranceTimeMs", "newFeedTipsFastEnterFirstTimeInterval", "getNewFeedTipsFastEnterFirstTimeInterval", "newFeedTipsFastEnterSecondTimeInterval", "getNewFeedTipsFastEnterSecondTimeInterval", "newFeedTipsFastEnterThirdTimeInterval", "getNewFeedTipsFastEnterThirdTimeInterval", "newFollowTipsEnterInterval", "getNewFollowTipsEnterInterval", "newMsgEntranceInterval", "getNewMsgEntranceInterval", "newUnFollowTipsEnterInterval", "getNewUnFollowTipsEnterInterval", "refreshDiscoveryTimeMs", "getRefreshDiscoveryTimeMs", "refreshEntranceInterval", "getRefreshEntranceInterval", "addLevelTime", "setCurrentFastEnterLevel", "", "level", "testFactor", "updateLastExitTime", "plugin-finder_release"})
public final class i
{
  public static final i rfA;
  
  static
  {
    AppMethodBeat.i(178219);
    rfA = new i();
    AppMethodBeat.o(178219);
  }
  
  public static void DC(int paramInt)
  {
    AppMethodBeat.i(178214);
    com.tencent.mm.kernel.e locale = g.agR();
    k.g(locale, "MMKernel.storage()");
    locale.agA().set(ah.a.GUu, Integer.valueOf(paramInt));
    AppMethodBeat.o(178214);
  }
  
  public static long cua()
  {
    AppMethodBeat.i(201488);
    long l1 = ((b)g.ab(b.class)).a(b.a.pVY, 0) * 1000L / cuo();
    long l2 = cun();
    AppMethodBeat.o(201488);
    return l1 + l2;
  }
  
  public static long cub()
  {
    AppMethodBeat.i(178207);
    long l1 = ((b)g.ab(b.class)).a(b.a.pVW, 0) * 1000L / cuo();
    long l2 = cun();
    AppMethodBeat.o(178207);
    return l1 + l2;
  }
  
  public static long cuc()
  {
    AppMethodBeat.i(201489);
    long l1 = ((b)g.ab(b.class)).a(b.a.pVZ, 0) * 1000L / cuo();
    long l2 = cun();
    AppMethodBeat.o(201489);
    return l1 + l2;
  }
  
  public static long cud()
  {
    AppMethodBeat.i(201490);
    long l1 = ((b)g.ab(b.class)).a(b.a.pWa, 0) * 1000L / cuo();
    long l2 = cun();
    AppMethodBeat.o(201490);
    return l1 + l2;
  }
  
  public static long cue()
  {
    AppMethodBeat.i(201491);
    long l1 = ((b)g.ab(b.class)).a(b.a.pVV, 0) * 1000L / cuo();
    long l2 = cun();
    AppMethodBeat.o(201491);
    return l1 + l2;
  }
  
  public static long cuf()
  {
    AppMethodBeat.i(178208);
    long l1 = ((b)g.ab(b.class)).a(b.a.pVX, 259200) * 1000L / cuo();
    long l2 = cun();
    AppMethodBeat.o(178208);
    return l1 + l2;
  }
  
  public static long cug()
  {
    AppMethodBeat.i(178209);
    com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.zero.b.a.class);
    k.g(locala, "MMKernel.service(IConfigService::class.java)");
    long l = ((com.tencent.mm.plugin.zero.b.a)locala).ZY().getInt("FinderFastEnterTime", 0);
    AppMethodBeat.o(178209);
    return l * 1000L;
  }
  
  private static long cuh()
  {
    AppMethodBeat.i(178210);
    com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.zero.b.a.class);
    k.g(locala, "MMKernel.service(IConfigService::class.java)");
    long l = ((com.tencent.mm.plugin.zero.b.a)locala).ZY().getInt("FinderNewFeedTipsFastEnterFirstTimeInterval", 86400) * 1000L / cuo();
    AppMethodBeat.o(178210);
    return l;
  }
  
  private static long cui()
  {
    AppMethodBeat.i(178211);
    com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.zero.b.a.class);
    k.g(locala, "MMKernel.service(IConfigService::class.java)");
    long l = ((com.tencent.mm.plugin.zero.b.a)locala).ZY().getInt("FinderNewFeedTipsFastEnterSecondTimeInterval", 172800) * 1000L / cuo();
    AppMethodBeat.o(178211);
    return l;
  }
  
  private static long cuj()
  {
    AppMethodBeat.i(178212);
    com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.zero.b.a.class);
    k.g(locala, "MMKernel.service(IConfigService::class.java)");
    long l = ((com.tencent.mm.plugin.zero.b.a)locala).ZY().getInt("FinderNewFeedTipsFastEnterThirdTimeInterval", 604800) * 1000L / cuo();
    AppMethodBeat.o(178212);
    return l;
  }
  
  public static int cuk()
  {
    AppMethodBeat.i(178213);
    com.tencent.mm.kernel.e locale = g.agR();
    k.g(locale, "MMKernel.storage()");
    int i = locale.agA().getInt(ah.a.GUu, 0);
    AppMethodBeat.o(178213);
    return i;
  }
  
  public static long cul()
  {
    AppMethodBeat.i(178215);
    com.tencent.mm.kernel.e locale = g.agR();
    k.g(locale, "MMKernel.storage()");
    long l = locale.agA().a(ah.a.GUv, 0L);
    AppMethodBeat.o(178215);
    return l;
  }
  
  public static void cum()
  {
    AppMethodBeat.i(178216);
    com.tencent.mm.kernel.e locale = g.agR();
    k.g(locale, "MMKernel.storage()");
    locale.agA().set(ah.a.GUv, Long.valueOf(ce.azJ()));
    AppMethodBeat.o(178216);
  }
  
  private static long cun()
  {
    AppMethodBeat.i(178217);
    switch (cuk())
    {
    default: 
      AppMethodBeat.o(178217);
      return 0L;
    case 1: 
      l = cuh();
      AppMethodBeat.o(178217);
      return l;
    case 2: 
      l = cui();
      AppMethodBeat.o(178217);
      return l;
    }
    long l = cuj();
    AppMethodBeat.o(178217);
    return l;
  }
  
  public static int cuo()
  {
    AppMethodBeat.i(178218);
    com.tencent.mm.kernel.e locale = g.agR();
    k.g(locale, "MMKernel.storage()");
    int i = locale.agA().getInt(ah.a.GUw, 1);
    AppMethodBeat.o(178218);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.i
 * JD-Core Version:    0.7.0.1
 */