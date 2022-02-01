package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cnu;
import com.tencent.mm.protocal.protobuf.cnv;
import com.tencent.mm.sdk.platformtools.ae;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private b rr;
  public cnu uZi;
  public cnv uZj;
  
  public k(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(25481);
    this.rr = null;
    this.uZi = null;
    this.uZj = null;
    this.callback = null;
    b.a locala = new b.a();
    locala.hQF = new cnu();
    locala.hQG = new cnv();
    locala.funcId = 726;
    locala.uri = "/cgi-bin/micromsg-bin/pstnredirect";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.uZi = ((cnu)this.rr.hQD.hQJ);
    this.uZi.Gxq = paramInt;
    this.uZi.Gxr = paramLong1;
    this.uZi.Hzz = paramLong2;
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
    ae.i("MicroMsg.NetSceneIPCallRedirect", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uZj = ((cnv)((b)paramq).hQE.hQJ);
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