package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/extension/reddot/ThreeDayTwoDay;", "", "()V", "TAG", "", "hasRedDotBeforeRevoke", "", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "afterRevokeRedDot", "", "beforeRevokeRedDot", "checkEnable", "checkInLimitTwoDay", "checkOverThreeDay", "checkRedDotFilter", "ctrlInfo", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "checkThreeDayBegin", "enterFindMoreFriendTab", "enterFinder", "init", "onConfigChange", "reset", "begin", "", "plugin-finder_release"})
public final class k
{
  static e rOC;
  static boolean sbN;
  public static final k sbO;
  
  static
  {
    AppMethodBeat.i(202123);
    sbO = new k();
    AppMethodBeat.o(202123);
  }
  
  private static boolean cCg()
  {
    AppMethodBeat.i(202117);
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cKN().value()).intValue() == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      reset(0L);
      AppMethodBeat.o(202117);
      return false;
    }
    AppMethodBeat.o(202117);
    return true;
  }
  
  public static void cCh()
  {
    AppMethodBeat.i(202118);
    Object localObject = rOC;
    if (localObject != null)
    {
      localObject = ((e)localObject).aij("FinderEntrance");
      if (localObject == null) {
        break label55;
      }
    }
    label55:
    for (boolean bool = true;; bool = false)
    {
      ae.i("Finder.ThreeDayTwoDay", "beforeRevokeRedDot hasRed=".concat(String.valueOf(bool)));
      sbN = bool;
      AppMethodBeat.o(202118);
      return;
      localObject = null;
      break;
    }
  }
  
  static boolean cCi()
  {
    AppMethodBeat.i(202119);
    if (!cCg())
    {
      AppMethodBeat.o(202119);
      return false;
    }
    cCj();
    Object localObject = rOC;
    if (localObject != null)
    {
      localObject = ((e)localObject).aij("FinderEntrance");
      if (localObject == null) {
        break label272;
      }
    }
    int i;
    long l3;
    label272:
    for (boolean bool = true;; bool = false)
    {
      localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
      i = ((Number)com.tencent.mm.plugin.finder.storage.b.cKO().value()).intValue();
      localObject = g.ajR();
      p.g(localObject, "MMKernel.storage()");
      long l1 = ((com.tencent.mm.kernel.e)localObject).ajA().a(am.a.Jdm, 0L);
      localObject = g.ajR();
      p.g(localObject, "MMKernel.storage()");
      long l2 = ((com.tencent.mm.kernel.e)localObject).ajA().a(am.a.Jdl, 0L);
      l3 = ch.aDc() - l1;
      ae.i("Finder.ThreeDayTwoDay", "[checkOverThreeDay] hasRed=" + bool + " threadDayBegin=" + l1 + " threeDayThreshold=" + i + " hitThreeDayTime=" + l2 + " diffThreeDay=" + l3);
      if ((!bool) || (l1 <= 0L) || (l2 != 0L) || (l3 < i)) {
        break label277;
      }
      ae.i("Finder.ThreeDayTwoDay", "[checkOverThreeDay] USERINFO_FINDER_THREE_DAY_HIT_TIME_LONG_SYNC=" + ch.aDc());
      localObject = g.ajR();
      p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jdl, Long.valueOf(ch.aDc()));
      AppMethodBeat.o(202119);
      return true;
      localObject = null;
      break;
    }
    label277:
    if (l3 >= i)
    {
      AppMethodBeat.o(202119);
      return true;
    }
    AppMethodBeat.o(202119);
    return false;
  }
  
  static void cCj()
  {
    AppMethodBeat.i(202120);
    boolean bool2 = cCg();
    if (!bool2)
    {
      AppMethodBeat.o(202120);
      return;
    }
    Object localObject = g.ajR();
    p.g(localObject, "MMKernel.storage()");
    long l = ((com.tencent.mm.kernel.e)localObject).ajA().a(am.a.Jdm, 0L);
    localObject = rOC;
    if (localObject != null)
    {
      localObject = ((e)localObject).aij("FinderEntrance");
      if (localObject == null) {
        break label187;
      }
    }
    label187:
    for (boolean bool1 = true;; bool1 = false)
    {
      ae.i("Finder.ThreeDayTwoDay", "[checkThreeDayTwoDay] isEnable=" + bool2 + " begin=" + l + " hasRed=" + bool1);
      if ((bool2) && (l == 0L) && (bool1))
      {
        ae.i("Finder.ThreeDayTwoDay", "[checkThreeDayBegin] USERINFO_FINDER_THREE_DAY_BEGIN_TIME_LONG_SYNC=" + ch.aDc());
        localObject = g.ajR();
        p.g(localObject, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.Jdm, Long.valueOf(ch.aDc()));
      }
      AppMethodBeat.o(202120);
      return;
      localObject = null;
      break;
    }
  }
  
  static void reset(long paramLong)
  {
    AppMethodBeat.i(202121);
    ae.i("Finder.ThreeDayTwoDay", "[reset] begin=".concat(String.valueOf(paramLong)));
    com.tencent.mm.kernel.e locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.Jdl, Long.valueOf(0L));
    locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.Jdm, Long.valueOf(paramLong));
    AppMethodBeat.o(202121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.k
 * JD-Core Version:    0.7.0.1
 */