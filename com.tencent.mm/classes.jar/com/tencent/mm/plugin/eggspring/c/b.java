package com.tencent.mm.plugin.eggspring.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/eggspring/net/NetSceneGetBrandCardContent;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "keyWord", "", "appId", "traceId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "brandCardContent", "Lcom/tencent/mm/plugin/eggspring/model/BrandCardContent;", "getBrandCardContent", "()Lcom/tencent/mm/plugin/eggspring/model/BrandCardContent;", "setBrandCardContent", "(Lcom/tencent/mm/plugin/eggspring/model/BrandCardContent;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-eggspring_release"})
public final class b
  extends n
  implements k
{
  public static final b.a pzo;
  private f callback;
  public com.tencent.mm.plugin.eggspring.b.a pzn;
  private com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(108160);
    pzo = new b.a((byte)0);
    AppMethodBeat.o(108160);
  }
  
  public b(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(108159);
    Object localObject = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject).c((com.tencent.mm.bx.a)new bau());
    ((com.tencent.mm.al.b.a)localObject).d((com.tencent.mm.bx.a)new bav());
    ((com.tencent.mm.al.b.a)localObject).Dl("/cgi-bin/mmoc-bin/expressionad/getexpressionad");
    ((com.tencent.mm.al.b.a)localObject).oP(2809);
    ((com.tencent.mm.al.b.a)localObject).oR(0);
    ((com.tencent.mm.al.b.a)localObject).oS(0);
    localObject = ((com.tencent.mm.al.b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.al.b)localObject);
    localObject = this.rr.aEE();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetExpressionAdReq");
      AppMethodBeat.o(108159);
      throw paramString1;
    }
    localObject = (bau)localObject;
    ((bau)localObject).dld = paramString1;
    ((bau)localObject).duW = paramString2;
    ((bau)localObject).GxL = paramString3;
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
    ad.i("MicroMsg.NetSceneGetBrandCardContent", "onGYNetEnd errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.rr.aEF();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetExpressionAdResp");
        AppMethodBeat.o(108158);
        throw paramString;
      }
      paramq = (bav)paramq;
      ad.d("MicroMsg.NetSceneGetBrandCardContent", "ret[%s] msg[%s] cardType[%s] appId[%s] traceId[%s].", new Object[] { Integer.valueOf(paramq.ret), paramq.msg, Integer.valueOf(paramq.FtO), paramq.duW, paramq.GxL });
      if (paramq.ret == 0)
      {
        this.pzn = new com.tencent.mm.plugin.eggspring.b.a();
        paramArrayOfByte = this.pzn;
        if (paramArrayOfByte == null) {
          p.gfZ();
        }
        paramArrayOfByte.pyV = paramq.FtO;
        paramArrayOfByte = this.pzn;
        if (paramArrayOfByte == null) {
          p.gfZ();
        }
        paramArrayOfByte.pyW = paramq.GxR;
        paramArrayOfByte = this.pzn;
        if (paramArrayOfByte == null) {
          p.gfZ();
        }
        paramArrayOfByte.pyX = paramq.GxN;
        paramArrayOfByte = this.pzn;
        if (paramArrayOfByte == null) {
          p.gfZ();
        }
        paramArrayOfByte.pyY = paramq.GxP;
        paramArrayOfByte = this.pzn;
        if (paramArrayOfByte == null) {
          p.gfZ();
        }
        paramArrayOfByte.pyZ = paramq.GxM;
        paramArrayOfByte = this.pzn;
        if (paramArrayOfByte == null) {
          p.gfZ();
        }
        paramArrayOfByte.pza = paramq.CXN;
        paramArrayOfByte = this.pzn;
        if (paramArrayOfByte == null) {
          p.gfZ();
        }
        paramArrayOfByte.pzb = paramq.GxT;
        paramArrayOfByte = this.pzn;
        if (paramArrayOfByte == null) {
          p.gfZ();
        }
        paramArrayOfByte.pzc = paramq.GxQ;
        paramArrayOfByte = this.pzn;
        if (paramArrayOfByte == null) {
          p.gfZ();
        }
        paramArrayOfByte.pzd = paramq.GxO;
        paramArrayOfByte = this.pzn;
        if (paramArrayOfByte == null) {
          p.gfZ();
        }
        paramArrayOfByte.pze = paramq.GxU;
        paramArrayOfByte = this.pzn;
        if (paramArrayOfByte == null) {
          p.gfZ();
        }
        paramArrayOfByte.pzf = paramq.GxS;
        paramArrayOfByte = this.pzn;
        if (paramArrayOfByte == null) {
          p.gfZ();
        }
        paramArrayOfByte.appId = paramq.duW;
        paramArrayOfByte = this.pzn;
        if (paramArrayOfByte == null) {
          p.gfZ();
        }
        paramArrayOfByte.pzg = paramq.pzg;
        paramArrayOfByte = this.pzn;
        if (paramArrayOfByte == null) {
          p.gfZ();
        }
        paramArrayOfByte.jSR = paramq.GxL;
      }
    }
    paramq = this.callback;
    if (paramq == null) {
      p.bcb("callback");
    }
    paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    AppMethodBeat.o(108158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.c.b
 * JD-Core Version:    0.7.0.1
 */