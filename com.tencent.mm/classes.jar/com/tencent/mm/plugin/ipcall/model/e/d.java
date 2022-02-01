package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bgl;
import com.tencent.mm.protocal.protobuf.bgm;
import com.tencent.mm.sdk.platformtools.ac;

public final class d
  extends n
  implements k
{
  private g callback;
  private b rr;
  private bgl tKt;
  public bgm tKu;
  
  public d()
  {
    AppMethodBeat.i(25460);
    this.rr = null;
    this.tKt = null;
    this.tKu = null;
    b.a locala = new b.a();
    locala.hvt = new bgl();
    locala.hvu = new bgm();
    locala.funcId = 288;
    locala.uri = "/cgi-bin/micromsg-bin/getwcogiftcardlist";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.tKt = ((bgl)this.rr.hvr.hvw);
    ac.i("MicroMsg.NetSceneIPCallGetGiftCardList", "NetSceneIPCallGetGiftCardList");
    AppMethodBeat.o(25460);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(25461);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25461);
    return i;
  }
  
  public final int getType()
  {
    return 288;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25462);
    ac.i("MicroMsg.NetSceneIPCallGetGiftCardList", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.tKu = ((bgm)((b)paramq).hvs.hvw);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.d
 * JD-Core Version:    0.7.0.1
 */