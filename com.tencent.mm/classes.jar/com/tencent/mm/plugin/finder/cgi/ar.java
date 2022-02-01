package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.model.ay;
import com.tencent.mm.plugin.finder.report.q;
import com.tencent.mm.plugin.finder.report.q.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.aw;
import com.tencent.mm.plugin.finder.viewmodel.component.aw.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bwh;
import com.tencent.mm.protocal.protobuf.bwi;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "pullType", "", "tabType", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "useGlobalLastBuffer", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;IILcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protobuf/ByteString;ZLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "isFetchFeedCgi", "onCgiEnd", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Callback", "Companion", "ConsumeCallback", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ar
  extends c<bwi>
{
  public static final b AAy;
  private final bwh AAA;
  private final a AAz;
  private final ar.c Azg;
  private final boolean Azh;
  private final int hJx;
  private final com.tencent.mm.bx.b lastBuffer;
  private final int pullType;
  
  static
  {
    AppMethodBeat.i(165175);
    AAy = new b((byte)0);
    AppMethodBeat.o(165175);
  }
  
  public ar(a parama, int paramInt1, int paramInt2, ar.c paramc, com.tencent.mm.bx.b paramb, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336229);
    this.AAz = parama;
    this.pullType = paramInt1;
    this.hJx = paramInt2;
    this.Azg = paramc;
    this.lastBuffer = paramb;
    this.Azh = false;
    this.AAA = new bwh();
    if ((this.pullType == 0) && (this.Azh))
    {
      parama = h.baE().ban();
      paramc = av.GiL;
      parama.set(av.Uh(this.hJx), null);
    }
    paramb = new c.a();
    if (this.Azh)
    {
      parama = h.baE().ban();
      paramc = av.GiL;
      parama = parama.get(av.Uh(this.hJx), "");
      if (parama == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(336229);
        throw parama;
      }
      parama = Util.decodeHexString((String)parama);
      this.AAA.lastBuffer = com.tencent.mm.bx.b.cX(parama);
      this.AAA.pullType = this.pullType;
      this.AAA.hJx = this.hJx;
      if ((this.pullType == 1) && ((this.hJx == 1) || (this.hJx == 3) || (this.hJx == 4)))
      {
        parama = this.AAA;
        paramc = aw.GUC;
        parama.aaeO = aw.a.Vt(this.hJx);
        Log.i("Finder.CgiFinderTimelineStream", "[request] tabType=" + this.hJx + " partialExposedObjectId=" + this.AAA.aaeO + " h:" + hashCode());
      }
      parama = k.aeZF;
      parama = ((com.tencent.mm.plugin.finder.viewmodel.b)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class)).dUh();
      this.AAA.longitude = ((Number)parama.bsC).floatValue();
      this.AAA.latitude = ((Number)parama.bsD).floatValue();
      parama = this.AAA;
      paramc = bi.ABn;
      parama.CJv = bi.a(parambui);
      parambui = this.AAA;
      paramc = ((com.tencent.mm.plugin.expt.b.d)h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
      parama = paramc;
      if (paramc == null) {
        parama = "";
      }
      parambui.sessionId = parama;
      parama = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Nx(this.hJx);
      if (parama.object_id != 0L)
      {
        this.AAA.EWw = parama.object_id;
        this.AAA.aaeN = parama.object_nonce_id;
        Log.i("Finder.CgiFinderTimelineStream", "[request] tabType=" + this.hJx + " request with showInfo. objectId=" + com.tencent.mm.ae.d.hF(this.AAA.EWw) + " h:" + hashCode());
      }
      parama = bi.ABn;
      parama = bi.bTZ();
      paramc = this.AAA;
      parambui = ay.EDk;
      paramc.ZXp = ay.Qt(this.hJx);
      this.AAA.ZDQ = parama;
      parama = q.Fqb;
      parama = q.a.Sj(this.hJx);
      if (parama != null) {
        this.AAA.ZHE = parama;
      }
      paramb.otE = ((a)this.AAA);
      parama = new bwi();
      parama.setBaseResponse(new kd());
      parama.getBaseResponse().akjO = new etl();
      paramb.otF = ((a)parama);
      paramb.uri = "/cgi-bin/micromsg-bin/finderstream";
      paramb.funcId = 3901;
      c(paramb.bEF());
      parama = new StringBuilder("lxl CgiFetchFinderTimeline  tabType=").append(this.hJx).append(" init ").append(this.pullType).append(" lastBuffer ");
      if (this.AAA.lastBuffer != null) {
        break label825;
      }
    }
    label825:
    for (boolean bool = true;; bool = false)
    {
      paramc = parama.append(bool).append(", ");
      if (this.AAA.lastBuffer != null) {
        break label831;
      }
      parama = Character.valueOf('1');
      Log.i("Finder.CgiFinderTimelineStream", parama + " longitude=" + this.AAA.longitude + " latitude=" + this.AAA.latitude + " h:" + hashCode());
      AppMethodBeat.o(336229);
      return;
      this.AAA.lastBuffer = this.lastBuffer;
      break;
    }
    label831:
    parama = this.AAA.lastBuffer;
    if (parama == null) {}
    for (parama = null;; parama = parama.Op)
    {
      parama = MD5Util.getMD5String(parama);
      break;
    }
  }
  
  public final boolean dVg()
  {
    return true;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.finder.feed.model.d paramd, int paramInt);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ar
 * JD-Core Version:    0.7.0.1
 */