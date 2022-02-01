package com.tencent.mm.plugin.finder.cgi;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.finder.report.af;
import com.tencent.mm.plugin.finder.report.af.a;
import com.tencent.mm.plugin.finder.video.f;
import com.tencent.mm.plugin.findersdk.b.a.b;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.axm;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bvx;
import com.tencent.mm.protocal.protobuf.bvy;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStatsReport;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportResponse;", "stats", "", "Lcom/tencent/mm/protocal/protobuf/Stats;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/util/List;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "enableReportVal", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "buildStatsRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStatsReportRequest;", "getFluencyInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFluencyInfo;", "isEnableReport", "onCgiEnd", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class ap
  extends c<bvy>
{
  public static final a AzZ;
  private b AAa;
  
  static
  {
    AppMethodBeat.i(336234);
    AzZ = new a((byte)0);
    AppMethodBeat.o(336234);
  }
  
  public ap(List<? extends fhp> paramList, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336227);
    c.a locala = new c.a();
    Object localObject1 = new bvx();
    Object localObject2 = ((Iterable)paramList).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (fhp)((Iterator)localObject2).next();
      if (parambui == null) {}
      for (int i = 0;; i = parambui.AJo)
      {
        ((fhp)localObject3).AJo = i;
        localObject4 = af.FsA;
        af.a.a((fhp)localObject3, "Finder.CgiFinderStatsReport");
        break;
      }
    }
    locala.otE = ((a)localObject1);
    ((bvx)localObject1).ZHE.addAll((Collection)paramList);
    ((bvx)localObject1).finderUsername = com.tencent.mm.model.z.bAW();
    localObject2 = bi.ABn;
    ((bvx)localObject1).CJv = bi.a(parambui);
    ((bvx)localObject1).aadJ = cn.bDw();
    localObject2 = new aur();
    ((aur)localObject2).osName = d.Yxd;
    ((aur)localObject2).osVersion = d.Yxe;
    ((aur)localObject2).deviceBrand = d.Yxa;
    ((aur)localObject2).deviceModel = d.Yxb;
    ((aur)localObject2).ZEZ = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
    Object localObject3 = com.tencent.mm.plugin.finder.report.z.FrZ;
    ((aur)localObject2).netType = com.tencent.mm.plugin.finder.report.z.bUg();
    ((aur)localObject2).ZFa = CdnLogic.getRecentAverageSpeed(2);
    localObject3 = ((aur)localObject2).ZFb;
    Object localObject4 = f.Gog;
    ((LinkedList)localObject3).addAll((Collection)f.fiT());
    localObject3 = f.Gog;
    Log.i("Finder.CgiFinderStatsReport", kotlin.g.b.s.X("[buildStatsRequest] lastVideosDownloadInfo size=", Integer.valueOf(f.fiT().size())));
    localObject3 = f.Gog;
    f.fiT().clear();
    ((aur)localObject2).ZFc.add("h264");
    if (e.wb(4)) {
      ((aur)localObject2).ZFc.add("h265");
    }
    ((aur)localObject2).ZFd = dVh();
    localObject3 = ((aur)localObject2).ZFh;
    localObject4 = f.Gog;
    ((LinkedList)localObject3).addAll((Collection)f.fiU());
    localObject3 = ((aur)localObject2).ZFf;
    localObject4 = f.Gog;
    ((LinkedList)localObject3).addAll((Collection)f.fiV());
    localObject3 = ((aur)localObject2).ZFg;
    localObject4 = f.Gog;
    ((LinkedList)localObject3).addAll((Collection)f.fiW());
    ((bvx)localObject1).ZDQ = ((aur)localObject2);
    localObject2 = bi.ABn;
    localObject1 = ((bvx)localObject1).CJv;
    localObject2 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (fhp)((Iterator)localObject2).next();
      paramList.add(new r(Integer.valueOf(((fhp)localObject3).AJo), Long.valueOf(((fhp)localObject3).hKN)));
    }
    bi.a((atz)localObject1, (List)paramList, parambui);
    paramList = new bvy();
    paramList.setBaseResponse(new kd());
    paramList.getBaseResponse().akjO = new etl();
    locala.otF = ((a)paramList);
    locala.uri = "/cgi-bin/micromsg-bin/finderstatsreport";
    locala.funcId = 3776;
    c(locala.bEF());
    this.AAa = b.Hdf;
    AppMethodBeat.o(336227);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, bvy parambvy)
  {
    AppMethodBeat.i(336255);
    kotlin.g.b.s.u(parambvy, "resp");
    if (paramInt1 >= 4) {
      this.AAa = b.Hdd;
    }
    AppMethodBeat.o(336255);
  }
  
  protected LinkedList<axm> dVh()
  {
    try
    {
      AppMethodBeat.i(336242);
      LinkedList localLinkedList = new LinkedList();
      com.tencent.mm.plugin.finder.report.s locals = com.tencent.mm.plugin.finder.report.s.Fqv;
      localLinkedList.addAll((Collection)com.tencent.mm.plugin.finder.report.s.eGJ());
      AppMethodBeat.o(336242);
      return localLinkedList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final b dVi()
  {
    return this.AAa;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStatsReport$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ap
 * JD-Core Version:    0.7.0.1
 */