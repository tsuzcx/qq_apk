package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.protocal.protobuf.to;
import com.tencent.mm.sdk.platformtools.ac;

public final class h
  extends a
{
  private final String TAG;
  private g callback;
  public String nyq;
  public to oyv;
  private b rr;
  
  public h(String paramString)
  {
    AppMethodBeat.i(63911);
    this.TAG = "MicroMsg.NetSceneQrRewardSetPhotoWord";
    b.a locala = new b.a();
    locala.hvt = new tn();
    locala.hvu = new to();
    locala.funcId = 1649;
    locala.uri = "/cgi-bin/mmpay-bin/setrewardqrcodephotoword";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((tn)this.rr.hvr.hvw).nyq = paramString;
    this.nyq = paramString;
    if ((paramString.length() > 0) && (paramString.length() <= 3))
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(724L, 0L, 1L, false);
      AppMethodBeat.o(63911);
      return;
    }
    if (paramString.length() > 3) {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(724L, 1L, 1L, false);
    }
    AppMethodBeat.o(63911);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63913);
    ac.i("MicroMsg.NetSceneQrRewardSetPhotoWord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.oyv = ((to)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneQrRewardSetPhotoWord", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.oyv.dae), this.oyv.oxf });
    if ((!this.oyl) && (this.oyv.dae != 0)) {
      this.oym = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63913);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(63912);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(63912);
    return i;
  }
  
  public final int getType()
  {
    return 1649;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.h
 * JD-Core Version:    0.7.0.1
 */