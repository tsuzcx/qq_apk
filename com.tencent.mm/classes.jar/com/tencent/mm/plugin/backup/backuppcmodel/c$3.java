package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.g.a;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class c$3
  implements f
{
  c$3(c paramc) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    c.ape();
    h.nFQ.f(13736, new Object[] { Integer.valueOf(0), c.e(this.hKH), g.cM(ae.getContext()), Integer.valueOf(0), Integer.valueOf(b.auw().aux().hKD) });
    com.tencent.mm.plugin.backup.g.b.b(1, c.f(this.hKH));
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth failed, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      switch (paramInt2)
      {
      case -2: 
      default: 
        h.nFQ.a(400L, 116L, 1L, false);
      }
      for (;;)
      {
        h.nFQ.f(13737, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(c.g(this.hKH)) });
        b.auw().atn().hFu = -5;
        b.auw().auy().nD(-5);
        return;
        h.nFQ.a(400L, 114L, 1L, false);
        continue;
        h.nFQ.a(400L, 115L, 1L, false);
      }
    }
    paramString = (a)paramm;
    boolean bool1;
    boolean bool2;
    label305:
    boolean bool3;
    if ((paramString.hLv.hQS & com.tencent.mm.plugin.backup.b.c.hFj) == 0)
    {
      bool1 = false;
      if ((paramString.hLv.hQS & com.tencent.mm.plugin.backup.b.c.hFk) != 0) {
        break label416;
      }
      bool2 = false;
      if ((paramString.hLv.hQS & com.tencent.mm.plugin.backup.b.c.hFl) != 0) {
        break label422;
      }
      bool3 = false;
      label322:
      y.i("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth success, pcSupportTimeSelect[%b], pcSupportQuickBackup[%b], pcSupportReconnect[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if (!bool3) {
        break label446;
      }
      if (paramString.hLv.hQU != null) {
        break label428;
      }
      paramString = null;
      label374:
      if (paramString == null) {
        break label439;
      }
      this.hKH.a(true, paramString);
    }
    for (;;)
    {
      b.auw().auy().hKS = bool1;
      b.auw().auy().hKT = bool2;
      return;
      bool1 = true;
      break;
      label416:
      bool2 = true;
      break label305;
      label422:
      bool3 = true;
      break label322;
      label428:
      paramString = paramString.hLv.hQU;
      break label374;
      label439:
      y.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd pcSupportReconnect but token is null!");
      label446:
      this.hKH.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.c.3
 * JD-Core Version:    0.7.0.1
 */