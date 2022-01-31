package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class g
{
  static long endTime;
  static long hMf;
  static long hMg;
  static long startTime;
  private SimpleDateFormat hJl = new SimpleDateFormat("yyyyMMdd");
  am hMh;
  
  static void init()
  {
    startTime = 0L;
    endTime = 0L;
    hMf = 0L;
    hMg = 0L;
  }
  
  private void nJ(int paramInt)
  {
    Long localLong1 = Long.valueOf(bk.UY());
    Long localLong2 = Long.valueOf(cI(bk.UY()));
    if ((localLong1.longValue() == 0L) || (localLong2.longValue() == 0L))
    {
      y.e("MicroMsg.BackupLogManager", "startLogAfterTimeHandler is zero, startAfterLogTime[%d], startAfterLogSize[%d], skip", new Object[] { localLong1, localLong2 });
      return;
    }
    this.hMh = new am(Looper.getMainLooper(), new g.1(this, localLong1, paramInt, localLong2), false);
    this.hMh.S(300000L, 300000L);
  }
  
  final void a(int paramInt, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramLong2 == 0L)
    {
      y.e("MicroMsg.BackupLogManager", "reportKv logSize is 0, skip report");
      return;
    }
    long l = paramLong2 / (paramLong1 / 1000L);
    y.i("MicroMsg.BackupLogManager", "reportKv, backupMode[%d], time[%d ms], logSize[%d KB], aveLogSize[%d B/s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l) });
    switch (paramInt)
    {
    default: 
      return;
    case 11: 
      if (!paramBoolean)
      {
        h.nFQ.a(400L, 81L, paramLong2 / 1024L, false);
        if (paramLong1 != 0L) {
          h.nFQ.a(400L, 82L, l, false);
        }
        nJ(paramInt);
        return;
      }
      h.nFQ.a(400L, 83L, paramLong2 / 1024L, false);
      return;
    case 12: 
      if (!paramBoolean)
      {
        h.nFQ.a(400L, 86L, paramLong2 / 1024L, false);
        if (paramLong1 != 0L) {
          h.nFQ.a(400L, 87L, l, false);
        }
        nJ(paramInt);
        return;
      }
      h.nFQ.a(400L, 88L, paramLong2 / 1024L, false);
      return;
    case 21: 
      if (!paramBoolean)
      {
        h.nFQ.a(485L, 91L, paramLong2 / 1024L, false);
        if (paramLong1 != 0L) {
          h.nFQ.a(485L, 92L, l, false);
        }
        nJ(paramInt);
        return;
      }
      h.nFQ.a(485L, 93L, paramLong2 / 1024L, false);
      return;
    }
    if (!paramBoolean)
    {
      h.nFQ.a(485L, 96L, paramLong2 / 1024L, false);
      if (paramLong1 != 0L) {
        h.nFQ.a(485L, 97L, l, false);
      }
      nJ(paramInt);
      return;
    }
    h.nFQ.a(485L, 98L, paramLong2 / 1024L, false);
  }
  
  final long cI(long paramLong)
  {
    String str1 = this.hJl.format(new Date(paramLong));
    String str2 = ac.unx + "/MM_" + str1 + ".xlog";
    if (com.tencent.mm.vfs.e.bK(str2)) {
      return com.tencent.mm.vfs.e.aeQ(str2);
    }
    str1 = com.tencent.mm.compatible.util.e.dzJ + "/MM_" + str1 + ".xlog";
    if (com.tencent.mm.vfs.e.bK(str1)) {
      return com.tencent.mm.vfs.e.aeQ(str1);
    }
    return 0L;
  }
  
  final long t(long paramLong1, long paramLong2)
  {
    long l = 0L;
    while (paramLong1 <= paramLong2 + 86400000L)
    {
      l += cI(paramLong1);
      paramLong1 += 86400000L;
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.g
 * JD-Core Version:    0.7.0.1
 */