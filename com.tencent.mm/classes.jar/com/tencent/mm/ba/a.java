package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ajg;
import com.tencent.mm.protocal.protobuf.ajh;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends p
  implements m
{
  private h callback;
  private final c rr;
  
  public a(String paramString)
  {
    AppMethodBeat.i(90685);
    c.a locala = new c.a();
    locala.otE = new ajg();
    locala.otF = new ajh();
    locala.uri = "/cgi-bin/micromsg-bin/deletecardimg";
    locala.funcId = 576;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((ajg)c.b.b(this.rr.otB)).ZqZ = paramString;
    AppMethodBeat.o(90685);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(90686);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(90686);
    return i;
  }
  
  public final int getType()
  {
    return 576;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(90687);
    Log.d("MicroMsg.NetSceneDeleteCardImg", "onGYNetEnd:%s, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(90687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ba.a
 * JD-Core Version:    0.7.0.1
 */