package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.sdk.platformtools.ab;

public final class ad
  extends m
  implements k
{
  private f callback;
  private final b rr;
  
  public ad(int paramInt)
  {
    AppMethodBeat.i(78612);
    b.a locala = new b.a();
    locala.fsX = new bau();
    locala.fsY = new bav();
    locala.uri = "/cgi-bin/micromsg-bin/logoutwebwx";
    locala.funcId = 281;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((bau)this.rr.fsV.fta).OpCode = paramInt;
    AppMethodBeat.o(78612);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78613);
    ab.d("MicroMsg.NetSceneWebWXLogout", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78613);
    return i;
  }
  
  public final int getType()
  {
    return 281;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78614);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      ab.d("MicroMsg.NetSceneWebWXLogout", "logout Error. ");
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(78614);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ad
 * JD-Core Version:    0.7.0.1
 */