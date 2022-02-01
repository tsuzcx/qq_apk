package com.tencent.mm.plugin.fcm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
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

public final class c
  extends n
  implements k
{
  private g callback;
  private final b rr;
  
  public c(String paramString)
  {
    AppMethodBeat.i(127578);
    b.a locala = new b.a();
    locala.hvt = new dr();
    locala.hvu = new ds();
    locala.uri = "/cgi-bin/micromsg-bin/androidfcmunreg";
    locala.funcId = 1059;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((dr)this.rr.hvr.hvw).DLA = paramString;
    AppMethodBeat.o(127578);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(127579);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(127579);
    return i;
  }
  
  public final int getType()
  {
    return 643;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(127580);
    ac.i("MicroMsg.FCM.NetSceneFcmUnreg", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.c
 * JD-Core Version:    0.7.0.1
 */