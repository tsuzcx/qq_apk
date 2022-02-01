package com.tencent.mm.plugin.finder.nearby.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ab.c;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.awo;
import com.tencent.mm.protocal.protobuf.awp;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bhx;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.o;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/CgiNearbyLiveFeedStream;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLbsLiveStreamResponse;", "userRequest", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsRequest;", "callback", "Lcom/tencent/mm/plugin/finder/nearby/live/CgiNearbyLiveFeedStream$Callback;", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsRequest;Lcom/tencent/mm/plugin/finder/nearby/live/CgiNearbyLiveFeedStream$Callback;Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "buildRedDotRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLbsLiveStreamRequest;", "buildResponse", "dead", "onCgiEnd", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateFeedSessionBuffer", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "Callback", "Companion", "plugin-finder-nearby_release"})
public final class a
  extends c<awp>
{
  public static final b zDQ;
  private ab.c xaU;
  private final NearbyLiveFeedLoader.b zDO;
  private final a zDP;
  
  static
  {
    AppMethodBeat.i(202029);
    zDQ = new b((byte)0);
    AppMethodBeat.o(202029);
  }
  
  public a(NearbyLiveFeedLoader.b paramb, a parama, ab.c paramc, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(202027);
    this.zDO = paramb;
    this.zDP = parama;
    this.xaU = paramc;
    paramb = new d.a();
    parama = new awo();
    paramc = g.Xox;
    paramc = ((com.tencent.mm.plugin.finder.viewmodel.a)g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class)).dnl();
    parambid = ao.xcj;
    parambid = ao.dnO();
    parambid.scene = this.zDO.xkX;
    parama.RLM = parambid;
    parama.longitude = ((Number)paramc.Mx).floatValue();
    parama.latitude = ((Number)paramc.My).floatValue();
    parama.SDI = this.zDO.lastBuffer;
    parama.SDJ = this.zDO.pullType;
    parama.zDZ = this.zDO.zDZ;
    paramc = this.zDO.zDU;
    if (paramc != null) {
      parama.SJi = paramc;
    }
    Object localObject;
    if ((this.zDO.pullType == 1) && (com.tencent.mm.plugin.finder.nearby.report.d.zJm.OG(this.zDO.xkX)))
    {
      parama.SJh.addAll((Collection)com.tencent.mm.plugin.finder.nearby.report.d.zJm.OF(this.zDO.xkX));
      paramc = parama.SFC;
      parambid = com.tencent.mm.plugin.finder.nearby.report.d.zJm;
      int i = this.zDO.xkX;
      localObject = com.tencent.mm.plugin.finder.nearby.report.d.zJm;
      paramc.addAll((Collection)parambid.gN(i, com.tencent.mm.plugin.finder.nearby.report.d.OH(this.zDO.xkX)));
    }
    paramc = com.tencent.mm.plugin.finder.nearby.live.square.page.a.zGC;
    if (com.tencent.mm.plugin.finder.nearby.live.square.page.a.Ov(this.zDO.xkX))
    {
      Log.i("Finder.CgiNearbyLiveFeedStream", "buildRedDotRequest return for in operation game.");
      paramb.c((com.tencent.mm.cd.a)parama);
      paramc = new awp();
      paramc.setBaseResponse(new jh());
      paramc.getBaseResponse().Tef = new eaf();
      paramb.d((com.tencent.mm.cd.a)paramc);
      paramb.TW("/cgi-bin/micromsg-bin/finderlbslivestream");
      paramb.vD(4026);
      c(paramb.bgN());
      paramc = new StringBuilder("[CgiFetchFinderTimeline#init] commentScene:").append(this.zDO.xkX).append(", pullType=").append(this.zDO.pullType).append(", longitude=").append(parama.longitude).append(" latitude=").append(parama.latitude).append(' ').append("tabInfo:");
      paramb = parama.SJi;
      if (paramb == null) {
        break label878;
      }
      paramb = Integer.valueOf(paramb.SOa);
      label468:
      paramc = paramc.append(paramb).append(" - ");
      paramb = parama.SJi;
      if (paramb == null) {
        break label883;
      }
    }
    label616:
    label878:
    label883:
    for (paramb = paramb.SOb;; paramb = null)
    {
      Log.i("Finder.CgiNearbyLiveFeedStream", paramb + ' ' + "lastBuffer:" + parama.SDI);
      AppMethodBeat.o(202027);
      return;
      if ((this.zDO.pullType != 1) && (this.zDO.pullType != 0) && (this.zDO.pullType != 11) && (this.zDO.pullType != 12)) {
        break;
      }
      paramc = h.ag(PluginFinder.class);
      p.j(paramc, "MMKernel.plugin(PluginFinder::class.java)");
      parambid = ((PluginFinder)paramc).getRedDotManager();
      localObject = parambid.aBi("NearbyLiveTab");
      if (localObject != null)
      {
        bool = true;
        parama.SHq = new awq();
        paramc = parama.SHq;
        if (paramc == null) {
          break;
        }
        if (localObject == null) {
          break label813;
        }
        paramc.SJc = ((bhx)localObject).object_id;
        paramc.SJm = ((bhx)localObject).object_nonce_id;
        paramc.SJd = ((bhx)localObject).tabTipsByPassInfo;
        parambid = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
        if (!com.tencent.mm.plugin.finder.nearby.abtest.a.dLo()) {
          break label803;
        }
        paramc.SJn = "FinderLiveEntrance";
        parambid = new StringBuilder("[buildRedDotRequest] pullType:").append(this.zDO.pullType).append(" isEnterRequest=").append(bool).append(" tab_tips_path=").append(paramc.SJn).append(' ').append(" tabTipsByPassInfo=");
        if (paramc.SJd == null) {
          break label872;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        Log.i("Finder.CgiNearbyLiveFeedStream", bool + ' ' + "objectId=" + com.tencent.mm.ae.d.Fw(paramc.SJc) + ' ');
        break;
        bool = false;
        break label616;
        paramc.SJn = "NearbyEntrance";
        break label686;
        parambid = parambid.aBf("NearbyLiveTab");
        if (parambid == null) {
          break label686;
        }
        parambid = parambid.xuM;
        paramc.SJc = parambid.object_id;
        paramc.SJm = parambid.object_nonce_id;
        paramc.SJd = parambid.tabTipsByPassInfo;
        paramc.SJn = "NearbyLiveTab";
        break label686;
      }
      paramb = null;
      break label468;
    }
  }
  
  public final void dead()
  {
    AppMethodBeat.i(201984);
    super.dead();
    this.xaU = null;
    AppMethodBeat.o(201984);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/CgiNearbyLiveFeedStream$Callback;", "", "onFetchDone", "", "errType", "", "errCode", "errMsg", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderLbsLiveStreamResponse;", "request", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsRequest;", "plugin-finder-nearby_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, awp paramawp, NearbyLiveFeedLoader.b paramb);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/CgiNearbyLiveFeedStream$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.a
 * JD-Core Version:    0.7.0.1
 */