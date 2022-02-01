package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.epr;
import com.tencent.mm.protocal.protobuf.eps;
import com.tencent.mm.sdk.platformtools.Log;

public final class r
  extends q
  implements m
{
  private i callback;
  private d rr;
  public boolean wwd;
  public boolean wwe;
  
  public r(int paramInt)
  {
    AppMethodBeat.i(103620);
    this.wwd = false;
    this.wwe = false;
    d.a locala = new d.a();
    locala.lBU = new epr();
    locala.lBV = new eps();
    locala.uri = "/cgi-bin/micromsg-bin/switchopface";
    locala.funcId = getType();
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    ((epr)d.b.b(this.rr.lBR)).RLe = paramInt;
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
    params = (eps)d.c.b(((d)params).lBS);
    this.wwd = params.Usn;
    this.wwe = params.Uso;
    Log.i("MicroMsg.NetSceneFaceSwitchOpFace", "hy: NetSceneFaceSwitchOpFace errType: %d, errCode: %d, errMsg: %s, hasBio: %b, isOpen: %b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Boolean.valueOf(this.wwd), Boolean.valueOf(this.wwe) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(103622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.r
 * JD-Core Version:    0.7.0.1
 */