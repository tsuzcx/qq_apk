package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.wa;
import com.tencent.mm.protocal.protobuf.wb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends a
{
  private final String TAG;
  private i callback;
  public wb qxA;
  public boolean qxB;
  private d rr;
  
  public b(boolean paramBoolean)
  {
    AppMethodBeat.i(63894);
    this.TAG = "MicroMsg.NetSceneQrRewardGetCode";
    d.a locala = new d.a();
    locala.iLN = new wa();
    locala.iLO = new wb();
    locala.funcId = 1323;
    locala.uri = "/cgi-bin/mmpay-bin/getrewardqrcode";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((wa)this.rr.iLK.iLR).Lhj = paramBoolean;
    this.qxB = paramBoolean;
    AppMethodBeat.o(63894);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(63896);
    Log.i("MicroMsg.NetSceneQrRewardGetCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.qxA = ((wb)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneQrRewardGetCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.qxA.dDN), this.qxA.qwn });
    if ((!this.qxx) && (this.qxA.dDN != 0)) {
      this.qxy = true;
    }
    if ((!this.qxx) && (!this.qxy))
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oej, Integer.valueOf(this.qxA.Lhq));
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oek, Integer.valueOf(this.qxA.Lhm));
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oem, this.qxA.desc);
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oel, this.qxA.pqv);
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oeo, Integer.valueOf(this.qxA.Lhp));
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oeq, this.qxA.pTK);
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oer, this.qxA.Lho);
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oes, this.qxA.Cog);
      params = new ArrayList();
      Iterator localIterator = this.qxA.Lhn.iterator();
      while (localIterator.hasNext()) {
        params.add(String.valueOf(((Integer)localIterator.next()).intValue()));
      }
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oep, Util.listToString(params, ","));
      h.CyF.idkeyStat(724L, 2L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      }
      AppMethodBeat.o(63896);
      return;
      if (this.qxx) {
        h.CyF.idkeyStat(724L, 4L, 1L, false);
      } else {
        h.CyF.idkeyStat(724L, 3L, 1L, false);
      }
    }
  }
  
  protected final boolean czP()
  {
    return false;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(63895);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(63895);
    return i;
  }
  
  public final int getType()
  {
    return 1323;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.b
 * JD-Core Version:    0.7.0.1
 */