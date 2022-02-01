package com.tencent.mm.plugin.fcm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.protocal.protobuf.dt;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.ak.b rr;
  
  public b(String paramString)
  {
    AppMethodBeat.i(127575);
    b.a locala = new b.a();
    locala.hQF = new ds();
    locala.hQG = new dt();
    locala.uri = "/cgi-bin/micromsg-bin/androidfcmreg";
    locala.funcId = 216;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((ds)this.rr.hQD.hQJ).FJd = paramString;
    AppMethodBeat.o(127575);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(127576);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(127576);
    return i;
  }
  
  public final int getType()
  {
    return 216;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(127577);
    ae.i("MicroMsg.FCM.NetSceneFcmReg", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.b
 * JD-Core Version:    0.7.0.1
 */