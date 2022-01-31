package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.qq;
import com.tencent.mm.protocal.protobuf.qr;
import com.tencent.mm.sdk.platformtools.ab;

public final class h
  extends a
{
  private final String TAG;
  private f callback;
  public String jVh;
  public qr kOM;
  private b rr;
  
  public h(String paramString)
  {
    AppMethodBeat.i(41051);
    this.TAG = "MicroMsg.NetSceneQrRewardSetPhotoWord";
    b.a locala = new b.a();
    locala.fsX = new qq();
    locala.fsY = new qr();
    locala.funcId = 1649;
    locala.uri = "/cgi-bin/mmpay-bin/setrewardqrcodephotoword";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((qq)this.rr.fsV.fta).jVh = paramString;
    this.jVh = paramString;
    if ((paramString.length() > 0) && (paramString.length() <= 3))
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(724L, 0L, 1L, false);
      AppMethodBeat.o(41051);
      return;
    }
    if (paramString.length() > 3) {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(724L, 1L, 1L, false);
    }
    AppMethodBeat.o(41051);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(41053);
    ab.i("MicroMsg.NetSceneQrRewardSetPhotoWord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.kOM = ((qr)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneQrRewardSetPhotoWord", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.kOM.cnK), this.kOM.kNv });
    if ((!this.kOC) && (this.kOM.cnK != 0)) {
      this.kOD = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(41053);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(41052);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(41052);
    return i;
  }
  
  public final int getType()
  {
    return 1649;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.h
 * JD-Core Version:    0.7.0.1
 */