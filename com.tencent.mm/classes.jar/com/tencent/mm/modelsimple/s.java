package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.ckb;
import com.tencent.mm.protocal.protobuf.ckc;
import com.tencent.mm.sdk.platformtools.Log;

public final class s
  extends q
  implements m
{
  private i callback;
  public final d rr;
  
  public s()
  {
    AppMethodBeat.i(150937);
    d.a locala = new d.a();
    locala.iLN = new ckb();
    locala.iLO = new ckc();
    locala.uri = "/cgi-bin/micromsg-bin/logout";
    locala.funcId = 282;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((ckb)this.rr.iLK.iLR).Scene = 0;
    AppMethodBeat.o(150937);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(150938);
    Log.d("MicroMsg.NetSceneLogout", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150938);
    return i;
  }
  
  public final int getType()
  {
    return 282;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150939);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.d("MicroMsg.NetSceneLogout", "logout Error. ");
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.s
 * JD-Core Version:    0.7.0.1
 */