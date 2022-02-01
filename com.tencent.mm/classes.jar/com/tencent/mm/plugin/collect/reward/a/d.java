package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.va;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends a
{
  private final String TAG;
  private f callback;
  private vb pbM;
  private b rr;
  
  public d(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    AppMethodBeat.i(63899);
    this.TAG = "MicroMsg.NetSceneQrRewardPayCheck";
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new va();
    ((b.a)localObject).hNN = new vb();
    ((b.a)localObject).funcId = 1960;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/rewardqrcodepaycheck";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (va)this.rr.hNK.hNQ;
    ((va)localObject).dve = paramString1;
    ((va)localObject).FUy = paramString2;
    ((va)localObject).FvI = paramString3;
    ((va)localObject).vls = paramInt;
    ((va)localObject).FUw = paramString4;
    ((va)localObject).FUv = paramString5;
    ad.i("MicroMsg.NetSceneQrRewardPayCheck", "rewardid: %s, amt: %s", new Object[] { paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63899);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63901);
    ad.i("MicroMsg.NetSceneQrRewardPayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.pbM = ((vb)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneQrRewardPayCheck", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.pbM.dlw), this.pbM.paA });
    if ((!this.pbG) && (this.pbM.dlw != 0)) {
      this.pbH = true;
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