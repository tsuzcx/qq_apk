package com.tencent.mm.plugin.finder.nearby.live;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ab.c;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.cgi.an;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.finder.nearby.report.c;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.aui;
import com.tencent.mm.protocal.protobuf.auj;
import com.tencent.mm.protocal.protobuf.auk;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.protocal.protobuf.bbj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/CgiNearbyLiveFeedStream;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLbsLiveStreamResponse;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lcom/tencent/mm/plugin/finder/nearby/live/CgiNearbyLiveFeedStream$Callback;", "pullType", "", "commentScene", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "(Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/nearby/live/CgiNearbyLiveFeedStream$Callback;IILcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;)V", "buildRedDotRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLbsLiveStreamRequest;", "buildResponse", "onCgiEnd", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Callback", "Companion", "plugin-finder_release"})
public final class a
  extends an<auj>
{
  public static final b uQE;
  private final int pullType;
  private final int tCE;
  private final ab.c ttd;
  private final a uQD;
  
  static
  {
    AppMethodBeat.i(249028);
    uQE = new b((byte)0);
    AppMethodBeat.o(249028);
  }
  
  public a(b paramb, a parama, int paramInt1, int paramInt2, ab.c paramc, bbn parambbn, axj paramaxj)
  {
    super(parambbn);
    AppMethodBeat.i(249027);
    this.uQD = parama;
    this.pullType = paramInt1;
    this.tCE = paramInt2;
    this.ttd = paramc;
    paramc = new d.a();
    parama = new aui();
    parambbn = com.tencent.mm.ui.component.a.PRN;
    com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    parambbn = FinderGlobalLocationVM.dHP();
    Object localObject = am.tuw;
    localObject = am.cXY();
    ((aov)localObject).scene = this.tCE;
    parama.LBM = ((aov)localObject);
    parama.dTj = ((Number)parambbn.first).floatValue();
    parama.latitude = ((Number)parambbn.second).floatValue();
    parama.LDs = paramb;
    parama.LFc = this.pullType;
    if (paramaxj != null) {
      parama.LFg = paramaxj;
    }
    if (this.pullType == 1)
    {
      paramb = c.uTk;
      if (c.JG(this.tCE))
      {
        paramb = parama.LFe;
        parambbn = c.uTk;
        paramb.addAll((Collection)c.JF(this.tCE));
        paramb = parama.LFf;
        parambbn = c.uTk;
        paramInt1 = this.tCE;
        parambbn = c.uTk;
        paramb.addAll((Collection)c.gb(paramInt1, c.JH(this.tCE)));
      }
    }
    boolean bool;
    if ((this.pullType == 1) || (this.pullType == 0))
    {
      paramb = g.ah(PluginFinder.class);
      p.g(paramb, "MMKernel.plugin(PluginFinder::class.java)");
      parambbn = ((PluginFinder)paramb).getRedDotManager();
      paramaxj = parambbn.ata("NearbyLiveTab");
      if (paramaxj == null) {
        break label659;
      }
      bool = true;
      parama.LFh = new auk();
      paramb = parama.LFh;
      if (paramb != null)
      {
        if (paramaxj == null) {
          break label665;
        }
        paramb.LFj = paramaxj.object_id;
        paramb.LFk = paramaxj.object_nonce_id;
        paramb.LFl = paramaxj.tabTipsByPassInfo;
        paramb.LFm = "NearbyEntrance";
        label354:
        parambbn = new StringBuilder("[buildRedDotRequest] isEnterRequest=").append(bool).append(" tab_tips_path=").append(paramb.LFm).append(' ').append(" tabTipsByPassInfo=");
        if (paramb.LFl == null) {
          break label722;
        }
        bool = true;
        label405:
        Log.i("Finder.FinderStream", bool + ' ' + "objectId=" + d.zs(paramb.LFj) + ' ');
      }
    }
    paramc.c((com.tencent.mm.bw.a)parama);
    paramb = new auj();
    paramb.setBaseResponse(new BaseResponse());
    paramb.getBaseResponse().ErrMsg = new dqi();
    paramc.d((com.tencent.mm.bw.a)paramb);
    paramc.MB("/cgi-bin/micromsg-bin/finderlbslivestream");
    paramc.sG(4026);
    c(paramc.aXF());
    paramc = new StringBuilder("[CgiFetchFinderTimeline#init] commentScene:").append(this.tCE).append(", pullType=").append(this.pullType).append(", longitude=").append(parama.dTj).append(" latitude=").append(parama.latitude).append(' ').append("tabInfo:");
    paramb = parama.LFg;
    if (paramb != null)
    {
      paramb = Integer.valueOf(paramb.LHQ);
      label610:
      paramc = paramc.append(paramb).append(" - ");
      paramb = parama.LFg;
      if (paramb == null) {
        break label733;
      }
    }
    label659:
    label665:
    label722:
    label733:
    for (paramb = paramb.LHR;; paramb = null)
    {
      Log.i("Finder.CgiNearbyLiveFeedStream", paramb);
      AppMethodBeat.o(249027);
      return;
      bool = false;
      break;
      parambbn = parambbn.asX("NearbyLiveTab");
      if (parambbn == null) {
        break label354;
      }
      parambbn = parambbn.tLm;
      paramb.LFj = parambbn.object_id;
      paramb.LFk = parambbn.object_nonce_id;
      paramb.LFl = parambbn.tabTipsByPassInfo;
      paramb.LFm = "NearbyLiveTab";
      break label354;
      bool = false;
      break label405;
      paramb = null;
      break label610;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/CgiNearbyLiveFeedStream$Callback;", "", "onFetchDone", "", "errType", "", "errCode", "errMsg", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderLbsLiveStreamResponse;", "pullType", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, auj paramauj, int paramInt3);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/CgiNearbyLiveFeedStream$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.a
 * JD-Core Version:    0.7.0.1
 */