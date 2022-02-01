package com.tencent.mm.plugin.ball.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public final class b
{
  static void a(BallInfo paramBallInfo, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    AppMethodBeat.i(106093);
    BallReportInfo localBallReportInfo = paramBallInfo.nFZ;
    int j = localBallReportInfo.opType;
    String str1 = localBallReportInfo.nGe;
    String str2 = localBallReportInfo.nGf;
    if (paramBallInfo.nFX) {}
    for (int i = 1;; i = 2)
    {
      paramBallInfo = String.format("%d,%s,%s,%d,%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(j), str1, str2, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(i), Integer.valueOf(localBallReportInfo.nGg), Long.valueOf(paramLong4) });
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(17604, paramBallInfo);
      ad.v("MicroMsg.FloatBallReportLogic", "doOpBallReport reportStr:%s", new Object[] { paramBallInfo });
      AppMethodBeat.o(106093);
      return;
    }
  }
  
  static void a(BallInfo paramBallInfo, List<BallInfo> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(106090);
    int i1 = paramList.size();
    int j = 0;
    int n = 1;
    int i = 1;
    int k = 0;
    Object localObject1;
    int m;
    if (k < i1)
    {
      localObject1 = (BallInfo)paramList.get(k);
      m = j;
      if (((BallInfo)localObject1).nFX) {
        m = j + 1;
      }
      if ((((BallInfo)localObject1).nFX == paramBallInfo.nFX) && (((BallInfo)localObject1).nFZ.nGg >= n))
      {
        j = ((BallInfo)localObject1).nFZ.nGg;
        i = ((BallInfo)localObject1).nFZ.nGg;
        n = j + 1;
      }
    }
    else
    {
      for (;;)
      {
        k += 1;
        j = m;
        break;
        localObject1 = paramBallInfo.nFZ;
        com.tencent.mm.kernel.g.ajA();
        ((BallReportInfo)localObject1).nGe = String.format("%s_%d", new Object[] { a.aiq(), Long.valueOf(paramBallInfo.createTime) });
        localObject1 = paramBallInfo.nFZ;
        Object localObject2;
        if (i1 <= 1)
        {
          paramList = String.format("Aggre_%s", new Object[] { paramBallInfo.nFZ.nGe });
          ((BallReportInfo)localObject1).nGf = paramList;
          paramBallInfo.nFZ.nGg = n;
          if (paramBallInfo.nFZ.nGa == 6) {
            paramBallInfo.nFZ.nGg = i;
          }
          localObject2 = paramBallInfo.nFZ;
        }
        try
        {
          long l = paramBallInfo.nFV;
          m = ((BallReportInfo)localObject2).nGa;
          n = ((BallReportInfo)localObject2).nGb;
          paramList = ((BallReportInfo)localObject2).nGe;
          localObject1 = ((BallReportInfo)localObject2).nGf;
          int i2 = ((BallReportInfo)localObject2).nGg;
          label287:
          int i3;
          String str1;
          String str2;
          int i4;
          if (paramBallInfo.nFX)
          {
            i = 1;
            i3 = ((BallReportInfo)localObject2).nGc;
            str1 = q.encode(bt.nullAsNil(((BallReportInfo)localObject2).dwX));
            str2 = q.encode(bt.nullAsNil(((BallReportInfo)localObject2).nGd));
            localObject2 = q.encode(bt.nullAsNil(((BallReportInfo)localObject2).hPO));
            i4 = paramBallInfo.bKp();
            if (!paramBoolean) {
              break label528;
            }
          }
          label528:
          for (k = 1;; k = 0)
          {
            paramBallInfo = String.format("%d,%d,%d,%s,%s,%d,%d,%d,%d,%d,%s,%s,%s,%d,%d", new Object[] { Long.valueOf(l), Integer.valueOf(m), Integer.valueOf(n), paramList, localObject1, Integer.valueOf(i2), Integer.valueOf(i1 - j), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(i3), str1, str2, localObject2, Integer.valueOf(i4), Integer.valueOf(k) });
            ad.v("MicroMsg.FloatBallReportLogic", "addBallReport reportStr:%s", new Object[] { paramBallInfo });
            com.tencent.mm.plugin.report.service.g.yhR.kvStat(17602, paramBallInfo);
            AppMethodBeat.o(106090);
            return;
            paramList = ((BallInfo)paramList.get(0)).nFZ.nGf;
            break;
            i = 2;
            break label287;
          }
        }
        catch (Exception paramBallInfo)
        {
          AppMethodBeat.o(106090);
          return;
        }
      }
    }
  }
  
  static void b(BallInfo paramBallInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(106092);
    int i = paramBallInfo.nFZ.opType;
    if ((i == 10) || (i == 9) || (i == 8) || (i == 11)) {}
    for (i = 1; i == 0; i = 0)
    {
      ad.w("MicroMsg.FloatBallReportLogic", "removeBallReport unexpected opType:%d", new Object[] { Integer.valueOf(paramBallInfo.nFZ.opType) });
      AppMethodBeat.o(106092);
      return;
    }
    long l2 = bt.flT();
    long l3 = paramBallInfo.nFV;
    long l4 = paramBallInfo.createTime;
    String[] arrayOfString;
    if ((paramBoolean) && (!bt.isNullOrNil(paramBallInfo.nFZ.nGf)))
    {
      arrayOfString = paramBallInfo.nFZ.nGf.split("_", -1);
      if (arrayOfString.length != 3) {}
    }
    for (;;)
    {
      try
      {
        l1 = bt.aRf(arrayOfString[2]);
        l1 = l2 - l1;
        a(paramBallInfo, 0L, l1, l2 - l4, l2 - l3);
        AppMethodBeat.o(106092);
        return;
      }
      catch (Exception localException) {}
      long l1 = 0L;
    }
  }
  
  static void x(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106091);
    if (paramBallInfo.nFZ.opType == -1)
    {
      AppMethodBeat.o(106091);
      return;
    }
    int i = paramBallInfo.nFZ.opType;
    if ((i == 7) || (i == 4) || (i == 5)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        ad.w("MicroMsg.FloatBallReportLogic", "minimizeBallReport unexpected opType:%d", new Object[] { Integer.valueOf(paramBallInfo.nFZ.opType) });
        paramBallInfo.nFZ.opType = 6;
      }
      a(paramBallInfo, 0L, 0L, 0L, bt.flT() - paramBallInfo.nFV);
      AppMethodBeat.o(106091);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.b
 * JD-Core Version:    0.7.0.1
 */