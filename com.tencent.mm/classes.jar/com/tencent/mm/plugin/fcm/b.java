package com.tencent.mm.plugin.fcm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dr;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends n
  implements k
{
  private g callback;
  private final com.tencent.mm.ak.b rr;
  
  public b(String paramString)
  {
    AppMethodBeat.i(127575);
    b.a locala = new b.a();
    locala.hvt = new dr();
    locala.hvu = new ds();
    locala.uri = "/cgi-bin/micromsg-bin/androidfcmreg";
    locala.funcId = 216;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((dr)this.rr.hvr.hvw).DLA = paramString;
    AppMethodBeat.o(127575);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(127576);
    this.callback = paramg;
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
    ac.i("MicroMsg.FCM.NetSceneFcmReg", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.b
 * JD-Core Version:    0.7.0.1
 */