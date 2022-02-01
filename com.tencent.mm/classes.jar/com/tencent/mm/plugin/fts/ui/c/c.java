package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.cpa;
import com.tencent.mm.protocal.protobuf.cpb;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/fts/ui/model/NetSceneKeyboardSug;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "request", "Lcom/tencent/mm/protocal/protobuf/KeyBoardSugSearchRequest;", "(Lcom/tencent/mm/protocal/protobuf/KeyBoardSugSearchRequest;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/KeyBoardSugSearchRequest;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/KeyBoardSugSearchResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "ui-fts_release"})
public final class c
  extends q
  implements m
{
  private final cpa BQQ;
  private i callback;
  public d lKU;
  
  public c(cpa paramcpa)
  {
    AppMethodBeat.i(190937);
    this.BQQ = paramcpa;
    this.BQQ.TwK = ai.czn();
    this.BQQ.TwL = ai.gQO();
    paramcpa = new d.a();
    paramcpa.vD(4591);
    paramcpa.TW("/cgi-bin/mmsearch-bin/keyboardsug");
    paramcpa.c((a)this.BQQ);
    paramcpa.d((a)new cpb());
    this.lKU = paramcpa.bgN();
    AppMethodBeat.o(190937);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(190931);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(190931);
    return i;
  }
  
  public final int getType()
  {
    return 4591;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(190935);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(190935);
      return;
    }
    AppMethodBeat.o(190935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c.c
 * JD-Core Version:    0.7.0.1
 */