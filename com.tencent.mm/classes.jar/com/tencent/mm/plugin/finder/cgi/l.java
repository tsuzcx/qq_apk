package com.tencent.mm.plugin.finder.cgi;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.report.e;
import com.tencent.mm.plugin.finder.report.f;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.report.m;
import com.tencent.mm.plugin.finder.report.m.a;
import com.tencent.mm.plugin.finder.report.s;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.alz;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.asc;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dje;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStatsReport;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportResponse;", "stats", "", "Lcom/tencent/mm/protocal/protobuf/Stats;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/util/List;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "buildStatsRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportRequest;", "getFluencyInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFluencyInfo;", "Companion", "plugin-finder_release"})
public final class l
  extends w<asc>
{
  public static final a rQq;
  
  static
  {
    AppMethodBeat.i(201458);
    rQq = new a((byte)0);
    AppMethodBeat.o(201458);
  }
  
  public l(List<? extends dje> paramList, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(201457);
    b.a locala = new b.a();
    Object localObject1 = new asb();
    Object localObject2 = ((Iterable)paramList).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (dje)((Iterator)localObject2).next();
      if (paramarn != null) {}
      for (int i = paramarn.sch;; i = 0)
      {
        ((dje)localObject3).sch = i;
        break;
      }
    }
    locala.c((a)localObject1);
    ((asb)localObject1).GIA.addAll((Collection)paramList);
    ((asb)localObject1).sbR = com.tencent.mm.model.v.aAK();
    localObject2 = v.rRb;
    ((asb)localObject1).GDR = v.a(paramarn);
    ((asb)localObject1).LGt = ch.aDc();
    paramarn = new alz();
    paramarn.osName = com.tencent.mm.protocal.d.FFE;
    paramarn.osVersion = com.tencent.mm.protocal.d.FFF;
    paramarn.deviceBrand = com.tencent.mm.protocal.d.FFB;
    paramarn.deviceModel = com.tencent.mm.protocal.d.FFC;
    paramarn.GEp = az.getNetTypeString(ak.getContext());
    localObject2 = i.syT;
    paramarn.netType = i.cFu();
    paramarn.GEq = CdnLogic.getRecentAverageSpeed(2);
    localObject2 = paramarn.GEr;
    Object localObject3 = s.sAY;
    ((LinkedList)localObject2).addAll((Collection)s.cGb());
    localObject2 = new StringBuilder("[buildStatsRequest] lastVideosDownloadInfo size=");
    localObject3 = s.sAY;
    ae.i("Finder.CgiFinderStatsReport", s.cGb().size());
    localObject2 = s.sAY;
    s.cGb().clear();
    paramarn.GEs.add("h264");
    if (com.tencent.mm.modelcontrol.d.pi(4)) {
      paramarn.GEs.add("h265");
    }
    localObject2 = new LinkedList();
    localObject3 = f.syc;
    ((LinkedList)localObject2).addAll((Collection)f.cFl());
    localObject3 = e.sxO;
    ((LinkedList)localObject2).addAll((Collection)e.cFl());
    paramarn.GEt = ((LinkedList)localObject2);
    ((asb)localObject1).GDS = paramarn;
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      paramarn = (dje)paramList.next();
      localObject1 = m.szT;
      m.a.a(paramarn, "Finder.CgiFinderStatsReport");
    }
    paramList = new asc();
    paramList.setBaseResponse(new BaseResponse());
    paramList.getBaseResponse().ErrMsg = new cxn();
    locala.d((a)paramList);
    locala.DN("/cgi-bin/micromsg-bin/finderstatsreport");
    locala.oS(3776);
    c(locala.aDS());
    AppMethodBeat.o(201457);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStatsReport$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.l
 * JD-Core Version:    0.7.0.1
 */