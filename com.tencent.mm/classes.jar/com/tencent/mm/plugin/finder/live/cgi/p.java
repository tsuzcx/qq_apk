package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bdg;
import com.tencent.mm.protocal.protobuf.bdh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar.a;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/NetSceneFinderLiveVerify;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderLiveVerifyResp;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class p
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private final String TAG;
  private i callback;
  private d xdl;
  
  public p()
  {
    AppMethodBeat.i(282641);
    this.TAG = "FLive.NetSceneFinderLiveVerify";
    d.a locala = new d.a();
    bdg localbdg = new bdg();
    com.tencent.mm.plugin.finder.cgi.ao localao = com.tencent.mm.plugin.finder.cgi.ao.xcj;
    localbdg.SDi = com.tencent.mm.plugin.finder.cgi.ao.dnO();
    locala.c((a)localbdg);
    locala.d((a)new bdh());
    locala.vD(getType());
    locala.TW("/cgi-bin/micromsg-bin/finderliveverify");
    this.xdl = locala.bgN();
    AppMethodBeat.o(282641);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(282640);
    Log.i(this.TAG, "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      Log.i(this.TAG, "NetSceneFinderLiveVerify " + com.tencent.mm.ae.g.bN(dwU()));
    }
    params = h.aHG();
    kotlin.g.b.p.j(params, "MMKernel.storage()");
    params.aHp().set(ar.a.VyG, Boolean.valueOf(dwU().wvU));
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(282640);
      return;
    }
    AppMethodBeat.o(282640);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(282638);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.xdl, (m)this);
    AppMethodBeat.o(282638);
    return i;
  }
  
  public final bdh dwU()
  {
    AppMethodBeat.i(282639);
    Object localObject = this.xdl;
    if (localObject == null) {
      kotlin.g.b.p.iCn();
    }
    localObject = ((d)localObject).bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveVerifyResp");
      AppMethodBeat.o(282639);
      throw ((Throwable)localObject);
    }
    localObject = (bdh)localObject;
    AppMethodBeat.o(282639);
    return localObject;
  }
  
  public final int getType()
  {
    return 5231;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.p
 * JD-Core Version:    0.7.0.1
 */