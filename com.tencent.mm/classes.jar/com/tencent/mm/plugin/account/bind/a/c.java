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
import com.tencent.mm.protocal.protobuf.drc;
import com.tencent.mm.protocal.protobuf.drd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;

public final class c
  extends n
  implements k
{
  private f callback;
  private final b rr;
  
  public c()
  {
    AppMethodBeat.i(109749);
    b.a locala = new b.a();
    locala.hQF = new drc();
    locala.hQG = new drd();
    locala.uri = "/cgi-bin/micromsg-bin/unbindlinkedincontact";
    locala.funcId = getType();
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((drc)this.rr.hQD.hQJ).FSQ = 1;
    AppMethodBeat.o(109749);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(109750);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(109750);
    return i;
  }
  
  public final int getType()
  {
    return 550;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109751);
    ae.d("MicroMsg.NetSceneUnBindLinkedinContact", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      g.ajR().ajA().set(286722, "");
      g.ajR().ajA().set(286721, "");
      g.ajR().ajA().set(286723, "");
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(109751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.c
 * JD-Core Version:    0.7.0.1
 */