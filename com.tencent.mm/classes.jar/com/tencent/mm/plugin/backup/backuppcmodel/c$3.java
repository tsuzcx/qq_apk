package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.g.a;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class c$3
  implements f
{
  c$3(c paramc) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(17501);
    c.aMp();
    h.qsU.e(13736, new Object[] { Integer.valueOf(0), c.e(this.jEk), g.dx(ah.getContext()), Integer.valueOf(0), Integer.valueOf(b.aTX().aTY().jEg) });
    com.tencent.mm.plugin.backup.g.b.b(1, c.f(this.jEk));
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth failed, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      switch (paramInt2)
      {
      case -2: 
      default: 
        h.qsU.idkeyStat(400L, 116L, 1L, false);
      }
      for (;;)
      {
        h.qsU.e(13737, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(c.g(this.jEk)) });
        b.aTX().aSL().jyN = -5;
        b.aTX().aTZ().rl(-5);
        AppMethodBeat.o(17501);
        return;
        h.qsU.idkeyStat(400L, 114L, 1L, false);
        continue;
        h.qsU.idkeyStat(400L, 115L, 1L, false);
      }
    }
    paramString = (a)paramm;
    boolean bool1;
    boolean bool2;
    label319:
    boolean bool3;
    if ((paramString.jEY.jKt & com.tencent.mm.plugin.backup.b.c.jyC) == 0)
    {
      bool1 = false;
      if ((paramString.jEY.jKt & com.tencent.mm.plugin.backup.b.c.jyD) != 0) {
        break label436;
      }
      bool2 = false;
      if ((paramString.jEY.jKt & com.tencent.mm.plugin.backup.b.c.jyE) != 0) {
        break label442;
      }
      bool3 = false;
      label336:
      ab.i("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth success, pcSupportTimeSelect[%b], pcSupportQuickBackup[%b], pcSupportReconnect[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if (!bool3) {
        break label466;
      }
      if (paramString.jEY.jKv != null) {
        break label448;
      }
      paramString = null;
      label388:
      if (paramString == null) {
        break label459;
      }
      this.jEk.a(true, paramString);
    }
    for (;;)
    {
      b.aTX().aTZ().jEv = bool1;
      b.aTX().aTZ().jEw = bool2;
      AppMethodBeat.o(17501);
      return;
      bool1 = true;
      break;
      label436:
      bool2 = true;
      break label319;
      label442:
      bool3 = true;
      break label336;
      label448:
      paramString = paramString.jEY.jKv;
      break label388;
      label459:
      ab.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd pcSupportReconnect but token is null!");
      label466:
      this.jEk.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.c.3
 * JD-Core Version:    0.7.0.1
 */