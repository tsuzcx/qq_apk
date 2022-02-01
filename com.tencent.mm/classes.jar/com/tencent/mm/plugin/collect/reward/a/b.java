package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.protocal.protobuf.wd;
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
  private d rr;
  public wd tWA;
  public boolean tWB;
  
  public b(boolean paramBoolean)
  {
    AppMethodBeat.i(63894);
    this.TAG = "MicroMsg.NetSceneQrRewardGetCode";
    d.a locala = new d.a();
    locala.lBU = new wc();
    locala.lBV = new wd();
    locala.funcId = 1323;
    locala.uri = "/cgi-bin/mmpay-bin/getrewardqrcode";
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    ((wc)d.b.b(this.rr.lBR)).Six = paramBoolean;
    this.tWB = paramBoolean;
    AppMethodBeat.o(63894);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(63896);
    Log.i("MicroMsg.NetSceneQrRewardGetCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.tWA = ((wd)d.c.b(((d)params).lBS));
    Log.i("MicroMsg.NetSceneQrRewardGetCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.tWA.fwx), this.tWA.tVo });
    if ((!this.tWx) && (this.tWA.fwx != 0)) {
      this.tWy = true;
    }
    if ((!this.tWx) && (!this.tWy))
    {
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vsu, Integer.valueOf(this.tWA.SiE));
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vsv, Integer.valueOf(this.tWA.SiA));
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vsx, this.tWA.desc);
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vsw, this.tWA.szv);
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vsz, Integer.valueOf(this.tWA.SiD));
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VsB, this.tWA.tpM);
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VsC, this.tWA.SiC);
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VsD, this.tWA.IkZ);
      params = new ArrayList();
      Iterator localIterator = this.tWA.SiB.iterator();
      while (localIterator.hasNext()) {
        params.add(String.valueOf(((Integer)localIterator.next()).intValue()));
      }
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VsA, Util.listToString(params, ","));
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(724L, 2L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      }
      AppMethodBeat.o(63896);
      return;
      if (this.tWx) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(724L, 4L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(724L, 3L, 1L, false);
      }
    }
  }
  
  protected final boolean cOp()
  {
    return false;
  }
  
  public final int doScene(g paramg, i parami)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.b
 * JD-Core Version:    0.7.0.1
 */