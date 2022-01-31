package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.i.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class e$3
  implements b.d
{
  e$3(e parame) {}
  
  public final void a(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i;
    if (paramArrayOfByte == null)
    {
      i = -1;
      y.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify isLocal[%b], type[%d], seq[%d], buf[%d], isBackupFinish[%b]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Boolean.valueOf(e.access$300()) });
      if ((!paramBoolean) || (paramArrayOfByte == null)) {
        break label456;
      }
      if (10011 == paramInt1)
      {
        paramInt1 = b.auw().atn().hFu;
        y.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify local disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramInt1) });
        switch (paramInt1)
        {
        }
      }
    }
    for (;;)
    {
      return;
      i = paramArrayOfByte.length;
      break;
      b.auw().atT().stop();
      b.auw().atn().hFu = -100;
      this.hKW.nD(-100);
      return;
      b.auw().atT().stop();
      return;
      b.auw().atT().stop();
      b.auw().atn().hFu = -100;
      this.hKW.nD(-100);
      return;
      if ((b.auw().aux().hKB) && (!e.access$300()))
      {
        paramInt1 = com.tencent.mm.plugin.backup.g.b.auS();
        switch (paramInt1)
        {
        default: 
          return;
        case 0: 
        case 2: 
          y.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify startBackupReconnectHandler, reconnectState[%d]", new Object[] { Integer.valueOf(paramInt1) });
          this.hKW.nC(19);
          e.c(this.hKW);
          com.tencent.mm.plugin.backup.g.b.a(b.auw().aux().hKG);
          return;
        }
        y.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify already start reconnect, state[%d]", new Object[] { Integer.valueOf(paramInt1) });
        return;
      }
      y.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify not support reconnect, disconnect");
      this.hKW.cancel(true);
      b.auw().atT().stop();
      b.auw().atn().hFu = -4;
      this.hKW.nD(-4);
      h.nFQ.a(400L, 9L, 1L, false);
      this.hKW.nC(3);
      return;
      this.hKW.cancel(true);
      return;
      label456:
      if ((1 != b.auw().aux().hKx) && (3 != b.auw().aux().hKx)) {
        continue;
      }
      if (paramInt1 == 10)
      {
        localObject = new f();
        try
        {
          ((f)localObject).aH(paramArrayOfByte);
          y.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive heartbeatResp, ack[%d]", new Object[] { Long.valueOf(((f)localObject).hMb) });
          return;
        }
        catch (Exception paramArrayOfByte)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.BackupPcServer", paramArrayOfByte, "onBackupPcServerNotify buf to BackupHeartBeatResponse error.", new Object[0]);
          }
        }
      }
      if (paramInt1 == 5)
      {
        y.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive cancelReq");
        this.hKW.cancel(true);
        b.auw().atn().hFu = -100;
        this.hKW.nD(-100);
        h.nFQ.a(400L, 51L, 1L, false);
        this.hKW.nC(5);
        return;
      }
      if (paramInt1 == 18)
      {
        localObject = new com.tencent.mm.plugin.backup.i.c();
        try
        {
          ((com.tencent.mm.plugin.backup.i.c)localObject).aH(paramArrayOfByte);
          y.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandResp, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.c)localObject).hPE) });
          if (((com.tencent.mm.plugin.backup.i.c)localObject).hPE != 9) {
            continue;
          }
          paramInt1 = com.tencent.mm.plugin.backup.g.b.auS();
          if (paramInt1 == 1)
          {
            com.tencent.mm.plugin.backup.g.b.nH(2);
            y.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect success, start resendSceneMap");
            this.hKW.nC(20);
            com.tencent.mm.plugin.backup.g.b.auR();
            b.auw().atn().hFu = 14;
            this.hKW.nD(14);
            com.tencent.mm.plugin.backup.g.b.a(new e.3.1(this));
            return;
          }
        }
        catch (Exception paramArrayOfByte)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.BackupPcServer", paramArrayOfByte, "onBackupPcServerNotify buf to BackupCommandResponse error.", new Object[0]);
          }
          y.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect is started, ignore. state[%d]", new Object[] { Integer.valueOf(paramInt1) });
          return;
        }
      }
      if (paramInt1 != 17) {
        continue;
      }
      Object localObject = new com.tencent.mm.plugin.backup.i.b();
      try
      {
        ((com.tencent.mm.plugin.backup.i.b)localObject).aH(paramArrayOfByte);
        y.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandReq, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.b)localObject).hPE) });
        if (((com.tencent.mm.plugin.backup.i.b)localObject).hPE != 10) {
          continue;
        }
        paramInt1 = b.auw().atn().hFu;
        y.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify pc request disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramInt1) });
        if ((paramInt1 != 12) && (paramInt1 != 14)) {
          continue;
        }
        this.hKW.cancel(true);
        b.auw().atT().stop();
        b.auw().atn().hFu = -4;
        this.hKW.nD(-4);
        h.nFQ.a(400L, 51L, 1L, false);
        this.hKW.nC(5);
        long l = 0L;
        if (e.b(this.hKW).hGg != 0L) {
          l = bk.co(e.b(this.hKW).hGg);
        }
        h.nFQ.f(13737, new Object[] { Integer.valueOf(3), Long.valueOf(e.b(this.hKW).atB()), Long.valueOf(l / 1000L), Integer.valueOf(1) });
        y.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify transfer disconnect, backupDataSize[%d kb], backupCostTime[%d s]", new Object[] { Long.valueOf(e.b(this.hKW).atB()), Long.valueOf(l / 1000L) });
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.BackupPcServer", paramArrayOfByte, "onBackupPcServerNotify buf to BackupCommandRequest error.", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.e.3
 * JD-Core Version:    0.7.0.1
 */