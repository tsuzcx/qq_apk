package com.tencent.mm.plugin.eggspring.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aww;
import com.tencent.mm.protocal.protobuf.awx;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/eggspring/net/NetSceneGetBrandCardContent;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "keyWord", "", "appId", "traceId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "brandCardContent", "Lcom/tencent/mm/plugin/eggspring/model/BrandCardContent;", "getBrandCardContent", "()Lcom/tencent/mm/plugin/eggspring/model/BrandCardContent;", "setBrandCardContent", "(Lcom/tencent/mm/plugin/eggspring/model/BrandCardContent;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-eggspring_release"})
public final class b
  extends n
  implements com.tencent.mm.network.k
{
  public static final b.a oVE;
  private g callback;
  public com.tencent.mm.plugin.eggspring.b.a oVD;
  private com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(108160);
    oVE = new b.a((byte)0);
    AppMethodBeat.o(108160);
  }
  
  public b(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(108159);
    Object localObject = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject).c((com.tencent.mm.bw.a)new aww());
    ((com.tencent.mm.ak.b.a)localObject).d((com.tencent.mm.bw.a)new awx());
    ((com.tencent.mm.ak.b.a)localObject).Am("/cgi-bin/mmoc-bin/expressionad/getexpressionad");
    ((com.tencent.mm.ak.b.a)localObject).op(2809);
    ((com.tencent.mm.ak.b.a)localObject).or(0);
    ((com.tencent.mm.ak.b.a)localObject).os(0);
    localObject = ((com.tencent.mm.ak.b.a)localObject).aAz();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.ak.b)localObject);
    localObject = this.rr.aBC();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetExpressionAdReq");
      AppMethodBeat.o(108159);
      throw paramString1;
    }
    localObject = (aww)localObject;
    ((aww)localObject).cZL = paramString1;
    ((aww)localObject).djj = paramString2;
    ((aww)localObject).EOI = paramString3;
    AppMethodBeat.o(108159);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(108157);
    d.g.b.k.h(parame, "dispatcher");
    d.g.b.k.h(paramg, "callback");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(108157);
    return i;
  }
  
  public final int getType()
  {
    return 2809;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108158);
    ac.i("MicroMsg.NetSceneGetBrandCardContent", "onGYNetEnd errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.rr.aBD();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetExpressionAdResp");
        AppMethodBeat.o(108158);
        throw paramString;
      }
      paramq = (awx)paramq;
      ac.d("MicroMsg.NetSceneGetBrandCardContent", "ret[%s] msg[%s] cardType[%s] appId[%s] traceId[%s].", new Object[] { Integer.valueOf(paramq.ret), paramq.bIO, Integer.valueOf(paramq.DOD), paramq.djj, paramq.EOI });
      if (paramq.ret == 0)
      {
        this.oVD = new com.tencent.mm.plugin.eggspring.b.a();
        paramArrayOfByte = this.oVD;
        if (paramArrayOfByte == null) {
          d.g.b.k.fOy();
        }
        paramArrayOfByte.oVl = paramq.DOD;
        paramArrayOfByte = this.oVD;
        if (paramArrayOfByte == null) {
          d.g.b.k.fOy();
        }
        paramArrayOfByte.oVm = paramq.EOO;
        paramArrayOfByte = this.oVD;
        if (paramArrayOfByte == null) {
          d.g.b.k.fOy();
        }
        paramArrayOfByte.oVn = paramq.EOK;
        paramArrayOfByte = this.oVD;
        if (paramArrayOfByte == null) {
          d.g.b.k.fOy();
        }
        paramArrayOfByte.oVo = paramq.EOM;
        paramArrayOfByte = this.oVD;
        if (paramArrayOfByte == null) {
          d.g.b.k.fOy();
        }
        paramArrayOfByte.oVp = paramq.EOJ;
        paramArrayOfByte = this.oVD;
        if (paramArrayOfByte == null) {
          d.g.b.k.fOy();
        }
        paramArrayOfByte.oVq = paramq.Bxu;
        paramArrayOfByte = this.oVD;
        if (paramArrayOfByte == null) {
          d.g.b.k.fOy();
        }
        paramArrayOfByte.oVr = paramq.EOQ;
        paramArrayOfByte = this.oVD;
        if (paramArrayOfByte == null) {
          d.g.b.k.fOy();
        }
        paramArrayOfByte.oVs = paramq.EON;
        paramArrayOfByte = this.oVD;
        if (paramArrayOfByte == null) {
          d.g.b.k.fOy();
        }
        paramArrayOfByte.oVt = paramq.EOL;
        paramArrayOfByte = this.oVD;
        if (paramArrayOfByte == null) {
          d.g.b.k.fOy();
        }
        paramArrayOfByte.oVu = paramq.EOR;
        paramArrayOfByte = this.oVD;
        if (paramArrayOfByte == null) {
          d.g.b.k.fOy();
        }
        paramArrayOfByte.oVv = paramq.EOP;
        paramArrayOfByte = this.oVD;
        if (paramArrayOfByte == null) {
          d.g.b.k.fOy();
        }
        paramArrayOfByte.appId = paramq.djj;
        paramArrayOfByte = this.oVD;
        if (paramArrayOfByte == null) {
          d.g.b.k.fOy();
        }
        paramArrayOfByte.oVw = paramq.oVw;
        paramArrayOfByte = this.oVD;
        if (paramArrayOfByte == null) {
          d.g.b.k.fOy();
        }
        paramArrayOfByte.jyU = paramq.EOI;
      }
    }
    paramq = this.callback;
    if (paramq == null) {
      d.g.b.k.aVY("callback");
    }
    paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    AppMethodBeat.o(108158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.c.b
 * JD-Core Version:    0.7.0.1
 */