package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.co.f;
import com.tencent.mm.model.cl;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cxr;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.protocal.protobuf.epf;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.c.a;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderStatLogic;", "", "()V", "LIMIT_PER_COUNT", "", "RETRY_COUNT", "TAG", "", "genStats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "feedId", "", "mediaType", "sessionBuffer", "commentScene", "sendStatsLimit", "", "list", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "hasTryTime", "plugin-finder_release"})
public final class s
{
  public static final s vhF;
  
  static
  {
    AppMethodBeat.i(250797);
    vhF = new s();
    AppMethodBeat.o(250797);
  }
  
  public static ecq a(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(250796);
    ecq localecq = new ecq();
    localecq.NcN = new epf();
    localecq.NcM = new mp();
    localecq.NcO = new cxr();
    localecq.hFK = paramLong;
    localecq.tCE = paramInt;
    localecq.sessionBuffer = paramString;
    localecq.finderUsername = com.tencent.mm.model.z.aUg();
    localecq.NcP = cl.aWA();
    localecq.mediaType = 2004;
    AppMethodBeat.o(250796);
    return localecq;
  }
  
  public static void a(List<? extends ecq> paramList, final bbn parambbn, final int paramInt)
  {
    AppMethodBeat.i(250795);
    p.h(paramList, "list");
    if ((paramInt > 2) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(250795);
      return;
    }
    final LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    if (paramList.size() > 20)
    {
      localLinkedList2.addAll((Collection)paramList.subList(0, 20));
      localLinkedList1.addAll((Collection)paramList.subList(20, paramList.size()));
    }
    for (;;)
    {
      Log.i("Finder.StatLogicReporter", "[sendStatsLimit] list=" + paramList.size() + " tryCount=" + paramInt);
      new com.tencent.mm.plugin.finder.cgi.z((List)localLinkedList2, parambbn).aYH().aYI().j((a)new a(localLinkedList2, localLinkedList1, parambbn, paramInt));
      AppMethodBeat.o(250795);
      return;
      localLinkedList2.addAll((Collection)paramList);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    a(LinkedList paramLinkedList1, LinkedList paramLinkedList2, bbn parambbn, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.s
 * JD-Core Version:    0.7.0.1
 */