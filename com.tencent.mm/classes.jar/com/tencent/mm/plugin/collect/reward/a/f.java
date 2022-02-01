package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.wq;
import com.tencent.mm.protocal.protobuf.wr;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  extends a
{
  private final String TAG;
  private i callback;
  public wr qxF;
  private d rr;
  
  public f(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(63905);
    this.TAG = "MicroMsg.NetSceneQrRewardScanCode";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new wq();
    ((d.a)localObject).iLO = new wr();
    ((d.a)localObject).funcId = 1516;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/scanrewardqrcode";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (wq)this.rr.iLK.iLR;
    ((wq)localObject).qwo = paramString1;
    ((wq)localObject).channel = paramInt;
    ((wq)localObject).LhJ = paramString2;
    AppMethodBeat.o(63905);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(63907);
    Log.i("MicroMsg.NetSceneQrRewardScanCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.qxF = ((wr)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneQrRewardScanCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.qxF.dDN), this.qxF.qwn });
    if ((!this.qxx) && (this.qxF.dDN != 0)) {
      this.qxy = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63907);
  }
  
  protected final boolean czP()
  {
    return false;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(63906);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
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