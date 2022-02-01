package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ut;
import com.tencent.mm.protocal.protobuf.uu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends a
{
  private final String TAG;
  private f callback;
  public uu pip;
  public boolean piq;
  private com.tencent.mm.ak.b rr;
  
  public b(boolean paramBoolean)
  {
    AppMethodBeat.i(63894);
    this.TAG = "MicroMsg.NetSceneQrRewardGetCode";
    b.a locala = new b.a();
    locala.hQF = new ut();
    locala.hQG = new uu();
    locala.funcId = 1323;
    locala.uri = "/cgi-bin/mmpay-bin/getrewardqrcode";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((ut)this.rr.hQD.hQJ).GmF = paramBoolean;
    this.piq = paramBoolean;
    AppMethodBeat.o(63894);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63896);
    ae.i("MicroMsg.NetSceneQrRewardGetCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.pip = ((uu)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneQrRewardGetCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.pip.dmy), this.pip.phe });
    if ((!this.pil) && (this.pip.dmy != 0)) {
      this.pim = true;
    }
    if ((!this.pil) && (!this.pim))
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVR, Integer.valueOf(this.pip.GmM));
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVS, Integer.valueOf(this.pip.GmI));
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVU, this.pip.desc);
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVT, this.pip.ofy);
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVW, Integer.valueOf(this.pip.GmL));
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVY, this.pip.oGe);
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVZ, this.pip.GmK);
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWa, this.pip.ynq);
      paramq = new ArrayList();
      Iterator localIterator = this.pip.GmJ.iterator();
      while (localIterator.hasNext()) {
        paramq.add(String.valueOf(((Integer)localIterator.next()).intValue()));
      }
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVX, bu.m(paramq, ","));
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(724L, 2L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      }
      AppMethodBeat.o(63896);
      return;
      if (this.pil) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(724L, 4L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(724L, 3L, 1L, false);
      }
    }
  }
  
  protected final boolean cbV()
  {
    return false;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(63895);
    this.callback = paramf;
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