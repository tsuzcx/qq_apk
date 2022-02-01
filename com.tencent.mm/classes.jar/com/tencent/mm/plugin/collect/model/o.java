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
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.ss;
import com.tencent.mm.sdk.platformtools.ad;

public final class o
  extends n
  implements k
{
  private final String TAG;
  private g callback;
  public String den;
  public ss nTX;
  private com.tencent.mm.al.b rr;
  
  public o(int paramInt, com.tencent.mm.bx.b paramb, String paramString)
  {
    AppMethodBeat.i(63835);
    this.TAG = "MicroMsg.NetSceneMDRcvVoice";
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new sr();
    ((b.a)localObject).gUV = new ss();
    ((b.a)localObject).funcId = 1317;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/getmdrcvvoice";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (sr)this.rr.gUS.gUX;
    ((sr)localObject).tav = paramInt;
    ((sr)localObject).CUg = 0;
    ((sr)localObject).nUi = paramString;
    ((sr)localObject).CUe = null;
    ((sr)localObject).CUf = paramb;
    this.den = paramString;
    ad.i("MicroMsg.NetSceneMDRcvVoice", "amount: %d, outtradeno: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(63835);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(63836);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(63836);
    return i;
  }
  
  public final int getType()
  {
    return 1317;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63837);
    ad.i("MicroMsg.NetSceneMDRcvVoice", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.nTX = ((ss)((com.tencent.mm.al.b)paramq).gUT.gUX);
    ad.i("MicroMsg.NetSceneMDRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", new Object[] { Integer.valueOf(this.nTX.dcG), this.nTX.nTK, Integer.valueOf(this.nTX.CUg) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.o
 * JD-Core Version:    0.7.0.1
 */