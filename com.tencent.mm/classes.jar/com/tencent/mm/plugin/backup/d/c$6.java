package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.ah.f;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.k;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class c$6
  implements f
{
  c$6(c paramc) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    com.tencent.mm.plugin.backup.g.b.b(3, c.h(this.hIn));
    y.i("MicroMsg.BackupMoveRecoverServer", "backupmove receive startrequest response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.BackupMoveRecoverServer", "start request failed, errMsg:" + paramString);
      b.atS().atn().hFu = -5;
      this.hIn.nt(-5);
      return;
    }
    paramString = (k)paramm;
    paramm = paramString.hME;
    if (!b.atS().hFm.equals(paramm.ID))
    {
      y.e("MicroMsg.BackupMoveRecoverServer", "start response not the same id");
      b.atS().atn().hFu = -5;
      this.hIn.nt(-5);
      return;
    }
    b.atS().atn().hFA = paramm.hQi;
    this.hIn.bwK = paramString.hME.hQl.hQb;
    label324:
    label349:
    label369:
    long l;
    if (paramString.hME.hQl.hQe.toLowerCase().contains("ios"))
    {
      c.a(this.hIn, 1);
      c.a(this.hIn, paramString.hME.hQp);
      c.b(this.hIn, paramString.hME.hQr);
      y.i("MicroMsg.BackupMoveRecoverServer", "move recover totalCount[%d], totalSize[%d], and wait old mobile's pushData", new Object[] { Long.valueOf(paramString.hME.hQo), Long.valueOf(paramString.hME.hQp) });
      if ((c.i(this.hIn)) && (c.f(this.hIn)))
      {
        paramm = h.nFQ;
        if ((!c.j(this.hIn)) && (c.k(this.hIn) != 1)) {
          break label580;
        }
        paramInt1 = 66;
        paramm.a(485L, paramInt1, 1L, false);
      }
      if (paramString.hME.hQn != 3) {
        break label586;
      }
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label591;
      }
      c.c(this.hIn, true);
      y.i("MicroMsg.BackupMoveRecoverServer", "isQuickBackup!!!");
      paramString = new PLong();
      paramm = new PLong();
      au.Hx();
      g.a(paramString, paramm, com.tencent.mm.model.c.FU());
      l = c.l(this.hIn);
      if (c.l(this.hIn) * 0.1D <= 524288000.0D) {
        break label603;
      }
    }
    label580:
    label586:
    label591:
    label603:
    for (double d = 524288000.0D;; d = c.l(this.hIn) * 0.1D)
    {
      l = d + l;
      this.hIn.hIj = l;
      if (paramm.value >= l) {
        break label620;
      }
      y.e("MicroMsg.BackupMoveRecoverServer", "startRequestNotify Not Enough Space:%d < dataSize:%d, dataSize:%d", new Object[] { Long.valueOf(paramm.value), Long.valueOf(l), Long.valueOf(c.l(this.hIn)) });
      h.nFQ.f(11787, new Object[] { Integer.valueOf(5) });
      b.atS().atT().stop();
      b.atS().atn().hFu = -13;
      this.hIn.nt(-13);
      h.nFQ.a(485L, 5L, 1L, false);
      return;
      c.a(this.hIn, 2);
      break;
      paramInt1 = 65;
      break label324;
      paramInt1 = 0;
      break label349;
      c.c(this.hIn, false);
      break label369;
    }
    label620:
    c.b(this.hIn, bk.UY());
    com.tencent.mm.plugin.backup.g.b.auL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.c.6
 * JD-Core Version:    0.7.0.1
 */