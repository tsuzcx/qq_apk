package com.tencent.mm.plugin.card.sharecard.model;

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
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.aix;
import com.tencent.mm.protocal.protobuf.aiy;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends p
  implements m
{
  private h callback;
  private String iaI;
  private final c rr;
  public int wuz;
  
  public a(String paramString)
  {
    AppMethodBeat.i(112954);
    this.iaI = "";
    c.a locala = new c.a();
    locala.otE = new aix();
    locala.otF = new aiy();
    locala.uri = "/cgi-bin/mmbiz-bin/card/delsharecard";
    locala.funcId = 1163;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((aix)c.b.b(this.rr.otB)).iaI = paramString;
    this.iaI = paramString;
    AppMethodBeat.o(112954);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(112956);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112956);
    return i;
  }
  
  public final int getType()
  {
    return 1163;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112955);
    Log.i("MicroMsg.NetSceneDelShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (aiy)c.c.b(this.rr.otC);
      Log.i("MicroMsg.NetSceneDelShareCard", "ret_code:" + params.wuz);
      this.wuz = params.wuz;
      if (this.wuz == 0) {
        am.dkR().akR(this.iaI);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.a
 * JD-Core Version:    0.7.0.1
 */