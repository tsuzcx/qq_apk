package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.protocal.protobuf.qp;
import com.tencent.mm.sdk.platformtools.ab;

public final class f
  extends a
{
  private final String TAG;
  private com.tencent.mm.ai.f callback;
  public qp kOK;
  private b rr;
  
  public f(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(41045);
    this.TAG = "MicroMsg.NetSceneQrRewardScanCode";
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new qo();
    ((b.a)localObject).fsY = new qp();
    ((b.a)localObject).funcId = 1516;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/scanrewardqrcode";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (qo)this.rr.fsV.fta;
    ((qo)localObject).kNw = paramString1;
    ((qo)localObject).cCy = paramInt;
    ((qo)localObject).wIR = paramString2;
    AppMethodBeat.o(41045);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(41047);
    ab.i("MicroMsg.NetSceneQrRewardScanCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.kOK = ((qp)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneQrRewardScanCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.kOK.cnK), this.kOK.kNv });
    if ((!this.kOC) && (this.kOK.cnK != 0)) {
      this.kOD = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(41047);
  }
  
  protected final boolean bhR()
  {
    return false;
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(41046);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(41046);
    return i;
  }
  
  public final int getType()
  {
    return 1516;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.f
 * JD-Core Version:    0.7.0.1
 */