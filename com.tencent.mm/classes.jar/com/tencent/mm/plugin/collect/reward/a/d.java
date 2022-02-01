package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.wj;
import com.tencent.mm.protocal.protobuf.wk;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends a
{
  private final String TAG;
  private i callback;
  private wk qxD;
  private com.tencent.mm.ak.d rr;
  
  public d(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    AppMethodBeat.i(63899);
    this.TAG = "MicroMsg.NetSceneQrRewardPayCheck";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new wj();
    ((d.a)localObject).iLO = new wk();
    ((d.a)localObject).funcId = 1960;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/rewardqrcodepaycheck";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (wj)this.rr.iLK.iLR;
    ((wj)localObject).dNQ = paramString1;
    ((wj)localObject).LhB = paramString2;
    ((wj)localObject).KHN = paramString3;
    ((wj)localObject).yRL = paramInt;
    ((wj)localObject).Lhz = paramString4;
    ((wj)localObject).Lhy = paramString5;
    Log.i("MicroMsg.NetSceneQrRewardPayCheck", "rewardid: %s, amt: %s", new Object[] { paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63899);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(63901);
    Log.i("MicroMsg.NetSceneQrRewardPayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.qxD = ((wk)((com.tencent.mm.ak.d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneQrRewardPayCheck", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.qxD.dDN), this.qxD.qwn });
    if ((!this.qxx) && (this.qxD.dDN != 0)) {
      this.qxy = true;
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