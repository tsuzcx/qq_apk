package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ag;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/RecordFinderChatList;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "chatExposeMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "chatListRecord", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$ChatListRecord;", "getChatListRecord", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$ChatListRecord;", "clickChatExposeMap", "clickChatExposeSet", "", "currentChatExposeSet", "delClickCountL", "", "dotClickCountL", "isOnProcess", "", "()Z", "setOnProcess", "(Z)V", "copySet", "", "src", "", "dst", "getExposePv", "type", "getExposeUV", "getMapContainer", "getSessionId", "getSetContainer", "incChatExpose", "key", "incDelClickCount", "incDotClickCount", "onEnterChatList", "accountType", "isGreetSession", "onExitChatList", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "recordChatClickExpose", "curRecordSet", "recordChatExpose", "exposeSet", "report20688", "resetChatListRecord", "structLog", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "plugin-finder_release"})
public final class x
{
  private final String TAG;
  private final HashMap<String, Integer> ssA;
  private final Set<String> ssB;
  private final HashMap<String, Integer> ssC;
  public long ssD;
  private long ssE;
  public boolean ssx;
  public final b.a ssy;
  private final Set<String> ssz;
  
  public x()
  {
    AppMethodBeat.i(203402);
    this.TAG = "RecordFinderChatList";
    this.ssy = new b.a();
    this.ssz = ((Set)new HashSet());
    this.ssA = new HashMap();
    this.ssB = ((Set)new HashSet());
    this.ssC = new HashMap();
    AppMethodBeat.o(203402);
  }
  
  private final HashMap<String, Integer> Fd(int paramInt)
  {
    if (paramInt == 1) {
      return this.ssA;
    }
    return this.ssC;
  }
  
  private final long Fe(int paramInt)
  {
    AppMethodBeat.i(203396);
    long l = 0L;
    Object localObject = Fd(paramInt).values();
    p.g(localObject, "getMapContainer(type).values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      p.g(localInteger, "it");
      l = localInteger.intValue() + l;
    }
    AppMethodBeat.o(203396);
    return l;
  }
  
  private final long Ff(int paramInt)
  {
    AppMethodBeat.i(203397);
    long l = Fd(paramInt).size();
    AppMethodBeat.o(203397);
    return l;
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(203400);
    Object localObject = b.snk;
    localObject = b.getTAG();
    StringBuilder localStringBuilder = new StringBuilder("report").append(parama.getId()).append(' ');
    parama = parama.RE();
    p.g(parama, "struct.toShowString()");
    ad.i((String)localObject, n.h(parama, "\r\n", " ", false));
    AppMethodBeat.o(203400);
  }
  
  private final void a(Set<String> paramSet1, Set<String> paramSet2)
  {
    AppMethodBeat.i(203394);
    if (!this.ssx)
    {
      AppMethodBeat.o(203394);
      return;
    }
    paramSet1 = ak.a(paramSet2, (Iterable)paramSet1);
    ad.i(this.TAG, "latestExposeRecords" + paramSet1 + "，size:" + paramSet1.size());
    if (!((Collection)paramSet1).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramSet1 = ((Iterable)paramSet1).iterator();
      while (paramSet1.hasNext()) {
        dn((String)paramSet1.next(), 1);
      }
    }
    b(paramSet2, this.ssz);
    ad.i(this.TAG, "pvCount:" + Fe(1) + ": uvCount:" + Ff(1));
    AppMethodBeat.o(203394);
  }
  
  private static void b(Set<String> paramSet1, Set<String> paramSet2)
  {
    AppMethodBeat.i(203395);
    paramSet2.clear();
    paramSet1 = ((Iterable)paramSet1).iterator();
    while (paramSet1.hasNext()) {
      paramSet2.add((String)paramSet1.next());
    }
    AppMethodBeat.o(203395);
  }
  
  private final void cEC()
  {
    AppMethodBeat.i(203401);
    b.a locala = this.ssy;
    locala.snl = 0L;
    locala.ahK("");
    locala.snn = 0L;
    locala.sno = 0L;
    this.ssx = false;
    this.ssD = 0L;
    this.ssE = 0L;
    this.ssz.clear();
    this.ssB.clear();
    this.ssA.clear();
    this.ssC.clear();
    AppMethodBeat.o(203401);
  }
  
  private final void dn(String paramString, int paramInt)
  {
    AppMethodBeat.i(203398);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(203398);
      return;
    }
    HashMap localHashMap = Fd(paramInt);
    if (((Map)localHashMap).containsKey(paramString))
    {
      Integer localInteger = (Integer)localHashMap.get(paramString);
      if (localInteger != null)
      {
        localHashMap.put(paramString, Integer.valueOf(localInteger.intValue() + 1));
        AppMethodBeat.o(203398);
        return;
      }
      AppMethodBeat.o(203398);
      return;
    }
    localHashMap.put(paramString, Integer.valueOf(1));
    AppMethodBeat.o(203398);
  }
  
  private final void f(aqy paramaqy)
  {
    AppMethodBeat.i(203399);
    ag localag = new ag();
    localag.cw(this.ssy.snl);
    localag.cx(this.ssy.sno);
    localag.hf(this.ssy.snm);
    localag.cz(Ff(1));
    localag.cA(Fe(1));
    localag.cB(Fe(2));
    localag.cC(Ff(2));
    localag.cD(this.ssD);
    localag.cF(this.ssE);
    localag.cE(System.currentTimeMillis() - this.ssy.snn);
    if (paramaqy != null) {
      localag.cy(paramaqy.tcl);
    }
    localag.aLk();
    a((a)localag);
    AppMethodBeat.o(203399);
  }
  
  public final void N(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(203390);
    cEC();
    b.a locala = this.ssy;
    locala.snl = paramLong1;
    locala.sno = paramLong2;
    locala.snn = cf.aCM();
    locala.ahK(String.valueOf(locala.snn));
    this.ssx = true;
    AppMethodBeat.o(203390);
  }
  
  public final void ahJ(String paramString)
  {
    AppMethodBeat.i(203393);
    p.h(paramString, "key");
    if (!this.ssx)
    {
      AppMethodBeat.o(203393);
      return;
    }
    dn(paramString, 2);
    AppMethodBeat.o(203393);
  }
  
  public final void e(aqy paramaqy)
  {
    AppMethodBeat.i(203391);
    f(paramaqy);
    this.ssx = false;
    AppMethodBeat.o(203391);
  }
  
  public final void l(Set<String> paramSet)
  {
    AppMethodBeat.i(203392);
    p.h(paramSet, "curRecordSet");
    a(this.ssz, paramSet);
    AppMethodBeat.o(203392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.x
 * JD-Core Version:    0.7.0.1
 */