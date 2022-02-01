package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.model.v;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cny;
import com.tencent.mm.protocal.protobuf.cnz;
import com.tencent.mm.sdk.platformtools.ae;

public final class n
  extends com.tencent.mm.ak.n
  implements k
{
  private f callback;
  private b rr;
  public cny uZo;
  private cnz uZp;
  
  public n(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(25490);
    this.rr = null;
    this.uZo = null;
    this.uZp = null;
    this.callback = null;
    b.a locala = new b.a();
    locala.hQF = new cny();
    locala.hQG = new cnz();
    locala.funcId = 723;
    locala.uri = "/cgi-bin/micromsg-bin/pstnshutdown";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    long l = System.currentTimeMillis();
    this.uZo = ((cny)this.rr.hQD.hQJ);
    this.uZo.uvG = v.aAC();
    this.uZo.Gxq = paramInt1;
    this.uZo.Gxr = paramLong1;
    this.uZo.Hzz = paramLong2;
    this.uZo.nJb = paramInt2;
    this.uZo.Hzw = l;
    ae.i("MicroMsg.NetSceneIPCallShutDown", "roomId: %d, roomKey: %d, callSeq: %d, status: %d, timestamp: %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Long.valueOf(l) });
    AppMethodBeat.o(25490);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(25491);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25491);
    return i;
  }
  
  public final int getType()
  {
    return 723;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25492);
    ae.i("MicroMsg.NetSceneIPCallShutDown", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uZp = ((cnz)((b)paramq).hQE.hQJ);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.n
 * JD-Core Version:    0.7.0.1
 */