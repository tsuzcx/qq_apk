package com.tencent.mm.plugin.fcm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dd;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  extends m
  implements k
{
  private f callback;
  private final b rr;
  
  public c(String paramString)
  {
    AppMethodBeat.i(56438);
    b.a locala = new b.a();
    locala.fsX = new dd();
    locala.fsY = new de();
    locala.uri = "/cgi-bin/micromsg-bin/androidfcmunreg";
    locala.funcId = 664;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((dd)this.rr.fsV.fta).wkV = paramString;
    AppMethodBeat.o(56438);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(56439);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(56439);
    return i;
  }
  
  public final int getType()
  {
    return 643;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(56440);
    ab.i("MicroMsg.FCM.NetSceneFcmUnreg", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(56440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.c
 * JD-Core Version:    0.7.0.1
 */