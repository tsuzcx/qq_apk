package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.lm;
import com.tencent.mm.protocal.protobuf.ln;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;

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
    ((b.a)localObject).hQF = new lm();
    ((b.a)localObject).hQG = new ln();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindlinkedincontact";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (lm)this.rr.hQD.hQJ;
    ((lm)localObject).FSQ = 1;
    ((lm)localObject).FVU = paramInt;
    ((lm)localObject).FVV = paramString1;
    ((lm)localObject).FVW = paramString2;
    ((lm)localObject).FVX = paramString3;
    ((lm)localObject).FVY = paramString4;
    ((lm)localObject).FVZ = paramString5;
    ((lm)localObject).FWa = paramString6;
    ((lm)localObject).FWb = paramString7;
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
    ae.d("MicroMsg.NetSceneBindLinkedinContact", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (lm)this.rr.hQD.hQJ;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      g.ajR().ajA().set(286722, paramq.FVW);
      g.ajR().ajA().set(286721, paramq.FVV);
      g.ajR().ajA().set(286723, paramq.FVX);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(109744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.a
 * JD-Core Version:    0.7.0.1
 */