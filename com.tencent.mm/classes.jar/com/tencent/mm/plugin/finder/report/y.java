package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ag;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.a.ak;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/RecordFinderChatList;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "chatExposeMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "chatListRecord", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$ChatListRecord;", "getChatListRecord", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$ChatListRecord;", "clickChatExposeMap", "clickChatExposeSet", "", "currentChatExposeSet", "delClickCountL", "", "dotClickCountL", "isOnProcess", "", "()Z", "setOnProcess", "(Z)V", "copySet", "", "src", "", "dst", "getExposePv", "type", "getExposeUV", "getMapContainer", "getSessionId", "getSetContainer", "incChatExpose", "key", "incDelClickCount", "incDotClickCount", "onEnterChatList", "accountType", "isGreetSession", "onExitChatList", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "recordChatClickExpose", "curRecordSet", "recordChatExpose", "exposeSet", "report20688", "resetChatListRecord", "structLog", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "plugin-finder_release"})
public final class y
{
  private final String TAG;
  public boolean sCH;
  public final b.a sCI;
  private final Set<String> sCJ;
  private final HashMap<String, Integer> sCK;
  private final Set<String> sCL;
  private final HashMap<String, Integer> sCM;
  public long sCN;
  private long sCO;
  
  public y()
  {
    AppMethodBeat.i(203961);
    this.TAG = "RecordFinderChatList";
    this.sCI = new b.a();
    this.sCJ = ((Set)new HashSet());
    this.sCK = new HashMap();
    this.sCL = ((Set)new HashSet());
    this.sCM = new HashMap();
    AppMethodBeat.o(203961);
  }
  
  private final long FA(int paramInt)
  {
    AppMethodBeat.i(203955);
    long l = 0L;
    Object localObject = Fz(paramInt).values();
    p.g(localObject, "getMapContainer(type).values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      p.g(localInteger, "it");
      l = localInteger.intValue() + l;
    }
    AppMethodBeat.o(203955);
    return l;
  }
  
  private final long FB(int paramInt)
  {
    AppMethodBeat.i(203956);
    long l = Fz(paramInt).size();
    AppMethodBeat.o(203956);
    return l;
  }
  
  private final HashMap<String, Integer> Fz(int paramInt)
  {
    if (paramInt == 1) {
      return this.sCK;
    }
    return this.sCM;
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(203959);
    Object localObject = b.sxb;
    localObject = b.getTAG();
    StringBuilder localStringBuilder = new StringBuilder("report").append(parama.getId()).append(' ');
    parama = parama.RD();
    p.g(parama, "struct.toShowString()");
    ae.i((String)localObject, n.h(parama, "\r\n", " ", false));
    AppMethodBeat.o(203959);
  }
  
  private final void a(Set<String> paramSet1, Set<String> paramSet2)
  {
    AppMethodBeat.i(203953);
    if (!this.sCH)
    {
      AppMethodBeat.o(203953);
      return;
    }
    paramSet1 = ak.a(paramSet2, (Iterable)paramSet1);
    ae.i(this.TAG, "latestExposeRecords" + paramSet1 + "，size:" + paramSet1.size());
    if (!((Collection)paramSet1).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramSet1 = ((Iterable)paramSet1).iterator();
      while (paramSet1.hasNext()) {
        ds((String)paramSet1.next(), 1);
      }
    }
    b(paramSet2, this.sCJ);
    ae.i(this.TAG, "pvCount:" + FA(1) + ": uvCount:" + FB(1));
    AppMethodBeat.o(203953);
  }
  
  private static void b(Set<String> paramSet1, Set<String> paramSet2)
  {
    AppMethodBeat.i(203954);
    paramSet2.clear();
    paramSet1 = ((Iterable)paramSet1).iterator();
    while (paramSet1.hasNext()) {
      paramSet2.add((String)paramSet1.next());
    }
    AppMethodBeat.o(203954);
  }
  
  private final void cGy()
  {
    AppMethodBeat.i(203960);
    b.a locala = this.sCI;
    locala.sxc = 0L;
    locala.aiI("");
    locala.sxe = 0L;
    locala.sxf = 0L;
    this.sCH = false;
    this.sCN = 0L;
    this.sCO = 0L;
    this.sCJ.clear();
    this.sCL.clear();
    this.sCK.clear();
    this.sCM.clear();
    AppMethodBeat.o(203960);
  }
  
  private final void ds(String paramString, int paramInt)
  {
    AppMethodBeat.i(203957);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(203957);
      return;
    }
    HashMap localHashMap = Fz(paramInt);
    if (((Map)localHashMap).containsKey(paramString))
    {
      Integer localInteger = (Integer)localHashMap.get(paramString);
      if (localInteger != null)
      {
        localHashMap.put(paramString, Integer.valueOf(localInteger.intValue() + 1));
        AppMethodBeat.o(203957);
        return;
      }
      AppMethodBeat.o(203957);
      return;
    }
    localHashMap.put(paramString, Integer.valueOf(1));
    AppMethodBeat.o(203957);
  }
  
  private final void f(arn paramarn)
  {
    AppMethodBeat.i(203958);
    ag localag = new ag();
    localag.cw(this.sCI.sxc);
    localag.cx(this.sCI.sxf);
    localag.hl(this.sCI.sxd);
    localag.cz(FB(1));
    localag.cA(FA(1));
    localag.cB(FA(2));
    localag.cC(FB(2));
    localag.cD(this.sCN);
    localag.cF(this.sCO);
    localag.cE(System.currentTimeMillis() - this.sCI.sxe);
    if (paramarn != null) {
      localag.cy(paramarn.tnf);
    }
    localag.aLH();
    a((a)localag);
    AppMethodBeat.o(203958);
  }
  
  public final void M(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(203949);
    cGy();
    b.a locala = this.sCI;
    locala.sxc = paramLong1;
    locala.sxf = paramLong2;
    locala.sxe = ch.aDc();
    locala.aiI(String.valueOf(locala.sxe));
    this.sCH = true;
    AppMethodBeat.o(203949);
  }
  
  public final void aiH(String paramString)
  {
    AppMethodBeat.i(203952);
    p.h(paramString, "key");
    if (!this.sCH)
    {
      AppMethodBeat.o(203952);
      return;
    }
    ds(paramString, 2);
    AppMethodBeat.o(203952);
  }
  
  public final void e(arn paramarn)
  {
    AppMethodBeat.i(203950);
    f(paramarn);
    this.sCH = false;
    AppMethodBeat.o(203950);
  }
  
  public final void l(Set<String> paramSet)
  {
    AppMethodBeat.i(203951);
    p.h(paramSet, "curRecordSet");
    a(this.sCJ, paramSet);
    AppMethodBeat.o(203951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.y
 * JD-Core Version:    0.7.0.1
 */