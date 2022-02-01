package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.c;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.k.h;
import d.l;
import java.util.Collection;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderShareStatistics;", "", "()V", "mCurPageNameStaticsing", "", "mCurPageNameStaticsingOnCreate", "mStayTime", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "getBackgroundTime", "", "timePairLsit", "Ljava/util/LinkedList;", "on7Event", "", "pageName", "hashCode", "", "timestamp", "on7EventV1", "on7EventV2", "on8Event", "on8EventV1", "on8EventV2", "onActivityCreate", "activity", "Landroid/app/Activity;", "onActivityCreateV1", "sPageName", "onActivityCreateV2", "onFinishActivity", "onFinishActivityV1", "onFinishActivityV2", "onPagePaused", "onPageResumed", "toStayTimeStatistics", "statistics", "Lcom/tencent/mm/protocal/protobuf/PageStatistics;", "reportType", "Companion", "plugin-expt_release"})
public final class d
{
  public static final d.a qXG;
  public com.tencent.mm.plugin.expt.hellhound.a.b.c.b qXD;
  public String qXE;
  public String qXF;
  
  static
  {
    AppMethodBeat.i(210894);
    qXG = new d.a((byte)0);
    AppMethodBeat.o(210894);
  }
  
  public static com.tencent.mm.plugin.expt.hellhound.a.b.c.b a(chl paramchl, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(210892);
    com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
    localb.sessionId = paramchl.sessionId;
    localb.dtL = paramchl.dtL;
    if (p.i(localb.dtL, "FinderTopicFeedUI"))
    {
      c.a locala = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVY;
      if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cpb() == c.c.qWe.value) {
        bool = true;
      }
    }
    for (localb.qXl = bool;; localb.qXl = false)
    {
      localb.qXg = paramchl.qXg;
      localb.qXh = paramchl.qXh;
      localb.qXi = paramchl.qXi;
      localb.qXj = paramchl.qXj;
      localb.qXk = paramchl.qXk;
      localb.dFx = paramInt;
      AppMethodBeat.o(210892);
      return localb;
    }
  }
  
  public static long aa(LinkedList<Long> paramLinkedList)
  {
    long l2 = 0L;
    AppMethodBeat.i(210893);
    if (paramLinkedList.isEmpty())
    {
      AppMethodBeat.o(210893);
      return 0L;
    }
    if (paramLinkedList.size() % 2 != 0) {
      paramLinkedList.removeLast();
    }
    Object localObject = h.a((d.k.b)h.lo(0, paramLinkedList.size()), 2);
    int i = ((d.k.b)localObject).MMh;
    int j = ((d.k.b)localObject).MMi;
    int k = ((d.k.b)localObject).kuN;
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
          p.g(localObject, "timePairLsit[i]");
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
    AppMethodBeat.o(210893);
    return l1;
  }
  
  public static void p(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210888);
    ad.i("HABBYGE-MALI.FinderShareStatistics", "onActivityCreateV1, sPage=" + paramString + ", hashCode=" + paramInt);
    if (f.qXM.da(paramString, paramInt) == null)
    {
      chl localchl = new chl();
      localchl.sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cpK().cnc();
      localchl.dtL = paramString;
      localchl.aHQ = paramInt;
      localchl.qXh = paramLong;
      b.a locala = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.qYW;
      localchl.qXk = b.a.cpG();
      localchl.dFx = c.b.qWb.value;
      f.qXM.a(localchl);
      ad.i("HABBYGE-MALI.FinderShareStatistics", "onActivityCreateV1, YES, sPage=" + paramString + ", hashCode=" + paramInt);
    }
    AppMethodBeat.o(210888);
  }
  
  public static void q(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210889);
    ad.i("HABBYGE-MALI.FinderShareStatistics", "on7EventV1: pageName=" + paramString + ", hashCode=" + paramInt);
    paramString = f.qXM.cpf();
    if (paramString == null)
    {
      AppMethodBeat.o(210889);
      return;
    }
    LinkedList localLinkedList = paramString.HaX;
    p.g(localLinkedList, "statistics.stayTimeOnBackground");
    if (!((Collection)localLinkedList).isEmpty())
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        if (paramString.HaX.size() % 2 == 0) {
          break label131;
        }
        paramString.HaX.add(Long.valueOf(paramLong));
      }
    }
    for (;;)
    {
      f.qXM.b(paramString);
      AppMethodBeat.o(210889);
      return;
      paramInt = 0;
      break;
      label131:
      paramString.HaX.removeLast();
      paramString.HaX.add(Long.valueOf(paramLong));
    }
  }
  
  public static void r(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210890);
    ad.i("HABBYGE-MALI.FinderShareStatistics", "on8EventV1: pageName=" + paramString + ", hashCode=" + paramInt);
    paramString = f.qXM.cpf();
    if (paramString == null)
    {
      AppMethodBeat.o(210890);
      return;
    }
    if (paramString.HaX.isEmpty()) {
      paramString.HaX.add(Long.valueOf(paramLong));
    }
    for (;;)
    {
      f.qXM.b(paramString);
      AppMethodBeat.o(210890);
      return;
      if (paramString.HaX.size() % 2 == 0)
      {
        paramString.HaX.add(Long.valueOf(paramLong));
      }
      else
      {
        paramString.HaX.removeLast();
        paramString.HaX.add(Long.valueOf(paramLong));
      }
    }
  }
  
  public static void s(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210891);
    ad.i("HABBYGE-MALI.FinderShareStatistics", "on7EventV2: pageName=" + paramString + ", hashCode=" + paramInt);
    paramString = f.qXM.cph();
    if (paramString == null)
    {
      AppMethodBeat.o(210891);
      return;
    }
    if (paramString.dFx == 8)
    {
      paramString.qXh = paramLong;
      paramString.qXi = 0L;
      paramString.qXg = 0L;
      paramString.dFx = c.b.qWa.value;
      f.qXM.d(paramString);
      ad.i("HABBYGE-MALI.FinderShareStatistics", "on7EventV2: " + paramString.dtL + ", " + paramString.aHQ);
    }
    AppMethodBeat.o(210891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.d
 * JD-Core Version:    0.7.0.1
 */