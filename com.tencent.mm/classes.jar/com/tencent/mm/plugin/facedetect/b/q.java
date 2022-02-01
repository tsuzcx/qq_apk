package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.efp;
import com.tencent.mm.protocal.protobuf.efq;
import com.tencent.mm.sdk.platformtools.Log;

public final class q
  extends com.tencent.mm.ak.q
  implements m
{
  private i callback;
  private d rr;
  public boolean sQf;
  public boolean sQg;
  
  public q(int paramInt)
  {
    AppMethodBeat.i(103620);
    this.sQf = false;
    this.sQg = false;
    d.a locala = new d.a();
    locala.iLN = new efp();
    locala.iLO = new efq();
    locala.uri = "/cgi-bin/micromsg-bin/switchopface";
    locala.funcId = getType();
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((efp)this.rr.iLK.iLR).OpCode = paramInt;
    AppMethodBeat.o(103620);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(103621);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(103621);
    return i;
  }
  
  public final int getType()
  {
    return 938;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103622);
    params = (efq)((d)params).iLL.iLR;
    this.sQf = params.NfI;
    this.sQg = params.NfJ;
    Log.i("MicroMsg.NetSceneFaceSwitchOpFace", "hy: NetSceneFaceSwitchOpFace errType: %d, errCode: %d, errMsg: %s, hasBio: %b, isOpen: %b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Boolean.valueOf(this.sQf), Boolean.valueOf(this.sQg) });
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