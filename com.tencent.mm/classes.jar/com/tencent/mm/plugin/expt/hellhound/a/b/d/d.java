package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.c;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.protocal.protobuf.cct;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.j;
import d.g.b.k;
import d.k.h;
import d.l;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderShareStatistics;", "", "()V", "mStayTime", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "doOn7EventV2", "", "pageName", "", "timestamp", "", "doOn8EventV2", "doOnActivityCreateV2", "activity", "Landroid/app/Activity;", "doOnFinishActivityV2", "getBackgroundTime", "timePairLsit", "Ljava/util/LinkedList;", "on7Event", "on8Event", "onActivityCreate", "onFinishActivity", "onPagePaused", "onPageResumed", "toStayTimeStatistics", "statistics", "Lcom/tencent/mm/protocal/protobuf/PageStatistics;", "reportType", "", "Companion", "plugin-expt_release"})
public final class d
{
  public static final d.a qoH;
  public com.tencent.mm.plugin.expt.hellhound.a.b.c.b qoG;
  
  static
  {
    AppMethodBeat.i(195546);
    qoH = new d.a((byte)0);
    AppMethodBeat.o(195546);
  }
  
  public static long Z(LinkedList<Long> paramLinkedList)
  {
    long l2 = 0L;
    AppMethodBeat.i(195543);
    if (paramLinkedList.isEmpty())
    {
      AppMethodBeat.o(195543);
      return 0L;
    }
    if (paramLinkedList.size() % 2 != 0) {
      paramLinkedList.removeLast();
    }
    Object localObject = h.a((d.k.b)h.kZ(0, paramLinkedList.size()), 2);
    int i = ((d.k.b)localObject).KVb;
    int j = ((d.k.b)localObject).KVc;
    int k = ((d.k.b)localObject).kar;
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
    AppMethodBeat.o(195543);
    return l1;
  }
  
  public static com.tencent.mm.plugin.expt.hellhound.a.b.c.b a(cct paramcct, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(195542);
    com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
    localb.sessionId = paramcct.sessionId;
    localb.qoi = paramcct.qoi;
    if (k.g(localb.qoi, "FinderTopicFeedUI"))
    {
      c.a locala = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qna;
      if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cjQ() == c.c.qng.value) {
        bool = true;
      }
    }
    for (localb.qoo = bool;; localb.qoo = false)
    {
      localb.qoj = paramcct.qoj;
      localb.qok = paramcct.qok;
      localb.qol = paramcct.qol;
      localb.qom = paramcct.qom;
      localb.qon = paramcct.qon;
      localb.dtw = paramInt;
      AppMethodBeat.o(195542);
      return localb;
    }
  }
  
  public static void h(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(195544);
    Object localObject1 = f.qoN.cjU();
    Object localObject2;
    if ((localObject1 == null) || (((cct)localObject1).dtw == 8))
    {
      if (paramActivity == null) {
        break label198;
      }
      localObject1 = paramActivity.getClass();
      if (localObject1 == null) {
        break label198;
      }
      localObject1 = ((Class)localObject1).getName();
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qna;
      if (j.a((Iterable)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cjO(), localObject1))
      {
        localObject2 = new cct();
        ((cct)localObject2).sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cku().cit();
        ((cct)localObject2).qoi = com.tencent.mm.plugin.expt.hellhound.core.b.ZK((String)localObject1);
        if (paramActivity == null) {
          break label204;
        }
      }
    }
    label198:
    label204:
    for (int i = paramActivity.hashCode();; i = 0)
    {
      ((cct)localObject2).aFZ = i;
      ((cct)localObject2).qok = paramLong;
      paramActivity = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.qpX;
      ((cct)localObject2).qon = b.a.ckz();
      ((cct)localObject2).dtw = c.b.qnc.value;
      f.qoN.b((cct)localObject2);
      ac.i("HABBYGE-MALI.FinderShareStatistics", "doOnActivityCreateV2: " + ((cct)localObject2).qoi + ", " + ((cct)localObject2).aFZ);
      AppMethodBeat.o(195544);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public static void sV(long paramLong)
  {
    AppMethodBeat.i(195545);
    cct localcct = f.qoN.cjU();
    if ((localcct != null) && (localcct.dtw == 8))
    {
      localcct.qok = paramLong;
      localcct.qol = 0L;
      localcct.qoj = 0L;
      localcct.dtw = c.b.qnc.value;
      f.qoN.b(localcct);
      ac.i("HABBYGE-MALI.FinderShareStatistics", "doOn7EventV2: " + localcct.qoi + ", " + localcct.aFZ);
    }
    AppMethodBeat.o(195545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.d
 * JD-Core Version:    0.7.0.1
 */