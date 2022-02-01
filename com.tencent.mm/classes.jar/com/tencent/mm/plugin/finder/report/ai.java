package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.b;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ap;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.protocal.protobuf.fvu;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderStatLogic;", "", "()V", "LIMIT_PER_COUNT", "", "RETRY_COUNT", "TAG", "", "genStats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "feedId", "", "mediaType", "sessionBuffer", "commentScene", "sendStatsLimit", "", "list", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "hasTryTime", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai
{
  public static final ai FtE;
  
  static
  {
    AppMethodBeat.i(331294);
    FtE = new ai();
    AppMethodBeat.o(331294);
  }
  
  private static final ah a(LinkedList paramLinkedList1, LinkedList paramLinkedList2, bui parambui, int paramInt, b.a parama)
  {
    AppMethodBeat.i(331286);
    s.u(paramLinkedList1, "$sendList");
    s.u(paramLinkedList2, "$nextList");
    if ((parama.errCode == 0) && (parama.errType == 0))
    {
      Log.i("Finder.StatLogicReporter", s.X("successfully! size=", Integer.valueOf(paramLinkedList1.size())));
      a((List)paramLinkedList2, parambui, 0);
    }
    for (;;)
    {
      paramLinkedList1 = ah.aiuX;
      AppMethodBeat.o(331286);
      return paramLinkedList1;
      if (paramInt <= 2)
      {
        paramLinkedList2.addAll(0, (Collection)paramLinkedList1);
        Log.i("Finder.StatLogicReporter", s.X("failure! try next time, size=", Integer.valueOf(paramLinkedList1.size())));
        a((List)paramLinkedList2, parambui, paramInt + 1);
      }
      else
      {
        paramLinkedList2 = new StringBuilder("tryCount=").append(paramInt).append(", throw this sendList=");
        parambui = (Iterable)paramLinkedList1;
        paramLinkedList1 = (Collection)new ArrayList(p.a(parambui, 10));
        parambui = parambui.iterator();
        while (parambui.hasNext()) {
          paramLinkedList1.add(d.hF(((fhp)parambui.next()).hKN));
        }
        Log.e("Finder.StatLogicReporter", (List)paramLinkedList1);
      }
    }
  }
  
  public static void a(List<? extends fhp> paramList, bui parambui, int paramInt)
  {
    AppMethodBeat.i(331265);
    s.u(paramList, "list");
    if ((paramInt > 2) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(331265);
      return;
    }
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    if (paramList.size() > 20)
    {
      localLinkedList2.addAll((Collection)paramList.subList(0, 20));
      localLinkedList1.addAll((Collection)paramList.subList(20, paramList.size()));
    }
    for (;;)
    {
      Log.i("Finder.StatLogicReporter", "[sendStatsLimit] list=" + paramList.size() + " tryCount=" + paramInt);
      paramList = new ap((List)localLinkedList2, parambui);
      paramList.otr = true;
      paramList.bFJ().j(new ai..ExternalSyntheticLambda0(localLinkedList2, localLinkedList1, parambui, paramInt));
      AppMethodBeat.o(331265);
      return;
      localLinkedList2.addAll((Collection)paramList);
    }
  }
  
  public static fhp c(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(331272);
    fhp localfhp = new fhp();
    localfhp.abIi = new fvu();
    localfhp.abIh = new ni();
    localfhp.abIj = new dzj();
    localfhp.hKN = paramLong;
    localfhp.AJo = paramInt;
    localfhp.sessionBuffer = paramString;
    localfhp.finderUsername = z.bAW();
    localfhp.abIk = cn.bDw();
    localfhp.mediaType = 2004;
    AppMethodBeat.o(331272);
    return localfhp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ai
 * JD-Core Version:    0.7.0.1
 */