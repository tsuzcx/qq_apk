package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.m;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
  extends com.tencent.mm.al.n
  implements k
{
  private g callback;
  private b iaa;
  private m iah;
  public com.tencent.mm.protocal.protobuf.n iai;
  
  public h()
  {
    AppMethodBeat.i(63385);
    b.a locala = new b.a();
    locala.gUU = new m();
    locala.gUV = new com.tencent.mm.protocal.protobuf.n();
    locala.funcId = 1698;
    locala.uri = "/cgi-bin/mmpay-bin/newaaoperation";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.iaa = locala.atI();
    this.iah = ((m)this.iaa.gUS.gUX);
    AppMethodBeat.o(63385);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(63386);
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
    AppMethodBeat.o(63386);
    return i;
  }
  
  public final int getType()
  {
    return 1698;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63387);
    ad.i("MicroMsg.NetSceneAAOperation", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.iai = ((com.tencent.mm.protocal.protobuf.n)((b)paramq).gUT.gUX);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ad.i("MicroMsg.NetSceneAAOperation", "retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", new Object[] { Integer.valueOf(this.iai.dcG), this.iai.nTK, Integer.valueOf(this.iai.iap), Integer.valueOf(this.iai.iaq), Integer.valueOf(this.iai.iar), Long.valueOf(this.iai.ias), Long.valueOf(this.iai.iat), this.iai.iau, this.iai.iav });
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.h
 * JD-Core Version:    0.7.0.1
 */