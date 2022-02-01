package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ky;
import com.tencent.mm.protocal.protobuf.kz;
import com.tencent.mm.sdk.platformtools.ad;

public final class y
  extends n
  implements k
{
  private g callback;
  public b iaa;
  
  public y(String paramString)
  {
    AppMethodBeat.i(184422);
    b.a locala = new b.a();
    locala.funcId = getType();
    ky localky = new ky();
    localky.dre = paramString;
    locala.gUU = localky;
    locala.uri = "/cgi-bin/micromsg-bin/bindoldwx";
    locala.gUV = new kz();
    this.iaa = locala.atI();
    AppMethodBeat.o(184422);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(184423);
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
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
    ad.i("MicroMsg.NetSceneBindOldWx", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(184424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.y
 * JD-Core Version:    0.7.0.1
 */