package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.c;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.protocal.protobuf.cif;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.k.j;
import d.l;
import java.util.Collection;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderShareStatistics;", "", "()V", "mCurPageNameStaticsing", "", "mCurPageNameStaticsingOnCreate", "mStayTime", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "getBackgroundTime", "", "timePairLsit", "Ljava/util/LinkedList;", "on7Event", "", "pageName", "hashCode", "", "timestamp", "on7EventV1", "on7EventV2", "on8Event", "on8EventV1", "on8EventV2", "onActivityCreate", "activity", "Landroid/app/Activity;", "onActivityCreateV1", "sPageName", "extraInfo", "onActivityCreateV2", "onFinishActivity", "onFinishActivityV1", "enterSourceInfo", "onFinishActivityV2", "onPagePaused", "onPageResumed", "toStayTimeStatistics", "statistics", "Lcom/tencent/mm/protocal/protobuf/PageStatistics;", "reportType", "Companion", "plugin-expt_release"})
public final class d
{
  public static final d.a rfM;
  public com.tencent.mm.plugin.expt.hellhound.a.b.c.b rfJ;
  public String rfK;
  public String rfL;
  
  static
  {
    AppMethodBeat.i(196565);
    rfM = new d.a((byte)0);
    AppMethodBeat.o(196565);
  }
  
  public static com.tencent.mm.plugin.expt.hellhound.a.b.c.b a(cif paramcif, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(196563);
    com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
    localb.sessionId = paramcif.sessionId;
    localb.duQ = paramcif.duQ;
    if (p.i(localb.duQ, "FinderTopicFeedUI"))
    {
      c.a locala = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdX;
      if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqD() == c.c.red.value) {
        bool = true;
      }
    }
    for (localb.rfq = bool;; localb.rfq = false)
    {
      localb.rfl = paramcif.rfl;
      localb.rfm = paramcif.rfm;
      localb.rfn = paramcif.rfn;
      localb.rfo = paramcif.rfo;
      localb.rfp = paramcif.rfp;
      localb.dGC = paramInt;
      localb.extraInfo = paramcif.extraInfo;
      localb.rfr = paramcif.rfr;
      AppMethodBeat.o(196563);
      return localb;
    }
  }
  
  public static void a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    AppMethodBeat.i(196559);
    ae.i("HABBYGE-MALI.FinderShareStatistics", "onActivityCreateV1, sPage=" + paramString1 + ", hashCode=" + paramInt);
    if (f.rfS.de(paramString1, paramInt) == null)
    {
      cif localcif = new cif();
      localcif.sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.crm().cos();
      localcif.duQ = paramString1;
      localcif.aHQ = paramInt;
      localcif.rfm = paramLong;
      b.a locala = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.rhc;
      localcif.rfp = b.a.cri();
      localcif.dGC = c.b.rea.value;
      localcif.extraInfo = paramString2;
      f.rfS.a(localcif);
      ae.i("HABBYGE-MALI.FinderShareStatistics", "onActivityCreateV1, YES, sPage=" + paramString1 + ", hashCode=" + paramInt);
    }
    AppMethodBeat.o(196559);
  }
  
  public static long aa(LinkedList<Long> paramLinkedList)
  {
    long l2 = 0L;
    AppMethodBeat.i(196564);
    if (paramLinkedList.isEmpty())
    {
      AppMethodBeat.o(196564);
      return 0L;
    }
    if (paramLinkedList.size() % 2 != 0) {
      paramLinkedList.removeLast();
    }
    Object localObject = j.a((d.k.d)j.lv(0, paramLinkedList.size()), 2);
    int i = ((d.k.d)localObject).Njm;
    int j = ((d.k.d)localObject).Njn;
    int k = ((d.k.d)localObject).kyd;
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
    AppMethodBeat.o(196564);
    return l1;
  }
  
  public static void p(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(196560);
    ae.i("HABBYGE-MALI.FinderShareStatistics", "on7EventV1: pageName=" + paramString + ", hashCode=" + paramInt);
    paramString = f.rfS.cqH();
    if (paramString == null)
    {
      AppMethodBeat.o(196560);
      return;
    }
    LinkedList localLinkedList = paramString.Hux;
    p.g(localLinkedList, "statistics.stayTimeOnBackground");
    if (!((Collection)localLinkedList).isEmpty())
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        if (paramString.Hux.size() % 2 == 0) {
          break label131;
        }
        paramString.Hux.add(Long.valueOf(paramLong));
      }
    }
    for (;;)
    {
      f.rfS.b(paramString);
      AppMethodBeat.o(196560);
      return;
      paramInt = 0;
      break;
      label131:
      paramString.Hux.removeLast();
      paramString.Hux.add(Long.valueOf(paramLong));
    }
  }
  
  public static void q(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(196561);
    ae.i("HABBYGE-MALI.FinderShareStatistics", "on8EventV1: pageName=" + paramString + ", hashCode=" + paramInt);
    paramString = f.rfS.cqH();
    if (paramString == null)
    {
      AppMethodBeat.o(196561);
      return;
    }
    if (paramString.Hux.isEmpty()) {
      paramString.Hux.add(Long.valueOf(paramLong));
    }
    for (;;)
    {
      f.rfS.b(paramString);
      AppMethodBeat.o(196561);
      return;
      if (paramString.Hux.size() % 2 == 0)
      {
        paramString.Hux.add(Long.valueOf(paramLong));
      }
      else
      {
        paramString.Hux.removeLast();
        paramString.Hux.add(Long.valueOf(paramLong));
      }
    }
  }
  
  public static void r(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(196562);
    ae.i("HABBYGE-MALI.FinderShareStatistics", "on7EventV2: pageName=" + paramString + ", hashCode=" + paramInt);
    cif localcif = f.rfS.cqJ();
    if (localcif == null)
    {
      AppMethodBeat.o(196562);
      return;
    }
    if (com.tencent.mm.plugin.expt.hellhound.core.b.aem(paramString))
    {
      f.rfS.cqK();
      AppMethodBeat.o(196562);
      return;
    }
    if (localcif.dGC == 8)
    {
      localcif.rfm = paramLong;
      localcif.rfn = 0L;
      localcif.rfl = 0L;
      localcif.dGC = c.b.rdZ.value;
      f.rfS.d(localcif);
      ae.i("HABBYGE-MALI.FinderShareStatistics", "on7EventV2: " + localcif.duQ + ", " + localcif.aHQ);
    }
    AppMethodBeat.o(196562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.d
 * JD-Core Version:    0.7.0.1
 */