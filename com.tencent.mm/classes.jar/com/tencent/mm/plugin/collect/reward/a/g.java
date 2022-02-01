package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.tf;
import com.tencent.mm.protocal.protobuf.tg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends a
{
  private final String TAG;
  private com.tencent.mm.al.g callback;
  public tg nUZ;
  private b rr;
  
  public g(LinkedList<Integer> paramLinkedList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(63908);
    this.TAG = "MicroMsg.NetSceneQrRewardSetCode";
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new tf();
    ((b.a)localObject).gUV = new tg();
    ((b.a)localObject).funcId = 1562;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/setrewardqrcode";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (tf)this.rr.gUS.gUX;
    ((tf)localObject).CUr = paramLinkedList;
    ((tf)localObject).desc = paramString;
    ((tf)localObject).CUV = paramBoolean1;
    ((tf)localObject).CUW = paramBoolean2;
    ad.i("MicroMsg.NetSceneQrRewardSetCode", "desc: %s, flag: %s, default: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    AppMethodBeat.o(63908);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63910);
    ad.i("MicroMsg.NetSceneQrRewardSetCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.nUZ = ((tg)((b)paramq).gUT.gUX);
    ad.i("MicroMsg.NetSceneQrRewardSetCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.nUZ.dcG), this.nUZ.nTK });
    if ((!this.nUQ) && (this.nUZ.dcG != 0)) {
      this.nUR = true;
    }
    if ((!this.nUQ) && (!this.nUR))
    {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Frh, Integer.valueOf(this.nUZ.CUu));
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fri, Integer.valueOf(this.nUZ.CUq));
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Frk, this.nUZ.desc);
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Frq, this.nUZ.vzM);
      paramq = new ArrayList();
      Iterator localIterator = this.nUZ.CUr.iterator();
      while (localIterator.hasNext()) {
        paramq.add(String.valueOf(((Integer)localIterator.next()).intValue()));
      }
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Frn, bt.n(paramq, ","));
      h.vKh.idkeyStat(724L, 5L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      }
      AppMethodBeat.o(63910);
      return;
      if (this.nUQ) {
        h.vKh.idkeyStat(724L, 7L, 1L, false);
      } else {
        h.vKh.idkeyStat(724L, 6L, 1L, false);
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(63909);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(63909);
    return i;
  }
  
  public final int getType()
  {
    return 1562;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.a.g
 * JD-Core Version:    0.7.0.1
 */