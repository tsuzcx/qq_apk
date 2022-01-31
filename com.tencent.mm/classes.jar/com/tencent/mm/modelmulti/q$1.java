package com.tencent.mm.modelmulti;

import android.os.HandlerThread;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.azg;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.protocal.c.qw;
import com.tencent.mm.protocal.s.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.LinkedList;

final class q$1
  implements Runnable
{
  q$1(int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    q.access$000();
    q.mG(e.bkH + "/testaddmsg.txt");
    if ((q.Pq().size() <= 0) || (q.Pr().size() <= 0))
    {
      y.e("MicroMsg.TestSyncAddMsg", "syncAddMsg get source failed cmd:%d contact:%d", new Object[] { Integer.valueOf(q.Pr().size()), Integer.valueOf(q.Pq().size()) });
      return;
    }
    new am(au.DS().mnU.getLooper(), new am.a()
    {
      int eul = q.1.this.euj;
      
      public final boolean tC()
      {
        if (this.eul <= 0) {
          return false;
        }
        this.eul -= 1;
        s.b localb = new s.b();
        localb.sqj.sIl = new qw();
        int j = bk.fe(q.1.this.euk, 1);
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label337;
          }
          cd localcd = (cd)q.Pr().get(bk.fe(q.Pr().size() - 1, 0));
          localcd.svF = new bml().YI(((ad)q.Pq().get(bk.fe(q.Pq().size() - 1, 0))).field_username);
          localcd.mPL = ((int)bk.UX());
          localcd.ndp = Math.abs((int)bk.UY() % 10000000);
          try
          {
            Object localObject = new qv();
            ((qv)localObject).sOB = new bmk();
            ((qv)localObject).sOB.bs(localcd.toByteArray());
            ((qv)localObject).sOA = 5;
            localb.sqj.sIl.hPT.add(localObject);
            localObject = localb.sqj.sIl;
            ((qw)localObject).hPS += 1;
            y.d("MicroMsg.TestSyncAddMsg", "syncAddMsg  loop:%d cnt:[%d,%d] cmdList:%d id:%d u:%s", new Object[] { Integer.valueOf(this.eul), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(localb.sqj.sIl.hPT.size()), Long.valueOf(localcd.ndp), localcd.svF.tFO });
          }
          catch (Exception localException)
          {
            for (;;)
            {
              y.d("MicroMsg.TestSyncAddMsg", localException.getMessage());
              y.printErrStackTrace("MicroMsg.TestSyncAddMsg", localException, "", new Object[0]);
            }
          }
          i += 1;
        }
        label337:
        localb.sqj.sFD = 0;
        azg localazg = localb.sqj;
        au.Hx();
        localazg.sIi = aa.I(bk.ZM(bk.pm((String)c.Dz().get(8195, new byte[0]))));
        localb.sqj.sze = 0;
        localb.sqj.hQq = 0;
        n.Pm().a(localb, 0, bk.UX());
        return true;
      }
    }, true).S(3000L, 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelmulti.q.1
 * JD-Core Version:    0.7.0.1
 */