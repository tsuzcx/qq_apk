package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.d;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.protocal.protobuf.dhy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderShareStatistics;", "", "()V", "mCurPageNameStaticsing", "", "mCurPageNameStaticsingOnCreate", "mStayTime", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "getBackgroundTime", "", "timePairLsit", "Ljava/util/LinkedList;", "on7Event", "", "pageName", "hashCode", "", "timestamp", "on7EventV1", "on7EventV2", "on8Event", "on8EventV1", "on8EventV2", "onActivityCreate", "activity", "Landroid/app/Activity;", "onActivityCreateV1", "sPageName", "extraInfo", "onActivityCreateV2", "onFinishActivity", "onFinishActivityV1", "enterSourceInfo", "onFinishActivityV2", "onPagePaused", "onPageResumed", "toStayTimeStatistics", "statistics", "Lcom/tencent/mm/protocal/protobuf/PageStatistics;", "reportType", "Companion", "plugin-expt_release"})
public final class d
{
  public static final d.a wmX;
  public com.tencent.mm.plugin.expt.hellhound.a.b.c.b wmU;
  public String wmV;
  public String wmW;
  
  static
  {
    AppMethodBeat.i(253148);
    wmX = new d.a((byte)0);
    AppMethodBeat.o(253148);
  }
  
  public static long Z(LinkedList<Long> paramLinkedList)
  {
    long l2 = 0L;
    AppMethodBeat.i(253147);
    if (paramLinkedList.isEmpty())
    {
      AppMethodBeat.o(253147);
      return 0L;
    }
    if (paramLinkedList.size() % 2 != 0) {
      paramLinkedList.removeLast();
    }
    Object localObject = i.a((kotlin.k.c)i.ou(0, paramLinkedList.size()), 2);
    int i = ((kotlin.k.c)localObject).dHa;
    int j = ((kotlin.k.c)localObject).aaBQ;
    int k = ((kotlin.k.c)localObject).oxQ;
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
          p.j(localObject, "timePairLsit[i]");
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
    AppMethodBeat.o(253147);
    return l1;
  }
  
  public static com.tencent.mm.plugin.expt.hellhound.a.b.c.b a(dhy paramdhy, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(253146);
    com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
    localb.sessionId = paramdhy.sessionId;
    localb.fFe = paramdhy.fFe;
    if (p.h(localb.fFe, "FinderTopicFeedUI"))
    {
      c.a locala = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddY() == c.d.wlg.value) {
        bool = true;
      }
    }
    for (localb.wmB = bool;; localb.wmB = false)
    {
      localb.wmw = paramdhy.wmw;
      localb.wmx = paramdhy.wmx;
      localb.wmy = paramdhy.wmy;
      localb.wmz = paramdhy.wmz;
      localb.wmA = paramdhy.wmA;
      localb.fSe = paramInt;
      localb.extraInfo = paramdhy.extraInfo;
      localb.wmC = paramdhy.wmC;
      AppMethodBeat.o(253146);
      return localb;
    }
  }
  
  public static void a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    AppMethodBeat.i(253137);
    Log.i("HABBYGE-MALI.FinderShareStatistics", "onActivityCreateV1, sPage=" + paramString1 + ", hashCode=" + paramInt);
    if (f.wnd.dF(paramString1, paramInt) == null)
    {
      dhy localdhy = new dhy();
      localdhy.sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.deO().dbr();
      localdhy.fFe = paramString1;
      localdhy.aNf = paramInt;
      localdhy.wmx = paramLong;
      b.a locala = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.wov;
      localdhy.wmA = b.a.deK();
      localdhy.fSe = c.b.wkY.value;
      localdhy.extraInfo = paramString2;
      f.wnd.a(localdhy);
      Log.i("HABBYGE-MALI.FinderShareStatistics", "onActivityCreateV1, YES, sPage=" + paramString1 + ", hashCode=" + paramInt);
    }
    AppMethodBeat.o(253137);
  }
  
  public static void p(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(253138);
    Log.i("HABBYGE-MALI.FinderShareStatistics", "on7EventV1: pageName=" + paramString + ", hashCode=" + paramInt);
    paramString = f.wnd.dei();
    if (paramString == null)
    {
      AppMethodBeat.o(253138);
      return;
    }
    LinkedList localLinkedList = paramString.TPe;
    p.j(localLinkedList, "statistics.stayTimeOnBackground");
    if (!((Collection)localLinkedList).isEmpty())
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        if (paramString.TPe.size() % 2 == 0) {
          break label131;
        }
        paramString.TPe.add(Long.valueOf(paramLong));
      }
    }
    for (;;)
    {
      f.wnd.b(paramString);
      AppMethodBeat.o(253138);
      return;
      paramInt = 0;
      break;
      label131:
      paramString.TPe.removeLast();
      paramString.TPe.add(Long.valueOf(paramLong));
    }
  }
  
  public static void q(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(253140);
    Log.i("HABBYGE-MALI.FinderShareStatistics", "on8EventV1: pageName=" + paramString + ", hashCode=" + paramInt);
    paramString = f.wnd.dei();
    if (paramString == null)
    {
      AppMethodBeat.o(253140);
      return;
    }
    if (paramString.TPe.isEmpty()) {
      paramString.TPe.add(Long.valueOf(paramLong));
    }
    for (;;)
    {
      f.wnd.b(paramString);
      AppMethodBeat.o(253140);
      return;
      if (paramString.TPe.size() % 2 == 0)
      {
        paramString.TPe.add(Long.valueOf(paramLong));
      }
      else
      {
        paramString.TPe.removeLast();
        paramString.TPe.add(Long.valueOf(paramLong));
      }
    }
  }
  
  public static void r(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(253143);
    Log.i("HABBYGE-MALI.FinderShareStatistics", "on7EventV2: pageName=" + paramString + ", hashCode=" + paramInt);
    dhy localdhy = f.wnd.dek();
    if (localdhy == null)
    {
      AppMethodBeat.o(253143);
      return;
    }
    if (com.tencent.mm.plugin.expt.hellhound.core.b.awy(paramString))
    {
      f.wnd.del();
      AppMethodBeat.o(253143);
      return;
    }
    if (localdhy.fSe == 8)
    {
      localdhy.wmx = paramLong;
      localdhy.wmy = 0L;
      localdhy.wmw = 0L;
      localdhy.fSe = c.b.wkX.value;
      f.wnd.d(localdhy);
      Log.i("HABBYGE-MALI.FinderShareStatistics", "on7EventV2: " + localdhy.fFe + ", " + localdhy.aNf);
    }
    AppMethodBeat.o(253143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.d
 * JD-Core Version:    0.7.0.1
 */