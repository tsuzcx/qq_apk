package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ve;
import com.tencent.mm.protocal.protobuf.vf;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends a
{
  private final String TAG;
  private f callback;
  public vf pbN;
  private b rr;
  
  public e(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt4)
  {
    AppMethodBeat.i(63902);
    this.TAG = "MicroMsg.NetSceneQrRewardPlaceOrder";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new ve();
    ((b.a)localObject).hNN = new vf();
    ((b.a)localObject).funcId = 1336;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/rewardqrcodeplaceorder";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (ve)this.rr.hNK.hNQ;
    ((ve)localObject).vls = paramInt1;
    ((ve)localObject).FUE = paramInt2;
    ((ve)localObject).FUC = paramString1;
    ((ve)localObject).FUD = paramString2;
    ((ve)localObject).xYV = paramString3;
    ((ve)localObject).channel = paramInt3;
    ((ve)localObject).FUF = paramString4;
    ((ve)localObject).FUw = paramString5;
    ((ve)localObject).FUG = paramString6;
    ((ve)localObject).FUH = paramString7;
    ((ve)localObject).FUI = paramString8;
    ((ve)localObject).FUJ = paramInt4;
    AppMethodBeat.o(63902);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63904);
    ad.i("MicroMsg.NetSceneQrRewardPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.pbN = ((vf)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneQrRewardPlaceOrder", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.pbN.dlw), this.pbN.paA });
    if ((!this.pbG) && (this.pbN.dlw != 0)) {
      this.pbH = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.e
 * JD-Core Version:    0.7.0.1
 */