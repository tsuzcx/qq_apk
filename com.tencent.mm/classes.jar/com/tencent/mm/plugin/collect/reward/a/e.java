package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.qm;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.sdk.platformtools.ab;

public final class e
  extends a
{
  private final String TAG;
  private f callback;
  public qn kOJ;
  private b rr;
  
  public e(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt4)
  {
    AppMethodBeat.i(41042);
    this.TAG = "MicroMsg.NetSceneQrRewardPlaceOrder";
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new qm();
    ((b.a)localObject).fsY = new qn();
    ((b.a)localObject).funcId = 1336;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/rewardqrcodeplaceorder";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (qm)this.rr.fsV.fta;
    ((qm)localObject).okH = paramInt1;
    ((qm)localObject).wIP = paramInt2;
    ((qm)localObject).wIN = paramString1;
    ((qm)localObject).wIO = paramString2;
    ((qm)localObject).qkh = paramString3;
    ((qm)localObject).cCy = paramInt3;
    ((qm)localObject).wIQ = paramString4;
    ((qm)localObject).wIK = paramString5;
    ((qm)localObject).wIR = paramString6;
    ((qm)localObject).wIS = paramString7;
    ((qm)localObject).wIT = paramString8;
    ((qm)localObject).wIU = paramInt4;
    AppMethodBeat.o(41042);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(41044);
    ab.i("MicroMsg.NetSceneQrRewardPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.kOJ = ((qn)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneQrRewardPlaceOrder", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.kOJ.cnK), this.kOJ.kNv });
    if ((!this.kOC) && (this.kOJ.cnK != 0)) {
      this.kOD = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(41044);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(41043);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(41043);
    return i;
  }
  
  public final int getType()
  {
    return 1336;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.e
 * JD-Core Version:    0.7.0.1
 */