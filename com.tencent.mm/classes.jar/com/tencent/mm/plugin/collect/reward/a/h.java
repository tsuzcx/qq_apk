package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.protocal.protobuf.vj;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
  extends a
{
  private final String TAG;
  private f callback;
  public String nZO;
  public vj pbQ;
  private b rr;
  
  public h(String paramString)
  {
    AppMethodBeat.i(63911);
    this.TAG = "MicroMsg.NetSceneQrRewardSetPhotoWord";
    b.a locala = new b.a();
    locala.hNM = new vi();
    locala.hNN = new vj();
    locala.funcId = 1649;
    locala.uri = "/cgi-bin/mmpay-bin/setrewardqrcodephotoword";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((vi)this.rr.hNK.hNQ).nZO = paramString;
    this.nZO = paramString;
    if ((paramString.length() > 0) && (paramString.length() <= 3))
    {
      g.yhR.idkeyStat(724L, 0L, 1L, false);
      AppMethodBeat.o(63911);
      return;
    }
    if (paramString.length() > 3) {
      g.yhR.idkeyStat(724L, 1L, 1L, false);
    }
    AppMethodBeat.o(63911);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63913);
    ad.i("MicroMsg.NetSceneQrRewardSetPhotoWord", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.pbQ = ((vj)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneQrRewardSetPhotoWord", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.pbQ.dlw), this.pbQ.paA });
    if ((!this.pbG) && (this.pbQ.dlw != 0)) {
      this.pbH = true;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63913);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(63912);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
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