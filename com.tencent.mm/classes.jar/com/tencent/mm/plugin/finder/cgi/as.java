package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.arp;
import com.tencent.mm.protocal.protobuf.arq;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneBlockPosterList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/FinderGetBlockPosterListResponse;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class as
  extends ax
{
  private final String TAG;
  private i callback;
  private d rr;
  
  public as(b paramb)
  {
    AppMethodBeat.i(242342);
    this.TAG = "NetSceneBlockPosterList";
    d.a locala = new d.a();
    locala.sG(getType());
    arp localarp = new arp();
    localarp.lastBuffer = paramb;
    paramb = am.tuw;
    localarp.LAI = am.cXY();
    locala.c((a)localarp);
    locala.d((a)new arq());
    locala.MB("/cgi-bin/micromsg-bin/findergetblockposterlist");
    paramb = locala.aXF();
    p.g(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i(this.TAG, "NetSceneBlockPosterList init, scene ");
    AppMethodBeat.o(242342);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242340);
    Log.i(this.TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.hyc();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(242340);
  }
  
  public final arq cYd()
  {
    AppMethodBeat.i(242341);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetBlockPosterListResponse");
      AppMethodBeat.o(242341);
      throw ((Throwable)localObject);
    }
    localObject = (arq)localObject;
    AppMethodBeat.o(242341);
    return localObject;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242339);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242339);
    return i;
  }
  
  public final int getType()
  {
    return 5905;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.as
 * JD-Core Version:    0.7.0.1
 */