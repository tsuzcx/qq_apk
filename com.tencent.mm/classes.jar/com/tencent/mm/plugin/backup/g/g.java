package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class g
{
  static long endTime;
  static long jFH;
  static long jFI;
  static long startTime;
  private SimpleDateFormat jCL;
  ap jFJ;
  
  public g()
  {
    AppMethodBeat.i(17667);
    this.jCL = new SimpleDateFormat("yyyyMMdd");
    AppMethodBeat.o(17667);
  }
  
  static void init()
  {
    startTime = 0L;
    endTime = 0L;
    jFH = 0L;
    jFI = 0L;
  }
  
  private void rx(int paramInt)
  {
    AppMethodBeat.i(17669);
    Long localLong1 = Long.valueOf(bo.aoy());
    Long localLong2 = Long.valueOf(hK(bo.aoy()));
    if ((localLong1.longValue() == 0L) || (localLong2.longValue() == 0L))
    {
      ab.e("MicroMsg.BackupLogManager", "startLogAfterTimeHandler is zero, startAfterLogTime[%d], startAfterLogSize[%d], skip", new Object[] { localLong1, localLong2 });
      AppMethodBeat.o(17669);
      return;
    }
    this.jFJ = new ap(Looper.getMainLooper(), new g.1(this, localLong1, paramInt, localLong2), false);
    this.jFJ.ag(300000L, 300000L);
    AppMethodBeat.o(17669);
  }
  
  final long D(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(17670);
    long l = 0L;
    while (paramLong1 <= paramLong2 + 86400000L)
    {
      l += hK(paramLong1);
      paramLong1 += 86400000L;
    }
    AppMethodBeat.o(17670);
    return l;
  }
  
  final void a(int paramInt, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(17668);
    if (paramLong2 == 0L)
    {
      ab.e("MicroMsg.BackupLogManager", "reportKv logSize is 0, skip report");
      AppMethodBeat.o(17668);
      return;
    }
    long l = paramLong2 / (paramLong1 / 1000L);
    ab.i("MicroMsg.BackupLogManager", "reportKv, backupMode[%d], time[%d ms], logSize[%d KB], aveLogSize[%d B/s]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(17668);
      return;
      if (!paramBoolean)
      {
        h.qsU.idkeyStat(400L, 81L, paramLong2 / 1024L, false);
        if (paramLong1 != 0L) {
          h.qsU.idkeyStat(400L, 82L, l, false);
        }
        rx(paramInt);
        AppMethodBeat.o(17668);
        return;
      }
      h.qsU.idkeyStat(400L, 83L, paramLong2 / 1024L, false);
      AppMethodBeat.o(17668);
      return;
      if (!paramBoolean)
      {
        h.qsU.idkeyStat(400L, 86L, paramLong2 / 1024L, false);
        if (paramLong1 != 0L) {
          h.qsU.idkeyStat(400L, 87L, l, false);
        }
        rx(paramInt);
        AppMethodBeat.o(17668);
        return;
      }
      h.qsU.idkeyStat(400L, 88L, paramLong2 / 1024L, false);
      AppMethodBeat.o(17668);
      return;
      if (!paramBoolean)
      {
        h.qsU.idkeyStat(485L, 91L, paramLong2 / 1024L, false);
        if (paramLong1 != 0L) {
          h.qsU.idkeyStat(485L, 92L, l, false);
        }
        rx(paramInt);
        AppMethodBeat.o(17668);
        return;
      }
      h.qsU.idkeyStat(485L, 93L, paramLong2 / 1024L, false);
      AppMethodBeat.o(17668);
      return;
      if (!paramBoolean)
      {
        h.qsU.idkeyStat(485L, 96L, paramLong2 / 1024L, false);
        if (paramLong1 != 0L) {
          h.qsU.idkeyStat(485L, 97L, l, false);
        }
        rx(paramInt);
        AppMethodBeat.o(17668);
        return;
      }
      h.qsU.idkeyStat(485L, 98L, paramLong2 / 1024L, false);
    }
  }
  
  final long hK(long paramLong)
  {
    AppMethodBeat.i(17671);
    String str1 = this.jCL.format(new Date(paramLong));
    String str2 = ac.yxo + "/MM_" + str1 + ".xlog";
    if (com.tencent.mm.vfs.e.cN(str2))
    {
      paramLong = com.tencent.mm.vfs.e.avI(str2);
      AppMethodBeat.o(17671);
      return paramLong;
    }
    str1 = com.tencent.mm.compatible.util.e.esx + "/MM_" + str1 + ".xlog";
    if (com.tencent.mm.vfs.e.cN(str1))
    {
      paramLong = com.tencent.mm.vfs.e.avI(str1);
      AppMethodBeat.o(17671);
      return paramLong;
    }
    AppMethodBeat.o(17671);
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.g
 * JD-Core Version:    0.7.0.1
 */