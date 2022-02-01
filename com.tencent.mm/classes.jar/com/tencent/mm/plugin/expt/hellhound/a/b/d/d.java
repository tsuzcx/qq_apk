package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.d;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderShareStatistics;", "", "()V", "mCurPageNameStaticsing", "", "mCurPageNameStaticsingOnCreate", "mStayTime", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "getBackgroundTime", "", "timePairLsit", "Ljava/util/LinkedList;", "on7Event", "", "pageName", "hashCode", "", "timestamp", "on7EventV1", "on7EventV2", "on8Event", "on8EventV1", "on8EventV2", "onActivityCreate", "activity", "Landroid/app/Activity;", "onActivityCreateV1", "sPageName", "extraInfo", "onActivityCreateV2", "onFinishActivity", "onFinishActivityV1", "enterSourceInfo", "onFinishActivityV2", "onPagePaused", "onPageResumed", "toStayTimeStatistics", "statistics", "Lcom/tencent/mm/protocal/protobuf/PageStatistics;", "reportType", "Companion", "plugin-expt_release"})
public final class d
{
  public static final d.a sHc;
  public com.tencent.mm.plugin.expt.hellhound.a.b.c.b sGZ;
  public String sHa;
  public String sHb;
  
  static
  {
    AppMethodBeat.i(221057);
    sHc = new d.a((byte)0);
    AppMethodBeat.o(221057);
  }
  
  public static com.tencent.mm.plugin.expt.hellhound.a.b.c.b a(cym paramcym, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(221055);
    com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
    localb.sessionId = paramcym.sessionId;
    localb.dMl = paramcym.dMl;
    if (p.j(localb.dMl, "FinderTopicFeedUI"))
    {
      c.a locala = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cPf() == c.d.sFl.value) {
        bool = true;
      }
    }
    for (localb.sGG = bool;; localb.sGG = false)
    {
      localb.sGB = paramcym.sGB;
      localb.sGC = paramcym.sGC;
      localb.sGD = paramcym.sGD;
      localb.sGE = paramcym.sGE;
      localb.sGF = paramcym.sGF;
      localb.dYn = paramInt;
      localb.extraInfo = paramcym.extraInfo;
      localb.sGH = paramcym.sGH;
      AppMethodBeat.o(221055);
      return localb;
    }
  }
  
  public static void a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    AppMethodBeat.i(221051);
    Log.i("HABBYGE-MALI.FinderShareStatistics", "onActivityCreateV1, sPage=" + paramString1 + ", hashCode=" + paramInt);
    if (f.sHi.dk(paramString1, paramInt) == null)
    {
      cym localcym = new cym();
      localcym.sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
      localcym.dMl = paramString1;
      localcym.aHK = paramInt;
      localcym.sGC = paramLong;
      b.a locala = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.sIy;
      localcym.sGF = b.a.cPQ();
      localcym.dYn = c.b.sFd.value;
      localcym.extraInfo = paramString2;
      f.sHi.a(localcym);
      Log.i("HABBYGE-MALI.FinderShareStatistics", "onActivityCreateV1, YES, sPage=" + paramString1 + ", hashCode=" + paramInt);
    }
    AppMethodBeat.o(221051);
  }
  
  public static long ab(LinkedList<Long> paramLinkedList)
  {
    long l2 = 0L;
    AppMethodBeat.i(221056);
    if (paramLinkedList.isEmpty())
    {
      AppMethodBeat.o(221056);
      return 0L;
    }
    if (paramLinkedList.size() % 2 != 0) {
      paramLinkedList.removeLast();
    }
    Object localObject = j.a((kotlin.k.d)j.mY(0, paramLinkedList.size()), 2);
    int i = ((kotlin.k.d)localObject).SYU;
    int j = ((kotlin.k.d)localObject).SYV;
    int k = ((kotlin.k.d)localObject).lCq;
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
    AppMethodBeat.o(221056);
    return l1;
  }
  
  public static void o(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(221052);
    Log.i("HABBYGE-MALI.FinderShareStatistics", "on7EventV1: pageName=" + paramString + ", hashCode=" + paramInt);
    paramString = f.sHi.cPo();
    if (paramString == null)
    {
      AppMethodBeat.o(221052);
      return;
    }
    LinkedList localLinkedList = paramString.MDv;
    p.g(localLinkedList, "statistics.stayTimeOnBackground");
    if (!((Collection)localLinkedList).isEmpty())
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        if (paramString.MDv.size() % 2 == 0) {
          break label131;
        }
        paramString.MDv.add(Long.valueOf(paramLong));
      }
    }
    for (;;)
    {
      f.sHi.b(paramString);
      AppMethodBeat.o(221052);
      return;
      paramInt = 0;
      break;
      label131:
      paramString.MDv.removeLast();
      paramString.MDv.add(Long.valueOf(paramLong));
    }
  }
  
  public static void p(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(221053);
    Log.i("HABBYGE-MALI.FinderShareStatistics", "on8EventV1: pageName=" + paramString + ", hashCode=" + paramInt);
    paramString = f.sHi.cPo();
    if (paramString == null)
    {
      AppMethodBeat.o(221053);
      return;
    }
    if (paramString.MDv.isEmpty()) {
      paramString.MDv.add(Long.valueOf(paramLong));
    }
    for (;;)
    {
      f.sHi.b(paramString);
      AppMethodBeat.o(221053);
      return;
      if (paramString.MDv.size() % 2 == 0)
      {
        paramString.MDv.add(Long.valueOf(paramLong));
      }
      else
      {
        paramString.MDv.removeLast();
        paramString.MDv.add(Long.valueOf(paramLong));
      }
    }
  }
  
  public static void q(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(221054);
    Log.i("HABBYGE-MALI.FinderShareStatistics", "on7EventV2: pageName=" + paramString + ", hashCode=" + paramInt);
    cym localcym = f.sHi.cPq();
    if (localcym == null)
    {
      AppMethodBeat.o(221054);
      return;
    }
    if (com.tencent.mm.plugin.expt.hellhound.core.b.aoz(paramString))
    {
      f.sHi.cPr();
      AppMethodBeat.o(221054);
      return;
    }
    if (localcym.dYn == 8)
    {
      localcym.sGC = paramLong;
      localcym.sGD = 0L;
      localcym.sGB = 0L;
      localcym.dYn = c.b.sFc.value;
      f.sHi.d(localcym);
      Log.i("HABBYGE-MALI.FinderShareStatistics", "on7EventV2: " + localcym.dMl + ", " + localcym.aHK);
    }
    AppMethodBeat.o(221054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.d
 * JD-Core Version:    0.7.0.1
 */