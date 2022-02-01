package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.dfr;
import com.tencent.mm.protocal.protobuf.dfs;
import com.tencent.mm.sdk.platformtools.ac;

public final class q
  extends n
  implements k
{
  private g callback;
  public boolean qwH;
  public boolean qwI;
  private b rr;
  
  public q(int paramInt)
  {
    AppMethodBeat.i(103620);
    this.qwH = false;
    this.qwI = false;
    b.a locala = new b.a();
    locala.hvt = new dfr();
    locala.hvu = new dfs();
    locala.uri = "/cgi-bin/micromsg-bin/switchopface";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((dfr)this.rr.hvr.hvw).OpCode = paramInt;
    AppMethodBeat.o(103620);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(103621);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103621);
    return i;
  }
  
  public final int getType()
  {
    return 938;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103622);
    paramq = (dfs)((b)paramq).hvs.hvw;
    this.qwH = paramq.FPc;
    this.qwI = paramq.FPd;
    ac.i("MicroMsg.NetSceneFaceSwitchOpFace", "hy: NetSceneFaceSwitchOpFace errType: %d, errCode: %d, errMsg: %s, hasBio: %b, isOpen: %b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Boolean.valueOf(this.qwH), Boolean.valueOf(this.qwI) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(103622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.q
 * JD-Core Version:    0.7.0.1
 */