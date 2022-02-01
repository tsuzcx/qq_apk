package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.aao;
import com.tencent.mm.protocal.protobuf.aap;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends n
  implements com.tencent.mm.network.k
{
  private g callback;
  private String dyc;
  public int ntx;
  private final b rr;
  
  public a(String paramString)
  {
    AppMethodBeat.i(112954);
    this.dyc = "";
    b.a locala = new b.a();
    locala.gUU = new aao();
    locala.gUV = new aap();
    locala.uri = "/cgi-bin/mmbiz-bin/card/delsharecard";
    locala.funcId = 1163;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    ((aao)this.rr.gUS.gUX).dyc = paramString;
    this.dyc = paramString;
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
    ad.i("MicroMsg.NetSceneDelShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (aap)this.rr.gUT.gUX;
      ad.i("MicroMsg.NetSceneDelShareCard", "ret_code:" + paramq.ntx);
      this.ntx = paramq.ntx;
      if (this.ntx == 0) {
        am.bJd().QI(this.dyc);
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