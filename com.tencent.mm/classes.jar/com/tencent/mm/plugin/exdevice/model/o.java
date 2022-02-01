package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ayn;
import com.tencent.mm.protocal.protobuf.ayo;
import com.tencent.mm.sdk.platformtools.ae;

public final class o
  extends n
  implements k
{
  private f callback;
  b rr;
  
  public o()
  {
    AppMethodBeat.i(23391);
    this.callback = null;
    this.rr = null;
    b.a locala = new b.a();
    locala.hQF = new ayn();
    locala.hQG = new ayo();
    locala.uri = "/cgi-bin/micromsg-bin/getboundharddevices";
    locala.funcId = 539;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((ayn)this.rr.hQD.hQJ).Version = 1;
    AppMethodBeat.o(23391);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(23393);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(23393);
    return i;
  }
  
  public final int getType()
  {
    return 539;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23392);
    ae.i("MicroMsg.exdevice.NetSceneGetBoundHardDevices", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.o
 * JD-Core Version:    0.7.0.1
 */