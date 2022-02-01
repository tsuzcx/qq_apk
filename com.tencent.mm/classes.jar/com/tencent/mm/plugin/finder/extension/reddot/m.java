package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.config.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/reddot/ThreeDayTwoDay;", "", "()V", "TAG", "", "hasRedDotBeforeRevoke", "", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "afterRevokeRedDot", "", "beforeRevokeRedDot", "checkEnable", "checkInLimitTwoDay", "checkOverThreeDay", "checkRedDotFilter", "ctrlInfo", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "checkThreeDayBegin", "enterFindMoreFriendTab", "enterFinder", "init", "onConfigChange", "reset", "begin", "", "plugin-finder_release"})
public final class m
{
  static boolean tLv;
  public static final m tLw;
  static f toy;
  
  static
  {
    AppMethodBeat.i(243660);
    tLw = new m();
    AppMethodBeat.o(243660);
  }
  
  private static boolean asT()
  {
    AppMethodBeat.i(243654);
    c localc = c.vCb;
    if (((Number)c.duI().value()).intValue() == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      reset(0L);
      AppMethodBeat.o(243654);
      return false;
    }
    AppMethodBeat.o(243654);
    return true;
  }
  
  public static void dbU()
  {
    AppMethodBeat.i(243655);
    Object localObject = toy;
    if (localObject != null)
    {
      localObject = ((f)localObject).asX("FinderEntrance");
      if (localObject == null) {
        break label55;
      }
    }
    label55:
    for (boolean bool = true;; bool = false)
    {
      Log.i("Finder.ThreeDayTwoDay", "beforeRevokeRedDot hasRed=".concat(String.valueOf(bool)));
      tLv = bool;
      AppMethodBeat.o(243655);
      return;
      localObject = null;
      break;
    }
  }
  
  static void reset(long paramLong)
  {
    AppMethodBeat.i(243658);
    Log.i("Finder.ThreeDayTwoDay", "[reset] begin=".concat(String.valueOf(paramLong)));
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.OmA, Long.valueOf(0L));
    locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.OmB, Long.valueOf(paramLong));
    AppMethodBeat.o(243658);
  }
  
  final boolean dbV()
  {
    AppMethodBeat.i(243656);
    if (!asT())
    {
      AppMethodBeat.o(243656);
      return false;
    }
    dbW();
    Object localObject = toy;
    if (localObject != null)
    {
      localObject = ((f)localObject).asX("FinderEntrance");
      if (localObject == null) {
        break label273;
      }
    }
    int i;
    long l3;
    label273:
    for (boolean bool = true;; bool = false)
    {
      localObject = c.vCb;
      i = ((Number)c.duJ().value()).intValue();
      localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      long l1 = ((e)localObject).azQ().a(ar.a.OmB, 0L);
      localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      long l2 = ((e)localObject).azQ().a(ar.a.OmA, 0L);
      l3 = cl.aWA() - l1;
      Log.i("Finder.ThreeDayTwoDay", "[checkOverThreeDay] hasRed=" + bool + " threadDayBegin=" + l1 + " threeDayThreshold=" + i + " hitThreeDayTime=" + l2 + " diffThreeDay=" + l3);
      if ((!bool) || (l1 <= 0L) || (l2 != 0L) || (l3 < i)) {
        break label278;
      }
      Log.i("Finder.ThreeDayTwoDay", "[checkOverThreeDay] USERINFO_FINDER_THREE_DAY_HIT_TIME_LONG_SYNC=" + cl.aWA());
      localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      ((e)localObject).azQ().set(ar.a.OmA, Long.valueOf(cl.aWA()));
      AppMethodBeat.o(243656);
      return true;
      localObject = null;
      break;
    }
    label278:
    if (l3 >= i)
    {
      AppMethodBeat.o(243656);
      return true;
    }
    AppMethodBeat.o(243656);
    return false;
  }
  
  final void dbW()
  {
    AppMethodBeat.i(243657);
    boolean bool2 = asT();
    if (!bool2)
    {
      AppMethodBeat.o(243657);
      return;
    }
    Object localObject = g.aAh();
    p.g(localObject, "MMKernel.storage()");
    long l = ((e)localObject).azQ().a(ar.a.OmB, 0L);
    localObject = toy;
    if (localObject != null)
    {
      localObject = ((f)localObject).asX("FinderEntrance");
      if (localObject == null) {
        break label187;
      }
    }
    label187:
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("Finder.ThreeDayTwoDay", "[checkThreeDayTwoDay] isEnable=" + bool2 + " begin=" + l + " hasRed=" + bool1);
      if ((bool2) && (l == 0L) && (bool1))
      {
        Log.i("Finder.ThreeDayTwoDay", "[checkThreeDayBegin] USERINFO_FINDER_THREE_DAY_BEGIN_TIME_LONG_SYNC=" + cl.aWA());
        localObject = g.aAh();
        p.g(localObject, "MMKernel.storage()");
        ((e)localObject).azQ().set(ar.a.OmB, Long.valueOf(cl.aWA()));
      }
      AppMethodBeat.o(243657);
      return;
      localObject = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.m
 * JD-Core Version:    0.7.0.1
 */