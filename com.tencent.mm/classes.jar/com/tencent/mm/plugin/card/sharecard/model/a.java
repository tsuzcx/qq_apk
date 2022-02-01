package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends n
  implements com.tencent.mm.network.k
{
  private g callback;
  private String dvO;
  public int nWx;
  private final b rr;
  
  public a(String paramString)
  {
    AppMethodBeat.i(112954);
    this.dvO = "";
    b.a locala = new b.a();
    locala.hvt = new abn();
    locala.hvu = new abo();
    locala.uri = "/cgi-bin/mmbiz-bin/card/delsharecard";
    locala.funcId = 1163;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((abn)this.rr.hvr.hvw).dvO = paramString;
    this.dvO = paramString;
    AppMethodBeat.o(112954);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112956);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112956);
    return i;
  }
  
  public final int getType()
  {
    return 1163;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112955);
    ac.i("MicroMsg.NetSceneDelShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (abo)this.rr.hvs.hvw;
      ac.i("MicroMsg.NetSceneDelShareCard", "ret_code:" + paramq.nWx);
      this.nWx = paramq.nWx;
      if (this.nWx == 0) {
        am.bQq().UU(this.dvO);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.a
 * JD-Core Version:    0.7.0.1
 */