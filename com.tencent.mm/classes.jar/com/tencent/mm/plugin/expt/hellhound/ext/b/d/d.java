package com.tencent.mm.plugin.expt.hellhound.ext.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.b;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.d;
import com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.a;
import com.tencent.mm.protocal.protobuf.eai;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.e;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderShareStatistics;", "", "()V", "mCurPageNameStaticsing", "", "mCurPageNameStaticsingOnCreate", "mStayTime", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "getBackgroundTime", "", "timePairLsit", "Ljava/util/LinkedList;", "on7Event", "", "pageName", "hashCode", "", "timestamp", "on7EventV1", "on7EventV2", "on8Event", "on8EventV1", "on8EventV2", "onActivityCreate", "activity", "Landroid/app/Activity;", "onActivityCreateV1", "sPageName", "extraInfo", "onActivityCreateV2", "onFinishActivity", "onFinishActivityV1", "enterSourceInfo", "onFinishActivityV2", "onPagePaused", "onPageResumed", "toStayTimeStatistics", "statistics", "Lcom/tencent/mm/protocal/protobuf/PageStatistics;", "reportType", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static String extraInfo;
  public static final d.a zIX;
  public com.tencent.mm.plugin.expt.hellhound.ext.b.c.b zIY;
  public String zIZ;
  public String zJa;
  
  static
  {
    AppMethodBeat.i(300424);
    zIX = new d.a((byte)0);
    extraInfo = "";
    AppMethodBeat.o(300424);
  }
  
  public static com.tencent.mm.plugin.expt.hellhound.ext.b.c.b a(eai parameai, int paramInt)
  {
    AppMethodBeat.i(300373);
    com.tencent.mm.plugin.expt.hellhound.ext.b.c.b localb = new com.tencent.mm.plugin.expt.hellhound.ext.b.c.b(null, null, 0L, 0L, 0L, null, null, 0, null, null, 4095);
    localb.sessionId = parameai.sessionId;
    localb.hJW = parameai.hJW;
    boolean bool;
    if (s.p(localb.hJW, "FinderTopicFeedUI"))
    {
      c.a locala = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
      if (com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKI() == c.d.zHl.value) {
        bool = true;
      }
    }
    for (localb.zID = bool;; localb.zID = false)
    {
      localb.zIy = parameai.zIy;
      localb.zIz = parameai.zIz;
      localb.zIA = parameai.zIA;
      localb.zIB = parameai.zIB;
      localb.zIC = parameai.zIC;
      localb.hYb = paramInt;
      localb.extraInfo = parameai.extraInfo;
      localb.zIE = parameai.zIE;
      AppMethodBeat.o(300373);
      return localb;
      bool = false;
      break;
    }
  }
  
  public static void a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    AppMethodBeat.i(300325);
    Log.i("HABBYGE-MALI.FinderShareStatistics", "onActivityCreateV1, sPage=" + paramString1 + ", hashCode=" + paramInt);
    if (f.zJg.ei(paramString1, paramInt) == null)
    {
      eai localeai = new eai();
      localeai.sessionId = com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD().dHN();
      localeai.hJW = paramString1;
      localeai.cHb = paramInt;
      localeai.zIz = paramLong;
      b.a locala = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.zKz;
      localeai.zIC = b.a.dLz();
      localeai.hYb = c.b.zHd.value;
      localeai.extraInfo = paramString2;
      f.zJg.a(localeai);
      Log.i("HABBYGE-MALI.FinderShareStatistics", "onActivityCreateV1, YES, sPage=" + paramString1 + ", hashCode=" + paramInt);
    }
    AppMethodBeat.o(300325);
  }
  
  public static long ad(LinkedList<Long> paramLinkedList)
  {
    long l2 = 0L;
    AppMethodBeat.i(300391);
    if (paramLinkedList.isEmpty())
    {
      AppMethodBeat.o(300391);
      return 0L;
    }
    if (paramLinkedList.size() % 2 != 0) {
      paramLinkedList.removeLast();
    }
    Object localObject = k.a((e)k.qt(0, paramLinkedList.size()), 2);
    int i = ((e)localObject).fIj;
    int j = ((e)localObject).aixs;
    int k = ((e)localObject).rBp;
    long l1;
    if ((k <= 0) || (i > j))
    {
      l1 = l2;
      if (k < 0)
      {
        l1 = l2;
        if (j > i) {}
      }
    }
    else
    {
      l1 = 0L;
    }
    for (;;)
    {
      l2 = ((Number)paramLinkedList.get(i + 1)).longValue();
      localObject = paramLinkedList.get(i);
      s.s(localObject, "timePairLsit[i]");
      l1 += l2 - ((Number)localObject).longValue();
      if (i == j)
      {
        AppMethodBeat.o(300391);
        return l1;
      }
      i += k;
    }
  }
  
  public static void p(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(300336);
    Log.i("HABBYGE-MALI.FinderShareStatistics", "on7EventV1: pageName=" + paramString + ", hashCode=" + paramInt);
    paramString = f.zJg.dKX();
    if (paramString == null)
    {
      AppMethodBeat.o(300336);
      return;
    }
    LinkedList localLinkedList = paramString.abfA;
    s.s(localLinkedList, "statistics.stayTimeOnBackground");
    if (!((Collection)localLinkedList).isEmpty())
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        if (paramString.abfA.size() % 2 == 0) {
          break label131;
        }
        paramString.abfA.add(Long.valueOf(paramLong));
      }
    }
    for (;;)
    {
      f.zJg.b(paramString);
      AppMethodBeat.o(300336);
      return;
      paramInt = 0;
      break;
      label131:
      paramString.abfA.removeLast();
      paramString.abfA.add(Long.valueOf(paramLong));
    }
  }
  
  public static void q(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(300348);
    Log.i("HABBYGE-MALI.FinderShareStatistics", "on8EventV1: pageName=" + paramString + ", hashCode=" + paramInt);
    paramString = f.zJg.dKX();
    if (paramString == null)
    {
      AppMethodBeat.o(300348);
      return;
    }
    if (paramString.abfA.isEmpty()) {
      paramString.abfA.add(Long.valueOf(paramLong));
    }
    for (;;)
    {
      f.zJg.b(paramString);
      AppMethodBeat.o(300348);
      return;
      if (paramString.abfA.size() % 2 == 0)
      {
        paramString.abfA.add(Long.valueOf(paramLong));
      }
      else
      {
        paramString.abfA.removeLast();
        paramString.abfA.add(Long.valueOf(paramLong));
      }
    }
  }
  
  public static void r(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(300358);
    Log.i("HABBYGE-MALI.FinderShareStatistics", "on7EventV2: pageName=" + paramString + ", hashCode=" + paramInt);
    eai localeai = f.zJg.dKZ();
    if (localeai == null)
    {
      AppMethodBeat.o(300358);
      return;
    }
    if (com.tencent.mm.plugin.expt.hellhound.core.b.aqC(paramString))
    {
      f.zJg.dLa();
      AppMethodBeat.o(300358);
      return;
    }
    if (localeai.hYb == 8)
    {
      localeai.zIz = paramLong;
      localeai.zIA = 0L;
      localeai.zIy = 0L;
      localeai.hYb = c.b.zHc.value;
      f.zJg.d(localeai);
      Log.i("HABBYGE-MALI.FinderShareStatistics", "on7EventV2: " + localeai.hJW + ", " + localeai.cHb);
    }
    AppMethodBeat.o(300358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.d.d
 * JD-Core Version:    0.7.0.1
 */