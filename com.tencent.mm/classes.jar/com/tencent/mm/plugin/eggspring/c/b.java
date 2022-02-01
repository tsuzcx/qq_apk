package com.tencent.mm.plugin.eggspring.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/eggspring/net/NetSceneGetBrandCardContent;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "keyWord", "", "appId", "traceId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "brandCardContent", "Lcom/tencent/mm/plugin/eggspring/model/BrandCardContent;", "getBrandCardContent", "()Lcom/tencent/mm/plugin/eggspring/model/BrandCardContent;", "setBrandCardContent", "(Lcom/tencent/mm/plugin/eggspring/model/BrandCardContent;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-eggspring_release"})
public final class b
  extends n
  implements com.tencent.mm.network.k
{
  public static final b.a ose;
  private g callback;
  public com.tencent.mm.plugin.eggspring.b.a osd;
  private com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(108160);
    ose = new b.a((byte)0);
    AppMethodBeat.o(108160);
  }
  
  public b(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(108159);
    Object localObject = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject).c((com.tencent.mm.bx.a)new atq());
    ((com.tencent.mm.al.b.a)localObject).d((com.tencent.mm.bx.a)new atr());
    ((com.tencent.mm.al.b.a)localObject).wg("/cgi-bin/mmoc-bin/expressionad/getexpressionad");
    ((com.tencent.mm.al.b.a)localObject).nB(2809);
    ((com.tencent.mm.al.b.a)localObject).nD(0);
    ((com.tencent.mm.al.b.a)localObject).nE(0);
    localObject = ((com.tencent.mm.al.b.a)localObject).atI();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.al.b)localObject);
    localObject = this.rr.auL();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetExpressionAdReq");
      AppMethodBeat.o(108159);
      throw paramString1;
    }
    localObject = (atq)localObject;
    ((atq)localObject).dcm = paramString1;
    ((atq)localObject).dlB = paramString2;
    ((atq)localObject).DtA = paramString3;
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
    ad.i("MicroMsg.NetSceneGetBrandCardContent", "onGYNetEnd errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.rr.auM();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetExpressionAdResp");
        AppMethodBeat.o(108158);
        throw paramString;
      }
      paramq = (atr)paramq;
      ad.d("MicroMsg.NetSceneGetBrandCardContent", "ret[%s] msg[%s] cardType[%s] appId[%s] traceId[%s].", new Object[] { Integer.valueOf(paramq.ret), paramq.bLg, Integer.valueOf(paramq.Cwg), paramq.dlB, paramq.DtA });
      if (paramq.ret == 0)
      {
        this.osd = new com.tencent.mm.plugin.eggspring.b.a();
        paramArrayOfByte = this.osd;
        if (paramArrayOfByte == null) {
          d.g.b.k.fvU();
        }
        paramArrayOfByte.orL = paramq.Cwg;
        paramArrayOfByte = this.osd;
        if (paramArrayOfByte == null) {
          d.g.b.k.fvU();
        }
        paramArrayOfByte.orM = paramq.DtG;
        paramArrayOfByte = this.osd;
        if (paramArrayOfByte == null) {
          d.g.b.k.fvU();
        }
        paramArrayOfByte.orN = paramq.DtC;
        paramArrayOfByte = this.osd;
        if (paramArrayOfByte == null) {
          d.g.b.k.fvU();
        }
        paramArrayOfByte.orO = paramq.DtE;
        paramArrayOfByte = this.osd;
        if (paramArrayOfByte == null) {
          d.g.b.k.fvU();
        }
        paramArrayOfByte.orP = paramq.DtB;
        paramArrayOfByte = this.osd;
        if (paramArrayOfByte == null) {
          d.g.b.k.fvU();
        }
        paramArrayOfByte.orQ = paramq.Afa;
        paramArrayOfByte = this.osd;
        if (paramArrayOfByte == null) {
          d.g.b.k.fvU();
        }
        paramArrayOfByte.orR = paramq.DtI;
        paramArrayOfByte = this.osd;
        if (paramArrayOfByte == null) {
          d.g.b.k.fvU();
        }
        paramArrayOfByte.orS = paramq.DtF;
        paramArrayOfByte = this.osd;
        if (paramArrayOfByte == null) {
          d.g.b.k.fvU();
        }
        paramArrayOfByte.orT = paramq.DtD;
        paramArrayOfByte = this.osd;
        if (paramArrayOfByte == null) {
          d.g.b.k.fvU();
        }
        paramArrayOfByte.orU = paramq.DtJ;
        paramArrayOfByte = this.osd;
        if (paramArrayOfByte == null) {
          d.g.b.k.fvU();
        }
        paramArrayOfByte.orV = paramq.DtH;
        paramArrayOfByte = this.osd;
        if (paramArrayOfByte == null) {
          d.g.b.k.fvU();
        }
        paramArrayOfByte.appId = paramq.dlB;
        paramArrayOfByte = this.osd;
        if (paramArrayOfByte == null) {
          d.g.b.k.fvU();
        }
        paramArrayOfByte.orW = paramq.orW;
        paramArrayOfByte = this.osd;
        if (paramArrayOfByte == null) {
          d.g.b.k.fvU();
        }
        paramArrayOfByte.iYE = paramq.DtA;
      }
    }
    paramq = this.callback;
    if (paramq == null) {
      d.g.b.k.aPZ("callback");
    }
    paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    AppMethodBeat.o(108158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.c.b
 * JD-Core Version:    0.7.0.1
 */