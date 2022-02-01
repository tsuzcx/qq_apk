package com.tencent.mm.plugin.aa.model.cgi;

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
import com.tencent.mm.protocal.protobuf.o;
import com.tencent.mm.protocal.protobuf.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.j;

public final class i
  extends n
  implements k, j
{
  private f callback;
  private b gRX;
  private o iWp;
  public p iWq;
  
  public i(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    AppMethodBeat.i(63388);
    b.a locala = new b.a();
    locala.hQF = new o();
    locala.hQG = new p();
    locala.funcId = 1629;
    locala.uri = "/cgi-bin/mmpay-bin/newaapay";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.gRX = locala.aDS();
    this.iWp = ((o)this.gRX.hQD.hQJ);
    this.iWp.FIe = paramString1;
    this.iWp.FIv = paramLong;
    this.iWp.scene = paramInt;
    this.iWp.FIf = paramString2;
    ae.i("MicroMsg.NetSceneAAPay", "NetSceneAAPay, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s", new Object[] { this.iWp.FIe, Long.valueOf(this.iWp.FIv), Integer.valueOf(this.iWp.scene), this.iWp.FIf });
    AppMethodBeat.o(63388);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(63389);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
    AppMethodBeat.o(63389);
    return i;
  }
  
  public final int getType()
  {
    return 1629;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63390);
    ae.i("MicroMsg.NetSceneAAPay", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.iWq = ((p)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneAAPay", "retcode: %s, retmsg: %s, paymsgid:%s", new Object[] { Integer.valueOf(this.iWq.dmy), this.iWq.phe, this.iWq.dFs });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.i
 * JD-Core Version:    0.7.0.1
 */