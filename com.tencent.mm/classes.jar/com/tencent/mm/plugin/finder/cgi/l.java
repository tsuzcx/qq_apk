package com.tencent.mm.plugin.finder.cgi;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.report.e;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.report.r;
import com.tencent.mm.plugin.finder.report.y;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aln;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dij;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStatsReport;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportResponse;", "stats", "", "Lcom/tencent/mm/protocal/protobuf/Stats;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/util/List;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "buildStatsRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportRequest;", "getFluencyInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFluencyInfo;", "Companion", "plugin-finder_release"})
public final class l
  extends w<arn>
{
  public static final a rIf;
  
  static
  {
    AppMethodBeat.i(201036);
    rIf = new a((byte)0);
    AppMethodBeat.o(201036);
  }
  
  public l(List<? extends dij> paramList, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(201035);
    b.a locala = new b.a();
    Object localObject1 = new arm();
    Object localObject2 = ((Iterable)paramList).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (dij)((Iterator)localObject2).next();
      if (paramaqy != null) {}
      for (int i = paramaqy.rTD;; i = 0)
      {
        ((dij)localObject3).rTD = i;
        break;
      }
    }
    locala.c((a)localObject1);
    ((arm)localObject1).Gpk.addAll((Collection)paramList);
    ((arm)localObject1).rTn = u.aAu();
    localObject2 = v.rIR;
    ((arm)localObject1).Glv = v.a(paramaqy);
    paramaqy = new aln();
    paramaqy.osName = com.tencent.mm.protocal.d.Fng;
    paramaqy.osVersion = com.tencent.mm.protocal.d.Fnh;
    paramaqy.deviceBrand = com.tencent.mm.protocal.d.Fnd;
    paramaqy.deviceModel = com.tencent.mm.protocal.d.Fne;
    paramaqy.Gln = ay.getNetTypeString(aj.getContext());
    localObject2 = h.soM;
    paramaqy.netType = h.cDz();
    paramaqy.Glo = CdnLogic.getRecentAverageSpeed(2);
    localObject2 = paramaqy.Glp;
    Object localObject3 = r.sqN;
    ((LinkedList)localObject2).addAll((Collection)r.cEf());
    localObject2 = new StringBuilder("[buildStatsRequest] lastVideosDownloadInfo size=");
    localObject3 = r.sqN;
    ad.i("Finder.CgiFinderStatsReport", r.cEf().size());
    localObject2 = r.sqN;
    r.cEf().clear();
    paramaqy.Glq.add("h264");
    if (com.tencent.mm.modelcontrol.d.pf(4)) {
      paramaqy.Glq.add("h265");
    }
    localObject2 = new LinkedList();
    localObject3 = e.snY;
    ((LinkedList)localObject2).addAll((Collection)e.bMX());
    localObject3 = y.LjV;
    ((LinkedList)localObject2).addAll((Collection)y.bMX());
    paramaqy.Oes = ((LinkedList)localObject2);
    ((arm)localObject1).Gnb = paramaqy;
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      paramaqy = (dij)paramList.next();
      localObject1 = com.tencent.mm.plugin.finder.report.l.spI;
      com.tencent.mm.plugin.finder.report.l.a.a(paramaqy, "Finder.CgiFinderStatsReport");
    }
    paramList = new arn();
    paramList.setBaseResponse(new BaseResponse());
    paramList.getBaseResponse().ErrMsg = new cwt();
    locala.d((a)paramList);
    locala.Dl("/cgi-bin/micromsg-bin/finderstatsreport");
    locala.oP(3776);
    c(locala.aDC());
    AppMethodBeat.o(201035);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStatsReport$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.l
 * JD-Core Version:    0.7.0.1
 */