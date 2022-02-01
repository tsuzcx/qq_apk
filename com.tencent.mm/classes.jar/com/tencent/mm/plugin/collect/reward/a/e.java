package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.protocal.protobuf.yl;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends a
{
  private final String TAG;
  private h callback;
  private c rr;
  public yl wZW;
  
  public e(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt4)
  {
    AppMethodBeat.i(63902);
    this.TAG = "MicroMsg.NetSceneQrRewardPlaceOrder";
    Object localObject = new c.a();
    ((c.a)localObject).otE = new yk();
    ((c.a)localObject).otF = new yl();
    ((c.a)localObject).funcId = 1336;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/rewardqrcodeplaceorder";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (yk)c.b.b(this.rr.otB);
    ((yk)localObject).amount = paramInt1;
    ((yk)localObject).Zhb = paramInt2;
    ((yk)localObject).ZgZ = paramString1;
    ((yk)localObject).Zha = paramString2;
    ((yk)localObject).Oki = paramString3;
    ((yk)localObject).channel = paramInt3;
    ((yk)localObject).Zhc = paramString4;
    ((yk)localObject).ZgT = paramString5;
    ((yk)localObject).Zhd = paramString6;
    ((yk)localObject).Zhe = paramString7;
    ((yk)localObject).Zhf = paramString8;
    ((yk)localObject).Zhg = paramInt4;
    AppMethodBeat.o(63902);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(63904);
    Log.i("MicroMsg.NetSceneQrRewardPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wZW = ((yl)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneQrRewardPlaceOrder", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.wZW.hAV), this.wZW.wYI });
    if ((!this.oaK) && (this.wZW.hAV != 0)) {
      this.wZR = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63904);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(63903);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(63903);
    return i;
  }
  
  public final int getType()
  {
    return 1336;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.e
 * JD-Core Version:    0.7.0.1
 */