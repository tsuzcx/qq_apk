package com.tencent.mm.plugin.finder.nearby.newlivesquare.net.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.c.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/net/cgi/CgiFinderNavLiveStream;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderNavLiveStreamResponse;", "userRequest", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/net/cgi/CgiFinderNavLiveStream$LiveEntranceRequest;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/net/cgi/CgiFinderNavLiveStream$LiveEntranceRequest;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "buildRedDotRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderNavLiveStreamRequest;", "buildResponse", "getKey", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "LiveEntranceRequest", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c<bqr>
{
  public static final a EOD;
  private final a.b EOE;
  
  static
  {
    AppMethodBeat.i(340299);
    EOD = new a((byte)0);
    AppMethodBeat.o(340299);
  }
  
  private a(a.b paramb)
  {
    super(null);
    AppMethodBeat.i(340288);
    this.EOE = paramb;
    Object localObject1 = new c.a();
    paramb = new bqq();
    Object localObject2 = bi.ABn;
    localObject2 = bi.dVu();
    ((atz)localObject2).scene = this.EOE.AJo;
    Object localObject3 = ah.aiuX;
    paramb.YIY = ((atz)localObject2);
    paramb.ZEQ = this.EOE.lastBuffer;
    localObject2 = k.aeZF;
    localObject2 = ((com.tencent.mm.plugin.finder.viewmodel.b)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class)).dUh();
    paramb.longitude = ((Number)((r)localObject2).bsC).floatValue();
    paramb.latitude = ((Number)((r)localObject2).bsD).floatValue();
    localObject2 = bi.ABn;
    paramb.ZDQ = bi.bTZ();
    paramb.ZER = this.EOE.pullType;
    paramb.EIo = "";
    localObject2 = aw.Gjk;
    paramb.ZKH = aw.fgv();
    localObject2 = com.tencent.mm.plugin.finder.nearby.live.square.page.b.ELW;
    if (com.tencent.mm.plugin.finder.nearby.live.square.page.b.QN(this.EOE.AJo))
    {
      Log.i("Finder.CgiFinderNavLiveStream", "buildRedDotRequest return for in operation game.");
      paramb.iaK = this.EOE.fromScene;
      paramb.ZNu = this.EOE.EIG;
      paramb.Zpm = this.EOE.EOG;
      paramb.ZYA.addAll((Collection)this.EOE.EOH);
      ((c.a)localObject1).otE = ((com.tencent.mm.bx.a)paramb);
      localObject2 = new bqr();
      ((bqr)localObject2).setBaseResponse(new kd());
      ((bqr)localObject2).getBaseResponse().akjO = new etl();
      ((c.a)localObject1).otF = ((com.tencent.mm.bx.a)localObject2);
      ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/findernavlivestream";
      ((c.a)localObject1).funcId = 7312;
      c(((c.a)localObject1).bEF());
      localObject1 = new StringBuilder("[CgiFetchFinderTimeline#init] commentScene:").append(this.EOE.AJo).append(", pullType=").append(this.EOE.pullType).append(", longitude=").append(paramb.longitude).append(" latitude=").append(paramb.latitude).append(" lastBuffer:").append(paramb.ZEQ).append(",speed=");
      paramb = paramb.ZKH;
      if (paramb != null) {
        break label753;
      }
      paramb = null;
    }
    for (;;)
    {
      Log.i("Finder.CgiFinderNavLiveStream", paramb);
      AppMethodBeat.o(340288);
      return;
      if ((this.EOE.pullType != 1) && (this.EOE.pullType != 0) && (this.EOE.pullType != 3) && (this.EOE.pullType != 11) && (this.EOE.pullType != 12) && (this.EOE.pullType != 14) && (this.EOE.pullType != 15)) {
        break;
      }
      localObject3 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avs("NearbyLiveTab");
      if (localObject3 != null)
      {
        bool1 = true;
        label555:
        paramb.ZKE = new bcl();
        localObject2 = paramb.ZKE;
        if (localObject2 == null) {
          break;
        }
        if (localObject3 != null)
        {
          ((bcl)localObject2).ZNj = ((btx)localObject3).object_id;
          ((bcl)localObject2).ZNw = ((btx)localObject3).object_nonce_id;
          ((bcl)localObject2).ZwY = ((btx)localObject3).tabTipsByPassInfo;
          localObject3 = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
          if (!com.tencent.mm.plugin.finder.nearby.abtest.a.eEi()) {
            break label737;
          }
          ((bcl)localObject2).ZNx = "FinderLiveEntrance";
        }
        label631:
        localObject3 = new StringBuilder("[buildRedDotRequest] pullType:").append(this.EOE.pullType).append(" isEnterRequest=").append(bool1).append(" tab_tips_path=").append(((bcl)localObject2).ZNx).append("  tabTipsByPassInfo=");
        if (((bcl)localObject2).ZwY == null) {
          break label748;
        }
      }
      label737:
      label748:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Log.i("Finder.CgiFinderNavLiveStream", bool1 + " objectId=" + d.hF(((bcl)localObject2).ZNj) + ' ');
        break;
        bool1 = false;
        break label555;
        ((bcl)localObject2).ZNx = "NearbyEntrance";
        break label631;
      }
      label753:
      paramb = paramb.ZPF;
      if (paramb == null) {
        paramb = null;
      } else {
        paramb = Integer.valueOf(paramb.ZPE);
      }
    }
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(340304);
    int j = this.EOE.pullType;
    int i = j;
    if (j == 3) {
      i = 1;
    }
    String str = super.getKey() + '+' + i;
    AppMethodBeat.o(340304);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/net/cgi/CgiFinderNavLiveStream$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.net.cgi.a
 * JD-Core Version:    0.7.0.1
 */