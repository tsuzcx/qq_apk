package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneBlockPosterList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResp", "Lcom/tencent/mm/protocal/protobuf/FinderGetBlockPosterListResponse;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class av
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private final String TAG;
  private i callback;
  private d rr;
  
  public av(b paramb)
  {
    AppMethodBeat.i(288698);
    this.TAG = "NetSceneBlockPosterList";
    d.a locala = new d.a();
    locala.vD(getType());
    atq localatq = new atq();
    localatq.lastBuffer = paramb;
    paramb = ao.xcj;
    localatq.SDi = ao.dnO();
    locala.c((a)localatq);
    locala.d((a)new atr());
    locala.TW("/cgi-bin/micromsg-bin/findergetblockposterlist");
    paramb = locala.bgN();
    p.j(paramb, "builder.buildInstance()");
    this.rr = paramb;
    Log.i(this.TAG, "NetSceneBlockPosterList init, scene ");
    AppMethodBeat.o(288698);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(288696);
    Log.i(this.TAG, "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.iCn();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(288696);
  }
  
  public final atr dnU()
  {
    AppMethodBeat.i(288697);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetBlockPosterListResponse");
      AppMethodBeat.o(288697);
      throw ((Throwable)localObject);
    }
    localObject = (atr)localObject;
    AppMethodBeat.o(288697);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(288695);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(288695);
    return i;
  }
  
  public final int getType()
  {
    return 5905;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.av
 * JD-Core Version:    0.7.0.1
 */