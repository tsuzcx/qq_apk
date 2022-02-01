package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.uw;
import com.tencent.mm.protocal.protobuf.ux;
import com.tencent.mm.sdk.platformtools.ad;

public final class o
  extends n
  implements k
{
  private final String TAG;
  private f callback;
  public String dnf;
  public ux paN;
  private com.tencent.mm.al.b rr;
  
  public o(int paramInt, com.tencent.mm.bx.b paramb, String paramString)
  {
    AppMethodBeat.i(63835);
    this.TAG = "MicroMsg.NetSceneMDRcvVoice";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new uw();
    ((b.a)localObject).hNN = new ux();
    ((b.a)localObject).funcId = 1317;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/getmdrcvvoice";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (uw)this.rr.hNK.hNQ;
    ((uw)localObject).vls = paramInt;
    ((uw)localObject).FNY = 0;
    ((uw)localObject).paY = paramString;
    ((uw)localObject).FTY = null;
    ((uw)localObject).FTZ = paramb;
    this.dnf = paramString;
    ad.i("MicroMsg.NetSceneMDRcvVoice", "amount: %d, outtradeno: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(63835);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(63836);
    this.callback = paramf;
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
    this.paN = ((ux)((com.tencent.mm.al.b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneMDRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", new Object[] { Integer.valueOf(this.paN.dlw), this.paN.paA, Integer.valueOf(this.paN.FNY) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(63837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.o
 * JD-Core Version:    0.7.0.1
 */