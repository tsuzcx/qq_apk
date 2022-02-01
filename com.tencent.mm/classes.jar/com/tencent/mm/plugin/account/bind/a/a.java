package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.kw;
import com.tencent.mm.protocal.protobuf.kx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;

public final class a
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private final b rr;
  
  public a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(109742);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new kw();
    ((b.a)localObject).gUV = new kx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindlinkedincontact";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (kw)this.rr.gUS.gUX;
    ((kw)localObject).CCB = 1;
    ((kw)localObject).CFD = paramInt;
    ((kw)localObject).CFE = paramString1;
    ((kw)localObject).CFF = paramString2;
    ((kw)localObject).CFG = paramString3;
    ((kw)localObject).CFH = paramString4;
    ((kw)localObject).CFI = paramString5;
    ((kw)localObject).CFJ = paramString6;
    ((kw)localObject).CFK = paramString7;
    AppMethodBeat.o(109742);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(109743);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(109743);
    return i;
  }
  
  public final int getType()
  {
    return 549;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109744);
    ad.d("MicroMsg.NetSceneBindLinkedinContact", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (kw)this.rr.gUS.gUX;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.g.afB().afk().set(286722, paramq.CFF);
      com.tencent.mm.kernel.g.afB().afk().set(286721, paramq.CFE);
      com.tencent.mm.kernel.g.afB().afk().set(286723, paramq.CFG);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(109744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.a
 * JD-Core Version:    0.7.0.1
 */