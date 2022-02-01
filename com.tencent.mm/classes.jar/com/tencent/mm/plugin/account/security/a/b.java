package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.biq;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends n
  implements k
{
  private f callback;
  public biq jkK;
  private com.tencent.mm.ak.b rr;
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(125515);
    b.a locala = new b.a();
    locala.hQF = new bip();
    locala.hQG = new biq();
    locala.uri = "/cgi-bin/micromsg-bin/getsafetyinfo";
    locala.funcId = 850;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(125515);
    return i;
  }
  
  public final int getType()
  {
    return 850;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125514);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ae.e("MicroMsg.NetSceneGetSafetyInfo", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.jkK = ((biq)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.b
 * JD-Core Version:    0.7.0.1
 */