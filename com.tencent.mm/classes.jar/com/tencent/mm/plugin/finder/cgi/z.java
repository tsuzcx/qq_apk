package com.tencent.mm.plugin.finder.cgi;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.cm;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.report.t;
import com.tencent.mm.plugin.finder.report.t.a;
import com.tencent.mm.plugin.findersdk.b.a.b;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.aqo;
import com.tencent.mm.protocal.protobuf.asy;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bjn;
import com.tencent.mm.protocal.protobuf.bjo;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.emr;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStatsReport;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportResponse;", "stats", "", "Lcom/tencent/mm/protocal/protobuf/Stats;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/util/List;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "enableReportVal", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "buildStatsRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportRequest;", "getFluencyInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFluencyInfo;", "isEnableReport", "onCgiEnd", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class z
  extends c<bjo>
{
  public static final a xbo;
  private b xbn;
  
  static
  {
    AppMethodBeat.i(266616);
    xbo = new a((byte)0);
    AppMethodBeat.o(266616);
  }
  
  public z(List<? extends emr> paramList, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(266614);
    d.a locala = new d.a();
    Object localObject1 = new bjn();
    Object localObject2 = ((Iterable)paramList).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (emr)((Iterator)localObject2).next();
      if (parambid != null) {}
      for (int i = parambid.xkX;; i = 0)
      {
        ((emr)localObject3).xkX = i;
        t.a locala1 = t.zXK;
        t.a.a((emr)localObject3, "Finder.CgiFinderStatsReport");
        break;
      }
    }
    locala.c((a)localObject1);
    ((bjn)localObject1).SFB.addAll((Collection)paramList);
    ((bjn)localObject1).finderUsername = com.tencent.mm.model.z.bdh();
    localObject2 = ao.xcj;
    ((bjn)localObject1).yjp = ao.a(parambid);
    ((bjn)localObject1).STF = cm.bfE();
    parambid = new aqo();
    parambid.osName = com.tencent.mm.protocal.d.RAz;
    parambid.osVersion = com.tencent.mm.protocal.d.RAA;
    parambid.deviceBrand = com.tencent.mm.protocal.d.RAw;
    parambid.deviceModel = com.tencent.mm.protocal.d.RAx;
    parambid.SDN = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
    localObject2 = n.zWF;
    parambid.netType = n.bvR();
    parambid.SDO = CdnLogic.getRecentAverageSpeed(2);
    localObject2 = parambid.SDP;
    Object localObject3 = com.tencent.mm.plugin.finder.video.reporter.d.ARA;
    ((LinkedList)localObject2).addAll((Collection)com.tencent.mm.plugin.finder.video.reporter.d.ehQ());
    localObject2 = new StringBuilder("[buildStatsRequest] lastVideosDownloadInfo size=");
    localObject3 = com.tencent.mm.plugin.finder.video.reporter.d.ARA;
    Log.i("Finder.CgiFinderStatsReport", com.tencent.mm.plugin.finder.video.reporter.d.ehQ().size());
    localObject2 = com.tencent.mm.plugin.finder.video.reporter.d.ARA;
    com.tencent.mm.plugin.finder.video.reporter.d.ehQ().clear();
    parambid.SDQ.add("h264");
    if (e.vW(4)) {
      parambid.SDQ.add("h265");
    }
    parambid.SDR = dnE();
    ((bjn)localObject1).SCW = parambid;
    parambid = ao.xcj;
    parambid = ((bjn)localObject1).yjp;
    localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (emr)((Iterator)localObject1).next();
      paramList.add(new o(Integer.valueOf(((emr)localObject2).xkX), Long.valueOf(((emr)localObject2).xbk)));
    }
    ao.a(parambid, (List)paramList);
    paramList = new bjo();
    paramList.setBaseResponse(new jh());
    paramList.getBaseResponse().Tef = new eaf();
    locala.d((a)paramList);
    locala.TW("/cgi-bin/micromsg-bin/finderstatsreport");
    locala.vD(3776);
    c(locala.bgN());
    this.xbn = b.BvV;
    AppMethodBeat.o(266614);
  }
  
  private final LinkedList<asy> dnE()
  {
    try
    {
      AppMethodBeat.i(266612);
      LinkedList localLinkedList = new LinkedList();
      Object localObject2 = com.tencent.mm.plugin.finder.report.j.zVy;
      localLinkedList.addAll((Collection)com.tencent.mm.plugin.finder.report.j.dPp());
      localObject2 = h.zVd;
      localLinkedList.addAll((Collection)h.dPp());
      AppMethodBeat.o(266612);
      return localLinkedList;
    }
    finally
    {
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public final b dnF()
  {
    return this.xbn;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStatsReport$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.z
 * JD-Core Version:    0.7.0.1
 */