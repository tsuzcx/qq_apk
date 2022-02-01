package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.sm;
import com.tencent.mm.protocal.protobuf.sn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends a
{
  private final String TAG;
  private com.tencent.mm.al.g callback;
  public sn nUT;
  public boolean nUU;
  private com.tencent.mm.al.b rr;
  
  public b(boolean paramBoolean)
  {
    AppMethodBeat.i(63894);
    this.TAG = "MicroMsg.NetSceneQrRewardGetCode";
    b.a locala = new b.a();
    locala.gUU = new sm();
    locala.gUV = new sn();
    locala.funcId = 1323;
    locala.uri = "/cgi-bin/mmpay-bin/getrewardqrcode";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    ((sm)this.rr.gUS.gUX).CUn = paramBoolean;
    this.nUU = paramBoolean;
    AppMethodBeat.o(63894);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63896);
    ad.i("MicroMsg.NetSceneQrRewardGetCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.nUT = ((sn)((com.tencent.mm.al.b)paramq).gUT.gUX);
    ad.i("MicroMsg.NetSceneQrRewardGetCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.nUT.dcG), this.nUT.nTK });
    if ((!this.nUQ) && (this.nUT.dcG != 0)) {
      this.nUR = true;
    }
    if ((!this.nUQ) && (!this.nUR))
    {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Frh, Integer.valueOf(this.nUT.CUu));
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fri, Integer.valueOf(this.nUT.CUq));
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Frk, this.nUT.desc);
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Frj, this.nUT.mVR);
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Frm, Integer.valueOf(this.nUT.CUt));
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fro, this.nUT.nti);
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Frp, this.nUT.CUs);
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Frq, this.nUT.vzM);
      paramq = new ArrayList();
      Iterator localIterator = this.nUT.CUr.iterator();
      while (localIterator.hasNext()) {
        paramq.add(String.valueOf(((Integer)localIterator.next()).intValue()));
      }
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Frn, bt.n(paramq, ","));
      h.vKh.idkeyStat(724L, 2L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      }
      AppMethodBeat.o(63896);
      return;
      if (this.nUQ) {
        h.vKh.idkeyStat(724L, 4L, 1L, false);
      } else {
        h.vKh.idkeyStat(724L, 3L, 1L, false);
      }
    }
  }
  
  protected final boolean bON()
  {
    return false;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(63895);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(63895);
    return i;
  }
  
  public final int getType()
  {
    return 1323;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.b
 * JD-Core Version:    0.7.0.1
 */