package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.tf;
import com.tencent.mm.protocal.protobuf.tg;
import com.tencent.mm.sdk.platformtools.ac;

public final class d
  extends a
{
  private final String TAG;
  private g callback;
  private tg oyr;
  private b rr;
  
  public d(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    AppMethodBeat.i(63899);
    this.TAG = "MicroMsg.NetSceneQrRewardPayCheck";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new tf();
    ((b.a)localObject).hvu = new tg();
    ((b.a)localObject).funcId = 1960;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/rewardqrcodepaycheck";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (tf)this.rr.hvr.hvw;
    ((tf)localObject).djr = paramString1;
    ((tf)localObject).Enp = paramString2;
    ((tf)localObject).DQt = paramString3;
    ((tf)localObject).uiK = paramInt;
    ((tf)localObject).Enn = paramString4;
    ((tf)localObject).Enm = paramString5;
    ac.i("MicroMsg.NetSceneQrRewardPayCheck", "rewardid: %s, amt: %s", new Object[] { paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63899);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63901);
    ac.i("MicroMsg.NetSceneQrRewardPayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.oyr = ((tg)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneQrRewardPayCheck", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.oyr.dae), this.oyr.oxf });
    if ((!this.oyl) && (this.oyr.dae != 0)) {
      this.oym = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63901);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(63900);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(63900);
    return i;
  }
  
  public final int getType()
  {
    return 1960;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.d
 * JD-Core Version:    0.7.0.1
 */