package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.protocal.protobuf.wt;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  extends a
{
  private final String TAG;
  private i callback;
  public String pqv;
  public wt qxH;
  private d rr;
  
  public h(String paramString)
  {
    AppMethodBeat.i(63911);
    this.TAG = "MicroMsg.NetSceneQrRewardSetPhotoWord";
    d.a locala = new d.a();
    locala.iLN = new ws();
    locala.iLO = new wt();
    locala.funcId = 1649;
    locala.uri = "/cgi-bin/mmpay-bin/setrewardqrcodephotoword";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((ws)this.rr.iLK.iLR).pqv = paramString;
    this.pqv = paramString;
    if ((paramString.length() > 0) && (paramString.length() <= 3))
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(724L, 0L, 1L, false);
      AppMethodBeat.o(63911);
      return;
    }
    if (paramString.length() > 3) {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(724L, 1L, 1L, false);
    }
    AppMethodBeat.o(63911);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(63913);
    Log.i("MicroMsg.NetSceneQrRewardSetPhotoWord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.qxH = ((wt)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneQrRewardSetPhotoWord", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.qxH.dDN), this.qxH.qwn });
    if ((!this.qxx) && (this.qxH.dDN != 0)) {
      this.qxy = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63913);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(63912);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(63912);
    return i;
  }
  
  public final int getType()
  {
    return 1649;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.h
 * JD-Core Version:    0.7.0.1
 */