package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.report.g.a;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderStreamPartialExposeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderStreamPartialExposeUIC.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.apc;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "pullType", "", "tabType", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "useGlobalLastBuffer", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;IILcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protobuf/ByteString;ZLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "isFetchFeedCgi", "onCgiEnd", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Callback", "Companion", "ConsumeCallback", "plugin-finder_release"})
public final class ab
  extends an<bda>
{
  public static final b tub;
  private final int dLS;
  private final com.tencent.mm.bw.b lastBuffer;
  private final int pullType;
  private final bcz ttZ;
  private final c ttd;
  private final boolean tte;
  private final a tua;
  
  static
  {
    AppMethodBeat.i(165175);
    tub = new b((byte)0);
    AppMethodBeat.o(165175);
  }
  
  public ab(a parama, int paramInt1, int paramInt2, c paramc, com.tencent.mm.bw.b paramb, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242292);
    this.tua = parama;
    this.pullType = paramInt1;
    this.dLS = paramInt2;
    this.ttd = paramc;
    this.lastBuffer = paramb;
    this.tte = false;
    this.ttZ = new bcz();
    if ((this.pullType == 0) && (this.tte))
    {
      parama = com.tencent.mm.kernel.g.aAh();
      p.g(parama, "MMKernel.storage()");
      parama = parama.azQ();
      paramc = y.vXH;
      parama.set(y.LK(this.dLS), null);
    }
    paramb = new d.a();
    if (this.tte)
    {
      parama = com.tencent.mm.kernel.g.aAh();
      p.g(parama, "MMKernel.storage()");
      parama = parama.azQ();
      paramc = y.vXH;
      parama = parama.get(y.LK(this.dLS), "");
      if (parama == null)
      {
        parama = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(242292);
        throw parama;
      }
      parama = Util.decodeHexString((String)parama);
      this.ttZ.lastBuffer = com.tencent.mm.bw.b.cD(parama);
      this.ttZ.pullType = this.pullType;
      this.ttZ.dLS = this.dLS;
      if ((this.pullType == 1) && ((this.dLS == 1) || (this.dLS == 3) || (this.dLS == 4)))
      {
        parama = this.ttZ;
        paramc = FinderStreamPartialExposeUIC.wAt;
        parama.LMz = FinderStreamPartialExposeUIC.a.MH(this.dLS);
        Log.i("Finder.CgiFinderTimelineStream", "[request] tabType=" + this.dLS + " partialExposedObjectId=" + this.ttZ.LMz + " h:" + hashCode());
      }
      parama = com.tencent.mm.ui.component.a.PRN;
      com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
      parama = FinderGlobalLocationVM.dHP();
      this.ttZ.dTj = ((Number)parama.first).floatValue();
      this.ttZ.latitude = ((Number)parama.second).floatValue();
      parama = this.ttZ;
      paramc = am.tuw;
      parama.uli = am.a(parambbn);
      parambbn = this.ttZ;
      paramc = ((c)com.tencent.mm.kernel.g.af(c.class)).cMD();
      parama = paramc;
      if (paramc == null) {
        parama = "";
      }
      parambbn.sessionId = parama;
      parama = com.tencent.mm.kernel.g.ah(PluginFinder.class);
      p.g(parama, "MMKernel.plugin(PluginFinder::class.java)");
      parama = ((PluginFinder)parama).getRedDotManager().IA(this.dLS);
      if (parama.object_id != 0L)
      {
        this.ttZ.LMx = parama.object_id;
        this.ttZ.LMy = parama.object_nonce_id;
        Log.i("Finder.CgiFinderTimelineStream", "[request] tabType=" + this.dLS + " request with showInfo. objectId=" + com.tencent.mm.ac.d.zs(this.ttZ.LMx) + " h:" + hashCode());
      }
      parama = new apc();
      parama.osName = com.tencent.mm.protocal.d.KyL;
      parama.osVersion = com.tencent.mm.protocal.d.KyM;
      parama.deviceBrand = com.tencent.mm.protocal.d.KyI;
      parama.deviceModel = com.tencent.mm.protocal.d.KyJ;
      parama.LBe = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
      paramc = k.vfA;
      parama.netType = k.dod();
      parama.LBf = CdnLogic.getRecentAverageSpeed(2);
      paramc = com.tencent.mm.plugin.finder.video.reporter.b.whK;
      parama.LBg = com.tencent.mm.plugin.finder.video.reporter.b.dFY();
      parama.LBh.add("h264");
      if (com.tencent.mm.modelcontrol.e.sX(4)) {
        parama.LBh.add("h265");
      }
      paramc = this.ttZ;
      parambbn = as.uOL;
      paramc.LIs = as.Jt(this.dLS);
      this.ttZ.LAv = parama;
      parama = com.tencent.mm.plugin.finder.report.g.vek;
      parama = g.a.Kc(this.dLS);
      if (parama != null) {
        this.ttZ.LEw = parama;
      }
      paramb.c((com.tencent.mm.bw.a)this.ttZ);
      parama = new bda();
      parama.setBaseResponse(new BaseResponse());
      parama.getBaseResponse().ErrMsg = new dqi();
      paramb.d((com.tencent.mm.bw.a)parama);
      paramb.MB("/cgi-bin/micromsg-bin/finderstream");
      paramb.sG(3901);
      c(paramb.aXF());
      parama = new StringBuilder("lxl CgiFetchFinderTimeline  tabType=").append(this.dLS).append(" init ").append(this.pullType).append(" lastBuffer ");
      if (this.ttZ.lastBuffer != null) {
        break label947;
      }
    }
    label947:
    for (boolean bool = true;; bool = false)
    {
      paramc = parama.append(bool).append(", ");
      if (this.ttZ.lastBuffer != null) {
        break label953;
      }
      parama = Character.valueOf('1');
      Log.i("Finder.CgiFinderTimelineStream", parama + " longitude=" + this.ttZ.dTj + " latitude=" + this.ttZ.latitude + " h:" + hashCode());
      AppMethodBeat.o(242292);
      return;
      this.ttZ.lastBuffer = this.lastBuffer;
      break;
    }
    label953:
    parama = this.ttZ.lastBuffer;
    if (parama != null) {}
    for (parama = parama.zy;; parama = null)
    {
      parama = MD5Util.getMD5String(parama);
      break;
    }
  }
  
  public final boolean cXQ()
  {
    return true;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.finder.feed.model.b paramb, int paramInt);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "", "isFetchConsume", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "plugin-finder_release"})
  public static abstract interface c
  {
    public abstract boolean b(dpc paramdpc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ab
 * JD-Core Version:    0.7.0.1
 */