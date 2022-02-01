package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/RedDotDynamicConfig;", "", "()V", "TAG", "", "currentFastEnterLevel", "", "getCurrentFastEnterLevel", "()I", "finderFastEnterTime", "", "getFinderFastEnterTime", "()J", "finderLiveEntranceEntranceTimeMs", "getFinderLiveEntranceEntranceTimeMs", "friendEntranceTimeMs", "getFriendEntranceTimeMs", "fullScreenTabShowed", "", "getFullScreenTabShowed", "()Z", "lastEnterFinderLiveTime", "getLastEnterFinderLiveTime", "lastEnterFinderTlTime", "getLastEnterFinderTlTime", "lastEnterNearbyTime", "getLastEnterNearbyTime", "lastExitFinderLiveTime", "getLastExitFinderLiveTime", "lastExitFinderTlTime", "getLastExitFinderTlTime", "lastExitNearbyTime", "getLastExitNearbyTime", "moreTabFollowEntranceTimeMs", "getMoreTabFollowEntranceTimeMs", "moreTabFollowTabTimeMs", "getMoreTabFollowTabTimeMs", "moreTabFriendEntranceTimeMs", "getMoreTabFriendEntranceTimeMs", "moreTabFriendPostTimeMs", "getMoreTabFriendPostTimeMs", "moreTabHotEntranceTimeMs", "getMoreTabHotEntranceTimeMs", "moreTabLiveEntranceTimeMs", "getMoreTabLiveEntranceTimeMs", "moreTabNearbyEntranceTimeMs", "getMoreTabNearbyEntranceTimeMs", "moreTabNewsEntranceTimeMs", "getMoreTabNewsEntranceTimeMs", "newFeedTipsFastEnterFirstTimeInterval", "getNewFeedTipsFastEnterFirstTimeInterval", "newFeedTipsFastEnterSecondTimeInterval", "getNewFeedTipsFastEnterSecondTimeInterval", "newFeedTipsFastEnterThirdTimeInterval", "getNewFeedTipsFastEnterThirdTimeInterval", "newFollowTipsEnterInterval", "getNewFollowTipsEnterInterval", "newMsgEntranceInterval", "getNewMsgEntranceInterval", "newUnFollowTipsEnterInterval", "getNewUnFollowTipsEnterInterval", "refreshDiscoveryTimeMs", "getRefreshDiscoveryTimeMs", "refreshEntranceInterval", "getRefreshEntranceInterval", "addLevelTime", "setCurrentFastEnterLevel", "", "level", "setFullScreenTabShowed", "isShowed", "testFactor", "updateFinderLiveLastEnterTime", "updateFinderLiveLastExitTime", "updateLastEnterTime", "updateLastExitTime", "updateNearbyLastEnterTime", "updateNearbyLastExitTime", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  public static final q ASF;
  
  static
  {
    AppMethodBeat.i(178219);
    ASF = new q();
    AppMethodBeat.o(178219);
  }
  
  public static void NB(int paramInt)
  {
    AppMethodBeat.i(178214);
    h.baE().ban().set(at.a.adbz, Integer.valueOf(paramInt));
    AppMethodBeat.o(178214);
  }
  
  public static long eaJ()
  {
    AppMethodBeat.i(178209);
    long l = ((a)h.ax(a.class)).aRC().getInt("FinderFastEnterTime", 0);
    AppMethodBeat.o(178209);
    return l * 1000L;
  }
  
  private static long eaK()
  {
    AppMethodBeat.i(178210);
    long l = ((a)h.ax(a.class)).aRC().getInt("FinderNewFeedTipsFastEnterFirstTimeInterval", 86400) * 1000L / ebb();
    AppMethodBeat.o(178210);
    return l;
  }
  
  private static long eaL()
  {
    AppMethodBeat.i(178211);
    long l = ((a)h.ax(a.class)).aRC().getInt("FinderNewFeedTipsFastEnterSecondTimeInterval", 172800) * 1000L / ebb();
    AppMethodBeat.o(178211);
    return l;
  }
  
  private static long eaM()
  {
    AppMethodBeat.i(178212);
    long l = ((a)h.ax(a.class)).aRC().getInt("FinderNewFeedTipsFastEnterThirdTimeInterval", 604800) * 1000L / ebb();
    AppMethodBeat.o(178212);
    return l;
  }
  
  public static int eaN()
  {
    AppMethodBeat.i(178213);
    int i = h.baE().ban().getInt(at.a.adbz, 0);
    AppMethodBeat.o(178213);
    return i;
  }
  
  public static void eaO()
  {
    AppMethodBeat.i(366868);
    h.baE().ban().set(at.a.adcz, Boolean.FALSE);
    AppMethodBeat.o(366868);
  }
  
  public static long eaP()
  {
    AppMethodBeat.i(178215);
    long l = h.baE().ban().a(at.a.adbI, 0L);
    AppMethodBeat.o(178215);
    return l;
  }
  
  public static long eaQ()
  {
    AppMethodBeat.i(366891);
    long l = h.baE().ban().a(at.a.adbH, 0L);
    AppMethodBeat.o(366891);
    return l;
  }
  
  public static long eaR()
  {
    AppMethodBeat.i(366901);
    long l = h.baE().ban().a(at.a.adbK, 0L);
    AppMethodBeat.o(366901);
    return l;
  }
  
  public static long eaS()
  {
    AppMethodBeat.i(366910);
    long l = h.baE().ban().a(at.a.adbM, 0L);
    AppMethodBeat.o(366910);
    return l;
  }
  
  public static long eaT()
  {
    AppMethodBeat.i(366917);
    long l = h.baE().ban().a(at.a.adbL, 0L);
    AppMethodBeat.o(366917);
    return l;
  }
  
  public static void eaU()
  {
    AppMethodBeat.i(178216);
    h.baE().ban().set(at.a.adbI, Long.valueOf(cn.bDw()));
    AppMethodBeat.o(178216);
  }
  
  public static void eaV()
  {
    AppMethodBeat.i(366925);
    h.baE().ban().set(at.a.adbH, Long.valueOf(cn.bDw()));
    AppMethodBeat.o(366925);
  }
  
  public static void eaW()
  {
    AppMethodBeat.i(366928);
    h.baE().ban().set(at.a.adbK, Long.valueOf(cn.bDw()));
    AppMethodBeat.o(366928);
  }
  
  public static void eaX()
  {
    AppMethodBeat.i(366933);
    h.baE().ban().set(at.a.adbJ, Long.valueOf(cn.bDw()));
    AppMethodBeat.o(366933);
  }
  
  public static void eaY()
  {
    AppMethodBeat.i(366936);
    h.baE().ban().set(at.a.adbM, Long.valueOf(cn.bDw()));
    AppMethodBeat.o(366936);
  }
  
  public static void eaZ()
  {
    AppMethodBeat.i(366938);
    h.baE().ban().set(at.a.adbL, Long.valueOf(cn.bDw()));
    AppMethodBeat.o(366938);
  }
  
  private static long eba()
  {
    AppMethodBeat.i(178217);
    switch (eaN())
    {
    default: 
      AppMethodBeat.o(178217);
      return 0L;
    case 1: 
      l = eaK();
      AppMethodBeat.o(178217);
      return l;
    case 2: 
      l = eaL();
      AppMethodBeat.o(178217);
      return l;
    }
    long l = eaM();
    AppMethodBeat.o(178217);
    return l;
  }
  
  public static int ebb()
  {
    AppMethodBeat.i(178218);
    d locald = d.FAy;
    int i = ((Number)d.eSS().bmg()).intValue();
    AppMethodBeat.o(178218);
    return i;
  }
  
  public final long eaA()
  {
    AppMethodBeat.i(366947);
    long l1 = ((c)h.ax(c.class)).a(c.a.zat, 0) * 1000L / ebb();
    long l2 = eba();
    AppMethodBeat.o(366947);
    return l1 + l2;
  }
  
  public final long eaB()
  {
    AppMethodBeat.i(366950);
    long l1 = ((c)h.ax(c.class)).a(c.a.zau, 7200) * 1000L / ebb();
    long l2 = eba();
    AppMethodBeat.o(366950);
    return l1 + l2;
  }
  
  public final long eaC()
  {
    AppMethodBeat.i(366952);
    long l1 = ((c)h.ax(c.class)).a(c.a.zav, 7200) * 1000L / ebb();
    long l2 = eba();
    AppMethodBeat.o(366952);
    return l1 + l2;
  }
  
  public final long eaD()
  {
    AppMethodBeat.i(366953);
    long l1 = ((c)h.ax(c.class)).a(c.a.zaw, 7200) * 1000L / ebb();
    long l2 = eba();
    AppMethodBeat.o(366953);
    return l1 + l2;
  }
  
  public final long eaE()
  {
    AppMethodBeat.i(366956);
    long l1 = ((c)h.ax(c.class)).a(c.a.zay, 7200) * 1000L / ebb();
    long l2 = eba();
    AppMethodBeat.o(366956);
    return l1 + l2;
  }
  
  public final long eaF()
  {
    AppMethodBeat.i(366959);
    long l1 = ((c)h.ax(c.class)).a(c.a.zax, 7200) * 1000L / ebb();
    long l2 = eba();
    AppMethodBeat.o(366959);
    return l1 + l2;
  }
  
  public final long eaG()
  {
    AppMethodBeat.i(366962);
    long l1 = ((c)h.ax(c.class)).a(c.a.zaz, 7200) * 1000L / ebb();
    long l2 = eba();
    AppMethodBeat.o(366962);
    return l1 + l2;
  }
  
  public final long eaH()
  {
    AppMethodBeat.i(366966);
    long l1 = ((c)h.ax(c.class)).a(c.a.zaA, 7200) * 1000L / ebb();
    long l2 = eba();
    AppMethodBeat.o(366966);
    return l1 + l2;
  }
  
  public final long eaI()
  {
    AppMethodBeat.i(366970);
    long l1 = ((c)h.ax(c.class)).a(c.a.zap, 7200) * 1000L / ebb();
    long l2 = eba();
    AppMethodBeat.o(366970);
    return l1 + l2;
  }
  
  public final long eaz()
  {
    AppMethodBeat.i(366946);
    long l1 = ((c)h.ax(c.class)).a(c.a.zas, 7200) * 1000L / ebb();
    long l2 = eba();
    AppMethodBeat.o(366946);
    return l1 + l2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.q
 * JD-Core Version:    0.7.0.1
 */