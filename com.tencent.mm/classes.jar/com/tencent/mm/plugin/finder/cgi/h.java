package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.e;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.protocal.protobuf.aog;
import com.tencent.mm.protocal.protobuf.aoh;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.o;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetNearbyListResp;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;", "pullType", "", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;ILcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getType", "isFetchFeedCgi", "", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Callback", "Companion", "plugin-finder_release"})
public final class h
  extends w<aoh>
{
  public static final b rHV;
  private final int pullType;
  private final n.c rHR;
  private final a rHU;
  
  static
  {
    AppMethodBeat.i(201029);
    rHV = new b((byte)0);
    AppMethodBeat.o(201029);
  }
  
  public h(b paramb, a parama, int paramInt, n.c paramc, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(201028);
    this.rHU = parama;
    this.pullType = paramInt;
    this.rHR = paramc;
    parama = new b.a();
    parama.oP(375);
    paramc = new aog();
    Object localObject = com.tencent.mm.ui.component.a.KiD;
    com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    localObject = FinderGlobalLocationVM.cOb();
    paramc.dAp = ((Number)((o)localObject).first).floatValue();
    paramc.dyz = ((Number)((o)localObject).second).floatValue();
    paramc.lastBuffer = paramb;
    localObject = v.rIR;
    paramc.Gle = v.cxY();
    parama.c((com.tencent.mm.bx.a)paramc);
    parama.d((com.tencent.mm.bx.a)new aoh());
    parama.Dl("/cgi-bin/micromsg-bin/findergetnearbylist");
    c(parama.aDC());
    ad.i("Finder.CgiFinderGetNearbyList", "CgiFinderGetNearbyList lat.lng:" + paramc.dyz + ", " + paramc.dAp + ' ' + this.pullType + ' ' + paramb);
    paramb = e.snY;
    e.a(2, this.pullType, paramaqy, 4L);
    AppMethodBeat.o(201028);
  }
  
  public final f<a.a<aoh>> aED()
  {
    AppMethodBeat.i(201026);
    Object localObject = e.snY;
    e.ae(2, true);
    localObject = super.aED();
    p.g(localObject, "super.run()");
    AppMethodBeat.o(201026);
    return localObject;
  }
  
  public final boolean cxU()
  {
    return true;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;", "", "onFetchDone", "", "errType", "", "errCode", "errMsg", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderGetNearbyListResp;", "pullType", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, aoh paramaoh, int paramInt3);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.h
 * JD-Core Version:    0.7.0.1
 */