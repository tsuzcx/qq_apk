package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bgj;
import com.tencent.mm.protocal.protobuf.bgk;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  extends n
  implements k
{
  private g callback;
  private b rr;
  private bgj tKr;
  public bgk tKs;
  
  public c()
  {
    AppMethodBeat.i(25457);
    this.rr = null;
    this.tKr = null;
    this.tKs = null;
    this.callback = null;
    b.a locala = new b.a();
    locala.hvt = new bgj();
    locala.hvu = new bgk();
    locala.funcId = 746;
    locala.uri = "/cgi-bin/micromsg-bin/getwcocallinfo";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.tKr = ((bgj)this.rr.hvr.hvw);
    ac.i("MicroMsg.NetSceneIPCallGetCallInfo", "NetSceneIPCallGetCallInfo");
    AppMethodBeat.o(25457);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(25458);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25458);
    return i;
  }
  
  public final int getType()
  {
    return 746;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25459);
    ac.i("MicroMsg.NetSceneIPCallGetCallInfo", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.tKs = ((bgk)((b)paramq).hvs.hvw);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.c
 * JD-Core Version:    0.7.0.1
 */