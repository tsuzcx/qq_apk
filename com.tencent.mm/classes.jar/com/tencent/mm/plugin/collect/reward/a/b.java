package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.xu;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends a
{
  private final String TAG;
  private com.tencent.mm.am.h callback;
  public boolean qmM;
  private c rr;
  public xv wZT;
  
  public b(boolean paramBoolean)
  {
    AppMethodBeat.i(63894);
    this.TAG = "MicroMsg.NetSceneQrRewardGetCode";
    c.a locala = new c.a();
    locala.otE = new xu();
    locala.otF = new xv();
    locala.funcId = 1323;
    locala.uri = "/cgi-bin/mmpay-bin/getrewardqrcode";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((xu)c.b.b(this.rr.otB)).ZgD = paramBoolean;
    this.qmM = paramBoolean;
    AppMethodBeat.o(63894);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(63896);
    Log.i("MicroMsg.NetSceneQrRewardGetCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.wZT = ((xv)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneQrRewardGetCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.wZT.hAV), this.wZT.wYI });
    if ((!this.oaK) && (this.wZT.hAV != 0)) {
      this.wZR = true;
    }
    if ((!this.oaK) && (!this.wZR))
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acTZ, Integer.valueOf(this.wZT.ZgK));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acUa, Integer.valueOf(this.wZT.ZgG));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acUc, this.wZT.desc);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acUb, this.wZT.vFa);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acUe, Integer.valueOf(this.wZT.ZgJ));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acUg, this.wZT.wul);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acUh, this.wZT.ZgI);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acUi, this.wZT.OhN);
      params = new ArrayList();
      Iterator localIterator = this.wZT.ZgH.iterator();
      while (localIterator.hasNext()) {
        params.add(String.valueOf(((Integer)localIterator.next()).intValue()));
      }
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acUf, Util.listToString(params, ","));
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(724L, 2L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      }
      AppMethodBeat.o(63896);
      return;
      if (this.oaK) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(724L, 4L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(724L, 3L, 1L, false);
      }
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(63895);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(63895);
    return i;
  }
  
  protected final boolean drU()
  {
    return false;
  }
  
  public final int getType()
  {
    return 1323;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.b
 * JD-Core Version:    0.7.0.1
 */