package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cgd;
import com.tencent.mm.protocal.protobuf.cge;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;

public final class x
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private final c rr;
  private String wuI;
  
  public x()
  {
    AppMethodBeat.i(112828);
    this.wuI = "";
    c.a locala = new c.a();
    locala.otE = new cgd();
    locala.otF = new cge();
    locala.uri = "/cgi-bin/micromsg-bin/getcardconfiginfo";
    locala.funcId = 1046;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    AppMethodBeat.o(112828);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(112829);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112829);
    return i;
  }
  
  public final int getType()
  {
    return 1046;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112830);
    Log.i("MicroMsg.NetSceneGetCardConfigInfo", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.wuI = ((cge)c.c.b(this.rr.otC)).wuy;
      com.tencent.mm.kernel.h.baE().ban().B(282885, this.wuI);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.x
 * JD-Core Version:    0.7.0.1
 */