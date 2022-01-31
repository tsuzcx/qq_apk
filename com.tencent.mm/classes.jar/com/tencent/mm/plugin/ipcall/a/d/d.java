package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.asa;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends m
  implements k
{
  private f callback;
  private asa nOQ;
  public asb nOR;
  private b rr;
  
  public d()
  {
    AppMethodBeat.i(21845);
    this.rr = null;
    this.nOQ = null;
    this.nOR = null;
    b.a locala = new b.a();
    locala.fsX = new asa();
    locala.fsY = new asb();
    locala.funcId = 288;
    locala.uri = "/cgi-bin/micromsg-bin/getwcogiftcardlist";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.nOQ = ((asa)this.rr.fsV.fta);
    ab.i("MicroMsg.NetSceneIPCallGetGiftCardList", "NetSceneIPCallGetGiftCardList");
    AppMethodBeat.o(21845);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(21846);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(21846);
    return i;
  }
  
  public final int getType()
  {
    return 288;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21847);
    ab.i("MicroMsg.NetSceneIPCallGetGiftCardList", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.nOR = ((asb)((b)paramq).fsW.fta);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(21847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d.d
 * JD-Core Version:    0.7.0.1
 */