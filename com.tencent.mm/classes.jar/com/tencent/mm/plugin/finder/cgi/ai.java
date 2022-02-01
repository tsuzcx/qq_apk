package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.protocal.protobuf.dyx;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.o;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetNearbyListResp;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;", "pullType", "", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;ILcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getType", "isFetchFeedCgi", "", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Callback", "Companion", "plugin-finder_release"})
public final class ai
  extends an<dyy>
{
  public static final b KJq;
  private final a KJp;
  private final int pullType;
  private final g.c qoo;
  
  static
  {
    AppMethodBeat.i(197254);
    KJq = new b((byte)0);
    AppMethodBeat.o(197254);
  }
  
  public ai(b paramb, a parama, int paramInt, g.c paramc, dzp paramdzp)
  {
    super(paramdzp);
    AppMethodBeat.i(197253);
    this.KJp = parama;
    this.pullType = paramInt;
    this.qoo = paramc;
    parama = new b.a();
    parama.nB(375);
    paramc = new dyx();
    paramdzp = com.tencent.mm.ui.component.a.LCX;
    com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderGlobalLocationVM.class);
    paramdzp = FinderGlobalLocationVM.fXf();
    paramc.dqQ = ((Number)paramdzp.first).floatValue();
    paramc.dpb = ((Number)paramdzp.second).floatValue();
    paramc.lastBuffer = paramb;
    paramdzp = am.KJy;
    paramc.DlF = am.fRS();
    parama.c((com.tencent.mm.bx.a)paramc);
    parama.d((com.tencent.mm.bx.a)new dyy());
    parama.wg("/cgi-bin/micromsg-bin/findergetnearbylist");
    c(parama.atI());
    ad.i("Finder.CgiFinderGetNearbyList", "CgiFinderGetNearbyList lat.lng:" + paramc.dpb + ", " + paramc.dqQ + ' ' + this.pullType + ' ' + paramb);
    AppMethodBeat.o(197253);
  }
  
  public final boolean fRR()
  {
    return true;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;", "", "onFetchDone", "", "errType", "", "errCode", "errMsg", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderGetNearbyListResp;", "pullType", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, dyy paramdyy, int paramInt3);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ai
 * JD-Core Version:    0.7.0.1
 */