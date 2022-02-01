package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am;
import com.tencent.mm.vfs.o;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class g
{
  static long endTime;
  static long nEU;
  static long nEV;
  static long startTime;
  private SimpleDateFormat nCa;
  aw nEW;
  
  public g()
  {
    AppMethodBeat.i(21726);
    this.nCa = new SimpleDateFormat("yyyyMMdd");
    AppMethodBeat.o(21726);
  }
  
  static void init()
  {
    startTime = 0L;
    endTime = 0L;
    nEU = 0L;
    nEV = 0L;
  }
  
  private void xK(final int paramInt)
  {
    AppMethodBeat.i(21728);
    final Long localLong1 = Long.valueOf(bu.fpO());
    final Long localLong2 = Long.valueOf(tq(bu.fpO()));
    if ((localLong1.longValue() == 0L) || (localLong2.longValue() == 0L))
    {
      ae.e("MicroMsg.BackupLogManager", "startLogAfterTimeHandler is zero, startAfterLogTime[%d], startAfterLogSize[%d], skip", new Object[] { localLong1, localLong2 });
      AppMethodBeat.o(21728);
      return;
    }
    this.nEW = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21725);
        Long localLong1 = Long.valueOf(bu.fpO());
        Long localLong2 = Long.valueOf(g.this.F(localLong1.longValue(), localLong1.longValue()));
        ae.i("MicroMsg.BackupLogManager", "backupAfterLogTimeHandler, backupMode[%d], endAfterLogTime[%d], startAfterLogTime[%d], endAfterLogSize[%d], startAfterLogSize[%d]", new Object[] { Integer.valueOf(paramInt), localLong1, localLong1, localLong2, localLong2 });
        if ((localLong2.longValue() != 0L) && (localLong2.longValue() > localLong2.longValue())) {
          g.this.a(paramInt, localLong1.longValue() - localLong1.longValue(), localLong2.longValue() - localLong2.longValue(), true);
        }
        AppMethodBeat.o(21725);
        return false;
      }
    }, false);
    this.nEW.ay(300000L, 300000L);
    AppMethodBeat.o(21728);
  }
  
  final long F(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(21729);
    long l = 0L;
    while (paramLong1 <= paramLong2 + 86400000L)
    {
      l += tq(paramLong1);
      paramLong1 += 86400000L;
    }
    AppMethodBeat.o(21729);
    return l;
  }
  
  final void a(int paramInt, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(21727);
    if (paramLong2 == 0L)
    {
      ae.e("MicroMsg.BackupLogManager", "reportKv logSize is 0, skip report");
      AppMethodBeat.o(21727);
      return;
    }
    long l = paramLong2 / (paramLong1 / 1000L);
    ae.i("MicroMsg.BackupLogManager", "reportKv, backupMode[%d], time[%d ms], logSize[%d KB], aveLogSize[%d B/s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21727);
      return;
      if (!paramBoolean)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 81L, paramLong2 / 1024L, false);
        if (paramLong1 != 0L) {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 82L, l, false);
        }
        xK(paramInt);
        AppMethodBeat.o(21727);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 83L, paramLong2 / 1024L, false);
      AppMethodBeat.o(21727);
      return;
      if (!paramBoolean)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 86L, paramLong2 / 1024L, false);
        if (paramLong1 != 0L) {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 87L, l, false);
        }
        xK(paramInt);
        AppMethodBeat.o(21727);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(400L, 88L, paramLong2 / 1024L, false);
      AppMethodBeat.o(21727);
      return;
      if (!paramBoolean)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 91L, paramLong2 / 1024L, false);
        if (paramLong1 != 0L) {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 92L, l, false);
        }
        xK(paramInt);
        AppMethodBeat.o(21727);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 93L, paramLong2 / 1024L, false);
      AppMethodBeat.o(21727);
      return;
      if (!paramBoolean)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 96L, paramLong2 / 1024L, false);
        if (paramLong1 != 0L) {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 97L, l, false);
        }
        xK(paramInt);
        AppMethodBeat.o(21727);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(485L, 98L, paramLong2 / 1024L, false);
    }
  }
  
  final long tq(long paramLong)
  {
    AppMethodBeat.i(21730);
    String str1 = this.nCa.format(new Date(paramLong));
    String str2 = am.IKi + "/MM_" + str1 + ".xlog";
    if (o.fB(str2))
    {
      paramLong = o.aZR(str2);
      AppMethodBeat.o(21730);
      return paramLong;
    }
    str1 = b.asq() + "/MM_" + str1 + ".xlog";
    if (o.fB(str1))
    {
      paramLong = o.aZR(str1);
      AppMethodBeat.o(21730);
      return paramLong;
    }
    AppMethodBeat.o(21730);
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.g
 * JD-Core Version:    0.7.0.1
 */