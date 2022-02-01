package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fkq;
import com.tencent.mm.protocal.protobuf.fkr;
import com.tencent.mm.sdk.platformtools.Log;

public final class r
  extends p
  implements m
{
  private h callback;
  private c rr;
  public boolean zSk;
  public boolean zSl;
  
  public r(int paramInt)
  {
    AppMethodBeat.i(103620);
    this.zSk = false;
    this.zSl = false;
    c.a locala = new c.a();
    locala.otE = new fkq();
    locala.otF = new fkr();
    locala.uri = "/cgi-bin/micromsg-bin/switchopface";
    locala.funcId = getType();
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((fkq)c.b.b(this.rr.otB)).YIq = paramInt;
    AppMethodBeat.o(103620);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(103621);
    this.callback = paramh;
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
    params = (fkr)c.c.b(((c)params).otC);
    this.zSk = params.abLq;
    this.zSl = params.abLr;
    Log.i("MicroMsg.NetSceneFaceSwitchOpFace", "hy: NetSceneFaceSwitchOpFace errType: %d, errCode: %d, errMsg: %s, hasBio: %b, isOpen: %b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Boolean.valueOf(this.zSk), Boolean.valueOf(this.zSl) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(103622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.r
 * JD-Core Version:    0.7.0.1
 */