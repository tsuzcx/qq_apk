package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.bx;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/RecordFinderChatList;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "chatExposeMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "chatListRecord", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$ChatListRecord;", "getChatListRecord", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$ChatListRecord;", "clickChatExposeMap", "clickChatExposeSet", "", "currentChatExposeSet", "delClickCountL", "", "dotClickCountL", "isOnProcess", "", "()Z", "setOnProcess", "(Z)V", "copySet", "", "src", "", "dst", "getExposePv", "type", "getExposeUV", "getMapContainer", "getSessionId", "getSetContainer", "incChatExpose", "key", "incDelClickCount", "incDotClickCount", "onEnterChatList", "accountType", "isGreetSession", "onExitChatList", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "recordChatClickExpose", "curRecordSet", "recordChatExpose", "exposeSet", "report20688", "resetChatListRecord", "structLog", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "plugin-finder_release"})
public final class al
{
  private final String TAG;
  public boolean zZF;
  public final d.a zZG;
  private final Set<String> zZH;
  private final HashMap<String, Integer> zZI;
  private final Set<String> zZJ;
  private final HashMap<String, Integer> zZK;
  public long zZL;
  private long zZM;
  
  public al()
  {
    AppMethodBeat.i(266582);
    this.TAG = "RecordFinderChatList";
    this.zZG = new d.a();
    this.zZH = ((Set)new HashSet());
    this.zZI = new HashMap();
    this.zZJ = ((Set)new HashSet());
    this.zZK = new HashMap();
    AppMethodBeat.o(266582);
  }
  
  private final HashMap<String, Integer> PP(int paramInt)
  {
    if (paramInt == 1) {
      return this.zZI;
    }
    return this.zZK;
  }
  
  private final long PQ(int paramInt)
  {
    AppMethodBeat.i(266575);
    long l = 0L;
    Object localObject = PP(paramInt).values();
    p.j(localObject, "getMapContainer(type).values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      p.j(localInteger, "it");
      l = localInteger.intValue() + l;
    }
    AppMethodBeat.o(266575);
    return l;
  }
  
  private final long PR(int paramInt)
  {
    AppMethodBeat.i(266577);
    long l = PP(paramInt).size();
    AppMethodBeat.o(266577);
    return l;
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(266580);
    Object localObject = d.zUg;
    localObject = d.getTAG();
    StringBuilder localStringBuilder = new StringBuilder("report").append(parama.getId()).append(' ');
    parama = parama.agI();
    p.j(parama, "struct.toShowString()");
    Log.i((String)localObject, n.l(parama, "\r\n", " ", false));
    AppMethodBeat.o(266580);
  }
  
  private final void b(Set<String> paramSet1, Set<String> paramSet2)
  {
    AppMethodBeat.i(266572);
    if (!this.zZF)
    {
      AppMethodBeat.o(266572);
      return;
    }
    paramSet1 = ak.a(paramSet2, (Iterable)paramSet1);
    Log.i(this.TAG, "latestExposeRecords" + paramSet1 + "，size:" + paramSet1.size());
    if (!((Collection)paramSet1).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramSet1 = ((Iterable)paramSet1).iterator();
      while (paramSet1.hasNext()) {
        dW((String)paramSet1.next(), 1);
      }
    }
    c(paramSet2, this.zZH);
    Log.i(this.TAG, "pvCount:" + PQ(1) + ": uvCount:" + PR(1));
    AppMethodBeat.o(266572);
  }
  
  private static void c(Set<String> paramSet1, Set<String> paramSet2)
  {
    AppMethodBeat.i(266573);
    paramSet2.clear();
    paramSet1 = ((Iterable)paramSet1).iterator();
    while (paramSet1.hasNext()) {
      paramSet2.add((String)paramSet1.next());
    }
    AppMethodBeat.o(266573);
  }
  
  private final void dQA()
  {
    AppMethodBeat.i(266581);
    d.a locala = this.zZG;
    locala.zUh = 0L;
    locala.aDU("");
    locala.wzm = 0L;
    locala.zUj = 0L;
    this.zZF = false;
    this.zZL = 0L;
    this.zZM = 0L;
    this.zZH.clear();
    this.zZJ.clear();
    this.zZI.clear();
    this.zZK.clear();
    AppMethodBeat.o(266581);
  }
  
  private final void dW(String paramString, int paramInt)
  {
    AppMethodBeat.i(266578);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(266578);
      return;
    }
    HashMap localHashMap = PP(paramInt);
    if (((Map)localHashMap).containsKey(paramString))
    {
      Integer localInteger = (Integer)localHashMap.get(paramString);
      if (localInteger != null)
      {
        localHashMap.put(paramString, Integer.valueOf(localInteger.intValue() + 1));
        AppMethodBeat.o(266578);
        return;
      }
      AppMethodBeat.o(266578);
      return;
    }
    localHashMap.put(paramString, Integer.valueOf(1));
    AppMethodBeat.o(266578);
  }
  
  private final void i(bid parambid)
  {
    AppMethodBeat.i(266579);
    bx localbx = new bx();
    localbx.em(this.zZG.zUh);
    localbx.en(this.zZG.zUj);
    localbx.lq(this.zZG.zUi);
    localbx.ep(PR(1));
    localbx.eq(PQ(1));
    localbx.er(PQ(2));
    localbx.es(PR(2));
    localbx.et(this.zZL);
    localbx.ev(this.zZM);
    localbx.eu(System.currentTimeMillis() - this.zZG.wzm);
    if (parambid != null) {
      localbx.eo(parambid.fGo);
    }
    localbx.bpa();
    a((a)localbx);
    AppMethodBeat.o(266579);
  }
  
  public final void W(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(266567);
    dQA();
    d.a locala = this.zZG;
    locala.zUh = paramLong1;
    locala.zUj = paramLong2;
    locala.wzm = cm.bfE();
    locala.aDU(String.valueOf(locala.wzm));
    this.zZF = true;
    AppMethodBeat.o(266567);
  }
  
  public final void aDT(String paramString)
  {
    AppMethodBeat.i(266571);
    p.k(paramString, "key");
    if (!this.zZF)
    {
      AppMethodBeat.o(266571);
      return;
    }
    dW(paramString, 2);
    AppMethodBeat.o(266571);
  }
  
  public final void h(bid parambid)
  {
    AppMethodBeat.i(266569);
    i(parambid);
    this.zZF = false;
    AppMethodBeat.o(266569);
  }
  
  public final void n(Set<String> paramSet)
  {
    AppMethodBeat.i(266570);
    p.k(paramSet, "curRecordSet");
    b(this.zZH, paramSet);
    AppMethodBeat.o(266570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.al
 * JD-Core Version:    0.7.0.1
 */