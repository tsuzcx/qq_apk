package com.tencent.mm.plugin.ball.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;

public final class b
{
  static void a(BallInfo paramBallInfo, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    AppMethodBeat.i(106093);
    BallReportInfo localBallReportInfo = paramBallInfo.nfD;
    int j = localBallReportInfo.opType;
    String str1 = localBallReportInfo.nfI;
    String str2 = localBallReportInfo.nfJ;
    if (paramBallInfo.nfB) {}
    for (int i = 1;; i = 2)
    {
      paramBallInfo = String.format("%d,%s,%s,%d,%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(j), str1, str2, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(i), Integer.valueOf(localBallReportInfo.nfK), Long.valueOf(paramLong4) });
      h.wUl.kvStat(17604, paramBallInfo);
      ac.v("MicroMsg.FloatBallReportLogic", "doOpBallReport reportStr:%s", new Object[] { paramBallInfo });
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
      if (((BallInfo)localObject1).nfB) {
        m = j + 1;
      }
      if ((((BallInfo)localObject1).nfB == paramBallInfo.nfB) && (((BallInfo)localObject1).nfD.nfK >= n))
      {
        j = ((BallInfo)localObject1).nfD.nfK;
        i = ((BallInfo)localObject1).nfD.nfK;
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
        localObject1 = paramBallInfo.nfD;
        g.agP();
        ((BallReportInfo)localObject1).nfI = String.format("%s_%d", new Object[] { a.afE(), Long.valueOf(paramBallInfo.createTime) });
        localObject1 = paramBallInfo.nfD;
        Object localObject2;
        if (i1 <= 1)
        {
          paramList = String.format("Aggre_%s", new Object[] { paramBallInfo.nfD.nfI });
          ((BallReportInfo)localObject1).nfJ = paramList;
          paramBallInfo.nfD.nfK = n;
          if (paramBallInfo.nfD.nfE == 6) {
            paramBallInfo.nfD.nfK = i;
          }
          localObject2 = paramBallInfo.nfD;
        }
        try
        {
          long l = paramBallInfo.nfz;
          m = ((BallReportInfo)localObject2).nfE;
          n = ((BallReportInfo)localObject2).nfF;
          paramList = ((BallReportInfo)localObject2).nfI;
          localObject1 = ((BallReportInfo)localObject2).nfJ;
          int i2 = ((BallReportInfo)localObject2).nfK;
          label287:
          int i3;
          String str1;
          String str2;
          int i4;
          if (paramBallInfo.nfB)
          {
            i = 1;
            i3 = ((BallReportInfo)localObject2).nfG;
            str1 = p.encode(bs.nullAsNil(((BallReportInfo)localObject2).dlk));
            str2 = p.encode(bs.nullAsNil(((BallReportInfo)localObject2).nfH));
            localObject2 = p.encode(bs.nullAsNil(((BallReportInfo)localObject2).hxt));
            i4 = paramBallInfo.bGe();
            if (!paramBoolean) {
              break label528;
            }
          }
          label528:
          for (k = 1;; k = 0)
          {
            paramBallInfo = String.format("%d,%d,%d,%s,%s,%d,%d,%d,%d,%d,%s,%s,%s,%d,%d", new Object[] { Long.valueOf(l), Integer.valueOf(m), Integer.valueOf(n), paramList, localObject1, Integer.valueOf(i2), Integer.valueOf(i1 - j), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(i3), str1, str2, localObject2, Integer.valueOf(i4), Integer.valueOf(k) });
            ac.v("MicroMsg.FloatBallReportLogic", "addBallReport reportStr:%s", new Object[] { paramBallInfo });
            h.wUl.kvStat(17602, paramBallInfo);
            AppMethodBeat.o(106090);
            return;
            paramList = ((BallInfo)paramList.get(0)).nfD.nfJ;
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
    int i = paramBallInfo.nfD.opType;
    if ((i == 10) || (i == 9) || (i == 8) || (i == 11)) {}
    for (i = 1; i == 0; i = 0)
    {
      ac.w("MicroMsg.FloatBallReportLogic", "removeBallReport unexpected opType:%d", new Object[] { Integer.valueOf(paramBallInfo.nfD.opType) });
      AppMethodBeat.o(106092);
      return;
    }
    long l2 = bs.eWj();
    long l3 = paramBallInfo.nfz;
    long l4 = paramBallInfo.createTime;
    String[] arrayOfString;
    if ((paramBoolean) && (!bs.isNullOrNil(paramBallInfo.nfD.nfJ)))
    {
      arrayOfString = paramBallInfo.nfD.nfJ.split("_", -1);
      if (arrayOfString.length != 3) {}
    }
    for (;;)
    {
      try
      {
        l1 = bs.aLz(arrayOfString[2]);
        l1 = l2 - l1;
        a(paramBallInfo, 0L, l1, l2 - l4, l2 - l3);
        AppMethodBeat.o(106092);
        return;
      }
      catch (Exception localException) {}
      long l1 = 0L;
    }
  }
  
  static void w(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(106091);
    if (paramBallInfo.nfD.opType == -1)
    {
      AppMethodBeat.o(106091);
      return;
    }
    int i = paramBallInfo.nfD.opType;
    if ((i == 7) || (i == 4) || (i == 5)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        ac.w("MicroMsg.FloatBallReportLogic", "minimizeBallReport unexpected opType:%d", new Object[] { Integer.valueOf(paramBallInfo.nfD.opType) });
        paramBallInfo.nfD.opType = 6;
      }
      a(paramBallInfo, 0L, 0L, 0L, bs.eWj() - paramBallInfo.nfz);
      AppMethodBeat.o(106091);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.b
 * JD-Core Version:    0.7.0.1
 */