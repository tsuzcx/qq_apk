package com.tencent.mm.plugin.eggspring.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbm;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/eggspring/net/NetSceneHasLuckyBag;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "keyWord", "", "appId", "queryTicket", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "luckyBagInfo", "Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;", "getLuckyBagInfo", "()Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;", "setLuckyBagInfo", "(Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;)V", "getQueryTicket", "()J", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-eggspring_release"})
public final class c
  extends n
  implements k
{
  public static final a pFV;
  private final String appId;
  private f callback;
  private final String ilP;
  public com.tencent.mm.plugin.eggspring.b.c pFT;
  public final long pFU;
  private b rr;
  
  static
  {
    AppMethodBeat.i(108164);
    pFV = new a((byte)0);
    AppMethodBeat.o(108164);
  }
  
  public c(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(108163);
    this.ilP = paramString1;
    this.appId = paramString2;
    this.pFU = paramLong;
    paramString1 = new b.a();
    paramString1.c((a)new bbm());
    paramString1.d((a)new bbn());
    paramString1.DN("/cgi-bin/mmoc-bin/expressionad/getexpression");
    paramString1.oS(2757);
    paramString1.oU(0);
    paramString1.oV(0);
    paramString1 = paramString1.aDS();
    p.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    paramString1 = this.rr.aEU();
    if (paramString1 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetExpressionReq");
      AppMethodBeat.o(108163);
      throw paramString1;
    }
    paramString1 = (bbm)paramString1;
    paramString1.dmf = this.ilP;
    paramString1.dwb = this.appId;
    AppMethodBeat.o(108163);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(108161);
    p.h(parame, "dispatcher");
    p.h(paramf, "callback");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(108161);
    return i;
  }
  
  public final int getType()
  {
    return 2757;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108162);
    ae.i("MicroMsg.NetSceneHasLuckyBag", "onGYNetEnd errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.rr.aEV();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetExpressionResp");
        AppMethodBeat.o(108162);
        throw paramString;
      }
      paramq = (bbn)paramq;
      ae.i("MicroMsg.NetSceneHasLuckyBag", "ret[%s] msg[%s] hasLuckyBag[%s] traceId[%s] interval[%s].", new Object[] { Integer.valueOf(paramq.ret), paramq.msg, Integer.valueOf(paramq.GRv), paramq.GRl, Integer.valueOf(paramq.gxu) });
      if (paramq.ret == 0)
      {
        this.pFT = new com.tencent.mm.plugin.eggspring.b.c();
        switch (paramq.GRv)
        {
        default: 
          ae.e("MicroMsg.NetSceneHasLuckyBag", "err!!![%s].", new Object[] { Integer.valueOf(paramq.GRv) });
        }
      }
    }
    for (;;)
    {
      if (paramq.gxu > 0)
      {
        paramArrayOfByte = this.pFT;
        if (paramArrayOfByte == null) {
          p.gkB();
        }
        paramArrayOfByte.gxu = paramq.gxu;
      }
      paramq = this.callback;
      if (paramq == null) {
        p.bdF("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(108162);
      return;
      paramArrayOfByte = this.pFT;
      if (paramArrayOfByte == null) {
        p.gkB();
      }
      paramArrayOfByte.pFM = true;
      paramArrayOfByte = this.pFT;
      if (paramArrayOfByte == null) {
        p.gkB();
      }
      paramArrayOfByte.jWi = paramq.GRl;
      paramArrayOfByte = this.pFT;
      if (paramArrayOfByte == null) {
        p.gkB();
      }
      paramArrayOfByte.ilP = this.ilP;
      paramArrayOfByte = this.pFT;
      if (paramArrayOfByte == null) {
        p.gkB();
      }
      paramArrayOfByte.appId = this.appId;
      continue;
      paramArrayOfByte = this.pFT;
      if (paramArrayOfByte == null) {
        p.gkB();
      }
      paramArrayOfByte.pFM = false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/eggspring/net/NetSceneHasLuckyBag$Companion;", "", "()V", "TAG", "", "plugin-eggspring_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.c.c
 * JD-Core Version:    0.7.0.1
 */