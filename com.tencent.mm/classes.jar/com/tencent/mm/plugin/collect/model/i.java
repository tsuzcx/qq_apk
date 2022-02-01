package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.si;
import com.tencent.mm.protocal.protobuf.sj;
import com.tencent.mm.sdk.platformtools.ad;

public final class i
  extends n
  implements k
{
  private g callback;
  public String den;
  public int dep;
  public long ed;
  private com.tencent.mm.al.b iaa;
  public sj nTC;
  public long nTD;
  private long nTE;
  
  public i(int paramInt1, com.tencent.mm.bx.b paramb, String paramString, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(63819);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new si();
    ((b.a)localObject).gUV = new sj();
    ((b.a)localObject).funcId = 1384;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/getf2frcvvoice";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.iaa = ((b.a)localObject).atI();
    localObject = (si)this.iaa.gUS.gUX;
    ((si)localObject).tav = paramInt1;
    ((si)localObject).CUg = 0;
    ((si)localObject).nUi = paramString;
    ((si)localObject).CUe = null;
    ((si)localObject).CUf = paramb;
    this.den = paramString;
    this.dep = paramInt2;
    this.ed = paramLong;
    this.nTE = System.currentTimeMillis();
    ad.i("MicroMsg.NetSceneF2FRcvVoice", "amount: %d, outtradeno: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
    AppMethodBeat.o(63819);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(63820);
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
    AppMethodBeat.o(63820);
    return i;
  }
  
  public final int getType()
  {
    return 1384;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63821);
    ad.i("MicroMsg.NetSceneF2FRcvVoice", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.nTC = ((sj)((com.tencent.mm.al.b)paramq).gUT.gUX);
    ad.i("MicroMsg.NetSceneF2FRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", new Object[] { Integer.valueOf(this.nTC.dcG), this.nTC.nTK, Integer.valueOf(this.nTC.CUg) });
    this.nTD = (System.currentTimeMillis() - this.nTE);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.i
 * JD-Core Version:    0.7.0.1
 */