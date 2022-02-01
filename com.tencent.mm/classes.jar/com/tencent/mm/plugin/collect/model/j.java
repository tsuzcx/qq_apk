package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.protocal.protobuf.rz;
import com.tencent.mm.sdk.platformtools.ad;

public final class j
  extends n
  implements k
{
  private g callback;
  private b iaa;
  public rz nTF;
  
  public j()
  {
    AppMethodBeat.i(63822);
    b.a locala = new b.a();
    locala.gUU = new ry();
    locala.gUV = new rz();
    locala.funcId = 1256;
    locala.uri = "/cgi-bin/mmpay-bin/f2fannounce";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.iaa = locala.atI();
    ad.d("MicroMsg.NetSceneF2fAnnouce", "do cgi");
    AppMethodBeat.o(63822);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(63823);
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
    AppMethodBeat.o(63823);
    return i;
  }
  
  public final int getType()
  {
    return 1256;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63824);
    ad.i("MicroMsg.NetSceneF2fAnnouce", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.nTF = ((rz)((b)paramq).gUT.gUX);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.j
 * JD-Core Version:    0.7.0.1
 */