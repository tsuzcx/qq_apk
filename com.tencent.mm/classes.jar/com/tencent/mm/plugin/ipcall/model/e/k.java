package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cna;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.ad;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private b rr;
  public cna uNv;
  public cnb uNw;
  
  public k(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(25481);
    this.rr = null;
    this.uNv = null;
    this.uNw = null;
    this.callback = null;
    b.a locala = new b.a();
    locala.hNM = new cna();
    locala.hNN = new cnb();
    locala.funcId = 726;
    locala.uri = "/cgi-bin/micromsg-bin/pstnredirect";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.uNv = ((cna)this.rr.hNK.hNQ);
    this.uNv.GeI = paramInt;
    this.uNv.GeJ = paramLong1;
    this.uNv.HfZ = paramLong2;
    AppMethodBeat.o(25481);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(25482);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25482);
    return i;
  }
  
  public final int getType()
  {
    return 726;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25483);
    ad.i("MicroMsg.NetSceneIPCallRedirect", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uNw = ((cnb)((b)paramq).hNL.hNQ);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.k
 * JD-Core Version:    0.7.0.1
 */