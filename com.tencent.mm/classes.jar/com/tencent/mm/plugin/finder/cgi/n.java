package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.report.d.a;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.report.r;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderStreamPartialExposeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderStreamPartialExposeUIC.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aln;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.protocal.protobuf.art;
import com.tencent.mm.protocal.protobuf.asd;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import d.o;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "pullType", "", "tabType", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "useGlobalLastBuffer", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;IILcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protobuf/ByteString;ZLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "isFetchFeedCgi", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Callback", "Companion", "ConsumeCallback", "plugin-finder_release"})
public final class n
  extends w<art>
{
  public static final b rIA;
  private final int duh;
  private final com.tencent.mm.bx.b lastBuffer;
  private final int pullType;
  private final c rHR;
  private final boolean rHS;
  private final ars rIy;
  private final a rIz;
  
  static
  {
    AppMethodBeat.i(165175);
    rIA = new b((byte)0);
    AppMethodBeat.o(165175);
  }
  
  public n(a parama, int paramInt1, int paramInt2, c paramc, com.tencent.mm.bx.b paramb, boolean paramBoolean, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(201070);
    this.rIz = parama;
    this.pullType = paramInt1;
    this.duh = paramInt2;
    this.rHR = paramc;
    this.lastBuffer = paramb;
    this.rHS = paramBoolean;
    this.rIy = new ars();
    if ((this.pullType == 0) && (this.rHS))
    {
      parama = g.ajC();
      d.g.b.p.g(parama, "MMKernel.storage()");
      parama = parama.ajl();
      paramc = com.tencent.mm.plugin.finder.utils.p.sMo;
      parama.set(com.tencent.mm.plugin.finder.utils.p.FS(this.duh), null);
    }
    paramb = new b.a();
    if (this.rHS)
    {
      parama = g.ajC();
      d.g.b.p.g(parama, "MMKernel.storage()");
      parama = parama.ajl();
      paramc = com.tencent.mm.plugin.finder.utils.p.sMo;
      parama = parama.get(com.tencent.mm.plugin.finder.utils.p.FS(this.duh), "");
      if (parama == null)
      {
        parama = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(201070);
        throw parama;
      }
      parama = bt.aRa((String)parama);
      this.rIy.lastBuffer = com.tencent.mm.bx.b.cj(parama);
      this.rIy.pullType = this.pullType;
      this.rIy.duh = this.duh;
      if ((this.pullType == 1) && ((this.duh == 1) || (this.duh == 3) || (this.duh == 4)))
      {
        parama = this.rIy;
        paramc = FinderStreamPartialExposeUIC.tcQ;
        parama.GpO = FinderStreamPartialExposeUIC.a.GA(this.duh);
        ad.i("Finder.CgiFinderTimelineStream", "[request] tabType=" + this.duh + " partialExposedObjectId=" + this.rIy.GpO + " h:" + hashCode());
      }
      parama = com.tencent.mm.ui.component.a.KiD;
      com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
      parama = FinderGlobalLocationVM.cOb();
      this.rIy.dAp = ((Number)parama.first).floatValue();
      this.rIy.dyz = ((Number)parama.second).floatValue();
      parama = this.rIy;
      paramc = v.rIR;
      parama.Glv = v.a(paramaqy);
      paramaqy = this.rIy;
      paramc = ((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc();
      parama = paramc;
      if (paramc == null) {
        parama = "";
      }
      paramaqy.sessionId = parama;
      parama = g.ad(PluginFinder.class);
      d.g.b.p.g(parama, "MMKernel.plugin(PluginFinder::class.java)");
      parama = ((PluginFinder)parama).getRedDotManager().Et(this.duh);
      if (parama.Gqn != 0L)
      {
        this.rIy.GpM = parama.Gqn;
        this.rIy.GpN = parama.Gqo;
        ad.i("Finder.CgiFinderTimelineStream", "[request] tabType=" + this.duh + " request with showInfo. objectId=" + com.tencent.mm.ad.c.rc(this.rIy.GpM) + " h:" + hashCode());
      }
      parama = new aln();
      parama.osName = com.tencent.mm.protocal.d.Fng;
      parama.osVersion = com.tencent.mm.protocal.d.Fnh;
      parama.deviceBrand = com.tencent.mm.protocal.d.Fnd;
      parama.deviceModel = com.tencent.mm.protocal.d.Fne;
      parama.Gln = ay.getNetTypeString(aj.getContext());
      paramc = h.soM;
      parama.netType = h.cDz();
      parama.Glo = CdnLogic.getRecentAverageSpeed(2);
      paramc = r.sqN;
      parama.Glp = r.cEe();
      parama.Glq.add("h264");
      if (com.tencent.mm.modelcontrol.d.pf(4)) {
        parama.Glq.add("h265");
      }
      paramc = this.rIy;
      paramaqy = x.skz;
      paramc.Gnv = x.EH(this.duh);
      this.rIy.Gnb = parama;
      parama = com.tencent.mm.plugin.finder.report.d.snS;
      parama = d.a.EK(this.duh);
      if (parama != null) {
        this.rIy.Gpk = parama;
      }
      paramb.c((com.tencent.mm.bx.a)this.rIy);
      parama = new art();
      parama.setBaseResponse(new BaseResponse());
      parama.getBaseResponse().ErrMsg = new cwt();
      paramb.d((com.tencent.mm.bx.a)parama);
      paramb.Dl("/cgi-bin/micromsg-bin/finderstream");
      paramb.oP(3901);
      c(paramb.aDC());
      parama = new StringBuilder("lxl CgiFetchFinderTimeline  tabType=").append(this.duh).append(" init ").append(this.pullType).append(" lastBuffer ");
      if (this.rIy.lastBuffer != null) {
        break label948;
      }
    }
    label948:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramc = parama.append(paramBoolean).append(", ");
      if (this.rIy.lastBuffer != null) {
        break label954;
      }
      parama = Character.valueOf('1');
      ad.i("Finder.CgiFinderTimelineStream", parama + " longitude=" + this.rIy.dAp + " latitude=" + this.rIy.dyz + " h:" + hashCode());
      AppMethodBeat.o(201070);
      return;
      this.rIy.lastBuffer = this.lastBuffer;
      break;
    }
    label954:
    parama = this.rIy.lastBuffer;
    if (parama != null) {}
    for (parama = parama.getBytes();; parama = null)
    {
      parama = com.tencent.mm.sdk.platformtools.ai.B(parama);
      break;
    }
  }
  
  public final boolean cxU()
  {
    return true;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.finder.feed.model.b paramb, int paramInt);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "", "isFetchConsume", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "plugin-finder_release"})
  public static abstract interface c
  {
    public abstract boolean b(cvp paramcvp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.n
 * JD-Core Version:    0.7.0.1
 */