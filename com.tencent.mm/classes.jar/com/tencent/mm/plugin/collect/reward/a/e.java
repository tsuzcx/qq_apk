package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.protocal.protobuf.wt;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends a
{
  private final String TAG;
  private i callback;
  private d rr;
  public wt tWE;
  
  public e(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt4)
  {
    AppMethodBeat.i(63902);
    this.TAG = "MicroMsg.NetSceneQrRewardPlaceOrder";
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ws();
    ((d.a)localObject).lBV = new wt();
    ((d.a)localObject).funcId = 1336;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/rewardqrcodeplaceorder";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ws)d.b.b(this.rr.lBR);
    ((ws)localObject).amount = paramInt1;
    ((ws)localObject).SiV = paramInt2;
    ((ws)localObject).SiT = paramString1;
    ((ws)localObject).SiU = paramString2;
    ((ws)localObject).ImS = paramString3;
    ((ws)localObject).channel = paramInt3;
    ((ws)localObject).SiW = paramString4;
    ((ws)localObject).SiN = paramString5;
    ((ws)localObject).SiX = paramString6;
    ((ws)localObject).SiY = paramString7;
    ((ws)localObject).SiZ = paramString8;
    ((ws)localObject).Sja = paramInt4;
    AppMethodBeat.o(63902);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(63904);
    Log.i("MicroMsg.NetSceneQrRewardPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.tWE = ((wt)d.c.b(((d)params).lBS));
    Log.i("MicroMsg.NetSceneQrRewardPlaceOrder", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.tWE.fwx), this.tWE.tVo });
    if ((!this.tWx) && (this.tWE.fwx != 0)) {
      this.tWy = true;
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