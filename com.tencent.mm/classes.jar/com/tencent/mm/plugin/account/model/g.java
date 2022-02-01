package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cmy;
import com.tencent.mm.protocal.protobuf.cmz;
import com.tencent.mm.sdk.platformtools.ae;

public final class g
  extends n
  implements k
{
  private f callback;
  private b gRX;
  private cmy jkq;
  
  public g(int paramInt, String paramString)
  {
    AppMethodBeat.i(127832);
    b.a locala = new b.a();
    locala.hQF = new cmy();
    locala.hQG = new cmz();
    locala.funcId = getType();
    locala.hQH = 0;
    locala.respCmdId = 0;
    locala.uri = "/cgi-bin/micromsg-bin/privacypolicychoise";
    this.gRX = locala.aDS();
    this.jkq = ((cmy)this.gRX.hQD.hQJ);
    this.jkq.Hza = paramInt;
    this.jkq.jge = paramString;
    AppMethodBeat.o(127832);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(127833);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
    AppMethodBeat.o(127833);
    return i;
  }
  
  public final int getType()
  {
    return 268;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(127834);
    ae.i("MicroMsg.NetScenePrivacyPolicyChoice", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(127834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.g
 * JD-Core Version:    0.7.0.1
 */