package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.cw.f;
import com.tencent.mm.model.cm;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.emr;
import com.tencent.mm.protocal.protobuf.ezq;
import com.tencent.mm.protocal.protobuf.mf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.c.a;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderStatLogic;", "", "()V", "LIMIT_PER_COUNT", "", "RETRY_COUNT", "TAG", "", "genStats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "feedId", "", "mediaType", "sessionBuffer", "commentScene", "sendStatsLimit", "", "list", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "hasTryTime", "plugin-finder_release"})
public final class w
{
  public static final w zYO;
  
  static
  {
    AppMethodBeat.i(285456);
    zYO = new w();
    AppMethodBeat.o(285456);
  }
  
  public static void a(List<? extends emr> paramList, final bid parambid, final int paramInt)
  {
    AppMethodBeat.i(285454);
    p.k(paramList, "list");
    if ((paramInt > 2) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(285454);
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
      new com.tencent.mm.plugin.finder.cgi.z((List)localLinkedList2, parambid).bhV().bhW().j((a)new a(localLinkedList2, localLinkedList1, parambid, paramInt));
      AppMethodBeat.o(285454);
      return;
      localLinkedList2.addAll((Collection)paramList);
    }
  }
  
  public static emr b(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(285455);
    emr localemr = new emr();
    localemr.Upk = new ezq();
    localemr.Upj = new mf();
    localemr.Upl = new dhb();
    localemr.xbk = paramLong;
    localemr.xkX = paramInt;
    localemr.sessionBuffer = paramString;
    localemr.finderUsername = com.tencent.mm.model.z.bdh();
    localemr.Upm = cm.bfE();
    localemr.mediaType = 2004;
    AppMethodBeat.o(285455);
    return localemr;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    a(LinkedList paramLinkedList1, LinkedList paramLinkedList2, bid parambid, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.w
 * JD-Core Version:    0.7.0.1
 */