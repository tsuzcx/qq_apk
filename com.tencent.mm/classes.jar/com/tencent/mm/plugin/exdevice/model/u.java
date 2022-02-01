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
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.protocal.protobuf.cze;
import com.tencent.mm.sdk.platformtools.ae;

public final class u
  extends n
  implements k
{
  private f callback;
  b rr;
  
  public u(String paramString)
  {
    AppMethodBeat.i(23410);
    this.callback = null;
    this.rr = null;
    b.a locala = new b.a();
    locala.hQF = new czd();
    locala.hQG = new cze();
    locala.uri = "/cgi-bin/micromsg-bin/searchharddevice";
    locala.funcId = 540;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((czd)this.rr.hQD.hQJ).HJa = paramString;
    AppMethodBeat.o(23410);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(23412);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(23412);
    return i;
  }
  
  public final int getType()
  {
    return 540;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23411);
    ae.i("MicroMsg.exdevice.NetSceneSearchHardDevice", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.u
 * JD-Core Version:    0.7.0.1
 */