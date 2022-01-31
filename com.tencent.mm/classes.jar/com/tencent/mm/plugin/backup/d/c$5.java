package com.tencent.mm.plugin.backup.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.g.a;
import com.tencent.mm.plugin.backup.g.k;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class c$5
  implements f
{
  c$5(c paramc) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(17250);
    c.access$202(true);
    h.qsU.idkeyStat(485L, 42L, 1L, false);
    h.qsU.e(11787, new Object[] { Integer.valueOf(0) });
    com.tencent.mm.plugin.backup.g.b.b(1, c.e(this.jBL));
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth failed");
      b.aTr().aSL().jyN = -5;
      this.jBL.rf(-5);
      this.jBL.rj(3);
      AppMethodBeat.o(17250);
      return;
    }
    ab.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth success");
    paramString = (a)paramm;
    if (paramString.jEY.Version < com.tencent.mm.plugin.backup.b.c.jyx)
    {
      ab.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start old move, version:%d", new Object[] { Integer.valueOf(paramString.jEY.Version) });
      h.qsU.idkeyStat(485L, 104L, 1L, false);
      b.aTr().aSL().jyN = -12;
      this.jBL.rf(-12);
      AppMethodBeat.o(17250);
      return;
    }
    paramInt1 = paramString.jEY.jKs;
    paramm = this.jBL;
    boolean bool;
    if ((paramString.jEY.jKt & com.tencent.mm.plugin.backup.b.c.jyB) == 0)
    {
      bool = false;
      c.a(paramm, bool);
      ab.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start new move, version:%d, type:%d, isServerSupportKv:%b", new Object[] { Integer.valueOf(paramString.jEY.Version), Integer.valueOf(paramInt1), Boolean.valueOf(c.f(this.jBL)) });
      if ((paramInt1 != com.tencent.mm.plugin.backup.b.c.jyz) || (!c.aTw())) {
        break label377;
      }
      c.b(this.jBL, true);
      ab.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Resume Move!!!.");
    }
    for (;;)
    {
      c.g(this.jBL);
      com.tencent.mm.plugin.backup.g.b.a(3, c.h(this.jBL));
      new k(b.aTr().jyF).aUv();
      b.aTr().aSL().jyN = 22;
      this.jBL.rf(22);
      AppMethodBeat.o(17250);
      return;
      bool = true;
      break;
      label377:
      this.jBL.aTx();
      c.b(this.jBL, false);
      ab.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Normal move.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.c.5
 * JD-Core Version:    0.7.0.1
 */