package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.wl;
import com.tencent.mm.protocal.protobuf.wm;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends a
{
  private final String TAG;
  private i callback;
  private com.tencent.mm.an.d rr;
  private wm tWD;
  
  public d(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    AppMethodBeat.i(63899);
    this.TAG = "MicroMsg.NetSceneQrRewardPayCheck";
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new wl();
    ((d.a)localObject).lBV = new wm();
    ((d.a)localObject).funcId = 1960;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/rewardqrcodepaycheck";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (wl)d.b.b(this.rr.lBR);
    ((wl)localObject).fHb = paramString1;
    ((wl)localObject).SiO = paramString2;
    ((wl)localObject).InV = paramString3;
    ((wl)localObject).amount = paramInt;
    ((wl)localObject).SiN = paramString4;
    ((wl)localObject).SiM = paramString5;
    Log.i("MicroMsg.NetSceneQrRewardPayCheck", "rewardid: %s, amt: %s", new Object[] { paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63899);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(63901);
    Log.i("MicroMsg.NetSceneQrRewardPayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.tWD = ((wm)d.c.b(((com.tencent.mm.an.d)params).lBS));
    Log.i("MicroMsg.NetSceneQrRewardPayCheck", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.tWD.fwx), this.tWD.tVo });
    if ((!this.tWx) && (this.tWD.fwx != 0)) {
      this.tWy = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63901);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(63900);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(63900);
    return i;
  }
  
  public final int getType()
  {
    return 1960;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.d
 * JD-Core Version:    0.7.0.1
 */