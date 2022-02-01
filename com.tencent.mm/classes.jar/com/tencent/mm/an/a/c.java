package com.tencent.mm.an.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.b.b;
import com.tencent.mm.an.d;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import kotlinx.coroutines.a.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/modelbase/flow/NetSceneFlow;", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "channel", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "Lcom/tencent/mm/modelbase/flow/FlowEvent;", "(Lcom/tencent/mm/modelbase/CommReqResp;Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;)V", "getChannel", "()Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "getReqResp", "()Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getType", "needCheckCallback", "", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "mmkernel_release"})
public final class c<T extends dyy>
  extends q
  implements m
{
  private final d kwO;
  private final n<a<T>> lDN;
  
  public c(d paramd, n<a<T>> paramn)
  {
    AppMethodBeat.i(210538);
    this.kwO = paramd;
    this.lDN = paramn;
    AppMethodBeat.o(210538);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(210534);
    int i = dispatch(paramg, (s)this.kwO, (m)this);
    this.lDN.offer(new a(b.lDP, i, -1, -1, "", this, null));
    Log.i("MicroMsg.Mvvm.FlowNetScene", "doScene, netId:".concat(String.valueOf(i)));
    AppMethodBeat.o(210534);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(210535);
    int i = this.kwO.getType();
    AppMethodBeat.o(210535);
    return i;
  }
  
  public final boolean needCheckCallback()
  {
    return false;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(210537);
    n localn;
    b localb;
    if (params != null)
    {
      if ((params instanceof d)) {}
      while (params != null) {
        if (params == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
          AppMethodBeat.o(210537);
          throw paramString;
          params = null;
        }
        else
        {
          params = (d)params;
          if (params != null)
          {
            paramArrayOfByte = params.bhY();
            params = paramArrayOfByte;
            if (!(paramArrayOfByte instanceof dyy)) {
              params = null;
            }
            params = (dyy)params;
            localn = this.lDN;
            localb = b.lDQ;
            if (paramString != null) {
              break label212;
            }
          }
        }
      }
    }
    label212:
    for (paramArrayOfByte = "";; paramArrayOfByte = paramString)
    {
      localn.offer(new a(localb, paramInt1, paramInt2, paramInt3, paramArrayOfByte, this, params));
      h.aGY().c(paramInt2, paramInt3, paramString, (q)this);
      Log.i("MicroMsg.Mvvm.FlowNetScene", "onGYNetEnd, netId:" + paramInt1 + " errType:" + paramInt2 + " errCode:" + paramInt3 + " errMsg:" + paramString);
      AppMethodBeat.o(210537);
      return;
      params = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.an.a.c
 * JD-Core Version:    0.7.0.1
 */