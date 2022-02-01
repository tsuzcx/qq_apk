package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bh;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.bbn;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/RecordFinderChatList;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "chatExposeMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "chatListRecord", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$ChatListRecord;", "getChatListRecord", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$ChatListRecord;", "clickChatExposeMap", "clickChatExposeSet", "", "currentChatExposeSet", "delClickCountL", "", "dotClickCountL", "isOnProcess", "", "()Z", "setOnProcess", "(Z)V", "copySet", "", "src", "", "dst", "getExposePv", "type", "getExposeUV", "getMapContainer", "getSessionId", "getSetContainer", "incChatExpose", "key", "incDelClickCount", "incDotClickCount", "onEnterChatList", "accountType", "isGreetSession", "onExitChatList", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "recordChatClickExpose", "curRecordSet", "recordChatExpose", "exposeSet", "report20688", "resetChatListRecord", "structLog", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "plugin-finder_release"})
public final class ai
{
  private final String TAG;
  public boolean viM;
  public final d.a viN;
  private final Set<String> viO;
  private final HashMap<String, Integer> viP;
  private final Set<String> viQ;
  private final HashMap<String, Integer> viR;
  public long viS;
  private long viT;
  
  public ai()
  {
    AppMethodBeat.i(250880);
    this.TAG = "RecordFinderChatList";
    this.viN = new d.a();
    this.viO = ((Set)new HashSet());
    this.viP = new HashMap();
    this.viQ = ((Set)new HashSet());
    this.viR = new HashMap();
    AppMethodBeat.o(250880);
  }
  
  private final HashMap<String, Integer> KD(int paramInt)
  {
    if (paramInt == 1) {
      return this.viP;
    }
    return this.viR;
  }
  
  private final long KE(int paramInt)
  {
    AppMethodBeat.i(250874);
    long l = 0L;
    Object localObject = KD(paramInt).values();
    p.g(localObject, "getMapContainer(type).values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      p.g(localInteger, "it");
      l = localInteger.intValue() + l;
    }
    AppMethodBeat.o(250874);
    return l;
  }
  
  private final long KF(int paramInt)
  {
    AppMethodBeat.i(250875);
    long l = KD(paramInt).size();
    AppMethodBeat.o(250875);
    return l;
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(250878);
    Object localObject = d.vdp;
    localObject = d.getTAG();
    StringBuilder localStringBuilder = new StringBuilder("report").append(parama.getId()).append(' ');
    parama = parama.abW();
    p.g(parama, "struct.toShowString()");
    Log.i((String)localObject, n.j(parama, "\r\n", " ", false));
    AppMethodBeat.o(250878);
  }
  
  private final void b(Set<String> paramSet1, Set<String> paramSet2)
  {
    AppMethodBeat.i(250872);
    if (!this.viM)
    {
      AppMethodBeat.o(250872);
      return;
    }
    paramSet1 = ak.a(paramSet2, (Iterable)paramSet1);
    Log.i(this.TAG, "latestExposeRecords" + paramSet1 + "，size:" + paramSet1.size());
    if (!((Collection)paramSet1).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramSet1 = ((Iterable)paramSet1).iterator();
      while (paramSet1.hasNext()) {
        dC((String)paramSet1.next(), 1);
      }
    }
    c(paramSet2, this.viO);
    Log.i(this.TAG, "pvCount:" + KE(1) + ": uvCount:" + KF(1));
    AppMethodBeat.o(250872);
  }
  
  private static void c(Set<String> paramSet1, Set<String> paramSet2)
  {
    AppMethodBeat.i(250873);
    paramSet2.clear();
    paramSet1 = ((Iterable)paramSet1).iterator();
    while (paramSet1.hasNext()) {
      paramSet2.add((String)paramSet1.next());
    }
    AppMethodBeat.o(250873);
  }
  
  private final void dC(String paramString, int paramInt)
  {
    AppMethodBeat.i(250876);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(250876);
      return;
    }
    HashMap localHashMap = KD(paramInt);
    if (((Map)localHashMap).containsKey(paramString))
    {
      Integer localInteger = (Integer)localHashMap.get(paramString);
      if (localInteger != null)
      {
        localHashMap.put(paramString, Integer.valueOf(localInteger.intValue() + 1));
        AppMethodBeat.o(250876);
        return;
      }
      AppMethodBeat.o(250876);
      return;
    }
    localHashMap.put(paramString, Integer.valueOf(1));
    AppMethodBeat.o(250876);
  }
  
  private final void doX()
  {
    AppMethodBeat.i(250879);
    d.a locala = this.viN;
    locala.vdq = 0L;
    locala.auC("");
    locala.sTp = 0L;
    locala.vds = 0L;
    this.viM = false;
    this.viS = 0L;
    this.viT = 0L;
    this.viO.clear();
    this.viQ.clear();
    this.viP.clear();
    this.viR.clear();
    AppMethodBeat.o(250879);
  }
  
  private final void g(bbn parambbn)
  {
    AppMethodBeat.i(250877);
    bh localbh = new bh();
    localbh.dy(this.viN.vdq);
    localbh.dz(this.viN.vds);
    localbh.jg(this.viN.vdr);
    localbh.dB(KF(1));
    localbh.dC(KE(1));
    localbh.dD(KE(2));
    localbh.dE(KF(2));
    localbh.dF(this.viS);
    localbh.dH(this.viT);
    localbh.dG(System.currentTimeMillis() - this.viN.sTp);
    if (parambbn != null) {
      localbh.dA(parambbn.tyh);
    }
    localbh.bfK();
    a((a)localbh);
    AppMethodBeat.o(250877);
  }
  
  public final void R(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(250868);
    doX();
    d.a locala = this.viN;
    locala.vdq = paramLong1;
    locala.vds = paramLong2;
    locala.sTp = cl.aWA();
    locala.auC(String.valueOf(locala.sTp));
    this.viM = true;
    AppMethodBeat.o(250868);
  }
  
  public final void auB(String paramString)
  {
    AppMethodBeat.i(250871);
    p.h(paramString, "key");
    if (!this.viM)
    {
      AppMethodBeat.o(250871);
      return;
    }
    dC(paramString, 2);
    AppMethodBeat.o(250871);
  }
  
  public final void f(bbn parambbn)
  {
    AppMethodBeat.i(250869);
    g(parambbn);
    this.viM = false;
    AppMethodBeat.o(250869);
  }
  
  public final void n(Set<String> paramSet)
  {
    AppMethodBeat.i(250870);
    p.h(paramSet, "curRecordSet");
    b(this.viO, paramSet);
    AppMethodBeat.o(250870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ai
 * JD-Core Version:    0.7.0.1
 */