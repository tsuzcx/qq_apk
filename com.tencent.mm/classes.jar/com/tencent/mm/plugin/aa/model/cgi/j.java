package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.r;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  extends com.tencent.mm.ak.q
  implements m, com.tencent.mm.wallet_core.c.j
{
  private i callback;
  private d hJu;
  private com.tencent.mm.protocal.protobuf.q jTm;
  public r jTn;
  
  public j(String paramString1, long paramLong, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(212948);
    d.a locala = new d.a();
    locala.iLN = new com.tencent.mm.protocal.protobuf.q();
    locala.iLO = new r();
    locala.funcId = 1629;
    locala.uri = "/cgi-bin/mmpay-bin/newaapay";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.hJu = locala.aXF();
    this.jTm = ((com.tencent.mm.protocal.protobuf.q)this.hJu.iLK.iLR);
    this.jTm.KBs = paramString1;
    this.jTm.KBK = paramLong;
    this.jTm.scene = paramInt;
    this.jTm.KBt = paramString2;
    this.jTm.KBL = paramString3;
    Log.i("MicroMsg.NetSceneAAPay", "NetSceneAAPay, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s", new Object[] { this.jTm.KBs, Long.valueOf(this.jTm.KBK), Integer.valueOf(this.jTm.scene), this.jTm.KBt });
    AppMethodBeat.o(212948);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(63389);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(63389);
    return i;
  }
  
  public final int getType()
  {
    return 1629;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63390);
    Log.i("MicroMsg.NetSceneAAPay", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.jTn = ((r)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneAAPay", "retcode: %s, retmsg: %s, paymsgid:%s", new Object[] { Integer.valueOf(this.jTn.dDN), this.jTn.qwn, this.jTn.dXf });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.j
 * JD-Core Version:    0.7.0.1
 */