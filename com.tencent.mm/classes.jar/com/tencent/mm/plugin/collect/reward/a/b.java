package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.mz;
import com.tencent.mm.protocal.c.na;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends a
{
  private final String TAG = "MicroMsg.NetSceneQrRewardGetCode";
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  public na iIa;
  public boolean iIb;
  
  public b(boolean paramBoolean)
  {
    b.a locala = new b.a();
    locala.ecH = new mz();
    locala.ecI = new na();
    locala.ecG = 1323;
    locala.uri = "/cgi-bin/mmpay-bin/getrewardqrcode";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((mz)this.dmK.ecE.ecN).sKE = paramBoolean;
    this.iIb = paramBoolean;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  protected final boolean aED()
  {
    return false;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneQrRewardGetCode", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.iIa = ((na)((com.tencent.mm.ah.b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneQrRewardGetCode", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.iIa.iHq), this.iIa.iHr });
    if ((!this.iHX) && (this.iIa.iHq != 0)) {
      this.iHY = true;
    }
    if ((!this.iHX) && (!this.iHY))
    {
      g.DP().Dz().c(ac.a.uyb, Integer.valueOf(this.iIa.sKL));
      g.DP().Dz().c(ac.a.uyc, Integer.valueOf(this.iIa.sKH));
      g.DP().Dz().c(ac.a.uye, this.iIa.desc);
      g.DP().Dz().c(ac.a.uyd, this.iIa.iet);
      g.DP().Dz().c(ac.a.uyg, Integer.valueOf(this.iIa.sKK));
      g.DP().Dz().c(ac.a.uyi, this.iIa.imZ);
      g.DP().Dz().c(ac.a.uyj, this.iIa.sKJ);
      g.DP().Dz().c(ac.a.uyk, this.iIa.nxM);
      paramq = new ArrayList();
      Iterator localIterator = this.iIa.sKI.iterator();
      while (localIterator.hasNext()) {
        paramq.add(String.valueOf(((Integer)localIterator.next()).intValue()));
      }
      g.DP().Dz().c(ac.a.uyh, bk.c(paramq, ","));
      h.nFQ.a(724L, 2L, 1L, false);
    }
    for (;;)
    {
      if (this.dmL != null) {
        this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
      }
      return;
      if (this.iHX) {
        h.nFQ.a(724L, 4L, 1L, false);
      } else {
        h.nFQ.a(724L, 3L, 1L, false);
      }
    }
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