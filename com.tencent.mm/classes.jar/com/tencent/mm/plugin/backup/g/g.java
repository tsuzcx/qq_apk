package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah;
import com.tencent.mm.vfs.i;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class g
{
  static long endTime;
  static long mZc;
  static long mZd;
  static long startTime;
  private SimpleDateFormat mWi;
  au mZe;
  
  public g()
  {
    AppMethodBeat.i(21726);
    this.mWi = new SimpleDateFormat("yyyyMMdd");
    AppMethodBeat.o(21726);
  }
  
  static void init()
  {
    startTime = 0L;
    endTime = 0L;
    mZc = 0L;
    mZd = 0L;
  }
  
  private void xa(final int paramInt)
  {
    AppMethodBeat.i(21728);
    final Long localLong1 = Long.valueOf(bs.eWj());
    final Long localLong2 = Long.valueOf(rd(bs.eWj()));
    if ((localLong1.longValue() == 0L) || (localLong2.longValue() == 0L))
    {
      ac.e("MicroMsg.BackupLogManager", "startLogAfterTimeHandler is zero, startAfterLogTime[%d], startAfterLogSize[%d], skip", new Object[] { localLong1, localLong2 });
      AppMethodBeat.o(21728);
      return;
    }
    this.mZe = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21725);
        Long localLong1 = Long.valueOf(bs.eWj());
        Long localLong2 = Long.valueOf(g.this.G(localLong1.longValue(), localLong1.longValue()));
        ac.i("MicroMsg.BackupLogManager", "backupAfterLogTimeHandler, backupMode[%d], endAfterLogTime[%d], startAfterLogTime[%d], endAfterLogSize[%d], startAfterLogSize[%d]", new Object[] { Integer.valueOf(paramInt), localLong1, localLong1, localLong2, localLong2 });
        if ((localLong2.longValue() != 0L) && (localLong2.longValue() > localLong2.longValue())) {
          g.this.a(paramInt, localLong1.longValue() - localLong1.longValue(), localLong2.longValue() - localLong2.longValue(), true);
        }
        AppMethodBeat.o(21725);
        return false;
      }
    }, false);
    this.mZe.au(300000L, 300000L);
    AppMethodBeat.o(21728);
  }
  
  final long G(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(21729);
    long l = 0L;
    while (paramLong1 <= paramLong2 + 86400000L)
    {
      l += rd(paramLong1);
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
      ac.e("MicroMsg.BackupLogManager", "reportKv logSize is 0, skip report");
      AppMethodBeat.o(21727);
      return;
    }
    long l = paramLong2 / (paramLong1 / 1000L);
    ac.i("MicroMsg.BackupLogManager", "reportKv, backupMode[%d], time[%d ms], logSize[%d KB], aveLogSize[%d B/s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21727);
      return;
      if (!paramBoolean)
      {
        h.wUl.idkeyStat(400L, 81L, paramLong2 / 1024L, false);
        if (paramLong1 != 0L) {
          h.wUl.idkeyStat(400L, 82L, l, false);
        }
        xa(paramInt);
        AppMethodBeat.o(21727);
        return;
      }
      h.wUl.idkeyStat(400L, 83L, paramLong2 / 1024L, false);
      AppMethodBeat.o(21727);
      return;
      if (!paramBoolean)
      {
        h.wUl.idkeyStat(400L, 86L, paramLong2 / 1024L, false);
        if (paramLong1 != 0L) {
          h.wUl.idkeyStat(400L, 87L, l, false);
        }
        xa(paramInt);
        AppMethodBeat.o(21727);
        return;
      }
      h.wUl.idkeyStat(400L, 88L, paramLong2 / 1024L, false);
      AppMethodBeat.o(21727);
      return;
      if (!paramBoolean)
      {
        h.wUl.idkeyStat(485L, 91L, paramLong2 / 1024L, false);
        if (paramLong1 != 0L) {
          h.wUl.idkeyStat(485L, 92L, l, false);
        }
        xa(paramInt);
        AppMethodBeat.o(21727);
        return;
      }
      h.wUl.idkeyStat(485L, 93L, paramLong2 / 1024L, false);
      AppMethodBeat.o(21727);
      return;
      if (!paramBoolean)
      {
        h.wUl.idkeyStat(485L, 96L, paramLong2 / 1024L, false);
        if (paramLong1 != 0L) {
          h.wUl.idkeyStat(485L, 97L, l, false);
        }
        xa(paramInt);
        AppMethodBeat.o(21727);
        return;
      }
      h.wUl.idkeyStat(485L, 98L, paramLong2 / 1024L, false);
    }
  }
  
  final long rd(long paramLong)
  {
    AppMethodBeat.i(21730);
    String str1 = this.mWi.format(new Date(paramLong));
    String str2 = ah.GDv + "/MM_" + str1 + ".xlog";
    if (i.eA(str2))
    {
      paramLong = i.aSp(str2);
      AppMethodBeat.o(21730);
      return paramLong;
    }
    str1 = b.apn() + "/MM_" + str1 + ".xlog";
    if (i.eA(str1))
    {
      paramLong = i.aSp(str1);
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