package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ddg;
import com.tencent.mm.protocal.protobuf.ddh;
import com.tencent.mm.sdk.platformtools.ae;

public final class p
  extends n
  implements k
{
  private f callback;
  private b gRX;
  private ddg phs;
  
  public p(String paramString)
  {
    AppMethodBeat.i(63838);
    b.a locala = new b.a();
    locala.hQF = new ddg();
    locala.hQG = new ddh();
    locala.funcId = 304;
    locala.uri = "/cgi-bin/micromsg-bin/setpushsound";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.gRX = locala.aDS();
    this.phs = ((ddg)this.gRX.hQD.hQJ);
    this.phs.nJA = 3;
    this.phs.HLb = paramString;
    ae.i("MicroMsg.NetSceneSetPushSound", "type: %d, sound: %s", new Object[] { Integer.valueOf(3), paramString });
    AppMethodBeat.o(63838);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(63839);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
    AppMethodBeat.o(63839);
    return i;
  }
  
  public final int getType()
  {
    return 304;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63840);
    ae.i("MicroMsg.NetSceneSetPushSound", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.p
 * JD-Core Version:    0.7.0.1
 */