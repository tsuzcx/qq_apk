package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.o;
import com.tencent.mm.protocal.protobuf.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.j;

public final class i
  extends n
  implements k, j
{
  private g callback;
  private b gvE;
  private o iAm;
  public p iAn;
  
  public i(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    AppMethodBeat.i(63388);
    b.a locala = new b.a();
    locala.hvt = new o();
    locala.hvu = new p();
    locala.funcId = 1629;
    locala.uri = "/cgi-bin/mmpay-bin/newaapay";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.gvE = locala.aAz();
    this.iAm = ((o)this.gvE.hvr.hvw);
    this.iAm.DKA = paramString1;
    this.iAm.DKR = paramLong;
    this.iAm.scene = paramInt;
    this.iAm.DKB = paramString2;
    ac.i("MicroMsg.NetSceneAAPay", "NetSceneAAPay, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s", new Object[] { this.iAm.DKA, Long.valueOf(this.iAm.DKR), Integer.valueOf(this.iAm.scene), this.iAm.DKB });
    AppMethodBeat.o(63388);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(63389);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
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
    ac.i("MicroMsg.NetSceneAAPay", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.iAn = ((p)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneAAPay", "retcode: %s, retmsg: %s, paymsgid:%s", new Object[] { Integer.valueOf(this.iAn.dae), this.iAn.oxf, this.iAn.dsu });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.i
 * JD-Core Version:    0.7.0.1
 */