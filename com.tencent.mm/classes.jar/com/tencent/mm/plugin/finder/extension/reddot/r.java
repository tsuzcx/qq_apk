package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/ThreeDayTwoDay;", "", "()V", "TAG", "", "hasRedDotBeforeRevoke", "", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "afterRevokeRedDot", "", "beforeRevokeRedDot", "checkEnable", "checkInLimitTwoDay", "checkOverThreeDay", "checkRedDotFilter", "ctrlInfo", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "checkThreeDayBegin", "enterFindMoreFriendTab", "enterFinder", "init", "onConfigChange", "reset", "begin", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
{
  public static final r ASG;
  static boolean ASH;
  static i Asl;
  
  static
  {
    AppMethodBeat.i(366799);
    ASG = new r();
    AppMethodBeat.o(366799);
  }
  
  public static void c(i parami)
  {
    AppMethodBeat.i(366776);
    s.u(parami, "redDotManager");
    AppMethodBeat.o(366776);
  }
  
  private static boolean ebc()
  {
    AppMethodBeat.i(366767);
    d locald = d.FAy;
    if (((Number)d.eUr().bmg()).intValue() == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      reset(0L);
      AppMethodBeat.o(366767);
      return false;
    }
    AppMethodBeat.o(366767);
    return true;
  }
  
  public static void ebd()
  {
    AppMethodBeat.i(366785);
    Object localObject = Asl;
    if (localObject == null)
    {
      localObject = null;
      if (localObject == null) {
        break label55;
      }
    }
    label55:
    for (boolean bool = true;; bool = false)
    {
      Log.i("Finder.ThreeDayTwoDay", s.X("beforeRevokeRedDot hasRed=", Boolean.valueOf(bool)));
      ASH = bool;
      AppMethodBeat.o(366785);
      return;
      localObject = ((i)localObject).Su("FinderEntrance");
      break;
    }
  }
  
  static void reset(long paramLong)
  {
    AppMethodBeat.i(366790);
    Log.i("Finder.ThreeDayTwoDay", s.X("[reset] begin=", Long.valueOf(paramLong)));
    h.baE().ban().set(at.a.addV, Long.valueOf(0L));
    h.baE().ban().set(at.a.addW, Long.valueOf(paramLong));
    AppMethodBeat.o(366790);
  }
  
  final boolean ebe()
  {
    AppMethodBeat.i(366808);
    if (!ebc())
    {
      AppMethodBeat.o(366808);
      return false;
    }
    ebf();
    Object localObject = Asl;
    if (localObject == null)
    {
      localObject = null;
      if (localObject == null) {
        break label233;
      }
    }
    int i;
    long l3;
    label233:
    for (boolean bool = true;; bool = false)
    {
      localObject = d.FAy;
      i = ((Number)d.eUs().bmg()).intValue();
      long l1 = h.baE().ban().a(at.a.addW, 0L);
      long l2 = h.baE().ban().a(at.a.addV, 0L);
      l3 = cn.bDw() - l1;
      Log.i("Finder.ThreeDayTwoDay", "[checkOverThreeDay] hasRed=" + bool + " threadDayBegin=" + l1 + " threeDayThreshold=" + i + " hitThreeDayTime=" + l2 + " diffThreeDay=" + l3);
      if ((!bool) || (l1 <= 0L) || (l2 != 0L) || (l3 < i)) {
        break label238;
      }
      Log.i("Finder.ThreeDayTwoDay", s.X("[checkOverThreeDay] USERINFO_FINDER_THREE_DAY_HIT_TIME_LONG_SYNC=", Long.valueOf(cn.bDw())));
      h.baE().ban().set(at.a.addV, Long.valueOf(cn.bDw()));
      AppMethodBeat.o(366808);
      return true;
      localObject = ((i)localObject).Su("FinderEntrance");
      break;
    }
    label238:
    if (l3 >= i)
    {
      AppMethodBeat.o(366808);
      return true;
    }
    AppMethodBeat.o(366808);
    return false;
  }
  
  final void ebf()
  {
    AppMethodBeat.i(366816);
    boolean bool2 = ebc();
    if (!bool2)
    {
      AppMethodBeat.o(366816);
      return;
    }
    long l = h.baE().ban().a(at.a.addW, 0L);
    Object localObject = Asl;
    if (localObject == null)
    {
      localObject = null;
      if (localObject == null) {
        break label158;
      }
    }
    label158:
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("Finder.ThreeDayTwoDay", "[checkThreeDayTwoDay] isEnable=" + bool2 + " begin=" + l + " hasRed=" + bool1);
      if ((bool2) && (l == 0L) && (bool1))
      {
        Log.i("Finder.ThreeDayTwoDay", s.X("[checkThreeDayBegin] USERINFO_FINDER_THREE_DAY_BEGIN_TIME_LONG_SYNC=", Long.valueOf(cn.bDw())));
        h.baE().ban().set(at.a.addW, Long.valueOf(cn.bDw()));
      }
      AppMethodBeat.o(366816);
      return;
      localObject = ((i)localObject).Su("FinderEntrance");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.r
 * JD-Core Version:    0.7.0.1
 */