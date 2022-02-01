package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.protocal.protobuf.tc;
import com.tencent.mm.sdk.platformtools.ad;

public final class f
  extends a
{
  private final String TAG;
  private g callback;
  public tc nUY;
  private b rr;
  
  public f(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(63905);
    this.TAG = "MicroMsg.NetSceneQrRewardScanCode";
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new tb();
    ((b.a)localObject).gUV = new tc();
    ((b.a)localObject).funcId = 1516;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/scanrewardqrcode";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (tb)this.rr.gUS.gUX;
    ((tb)localObject).nTL = paramString1;
    ((tb)localObject).channel = paramInt;
    ((tb)localObject).CUN = paramString2;
    AppMethodBeat.o(63905);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63907);
    ad.i("MicroMsg.NetSceneQrRewardScanCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.nUY = ((tc)((b)paramq).gUT.gUX);
    ad.i("MicroMsg.NetSceneQrRewardScanCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.nUY.dcG), this.nUY.nTK });
    if ((!this.nUQ) && (this.nUY.dcG != 0)) {
      this.nUR = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63907);
  }
  
  protected final boolean bON()
  {
    return false;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(63906);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(63906);
    return i;
  }
  
  public final int getType()
  {
    return 1516;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.f
 * JD-Core Version:    0.7.0.1
 */