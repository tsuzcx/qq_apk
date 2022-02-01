package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.m;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
  extends com.tencent.mm.al.n
  implements k
{
  private f callback;
  private b gPp;
  private m iTu;
  public com.tencent.mm.protocal.protobuf.n iTv;
  
  public h()
  {
    AppMethodBeat.i(63385);
    b.a locala = new b.a();
    locala.hNM = new m();
    locala.hNN = new com.tencent.mm.protocal.protobuf.n();
    locala.funcId = 1698;
    locala.uri = "/cgi-bin/mmpay-bin/newaaoperation";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.gPp = locala.aDC();
    this.iTu = ((m)this.gPp.hNK.hNQ);
    AppMethodBeat.o(63385);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(63386);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
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
    this.iTv = ((com.tencent.mm.protocal.protobuf.n)((b)paramq).hNL.hNQ);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ad.i("MicroMsg.NetSceneAAOperation", "retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", new Object[] { Integer.valueOf(this.iTv.dlw), this.iTv.paA, Integer.valueOf(this.iTv.iTC), Integer.valueOf(this.iTv.iTD), Integer.valueOf(this.iTv.iTE), Long.valueOf(this.iTv.iTF), Long.valueOf(this.iTv.iTG), this.iTv.iTH, this.iTv.iTI });
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.h
 * JD-Core Version:    0.7.0.1
 */