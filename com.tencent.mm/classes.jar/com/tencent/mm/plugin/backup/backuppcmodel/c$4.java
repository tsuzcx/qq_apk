package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Arrays;
import java.util.LinkedList;

final class c$4
  implements b.d
{
  c$4(c paramc) {}
  
  public final void a(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(17502);
    int i;
    if (paramArrayOfByte == null)
    {
      i = -1;
      ab.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify isLocal[%b], type[%d], seq[%d], buf[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if ((!paramBoolean) || (paramArrayOfByte == null)) {
        break label251;
      }
      if (10011 == paramInt1)
      {
        paramInt1 = b.aTX().aSL().jyN;
        ab.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify local disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramInt1) });
        switch (paramInt1)
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(17502);
      return;
      i = paramArrayOfByte.length;
      break;
      if (!c.access$200())
      {
        if (c.c(this.jEk) != null)
        {
          ab.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify stop backupConnectTimerHandler.");
          c.c(this.jEk).stopTimer();
        }
        c.d(this.jEk);
        AppMethodBeat.o(17502);
        return;
      }
      b.aTX().aTs().stop();
      b.aTX().aSL().jyN = -4;
      b.aTX().aTZ().rl(-4);
      AppMethodBeat.o(17502);
      return;
      b.aTX().aTs().stop();
    }
    label251:
    com.tencent.mm.plugin.backup.i.b localb;
    if (paramInt1 == 17) {
      localb = new com.tencent.mm.plugin.backup.i.b();
    }
    for (;;)
    {
      try
      {
        localb.parseFrom(paramArrayOfByte);
        ab.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive commandReq, command[%d]", new Object[] { Integer.valueOf(localb.jJg) });
        i = localb.jJg;
        switch (i)
        {
        }
      }
      catch (Exception paramArrayOfByte)
      {
        ab.printErrStackTrace("MicroMsg.BackupPcProcessMgr", paramArrayOfByte, "onBackupPcProcessMgrNotify buf to BackupCommandRequest error.", new Object[0]);
        continue;
        aw.aaz();
        if (((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yEp, Boolean.FALSE)).booleanValue()) {
          continue;
        }
        ab.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not backuping, start new backup.");
        c.a(this.jEk, 5, paramInt2);
        continue;
        b.aTX();
        paramArrayOfByte = b.aSQ().getString("BACKUP_PC_CHOOSE_SESSION", null);
        if (paramArrayOfByte != null) {
          continue;
        }
        ab.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify sessionString is null, start new backup.");
        c.a(this.jEk, 5, paramInt2);
        continue;
        ab.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify start continue Backup.");
        h.qsU.idkeyStat(400L, 29L, 1L, false);
        this.jEk.jEa = 3;
        paramArrayOfByte = new LinkedList(Arrays.asList(g.cZ(paramArrayOfByte, ",")));
        b.aTX().aTZ().init();
        b.aTX().aTZ().G(paramArrayOfByte);
        c.dF(5, paramInt2);
        b.aTX().aTZ().aSJ();
        this.jEk.rq(6);
        paramArrayOfByte = b.aTX().aTZ();
        com.tencent.mm.plugin.backup.h.d.aUK().aUN();
        paramArrayOfByte.hJ(paramArrayOfByte.jBO.size());
        continue;
        c.b(this.jEk, 3, paramInt2);
        continue;
        aw.aaz();
        if (((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yEq, Boolean.FALSE)).booleanValue()) {
          continue;
        }
        ab.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not recovering, start new recover.");
        c.b(this.jEk, 7, paramInt2);
        continue;
        b.aTX().aUa();
        if (d.aTw()) {
          continue;
        }
        ab.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify MsgDataIdList not exist, start new recover.");
        c.b(this.jEk, 7, paramInt2);
        continue;
        ab.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify continue Recover.");
        h.qsU.idkeyStat(400L, 30L, 1L, false);
        this.jEk.jEa = 4;
        b.aTX().aUa().init();
        c.dF(7, paramInt2);
        b.aTX().aTZ().aSJ();
        this.jEk.rq(8);
        continue;
        AppMethodBeat.o(17502);
      }
      if (paramInt1 != 5) {
        continue;
      }
      ab.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive cancelReq");
      h.qsU.e(13737, new Object[] { Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(b.aTX().aTY().jEg) });
      b.aTX().aSL().jyN = -100;
      b.aTX().aTZ().rl(-100);
      AppMethodBeat.o(17502);
      return;
      c.a(this.jEk, 1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.c.4
 * JD-Core Version:    0.7.0.1
 */