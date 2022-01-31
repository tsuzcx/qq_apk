package com.tencent.mm.plugin.aa.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.n;
import com.tencent.mm.protocal.protobuf.o;
import com.tencent.mm.sdk.platformtools.ab;

public final class i
  extends m
  implements k, com.tencent.mm.wallet_core.c.i
{
  private f callback;
  private b goo;
  private n goy;
  public o goz;
  
  public i(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    AppMethodBeat.i(40657);
    b.a locala = new b.a();
    locala.fsX = new n();
    locala.fsY = new o();
    locala.funcId = 1629;
    locala.uri = "/cgi-bin/mmpay-bin/newaapay";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.goo = locala.ado();
    this.goy = ((n)this.goo.fsV.fta);
    this.goy.wjW = paramString1;
    this.goy.wkp = paramLong;
    this.goy.scene = paramInt;
    this.goy.wjX = paramString2;
    ab.i("MicroMsg.NetSceneAAPay", "NetSceneAAPay, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s", new Object[] { this.goy.wjW, Long.valueOf(this.goy.wkp), Integer.valueOf(this.goy.scene), this.goy.wjX });
    AppMethodBeat.o(40657);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(40658);
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(40658);
    return i;
  }
  
  public final int getType()
  {
    return 1629;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(40659);
    ab.i("MicroMsg.NetSceneAAPay", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.goz = ((o)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneAAPay", "retcode: %s, retmsg: %s, paymsgid:%s", new Object[] { Integer.valueOf(this.goz.cnK), this.goz.kNv, this.goz.cEg });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(40659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.a.i
 * JD-Core Version:    0.7.0.1
 */