package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bkb;
import com.tencent.mm.protocal.protobuf.bkc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;

public final class x
  extends q
  implements m
{
  private i callback;
  private String pUi;
  private final d rr;
  
  public x()
  {
    AppMethodBeat.i(112828);
    this.pUi = "";
    d.a locala = new d.a();
    locala.iLN = new bkb();
    locala.iLO = new bkc();
    locala.uri = "/cgi-bin/micromsg-bin/getcardconfiginfo";
    locala.funcId = 1046;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(112828);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(112829);
    this.callback = parami;
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
      this.pUi = ((bkc)this.rr.iLL.iLR).pTY;
      com.tencent.mm.kernel.g.aAh().azQ().set(282885, this.pUi);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.x
 * JD-Core Version:    0.7.0.1
 */