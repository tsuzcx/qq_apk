package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cnm;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends n
  implements k
{
  private f callback;
  private b rr;
  public cnl uYN;
  private cnm uYO;
  
  public a(int paramInt1, long paramLong1, String paramString1, String paramString2, int paramInt2, long paramLong2)
  {
    AppMethodBeat.i(25451);
    this.rr = null;
    this.uYN = null;
    this.uYO = null;
    this.callback = null;
    b.a locala = new b.a();
    locala.hQF = new cnl();
    locala.hQG = new cnm();
    locala.funcId = 843;
    locala.uri = "/cgi-bin/micromsg-bin/pstncancelinvite";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    long l = System.currentTimeMillis();
    this.uYN = ((cnl)this.rr.hQD.hQJ);
    this.uYN.Gxq = paramInt1;
    this.uYN.Gxr = paramLong1;
    this.uYN.uvF = paramString1;
    this.uYN.Hzw = l;
    this.uYN.Hzx = paramInt2;
    this.uYN.Hzy = paramString2;
    this.uYN.Hzz = paramLong2;
    ae.d("MicroMsg.NetSceneIPCallCancel", "roomId: %d, roomKey: %d, toUsername: %s, timestamp: %d, inviteId: %d, phoneNumber: %s, callseq: %d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), paramString1, Long.valueOf(l), Integer.valueOf(paramInt2), paramString2, Long.valueOf(paramLong2) });
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
    ae.i("MicroMsg.NetSceneIPCallCancel", "errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uYO = ((cnm)((b)paramq).hQE.hQJ);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.a
 * JD-Core Version:    0.7.0.1
 */