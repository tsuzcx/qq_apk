package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  private i callback;
  private String eaO;
  public int pTZ;
  private final d rr;
  
  public a(String paramString)
  {
    AppMethodBeat.i(112954);
    this.eaO = "";
    d.a locala = new d.a();
    locala.iLN = new afz();
    locala.iLO = new aga();
    locala.uri = "/cgi-bin/mmbiz-bin/card/delsharecard";
    locala.funcId = 1163;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((afz)this.rr.iLK.iLR).eaO = paramString;
    this.eaO = paramString;
    AppMethodBeat.o(112954);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112956);
    this.callback = parami;
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
      params = (aga)this.rr.iLL.iLR;
      Log.i("MicroMsg.NetSceneDelShareCard", "ret_code:" + params.pTZ);
      this.pTZ = params.pTZ;
      if (this.pTZ == 0) {
        am.ctY().ajz(this.eaO);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.a
 * JD-Core Version:    0.7.0.1
 */