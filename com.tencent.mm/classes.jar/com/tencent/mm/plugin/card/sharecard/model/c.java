package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.csj;
import com.tencent.mm.protocal.protobuf.csk;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends p
  implements m
{
  private h callback;
  private final com.tencent.mm.am.c rr;
  public String wuy;
  
  public c(String paramString)
  {
    AppMethodBeat.i(112960);
    c.a locala = new c.a();
    locala.otE = new csj();
    locala.otF = new csk();
    locala.uri = "/cgi-bin/micromsg-bin/getsharecard";
    locala.funcId = 1051;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((csj)c.b.b(this.rr.otB)).iaI = paramString;
    AppMethodBeat.o(112960);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(112962);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112962);
    return i;
  }
  
  public final int getType()
  {
    return 1051;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112961);
    Log.i("MicroMsg.NetSceneGetShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (csk)c.c.b(this.rr.otC);
      Log.v("MicroMsg.NetSceneGetShareCard", "json:" + params.wuy);
      this.wuy = params.wuy;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.c
 * JD-Core Version:    0.7.0.1
 */