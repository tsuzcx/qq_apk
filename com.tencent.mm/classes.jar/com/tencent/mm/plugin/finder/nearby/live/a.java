package com.tencent.mm.plugin.finder.nearby.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.c.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.finder.nearby.report.e;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.bck;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.protocal.protobuf.yf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/CgiNearbyLiveFeedStream;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLbsLiveStreamResponse;", "userRequest", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsRequest;", "callback", "Lcom/tencent/mm/plugin/finder/nearby/live/CgiNearbyLiveFeedStream$Callback;", "consume", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$CgiConsumeCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsRequest;Lcom/tencent/mm/plugin/finder/nearby/live/CgiNearbyLiveFeedStream$Callback;Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$CgiConsumeCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "buildRedDotRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLbsLiveStreamRequest;", "buildResponse", "dead", "onCgiEnd", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateFeedSessionBuffer", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "Callback", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c<bck>
{
  public static final b EIi;
  private static boolean akhs;
  private final NearbyLiveFeedLoader.c EIj;
  private final a EIk;
  private NearbyLiveFeedLoader.a EIl;
  
  static
  {
    AppMethodBeat.i(340640);
    EIi = new b((byte)0);
    AppMethodBeat.o(340640);
  }
  
  public a(NearbyLiveFeedLoader.c paramc, a parama, NearbyLiveFeedLoader.a parama1, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(340635);
    this.EIj = paramc;
    this.EIk = parama;
    this.EIl = parama1;
    akhs = false;
    paramc = new c.a();
    parama = new bcj();
    parama1 = k.aeZF;
    parama1 = ((com.tencent.mm.plugin.finder.viewmodel.b)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class)).dUh();
    parambui = bi.ABn;
    parambui = bi.dVu();
    parambui.scene = this.EIj.AJo;
    Object localObject = ah.aiuX;
    parama.YIY = parambui;
    parama.longitude = ((Number)parama1.bsC).floatValue();
    parama.latitude = ((Number)parama1.bsD).floatValue();
    parama.ZEQ = this.EIj.lastBuffer;
    parama.ZER = this.EIj.pullType;
    parama.EIo = this.EIj.EIo;
    parama.EIF = this.EIj.EIF;
    parama.ZNu = this.EIj.EIG;
    parama1 = this.EIj.EIq;
    if (parama1 != null) {
      parama.ZNs = parama1;
    }
    int i;
    if ((this.EIj.pullType == 1) && (e.EQU.Rh(this.EIj.AJo)))
    {
      parama.ZNr.addAll((Collection)e.EQU.Rg(this.EIj.AJo));
      parama1 = parama.ZHF;
      parambui = e.EQU;
      i = this.EIj.AJo;
      localObject = e.EQU;
      parama1.addAll((Collection)parambui.hY(i, e.Ri(this.EIj.AJo)));
    }
    parama1 = aw.Gjk;
    parama.ZKH = aw.fgv();
    if (((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).isNewLiveEntranceEnable())
    {
      i = 0;
      parama.akkJ = i;
      parama1 = com.tencent.mm.plugin.finder.nearby.live.square.page.b.ELW;
      if (!com.tencent.mm.plugin.finder.nearby.live.square.page.b.QN(this.EIj.AJo)) {
        break label654;
      }
      Log.i("Finder.CgiNearbyLiveFeedStream", "buildRedDotRequest return for in operation game.");
      label375:
      paramc.otE = ((com.tencent.mm.bx.a)parama);
      parama1 = new bck();
      parama1.setBaseResponse(new kd());
      parama1.getBaseResponse().akjO = new etl();
      paramc.otF = ((com.tencent.mm.bx.a)parama1);
      paramc.uri = "/cgi-bin/micromsg-bin/finderlbslivestream";
      paramc.funcId = 4026;
      c(paramc.bEF());
      parama1 = new StringBuilder("[CgiFetchFinderTimeline#init] commentScene:").append(this.EIj.AJo).append(", pullType=").append(this.EIj.pullType).append(", only_follow_feed:").append(this.EIj.EIF).append(" longitude=").append(parama.longitude).append(" latitude=").append(parama.latitude).append(" tabInfo:");
      paramc = parama.ZNs;
      if (paramc != null) {
        break label1007;
      }
      paramc = null;
      label543:
      parama1 = parama1.append(paramc).append(" - ");
      paramc = parama.ZNs;
      if (paramc != null) {
        break label1018;
      }
      paramc = null;
      label566:
      parama1 = parama1.append(paramc).append(" related_object_id:").append(parama.ZNu).append(",lastBuffer:").append(parama.ZEQ).append(",speed=");
      paramc = parama.ZKH;
      if (paramc != null) {
        break label1026;
      }
      paramc = null;
    }
    for (;;)
    {
      Log.i("Finder.CgiNearbyLiveFeedStream", paramc + " need_banner_card_style:" + parama.akkJ);
      AppMethodBeat.o(340635);
      return;
      i = 1;
      break;
      label654:
      if ((this.EIj.pullType != 1) && (this.EIj.pullType != 0) && (this.EIj.pullType != 11) && (this.EIj.pullType != 12) && (this.EIj.pullType != 14) && (this.EIj.pullType != 15)) {
        break label375;
      }
      parambui = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
      localObject = parambui.avs("NearbyLiveTab");
      if (localObject != null)
      {
        bool = true;
        label754:
        parama.ZKE = new bcl();
        parama1 = parama.ZKE;
        if (parama1 == null) {
          break label375;
        }
        if (localObject == null) {
          break label942;
        }
        parama1.ZNj = ((btx)localObject).object_id;
        parama1.ZNw = ((btx)localObject).object_nonce_id;
        parama1.ZwY = ((btx)localObject).tabTipsByPassInfo;
        parambui = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
        if (!com.tencent.mm.plugin.finder.nearby.abtest.a.eEi()) {
          break label932;
        }
        parama1.ZNx = "FinderLiveEntrance";
        label824:
        parambui = new StringBuilder("[buildRedDotRequest] pullType:").append(this.EIj.pullType).append(" isEnterRequest=").append(bool).append(" tab_tips_path=").append(parama1.ZNx).append("  tabTipsByPassInfo=");
        if (parama1.ZwY == null) {
          break label1001;
        }
      }
      label932:
      label942:
      label1001:
      for (boolean bool = true;; bool = false)
      {
        Log.i("Finder.CgiNearbyLiveFeedStream", bool + " objectId=" + d.hF(parama1.ZNj) + ' ');
        break;
        bool = false;
        break label754;
        parama1.ZNx = "NearbyEntrance";
        break label824;
        parambui = parambui.Su("NearbyLiveTab");
        if (parambui == null) {
          break label824;
        }
        parambui = parambui.ASz;
        parama1.ZNj = parambui.object_id;
        parama1.ZNw = parambui.object_nonce_id;
        parama1.ZwY = parambui.tabTipsByPassInfo;
        parama1.ZNx = "NearbyLiveTab";
        break label824;
      }
      label1007:
      paramc = Integer.valueOf(paramc.ZVZ);
      break label543;
      label1018:
      paramc = paramc.ZWa;
      break label566;
      label1026:
      paramc = paramc.ZPF;
      if (paramc == null) {
        paramc = null;
      } else {
        paramc = Integer.valueOf(paramc.ZPE);
      }
    }
  }
  
  public final void dead()
  {
    AppMethodBeat.i(340649);
    super.dead();
    this.EIl = null;
    AppMethodBeat.o(340649);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/CgiNearbyLiveFeedStream$Callback;", "", "onFetchDone", "", "errType", "", "errCode", "errMsg", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderLbsLiveStreamResponse;", "request", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader$FinderLiveFriendsRequest;", "cgiProfile", "Lcom/tencent/mm/protocal/protobuf/CgiProfile;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, bck parambck, NearbyLiveFeedLoader.c paramc, yf paramyf);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/CgiNearbyLiveFeedStream$Companion;", "", "()V", "TAG", "", "skip_feeds_report", "", "getSkip_feeds_report", "()Z", "setSkip_feeds_report", "(Z)V", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.a
 * JD-Core Version:    0.7.0.1
 */