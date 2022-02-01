package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.vg;
import com.tencent.mm.protocal.protobuf.vh;
import com.tencent.mm.sdk.platformtools.ad;

public final class f
  extends a
{
  private final String TAG;
  private com.tencent.mm.al.f callback;
  public vh pbO;
  private b rr;
  
  public f(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(63905);
    this.TAG = "MicroMsg.NetSceneQrRewardScanCode";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new vg();
    ((b.a)localObject).hNN = new vh();
    ((b.a)localObject).funcId = 1516;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/scanrewardqrcode";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (vg)this.rr.hNK.hNQ;
    ((vg)localObject).paB = paramString1;
    ((vg)localObject).channel = paramInt;
    ((vg)localObject).FUG = paramString2;
    AppMethodBeat.o(63905);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63907);
    ad.i("MicroMsg.NetSceneQrRewardScanCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.pbO = ((vh)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneQrRewardScanCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.pbO.dlw), this.pbO.paA });
    if ((!this.pbG) && (this.pbO.dlw != 0)) {
      this.pbH = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63907);
  }
  
  protected final boolean caG()
  {
    return false;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(63906);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(63906);
    return i;
  }
  
  public final int getType()
  {
    return 1516;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.f
 * JD-Core Version:    0.7.0.1
 */