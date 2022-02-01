package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bkt;
import com.tencent.mm.protocal.protobuf.bku;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends n
  implements k
{
  private f callback;
  private b rr;
  private bkt uNg;
  public bku uNh;
  
  public d()
  {
    AppMethodBeat.i(25460);
    this.rr = null;
    this.uNg = null;
    this.uNh = null;
    b.a locala = new b.a();
    locala.hNM = new bkt();
    locala.hNN = new bku();
    locala.funcId = 288;
    locala.uri = "/cgi-bin/micromsg-bin/getwcogiftcardlist";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.uNg = ((bkt)this.rr.hNK.hNQ);
    ad.i("MicroMsg.NetSceneIPCallGetGiftCardList", "NetSceneIPCallGetGiftCardList");
    AppMethodBeat.o(25460);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(25461);
    this.callback = paramf;
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
    ad.i("MicroMsg.NetSceneIPCallGetGiftCardList", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uNh = ((bku)((b)paramq).hNL.hNQ);
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