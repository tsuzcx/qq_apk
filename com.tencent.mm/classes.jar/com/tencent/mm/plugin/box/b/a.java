package com.tencent.mm.plugin.box.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.blr;
import com.tencent.mm.protocal.protobuf.bls;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends n
  implements k
{
  private f callback;
  public String dyb;
  private b hZD;
  private long oaP;
  public bls oaQ;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76328);
    this.dyb = paramString1;
    b.a locala = new b.a();
    locala.funcId = getType();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getweappbox";
    locala.hQF = new blr();
    locala.hQG = new bls();
    this.hZD = locala.aDS();
    ((blr)this.hZD.hQD.hQJ).GYL = paramString2;
    ae.i("MicroMsg.Box.NetSceneBox", "Create NetSceneBox %s %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(76328);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(76329);
    this.oaP = System.currentTimeMillis();
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(76329);
    return i;
  }
  
  public final int getType()
  {
    return 1869;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(76330);
    ae.i("MicroMsg.Box.NetSceneBox", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.oaP) });
    this.oaQ = ((bls)this.hZD.hQE.hQJ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(76330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.box.b.a
 * JD-Core Version:    0.7.0.1
 */