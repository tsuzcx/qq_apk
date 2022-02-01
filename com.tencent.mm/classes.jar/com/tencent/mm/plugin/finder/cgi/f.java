package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.protocal.protobuf.alb;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.o;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetNearbyListResp;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;", "pullType", "", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;ILcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getType", "isFetchFeedCgi", "", "onCgiBack", "", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Callback", "Companion", "plugin-finder_release"})
public final class f
  extends r<alc>
{
  public static final b qWU;
  private final int pullType;
  private final l.c qWQ;
  private final a qWT;
  
  static
  {
    AppMethodBeat.i(201107);
    qWU = new b((byte)0);
    AppMethodBeat.o(201107);
  }
  
  public f(b paramb, a parama, int paramInt, l.c paramc, anm paramanm)
  {
    super(paramanm);
    AppMethodBeat.i(201106);
    this.qWT = parama;
    this.pullType = paramInt;
    this.qWQ = paramc;
    parama = new b.a();
    parama.op(375);
    paramc = new alb();
    paramanm = com.tencent.mm.ui.component.a.IrY;
    com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderGlobalLocationVM.class);
    paramanm = FinderGlobalLocationVM.cFH();
    paramc.doB = ((Number)paramanm.first).floatValue();
    paramc.dmL = ((Number)paramanm.second).floatValue();
    paramc.lastBuffer = paramb;
    paramanm = q.qXH;
    paramc.EDu = q.csi();
    parama.c((com.tencent.mm.bw.a)paramc);
    parama.d((com.tencent.mm.bw.a)new alc());
    parama.Am("/cgi-bin/micromsg-bin/findergetnearbylist");
    c(parama.aAz());
    ac.i("Finder.CgiFinderGetNearbyList", "CgiFinderGetNearbyList lat.lng:" + paramc.dmL + ", " + paramc.doB + ' ' + this.pullType + ' ' + paramb);
    AppMethodBeat.o(201106);
  }
  
  public final boolean csf()
  {
    return true;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;", "", "onFetchDone", "", "errType", "", "errCode", "errMsg", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderGetNearbyListResp;", "pullType", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, alc paramalc, int paramInt3);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.f
 * JD-Core Version:    0.7.0.1
 */