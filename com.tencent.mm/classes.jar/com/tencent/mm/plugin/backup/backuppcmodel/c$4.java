package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
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
    if (paramArrayOfByte == null) {}
    for (int i = -1;; i = paramArrayOfByte.length)
    {
      y.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify isLocal[%b], type[%d], seq[%d], buf[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if ((!paramBoolean) || (paramArrayOfByte == null)) {
        break;
      }
      if (10011 == paramInt1)
      {
        paramInt1 = b.auw().atn().hFu;
        y.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify local disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramInt1) });
      }
      switch (paramInt1)
      {
      default: 
        return;
      }
    }
    if (!c.access$200())
    {
      if (c.c(this.hKH) != null)
      {
        y.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify stop backupConnectTimerHandler.");
        c.c(this.hKH).stopTimer();
      }
      c.d(this.hKH);
      return;
    }
    b.auw().atT().stop();
    b.auw().atn().hFu = -4;
    b.auw().auy().nD(-4);
    return;
    b.auw().atT().stop();
    return;
    com.tencent.mm.plugin.backup.i.b localb;
    if (paramInt1 == 17) {
      localb = new com.tencent.mm.plugin.backup.i.b();
    }
    for (;;)
    {
      try
      {
        localb.aH(paramArrayOfByte);
        y.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive commandReq, command[%d]", new Object[] { Integer.valueOf(localb.hPE) });
        i = localb.hPE;
        switch (i)
        {
        }
      }
      catch (Exception paramArrayOfByte)
      {
        y.printErrStackTrace("MicroMsg.BackupPcProcessMgr", paramArrayOfByte, "onBackupPcProcessMgrNotify buf to BackupCommandRequest error.", new Object[0]);
        continue;
        au.Hx();
        if (((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.uum, Boolean.valueOf(false))).booleanValue()) {
          continue;
        }
        y.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not backuping, start new backup.");
        c.a(this.hKH, 5, paramInt2);
        continue;
        b.auw();
        paramArrayOfByte = b.ats().getString("BACKUP_PC_CHOOSE_SESSION", null);
        if (paramArrayOfByte != null) {
          continue;
        }
        y.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify sessionString is null, start new backup.");
        c.a(this.hKH, 5, paramInt2);
        continue;
        y.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify start continue Backup.");
        h.nFQ.a(400L, 29L, 1L, false);
        this.hKH.hKx = 3;
        paramArrayOfByte = new LinkedList(Arrays.asList(g.ci(paramArrayOfByte, ",")));
        b.auw().auy().init();
        b.auw().auy().F(paramArrayOfByte);
        c.cp(5, paramInt2);
        b.auw().auy().atl();
        this.hKH.nB(6);
        paramArrayOfByte = b.auw().auy();
        com.tencent.mm.plugin.backup.h.d.avi().avl();
        paramArrayOfByte.cH(paramArrayOfByte.hIq.size());
        continue;
        c.b(this.hKH, 3, paramInt2);
        continue;
        au.Hx();
        if (((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.uun, Boolean.valueOf(false))).booleanValue()) {
          continue;
        }
        y.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not recovering, start new recover.");
        c.b(this.hKH, 7, paramInt2);
        continue;
        b.auw().auz();
        if (d.atX()) {
          continue;
        }
        y.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify MsgDataIdList not exist, start new recover.");
        c.b(this.hKH, 7, paramInt2);
        continue;
        y.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify continue Recover.");
        h.nFQ.a(400L, 30L, 1L, false);
        this.hKH.hKx = 4;
        b.auw().auz().init();
        c.cp(7, paramInt2);
        b.auw().auy().atl();
        this.hKH.nB(8);
        continue;
      }
      if (paramInt1 != 5) {
        break;
      }
      y.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive cancelReq");
      h.nFQ.f(13737, new Object[] { Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(b.auw().aux().hKD) });
      b.auw().atn().hFu = -100;
      b.auw().auy().nD(-100);
      return;
      c.a(this.hKH, 1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.c.4
 * JD-Core Version:    0.7.0.1
 */