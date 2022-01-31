package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.nq;
import com.tencent.mm.protocal.c.nr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends a
{
  private final String TAG = "MicroMsg.NetSceneQrRewardSetCode";
  private b dmK;
  private f dmL;
  public nr iIg;
  
  public g(LinkedList<Integer> paramLinkedList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new nq();
    ((b.a)localObject).ecI = new nr();
    ((b.a)localObject).ecG = 1562;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/setrewardqrcode";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (nq)this.dmK.ecE.ecN;
    ((nq)localObject).sKI = paramLinkedList;
    ((nq)localObject).desc = paramString;
    ((nq)localObject).sLj = paramBoolean1;
    ((nq)localObject).sLk = paramBoolean2;
    y.i("MicroMsg.NetSceneQrRewardSetCode", "desc: %s, flag: %s, default: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneQrRewardSetCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.iIg = ((nr)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneQrRewardSetCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.iIg.iHq), this.iIg.iHr });
    if ((!this.iHX) && (this.iIg.iHq != 0)) {
      this.iHY = true;
    }
    if ((!this.iHX) && (!this.iHY))
    {
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uyb, Integer.valueOf(this.iIg.sKL));
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uyc, Integer.valueOf(this.iIg.sKH));
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uye, this.iIg.desc);
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uyk, this.iIg.nxM);
      paramq = new ArrayList();
      Iterator localIterator = this.iIg.sKI.iterator();
      while (localIterator.hasNext()) {
        paramq.add(String.valueOf(((Integer)localIterator.next()).intValue()));
      }
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uyh, bk.c(paramq, ","));
      h.nFQ.a(724L, 5L, 1L, false);
    }
    for (;;)
    {
      if (this.dmL != null) {
        this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
      }
      return;
      if (this.iHX) {
        h.nFQ.a(724L, 7L, 1L, false);
      } else {
        h.nFQ.a(724L, 6L, 1L, false);
      }
    }
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