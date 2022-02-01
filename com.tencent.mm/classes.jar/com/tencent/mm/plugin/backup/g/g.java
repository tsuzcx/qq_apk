package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae;
import com.tencent.mm.vfs.i;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class g
{
  static long endTime;
  static long mxb;
  static long mxc;
  static long startTime;
  private SimpleDateFormat mug;
  av mxd;
  
  public g()
  {
    AppMethodBeat.i(21726);
    this.mug = new SimpleDateFormat("yyyyMMdd");
    AppMethodBeat.o(21726);
  }
  
  static void init()
  {
    startTime = 0L;
    endTime = 0L;
    mxb = 0L;
    mxc = 0L;
  }
  
  private void wj(final int paramInt)
  {
    AppMethodBeat.i(21728);
    final Long localLong1 = Long.valueOf(bt.eGO());
    final Long localLong2 = Long.valueOf(nr(bt.eGO()));
    if ((localLong1.longValue() == 0L) || (localLong2.longValue() == 0L))
    {
      ad.e("MicroMsg.BackupLogManager", "startLogAfterTimeHandler is zero, startAfterLogTime[%d], startAfterLogSize[%d], skip", new Object[] { localLong1, localLong2 });
      AppMethodBeat.o(21728);
      return;
    }
    this.mxd = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21725);
        Long localLong1 = Long.valueOf(bt.eGO());
        Long localLong2 = Long.valueOf(g.this.K(localLong1.longValue(), localLong1.longValue()));
        ad.i("MicroMsg.BackupLogManager", "backupAfterLogTimeHandler, backupMode[%d], endAfterLogTime[%d], startAfterLogTime[%d], endAfterLogSize[%d], startAfterLogSize[%d]", new Object[] { Integer.valueOf(paramInt), localLong1, localLong1, localLong2, localLong2 });
        if ((localLong2.longValue() != 0L) && (localLong2.longValue() > localLong2.longValue())) {
          g.this.a(paramInt, localLong1.longValue() - localLong1.longValue(), localLong2.longValue() - localLong2.longValue(), true);
        }
        AppMethodBeat.o(21725);
        return false;
      }
    }, false);
    this.mxd.av(300000L, 300000L);
    AppMethodBeat.o(21728);
  }
  
  final long K(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(21729);
    long l = 0L;
    while (paramLong1 <= paramLong2 + 86400000L)
    {
      l += nr(paramLong1);
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
      ad.e("MicroMsg.BackupLogManager", "reportKv logSize is 0, skip report");
      AppMethodBeat.o(21727);
      return;
    }
    long l = paramLong2 / (paramLong1 / 1000L);
    ad.i("MicroMsg.BackupLogManager", "reportKv, backupMode[%d], time[%d ms], logSize[%d KB], aveLogSize[%d B/s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21727);
      return;
      if (!paramBoolean)
      {
        h.vKh.idkeyStat(400L, 81L, paramLong2 / 1024L, false);
        if (paramLong1 != 0L) {
          h.vKh.idkeyStat(400L, 82L, l, false);
        }
        wj(paramInt);
        AppMethodBeat.o(21727);
        return;
      }
      h.vKh.idkeyStat(400L, 83L, paramLong2 / 1024L, false);
      AppMethodBeat.o(21727);
      return;
      if (!paramBoolean)
      {
        h.vKh.idkeyStat(400L, 86L, paramLong2 / 1024L, false);
        if (paramLong1 != 0L) {
          h.vKh.idkeyStat(400L, 87L, l, false);
        }
        wj(paramInt);
        AppMethodBeat.o(21727);
        return;
      }
      h.vKh.idkeyStat(400L, 88L, paramLong2 / 1024L, false);
      AppMethodBeat.o(21727);
      return;
      if (!paramBoolean)
      {
        h.vKh.idkeyStat(485L, 91L, paramLong2 / 1024L, false);
        if (paramLong1 != 0L) {
          h.vKh.idkeyStat(485L, 92L, l, false);
        }
        wj(paramInt);
        AppMethodBeat.o(21727);
        return;
      }
      h.vKh.idkeyStat(485L, 93L, paramLong2 / 1024L, false);
      AppMethodBeat.o(21727);
      return;
      if (!paramBoolean)
      {
        h.vKh.idkeyStat(485L, 96L, paramLong2 / 1024L, false);
        if (paramLong1 != 0L) {
          h.vKh.idkeyStat(485L, 97L, l, false);
        }
        wj(paramInt);
        AppMethodBeat.o(21727);
        return;
      }
      h.vKh.idkeyStat(485L, 98L, paramLong2 / 1024L, false);
    }
  }
  
  final long nr(long paramLong)
  {
    AppMethodBeat.i(21730);
    String str1 = this.mug.format(new Date(paramLong));
    String str2 = ae.FfI + "/MM_" + str1 + ".xlog";
    if (i.eK(str2))
    {
      paramLong = i.aMN(str2);
      AppMethodBeat.o(21730);
      return paramLong;
    }
    str1 = b.ain() + "/MM_" + str1 + ".xlog";
    if (i.eK(str1))
    {
      paramLong = i.aMN(str1);
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