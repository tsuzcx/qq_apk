package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.dle;
import com.tencent.mm.protocal.protobuf.dlf;
import com.tencent.mm.sdk.platformtools.ad;

public final class q
  extends n
  implements k
{
  private f callback;
  public boolean rgx;
  public boolean rgy;
  private b rr;
  
  public q(int paramInt)
  {
    AppMethodBeat.i(103620);
    this.rgx = false;
    this.rgy = false;
    b.a locala = new b.a();
    locala.hNM = new dle();
    locala.hNN = new dlf();
    locala.uri = "/cgi-bin/micromsg-bin/switchopface";
    locala.funcId = getType();
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((dle)this.rr.hNK.hNQ).OpCode = paramInt;
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
    paramq = (dlf)((b)paramq).hNL.hNQ;
    this.rgx = paramq.HzN;
    this.rgy = paramq.HzO;
    ad.i("MicroMsg.NetSceneFaceSwitchOpFace", "hy: NetSceneFaceSwitchOpFace errType: %d, errCode: %d, errMsg: %s, hasBio: %b, isOpen: %b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Boolean.valueOf(this.rgx), Boolean.valueOf(this.rgy) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(103622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.q
 * JD-Core Version:    0.7.0.1
 */