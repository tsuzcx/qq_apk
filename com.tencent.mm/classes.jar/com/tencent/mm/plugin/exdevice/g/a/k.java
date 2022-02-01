package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bvp;
import com.tencent.mm.protocal.protobuf.bvq;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetSportHistory;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "request", "Lcom/tencent/mm/protocal/protobuf/GetSportRecordHistoryRequest;", "(Lcom/tencent/mm/protocal/protobuf/GetSportRecordHistoryRequest;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/GetSportRecordHistoryRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetSportRecordHistoryResponse;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/GetSportRecordHistoryResponse;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/GetSportRecordHistoryResponse;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "app_release"})
public final class k
  extends q
  implements m
{
  private final String TAG;
  private i callback;
  private d iUB;
  public bvq rCP;
  private final bvp rCQ;
  
  public k(bvp parambvp)
  {
    AppMethodBeat.i(230601);
    this.rCQ = parambvp;
    this.TAG = "MicroMsg.Sport.NetSceneGetSportHistory";
    new StringBuilder("create NetSceneGetSportHistory, ").append(this.rCQ.username);
    h.hkS();
    parambvp = new d.a();
    parambvp.sG(4835);
    parambvp.MB("/cgi-bin/mmbiz-bin/rank/getsportrecordhistory");
    parambvp.c((a)this.rCQ);
    parambvp.d((a)new bvq());
    this.iUB = parambvp.aXF();
    AppMethodBeat.o(230601);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(230600);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.iUB, (m)this);
    AppMethodBeat.o(230600);
    return i;
  }
  
  public final int getType()
  {
    return 4835;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(230599);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.iUB;
      if (params != null) {}
      for (params = params.aYK(); params == null; params = null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetSportRecordHistoryResponse");
        AppMethodBeat.o(230599);
        throw paramString;
      }
      this.rCP = ((bvq)params);
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(230599);
      return;
    }
    AppMethodBeat.o(230599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.k
 * JD-Core Version:    0.7.0.1
 */