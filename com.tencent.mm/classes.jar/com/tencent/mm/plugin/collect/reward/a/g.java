package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.tp;
import com.tencent.mm.protocal.protobuf.tq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends a
{
  private final String TAG;
  private com.tencent.mm.ak.g callback;
  public tq oyu;
  private b rr;
  
  public g(LinkedList<Integer> paramLinkedList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(63908);
    this.TAG = "MicroMsg.NetSceneQrRewardSetCode";
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new tp();
    ((b.a)localObject).hvu = new tq();
    ((b.a)localObject).funcId = 1562;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/setrewardqrcode";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (tp)this.rr.hvr.hvw;
    ((tp)localObject).Enb = paramLinkedList;
    ((tp)localObject).desc = paramString;
    ((tp)localObject).EnF = paramBoolean1;
    ((tp)localObject).EnG = paramBoolean2;
    ac.i("MicroMsg.NetSceneQrRewardSetCode", "desc: %s, flag: %s, default: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    AppMethodBeat.o(63908);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63910);
    ac.i("MicroMsg.NetSceneQrRewardSetCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.oyu = ((tq)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneQrRewardSetCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.oyu.dae), this.oyu.oxf });
    if ((!this.oyl) && (this.oyu.dae != 0)) {
      this.oym = true;
    }
    if ((!this.oyl) && (!this.oym))
    {
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOX, Integer.valueOf(this.oyu.Ene));
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOY, Integer.valueOf(this.oyu.Ena));
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPa, this.oyu.desc);
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPg, this.oyu.wJR);
      paramq = new ArrayList();
      Iterator localIterator = this.oyu.Enb.iterator();
      while (localIterator.hasNext()) {
        paramq.add(String.valueOf(((Integer)localIterator.next()).intValue()));
      }
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPd, bs.n(paramq, ","));
      h.wUl.idkeyStat(724L, 5L, 1L, false);
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
      }
      AppMethodBeat.o(63910);
      return;
      if (this.oyl) {
        h.wUl.idkeyStat(724L, 7L, 1L, false);
      } else {
        h.wUl.idkeyStat(724L, 6L, 1L, false);
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
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