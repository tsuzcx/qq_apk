package com.tencent.mm.plugin.finder.nearby.live.square;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.cgi.ax;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.protocal.protobuf.atb;
import com.tencent.mm.protocal.protobuf.atc;
import com.tencent.mm.protocal.protobuf.bbn;
import kotlin.l;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/square/NetSceneNearbyLiveSquareTabs;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveTabsResponse;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class a
  extends ax
  implements m
{
  private final String TAG;
  private i callback;
  d rr;
  
  public a(bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(249207);
    this.TAG = "NetSceneNearbyLiveSquareTabs";
    Object localObject = com.tencent.mm.ui.component.a.PRN;
    com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    localObject = FinderGlobalLocationVM.dHP();
    d.a locala = new d.a();
    atb localatb = new atb();
    am localam = am.tuw;
    localatb.LBM = am.a(parambbn);
    localatb.dTj = ((Number)((o)localObject).first).floatValue();
    localatb.latitude = ((Number)((o)localObject).second).floatValue();
    locala.c((com.tencent.mm.bw.a)localatb);
    locala.d((com.tencent.mm.bw.a)new atc());
    locala.MB("/cgi-bin/micromsg-bin/findergetlivetabs");
    locala.sG(4210);
    this.rr = locala.aXF();
    AppMethodBeat.o(249207);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(249206);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(249206);
      return;
    }
    AppMethodBeat.o(249206);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(249205);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(249205);
    return i;
  }
  
  public final int getType()
  {
    return 4210;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.a
 * JD-Core Version:    0.7.0.1
 */