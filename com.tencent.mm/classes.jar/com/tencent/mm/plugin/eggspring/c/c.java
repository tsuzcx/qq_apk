package com.tencent.mm.plugin.eggspring.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.awy;
import com.tencent.mm.protocal.protobuf.awz;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/eggspring/net/NetSceneHasLuckyBag;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "keyWord", "", "appId", "queryTicket", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "luckyBagInfo", "Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;", "getLuckyBagInfo", "()Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;", "setLuckyBagInfo", "(Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;)V", "getQueryTicket", "()J", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-eggspring_release"})
public final class c
  extends n
  implements com.tencent.mm.network.k
{
  public static final c.a oVH;
  private final String appId;
  private g callback;
  private final String hPI;
  public com.tencent.mm.plugin.eggspring.b.c oVF;
  public final long oVG;
  private b rr;
  
  static
  {
    AppMethodBeat.i(108164);
    oVH = new c.a((byte)0);
    AppMethodBeat.o(108164);
  }
  
  public c(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(108163);
    this.hPI = paramString1;
    this.appId = paramString2;
    this.oVG = paramLong;
    paramString1 = new b.a();
    paramString1.c((a)new awy());
    paramString1.d((a)new awz());
    paramString1.Am("/cgi-bin/mmoc-bin/expressionad/getexpression");
    paramString1.op(2757);
    paramString1.or(0);
    paramString1.os(0);
    paramString1 = paramString1.aAz();
    d.g.b.k.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    paramString1 = this.rr.aBC();
    if (paramString1 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetExpressionReq");
      AppMethodBeat.o(108163);
      throw paramString1;
    }
    paramString1 = (awy)paramString1;
    paramString1.cZL = this.hPI;
    paramString1.djj = this.appId;
    AppMethodBeat.o(108163);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(108161);
    d.g.b.k.h(parame, "dispatcher");
    d.g.b.k.h(paramg, "callback");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
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
    ac.i("MicroMsg.NetSceneHasLuckyBag", "onGYNetEnd errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.rr.aBD();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetExpressionResp");
        AppMethodBeat.o(108162);
        throw paramString;
      }
      paramq = (awz)paramq;
      ac.i("MicroMsg.NetSceneHasLuckyBag", "ret[%s] msg[%s] hasLuckyBag[%s] traceId[%s] interval[%s].", new Object[] { Integer.valueOf(paramq.ret), paramq.bIO, Integer.valueOf(paramq.EOS), paramq.EOI, Integer.valueOf(paramq.gbd) });
      if (paramq.ret == 0)
      {
        this.oVF = new com.tencent.mm.plugin.eggspring.b.c();
        switch (paramq.EOS)
        {
        default: 
          ac.e("MicroMsg.NetSceneHasLuckyBag", "err!!![%s].", new Object[] { Integer.valueOf(paramq.EOS) });
        }
      }
    }
    for (;;)
    {
      if (paramq.gbd > 0)
      {
        paramArrayOfByte = this.oVF;
        if (paramArrayOfByte == null) {
          d.g.b.k.fOy();
        }
        paramArrayOfByte.gbd = paramq.gbd;
      }
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aVY("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(108162);
      return;
      paramArrayOfByte = this.oVF;
      if (paramArrayOfByte == null) {
        d.g.b.k.fOy();
      }
      paramArrayOfByte.oVy = true;
      paramArrayOfByte = this.oVF;
      if (paramArrayOfByte == null) {
        d.g.b.k.fOy();
      }
      paramArrayOfByte.jyU = paramq.EOI;
      paramArrayOfByte = this.oVF;
      if (paramArrayOfByte == null) {
        d.g.b.k.fOy();
      }
      paramArrayOfByte.hPI = this.hPI;
      paramArrayOfByte = this.oVF;
      if (paramArrayOfByte == null) {
        d.g.b.k.fOy();
      }
      paramArrayOfByte.appId = this.appId;
      continue;
      paramArrayOfByte = this.oVF;
      if (paramArrayOfByte == null) {
        d.g.b.k.fOy();
      }
      paramArrayOfByte.oVy = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.c.c
 * JD-Core Version:    0.7.0.1
 */