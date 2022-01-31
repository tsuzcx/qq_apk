package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
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
    if (!d.a(this.iNn))
    {
      if (this.iNb != null) {
        this.iNb.pC(1);
      }
      return;
    }
    d.a(this.iNn, null);
    for (;;)
    {
      Object localObject3;
      long l1;
      label208:
      int i;
      label263:
      label278:
      label325:
      int k;
      int j;
      try
      {
        long l2 = System.nanoTime();
        localObject3 = com.tencent.mm.a.g.p((q.zf() + c.CK()).getBytes());
        Object localObject1 = new com.tencent.mm.vfs.b(this.iNd);
        com.tencent.mm.vfs.b localb;
        if ((!this.iNe) || (!((com.tencent.mm.vfs.b)localObject1).exists()))
        {
          boolean bool = RepairKit.MasterInfo.save(this.iNf, this.iNg, (byte[])localObject3);
          localb = new com.tencent.mm.vfs.b(this.iNg);
          if (bool)
          {
            ((com.tencent.mm.vfs.b)localObject1).delete();
            bool = localb.n((com.tencent.mm.vfs.b)localObject1);
            l1 = System.nanoTime();
            if (!bool) {
              break label1074;
            }
            localObject1 = "SUCCEEDED";
            y.i("MicroMsg.SubCoreDBBackup", "Master table backup %s, elapsed %.3f", new Object[] { localObject1, Float.valueOf((float)(l1 - l2) / 1.0E+009F) });
            localObject1 = h.nFQ;
            if (!bool) {
              break label1082;
            }
            l1 = 24L;
            ((h)localObject1).a(181L, l1, 1L, false);
          }
        }
        else
        {
          long l3 = new com.tencent.mm.vfs.b(this.iMy).length();
          long l4 = new com.tencent.mm.vfs.b(this.iNh).length();
          if (!this.iNe) {
            break label1090;
          }
          localObject1 = "incremental";
          if (this.iNi == null) {
            break label1098;
          }
          l1 = this.iNi[0];
          y.i("MicroMsg.SubCoreDBBackup", "Backup started [%s, cursor: %d ~ %d]", new Object[] { localObject1, Long.valueOf(l1), Long.valueOf(this.iNj[0]) });
          if (!this.iNe) {
            break label1104;
          }
          i = 10011;
          h.nFQ.f(11098, new Object[] { Integer.valueOf(i), String.format("%d|%d|%s", new Object[] { Long.valueOf(l3), Long.valueOf(l4), this.iNn.iMX.format(new Date()) }) });
          d.a(this.iNn, new BackupKit(this.iNf, this.iNh, (byte[])localObject3, this.iNk, this.iNl));
          k = d.b(this.iNn).run();
          l1 = System.nanoTime() - l2;
          localObject1 = new com.tencent.mm.vfs.b(this.iNh);
          l2 = ((com.tencent.mm.vfs.b)localObject1).length();
          if (k != 0) {
            continue;
          }
          d.b(this.iMy, this.iNj);
          localObject3 = new com.tencent.mm.vfs.b(this.iNm);
          ((com.tencent.mm.vfs.b)localObject3).delete();
          ((com.tencent.mm.vfs.b)localObject1).n((com.tencent.mm.vfs.b)localObject3);
          if (!this.iNe) {
            break label1111;
          }
          j = 10012;
          i = 19;
          label522:
          if (!this.iNe) {
            break label1141;
          }
          localObject3 = "incremental";
          break label1062;
          label536:
          y.i("MicroMsg.SubCoreDBBackup", "Database %s backup %s, elapsed %.2f seconds.", new Object[] { localObject3, localObject1, Float.valueOf((float)l1 / 1.0E+009F) });
          h.nFQ.a(181L, i, 1L, false);
          h.nFQ.f(11098, new Object[] { Integer.valueOf(j), String.format("%d|%d|%d|%d|%d|%s", new Object[] { Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l2), Integer.valueOf(d.b(this.iNn).statementCount()), Long.valueOf(l1 / 1000000L), this.iNn.iMX.format(new Date()) }) });
          if (this.iNb != null) {
            this.iNb.pC(k);
          }
          d.b(this.iNn).release();
          d.a(this.iNn, null);
          localObject1 = new StringBuilder();
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.vfs.e.nb(com.tencent.mm.kernel.g.DP().dKt + "dbback");
          localObject1 = this.iNd;
          localObject3 = new StringBuilder();
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.vfs.e.r((String)localObject1, com.tencent.mm.kernel.g.DP().dKt + "dbback/EnMicroMsg.db.sm");
          return;
        }
        localb.delete();
        continue;
        ((com.tencent.mm.vfs.b)localObject1).delete();
        if (k == 1)
        {
          if (this.iNe)
          {
            j = 10013;
            i = 20;
          }
        }
        else
        {
          if (!this.iNe) {
            break label1131;
          }
          j = 10014;
          i = 21;
          continue;
          localObject1 = "failed";
          continue;
          h localh;
          if (k != 0) {
            break label1149;
          }
        }
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.SubCoreDBBackup", localException, "Failed to start database backup, path: %s", new Object[] { this.iMy });
        if (this.iNb != null) {
          this.iNb.pC(-1);
        }
        localh = h.nFQ;
        if (this.iNe)
        {
          l1 = 18L;
          localh.a(181L, l1, 1L, false);
          return;
        }
        l1 = 21L;
        continue;
      }
      finally
      {
        if (d.b(this.iNn) != null)
        {
          d.b(this.iNn).release();
          d.a(this.iNn, null);
        }
        d.c(this.iNn);
      }
      label1062:
      String str;
      for (;;)
      {
        str = "succeeded";
        break label536;
        label1074:
        str = "FAILED";
        break;
        label1082:
        l1 = 25L;
        break label208;
        label1090:
        str = "new";
        break label263;
        label1098:
        l1 = 0L;
        break label278;
        label1104:
        i = 10000;
        break label325;
        label1111:
        j = 10001;
        i = 16;
        break label522;
        j = 10002;
        i = 17;
        break label522;
        label1131:
        j = 10003;
        i = 18;
        break label522;
        label1141:
        localObject3 = "new";
      }
      label1149:
      if (k == 1) {
        str = "canceled";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d.1
 * JD-Core Version:    0.7.0.1
 */