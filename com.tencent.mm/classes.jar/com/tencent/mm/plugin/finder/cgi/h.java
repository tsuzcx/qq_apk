package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.protocal.protobuf.aou;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.o;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetNearbyListResp;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;", "pullType", "", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;ILcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getType", "isFetchFeedCgi", "", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Callback", "Companion", "plugin-finder_release"})
public final class h
  extends w<aou>
{
  public static final b rQg;
  private final int pullType;
  private final n.c rQc;
  private final a rQf;
  
  static
  {
    AppMethodBeat.i(201451);
    rQg = new b((byte)0);
    AppMethodBeat.o(201451);
  }
  
  public h(b paramb, a parama, int paramInt, n.c paramc, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(201450);
    this.rQf = parama;
    this.pullType = paramInt;
    this.rQc = paramc;
    parama = new b.a();
    parama.oS(375);
    paramc = new aot();
    Object localObject = com.tencent.mm.ui.component.a.KEX;
    com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    localObject = FinderGlobalLocationVM.cQL();
    paramc.dBu = ((Number)((o)localObject).first).floatValue();
    paramc.dzE = ((Number)((o)localObject).second).floatValue();
    paramc.lastBuffer = paramb;
    localObject = v.rRb;
    paramc.GEg = v.czz();
    localObject = v.rRb;
    paramc.GDS = v.cXN();
    parama.c((com.tencent.mm.bw.a)paramc);
    parama.d((com.tencent.mm.bw.a)new aou());
    parama.DN("/cgi-bin/micromsg-bin/findergetnearbylist");
    c(parama.aDS());
    ae.i("Finder.CgiFinderGetNearbyList", "CgiFinderGetNearbyList lat.lng:" + paramc.dzE + ", " + paramc.dBu + ' ' + this.pullType + ' ' + paramb);
    paramb = com.tencent.mm.plugin.finder.report.f.syc;
    com.tencent.mm.plugin.finder.report.f.a(2, this.pullType, paramarn, 4L);
    AppMethodBeat.o(201450);
  }
  
  public final com.tencent.mm.cm.f<a.a<aou>> aET()
  {
    AppMethodBeat.i(201448);
    Object localObject = com.tencent.mm.plugin.finder.report.f.syc;
    com.tencent.mm.plugin.finder.report.f.ah(2, true);
    localObject = super.aET();
    p.g(localObject, "super.run()");
    AppMethodBeat.o(201448);
    return localObject;
  }
  
  public final boolean czv()
  {
    return true;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;", "", "onFetchDone", "", "errType", "", "errCode", "errMsg", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderGetNearbyListResp;", "pullType", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, aou paramaou, int paramInt3);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.h
 * JD-Core Version:    0.7.0.1
 */