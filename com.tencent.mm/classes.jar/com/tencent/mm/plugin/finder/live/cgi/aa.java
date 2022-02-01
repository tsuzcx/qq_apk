package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.bnz;
import com.tencent.mm.protocal.protobuf.boa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/NetSceneFinderLiveVerify;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderLiveVerifyResp;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
  extends com.tencent.mm.plugin.findersdk.b.h
{
  private c ACJ;
  private final String TAG;
  private com.tencent.mm.am.h callback;
  
  public aa()
  {
    AppMethodBeat.i(351207);
    this.TAG = "FLive.NetSceneFinderLiveVerify";
    c.a locala = new c.a();
    bnz localbnz = new bnz();
    bi localbi = bi.ABn;
    localbnz.ZEc = bi.dVu();
    locala.otE = ((a)localbnz);
    locala.otF = ((a)new boa());
    locala.funcId = getType();
    locala.uri = "/cgi-bin/micromsg-bin/finderliveverify";
    this.ACJ = locala.bEF();
    AppMethodBeat.o(351207);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(351242);
    Log.i(this.TAG, "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      Log.i(this.TAG, kotlin.g.b.s.X("NetSceneFinderLiveVerify ", com.tencent.mm.ae.f.dg(ehq())));
    }
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adaC, Boolean.valueOf(ehq().zSb));
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(351242);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(351220);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.ACJ, (m)this);
    AppMethodBeat.o(351220);
    return i;
  }
  
  public final boa ehq()
  {
    AppMethodBeat.i(351231);
    Object localObject = this.ACJ;
    kotlin.g.b.s.checkNotNull(localObject);
    localObject = c.c.b(((c)localObject).otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveVerifyResp");
      AppMethodBeat.o(351231);
      throw ((Throwable)localObject);
    }
    localObject = (boa)localObject;
    AppMethodBeat.o(351231);
    return localObject;
  }
  
  public final int getType()
  {
    return 5231;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.aa
 * JD-Core Version:    0.7.0.1
 */