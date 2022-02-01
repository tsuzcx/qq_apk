package com.tencent.mm.plugin.eggspring.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbk;
import com.tencent.mm.protocal.protobuf.bbl;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/eggspring/net/NetSceneGetBrandCardContent;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "keyWord", "", "appId", "traceId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "brandCardContent", "Lcom/tencent/mm/plugin/eggspring/model/BrandCardContent;", "getBrandCardContent", "()Lcom/tencent/mm/plugin/eggspring/model/BrandCardContent;", "setBrandCardContent", "(Lcom/tencent/mm/plugin/eggspring/model/BrandCardContent;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-eggspring_release"})
public final class b
  extends n
  implements k
{
  public static final b.a pFS;
  private f callback;
  public com.tencent.mm.plugin.eggspring.b.a pFR;
  private com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(108160);
    pFS = new b.a((byte)0);
    AppMethodBeat.o(108160);
  }
  
  public b(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(108159);
    Object localObject = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject).c((com.tencent.mm.bw.a)new bbk());
    ((com.tencent.mm.ak.b.a)localObject).d((com.tencent.mm.bw.a)new bbl());
    ((com.tencent.mm.ak.b.a)localObject).DN("/cgi-bin/mmoc-bin/expressionad/getexpressionad");
    ((com.tencent.mm.ak.b.a)localObject).oS(2809);
    ((com.tencent.mm.ak.b.a)localObject).oU(0);
    ((com.tencent.mm.ak.b.a)localObject).oV(0);
    localObject = ((com.tencent.mm.ak.b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.ak.b)localObject);
    localObject = this.rr.aEU();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetExpressionAdReq");
      AppMethodBeat.o(108159);
      throw paramString1;
    }
    localObject = (bbk)localObject;
    ((bbk)localObject).dmf = paramString1;
    ((bbk)localObject).dwb = paramString2;
    ((bbk)localObject).GRl = paramString3;
    AppMethodBeat.o(108159);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(108157);
    p.h(parame, "dispatcher");
    p.h(paramf, "callback");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
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
    ae.i("MicroMsg.NetSceneGetBrandCardContent", "onGYNetEnd errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.rr.aEV();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetExpressionAdResp");
        AppMethodBeat.o(108158);
        throw paramString;
      }
      paramq = (bbl)paramq;
      ae.d("MicroMsg.NetSceneGetBrandCardContent", "ret[%s] msg[%s] cardType[%s] appId[%s] traceId[%s].", new Object[] { Integer.valueOf(paramq.ret), paramq.msg, Integer.valueOf(paramq.FMm), paramq.dwb, paramq.GRl });
      if (paramq.ret == 0)
      {
        this.pFR = new com.tencent.mm.plugin.eggspring.b.a();
        paramArrayOfByte = this.pFR;
        if (paramArrayOfByte == null) {
          p.gkB();
        }
        paramArrayOfByte.pFz = paramq.FMm;
        paramArrayOfByte = this.pFR;
        if (paramArrayOfByte == null) {
          p.gkB();
        }
        paramArrayOfByte.pFA = paramq.GRr;
        paramArrayOfByte = this.pFR;
        if (paramArrayOfByte == null) {
          p.gkB();
        }
        paramArrayOfByte.pFB = paramq.GRn;
        paramArrayOfByte = this.pFR;
        if (paramArrayOfByte == null) {
          p.gkB();
        }
        paramArrayOfByte.pFC = paramq.GRp;
        paramArrayOfByte = this.pFR;
        if (paramArrayOfByte == null) {
          p.gkB();
        }
        paramArrayOfByte.pFD = paramq.GRm;
        paramArrayOfByte = this.pFR;
        if (paramArrayOfByte == null) {
          p.gkB();
        }
        paramArrayOfByte.pFE = paramq.Dps;
        paramArrayOfByte = this.pFR;
        if (paramArrayOfByte == null) {
          p.gkB();
        }
        paramArrayOfByte.pFF = paramq.GRt;
        paramArrayOfByte = this.pFR;
        if (paramArrayOfByte == null) {
          p.gkB();
        }
        paramArrayOfByte.pFG = paramq.GRq;
        paramArrayOfByte = this.pFR;
        if (paramArrayOfByte == null) {
          p.gkB();
        }
        paramArrayOfByte.pFH = paramq.GRo;
        paramArrayOfByte = this.pFR;
        if (paramArrayOfByte == null) {
          p.gkB();
        }
        paramArrayOfByte.pFI = paramq.GRu;
        paramArrayOfByte = this.pFR;
        if (paramArrayOfByte == null) {
          p.gkB();
        }
        paramArrayOfByte.pFJ = paramq.GRs;
        paramArrayOfByte = this.pFR;
        if (paramArrayOfByte == null) {
          p.gkB();
        }
        paramArrayOfByte.appId = paramq.dwb;
        paramArrayOfByte = this.pFR;
        if (paramArrayOfByte == null) {
          p.gkB();
        }
        paramArrayOfByte.pFK = paramq.pFK;
        paramArrayOfByte = this.pFR;
        if (paramArrayOfByte == null) {
          p.gkB();
        }
        paramArrayOfByte.jWi = paramq.GRl;
      }
    }
    paramq = this.callback;
    if (paramq == null) {
      p.bdF("callback");
    }
    paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    AppMethodBeat.o(108158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.c.b
 * JD-Core Version:    0.7.0.1
 */