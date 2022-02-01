package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.adn;
import com.tencent.mm.protocal.protobuf.ado;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private String dHX;
  public int ozR;
  private final b rr;
  
  public a(String paramString)
  {
    AppMethodBeat.i(112954);
    this.dHX = "";
    b.a locala = new b.a();
    locala.hNM = new adn();
    locala.hNN = new ado();
    locala.uri = "/cgi-bin/mmbiz-bin/card/delsharecard";
    locala.funcId = 1163;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((adn)this.rr.hNK.hNQ).dHX = paramString;
    this.dHX = paramString;
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
    ad.i("MicroMsg.NetSceneDelShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ado)this.rr.hNL.hNQ;
      ad.i("MicroMsg.NetSceneDelShareCard", "ret_code:" + paramq.ozR);
      this.ozR = paramq.ozR;
      if (this.ozR == 0) {
        am.bUV().YD(this.dHX);
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