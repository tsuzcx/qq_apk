package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.dmc;
import com.tencent.mm.sdk.platformtools.ae;

public final class q
  extends n
  implements k
{
  private f callback;
  public boolean roB;
  public boolean roC;
  private b rr;
  
  public q(int paramInt)
  {
    AppMethodBeat.i(103620);
    this.roB = false;
    this.roC = false;
    b.a locala = new b.a();
    locala.hQF = new dmb();
    locala.hQG = new dmc();
    locala.uri = "/cgi-bin/micromsg-bin/switchopface";
    locala.funcId = getType();
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((dmb)this.rr.hQD.hQJ).OpCode = paramInt;
    AppMethodBeat.o(103620);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(103621);
    this.callback = paramf;
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
    paramq = (dmc)((b)paramq).hQE.hQJ;
    this.roB = paramq.HTA;
    this.roC = paramq.HTB;
    ae.i("MicroMsg.NetSceneFaceSwitchOpFace", "hy: NetSceneFaceSwitchOpFace errType: %d, errCode: %d, errMsg: %s, hasBio: %b, isOpen: %b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Boolean.valueOf(this.roB), Boolean.valueOf(this.roC) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(103622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.q
 * JD-Core Version:    0.7.0.1
 */