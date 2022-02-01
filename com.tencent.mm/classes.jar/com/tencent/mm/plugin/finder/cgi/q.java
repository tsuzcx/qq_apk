package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.cw.f;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.avo;
import com.tencent.mm.protocal.protobuf.avp;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetNearbyListResp;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;", "pullType", "", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;ILcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getType", "isFetchFeedCgi", "", "onCgiEnd", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Callback", "Companion", "plugin-finder_release"})
public final class q
  extends c<avp>
{
  public static final b xaY;
  private final int pullType;
  private final ab.c xaU;
  private final a xaX;
  
  static
  {
    AppMethodBeat.i(267016);
    xaY = new b((byte)0);
    AppMethodBeat.o(267016);
  }
  
  public q(b paramb, a parama, int paramInt, ab.c paramc, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(267015);
    this.xaX = parama;
    this.pullType = paramInt;
    this.xaU = paramc;
    parama = new d.a();
    parama.vD(375);
    paramc = new avo();
    Object localObject = g.Xox;
    localObject = ((com.tencent.mm.plugin.finder.viewmodel.a)g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class)).dnl();
    paramc.longitude = ((Number)((o)localObject).Mx).floatValue();
    paramc.latitude = ((Number)((o)localObject).My).floatValue();
    paramc.lastBuffer = paramb;
    localObject = ao.xcj;
    paramc.SDi = ao.dnO();
    localObject = ao.xcj;
    paramc.SCW = ao.dnP();
    parama.c((com.tencent.mm.cd.a)paramc);
    parama.d((com.tencent.mm.cd.a)new avp());
    parama.TW("/cgi-bin/micromsg-bin/findergetnearbylist");
    c(parama.bgN());
    Log.i("Finder.CgiFinderGetNearbyList", "CgiFinderGetNearbyList lat.lng:" + paramc.latitude + ", " + paramc.longitude + ' ' + this.pullType + ' ' + paramb);
    paramb = j.zVy;
    j.a(2, this.pullType, parambid, 4L);
    AppMethodBeat.o(267015);
  }
  
  public final f<c.a<avp>> bhW()
  {
    AppMethodBeat.i(267012);
    j.a(j.zVy, 2, true, null, 12);
    f localf = super.bhW();
    AppMethodBeat.o(267012);
    return localf;
  }
  
  public final boolean dnD()
  {
    return true;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;", "", "onFetchDone", "", "errType", "", "errCode", "errMsg", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderGetNearbyListResp;", "pullType", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, avp paramavp, int paramInt3);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.q
 * JD-Core Version:    0.7.0.1
 */