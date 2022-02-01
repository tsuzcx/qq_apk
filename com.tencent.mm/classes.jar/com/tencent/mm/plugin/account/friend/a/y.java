package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.lo;
import com.tencent.mm.protocal.protobuf.lp;
import com.tencent.mm.sdk.platformtools.ae;

public final class y
  extends n
  implements k
{
  private f callback;
  public b gRX;
  
  public y(String paramString)
  {
    AppMethodBeat.i(184422);
    b.a locala = new b.a();
    locala.funcId = getType();
    lo locallo = new lo();
    locallo.dBI = paramString;
    locala.hQF = locallo;
    locala.uri = "/cgi-bin/micromsg-bin/bindoldwx";
    locala.hQG = new lp();
    this.gRX = locala.aDS();
    AppMethodBeat.o(184422);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(184423);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
    AppMethodBeat.o(184423);
    return i;
  }
  
  public final int getType()
  {
    return 870;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(184424);
    ae.i("MicroMsg.NetSceneBindOldWx", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(184424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.y
 * JD-Core Version:    0.7.0.1
 */