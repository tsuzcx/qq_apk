package com.tencent.mm.plugin.finder.nearby.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.ap;
import com.tencent.mm.protocal.protobuf.axm;
import com.tencent.mm.protocal.protobuf.bvy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/report/NearbyLiveCgiStatusReport;", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStatsReport;", "()V", "getFluencyInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFluencyInfo;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportResponse;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends ap
{
  public static final c.a EQS;
  
  static
  {
    AppMethodBeat.i(339705);
    EQS = new c.a((byte)0);
    AppMethodBeat.o(339705);
  }
  
  public c()
  {
    super((List)new LinkedList(), null);
    AppMethodBeat.i(339699);
    AppMethodBeat.o(339699);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, bvy parambvy)
  {
    AppMethodBeat.i(339719);
    s.u(parambvy, "resp");
    Log.i("Finder.NearbyLiveCgiStatusReport", "onCgiEnd errType: " + paramInt1 + " errCode: " + paramInt2 + " errMsg: " + paramString);
    AppMethodBeat.o(339719);
  }
  
  public final LinkedList<axm> dVh()
  {
    AppMethodBeat.i(339711);
    LinkedList localLinkedList = new LinkedList();
    b localb = b.EQs;
    localLinkedList.addAll((Collection)b.eGJ());
    AppMethodBeat.o(339711);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.report.c
 * JD-Core Version:    0.7.0.1
 */