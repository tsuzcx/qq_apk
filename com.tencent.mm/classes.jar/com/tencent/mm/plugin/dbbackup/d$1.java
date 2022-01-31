package com.tencent.mm.plugin.dbbackup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.repair.BackupKit;
import com.tencent.wcdb.repair.RepairKit.MasterInfo;
import java.text.SimpleDateFormat;
import java.util.Date;

final class d$1
  implements Runnable
{
  d$1(d paramd, b paramb, c paramc, String paramString1, boolean paramBoolean, SQLiteDatabase paramSQLiteDatabase, String paramString2, String paramString3, String paramString4, long[] paramArrayOfLong1, long[] paramArrayOfLong2, int paramInt, String[] paramArrayOfString, String paramString5) {}
  
  public final void run()
  {
    AppMethodBeat.i(18969);
    if (!d.a(this.kUn))
    {
      if (this.kUb != null) {
        this.kUb.tT(1);
      }
      AppMethodBeat.o(18969);
      return;
    }
    d.a(this.kUn, null);
    for (;;)
    {
      Object localObject3;
      long l1;
      label221:
      int i;
      label276:
      label291:
      label338:
      int k;
      int j;
      try
      {
        long l2 = System.nanoTime();
        localObject3 = com.tencent.mm.a.g.x((q.bP(true) + c.getUin()).getBytes());
        Object localObject1 = new com.tencent.mm.vfs.b(this.kUd);
        com.tencent.mm.vfs.b localb;
        if ((!this.kUe) || (!((com.tencent.mm.vfs.b)localObject1).exists()))
        {
          boolean bool = RepairKit.MasterInfo.save(this.kUf, this.kUg, (byte[])localObject3);
          localb = new com.tencent.mm.vfs.b(this.kUg);
          if (bool)
          {
            ((com.tencent.mm.vfs.b)localObject1).delete();
            bool = localb.p((com.tencent.mm.vfs.b)localObject1);
            l1 = System.nanoTime();
            if (!bool) {
              break label1105;
            }
            localObject1 = "SUCCEEDED";
            ab.i("MicroMsg.SubCoreDBBackup", "Master table backup %s, elapsed %.3f", new Object[] { localObject1, Float.valueOf((float)(l1 - l2) / 1.0E+009F) });
            localObject1 = h.qsU;
            if (!bool) {
              break label1113;
            }
            l1 = 24L;
            ((h)localObject1).idkeyStat(181L, l1, 1L, false);
          }
        }
        else
        {
          long l3 = new com.tencent.mm.vfs.b(this.kTw).length();
          long l4 = new com.tencent.mm.vfs.b(this.kUh).length();
          if (!this.kUe) {
            break label1121;
          }
          localObject1 = "incremental";
          if (this.kUi == null) {
            break label1129;
          }
          l1 = this.kUi[0];
          ab.i("MicroMsg.SubCoreDBBackup", "Backup started [%s, cursor: %d ~ %d]", new Object[] { localObject1, Long.valueOf(l1), Long.valueOf(this.kUj[0]) });
          if (!this.kUe) {
            break label1135;
          }
          i = 10011;
          h.qsU.e(11098, new Object[] { Integer.valueOf(i), String.format("%d|%d|%s", new Object[] { Long.valueOf(l3), Long.valueOf(l4), this.kUn.kTX.format(new Date()) }) });
          d.a(this.kUn, new BackupKit(this.kUf, this.kUh, (byte[])localObject3, this.kUk, this.kUl));
          k = d.b(this.kUn).run();
          l1 = System.nanoTime() - l2;
          localObject1 = new com.tencent.mm.vfs.b(this.kUh);
          l2 = ((com.tencent.mm.vfs.b)localObject1).length();
          if (k != 0) {
            continue;
          }
          d.b(this.kTw, this.kUj);
          localObject3 = new com.tencent.mm.vfs.b(this.kUm);
          ((com.tencent.mm.vfs.b)localObject3).delete();
          ((com.tencent.mm.vfs.b)localObject1).p((com.tencent.mm.vfs.b)localObject3);
          if (!this.kUe) {
            break label1142;
          }
          i = 19;
          j = 10012;
          label535:
          if (!this.kUe) {
            break label1172;
          }
          localObject3 = "incremental";
          break label1093;
          label549:
          ab.i("MicroMsg.SubCoreDBBackup", "Database %s backup %s, elapsed %.2f seconds.", new Object[] { localObject3, localObject1, Float.valueOf((float)l1 / 1.0E+009F) });
          h.qsU.idkeyStat(181L, i, 1L, false);
          h.qsU.e(11098, new Object[] { Integer.valueOf(j), String.format("%d|%d|%d|%d|%d|%s", new Object[] { Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l2), Integer.valueOf(d.b(this.kUn).statementCount()), Long.valueOf(l1 / 1000000L), this.kUn.kTX.format(new Date()) }) });
          if (this.kUb != null) {
            this.kUb.tT(k);
          }
          d.b(this.kUn).release();
          d.a(this.kUn, null);
          localObject1 = new StringBuilder();
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.vfs.e.um(com.tencent.mm.kernel.g.RL().eHR + "dbback");
          localObject1 = this.kUd;
          localObject3 = new StringBuilder();
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.vfs.e.C((String)localObject1, com.tencent.mm.kernel.g.RL().eHR + "dbback/EnMicroMsg.db.sm");
          return;
        }
        localb.delete();
        continue;
        ((com.tencent.mm.vfs.b)localObject1).delete();
        if (k == 1)
        {
          if (this.kUe)
          {
            i = 20;
            j = 10013;
          }
        }
        else
        {
          if (!this.kUe) {
            break label1162;
          }
          i = 21;
          j = 10014;
          continue;
          localObject1 = "failed";
          continue;
          h localh;
          if (k != 0) {
            break label1180;
          }
        }
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", localException, "Failed to start database backup, path: %s", new Object[] { this.kTw });
        if (this.kUb != null) {
          this.kUb.tT(-1);
        }
        localh = h.qsU;
        if (this.kUe)
        {
          l1 = 18L;
          localh.idkeyStat(181L, l1, 1L, false);
          return;
        }
        l1 = 21L;
        continue;
      }
      finally
      {
        if (d.b(this.kUn) != null)
        {
          d.b(this.kUn).release();
          d.a(this.kUn, null);
        }
        d.c(this.kUn);
        AppMethodBeat.o(18969);
      }
      label1093:
      String str;
      for (;;)
      {
        str = "succeeded";
        break label549;
        label1105:
        str = "FAILED";
        break;
        label1113:
        l1 = 25L;
        break label221;
        label1121:
        str = "new";
        break label276;
        label1129:
        l1 = 0L;
        break label291;
        label1135:
        i = 10000;
        break label338;
        label1142:
        i = 16;
        j = 10001;
        break label535;
        i = 17;
        j = 10002;
        break label535;
        label1162:
        i = 18;
        j = 10003;
        break label535;
        label1172:
        localObject3 = "new";
      }
      label1180:
      if (k == 1) {
        str = "canceled";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d.1
 * JD-Core Version:    0.7.0.1
 */