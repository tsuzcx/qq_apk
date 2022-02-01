package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cdh;
import com.tencent.mm.protocal.protobuf.cdi;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetSportHistory;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "request", "Lcom/tencent/mm/protocal/protobuf/GetSportRecordHistoryRequest;", "(Lcom/tencent/mm/protocal/protobuf/GetSportRecordHistoryRequest;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/GetSportRecordHistoryRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetSportRecordHistoryResponse;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/GetSportRecordHistoryResponse;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/GetSportRecordHistoryResponse;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "app_release"})
public final class k
  extends q
  implements m
{
  private final String TAG;
  private i callback;
  private d lKU;
  private final cdh viA;
  public cdi viz;
  
  public k(cdh paramcdh)
  {
    AppMethodBeat.i(217252);
    this.viA = paramcdh;
    this.TAG = "MicroMsg.Sport.NetSceneGetSportHistory";
    new StringBuilder("create NetSceneGetSportHistory, ").append(this.viA.username);
    h.ioq();
    paramcdh = new d.a();
    paramcdh.vD(4835);
    paramcdh.TW("/cgi-bin/mmbiz-bin/rank/getsportrecordhistory");
    paramcdh.c((a)this.viA);
    paramcdh.d((a)new cdi());
    this.lKU = paramcdh.bgN();
    AppMethodBeat.o(217252);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(217251);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.lKU, (m)this);
    AppMethodBeat.o(217251);
    return i;
  }
  
  public final int getType()
  {
    return 4835;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(217250);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.lKU;
      if (params != null) {}
      for (params = params.bhY(); params == null; params = null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetSportRecordHistoryResponse");
        AppMethodBeat.o(217250);
        throw paramString;
      }
      this.viz = ((cdi)params);
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(217250);
      return;
    }
    AppMethodBeat.o(217250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.k
 * JD-Core Version:    0.7.0.1
 */