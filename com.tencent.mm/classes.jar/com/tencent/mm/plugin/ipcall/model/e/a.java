package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends n
  implements k
{
  private g callback;
  private b rr;
  public cco sCF;
  private ccp sCG;
  
  public a(int paramInt1, long paramLong1, String paramString1, String paramString2, int paramInt2, long paramLong2)
  {
    AppMethodBeat.i(25451);
    this.rr = null;
    this.sCF = null;
    this.sCG = null;
    this.callback = null;
    b.a locala = new b.a();
    locala.gUU = new cco();
    locala.gUV = new ccp();
    locala.funcId = 843;
    locala.uri = "/cgi-bin/micromsg-bin/pstncancelinvite";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    long l = System.currentTimeMillis();
    this.sCF = ((cco)this.rr.gUS.gUX);
    this.sCF.DdZ = paramInt1;
    this.sCF.Dea = paramLong1;
    this.sCF.sdP = paramString1;
    this.sCF.DYU = l;
    this.sCF.DYV = paramInt2;
    this.sCF.DYW = paramString2;
    this.sCF.DYX = paramLong2;
    ad.d("MicroMsg.NetSceneIPCallCancel", "roomId: %d, roomKey: %d, toUsername: %s, timestamp: %d, inviteId: %d, phoneNumber: %s, callseq: %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), paramString1, Long.valueOf(l), Integer.valueOf(paramInt2), paramString2, Long.valueOf(paramLong2) });
    AppMethodBeat.o(25451);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(25452);
    this.callback = paramg;
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
    this.sCG = ((ccp)((b)paramq).gUT.gUX);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.a
 * JD-Core Version:    0.7.0.1
 */