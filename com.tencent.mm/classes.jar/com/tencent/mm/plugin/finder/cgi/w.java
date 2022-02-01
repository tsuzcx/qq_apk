package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.s;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bao;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetNearbyListResp;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;", "pullType", "", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;ILcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getType", "isFetchFeedCgi", "", "onCgiEnd", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Callback", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  extends c<bap>
{
  public static final b Azs;
  private final ar.c Azg;
  private final a Azt;
  private final int pullType;
  
  static
  {
    AppMethodBeat.i(336495);
    Azs = new b((byte)0);
    AppMethodBeat.o(336495);
  }
  
  public w(com.tencent.mm.bx.b paramb, a parama, int paramInt, ar.c paramc, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336490);
    this.Azt = parama;
    this.pullType = paramInt;
    this.Azg = paramc;
    parama = new c.a();
    parama.funcId = 375;
    paramc = new bao();
    Object localObject = k.aeZF;
    localObject = ((com.tencent.mm.plugin.finder.viewmodel.b)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class)).dUh();
    paramc.longitude = ((Number)((r)localObject).bsC).floatValue();
    paramc.latitude = ((Number)((r)localObject).bsD).floatValue();
    paramc.lastBuffer = paramb;
    localObject = bi.ABn;
    paramc.ZEc = bi.dVu();
    localObject = bi.ABn;
    paramc.ZDQ = bi.bTZ();
    parama.otE = ((a)paramc);
    parama.otF = ((a)new bap());
    parama.uri = "/cgi-bin/micromsg-bin/findergetnearbylist";
    c(parama.bEF());
    Log.i("Finder.CgiFinderGetNearbyList", "CgiFinderGetNearbyList lat.lng:" + paramc.latitude + ", " + paramc.longitude + ' ' + this.pullType + ' ' + paramb);
    paramb = s.Fqv;
    s.a(2, this.pullType, parambui, 4L);
    AppMethodBeat.o(336490);
  }
  
  public final f<b.a<bap>> bFJ()
  {
    AppMethodBeat.i(336502);
    s.a(s.Fqv, 2, true, null, 12);
    f localf = super.bFJ();
    AppMethodBeat.o(336502);
    return localf;
  }
  
  public final boolean dVg()
  {
    return true;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;", "", "onFetchDone", "", "errType", "", "errCode", "errMsg", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderGetNearbyListResp;", "pullType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, bap parambap, int paramInt3);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.w
 * JD-Core Version:    0.7.0.1
 */