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
import com.tencent.mm.protocal.protobuf.cmr;
import com.tencent.mm.protocal.protobuf.cms;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends n
  implements k
{
  private f callback;
  private b rr;
  public cmr uNa;
  private cms uNb;
  
  public a(int paramInt1, long paramLong1, String paramString1, String paramString2, int paramInt2, long paramLong2)
  {
    AppMethodBeat.i(25451);
    this.rr = null;
    this.uNa = null;
    this.uNb = null;
    this.callback = null;
    b.a locala = new b.a();
    locala.hNM = new cmr();
    locala.hNN = new cms();
    locala.funcId = 843;
    locala.uri = "/cgi-bin/micromsg-bin/pstncancelinvite";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    long l = System.currentTimeMillis();
    this.uNa = ((cmr)this.rr.hNK.hNQ);
    this.uNa.GeI = paramInt1;
    this.uNa.GeJ = paramLong1;
    this.uNa.uki = paramString1;
    this.uNa.HfW = l;
    this.uNa.HfX = paramInt2;
    this.uNa.HfY = paramString2;
    this.uNa.HfZ = paramLong2;
    ad.d("MicroMsg.NetSceneIPCallCancel", "roomId: %d, roomKey: %d, toUsername: %s, timestamp: %d, inviteId: %d, phoneNumber: %s, callseq: %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), paramString1, Long.valueOf(l), Integer.valueOf(paramInt2), paramString2, Long.valueOf(paramLong2) });
    AppMethodBeat.o(25451);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(25452);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25452);
    return i;
  }
  
  public final int getType()
  {
    return 843;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25453);
    ad.i("MicroMsg.NetSceneIPCallCancel", "errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uNb = ((cms)((b)paramq).hNL.hNQ);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.a
 * JD-Core Version:    0.7.0.1
 */