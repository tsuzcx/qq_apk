package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.tl;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.sdk.platformtools.ac;

public final class f
  extends a
{
  private final String TAG;
  private g callback;
  public tm oyt;
  private b rr;
  
  public f(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(63905);
    this.TAG = "MicroMsg.NetSceneQrRewardScanCode";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new tl();
    ((b.a)localObject).hvu = new tm();
    ((b.a)localObject).funcId = 1516;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/scanrewardqrcode";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (tl)this.rr.hvr.hvw;
    ((tl)localObject).oxg = paramString1;
    ((tl)localObject).channel = paramInt;
    ((tl)localObject).Enx = paramString2;
    AppMethodBeat.o(63905);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63907);
    ac.i("MicroMsg.NetSceneQrRewardScanCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.oyt = ((tm)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneQrRewardScanCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.oyt.dae), this.oyt.oxf });
    if ((!this.oyl) && (this.oyt.dae != 0)) {
      this.oym = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63907);
  }
  
  protected final boolean bWd()
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