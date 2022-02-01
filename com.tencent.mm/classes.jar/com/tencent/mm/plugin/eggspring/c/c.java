package com.tencent.mm.plugin.eggspring.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bax;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/eggspring/net/NetSceneHasLuckyBag;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "keyWord", "", "appId", "queryTicket", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "luckyBagInfo", "Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;", "getLuckyBagInfo", "()Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;", "setLuckyBagInfo", "(Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;)V", "getQueryTicket", "()J", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-eggspring_release"})
public final class c
  extends n
  implements k
{
  public static final a pzr;
  private final String appId;
  private f callback;
  private final String iiW;
  public com.tencent.mm.plugin.eggspring.b.c pzp;
  public final long pzq;
  private b rr;
  
  static
  {
    AppMethodBeat.i(108164);
    pzr = new a((byte)0);
    AppMethodBeat.o(108164);
  }
  
  public c(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(108163);
    this.iiW = paramString1;
    this.appId = paramString2;
    this.pzq = paramLong;
    paramString1 = new b.a();
    paramString1.c((a)new baw());
    paramString1.d((a)new bax());
    paramString1.Dl("/cgi-bin/mmoc-bin/expressionad/getexpression");
    paramString1.oP(2757);
    paramString1.oR(0);
    paramString1.oS(0);
    paramString1 = paramString1.aDC();
    p.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    paramString1 = this.rr.aEE();
    if (paramString1 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetExpressionReq");
      AppMethodBeat.o(108163);
      throw paramString1;
    }
    paramString1 = (baw)paramString1;
    paramString1.dld = this.iiW;
    paramString1.duW = this.appId;
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
    ad.i("MicroMsg.NetSceneHasLuckyBag", "onGYNetEnd errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.rr.aEF();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetExpressionResp");
        AppMethodBeat.o(108162);
        throw paramString;
      }
      paramq = (bax)paramq;
      ad.i("MicroMsg.NetSceneHasLuckyBag", "ret[%s] msg[%s] hasLuckyBag[%s] traceId[%s] interval[%s].", new Object[] { Integer.valueOf(paramq.ret), paramq.msg, Integer.valueOf(paramq.GxV), paramq.GxL, Integer.valueOf(paramq.guN) });
      if (paramq.ret == 0)
      {
        this.pzp = new com.tencent.mm.plugin.eggspring.b.c();
        switch (paramq.GxV)
        {
        default: 
          ad.e("MicroMsg.NetSceneHasLuckyBag", "err!!![%s].", new Object[] { Integer.valueOf(paramq.GxV) });
        }
      }
    }
    for (;;)
    {
      if (paramq.guN > 0)
      {
        paramArrayOfByte = this.pzp;
        if (paramArrayOfByte == null) {
          p.gfZ();
        }
        paramArrayOfByte.guN = paramq.guN;
      }
      paramq = this.callback;
      if (paramq == null) {
        p.bcb("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(108162);
      return;
      paramArrayOfByte = this.pzp;
      if (paramArrayOfByte == null) {
        p.gfZ();
      }
      paramArrayOfByte.pzi = true;
      paramArrayOfByte = this.pzp;
      if (paramArrayOfByte == null) {
        p.gfZ();
      }
      paramArrayOfByte.jSR = paramq.GxL;
      paramArrayOfByte = this.pzp;
      if (paramArrayOfByte == null) {
        p.gfZ();
      }
      paramArrayOfByte.iiW = this.iiW;
      paramArrayOfByte = this.pzp;
      if (paramArrayOfByte == null) {
        p.gfZ();
      }
      paramArrayOfByte.appId = this.appId;
      continue;
      paramArrayOfByte = this.pzp;
      if (paramArrayOfByte == null) {
        p.gfZ();
      }
      paramArrayOfByte.pzi = false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/eggspring/net/NetSceneHasLuckyBag$Companion;", "", "()V", "TAG", "", "plugin-eggspring_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.c.c
 * JD-Core Version:    0.7.0.1
 */