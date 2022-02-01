package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.sw;
import com.tencent.mm.protocal.protobuf.sx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends a
{
  private final String TAG;
  private com.tencent.mm.ak.g callback;
  public sx oyo;
  public boolean oyp;
  private com.tencent.mm.ak.b rr;
  
  public b(boolean paramBoolean)
  {
    AppMethodBeat.i(63894);
    this.TAG = "MicroMsg.NetSceneQrRewardGetCode";
    b.a locala = new b.a();
    locala.hvt = new sw();
    locala.hvu = new sx();
    locala.funcId = 1323;
    locala.uri = "/cgi-bin/mmpay-bin/getrewardqrcode";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((sw)this.rr.hvr.hvw).EmX = paramBoolean;
    this.oyp = paramBoolean;
    AppMethodBeat.o(63894);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63896);
    ac.i("MicroMsg.NetSceneQrRewardGetCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.oyo = ((sx)((com.tencent.mm.ak.b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneQrRewardGetCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.oyo.dae), this.oyo.oxf });
    if ((!this.oyl) && (this.oyo.dae != 0)) {
      this.oym = true;
    }
    if ((!this.oyl) && (!this.oym))
    {
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOX, Integer.valueOf(this.oyo.Ene));
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOY, Integer.valueOf(this.oyo.Ena));
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPa, this.oyo.desc);
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOZ, this.oyo.nyq);
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPc, Integer.valueOf(this.oyo.End));
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPe, this.oyo.nWi);
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPf, this.oyo.Enc);
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPg, this.oyo.wJR);
      paramq = new ArrayList();
      Iterator localIterator = this.oyo.Enb.iterator();
      while (localIterator.hasNext()) {
        paramq.add(String.valueOf(((Integer)localIterator.next()).intValue()));
      }
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPd, bs.n(paramq, ","));
      h.wUl.idkeyStat(724L, 2L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      }
      AppMethodBeat.o(63896);
      return;
      if (this.oyl) {
        h.wUl.idkeyStat(724L, 4L, 1L, false);
      } else {
        h.wUl.idkeyStat(724L, 3L, 1L, false);
      }
    }
  }
  
  protected final boolean bWd()
  {
    return false;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.b
 * JD-Core Version:    0.7.0.1
 */