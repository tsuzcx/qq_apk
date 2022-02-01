package com.tencent.mm.plugin.aa.model.cgi;

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
import com.tencent.mm.protocal.protobuf.o;
import com.tencent.mm.protocal.protobuf.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.j;

public final class i
  extends n
  implements k, j
{
  private g callback;
  private b iaa;
  private o iaj;
  public p iak;
  
  public i(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    AppMethodBeat.i(63388);
    b.a locala = new b.a();
    locala.gUU = new o();
    locala.gUV = new p();
    locala.funcId = 1629;
    locala.uri = "/cgi-bin/mmpay-bin/newaapay";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.iaa = locala.atI();
    this.iaj = ((o)this.iaa.gUS.gUX);
    this.iaj.Csi = paramString1;
    this.iaj.CsA = paramLong;
    this.iaj.scene = paramInt;
    this.iaj.Csj = paramString2;
    ad.i("MicroMsg.NetSceneAAPay", "NetSceneAAPay, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s", new Object[] { this.iaj.Csi, Long.valueOf(this.iaj.CsA), Integer.valueOf(this.iaj.scene), this.iaj.Csj });
    AppMethodBeat.o(63388);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(63389);
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
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
    this.iak = ((p)((b)paramq).gUT.gUX);
    ad.i("MicroMsg.NetSceneAAPay", "retcode: %s, retmsg: %s, paymsgid:%s", new Object[] { Integer.valueOf(this.iak.dcG), this.iak.nTK, this.iak.duI });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.i
 * JD-Core Version:    0.7.0.1
 */