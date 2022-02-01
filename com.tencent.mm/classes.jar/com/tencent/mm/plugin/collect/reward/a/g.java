package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.wy;
import com.tencent.mm.protocal.protobuf.wz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends a
{
  private final String TAG;
  private i callback;
  private d rr;
  public wz tWG;
  
  public g(LinkedList<Integer> paramLinkedList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(63908);
    this.TAG = "MicroMsg.NetSceneQrRewardSetCode";
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new wy();
    ((d.a)localObject).lBV = new wz();
    ((d.a)localObject).funcId = 1562;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/setrewardqrcode";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (wy)d.b.b(this.rr.lBR);
    ((wy)localObject).SiB = paramLinkedList;
    ((wy)localObject).desc = paramString;
    ((wy)localObject).Sjf = paramBoolean1;
    ((wy)localObject).Sjg = paramBoolean2;
    Log.i("MicroMsg.NetSceneQrRewardSetCode", "desc: %s, flag: %s, default: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    AppMethodBeat.o(63908);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(63910);
    Log.i("MicroMsg.NetSceneQrRewardSetCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.tWG = ((wz)d.c.b(((d)params).lBS));
    Log.i("MicroMsg.NetSceneQrRewardSetCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.tWG.fwx), this.tWG.tVo });
    if ((!this.tWx) && (this.tWG.fwx != 0)) {
      this.tWy = true;
    }
    if ((!this.tWx) && (!this.tWy))
    {
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vsu, Integer.valueOf(this.tWG.SiE));
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vsv, Integer.valueOf(this.tWG.SiA));
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vsx, this.tWG.desc);
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VsD, this.tWG.IkZ);
      params = new ArrayList();
      Iterator localIterator = this.tWG.SiB.iterator();
      while (localIterator.hasNext()) {
        params.add(String.valueOf(((Integer)localIterator.next()).intValue()));
      }
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VsA, Util.listToString(params, ","));
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(724L, 5L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      }
      AppMethodBeat.o(63910);
      return;
      if (this.tWx) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(724L, 7L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(724L, 6L, 1L, false);
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(63909);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(63909);
    return i;
  }
  
  public final int getType()
  {
    return 1562;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.g
 * JD-Core Version:    0.7.0.1
 */