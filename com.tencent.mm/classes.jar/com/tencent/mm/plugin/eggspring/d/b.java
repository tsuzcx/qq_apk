package com.tencent.mm.plugin.eggspring.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.eggspring.c.c;
import com.tencent.mm.protocal.protobuf.bmz;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/eggspring/net/NetSceneHasLuckyBag;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "keyWord", "", "appId", "queryTicket", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "luckyBagInfo", "Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;", "getLuckyBagInfo", "()Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;", "setLuckyBagInfo", "(Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;)V", "getQueryTicket", "()J", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-eggspring_release"})
public final class b
  extends q
  implements m
{
  public static final a qVl;
  private final String appId;
  private i callback;
  private final String jgR;
  public c qVj;
  public final long qVk;
  private d rr;
  
  static
  {
    AppMethodBeat.i(108164);
    qVl = new a((byte)0);
    AppMethodBeat.o(108164);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(108161);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(108161);
    return i;
  }
  
  public final int getType()
  {
    return 2757;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108162);
    Log.i("MicroMsg.NetSceneHasLuckyBag", "onGYNetEnd errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.rr.aYK();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetExpressionResp");
        AppMethodBeat.o(108162);
        throw paramString;
      }
      params = (bmz)params;
      Log.i("MicroMsg.NetSceneHasLuckyBag", "ret[%s] msg[%s] hasLuckyBag[%s] traceId[%s] interval[%s].", new Object[] { Integer.valueOf(params.ret), params.msg, Integer.valueOf(params.gTm), params.gTl, Integer.valueOf(params.gTn) });
      if (params.ret == 0) {
        switch (params.gTm)
        {
        default: 
          Log.e("MicroMsg.NetSceneHasLuckyBag", "err!!![%s].", new Object[] { Integer.valueOf(params.gTm) });
        }
      }
    }
    for (;;)
    {
      params = this.callback;
      if (params == null) {
        p.btv("callback");
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(108162);
      return;
      paramArrayOfByte = params.gTl;
      paramInt1 = Math.max(params.gTn, 0);
      this.qVj = new c(this.jgR, paramArrayOfByte, this.appId, paramInt1);
      continue;
      this.qVj = null;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/eggspring/net/NetSceneHasLuckyBag$Companion;", "", "()V", "TAG", "", "plugin-eggspring_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.d.b
 * JD-Core Version:    0.7.0.1
 */