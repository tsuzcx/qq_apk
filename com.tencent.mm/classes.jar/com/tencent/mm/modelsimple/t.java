package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.djx;
import com.tencent.mm.protocal.protobuf.djy;
import com.tencent.mm.sdk.platformtools.Log;

public final class t
  extends p
  implements m
{
  private h callback;
  public final c rr;
  
  public t()
  {
    AppMethodBeat.i(150937);
    c.a locala = new c.a();
    locala.otE = new djx();
    locala.otF = new djy();
    locala.uri = "/cgi-bin/micromsg-bin/logout";
    locala.funcId = 282;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((djx)c.b.b(this.rr.otB)).IJG = 0;
    AppMethodBeat.o(150937);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(150938);
    Log.d("MicroMsg.NetSceneLogout", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150938);
    return i;
  }
  
  public final int getType()
  {
    return 282;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
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
 * Qualified Name:     com.tencent.mm.modelsimple.t
 * JD-Core Version:    0.7.0.1
 */