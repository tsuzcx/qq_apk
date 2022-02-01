package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.lm;
import com.tencent.mm.protocal.protobuf.ln;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;

public final class a
  extends n
  implements k
{
  private f callback;
  private final b rr;
  
  public a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(109742);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new lm();
    ((b.a)localObject).hNN = new ln();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindlinkedincontact";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (lm)this.rr.hNK.hNQ;
    ((lm)localObject).FAt = 1;
    ((lm)localObject).FDz = paramInt;
    ((lm)localObject).FDA = paramString1;
    ((lm)localObject).FDB = paramString2;
    ((lm)localObject).FDC = paramString3;
    ((lm)localObject).FDD = paramString4;
    ((lm)localObject).FDE = paramString5;
    ((lm)localObject).FDF = paramString6;
    ((lm)localObject).FDG = paramString7;
    AppMethodBeat.o(109742);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(109743);
    this.callback = paramf;
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
    paramq = (lm)this.rr.hNK.hNQ;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      g.ajC().ajl().set(286722, paramq.FDB);
      g.ajC().ajl().set(286721, paramq.FDA);
      g.ajC().ajl().set(286723, paramq.FDC);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(109744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.a
 * JD-Core Version:    0.7.0.1
 */