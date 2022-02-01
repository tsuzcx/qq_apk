package com.tencent.mm.plugin.finder.cgi;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.au;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.report.i.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.am;
import com.tencent.mm.plugin.finder.viewmodel.component.am.a;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.aqo;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bjv;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "pullType", "", "tabType", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "useGlobalLastBuffer", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;IILcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protobuf/ByteString;ZLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "isFetchFeedCgi", "onCgiEnd", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Callback", "Companion", "ConsumeCallback", "plugin-finder_release"})
public final class ab
  extends com.tencent.mm.plugin.findersdk.b.c<bjw>
{
  public static final b xbH;
  private final int fEH;
  private final com.tencent.mm.cd.b lastBuffer;
  private final int pullType;
  private final c xaU;
  private final boolean xaV;
  private final bjv xbF;
  private final a xbG;
  
  static
  {
    AppMethodBeat.i(165175);
    xbH = new b((byte)0);
    AppMethodBeat.o(165175);
  }
  
  public ab(a parama, int paramInt1, int paramInt2, c paramc, com.tencent.mm.cd.b paramb, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(223674);
    this.xbG = parama;
    this.pullType = paramInt1;
    this.fEH = paramInt2;
    this.xaU = paramc;
    this.lastBuffer = paramb;
    this.xaV = false;
    this.xbF = new bjv();
    if ((this.pullType == 0) && (this.xaV))
    {
      parama = h.aHG();
      p.j(parama, "MMKernel.storage()");
      parama = parama.aHp();
      paramc = aj.AGc;
      parama.set(aj.QX(this.fEH), null);
    }
    paramb = new d.a();
    if (this.xaV)
    {
      parama = h.aHG();
      p.j(parama, "MMKernel.storage()");
      parama = parama.aHp();
      paramc = aj.AGc;
      parama = parama.get(aj.QX(this.fEH), "");
      if (parama == null)
      {
        parama = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(223674);
        throw parama;
      }
      parama = Util.decodeHexString((String)parama);
      this.xbF.lastBuffer = com.tencent.mm.cd.b.cU(parama);
      this.xbF.pullType = this.pullType;
      this.xbF.fEH = this.fEH;
      if ((this.pullType == 1) && ((this.fEH == 1) || (this.fEH == 3) || (this.fEH == 4)))
      {
        parama = this.xbF;
        paramc = am.BoE;
        parama.SUy = am.a.Sb(this.fEH);
        Log.i("Finder.CgiFinderTimelineStream", "[request] tabType=" + this.fEH + " partialExposedObjectId=" + this.xbF.SUy + " h:" + hashCode());
      }
      parama = g.Xox;
      parama = ((com.tencent.mm.plugin.finder.viewmodel.a)g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class)).dnl();
      this.xbF.longitude = ((Number)parama.Mx).floatValue();
      this.xbF.latitude = ((Number)parama.My).floatValue();
      parama = this.xbF;
      paramc = ao.xcj;
      parama.yjp = ao.a(parambid);
      parambid = this.xbF;
      paramc = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
      parama = paramc;
      if (paramc == null) {
        parama = "";
      }
      parambid.sessionId = parama;
      parama = h.ag(PluginFinder.class);
      p.j(parama, "MMKernel.plugin(PluginFinder::class.java)");
      parama = ((PluginFinder)parama).getRedDotManager().Mr(this.fEH);
      if (parama.object_id != 0L)
      {
        this.xbF.SUw = parama.object_id;
        this.xbF.SUx = parama.object_nonce_id;
        Log.i("Finder.CgiFinderTimelineStream", "[request] tabType=" + this.fEH + " request with showInfo. objectId=" + com.tencent.mm.ae.d.Fw(this.xbF.SUw) + " h:" + hashCode());
      }
      parama = new aqo();
      parama.osName = com.tencent.mm.protocal.d.RAz;
      parama.osVersion = com.tencent.mm.protocal.d.RAA;
      parama.deviceBrand = com.tencent.mm.protocal.d.RAw;
      parama.deviceModel = com.tencent.mm.protocal.d.RAx;
      parama.SDN = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
      paramc = n.zWF;
      parama.netType = n.bvR();
      parama.SDO = CdnLogic.getRecentAverageSpeed(2);
      parama.SDP = ((com.tencent.mm.plugin.b)h.ae(com.tencent.mm.plugin.b.class)).bvN();
      parama.SDQ.add("h264");
      if (e.vW(4)) {
        parama.SDQ.add("h265");
      }
      paramc = this.xbF;
      parambid = au.zBf;
      paramc.SPe = au.Og(this.fEH);
      this.xbF.SCW = parama;
      parama = i.zVp;
      parama = i.a.Pg(this.fEH);
      if (parama != null) {
        this.xbF.SFB = parama;
      }
      paramb.c((com.tencent.mm.cd.a)this.xbF);
      parama = new bjw();
      parama.setBaseResponse(new jh());
      parama.getBaseResponse().Tef = new eaf();
      paramb.d((com.tencent.mm.cd.a)parama);
      paramb.TW("/cgi-bin/micromsg-bin/finderstream");
      paramb.vD(3901);
      c(paramb.bgN());
      parama = new StringBuilder("lxl CgiFetchFinderTimeline  tabType=").append(this.fEH).append(" init ").append(this.pullType).append(" lastBuffer ");
      if (this.xbF.lastBuffer != null) {
        break label955;
      }
    }
    label955:
    for (boolean bool = true;; bool = false)
    {
      paramc = parama.append(bool).append(", ");
      if (this.xbF.lastBuffer != null) {
        break label961;
      }
      parama = Character.valueOf('1');
      Log.i("Finder.CgiFinderTimelineStream", parama + " longitude=" + this.xbF.longitude + " latitude=" + this.xbF.latitude + " h:" + hashCode());
      AppMethodBeat.o(223674);
      return;
      this.xbF.lastBuffer = this.lastBuffer;
      break;
    }
    label961:
    parama = this.xbF.lastBuffer;
    if (parama != null) {}
    for (parama = parama.UH;; parama = null)
    {
      parama = MD5Util.getMD5String(parama);
      break;
    }
  }
  
  public final boolean dnD()
  {
    return true;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.finder.feed.model.d paramd, int paramInt);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "", "isFetchConsume", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "plugin-finder_release"})
  public static abstract interface c
  {
    public abstract boolean b(dyy paramdyy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ab
 * JD-Core Version:    0.7.0.1
 */