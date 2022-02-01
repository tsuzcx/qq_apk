package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.lc;
import com.tencent.mm.protocal.protobuf.ld;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;

public final class a
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private final b rr;
  
  public a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(109742);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new lc();
    ((b.a)localObject).hvu = new ld();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindlinkedincontact";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (lc)this.rr.hvr.hvw;
    ((lc)localObject).DUY = 1;
    ((lc)localObject).DYd = paramInt;
    ((lc)localObject).DYe = paramString1;
    ((lc)localObject).DYf = paramString2;
    ((lc)localObject).DYg = paramString3;
    ((lc)localObject).DYh = paramString4;
    ((lc)localObject).DYi = paramString5;
    ((lc)localObject).DYj = paramString6;
    ((lc)localObject).DYk = paramString7;
    AppMethodBeat.o(109742);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
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
    ac.d("MicroMsg.NetSceneBindLinkedinContact", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (lc)this.rr.hvr.hvw;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.g.agR().agA().set(286722, paramq.DYf);
      com.tencent.mm.kernel.g.agR().agA().set(286721, paramq.DYe);
      com.tencent.mm.kernel.g.agR().agA().set(286723, paramq.DYg);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(109744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.a
 * JD-Core Version:    0.7.0.1
 */