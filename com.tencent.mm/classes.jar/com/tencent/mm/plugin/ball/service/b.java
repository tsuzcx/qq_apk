package com.tencent.mm.plugin.ball.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public final class b
{
  static void a(BallInfo paramBallInfo, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    AppMethodBeat.i(106093);
    BallReportInfo localBallReportInfo = paramBallInfo.mDw;
    int j = localBallReportInfo.opType;
    String str1 = localBallReportInfo.mDC;
    String str2 = localBallReportInfo.mDD;
    if (paramBallInfo.mDu) {}
    for (int i = 1;; i = 2)
    {
      paramBallInfo = String.format("%d,%s,%s,%d,%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(j), str1, str2, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(i), Integer.valueOf(localBallReportInfo.mDE), Long.valueOf(paramLong4) });
      h.vKh.kvStat(17604, paramBallInfo);
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
      if (((BallInfo)localObject1).mDu) {
        m = j + 1;
      }
      if ((((BallInfo)localObject1).mDu == paramBallInfo.mDu) && (((BallInfo)localObject1).mDw.mDE >= n))
      {
        j = ((BallInfo)localObject1).mDw.mDE;
        i = ((BallInfo)localObject1).mDw.mDE;
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
        localObject1 = paramBallInfo.mDw;
        g.afz();
        ((BallReportInfo)localObject1).mDC = String.format("%s_%d", new Object[] { a.aeo(), Long.valueOf(paramBallInfo.createTime) });
        localObject1 = paramBallInfo.mDw;
        Object localObject2;
        if (i1 <= 1)
        {
          paramList = String.format("Aggre_%s", new Object[] { paramBallInfo.mDw.mDC });
          ((BallReportInfo)localObject1).mDD = paramList;
          paramBallInfo.mDw.mDE = n;
          if (paramBallInfo.mDw.mDx == 6) {
            paramBallInfo.mDw.mDE = i;
          }
          localObject2 = paramBallInfo.mDw;
        }
        try
        {
          long l = paramBallInfo.mDs;
          m = ((BallReportInfo)localObject2).mDx;
          n = ((BallReportInfo)localObject2).mDy;
          paramList = ((BallReportInfo)localObject2).mDC;
          localObject1 = ((BallReportInfo)localObject2).mDD;
          int i2 = ((BallReportInfo)localObject2).mDE;
          label287:
          int i3;
          String str1;
          String str2;
          int i4;
          if (paramBallInfo.mDu)
          {
            i = 1;
            i3 = ((BallReportInfo)localObject2).mDz;
            str1 = p.encode(bt.nullAsNil(((BallReportInfo)localObject2).dnC));
            str2 = p.encode(bt.nullAsNil(((BallReportInfo)localObject2).mDA));
            localObject2 = p.encode(bt.nullAsNil(((BallReportInfo)localObject2).gWU));
            i4 = paramBallInfo.bzi();
            if (!paramBoolean) {
              break label528;
            }
          }
          label528:
          for (k = 1;; k = 0)
          {
            paramBallInfo = String.format("%d,%d,%d,%s,%s,%d,%d,%d,%d,%d,%s,%s,%s,%d,%d", new Object[] { Long.valueOf(l), Integer.valueOf(m), Integer.valueOf(n), paramList, localObject1, Integer.valueOf(i2), Integer.valueOf(i1 - j), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(i3), str1, str2, localObject2, Integer.valueOf(i4), Integer.valueOf(k) });
            ad.v("MicroMsg.FloatBallReportLogic", "addBallReport reportStr:%s", new Object[] { paramBallInfo });
            h.vKh.kvStat(17602, paramBallInfo);
            AppMethodBeat.o(106090);
            return;
            paramList = ((BallInfo)paramList.get(0)).mDw.mDD;
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
    int i = paramBallInfo.mDw.opType;
    if ((i == 10) || (i == 9) || (i == 8) || (i == 11)) {}
    for (i = 1; i == 0; i = 0)
    {
      ad.w("MicroMsg.FloatBallReportLogic", "removeBallReport unexpected opType:%d", new Object[] { Integer.valueOf(paramBallInfo.mDw.opType) });
      AppMethodBeat.o(106092);
      return;
    }
    long l2 = bt.eGO();
    long l3 = paramBallInfo.mDs;
    long l4 = paramBallInfo.createTime;
    String[] arrayOfString;
    if ((paramBoolean) && (!bt.isNullOrNil(paramBallInfo.mDw.mDD)))
    {
      arrayOfString = paramBallInfo.mDw.mDD.split("_", -1);
      if (arrayOfString.length != 3) {}
    }
    for (;;)
    {
      try
      {
        l1 = bt.aGi(arrayOfString[2]);
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
    if (paramBallInfo.mDw.opType == -1)
    {
      AppMethodBeat.o(106091);
      return;
    }
    int i = paramBallInfo.mDw.opType;
    if ((i == 7) || (i == 4) || (i == 5)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        ad.w("MicroMsg.FloatBallReportLogic", "minimizeBallReport unexpected opType:%d", new Object[] { Integer.valueOf(paramBallInfo.mDw.opType) });
        paramBallInfo.mDw.opType = 6;
      }
      a(paramBallInfo, 0L, 0L, 0L, bt.eGO() - paramBallInfo.mDs);
      AppMethodBeat.o(106091);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.b
 * JD-Core Version:    0.7.0.1
 */