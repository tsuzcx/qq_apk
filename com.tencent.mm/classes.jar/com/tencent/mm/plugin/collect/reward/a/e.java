package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.vg;
import com.tencent.mm.protocal.protobuf.vh;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
  extends a
{
  private final String TAG;
  private f callback;
  public vh pit;
  private b rr;
  
  public e(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt4)
  {
    AppMethodBeat.i(63902);
    this.TAG = "MicroMsg.NetSceneQrRewardPlaceOrder";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new vg();
    ((b.a)localObject).hQG = new vh();
    ((b.a)localObject).funcId = 1336;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/rewardqrcodeplaceorder";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (vg)this.rr.hQD.hQJ;
    ((vg)localObject).vxx = paramInt1;
    ((vg)localObject).Gnd = paramInt2;
    ((vg)localObject).Gnb = paramString1;
    ((vg)localObject).Gnc = paramString2;
    ((vg)localObject).yoN = paramString3;
    ((vg)localObject).channel = paramInt3;
    ((vg)localObject).Gne = paramString4;
    ((vg)localObject).GmV = paramString5;
    ((vg)localObject).Gnf = paramString6;
    ((vg)localObject).Gng = paramString7;
    ((vg)localObject).Gnh = paramString8;
    ((vg)localObject).Gni = paramInt4;
    AppMethodBeat.o(63902);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63904);
    ae.i("MicroMsg.NetSceneQrRewardPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.pit = ((vh)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneQrRewardPlaceOrder", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.pit.dmy), this.pit.phe });
    if ((!this.pil) && (this.pit.dmy != 0)) {
      this.pim = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63904);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(63903);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(63903);
    return i;
  }
  
  public final int getType()
  {
    return 1336;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.e
 * JD-Core Version:    0.7.0.1
 */