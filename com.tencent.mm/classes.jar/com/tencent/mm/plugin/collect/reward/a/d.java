package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.vc;
import com.tencent.mm.protocal.protobuf.vd;
import com.tencent.mm.sdk.platformtools.ae;

public final class d
  extends a
{
  private final String TAG;
  private f callback;
  private vd pis;
  private b rr;
  
  public d(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    AppMethodBeat.i(63899);
    this.TAG = "MicroMsg.NetSceneQrRewardPayCheck";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new vc();
    ((b.a)localObject).hQG = new vd();
    ((b.a)localObject).funcId = 1960;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/rewardqrcodepaycheck";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (vc)this.rr.hQD.hQJ;
    ((vc)localObject).dwj = paramString1;
    ((vc)localObject).GmX = paramString2;
    ((vc)localObject).FOg = paramString3;
    ((vc)localObject).vxx = paramInt;
    ((vc)localObject).GmV = paramString4;
    ((vc)localObject).GmU = paramString5;
    ae.i("MicroMsg.NetSceneQrRewardPayCheck", "rewardid: %s, amt: %s", new Object[] { paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63899);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63901);
    ae.i("MicroMsg.NetSceneQrRewardPayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.pis = ((vd)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneQrRewardPayCheck", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.pis.dmy), this.pis.phe });
    if ((!this.pil) && (this.pis.dmy != 0)) {
      this.pim = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63901);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(63900);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
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