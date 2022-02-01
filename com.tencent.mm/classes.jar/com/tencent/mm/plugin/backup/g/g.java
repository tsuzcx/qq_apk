package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.s;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class g
{
  static long endTime;
  static long oPR;
  static long oPS;
  static long startTime;
  private SimpleDateFormat oMZ;
  MTimerHandler oPT;
  
  public g()
  {
    AppMethodBeat.i(21726);
    this.oMZ = new SimpleDateFormat("yyyyMMdd");
    AppMethodBeat.o(21726);
  }
  
  private void Bq(final int paramInt)
  {
    AppMethodBeat.i(21728);
    final Long localLong1 = Long.valueOf(Util.nowMilliSecond());
    final Long localLong2 = Long.valueOf(Bw(Util.nowMilliSecond()));
    if ((localLong1.longValue() == 0L) || (localLong2.longValue() == 0L))
    {
      Log.e("MicroMsg.BackupLogManager", "startLogAfterTimeHandler is zero, startAfterLogTime[%d], startAfterLogSize[%d], skip", new Object[] { localLong1, localLong2 });
      AppMethodBeat.o(21728);
      return;
    }
    this.oPT = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21725);
        Long localLong1 = Long.valueOf(Util.nowMilliSecond());
        Long localLong2 = Long.valueOf(g.this.K(localLong1.longValue(), localLong1.longValue()));
        Log.i("MicroMsg.BackupLogManager", "backupAfterLogTimeHandler, backupMode[%d], endAfterLogTime[%d], startAfterLogTime[%d], endAfterLogSize[%d], startAfterLogSize[%d]", new Object[] { Integer.valueOf(paramInt), localLong1, localLong1, localLong2, localLong2 });
        if ((localLong2.longValue() != 0L) && (localLong2.longValue() > localLong2.longValue())) {
          g.this.a(paramInt, localLong1.longValue() - localLong1.longValue(), localLong2.longValue() - localLong2.longValue(), true);
        }
        AppMethodBeat.o(21725);
        return false;
      }
    }, false);
    this.oPT.startTimer(300000L);
    AppMethodBeat.o(21728);
  }
  
  static void init()
  {
    startTime = 0L;
    endTime = 0L;
    oPR = 0L;
    oPS = 0L;
  }
  
  final long Bw(long paramLong)
  {
    AppMethodBeat.i(21730);
    String str1 = this.oMZ.format(new Date(paramLong));
    String str2 = ar.NSf + "/MM_" + str1 + ".xlog";
    if (s.YS(str2))
    {
      paramLong = s.boW(str2);
      AppMethodBeat.o(21730);
      return paramLong;
    }
    str1 = b.aKQ() + "/MM_" + str1 + ".xlog";
    if (s.YS(str1))
    {
      paramLong = s.boW(str1);
      AppMethodBeat.o(21730);
      return paramLong;
    }
    AppMethodBeat.o(21730);
    return 0L;
  }
  
  final long K(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(21729);
    long l = 0L;
    while (paramLong1 <= paramLong2 + 86400000L)
    {
      l += Bw(paramLong1);
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
      Log.e("MicroMsg.BackupLogManager", "reportKv logSize is 0, skip report");
      AppMethodBeat.o(21727);
      return;
    }
    long l = paramLong2 / (paramLong1 / 1000L);
    Log.i("MicroMsg.BackupLogManager", "reportKv, backupMode[%d], time[%d ms], logSize[%d KB], aveLogSize[%d B/s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21727);
      return;
      if (!paramBoolean)
      {
        h.CyF.idkeyStat(400L, 81L, paramLong2 / 1024L, false);
        if (paramLong1 != 0L) {
          h.CyF.idkeyStat(400L, 82L, l, false);
        }
        Bq(paramInt);
        AppMethodBeat.o(21727);
        return;
      }
      h.CyF.idkeyStat(400L, 83L, paramLong2 / 1024L, false);
      AppMethodBeat.o(21727);
      return;
      if (!paramBoolean)
      {
        h.CyF.idkeyStat(400L, 86L, paramLong2 / 1024L, false);
        if (paramLong1 != 0L) {
          h.CyF.idkeyStat(400L, 87L, l, false);
        }
        Bq(paramInt);
        AppMethodBeat.o(21727);
        return;
      }
      h.CyF.idkeyStat(400L, 88L, paramLong2 / 1024L, false);
      AppMethodBeat.o(21727);
      return;
      if (!paramBoolean)
      {
        h.CyF.idkeyStat(485L, 91L, paramLong2 / 1024L, false);
        if (paramLong1 != 0L) {
          h.CyF.idkeyStat(485L, 92L, l, false);
        }
        Bq(paramInt);
        AppMethodBeat.o(21727);
        return;
      }
      h.CyF.idkeyStat(485L, 93L, paramLong2 / 1024L, false);
      AppMethodBeat.o(21727);
      return;
      if (!paramBoolean)
      {
        h.CyF.idkeyStat(485L, 96L, paramLong2 / 1024L, false);
        if (paramLong1 != 0L) {
          h.CyF.idkeyStat(485L, 97L, l, false);
        }
        Bq(paramInt);
        AppMethodBeat.o(21727);
        return;
      }
      h.CyF.idkeyStat(485L, 98L, paramLong2 / 1024L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.g
 * JD-Core Version:    0.7.0.1
 */