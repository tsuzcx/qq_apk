package com.tencent.mm.plugin.fcm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ex;
import com.tencent.mm.protocal.protobuf.ey;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends p
  implements m
{
  private h callback;
  private final c rr;
  
  public d(String paramString)
  {
    AppMethodBeat.i(127578);
    c.a locala = new c.a();
    locala.otE = new ex();
    locala.otF = new ey();
    locala.uri = "/cgi-bin/micromsg-bin/androidfcmunreg";
    locala.funcId = 1059;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((ex)c.b.b(this.rr.otB)).YGM = paramString;
    AppMethodBeat.o(127578);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(127579);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(127579);
    return i;
  }
  
  public final int getType()
  {
    return 643;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(127580);
    Log.i("MicroMsg.FCM.NetSceneFcmUnreg", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.d
 * JD-Core Version:    0.7.0.1
 */