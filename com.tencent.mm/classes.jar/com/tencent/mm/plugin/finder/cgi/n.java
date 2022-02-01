package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.protocal.protobuf.atl;
import com.tencent.mm.protocal.protobuf.atm;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetNearbyListResp;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;", "pullType", "", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;ILcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getType", "isFetchFeedCgi", "", "onCgiEnd", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Callback", "Companion", "plugin-finder_release"})
public final class n
  extends an<atm>
{
  public static final b tth;
  private final int pullType;
  private final ab.c ttd;
  private final a ttg;
  
  static
  {
    AppMethodBeat.i(242230);
    tth = new b((byte)0);
    AppMethodBeat.o(242230);
  }
  
  public n(b paramb, a parama, int paramInt, ab.c paramc, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242229);
    this.ttg = parama;
    this.pullType = paramInt;
    this.ttd = paramc;
    parama = new d.a();
    parama.sG(375);
    paramc = new atl();
    Object localObject = com.tencent.mm.ui.component.a.PRN;
    com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    localObject = FinderGlobalLocationVM.dHP();
    paramc.dTj = ((Number)((o)localObject).first).floatValue();
    paramc.latitude = ((Number)((o)localObject).second).floatValue();
    paramc.lastBuffer = paramb;
    localObject = am.tuw;
    paramc.LAI = am.cXY();
    localObject = am.tuw;
    paramc.LAv = am.cXZ();
    parama.c((com.tencent.mm.bw.a)paramc);
    parama.d((com.tencent.mm.bw.a)new atm());
    parama.MB("/cgi-bin/micromsg-bin/findergetnearbylist");
    c(parama.aXF());
    Log.i("Finder.CgiFinderGetNearbyList", "CgiFinderGetNearbyList lat.lng:" + paramc.latitude + ", " + paramc.dTj + ' ' + this.pullType + ' ' + paramb);
    paramb = h.veu;
    h.a(2, this.pullType, parambbn, 4L);
    AppMethodBeat.o(242229);
  }
  
  public final f<c.a<atm>> aYI()
  {
    AppMethodBeat.i(242227);
    h.a(h.veu, 2, true, null, 12);
    f localf = super.aYI();
    AppMethodBeat.o(242227);
    return localf;
  }
  
  public final boolean cXQ()
  {
    return true;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;", "", "onFetchDone", "", "errType", "", "errCode", "errMsg", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderGetNearbyListResp;", "pullType", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, atm paramatm, int paramInt3);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.n
 * JD-Core Version:    0.7.0.1
 */