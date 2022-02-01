package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.wu;
import com.tencent.mm.protocal.protobuf.wv;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  extends a
{
  private final String TAG;
  private i callback;
  private d rr;
  public wv tWF;
  
  public f(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(63905);
    this.TAG = "MicroMsg.NetSceneQrRewardScanCode";
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new wu();
    ((d.a)localObject).lBV = new wv();
    ((d.a)localObject).funcId = 1516;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/scanrewardqrcode";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (wu)d.b.b(this.rr.lBR);
    ((wu)localObject).tVp = paramString1;
    ((wu)localObject).channel = paramInt;
    ((wu)localObject).SiX = paramString2;
    AppMethodBeat.o(63905);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(63907);
    Log.i("MicroMsg.NetSceneQrRewardScanCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.tWF = ((wv)d.c.b(((d)params).lBS));
    Log.i("MicroMsg.NetSceneQrRewardScanCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.tWF.fwx), this.tWF.tVo });
    if ((!this.tWx) && (this.tWF.fwx != 0)) {
      this.tWy = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63907);
  }
  
  protected final boolean cOp()
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