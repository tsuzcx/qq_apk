package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ym;
import com.tencent.mm.protocal.protobuf.yn;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  extends a
{
  private final String TAG;
  private h callback;
  private c rr;
  public yn wZX;
  
  public f(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(63905);
    this.TAG = "MicroMsg.NetSceneQrRewardScanCode";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ym();
    ((c.a)localObject).otF = new yn();
    ((c.a)localObject).funcId = 1516;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/scanrewardqrcode";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ym)c.b.b(this.rr.otB);
    ((ym)localObject).wYJ = paramString1;
    ((ym)localObject).channel = paramInt;
    ((ym)localObject).Zhd = paramString2;
    AppMethodBeat.o(63905);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(63907);
    Log.i("MicroMsg.NetSceneQrRewardScanCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wZX = ((yn)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneQrRewardScanCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.wZX.hAV), this.wZX.wYI });
    if ((!this.oaK) && (this.wZX.hAV != 0)) {
      this.wZR = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63907);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(63906);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(63906);
    return i;
  }
  
  protected final boolean drU()
  {
    return false;
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