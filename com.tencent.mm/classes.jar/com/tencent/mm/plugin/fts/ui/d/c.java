package com.tencent.mm.plugin.fts.ui.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.dfu;
import com.tencent.mm.protocal.protobuf.dfv;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/model/NetSceneKeyboardSug;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "request", "Lcom/tencent/mm/protocal/protobuf/KeyBoardSugSearchRequest;", "(Lcom/tencent/mm/protocal/protobuf/KeyBoardSugSearchRequest;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/KeyBoardSugSearchRequest;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/KeyBoardSugSearchResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends p
  implements m
{
  private final dfu HCC;
  private h callback;
  public com.tencent.mm.am.c oDw;
  
  public c(dfu paramdfu)
  {
    AppMethodBeat.i(265677);
    this.HCC = paramdfu;
    this.HCC.aaLr = aj.dch();
    this.HCC.aaLs = aj.iqa();
    paramdfu = new c.a();
    paramdfu.funcId = 4591;
    paramdfu.uri = "/cgi-bin/mmsearch-bin/keyboardsug";
    paramdfu.otE = ((a)this.HCC);
    paramdfu.otF = ((a)new dfv());
    this.oDw = paramdfu.bEF();
    AppMethodBeat.o(265677);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(265681);
    this.callback = paramh;
    int i = dispatch(paramg, (s)this.oDw, (m)this);
    AppMethodBeat.o(265681);
    return i;
  }
  
  public final int getType()
  {
    return 4591;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(265687);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(265687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.c
 * JD-Core Version:    0.7.0.1
 */