package com.tencent.mm.plugin.finder.cgi;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.finder.report.f;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.report.p;
import com.tencent.mm.plugin.finder.report.p.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.apc;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bct;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStatsReport;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportResponse;", "stats", "", "Lcom/tencent/mm/protocal/protobuf/Stats;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/util/List;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "enableReportVal", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "buildStatsRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportRequest;", "getFluencyInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFluencyInfo;", "isEnableReport", "onCgiEnd", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class z
  extends an<bct>
{
  public static final a ttI;
  private com.tencent.mm.plugin.finder.cgi.report.b ttH;
  
  static
  {
    AppMethodBeat.i(242260);
    ttI = new a((byte)0);
    AppMethodBeat.o(242260);
  }
  
  public z(List<? extends ecq> paramList, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242259);
    d.a locala = new d.a();
    Object localObject1 = new bcs();
    Object localObject2 = ((Iterable)paramList).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ecq)((Iterator)localObject2).next();
      if (parambbn != null) {}
      for (int i = parambbn.tCE;; i = 0)
      {
        ((ecq)localObject3).tCE = i;
        break;
      }
    }
    locala.c((a)localObject1);
    ((bcs)localObject1).LEw.addAll((Collection)paramList);
    ((bcs)localObject1).finderUsername = com.tencent.mm.model.z.aUg();
    localObject2 = am.tuw;
    ((bcs)localObject1).uli = am.a(parambbn);
    ((bcs)localObject1).LLM = cl.aWA();
    parambbn = new apc();
    parambbn.osName = d.KyL;
    parambbn.osVersion = d.KyM;
    parambbn.deviceBrand = d.KyI;
    parambbn.deviceModel = d.KyJ;
    parambbn.LBe = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
    localObject2 = k.vfA;
    parambbn.netType = k.dod();
    parambbn.LBf = CdnLogic.getRecentAverageSpeed(2);
    localObject2 = parambbn.LBg;
    Object localObject3 = com.tencent.mm.plugin.finder.video.reporter.b.whK;
    ((LinkedList)localObject2).addAll((Collection)com.tencent.mm.plugin.finder.video.reporter.b.dFZ());
    localObject2 = new StringBuilder("[buildStatsRequest] lastVideosDownloadInfo size=");
    localObject3 = com.tencent.mm.plugin.finder.video.reporter.b.whK;
    Log.i("Finder.CgiFinderStatsReport", com.tencent.mm.plugin.finder.video.reporter.b.dFZ().size());
    localObject2 = com.tencent.mm.plugin.finder.video.reporter.b.whK;
    com.tencent.mm.plugin.finder.video.reporter.b.dFZ().clear();
    parambbn.LBh.add("h264");
    if (e.sX(4)) {
      parambbn.LBh.add("h265");
    }
    parambbn.LBi = cXR();
    ((bcs)localObject1).LAv = parambbn;
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      parambbn = (ecq)paramList.next();
      localObject1 = p.vgC;
      p.a.a(parambbn, "Finder.CgiFinderStatsReport");
    }
    paramList = new bct();
    paramList.setBaseResponse(new BaseResponse());
    paramList.getBaseResponse().ErrMsg = new dqi();
    locala.d((a)paramList);
    locala.MB("/cgi-bin/micromsg-bin/finderstatsreport");
    locala.sG(3776);
    c(locala.aXF());
    this.ttH = com.tencent.mm.plugin.finder.cgi.report.b.tyf;
    AppMethodBeat.o(242259);
  }
  
  private final LinkedList<arc> cXR()
  {
    try
    {
      AppMethodBeat.i(242257);
      LinkedList localLinkedList = new LinkedList();
      Object localObject2 = h.veu;
      localLinkedList.addAll((Collection)h.dnP());
      localObject2 = f.veb;
      localLinkedList.addAll((Collection)f.dnP());
      AppMethodBeat.o(242257);
      return localLinkedList;
    }
    finally
    {
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public final com.tencent.mm.plugin.finder.cgi.report.b cXS()
  {
    return this.ttH;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStatsReport$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.z
 * JD-Core Version:    0.7.0.1
 */