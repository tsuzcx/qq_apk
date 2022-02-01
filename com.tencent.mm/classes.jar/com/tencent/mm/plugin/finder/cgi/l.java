package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.m;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderStreamPartialExposeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderStreamPartialExposeUIC.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aix;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aod;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.aom;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import d.g.b.k;
import d.o;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "pullType", "", "tabType", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "useGlobalLastBuffer", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;IILcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protobuf/ByteString;ZLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "isFetchFeedCgi", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Callback", "Companion", "ConsumeCallback", "plugin-finder_release"})
public final class l
  extends r<aoe>
{
  public static final l.b qXt;
  private final int diw;
  private final com.tencent.mm.bw.b lastBuffer;
  private final int pullType;
  private final l.c qWQ;
  private final boolean qWR;
  private final aod qXr;
  private final l.a qXs;
  
  static
  {
    AppMethodBeat.i(165175);
    qXt = new l.b((byte)0);
    AppMethodBeat.o(165175);
  }
  
  public l(l.a parama, int paramInt1, int paramInt2, l.c paramc, com.tencent.mm.bw.b paramb, boolean paramBoolean, anm paramanm)
  {
    super(paramanm);
    AppMethodBeat.i(201138);
    this.qXs = parama;
    this.pullType = paramInt1;
    this.diw = paramInt2;
    this.qWQ = paramc;
    this.lastBuffer = paramb;
    this.qWR = paramBoolean;
    this.qXr = new aod();
    if ((this.pullType == 0) && (this.qWR))
    {
      parama = g.agR();
      k.g(parama, "MMKernel.storage()");
      parama = parama.agA();
      paramc = n.rPN;
      parama.set(n.EI(this.diw), null);
    }
    paramb = new com.tencent.mm.ak.b.a();
    if (this.qWR)
    {
      parama = g.agR();
      k.g(parama, "MMKernel.storage()");
      parama = parama.agA();
      paramc = n.rPN;
      parama = parama.get(n.EI(this.diw), "");
      if (parama == null)
      {
        parama = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(201138);
        throw parama;
      }
      parama = bs.aLu((String)parama);
      this.qXr.lastBuffer = com.tencent.mm.bw.b.cc(parama);
      this.qXr.pullType = this.pullType;
      this.qXr.diw = this.diw;
      if ((this.pullType == 1) && ((this.diw == 1) || (this.diw == 3) || (this.diw == 4)))
      {
        parama = this.qXr;
        paramc = FinderStreamPartialExposeUIC.seU;
        parama.EHf = FinderStreamPartialExposeUIC.a.Fk(this.diw);
        ac.i("Finder.CgiFinderTimelineStream", "[request] tabType=" + this.diw + " partialExposedObjectId=" + this.qXr.EHf + " h:" + hashCode());
      }
      parama = com.tencent.mm.ui.component.a.IrY;
      com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderGlobalLocationVM.class);
      parama = FinderGlobalLocationVM.cFH();
      this.qXr.doB = ((Number)parama.first).floatValue();
      this.qXr.dmL = ((Number)parama.second).floatValue();
      parama = this.qXr;
      paramc = q.qXH;
      parama.EDL = q.a(paramanm);
      paramanm = this.qXr;
      paramc = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
      parama = paramc;
      if (paramc == null) {
        parama = "";
      }
      paramanm.sessionId = parama;
      parama = g.ad(PluginFinder.class);
      k.g(parama, "MMKernel.plugin(PluginFinder::class.java)");
      parama = ((PluginFinder)parama).getRedDotManager().DA(this.diw);
      if (parama.EHA != 0L)
      {
        this.qXr.EHd = parama.EHA;
        this.qXr.EHe = parama.EHB;
        ac.i("Finder.CgiFinderTimelineStream", "[request] tabType=" + this.diw + " request with showInfo. objectId=" + com.tencent.mm.ac.c.pb(this.qXr.EHd) + " h:" + hashCode());
      }
      parama = new aix();
      parama.osName = com.tencent.mm.protocal.d.DHZ;
      parama.osVersion = com.tencent.mm.protocal.d.DIa;
      parama.deviceBrand = com.tencent.mm.protocal.d.DHW;
      parama.deviceModel = com.tencent.mm.protocal.d.DHX;
      parama.EDD = ax.getNetTypeString(ai.getContext());
      paramc = com.tencent.mm.plugin.finder.report.d.rxr;
      parama.netType = com.tencent.mm.plugin.finder.report.d.cwU();
      parama.EDE = CdnLogic.getRecentAverageSpeed(2);
      paramc = m.rzd;
      parama.EDF = m.cxo();
      parama.EDG.add("h264");
      if (com.tencent.mm.modelcontrol.d.oE(4)) {
        parama.EDG.add("h265");
      }
      paramc = this.qXr;
      paramanm = com.tencent.mm.plugin.finder.model.v.rve;
      paramc.EFn = com.tencent.mm.plugin.finder.model.v.DN(this.diw);
      this.qXr.EEW = parama;
      parama = com.tencent.mm.plugin.finder.report.b.rxc;
      parama = com.tencent.mm.plugin.finder.report.b.a.DQ(this.diw);
      if (parama != null) {
        this.qXr.EGL = parama;
      }
      paramb.c((com.tencent.mm.bw.a)this.qXr);
      parama = new aoe();
      parama.setBaseResponse(new BaseResponse());
      parama.getBaseResponse().ErrMsg = new crm();
      paramb.d((com.tencent.mm.bw.a)parama);
      paramb.Am("/cgi-bin/micromsg-bin/finderstream");
      paramb.op(3901);
      c(paramb.aAz());
      parama = new StringBuilder("lxl CgiFetchFinderTimeline  tabType=").append(this.diw).append(" init ").append(this.pullType).append(" lastBuffer ");
      if (this.qXr.lastBuffer != null) {
        break label948;
      }
    }
    label948:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramc = parama.append(paramBoolean).append(", ");
      if (this.qXr.lastBuffer != null) {
        break label954;
      }
      parama = Character.valueOf('1');
      ac.i("Finder.CgiFinderTimelineStream", parama + " longitude=" + this.qXr.doB + " latitude=" + this.qXr.dmL + " h:" + hashCode());
      AppMethodBeat.o(201138);
      return;
      this.qXr.lastBuffer = this.lastBuffer;
      break;
    }
    label954:
    parama = this.qXr.lastBuffer;
    if (parama != null) {}
    for (parama = parama.getBytes();; parama = null)
    {
      parama = ah.B(parama);
      break;
    }
  }
  
  public final boolean csf()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.l
 * JD-Core Version:    0.7.0.1
 */