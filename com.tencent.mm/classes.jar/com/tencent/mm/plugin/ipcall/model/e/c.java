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
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.protocal.protobuf.bks;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends n
  implements k
{
  private f callback;
  private b rr;
  private bkr uNe;
  public bks uNf;
  
  public c()
  {
    AppMethodBeat.i(25457);
    this.rr = null;
    this.uNe = null;
    this.uNf = null;
    this.callback = null;
    b.a locala = new b.a();
    locala.hNM = new bkr();
    locala.hNN = new bks();
    locala.funcId = 746;
    locala.uri = "/cgi-bin/micromsg-bin/getwcocallinfo";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.uNe = ((bkr)this.rr.hNK.hNQ);
    ad.i("MicroMsg.NetSceneIPCallGetCallInfo", "NetSceneIPCallGetCallInfo");
    AppMethodBeat.o(25457);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(25458);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25458);
    return i;
  }
  
  public final int getType()
  {
    return 746;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25459);
    ad.i("MicroMsg.NetSceneIPCallGetCallInfo", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uNf = ((bks)((b)paramq).hNL.hNQ);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.c
 * JD-Core Version:    0.7.0.1
 */