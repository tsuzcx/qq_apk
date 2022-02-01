package com.tencent.mm.plugin.aa.model.cgi;

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
import com.tencent.mm.protocal.protobuf.o;
import com.tencent.mm.protocal.protobuf.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.j;

public final class i
  extends n
  implements k, j
{
  private f callback;
  private b gPp;
  private o iTw;
  public p iTx;
  
  public i(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    AppMethodBeat.i(63388);
    b.a locala = new b.a();
    locala.hNM = new o();
    locala.hNN = new p();
    locala.funcId = 1629;
    locala.uri = "/cgi-bin/mmpay-bin/newaapay";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.gPp = locala.aDC();
    this.iTw = ((o)this.gPp.hNK.hNQ);
    this.iTw.FpG = paramString1;
    this.iTw.FpX = paramLong;
    this.iTw.scene = paramInt;
    this.iTw.FpH = paramString2;
    ad.i("MicroMsg.NetSceneAAPay", "NetSceneAAPay, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s", new Object[] { this.iTw.FpG, Long.valueOf(this.iTw.FpX), Integer.valueOf(this.iTw.scene), this.iTw.FpH });
    AppMethodBeat.o(63388);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(63389);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
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
    ad.i("MicroMsg.NetSceneAAPay", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.iTx = ((p)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneAAPay", "retcode: %s, retmsg: %s, paymsgid:%s", new Object[] { Integer.valueOf(this.iTx.dlw), this.iTx.paA, this.iTx.dEn });
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