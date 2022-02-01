package com.tencent.mm.plugin.ball.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;

public final class b
{
  static void a(BallInfo paramBallInfo, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    AppMethodBeat.i(106093);
    BallReportInfo localBallReportInfo = paramBallInfo.nLw;
    int j = localBallReportInfo.opType;
    String str1 = localBallReportInfo.nLF;
    String str2 = localBallReportInfo.nLG;
    if (paramBallInfo.nLu) {}
    for (int i = 1;; i = 2)
    {
      paramBallInfo = String.format("%d,%s,%s,%d,%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(j), str1, str2, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(i), Integer.valueOf(localBallReportInfo.nLH), Long.valueOf(paramLong4) });
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(17604, paramBallInfo);
      ae.v("MicroMsg.FloatBallReportLogic", "doOpBallReport reportStr:%s", new Object[] { paramBallInfo });
      AppMethodBeat.o(106093);
      return;
    }
  }
  
  public static void a(BallInfo paramBallInfo, List<BallInfo> paramList)
  {
    AppMethodBeat.i(209443);
    int i1 = paramBallInfo.nLw.nLE;
    ae.v("MicroMsg.FloatBallReportLogic", "alvinluo addBallReport overLimitType: %d", new Object[] { Integer.valueOf(i1) });
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
      if (((BallInfo)localObject).nLu) {
        m = k + 1;
      }
      if ((((BallInfo)localObject).nLu == paramBallInfo.nLu) && (((BallInfo)localObject).nLw.nLH >= n))
      {
        k = ((BallInfo)localObject).nLw.nLH;
        i = ((BallInfo)localObject).nLw.nLH;
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
        localObject = paramBallInfo.nLw;
        com.tencent.mm.kernel.g.ajP();
        ((BallReportInfo)localObject).nLF = String.format("%s_%d", new Object[] { a.aiF(), Long.valueOf(paramBallInfo.createTime) });
        localObject = paramBallInfo.nLw;
        if (i2 <= 1)
        {
          paramList = String.format("Aggre_%s", new Object[] { paramBallInfo.nLw.nLF });
          ((BallReportInfo)localObject).nLG = paramList;
          paramBallInfo.nLw.nLH = n;
          if (paramBallInfo.nLw.nLA == 6) {
            paramBallInfo.nLw.nLH = i;
          }
          paramList = paramBallInfo.nLw;
        }
        try
        {
          long l = paramBallInfo.nLs;
          j = paramList.nLA;
          m = paramList.nLB;
          localObject = paramList.nLF;
          String str = paramList.nLG;
          n = paramList.nLH;
          if (paramBallInfo.nLu) {}
          for (i = 1;; i = 2)
          {
            paramBallInfo = String.format("%d,%d,%d,%s,%s,%d,%d,%d,%d,%d,%s,%s,%s,%d,%d", new Object[] { Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(m), localObject, str, Integer.valueOf(n), Integer.valueOf(i2 - k), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(paramList.nLC), q.encode(bu.nullAsNil(paramList.dyc)), q.encode(bu.nullAsNil(paramList.nLD)), q.encode(bu.nullAsNil(paramList.hSG)), Integer.valueOf(paramBallInfo.bLm()), Integer.valueOf(i1) });
            ae.v("MicroMsg.FloatBallReportLogic", "addBallReport reportStr:%s", new Object[] { paramBallInfo });
            com.tencent.mm.plugin.report.service.g.yxI.kvStat(17602, paramBallInfo);
            AppMethodBeat.o(209443);
            return;
            paramList = ((BallInfo)paramList.get(0)).nLw.nLG;
            break;
          }
        }
        catch (Exception paramBallInfo)
        {
          AppMethodBeat.o(209443);
          return;
        }
      }
    }
  }
  
  static void b(BallInfo paramBallInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(106092);
    int i = paramBallInfo.nLw.opType;
    if ((i == 10) || (i == 9) || (i == 8) || (i == 11)) {}
    for (i = 1; i == 0; i = 0)
    {
      ae.w("MicroMsg.FloatBallReportLogic", "removeBallReport unexpected opType:%d", new Object[] { Integer.valueOf(paramBallInfo.nLw.opType) });
      AppMethodBeat.o(106092);
      return;
    }
    long l2 = bu.fpO();
    long l3 = paramBallInfo.nLs;
    long l4 = paramBallInfo.createTime;
    String[] arrayOfString;
    if ((paramBoolean) && (!bu.isNullOrNil(paramBallInfo.nLw.nLG)))
    {
      arrayOfString = paramBallInfo.nLw.nLG.split("_", -1);
      if (arrayOfString.length != 3) {}
    }
    for (;;)
    {
      try
      {
        l1 = bu.aSC(arrayOfString[2]);
        l1 = l2 - l1;
        a(paramBallInfo, 0L, l1, l2 - l4, l2 - l3);
        AppMethodBeat.o(106092);
        return;
      }
      catch (Exception localException) {}
      long l1 = 0L;
    }
  }
  
  static void z(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106091);
    if (paramBallInfo.nLw.opType == -1)
    {
      AppMethodBeat.o(106091);
      return;
    }
    int i = paramBallInfo.nLw.opType;
    if ((i == 7) || (i == 4) || (i == 5)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        ae.w("MicroMsg.FloatBallReportLogic", "minimizeBallReport unexpected opType:%d", new Object[] { Integer.valueOf(paramBallInfo.nLw.opType) });
        paramBallInfo.nLw.opType = 6;
      }
      a(paramBallInfo, 0L, 0L, 0L, bu.fpO() - paramBallInfo.nLs);
      AppMethodBeat.o(106091);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.b
 * JD-Core Version:    0.7.0.1
 */