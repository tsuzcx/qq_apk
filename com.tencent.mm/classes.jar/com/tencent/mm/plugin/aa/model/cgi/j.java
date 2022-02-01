package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.r;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  extends q
  implements m, com.tencent.mm.wallet_core.c.j
{
  private i callback;
  private d kwO;
  private r mKA;
  public com.tencent.mm.protocal.protobuf.s mKB;
  
  public j(String paramString1, long paramLong, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(269096);
    d.a locala = new d.a();
    locala.lBU = new r();
    locala.lBV = new com.tencent.mm.protocal.protobuf.s();
    locala.funcId = 1629;
    locala.uri = "/cgi-bin/mmpay-bin/newaapay";
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.kwO = locala.bgN();
    this.mKA = ((r)d.b.b(this.kwO.lBR));
    this.mKA.RDi = paramString1;
    this.mKA.RDB = paramLong;
    this.mKA.scene = paramInt;
    this.mKA.RDj = paramString2;
    this.mKA.RDC = paramString3;
    Log.i("MicroMsg.NetSceneAAPay", "NetSceneAAPay, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s", new Object[] { this.mKA.RDi, Long.valueOf(this.mKA.RDB), Integer.valueOf(this.mKA.scene), this.mKA.RDj });
    AppMethodBeat.o(269096);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(63389);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
    AppMethodBeat.o(63389);
    return i;
  }
  
  public final int getType()
  {
    return 1629;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63390);
    Log.i("MicroMsg.NetSceneAAPay", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.mKB = ((com.tencent.mm.protocal.protobuf.s)d.c.b(((d)params).lBS));
    Log.i("MicroMsg.NetSceneAAPay", "retcode: %s, retmsg: %s, paymsgid:%s", new Object[] { Integer.valueOf(this.mKB.fwx), this.mKB.tVo, this.mKB.fQR });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.j
 * JD-Core Version:    0.7.0.1
 */