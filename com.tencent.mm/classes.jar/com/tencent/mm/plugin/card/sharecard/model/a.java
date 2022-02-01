package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.adx;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private String dJb;
  public int oGt;
  private final b rr;
  
  public a(String paramString)
  {
    AppMethodBeat.i(112954);
    this.dJb = "";
    b.a locala = new b.a();
    locala.hQF = new adw();
    locala.hQG = new adx();
    locala.uri = "/cgi-bin/mmbiz-bin/card/delsharecard";
    locala.funcId = 1163;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((adw)this.rr.hQD.hQJ).dJb = paramString;
    this.dJb = paramString;
    AppMethodBeat.o(112954);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112956);
    this.callback = paramf;
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
    ae.i("MicroMsg.NetSceneDelShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (adx)this.rr.hQE.hQJ;
      ae.i("MicroMsg.NetSceneDelShareCard", "ret_code:" + paramq.oGt);
      this.oGt = paramq.oGt;
      if (this.oGt == 0) {
        am.bWk().Zu(this.dJb);
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