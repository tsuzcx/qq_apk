package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.g.a;
import com.tencent.mm.plugin.backup.g.k;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class c$5
  implements f
{
  c$5(c paramc) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    c.bb(true);
    h.nFQ.a(485L, 42L, 1L, false);
    h.nFQ.f(11787, new Object[] { Integer.valueOf(0) });
    com.tencent.mm.plugin.backup.g.b.b(1, c.e(this.hIn));
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth failed");
      b.atS().atn().hFu = -5;
      this.hIn.nt(-5);
      this.hIn.nx(3);
      return;
    }
    y.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth success");
    paramString = (a)paramm;
    if (paramString.hLv.hQQ < com.tencent.mm.plugin.backup.b.c.hFe)
    {
      y.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start old move, version:%d", new Object[] { Integer.valueOf(paramString.hLv.hQQ) });
      h.nFQ.a(485L, 104L, 1L, false);
      b.atS().atn().hFu = -12;
      this.hIn.nt(-12);
      return;
    }
    paramInt1 = paramString.hLv.hQR;
    paramm = this.hIn;
    boolean bool;
    if ((paramString.hLv.hQS & com.tencent.mm.plugin.backup.b.c.hFi) == 0)
    {
      bool = false;
      c.a(paramm, bool);
      y.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start new move, version:%d, type:%d, isServerSupportKv:%b", new Object[] { Integer.valueOf(paramString.hLv.hQQ), Integer.valueOf(paramInt1), Boolean.valueOf(c.f(this.hIn)) });
      if ((paramInt1 != com.tencent.mm.plugin.backup.b.c.hFg) || (!c.atX())) {
        break label353;
      }
      c.b(this.hIn, true);
      y.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Resume Move!!!.");
    }
    for (;;)
    {
      c.g(this.hIn);
      com.tencent.mm.plugin.backup.g.b.a(3, c.h(this.hIn));
      new k(b.atS().hFm).auT();
      b.atS().atn().hFu = 22;
      this.hIn.nt(22);
      return;
      bool = true;
      break;
      label353:
      this.hIn.atY();
      c.b(this.hIn, false);
      y.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Normal move.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.c.5
 * JD-Core Version:    0.7.0.1
 */