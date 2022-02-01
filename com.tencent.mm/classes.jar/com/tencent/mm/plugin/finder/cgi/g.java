package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.q;
import com.tencent.mm.plugin.finder.report.f;
import com.tencent.mm.plugin.finder.report.f.a;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderStreamPartialExposeUIC;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ahu;
import com.tencent.mm.protocal.protobuf.ali;
import com.tencent.mm.protocal.protobuf.alj;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.dzv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import d.g.b.k;
import d.l;
import d.o;
import d.v;
import java.util.HashMap;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "pullType", "", "tabType", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "useGlobalLastBuffer", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;IILcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protobuf/ByteString;ZLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "isFetchFeedCgi", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Callback", "Companion", "ConsumeCallback", "plugin-finder_release"})
public final class g
  extends an<alj>
{
  public static final b qoA;
  private final int IoU;
  private final boolean KJo;
  private final ali KJu;
  private final com.tencent.mm.bx.b lastBuffer;
  private final int pullType;
  private final c qoo;
  private final a qoy;
  
  static
  {
    AppMethodBeat.i(165175);
    qoA = new b((byte)0);
    AppMethodBeat.o(165175);
  }
  
  public g(a parama, int paramInt1, int paramInt2, c paramc, com.tencent.mm.bx.b paramb, boolean paramBoolean, dzp paramdzp)
  {
    super(paramdzp);
    AppMethodBeat.i(197261);
    this.qoy = parama;
    this.pullType = paramInt1;
    this.IoU = paramInt2;
    this.qoo = paramc;
    this.lastBuffer = paramb;
    this.KJo = paramBoolean;
    this.KJu = new ali();
    if ((this.pullType == 0) && (this.KJo))
    {
      parama = com.tencent.mm.kernel.g.afB();
      k.g(parama, "MMKernel.storage()");
      parama = parama.afk();
      paramc = i.qTa;
      parama.set(i.ahH(this.IoU), null);
    }
    paramb = new b.a();
    long l;
    if (this.KJo)
    {
      parama = com.tencent.mm.kernel.g.afB();
      k.g(parama, "MMKernel.storage()");
      parama = parama.afk();
      paramc = i.qTa;
      parama = parama.get(i.ahH(this.IoU), "");
      if (parama == null)
      {
        parama = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(197261);
        throw parama;
      }
      parama = bt.aGd((String)parama);
      this.KJu.lastBuffer = com.tencent.mm.bx.b.cd(parama);
      this.KJu.pullType = this.pullType;
      this.KJu.IoU = this.IoU;
      if ((this.pullType == 1) && ((this.IoU == 1) || (this.IoU == 3) || (this.IoU == 4)))
      {
        parama = this.KJu;
        paramc = FinderStreamPartialExposeUIC.Ljo;
        paramInt1 = this.IoU;
        paramc = (Long)FinderStreamPartialExposeUIC.fXx().remove(Integer.valueOf(paramInt1));
        if (paramc == null) {
          break label976;
        }
        l = paramc.longValue();
        label293:
        parama.Lyp = l;
        ad.i("Finder.CgiFinderTimelineStream", "[request] tabType=" + this.IoU + " partialExposedObjectId=" + this.KJu.Lyp + " h:" + hashCode());
      }
      parama = com.tencent.mm.ui.component.a.LCX;
      com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderGlobalLocationVM.class);
      parama = FinderGlobalLocationVM.fXf();
      this.KJu.dqQ = ((Number)parama.first).floatValue();
      this.KJu.dpb = ((Number)parama.second).floatValue();
      parama = this.KJu;
      paramc = am.KJy;
      parama.Dkw = am.a(paramdzp);
      paramdzp = this.KJu;
      paramc = ((com.tencent.mm.plugin.expt.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
      parama = paramc;
      if (paramc == null) {
        parama = "";
      }
      paramdzp.sessionId = parama;
      parama = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      k.g(parama, "MMKernel.plugin(PluginFinder::class.java)");
      parama = ((PluginFinder)parama).getRedDotManager().ahi(this.IoU);
      if (parama.Lyz != 0L)
      {
        this.KJu.Lyn = parama.Lyz;
        this.KJu.Lyo = parama.LyA;
        ad.i("Finder.CgiFinderTimelineStream", "[request] tabType=" + this.IoU + " request with showInfo. objectId=" + com.tencent.mm.ad.c.ly(this.KJu.Lyn) + " h:" + hashCode());
      }
      parama = new ahu();
      parama.osName = com.tencent.mm.protocal.d.CpH;
      parama.osVersion = com.tencent.mm.protocal.d.CpI;
      parama.deviceBrand = com.tencent.mm.protocal.d.CpE;
      parama.deviceModel = com.tencent.mm.protocal.d.CpF;
      parama.Dkp = ay.getNetTypeString(aj.getContext());
      paramc = com.tencent.mm.plugin.finder.report.b.qFq;
      parama.netType = com.tencent.mm.plugin.finder.report.b.fTW();
      parama.Dkq = CdnLogic.getRecentAverageSpeed(2);
      paramc = com.tencent.mm.plugin.finder.report.g.qGu;
      parama.Dkr = com.tencent.mm.plugin.finder.report.g.fTX();
      parama.Dks.add("h264");
      if (com.tencent.mm.modelcontrol.d.nQ(4)) {
        parama.Dks.add("h265");
      }
      paramc = this.KJu;
      paramdzp = q.qDO;
      paramc.DlG = q.ahm(this.IoU);
      this.KJu.DmA = parama;
      parama = f.KUD;
      parama = f.a.ahn(this.IoU);
      if (parama != null) {
        this.KJu.Dmz = parama;
      }
      paramb.c((com.tencent.mm.bx.a)this.KJu);
      parama = new alj();
      parama.setBaseResponse(new BaseResponse());
      parama.getBaseResponse().ErrMsg = new cmf();
      paramb.d((com.tencent.mm.bx.a)parama);
      paramb.wg("/cgi-bin/micromsg-bin/finderstream");
      paramb.nB(3901);
      c(paramb.atI());
      parama = new StringBuilder("lxl CgiFetchFinderTimeline  tabType=").append(this.IoU).append(" init ").append(this.pullType).append(" lastBuffer ");
      if (this.KJu.lastBuffer != null) {
        break label982;
      }
    }
    label976:
    label982:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramc = parama.append(paramBoolean).append(", ");
      if (this.KJu.lastBuffer != null) {
        break label988;
      }
      parama = Character.valueOf('1');
      ad.i("Finder.CgiFinderTimelineStream", parama + " longitude=" + this.KJu.dqQ + " latitude=" + this.KJu.dpb + " h:" + hashCode());
      AppMethodBeat.o(197261);
      return;
      this.KJu.lastBuffer = this.lastBuffer;
      break;
      l = 0L;
      break label293;
    }
    label988:
    parama = this.KJu.lastBuffer;
    if (parama != null) {}
    for (parama = parama.getBytes();; parama = null)
    {
      parama = ai.D(parama);
      break;
    }
  }
  
  public final boolean fRR()
  {
    return true;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/FetchFinderTimelineInfo;", "pullType", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.finder.feed.model.c paramc, int paramInt);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "", "isFetchConsume", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "plugin-finder_release"})
  public static abstract interface c
  {
    public abstract boolean b(int paramInt1, int paramInt2, cld paramcld);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.g
 * JD-Core Version:    0.7.0.1
 */