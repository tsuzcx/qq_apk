package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.ayg;
import com.tencent.mm.protocal.protobuf.ayh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneBlockPosterList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/FinderGetBlockPosterListResponse;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bq
  extends com.tencent.mm.plugin.findersdk.b.h
{
  private final String TAG;
  private com.tencent.mm.am.h callback;
  private c rr;
  
  public bq(b paramb)
  {
    AppMethodBeat.i(336382);
    this.TAG = "NetSceneBlockPosterList";
    c.a locala = new c.a();
    locala.funcId = getType();
    ayg localayg = new ayg();
    localayg.lastBuffer = paramb;
    paramb = bi.ABn;
    localayg.ZEc = bi.dVu();
    locala.otE = ((a)localayg);
    locala.otF = ((a)new ayh());
    locala.uri = "/cgi-bin/micromsg-bin/findergetblockposterlist";
    paramb = locala.bEF();
    kotlin.g.b.s.s(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i(this.TAG, "NetSceneBlockPosterList init, scene ");
    AppMethodBeat.o(336382);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336403);
    Log.i(this.TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null)
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336403);
  }
  
  public final ayh dVB()
  {
    AppMethodBeat.i(336411);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetBlockPosterListResponse");
      AppMethodBeat.o(336411);
      throw ((Throwable)localObject);
    }
    localObject = (ayh)localObject;
    AppMethodBeat.o(336411);
    return localObject;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336388);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(336388);
    return i;
  }
  
  public final int getType()
  {
    return 5905;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bq
 * JD-Core Version:    0.7.0.1
 */