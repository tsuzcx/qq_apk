package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.vm;
import com.tencent.mm.protocal.protobuf.vn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends a
{
  private final String TAG;
  private f callback;
  public vn piv;
  private b rr;
  
  public g(LinkedList<Integer> paramLinkedList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(63908);
    this.TAG = "MicroMsg.NetSceneQrRewardSetCode";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new vm();
    ((b.a)localObject).hQG = new vn();
    ((b.a)localObject).funcId = 1562;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/setrewardqrcode";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (vm)this.rr.hQD.hQJ;
    ((vm)localObject).GmJ = paramLinkedList;
    ((vm)localObject).desc = paramString;
    ((vm)localObject).Gnn = paramBoolean1;
    ((vm)localObject).Gno = paramBoolean2;
    ae.i("MicroMsg.NetSceneQrRewardSetCode", "desc: %s, flag: %s, default: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    AppMethodBeat.o(63908);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63910);
    ae.i("MicroMsg.NetSceneQrRewardSetCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.piv = ((vn)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneQrRewardSetCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.piv.dmy), this.piv.phe });
    if ((!this.pil) && (this.piv.dmy != 0)) {
      this.pim = true;
    }
    if ((!this.pil) && (!this.pim))
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVR, Integer.valueOf(this.piv.GmM));
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVS, Integer.valueOf(this.piv.GmI));
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVU, this.piv.desc);
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWa, this.piv.ynq);
      paramq = new ArrayList();
      Iterator localIterator = this.piv.GmJ.iterator();
      while (localIterator.hasNext()) {
        paramq.add(String.valueOf(((Integer)localIterator.next()).intValue()));
      }
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVX, bu.m(paramq, ","));
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(724L, 5L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      }
      AppMethodBeat.o(63910);
      return;
      if (this.pil) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(724L, 7L, 1L, false);
      } else {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(724L, 6L, 1L, false);
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(63909);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
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