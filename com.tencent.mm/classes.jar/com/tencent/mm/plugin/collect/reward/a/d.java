package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.yd;
import com.tencent.mm.protocal.protobuf.ye;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends a
{
  private final String TAG;
  private h callback;
  private c rr;
  private ye wZV;
  
  public d(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    AppMethodBeat.i(63899);
    this.TAG = "MicroMsg.NetSceneQrRewardPayCheck";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new yd();
    ((c.a)localObject).otF = new ye();
    ((c.a)localObject).funcId = 1960;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/rewardqrcodepaycheck";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (yd)c.b.b(this.rr.otB);
    ((yd)localObject).hMy = paramString1;
    ((yd)localObject).ZgU = paramString2;
    ((yd)localObject).Oln = paramString3;
    ((yd)localObject).amount = paramInt;
    ((yd)localObject).ZgT = paramString4;
    ((yd)localObject).ZgS = paramString5;
    Log.i("MicroMsg.NetSceneQrRewardPayCheck", "rewardid: %s, amt: %s", new Object[] { paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63899);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(63901);
    Log.i("MicroMsg.NetSceneQrRewardPayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wZV = ((ye)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneQrRewardPayCheck", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.wZV.hAV), this.wZV.wYI });
    if ((!this.oaK) && (this.wZV.hAV != 0)) {
      this.wZR = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63901);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(63900);
    this.callback = paramh;
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