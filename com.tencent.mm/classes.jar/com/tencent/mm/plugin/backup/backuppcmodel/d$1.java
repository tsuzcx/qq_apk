package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.i.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

final class d$1
  implements b.d
{
  d$1(d paramd) {}
  
  public final void a(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(17521);
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      ab.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify isLocal[%b], type[%d], seq[%d], buflen[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if ((!paramBoolean) || (10011 != paramInt1)) {
        break;
      }
      d.a(this.jEr);
      AppMethodBeat.o(17521);
      return;
    }
    if (paramInt1 == 5)
    {
      ab.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive cancelReq.");
      this.jEr.c(true, false, -100);
      h.qsU.idkeyStat(400L, 52L, 1L, false);
      this.jEr.rr(5);
      AppMethodBeat.o(17521);
      return;
    }
    i = b.aTX().aTY().jEa;
    if ((2 != i) && (4 != i))
    {
      ab.e("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify cmdmode error[%d]", new Object[] { Integer.valueOf(b.aTX().aTY().jEa) });
      AppMethodBeat.o(17521);
      return;
    }
    long l;
    if (paramInt1 == 10)
    {
      paramArrayOfByte = (f)g.a(new f(), paramArrayOfByte);
      if (paramArrayOfByte != null) {}
      for (l = paramArrayOfByte.jFD;; l = -1L)
      {
        ab.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive heartbeatResp, ack[%d]", new Object[] { Long.valueOf(l) });
        AppMethodBeat.o(17521);
        return;
      }
    }
    Object localObject;
    if (paramInt1 == 18)
    {
      localObject = new com.tencent.mm.plugin.backup.i.c();
      try
      {
        ((com.tencent.mm.plugin.backup.i.c)localObject).parseFrom(paramArrayOfByte);
        ab.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandResp, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.c)localObject).jJg) });
        if (((com.tencent.mm.plugin.backup.i.c)localObject).jJg == 9)
        {
          paramInt1 = com.tencent.mm.plugin.backup.g.b.aUu();
          if (paramInt1 == 1)
          {
            com.tencent.mm.plugin.backup.g.b.rv(2);
            ab.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect success");
            this.jEr.rr(20);
            com.tencent.mm.plugin.backup.g.b.aUt();
            b.aTX().aSL().jyN = 23;
            this.jEr.rf(23);
            com.tencent.mm.plugin.backup.g.b.rv(0);
            AppMethodBeat.o(17521);
            return;
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.BackupPcRecoverServer", paramArrayOfByte, "onBackupPcRecoverServerNotify buf to BackupCommandResponse error.", new Object[0]);
        }
        ab.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect is started, ignore. state[%d]", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(17521);
        return;
      }
    }
    if (paramInt1 == 17)
    {
      localObject = new com.tencent.mm.plugin.backup.i.b();
      try
      {
        ((com.tencent.mm.plugin.backup.i.b)localObject).parseFrom(paramArrayOfByte);
        ab.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandReq, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.b)localObject).jJg) });
        if (((com.tencent.mm.plugin.backup.i.b)localObject).jJg == 10)
        {
          paramInt1 = b.aTX().aSL().jyN;
          ab.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify pc request disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramInt1) });
          if ((paramInt1 == 22) || (paramInt1 == 23))
          {
            this.jEr.c(true, false, -4);
            b.aTX().aTs().stop();
            h.qsU.idkeyStat(400L, 52L, 1L, false);
            this.jEr.rr(5);
            l = 0L;
            if (d.b(this.jEr) != 0L) {
              l = bo.hl(d.b(this.jEr));
            }
            h.qsU.e(13737, new Object[] { Integer.valueOf(3), Long.valueOf(d.c(this.jEr)), Long.valueOf(l), Integer.valueOf(2) });
            ab.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify recover transfer disconnect, recoverDataSize:%d, recoverCostTime:%d", new Object[] { Long.valueOf(d.c(this.jEr)), Long.valueOf(l) });
          }
        }
        AppMethodBeat.o(17521);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.BackupPcRecoverServer", paramArrayOfByte, "onBackupPcRecoverServerNotify buf to BackupCommandRequest error.", new Object[0]);
        }
      }
    }
    aw.RO().ac(new d.1.1(this, paramInt1, paramArrayOfByte, paramInt2));
    AppMethodBeat.o(17521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.d.1
 * JD-Core Version:    0.7.0.1
 */