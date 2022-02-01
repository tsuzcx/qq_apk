package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.tj;
import com.tencent.mm.protocal.protobuf.tk;
import com.tencent.mm.sdk.platformtools.ac;

public final class e
  extends a
{
  private final String TAG;
  private g callback;
  public tk oys;
  private b rr;
  
  public e(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt4)
  {
    AppMethodBeat.i(63902);
    this.TAG = "MicroMsg.NetSceneQrRewardPlaceOrder";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new tj();
    ((b.a)localObject).hvu = new tk();
    ((b.a)localObject).funcId = 1336;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/rewardqrcodeplaceorder";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (tj)this.rr.hvr.hvw;
    ((tj)localObject).uiK = paramInt1;
    ((tj)localObject).Env = paramInt2;
    ((tj)localObject).Ent = paramString1;
    ((tj)localObject).Enu = paramString2;
    ((tj)localObject).wLo = paramString3;
    ((tj)localObject).channel = paramInt3;
    ((tj)localObject).Enw = paramString4;
    ((tj)localObject).Enn = paramString5;
    ((tj)localObject).Enx = paramString6;
    ((tj)localObject).Eny = paramString7;
    ((tj)localObject).Enz = paramString8;
    ((tj)localObject).EnA = paramInt4;
    AppMethodBeat.o(63902);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63904);
    ac.i("MicroMsg.NetSceneQrRewardPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.oys = ((tk)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneQrRewardPlaceOrder", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.oys.dae), this.oys.oxf });
    if ((!this.oyl) && (this.oys.dae != 0)) {
      this.oym = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63904);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(63903);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
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