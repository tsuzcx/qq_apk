package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.uf;
import com.tencent.mm.protocal.protobuf.ug;
import com.tencent.mm.sdk.platformtools.ae;

public final class j
  extends n
  implements k
{
  private f callback;
  private b gRX;
  public ug pgZ;
  
  public j()
  {
    AppMethodBeat.i(63822);
    b.a locala = new b.a();
    locala.hQF = new uf();
    locala.hQG = new ug();
    locala.funcId = 1256;
    locala.uri = "/cgi-bin/mmpay-bin/f2fannounce";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.gRX = locala.aDS();
    ae.d("MicroMsg.NetSceneF2fAnnouce", "do cgi");
    AppMethodBeat.o(63822);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(63823);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
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
    ae.i("MicroMsg.NetSceneF2fAnnouce", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.pgZ = ((ug)((b)paramq).hQE.hQJ);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.j
 * JD-Core Version:    0.7.0.1
 */