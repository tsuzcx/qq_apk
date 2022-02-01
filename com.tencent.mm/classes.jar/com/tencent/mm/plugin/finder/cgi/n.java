package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.report.d.a;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.report.s;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderStreamPartialExposeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderStreamPartialExposeUIC.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.alz;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.ash;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import d.l;
import d.o;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "pullType", "", "tabType", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "useGlobalLastBuffer", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;IILcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protobuf/ByteString;ZLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "isFetchFeedCgi", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Callback", "Companion", "ConsumeCallback", "plugin-finder_release"})
public final class n
  extends w<asi>
{
  public static final b rQK;
  private final int dvm;
  private final com.tencent.mm.bw.b lastBuffer;
  private final int pullType;
  private final ash rQI;
  private final a rQJ;
  private final c rQc;
  private final boolean rQd;
  
  static
  {
    AppMethodBeat.i(165175);
    rQK = new b((byte)0);
    AppMethodBeat.o(165175);
  }
  
  public n(a parama, int paramInt1, int paramInt2, c paramc, com.tencent.mm.bw.b paramb, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(201488);
    this.rQJ = parama;
    this.pullType = paramInt1;
    this.dvm = paramInt2;
    this.rQc = paramc;
    this.lastBuffer = paramb;
    this.rQd = false;
    this.rQI = new ash();
    if ((this.pullType == 0) && (this.rQd))
    {
      parama = g.ajR();
      d.g.b.p.g(parama, "MMKernel.storage()");
      parama = parama.ajA();
      paramc = com.tencent.mm.plugin.finder.utils.p.sXz;
      parama.set(com.tencent.mm.plugin.finder.utils.p.Gr(this.dvm), null);
    }
    paramb = new b.a();
    if (this.rQd)
    {
      parama = g.ajR();
      d.g.b.p.g(parama, "MMKernel.storage()");
      parama = parama.ajA();
      paramc = com.tencent.mm.plugin.finder.utils.p.sXz;
      parama = parama.get(com.tencent.mm.plugin.finder.utils.p.Gr(this.dvm), "");
      if (parama == null)
      {
        parama = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(201488);
        throw parama;
      }
      parama = bu.aSx((String)parama);
      this.rQI.lastBuffer = com.tencent.mm.bw.b.cm(parama);
      this.rQI.pullType = this.pullType;
      this.rQI.dvm = this.dvm;
      if ((this.pullType == 1) && ((this.dvm == 1) || (this.dvm == 3) || (this.dvm == 4)))
      {
        parama = this.rQI;
        paramc = FinderStreamPartialExposeUIC.tnK;
        parama.GJj = FinderStreamPartialExposeUIC.a.GX(this.dvm);
        ae.i("Finder.CgiFinderTimelineStream", "[request] tabType=" + this.dvm + " partialExposedObjectId=" + this.rQI.GJj + " h:" + hashCode());
      }
      parama = com.tencent.mm.ui.component.a.KEX;
      com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
      parama = FinderGlobalLocationVM.cQL();
      this.rQI.dBu = ((Number)parama.first).floatValue();
      this.rQI.dzE = ((Number)parama.second).floatValue();
      parama = this.rQI;
      paramc = v.rRb;
      parama.GDR = v.a(paramarn);
      paramarn = this.rQI;
      paramc = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cos();
      parama = paramc;
      if (paramc == null) {
        parama = "";
      }
      paramarn.sessionId = parama;
      parama = g.ad(PluginFinder.class);
      d.g.b.p.g(parama, "MMKernel.plugin(PluginFinder::class.java)");
      parama = ((PluginFinder)parama).getRedDotManager().EG(this.dvm);
      if (parama.GJI != 0L)
      {
        this.rQI.GJh = parama.GJI;
        this.rQI.GJi = parama.GJJ;
        ae.i("Finder.CgiFinderTimelineStream", "[request] tabType=" + this.dvm + " request with showInfo. objectId=" + com.tencent.mm.ac.c.rp(this.rQI.GJh) + " h:" + hashCode());
      }
      parama = new alz();
      parama.osName = com.tencent.mm.protocal.d.FFE;
      parama.osVersion = com.tencent.mm.protocal.d.FFF;
      parama.deviceBrand = com.tencent.mm.protocal.d.FFB;
      parama.deviceModel = com.tencent.mm.protocal.d.FFC;
      parama.GEp = az.getNetTypeString(ak.getContext());
      paramc = i.syT;
      parama.netType = i.cFu();
      parama.GEq = CdnLogic.getRecentAverageSpeed(2);
      paramc = s.sAY;
      parama.GEr = s.cGa();
      parama.GEs.add("h264");
      if (com.tencent.mm.modelcontrol.d.pi(4)) {
        parama.GEs.add("h265");
      }
      paramc = this.rQI;
      paramarn = y.stw;
      paramc.GGB = y.EU(this.dvm);
      this.rQI.GDS = parama;
      parama = com.tencent.mm.plugin.finder.report.d.sxJ;
      parama = d.a.Fd(this.dvm);
      if (parama != null) {
        this.rQI.GIA = parama;
      }
      paramb.c((com.tencent.mm.bw.a)this.rQI);
      parama = new asi();
      parama.setBaseResponse(new BaseResponse());
      parama.getBaseResponse().ErrMsg = new cxn();
      paramb.d((com.tencent.mm.bw.a)parama);
      paramb.DN("/cgi-bin/micromsg-bin/finderstream");
      paramb.oS(3901);
      c(paramb.aDS());
      parama = new StringBuilder("lxl CgiFetchFinderTimeline  tabType=").append(this.dvm).append(" init ").append(this.pullType).append(" lastBuffer ");
      if (this.rQI.lastBuffer != null) {
        break label947;
      }
    }
    label947:
    for (boolean bool = true;; bool = false)
    {
      paramc = parama.append(bool).append(", ");
      if (this.rQI.lastBuffer != null) {
        break label953;
      }
      parama = Character.valueOf('1');
      ae.i("Finder.CgiFinderTimelineStream", parama + " longitude=" + this.rQI.dBu + " latitude=" + this.rQI.dzE + " h:" + hashCode());
      AppMethodBeat.o(201488);
      return;
      this.rQI.lastBuffer = this.lastBuffer;
      break;
    }
    label953:
    parama = this.rQI.lastBuffer;
    if (parama != null) {}
    for (parama = parama.getBytes();; parama = null)
    {
      parama = com.tencent.mm.sdk.platformtools.aj.B(parama);
      break;
    }
  }
  
  public final boolean czv()
  {
    return true;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.finder.feed.model.b paramb, int paramInt);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "", "isFetchConsume", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "plugin-finder_release"})
  public static abstract interface c
  {
    public abstract boolean b(cwj paramcwj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.n
 * JD-Core Version:    0.7.0.1
 */