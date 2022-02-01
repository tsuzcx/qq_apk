package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.cge;
import com.tencent.mm.protocal.protobuf.cgf;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/fts/ui/model/NetSceneKeyboardSug;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "request", "Lcom/tencent/mm/protocal/protobuf/KeyBoardSugSearchRequest;", "(Lcom/tencent/mm/protocal/protobuf/KeyBoardSugSearchRequest;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/KeyBoardSugSearchRequest;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/KeyBoardSugSearchResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "ui-fts_release"})
public final class c
  extends q
  implements m
{
  private i callback;
  public d iUB;
  private final cge xeH;
  
  public c(cge paramcge)
  {
    AppMethodBeat.i(235446);
    this.xeH = paramcge;
    this.xeH.MlQ = ai.clJ();
    this.xeH.MlR = ai.fYd();
    paramcge = new d.a();
    paramcge.sG(4591);
    paramcge.MB("/cgi-bin/mmsearch-bin/keyboardsug");
    paramcge.c((a)this.xeH);
    paramcge.d((a)new cgf());
    this.iUB = paramcge.aXF();
    AppMethodBeat.o(235446);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(235444);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (m)this);
    AppMethodBeat.o(235444);
    return i;
  }
  
  public final int getType()
  {
    return 4591;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(235445);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(235445);
      return;
    }
    AppMethodBeat.o(235445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c.c
 * JD-Core Version:    0.7.0.1
 */