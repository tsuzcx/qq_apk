package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.i.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class e$3
  implements b.d
{
  e$3(e parame) {}
  
  public final void a(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(17546);
    int i;
    if (paramArrayOfByte == null)
    {
      i = -1;
      ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify isLocal[%b], type[%d], seq[%d], buf[%d], isBackupFinish[%b]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Boolean.valueOf(e.aTJ()) });
      if ((!paramBoolean) || (paramArrayOfByte == null)) {
        break label506;
      }
      if (10011 == paramInt1)
      {
        paramInt1 = b.aTX().aSL().jyN;
        ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify local disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramInt1) });
        switch (paramInt1)
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(17546);
      return;
      i = paramArrayOfByte.length;
      break;
      b.aTX().aTs().stop();
      b.aTX().aSL().jyN = -100;
      this.jEz.rl(-100);
      AppMethodBeat.o(17546);
      return;
      b.aTX().aTs().stop();
      AppMethodBeat.o(17546);
      return;
      b.aTX().aTs().stop();
      b.aTX().aSL().jyN = -100;
      this.jEz.rl(-100);
      AppMethodBeat.o(17546);
      return;
      if ((b.aTX().aTY().jEe) && (!e.aTJ()))
      {
        paramInt1 = com.tencent.mm.plugin.backup.g.b.aUu();
        switch (paramInt1)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(17546);
          return;
          ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify startBackupReconnectHandler, reconnectState[%d]", new Object[] { Integer.valueOf(paramInt1) });
          this.jEz.rr(19);
          e.c(this.jEz);
          com.tencent.mm.plugin.backup.g.b.a(b.aTX().aTY().jEj);
          AppMethodBeat.o(17546);
          return;
          ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify already start reconnect, state[%d]", new Object[] { Integer.valueOf(paramInt1) });
        }
      }
      ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify not support reconnect, disconnect");
      this.jEz.cancel(true);
      b.aTX().aTs().stop();
      b.aTX().aSL().jyN = -4;
      this.jEz.rl(-4);
      h.qsU.idkeyStat(400L, 9L, 1L, false);
      this.jEz.rr(3);
      AppMethodBeat.o(17546);
      return;
      this.jEz.cancel(true);
    }
    label506:
    Object localObject;
    if ((1 == b.aTX().aTY().jEa) || (3 == b.aTX().aTY().jEa))
    {
      if (paramInt1 == 10)
      {
        localObject = new f();
        try
        {
          ((f)localObject).parseFrom(paramArrayOfByte);
          ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive heartbeatResp, ack[%d]", new Object[] { Long.valueOf(((f)localObject).jFD) });
          AppMethodBeat.o(17546);
          return;
        }
        catch (Exception paramArrayOfByte)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.BackupPcServer", paramArrayOfByte, "onBackupPcServerNotify buf to BackupHeartBeatResponse error.", new Object[0]);
          }
        }
      }
      if (paramInt1 == 5)
      {
        ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive cancelReq");
        this.jEz.cancel(true);
        b.aTX().aSL().jyN = -100;
        this.jEz.rl(-100);
        h.qsU.idkeyStat(400L, 51L, 1L, false);
        this.jEz.rr(5);
        AppMethodBeat.o(17546);
        return;
      }
      if (paramInt1 == 18)
      {
        localObject = new com.tencent.mm.plugin.backup.i.c();
        try
        {
          ((com.tencent.mm.plugin.backup.i.c)localObject).parseFrom(paramArrayOfByte);
          ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandResp, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.c)localObject).jJg) });
          if (((com.tencent.mm.plugin.backup.i.c)localObject).jJg == 9)
          {
            paramInt1 = com.tencent.mm.plugin.backup.g.b.aUu();
            if (paramInt1 == 1)
            {
              com.tencent.mm.plugin.backup.g.b.rv(2);
              ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect success, start resendSceneMap");
              this.jEz.rr(20);
              com.tencent.mm.plugin.backup.g.b.aUt();
              b.aTX().aSL().jyN = 14;
              this.jEz.rl(14);
              com.tencent.mm.plugin.backup.g.b.a(new e.3.1(this));
              AppMethodBeat.o(17546);
              return;
            }
          }
        }
        catch (Exception paramArrayOfByte)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.BackupPcServer", paramArrayOfByte, "onBackupPcServerNotify buf to BackupCommandResponse error.", new Object[0]);
          }
          ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect is started, ignore. state[%d]", new Object[] { Integer.valueOf(paramInt1) });
          AppMethodBeat.o(17546);
          return;
        }
      }
      if (paramInt1 == 17) {
        localObject = new com.tencent.mm.plugin.backup.i.b();
      }
    }
    try
    {
      ((com.tencent.mm.plugin.backup.i.b)localObject).parseFrom(paramArrayOfByte);
      ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandReq, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.b)localObject).jJg) });
      if (((com.tencent.mm.plugin.backup.i.b)localObject).jJg == 10)
      {
        paramInt1 = b.aTX().aSL().jyN;
        ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify pc request disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramInt1) });
        if ((paramInt1 == 12) || (paramInt1 == 14))
        {
          this.jEz.cancel(true);
          b.aTX().aTs().stop();
          b.aTX().aSL().jyN = -4;
          this.jEz.rl(-4);
          h.qsU.idkeyStat(400L, 51L, 1L, false);
          this.jEz.rr(5);
          long l = 0L;
          if (e.b(this.jEz).jzC != 0L) {
            l = bo.hl(e.b(this.jEz).jzC);
          }
          h.qsU.e(13737, new Object[] { Integer.valueOf(3), Long.valueOf(e.b(this.jEz).aSZ()), Long.valueOf(l / 1000L), Integer.valueOf(1) });
          ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify transfer disconnect, backupDataSize[%d kb], backupCostTime[%d s]", new Object[] { Long.valueOf(e.b(this.jEz).aSZ()), Long.valueOf(l / 1000L) });
        }
      }
      AppMethodBeat.o(17546);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.BackupPcServer", paramArrayOfByte, "onBackupPcServerNotify buf to BackupCommandRequest error.", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.e.3
 * JD-Core Version:    0.7.0.1
 */