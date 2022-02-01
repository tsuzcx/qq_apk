package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.protocal.protobuf.cke;
import com.tencent.mm.sdk.platformtools.Log;

public final class ae
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public ae(int paramInt)
  {
    AppMethodBeat.i(150963);
    d.a locala = new d.a();
    locala.iLN = new ckd();
    locala.iLO = new cke();
    locala.uri = "/cgi-bin/micromsg-bin/logoutwebwx";
    locala.funcId = 281;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((ckd)this.rr.iLK.iLR).OpCode = paramInt;
    AppMethodBeat.o(150963);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(150964);
    Log.d("MicroMsg.NetSceneWebWXLogout", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150964);
    return i;
  }
  
  public final int getType()
  {
    return 281;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150965);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.d("MicroMsg.NetSceneWebWXLogout", "logout Error. ");
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(150965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ae
 * JD-Core Version:    0.7.0.1
 */