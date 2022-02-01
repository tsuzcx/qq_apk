package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.protocal.protobuf.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class j
  extends w
  implements com.tencent.mm.wallet_core.model.j
{
  private h callback;
  private c nao;
  private r pHi;
  public com.tencent.mm.protocal.protobuf.s pHj;
  
  public j(String paramString1, long paramLong, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(268405);
    c.a locala = new c.a();
    locala.otE = new r();
    locala.otF = new com.tencent.mm.protocal.protobuf.s();
    locala.funcId = 1629;
    locala.uri = "/cgi-bin/mmpay-bin/newaapay";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.nao = locala.bEF();
    this.pHi = ((r)c.b.b(this.nao.otB));
    this.pHi.YzL = paramString1;
    this.pHi.YAe = paramLong;
    this.pHi.scene = paramInt;
    this.pHi.YzM = paramString2;
    this.pHi.YAf = paramString3;
    Log.i("MicroMsg.NetSceneAAPay", "NetSceneAAPay, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s", new Object[] { this.pHi.YzL, Long.valueOf(this.pHi.YAe), Integer.valueOf(this.pHi.scene), this.pHi.YzM });
    AppMethodBeat.o(268405);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(63389);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(63389);
    return i;
  }
  
  public final int getType()
  {
    return 1629;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(268414);
    Log.i("MicroMsg.NetSceneAAPay", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.pHj = ((com.tencent.mm.protocal.protobuf.s)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneAAPay", "retcode: %s, retmsg: %s, paymsgid:%s", new Object[] { Integer.valueOf(this.pHj.hAV), this.pHj.wYI, this.pHj.hWO });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(268414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.j
 * JD-Core Version:    0.7.0.1
 */