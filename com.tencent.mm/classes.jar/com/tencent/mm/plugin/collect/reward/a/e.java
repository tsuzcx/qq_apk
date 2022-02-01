package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.sz;
import com.tencent.mm.protocal.protobuf.ta;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends a
{
  private final String TAG;
  private g callback;
  public ta nUX;
  private b rr;
  
  public e(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt4)
  {
    AppMethodBeat.i(63902);
    this.TAG = "MicroMsg.NetSceneQrRewardPlaceOrder";
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new sz();
    ((b.a)localObject).gUV = new ta();
    ((b.a)localObject).funcId = 1336;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/rewardqrcodeplaceorder";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (sz)this.rr.gUS.gUX;
    ((sz)localObject).tav = paramInt1;
    ((sz)localObject).CUL = paramInt2;
    ((sz)localObject).CUJ = paramString1;
    ((sz)localObject).CUK = paramString2;
    ((sz)localObject).vBj = paramString3;
    ((sz)localObject).channel = paramInt3;
    ((sz)localObject).CUM = paramString4;
    ((sz)localObject).CUD = paramString5;
    ((sz)localObject).CUN = paramString6;
    ((sz)localObject).CUO = paramString7;
    ((sz)localObject).CUP = paramString8;
    ((sz)localObject).CUQ = paramInt4;
    AppMethodBeat.o(63902);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63904);
    ad.i("MicroMsg.NetSceneQrRewardPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.nUX = ((ta)((b)paramq).gUT.gUX);
    ad.i("MicroMsg.NetSceneQrRewardPlaceOrder", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.nUX.dcG), this.nUX.nTK });
    if ((!this.nUQ) && (this.nUX.dcG != 0)) {
      this.nUR = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63904);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(63903);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(63903);
    return i;
  }
  
  public final int getType()
  {
    return 1336;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.e
 * JD-Core Version:    0.7.0.1
 */