package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.cw;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/RecordFinderChatList;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "chatExposeMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "chatListRecord", "Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$ChatListRecord;", "getChatListRecord", "()Lcom/tencent/mm/plugin/finder/report/FinderChatReporter$ChatListRecord;", "clickChatExposeMap", "clickChatExposeSet", "", "currentChatExposeSet", "delClickCountL", "", "dotClickCountL", "isOnProcess", "", "()Z", "setOnProcess", "(Z)V", "copySet", "", "src", "", "dst", "getExposePv", "type", "getExposeUV", "getMapContainer", "getSessionId", "getSetContainer", "incChatExpose", "key", "incDelClickCount", "incDotClickCount", "onEnterChatList", "accountType", "isGreetSession", "onExitChatList", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "recordChatClickExpose", "curRecordSet", "recordChatExpose", "exposeSet", "report20688", "resetChatListRecord", "structLog", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ba
{
  public boolean FuC;
  public final f.a FuD;
  private final Set<String> FuE;
  private final HashMap<String, Integer> FuF;
  private final Set<String> FuG;
  private final HashMap<String, Integer> FuH;
  public long FuI;
  private long FuJ;
  private final String TAG;
  
  public ba()
  {
    AppMethodBeat.i(331080);
    this.TAG = "RecordFinderChatList";
    this.FuD = new f.a();
    this.FuE = ((Set)new HashSet());
    this.FuF = new HashMap();
    this.FuG = ((Set)new HashSet());
    this.FuH = new HashMap();
    AppMethodBeat.o(331080);
  }
  
  private final HashMap<String, Integer> SU(int paramInt)
  {
    if (paramInt == 1) {
      return this.FuF;
    }
    return this.FuH;
  }
  
  private final long SV(int paramInt)
  {
    AppMethodBeat.i(331106);
    long l = 0L;
    Object localObject = SU(paramInt).values();
    s.s(localObject, "getMapContainer(type).values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      s.s(localInteger, "it");
      l = localInteger.intValue() + l;
    }
    AppMethodBeat.o(331106);
    return l;
  }
  
  private final long SW(int paramInt)
  {
    AppMethodBeat.i(331110);
    long l = SU(paramInt).size();
    AppMethodBeat.o(331110);
    return l;
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(331135);
    Object localObject = f.FnM;
    localObject = f.getTAG();
    StringBuilder localStringBuilder = new StringBuilder("report").append(parama.getId()).append(' ');
    parama = parama.aIF();
    s.s(parama, "struct.toShowString()");
    Log.i((String)localObject, n.bV(parama, "\r\n", " "));
    AppMethodBeat.o(331135);
  }
  
  private final void c(Set<String> paramSet1, Set<String> paramSet2)
  {
    AppMethodBeat.i(331088);
    if (!this.FuC)
    {
      AppMethodBeat.o(331088);
      return;
    }
    paramSet1 = ar.a(paramSet2, (Iterable)paramSet1);
    Log.i(this.TAG, "latestExposeRecords" + paramSet1 + "，size:" + paramSet1.size());
    if (!((Collection)paramSet1).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramSet1 = ((Iterable)paramSet1).iterator();
      while (paramSet1.hasNext()) {
        eH((String)paramSet1.next(), 1);
      }
    }
    d(paramSet2, this.FuE);
    Log.i(this.TAG, "pvCount:" + SV(1) + ": uvCount:" + SW(1));
    AppMethodBeat.o(331088);
  }
  
  private static void d(Set<String> paramSet1, Set<String> paramSet2)
  {
    AppMethodBeat.i(331100);
    paramSet2.clear();
    paramSet1 = ((Iterable)paramSet1).iterator();
    while (paramSet1.hasNext()) {
      paramSet2.add((String)paramSet1.next());
    }
    AppMethodBeat.o(331100);
  }
  
  private final void eH(String paramString, int paramInt)
  {
    AppMethodBeat.i(331118);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(331118);
      return;
    }
    HashMap localHashMap = SU(paramInt);
    if (((Map)localHashMap).containsKey(paramString))
    {
      Integer localInteger = (Integer)localHashMap.get(paramString);
      if (localInteger != null)
      {
        localHashMap.put(paramString, Integer.valueOf(localInteger.intValue() + 1));
        AppMethodBeat.o(331118);
      }
    }
    else
    {
      localHashMap.put(paramString, Integer.valueOf(1));
    }
    AppMethodBeat.o(331118);
  }
  
  private final void eNX()
  {
    AppMethodBeat.i(331143);
    f.a locala = this.FuD;
    locala.FnT = 0L;
    locala.azH("");
    locala.zVt = 0L;
    locala.FnV = 0L;
    this.FuC = false;
    this.FuI = 0L;
    this.FuJ = 0L;
    this.FuE.clear();
    this.FuG.clear();
    this.FuF.clear();
    this.FuH.clear();
    AppMethodBeat.o(331143);
  }
  
  private final void i(bui parambui)
  {
    AppMethodBeat.i(331127);
    cw localcw = new cw();
    localcw.ixI = this.FuD.FnT;
    localcw.ixT = this.FuD.FnV;
    localcw.mN(this.FuD.FnU);
    localcw.ixV = SW(1);
    localcw.ixW = SV(1);
    localcw.ixX = SV(2);
    localcw.ixY = SW(2);
    localcw.ixZ = this.FuI;
    localcw.iya = this.FuJ;
    localcw.ixN = (System.currentTimeMillis() - this.FuD.zVt);
    if (parambui != null) {
      localcw.ixH = parambui.hLK;
    }
    localcw.bMH();
    a((a)localcw);
    AppMethodBeat.o(331127);
  }
  
  public final void at(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(331149);
    eNX();
    f.a locala = this.FuD;
    locala.FnT = paramLong1;
    locala.FnV = paramLong2;
    locala.zVt = cn.bDw();
    locala.azH(String.valueOf(locala.zVt));
    this.FuC = true;
    AppMethodBeat.o(331149);
  }
  
  public final void azG(String paramString)
  {
    AppMethodBeat.i(331168);
    s.u(paramString, "key");
    if (!this.FuC)
    {
      AppMethodBeat.o(331168);
      return;
    }
    eH(paramString, 2);
    AppMethodBeat.o(331168);
  }
  
  public final void h(bui parambui)
  {
    AppMethodBeat.i(331155);
    i(parambui);
    this.FuC = false;
    AppMethodBeat.o(331155);
  }
  
  public final void v(Set<String> paramSet)
  {
    AppMethodBeat.i(331159);
    s.u(paramSet, "curRecordSet");
    c(this.FuE, paramSet);
    AppMethodBeat.o(331159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ba
 * JD-Core Version:    0.7.0.1
 */