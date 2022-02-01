package com.tencent.mm.plugin.eggspring.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ats;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/eggspring/net/NetSceneHasLuckyBag;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "keyWord", "", "appId", "queryTicket", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "luckyBagInfo", "Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;", "getLuckyBagInfo", "()Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;", "setLuckyBagInfo", "(Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;)V", "getQueryTicket", "()J", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-eggspring_release"})
public final class c
  extends n
  implements com.tencent.mm.network.k
{
  public static final a osh;
  private final String appId;
  private g callback;
  private final String hpg;
  public com.tencent.mm.plugin.eggspring.b.c osf;
  public final long osg;
  private b rr;
  
  static
  {
    AppMethodBeat.i(108164);
    osh = new a((byte)0);
    AppMethodBeat.o(108164);
  }
  
  public c(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(108163);
    this.hpg = paramString1;
    this.appId = paramString2;
    this.osg = paramLong;
    paramString1 = new b.a();
    paramString1.c((a)new ats());
    paramString1.d((a)new att());
    paramString1.wg("/cgi-bin/mmoc-bin/expressionad/getexpression");
    paramString1.nB(2757);
    paramString1.nD(0);
    paramString1.nE(0);
    paramString1 = paramString1.atI();
    d.g.b.k.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    paramString1 = this.rr.auL();
    if (paramString1 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetExpressionReq");
      AppMethodBeat.o(108163);
      throw paramString1;
    }
    paramString1 = (ats)paramString1;
    paramString1.dcm = this.hpg;
    paramString1.dlB = this.appId;
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
    ad.i("MicroMsg.NetSceneHasLuckyBag", "onGYNetEnd errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.rr.auM();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetExpressionResp");
        AppMethodBeat.o(108162);
        throw paramString;
      }
      paramq = (att)paramq;
      ad.i("MicroMsg.NetSceneHasLuckyBag", "ret[%s] msg[%s] hasLuckyBag[%s] traceId[%s] interval[%s].", new Object[] { Integer.valueOf(paramq.ret), paramq.bLg, Integer.valueOf(paramq.DtK), paramq.DtA, Integer.valueOf(paramq.fWw) });
      if (paramq.ret == 0)
      {
        this.osf = new com.tencent.mm.plugin.eggspring.b.c();
        switch (paramq.DtK)
        {
        default: 
          ad.e("MicroMsg.NetSceneHasLuckyBag", "err!!![%s].", new Object[] { Integer.valueOf(paramq.DtK) });
        }
      }
    }
    for (;;)
    {
      if (paramq.fWw > 0)
      {
        paramArrayOfByte = this.osf;
        if (paramArrayOfByte == null) {
          d.g.b.k.fvU();
        }
        paramArrayOfByte.fWw = paramq.fWw;
      }
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aPZ("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(108162);
      return;
      paramArrayOfByte = this.osf;
      if (paramArrayOfByte == null) {
        d.g.b.k.fvU();
      }
      paramArrayOfByte.orY = true;
      paramArrayOfByte = this.osf;
      if (paramArrayOfByte == null) {
        d.g.b.k.fvU();
      }
      paramArrayOfByte.iYE = paramq.DtA;
      paramArrayOfByte = this.osf;
      if (paramArrayOfByte == null) {
        d.g.b.k.fvU();
      }
      paramArrayOfByte.hpg = this.hpg;
      paramArrayOfByte = this.osf;
      if (paramArrayOfByte == null) {
        d.g.b.k.fvU();
      }
      paramArrayOfByte.appId = this.appId;
      continue;
      paramArrayOfByte = this.osf;
      if (paramArrayOfByte == null) {
        d.g.b.k.fvU();
      }
      paramArrayOfByte.orY = false;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/eggspring/net/NetSceneHasLuckyBag$Companion;", "", "()V", "TAG", "", "plugin-eggspring_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.c.c
 * JD-Core Version:    0.7.0.1
 */