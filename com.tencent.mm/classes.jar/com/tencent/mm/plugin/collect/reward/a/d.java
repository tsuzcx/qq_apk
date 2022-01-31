package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.qk;
import com.tencent.mm.protocal.protobuf.ql;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends a
{
  private final String TAG;
  private f callback;
  private ql kOI;
  private b rr;
  
  public d(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    AppMethodBeat.i(41039);
    this.TAG = "MicroMsg.NetSceneQrRewardPayCheck";
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new qk();
    ((b.a)localObject).fsY = new ql();
    ((b.a)localObject).funcId = 1960;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/rewardqrcodepaycheck";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (qk)this.rr.fsV.fta;
    ((qk)localObject).cwk = paramString1;
    ((qk)localObject).wIM = paramString2;
    ((qk)localObject).wpq = paramString3;
    ((qk)localObject).okH = paramInt;
    ((qk)localObject).wIK = paramString4;
    ((qk)localObject).wIJ = paramString5;
    ab.i("MicroMsg.NetSceneQrRewardPayCheck", "rewardid: %s, amt: %s", new Object[] { paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(41039);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(41041);
    ab.i("MicroMsg.NetSceneQrRewardPayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.kOI = ((ql)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneQrRewardPayCheck", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.kOI.cnK), this.kOI.kNv });
    if ((!this.kOC) && (this.kOI.cnK != 0)) {
      this.kOD = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(41041);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(41040);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(41040);
    return i;
  }
  
  public final int getType()
  {
    return 1960;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.d
 * JD-Core Version:    0.7.0.1
 */