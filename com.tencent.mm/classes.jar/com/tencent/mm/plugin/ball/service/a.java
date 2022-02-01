package com.tencent.mm.plugin.ball.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class a
{
  static void a(BallInfo paramBallInfo, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    AppMethodBeat.i(106093);
    BallReportInfo localBallReportInfo = paramBallInfo.rYs;
    int j = localBallReportInfo.opType;
    String str1 = localBallReportInfo.rYA;
    String str2 = localBallReportInfo.rYB;
    if (paramBallInfo.rYr) {}
    for (int i = 1;; i = 2)
    {
      paramBallInfo = String.format("%d,%s,%s,%d,%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(j), str1, str2, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(i), Integer.valueOf(localBallReportInfo.rYC), Long.valueOf(paramLong4) });
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(17604, paramBallInfo);
      Log.v("MicroMsg.FloatBallReportLogic", "doOpBallReport reportStr:%s", new Object[] { paramBallInfo });
      AppMethodBeat.o(106093);
      return;
    }
  }
  
  public static void a(BallInfo paramBallInfo, List<BallInfo> paramList)
  {
    AppMethodBeat.i(187241);
    int i1 = paramBallInfo.rYs.rYz;
    Log.v("MicroMsg.FloatBallReportLogic", "alvinluo addBallReport overLimitType: %d", new Object[] { Integer.valueOf(i1) });
    int i2 = paramList.size();
    int k = 0;
    int n = 1;
    int i = 1;
    int j = 0;
    Object localObject;
    int m;
    if (j < i2)
    {
      localObject = (BallInfo)paramList.get(j);
      m = k;
      if (((BallInfo)localObject).rYr) {
        m = k + 1;
      }
      if ((((BallInfo)localObject).rYr == paramBallInfo.rYr) && (((BallInfo)localObject).rYs.rYC >= n))
      {
        k = ((BallInfo)localObject).rYs.rYC;
        i = ((BallInfo)localObject).rYs.rYC;
        n = k + 1;
      }
    }
    else
    {
      for (;;)
      {
        j += 1;
        k = m;
        break;
        localObject = paramBallInfo.rYs;
        com.tencent.mm.kernel.h.aHE();
        ((BallReportInfo)localObject).rYA = String.format("%s_%d", new Object[] { b.aGq(), Long.valueOf(paramBallInfo.createTime) });
        localObject = paramBallInfo.rYs;
        if (i2 <= 1)
        {
          paramList = String.format("Aggre_%s", new Object[] { paramBallInfo.rYs.rYA });
          ((BallReportInfo)localObject).rYB = paramList;
          paramBallInfo.rYs.rYC = n;
          if (paramBallInfo.rYs.kqY == 6) {
            paramBallInfo.rYs.rYC = i;
          }
          paramList = paramBallInfo.rYs;
        }
        try
        {
          long l = paramBallInfo.rYp;
          j = paramList.kqY;
          m = paramList.rYx;
          localObject = paramList.rYA;
          String str = paramList.rYB;
          n = paramList.rYC;
          if (paramBallInfo.rYr) {}
          for (i = 1;; i = 2)
          {
            paramBallInfo = String.format("%d,%d,%d,%s,%s,%d,%d,%d,%d,%d,%s,%s,%s,%d,%d", new Object[] { Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(m), localObject, str, Integer.valueOf(n), Integer.valueOf(i2 - k), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(paramList.kqZ), q.aT(Util.nullAsNil(paramList.fIZ)), q.aT(Util.nullAsNil(paramList.rYy)), q.aT(Util.nullAsNil(paramList.lEm)), Integer.valueOf(paramBallInfo.cvs()), Integer.valueOf(i1) });
            Log.v("MicroMsg.FloatBallReportLogic", "addBallReport reportStr:%s", new Object[] { paramBallInfo });
            com.tencent.mm.plugin.report.service.h.IzE.kvStat(17602, paramBallInfo);
            AppMethodBeat.o(187241);
            return;
            paramList = ((BallInfo)paramList.get(0)).rYs.rYB;
            break;
          }
        }
        catch (Exception paramBallInfo)
        {
          AppMethodBeat.o(187241);
          return;
        }
      }
    }
  }
  
  static void b(BallInfo paramBallInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(106092);
    int i = paramBallInfo.rYs.opType;
    if ((i == 10) || (i == 9) || (i == 8) || (i == 11) || (i == 14) || (i == 15)) {}
    for (i = 1; i == 0; i = 0)
    {
      Log.w("MicroMsg.FloatBallReportLogic", "removeBallReport unexpected opType:%d", new Object[] { Integer.valueOf(paramBallInfo.rYs.opType) });
      AppMethodBeat.o(106092);
      return;
    }
    long l2 = Util.nowMilliSecond();
    long l3 = paramBallInfo.rYp;
    long l4 = paramBallInfo.createTime;
    String[] arrayOfString;
    if ((paramBoolean) && (!Util.isNullOrNil(paramBallInfo.rYs.rYB)))
    {
      arrayOfString = paramBallInfo.rYs.rYB.split("_", -1);
      if (arrayOfString.length != 3) {}
    }
    for (;;)
    {
      try
      {
        l1 = Util.safeParseLong(arrayOfString[2]);
        l1 = l2 - l1;
        a(paramBallInfo, 0L, l1, l2 - l4, l2 - l3);
        AppMethodBeat.o(106092);
        return;
      }
      catch (Exception localException) {}
      long l1 = 0L;
    }
  }
  
  static void y(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106091);
    if (paramBallInfo.rYs.opType == -1)
    {
      AppMethodBeat.o(106091);
      return;
    }
    int i = paramBallInfo.rYs.opType;
    if ((i == 7) || (i == 4) || (i == 5) || (i == 12) || (i == 13)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        Log.w("MicroMsg.FloatBallReportLogic", "minimizeBallReport unexpected opType:%d", new Object[] { Integer.valueOf(paramBallInfo.rYs.opType) });
        paramBallInfo.rYs.opType = 6;
      }
      a(paramBallInfo, 0L, 0L, 0L, Util.nowMilliSecond() - paramBallInfo.rYp);
      AppMethodBeat.o(106091);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.a
 * JD-Core Version:    0.7.0.1
 */