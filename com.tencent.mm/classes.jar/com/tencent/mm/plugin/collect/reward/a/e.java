package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.wo;
import com.tencent.mm.protocal.protobuf.wp;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends a
{
  private final String TAG;
  private i callback;
  public wp qxE;
  private d rr;
  
  public e(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt4)
  {
    AppMethodBeat.i(63902);
    this.TAG = "MicroMsg.NetSceneQrRewardPlaceOrder";
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new wo();
    ((d.a)localObject).iLO = new wp();
    ((d.a)localObject).funcId = 1336;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/rewardqrcodeplaceorder";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (wo)this.rr.iLK.iLR;
    ((wo)localObject).yRL = paramInt1;
    ((wo)localObject).LhH = paramInt2;
    ((wo)localObject).LhF = paramString1;
    ((wo)localObject).LhG = paramString2;
    ((wo)localObject).CpD = paramString3;
    ((wo)localObject).channel = paramInt3;
    ((wo)localObject).LhI = paramString4;
    ((wo)localObject).Lhz = paramString5;
    ((wo)localObject).LhJ = paramString6;
    ((wo)localObject).LhK = paramString7;
    ((wo)localObject).LhL = paramString8;
    ((wo)localObject).LhM = paramInt4;
    AppMethodBeat.o(63902);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(63904);
    Log.i("MicroMsg.NetSceneQrRewardPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.qxE = ((wp)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneQrRewardPlaceOrder", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.qxE.dDN), this.qxE.qwn });
    if ((!this.qxx) && (this.qxE.dDN != 0)) {
      this.qxy = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63904);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(63903);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
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