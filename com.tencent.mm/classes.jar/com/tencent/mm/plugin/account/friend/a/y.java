package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.le;
import com.tencent.mm.protocal.protobuf.lf;
import com.tencent.mm.sdk.platformtools.ac;

public final class y
  extends n
  implements k
{
  private g callback;
  public b gvE;
  
  public y(String paramString)
  {
    AppMethodBeat.i(184422);
    b.a locala = new b.a();
    locala.funcId = getType();
    le localle = new le();
    localle.doP = paramString;
    locala.hvt = localle;
    locala.uri = "/cgi-bin/micromsg-bin/bindoldwx";
    locala.hvu = new lf();
    this.gvE = locala.aAz();
    AppMethodBeat.o(184422);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(184423);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
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
    ac.i("MicroMsg.NetSceneBindOldWx", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(184424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.y
 * JD-Core Version:    0.7.0.1
 */