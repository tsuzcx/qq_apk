package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.daf;
import com.tencent.mm.protocal.protobuf.dag;
import com.tencent.mm.sdk.platformtools.ad;

public final class q
  extends n
  implements k
{
  private g callback;
  public boolean pNZ;
  public boolean pOa;
  private b rr;
  
  public q(int paramInt)
  {
    AppMethodBeat.i(103620);
    this.pNZ = false;
    this.pOa = false;
    b.a locala = new b.a();
    locala.gUU = new daf();
    locala.gUV = new dag();
    locala.uri = "/cgi-bin/micromsg-bin/switchopface";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    ((daf)this.rr.gUS.gUX).OpCode = paramInt;
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
    paramq = (dag)((b)paramq).gUT.gUX;
    this.pNZ = paramq.Esa;
    this.pOa = paramq.Esb;
    ad.i("MicroMsg.NetSceneFaceSwitchOpFace", "hy: NetSceneFaceSwitchOpFace errType: %d, errCode: %d, errMsg: %s, hasBio: %b, isOpen: %b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Boolean.valueOf(this.pNZ), Boolean.valueOf(this.pOa) });
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