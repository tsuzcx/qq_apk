package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/ThreeDayTwoDay;", "", "()V", "TAG", "", "hasRedDotBeforeRevoke", "", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "afterRevokeRedDot", "", "beforeRevokeRedDot", "checkEnable", "checkInLimitTwoDay", "checkOverThreeDay", "checkRedDotFilter", "ctrlInfo", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "checkThreeDayBegin", "enterFindMoreFriendTab", "enterFinder", "init", "onConfigChange", "reset", "begin", "", "plugin-finder_release"})
public final class n
{
  static f wVw;
  static boolean xuV;
  public static final n xuW;
  
  static
  {
    AppMethodBeat.i(292047);
    xuW = new n();
    AppMethodBeat.o(292047);
  }
  
  private static boolean azH()
  {
    AppMethodBeat.i(292039);
    d locald = d.AjH;
    if (((Number)d.dVP().aSr()).intValue() == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      reset(0L);
      AppMethodBeat.o(292039);
      return false;
    }
    AppMethodBeat.o(292039);
    return true;
  }
  
  public static void dsh()
  {
    AppMethodBeat.i(292041);
    Object localObject = wVw;
    if (localObject != null)
    {
      localObject = ((f)localObject).aBf("FinderEntrance");
      if (localObject == null) {
        break label55;
      }
    }
    label55:
    for (boolean bool = true;; bool = false)
    {
      Log.i("Finder.ThreeDayTwoDay", "beforeRevokeRedDot hasRed=".concat(String.valueOf(bool)));
      xuV = bool;
      AppMethodBeat.o(292041);
      return;
      localObject = null;
      break;
    }
  }
  
  static void reset(long paramLong)
  {
    AppMethodBeat.i(292044);
    Log.i("Finder.ThreeDayTwoDay", "[reset] begin=".concat(String.valueOf(paramLong)));
    com.tencent.mm.kernel.f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VBz, Long.valueOf(0L));
    localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VBA, Long.valueOf(paramLong));
    AppMethodBeat.o(292044);
  }
  
  final boolean dsi()
  {
    AppMethodBeat.i(292042);
    if (!azH())
    {
      AppMethodBeat.o(292042);
      return false;
    }
    dsj();
    Object localObject = wVw;
    if (localObject != null)
    {
      localObject = ((f)localObject).aBf("FinderEntrance");
      if (localObject == null) {
        break label273;
      }
    }
    int i;
    long l3;
    label273:
    for (boolean bool = true;; bool = false)
    {
      localObject = d.AjH;
      i = ((Number)d.dVQ().aSr()).intValue();
      localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      long l1 = ((com.tencent.mm.kernel.f)localObject).aHp().a(ar.a.VBA, 0L);
      localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      long l2 = ((com.tencent.mm.kernel.f)localObject).aHp().a(ar.a.VBz, 0L);
      l3 = cm.bfE() - l1;
      Log.i("Finder.ThreeDayTwoDay", "[checkOverThreeDay] hasRed=" + bool + " threadDayBegin=" + l1 + " threeDayThreshold=" + i + " hitThreeDayTime=" + l2 + " diffThreeDay=" + l3);
      if ((!bool) || (l1 <= 0L) || (l2 != 0L) || (l3 < i)) {
        break label278;
      }
      Log.i("Finder.ThreeDayTwoDay", "[checkOverThreeDay] USERINFO_FINDER_THREE_DAY_HIT_TIME_LONG_SYNC=" + cm.bfE());
      localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBz, Long.valueOf(cm.bfE()));
      AppMethodBeat.o(292042);
      return true;
      localObject = null;
      break;
    }
    label278:
    if (l3 >= i)
    {
      AppMethodBeat.o(292042);
      return true;
    }
    AppMethodBeat.o(292042);
    return false;
  }
  
  final void dsj()
  {
    AppMethodBeat.i(292043);
    boolean bool2 = azH();
    if (!bool2)
    {
      AppMethodBeat.o(292043);
      return;
    }
    Object localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    long l = ((com.tencent.mm.kernel.f)localObject).aHp().a(ar.a.VBA, 0L);
    localObject = wVw;
    if (localObject != null)
    {
      localObject = ((f)localObject).aBf("FinderEntrance");
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
        Log.i("Finder.ThreeDayTwoDay", "[checkThreeDayBegin] USERINFO_FINDER_THREE_DAY_BEGIN_TIME_LONG_SYNC=" + cm.bfE());
        localObject = h.aHG();
        p.j(localObject, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBA, Long.valueOf(cm.bfE()));
      }
      AppMethodBeat.o(292043);
      return;
      localObject = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.n
 * JD-Core Version:    0.7.0.1
 */