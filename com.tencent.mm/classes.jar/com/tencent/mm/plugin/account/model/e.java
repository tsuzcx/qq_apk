package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.vy;
import com.tencent.mm.protocal.protobuf.vz;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends n
  implements k
{
  private f callback;
  public String ffB;
  private b hWL;
  
  public e(String paramString)
  {
    AppMethodBeat.i(207102);
    b.a locala = new b.a();
    vy localvy = new vy();
    localvy.ffB = paramString;
    this.ffB = paramString;
    locala.hNM = localvy;
    locala.hNN = new vz();
    locala.uri = "/cgi-bin/micromsg-bin/checkaliasvalid";
    locala.funcId = getType();
    this.hWL = locala.aDC();
    AppMethodBeat.o(207102);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(207103);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
    AppMethodBeat.o(207103);
    return i;
  }
  
  public final int getType()
  {
    return 3516;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207104);
    ad.i("MicroMsg.NetSceneCheckAliasValid", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(207104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.e
 * JD-Core Version:    0.7.0.1
 */