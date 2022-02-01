package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnh;
import com.tencent.mm.sdk.platformtools.ad;

public final class o
  extends n
  implements k
{
  private f callback;
  private b rr;
  public cng uND;
  public cnh uNE;
  
  public o(int paramInt1, long paramLong1, int paramInt2, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(25493);
    this.rr = null;
    this.uND = null;
    this.uNE = null;
    b.a locala = new b.a();
    locala.hNM = new cng();
    locala.hNN = new cnh();
    locala.funcId = 819;
    locala.uri = "/cgi-bin/micromsg-bin/pstnsync";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    long l = System.currentTimeMillis();
    this.uND = ((cng)this.rr.hNK.hNQ);
    this.uND.Hgt = u.aAm();
    this.uND.GeI = paramInt1;
    this.uND.GeJ = paramLong1;
    this.uND.HfW = l;
    this.uND.Hgu = paramInt2;
    this.uND.HfZ = paramLong2;
    if (!paramBoolean) {}
    for (this.uND.Hgv = 0;; this.uND.Hgv = 1)
    {
      ad.i("MicroMsg.NetSceneIPCallSync", "roomId: %d, roomKey: %d, syncKey: %d, callSeq: %d,dataFlag: %d, timestamp: %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Long.valueOf(paramLong2), Integer.valueOf(this.uND.Hgv), Long.valueOf(l) });
      AppMethodBeat.o(25493);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(25494);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25494);
    return i;
  }
  
  public final int getType()
  {
    return 819;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25495);
    ad.i("MicroMsg.NetSceneIPCallSync", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uNE = ((cnh)((b)paramq).hNL.hNQ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(25495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.o
 * JD-Core Version:    0.7.0.1
 */