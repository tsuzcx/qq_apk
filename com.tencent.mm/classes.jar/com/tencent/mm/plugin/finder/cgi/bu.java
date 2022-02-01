package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.axp;
import com.tencent.mm.protocal.protobuf.axq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderLiveVerify;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderLiveVerifyResp;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bu
  extends ax
  implements m
{
  private final String TAG;
  private i callback;
  private d tvD;
  
  public bu()
  {
    AppMethodBeat.i(242472);
    this.TAG = "FLive.NetSceneFinderLiveVerify";
    d.a locala = new d.a();
    axp localaxp = new axp();
    am localam = am.tuw;
    localaxp.LAI = am.cXY();
    locala.c((a)localaxp);
    locala.d((a)new axq());
    locala.sG(getType());
    locala.MB("/cgi-bin/micromsg-bin/finderliveverify");
    this.tvD = locala.aXF();
    AppMethodBeat.o(242472);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242471);
    Log.i(this.TAG, "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      Log.i(this.TAG, "NetSceneFinderLiveVerify " + com.tencent.mm.ac.g.bN(cYK()));
    }
    params = com.tencent.mm.kernel.g.aAh();
    p.g(params, "MMKernel.storage()");
    params.azQ().set(ar.a.Oki, Boolean.valueOf(cYK().sPX));
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(242471);
      return;
    }
    AppMethodBeat.o(242471);
  }
  
  public final axq cYK()
  {
    AppMethodBeat.i(242470);
    Object localObject = this.tvD;
    if (localObject == null) {
      p.hyc();
    }
    localObject = ((d)localObject).aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveVerifyResp");
      AppMethodBeat.o(242470);
      throw ((Throwable)localObject);
    }
    localObject = (axq)localObject;
    AppMethodBeat.o(242470);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(242469);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.tvD, (m)this);
    AppMethodBeat.o(242469);
    return i;
  }
  
  public final int getType()
  {
    return 5231;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bu
 * JD-Core Version:    0.7.0.1
 */