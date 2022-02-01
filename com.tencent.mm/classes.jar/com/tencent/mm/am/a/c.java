package com.tencent.mm.am.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s.7;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.Metadata;
import kotlinx.coroutines.a.ab;
import kotlinx.coroutines.a.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelbase/flow/NetSceneFlow;", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "channel", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "Lcom/tencent/mm/modelbase/flow/FlowEvent;", "(Lcom/tencent/mm/modelbase/CommReqResp;Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;)V", "getChannel", "()Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "getReqResp", "()Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getType", "needCheckCallback", "", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "mmkernel_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c<T extends esc>
  extends p
  implements m
{
  private final com.tencent.mm.am.c nao;
  private final q<a<T>> ovy;
  
  public c(com.tencent.mm.am.c paramc, q<a<T>> paramq)
  {
    AppMethodBeat.i(236806);
    this.nao = paramc;
    this.ovy = paramq;
    AppMethodBeat.o(236806);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(236809);
    if (paramg != null)
    {
      int i = dispatch(paramg, (com.tencent.mm.network.s)this.nao, (m)this);
      if (!this.ovy.Ij()) {
        this.ovy.offer(new a(b.ovA, i, -1, -1, "", this, null));
      }
      Log.i("MicroMsg.Mvvm.FlowNetScene", kotlin.g.b.s.X("doScene, netId:", Integer.valueOf(i)));
      AppMethodBeat.o(236809);
      return i;
    }
    AppMethodBeat.o(236809);
    return -1;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(236814);
    int i = this.nao.getType();
    AppMethodBeat.o(236814);
    return i;
  }
  
  public final boolean needCheckCallback()
  {
    return false;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(236816);
    label51:
    q localq;
    b localb;
    if (params != null) {
      if ((params instanceof com.tencent.mm.am.c))
      {
        if (params == null) {
          break label214;
        }
        params = c.c.b(((com.tencent.mm.am.c)params).otC);
        if (!(params instanceof esc)) {
          break label214;
        }
        params = (esc)params;
        if (!this.ovy.Ij())
        {
          localq = this.ovy;
          localb = b.ovB;
          if (paramString != null) {
            break label220;
          }
        }
      }
    }
    label214:
    label220:
    for (paramArrayOfByte = "";; paramArrayOfByte = paramString)
    {
      localq.offer(new a(localb, paramInt1, paramInt2, paramInt3, paramArrayOfByte, this, params));
      ((ab)this.ovy).k(null);
      params = com.tencent.mm.kernel.h.aZW();
      paramArrayOfByte = (p)this;
      params.handler.post(new s.7(params, paramInt2, paramInt3, paramString, paramArrayOfByte));
      Log.i("MicroMsg.Mvvm.FlowNetScene", "onGYNetEnd, netId:" + paramInt1 + " errType:" + paramInt2 + " errCode:" + paramInt3 + " errMsg:" + paramString);
      AppMethodBeat.o(236816);
      return;
      params = null;
      break;
      params = null;
      break label51;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.am.a.c
 * JD-Core Version:    0.7.0.1
 */