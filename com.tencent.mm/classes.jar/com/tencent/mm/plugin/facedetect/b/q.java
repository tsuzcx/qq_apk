package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.ab;

public final class q
  extends m
  implements k
{
  private f callback;
  public boolean mhl;
  public boolean mhm;
  private b rr;
  
  public q(int paramInt)
  {
    AppMethodBeat.i(95);
    this.mhl = false;
    this.mhm = false;
    b.a locala = new b.a();
    locala.fsX = new ciu();
    locala.fsY = new civ();
    locala.uri = "/cgi-bin/micromsg-bin/switchopface";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((ciu)this.rr.fsV.fta).OpCode = paramInt;
    AppMethodBeat.o(95);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(96);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(96);
    return i;
  }
  
  public final int getType()
  {
    return 938;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97);
    paramq = (civ)((b)paramq).fsW.fta;
    this.mhl = paramq.xTd;
    this.mhm = paramq.xTe;
    ab.i("MicroMsg.NetSceneFaceSwitchOpFace", "hy: NetSceneFaceSwitchOpFace errType: %d, errCode: %d, errMsg: %s, hasBio: %b, isOpen: %b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Boolean.valueOf(this.mhl), Boolean.valueOf(this.mhm) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(97);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.q
 * JD-Core Version:    0.7.0.1
 */