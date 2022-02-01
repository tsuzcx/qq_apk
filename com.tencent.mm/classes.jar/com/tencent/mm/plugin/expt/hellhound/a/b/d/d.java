package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.c;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.k;
import d.k.h;
import d.l;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderShareStatistics;", "", "()V", "mStayTime", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "doOn7EventV2", "", "pageName", "", "timestamp", "", "doOn8EventV2", "doOnActivityCreateV2", "activity", "Landroid/app/Activity;", "doOnFinishActivityV2", "getBackgroundTime", "timePairLsit", "Ljava/util/LinkedList;", "on7Event", "on8Event", "onActivityCreate", "onFinishActivity", "onPagePaused", "onPageResumed", "toStayTimeStatistics", "statistics", "Lcom/tencent/mm/protocal/protobuf/PageStatistics;", "reportType", "", "Companion", "plugin-expt_release"})
public final class d
{
  public static final a KIp;
  public com.tencent.mm.plugin.expt.hellhound.a.b.c.b KIo;
  
  static
  {
    AppMethodBeat.i(205287);
    KIp = new a((byte)0);
    AppMethodBeat.o(205287);
  }
  
  public static void Bo(long paramLong)
  {
    AppMethodBeat.i(205286);
    ebj localebj = f.KIv.fRN();
    if ((localebj != null) && (localebj.dvJ == 8))
    {
      localebj.KHU = paramLong;
      localebj.KHV = 0L;
      localebj.xBr = 0L;
      localebj.dvJ = c.b.KGO.value;
      f.KIv.b(localebj);
      ad.i("HABBYGE-MALI.FinderShareStatistics", "doOn7EventV2: " + localebj.DDP + ", " + localebj.aFj);
    }
    AppMethodBeat.o(205286);
  }
  
  public static com.tencent.mm.plugin.expt.hellhound.a.b.c.b a(ebj paramebj, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(205283);
    com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
    localb.sessionId = paramebj.sessionId;
    localb.DDP = paramebj.DDP;
    if (k.g(localb.DDP, "FinderTopicFeedUI"))
    {
      c.a locala = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KGM;
      if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.fRJ() == c.c.KGS.value) {
        bool = true;
      }
    }
    for (localb.KHX = bool;; localb.KHX = false)
    {
      localb.xBr = paramebj.xBr;
      localb.KHU = paramebj.KHU;
      localb.KHV = paramebj.KHV;
      localb.KHW = paramebj.KHW;
      localb.pZX = paramebj.pZX;
      localb.dvJ = paramInt;
      AppMethodBeat.o(205283);
      return localb;
    }
  }
  
  public static long ac(LinkedList<Long> paramLinkedList)
  {
    long l2 = 0L;
    AppMethodBeat.i(205284);
    if (paramLinkedList.isEmpty())
    {
      AppMethodBeat.o(205284);
      return 0L;
    }
    if (paramLinkedList.size() % 2 != 0) {
      paramLinkedList.removeLast();
    }
    Object localObject = h.a((d.k.b)h.kJ(0, paramLinkedList.size()), 2);
    int i = ((d.k.b)localObject).JhH;
    int j = ((d.k.b)localObject).JhI;
    int k = ((d.k.b)localObject).jzV;
    long l1;
    if (k >= 0)
    {
      l1 = l2;
      if (i > j) {}
    }
    else
    {
      do
      {
        for (;;)
        {
          l1 = ((Number)paramLinkedList.get(i + 1)).longValue();
          localObject = paramLinkedList.get(i);
          k.g(localObject, "timePairLsit[i]");
          l2 += l1 - ((Number)localObject).longValue();
          l1 = l2;
          if (i == j) {
            break;
          }
          i += k;
        }
        l1 = l2;
      } while (i >= j);
    }
    AppMethodBeat.o(205284);
    return l1;
  }
  
  public static void h(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(205285);
    Object localObject1 = f.KIv.fRN();
    Object localObject2;
    if ((localObject1 == null) || (((ebj)localObject1).dvJ == 8))
    {
      if (paramActivity == null) {
        break label196;
      }
      localObject1 = paramActivity.getClass();
      if (localObject1 == null) {
        break label196;
      }
      localObject1 = ((Class)localObject1).getName();
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KGM;
      if (j.a((Iterable)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.fRH(), localObject1))
      {
        localObject2 = new ebj();
        ((ebj)localObject2).sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.ccM().cbk();
        ((ebj)localObject2).DDP = com.tencent.mm.plugin.expt.hellhound.core.b.Vy((String)localObject1);
        if (paramActivity == null) {
          break label202;
        }
      }
    }
    label196:
    label202:
    for (int i = paramActivity.hashCode();; i = 0)
    {
      ((ebj)localObject2).aFj = i;
      ((ebj)localObject2).KHU = paramLong;
      paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.pHq;
      ((ebj)localObject2).pZX = b.a.ccR();
      ((ebj)localObject2).dvJ = c.b.KGO.value;
      f.KIv.b((ebj)localObject2);
      ad.i("HABBYGE-MALI.FinderShareStatistics", "doOnActivityCreateV2: " + ((ebj)localObject2).DDP + ", " + ((ebj)localObject2).aFj);
      AppMethodBeat.o(205285);
      return;
      localObject1 = null;
      break;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderShareStatistics$Companion;", "", "()V", "TAG", "", "plugin-expt_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.d
 * JD-Core Version:    0.7.0.1
 */