package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.i.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class d$1
  implements b.d
{
  d$1(d paramd) {}
  
  public final void a(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i;
    if (paramArrayOfByte == null)
    {
      i = 0;
      y.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify isLocal[%b], type[%d], seq[%d], buflen[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
      if ((!paramBoolean) || (10011 != paramInt1)) {
        break label74;
      }
      d.a(this.hKO);
    }
    for (;;)
    {
      return;
      i = paramArrayOfByte.length;
      break;
      label74:
      if (paramInt1 == 5)
      {
        y.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive cancelReq.");
        this.hKO.a(true, false, -100);
        h.nFQ.a(400L, 52L, 1L, false);
        this.hKO.nC(5);
        return;
      }
      i = b.auw().aux().hKx;
      if ((2 != i) && (4 != i))
      {
        y.e("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify cmdmode error[%d]", new Object[] { Integer.valueOf(b.auw().aux().hKx) });
        return;
      }
      long l;
      if (paramInt1 == 10)
      {
        paramArrayOfByte = (f)g.a(new f(), paramArrayOfByte);
        if (paramArrayOfByte != null) {}
        for (l = paramArrayOfByte.hMb;; l = -1L)
        {
          y.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive heartbeatResp, ack[%d]", new Object[] { Long.valueOf(l) });
          return;
        }
      }
      Object localObject;
      if (paramInt1 == 18)
      {
        localObject = new com.tencent.mm.plugin.backup.i.c();
        try
        {
          ((com.tencent.mm.plugin.backup.i.c)localObject).aH(paramArrayOfByte);
          y.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandResp, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.c)localObject).hPE) });
          if (((com.tencent.mm.plugin.backup.i.c)localObject).hPE != 9) {
            continue;
          }
          paramInt1 = com.tencent.mm.plugin.backup.g.b.auS();
          if (paramInt1 == 1)
          {
            com.tencent.mm.plugin.backup.g.b.nH(2);
            y.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect success");
            this.hKO.nC(20);
            com.tencent.mm.plugin.backup.g.b.auR();
            b.auw().atn().hFu = 23;
            this.hKO.nt(23);
            com.tencent.mm.plugin.backup.g.b.nH(0);
            return;
          }
        }
        catch (Exception paramArrayOfByte)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.BackupPcRecoverServer", paramArrayOfByte, "onBackupPcRecoverServerNotify buf to BackupCommandResponse error.", new Object[0]);
          }
          y.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect is started, ignore. state[%d]", new Object[] { Integer.valueOf(paramInt1) });
          return;
        }
      }
      else if (paramInt1 == 17)
      {
        localObject = new com.tencent.mm.plugin.backup.i.b();
        try
        {
          ((com.tencent.mm.plugin.backup.i.b)localObject).aH(paramArrayOfByte);
          y.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandReq, cmd[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.backup.i.b)localObject).hPE) });
          if (((com.tencent.mm.plugin.backup.i.b)localObject).hPE == 10)
          {
            paramInt1 = b.auw().atn().hFu;
            y.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify pc request disconnect, backupPcState[%d]", new Object[] { Integer.valueOf(paramInt1) });
            if ((paramInt1 == 22) || (paramInt1 == 23))
            {
              this.hKO.a(true, false, -4);
              b.auw().atT().stop();
              h.nFQ.a(400L, 52L, 1L, false);
              this.hKO.nC(5);
              l = 0L;
              if (d.b(this.hKO) != 0L) {
                l = bk.co(d.b(this.hKO));
              }
              h.nFQ.f(13737, new Object[] { Integer.valueOf(3), Long.valueOf(d.c(this.hKO)), Long.valueOf(l), Integer.valueOf(2) });
              y.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify recover transfer disconnect, recoverDataSize:%d, recoverCostTime:%d", new Object[] { Long.valueOf(d.c(this.hKO)), Long.valueOf(l) });
              return;
            }
          }
        }
        catch (Exception paramArrayOfByte)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.BackupPcRecoverServer", paramArrayOfByte, "onBackupPcRecoverServerNotify buf to BackupCommandRequest error.", new Object[0]);
          }
        }
      }
    }
    au.DS().O(new d.1.1(this, paramInt1, paramArrayOfByte, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.d.1
 * JD-Core Version:    0.7.0.1
 */