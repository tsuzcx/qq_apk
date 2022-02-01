package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.csv;
import com.tencent.mm.protocal.protobuf.csw;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetSportHistory;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "request", "Lcom/tencent/mm/protocal/protobuf/GetSportRecordHistoryRequest;", "(Lcom/tencent/mm/protocal/protobuf/GetSportRecordHistoryRequest;)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/GetSportRecordHistoryRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetSportRecordHistoryResponse;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/GetSportRecordHistoryResponse;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/GetSportRecordHistoryResponse;)V", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends p
  implements m
{
  private final String TAG;
  private com.tencent.mm.am.h callback;
  private c oDw;
  private final csv yuy;
  public csw yuz;
  
  public k(csv paramcsv)
  {
    AppMethodBeat.i(274565);
    this.yuy = paramcsv;
    this.TAG = "MicroMsg.Sport.NetSceneGetSportHistory";
    kotlin.g.b.s.X("create NetSceneGetSportHistory, ", this.yuy.username);
    com.tencent.e.f.h.jXD();
    paramcsv = new c.a();
    paramcsv.funcId = 4835;
    paramcsv.uri = "/cgi-bin/mmbiz-bin/rank/getsportrecordhistory";
    paramcsv.otE = ((a)this.yuy);
    paramcsv.otF = ((a)new csw());
    this.oDw = paramcsv.bEF();
    AppMethodBeat.o(274565);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(274569);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(274569);
    return i;
  }
  
  public final int getType()
  {
    return 4835;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(274568);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.oDw;
      if (params == null) {}
      for (params = null; params == null; params = c.c.b(params.otC))
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetSportRecordHistoryResponse");
        AppMethodBeat.o(274568);
        throw paramString;
      }
      this.yuz = ((csw)params);
    }
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(274568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.k
 * JD-Core Version:    0.7.0.1
 */