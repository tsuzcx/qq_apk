package com.tencent.mm.plugin.fts.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;

public final class e
{
  public static final int[] swT;
  public static final a swU;
  public static long swV;
  public static long swW;
  
  static
  {
    AppMethodBeat.i(131651);
    swT = new int[] { 8, 9, 10, 11, 12, 14, 19, 20, 21, 22, 24, 25, 26, 15, 28, 29 };
    swU = new a();
    swV = 0L;
    swW = 0L;
    AppMethodBeat.o(131651);
  }
  
  public static void Fy(int paramInt)
  {
    AppMethodBeat.i(131647);
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(146);
    localIDKey.SetKey(0);
    localIDKey.SetValue(1L);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localIDKey);
    if (paramInt != 1)
    {
      localIDKey = new IDKey();
      localIDKey.SetID(146);
      localIDKey.SetKey(2);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(146);
      localIDKey.SetKey(paramInt);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.e.wTc.b(localArrayList, false);
      AppMethodBeat.o(131647);
      return;
      localIDKey = new IDKey();
      localIDKey.SetID(146);
      localIDKey.SetKey(1);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
    }
  }
  
  public static final void Fz(int paramInt)
  {
    AppMethodBeat.i(131648);
    ac.i("MicroMsg.FTS.FTSReportApiLogic", "reportCommonChatroom: %d %d", new Object[] { Integer.valueOf(14731), Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.e.wTc.f(14731, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(131648);
  }
  
  public static void ac(int paramInt, long paramLong)
  {
    AppMethodBeat.i(131645);
    if (paramInt > 0)
    {
      int i = (paramInt - 1) * 2 + 1;
      ac.v("MicroMsg.FTS.FTSReportApiLogic", "reportIDKeySearchTime: reportKey=%d taskId=%d time=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
      ArrayList localArrayList = new ArrayList();
      IDKey localIDKey = new IDKey();
      localIDKey.SetID(601);
      localIDKey.SetKey(i);
      localIDKey.SetValue((int)paramLong);
      localArrayList.add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(601);
      localIDKey.SetKey(i + 1);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      com.tencent.mm.plugin.report.e.wTc.b(localArrayList, false);
    }
    AppMethodBeat.o(131645);
  }
  
  public static void ad(int paramInt, long paramLong)
  {
    AppMethodBeat.i(131646);
    ArrayList localArrayList;
    IDKey localIDKey;
    if (paramInt > 0)
    {
      paramInt = (paramInt - 1) * 4 + 1;
      localArrayList = new ArrayList();
      localIDKey = new IDKey();
      localIDKey.SetID(602);
      localIDKey.SetKey(paramInt);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
      if (paramLong > 100L) {
        break label121;
      }
      localIDKey = new IDKey();
      localIDKey.SetID(602);
      localIDKey.SetKey(paramInt + 1);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.e.wTc.b(localArrayList, false);
      AppMethodBeat.o(131646);
      return;
      label121:
      if (paramLong <= 500L)
      {
        localIDKey = new IDKey();
        localIDKey.SetID(602);
        localIDKey.SetKey(paramInt + 2);
        localIDKey.SetValue(1L);
        localArrayList.add(localIDKey);
      }
      else
      {
        localIDKey = new IDKey();
        localIDKey.SetID(602);
        localIDKey.SetKey(paramInt + 3);
        localIDKey.SetValue(1L);
        localArrayList.add(localIDKey);
      }
    }
  }
  
  public static final void cKu()
  {
    AppMethodBeat.i(131649);
    ac.i("MicroMsg.FTS.FTSReportApiLogic", "reportIDKeyFTSData %d %d %d %d %d", new Object[] { Long.valueOf(swU.swX), Long.valueOf(swU.swY), Long.valueOf(swU.swZ), Long.valueOf(swU.sxb), Long.valueOf(swU.sxa) });
    ArrayList localArrayList = new ArrayList();
    d(localArrayList, 0);
    if (swU.swX > 1536L) {
      d(localArrayList, 1);
    }
    if (swU.swY >= 10000L) {
      d(localArrayList, 2);
    }
    if (swU.swZ >= 5000L) {
      d(localArrayList, 3);
    }
    if (swU.sxb >= 10000L) {
      d(localArrayList, 4);
    }
    if (swU.sxa >= 1000000L) {
      d(localArrayList, 5);
    }
    com.tencent.mm.plugin.report.e.wTc.b(localArrayList, false);
    AppMethodBeat.o(131649);
  }
  
  private static final void d(ArrayList<IDKey> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(131650);
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(729);
    localIDKey.SetKey(paramInt);
    localIDKey.SetValue(1L);
    paramArrayList.add(localIDKey);
    AppMethodBeat.o(131650);
  }
  
  public static final void i(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(131644);
    if (!d.f(paramInt, swT))
    {
      AppMethodBeat.o(131644);
      return;
    }
    g.agP();
    long l = new p(a.getUin()).longValue();
    if (com.tencent.mm.protocal.d.DId)
    {
      if (l % 100L != 1L) {
        AppMethodBeat.o(131644);
      }
    }
    else if ((com.tencent.mm.protocal.d.DIe) && (l % 10L != 1L))
    {
      AppMethodBeat.o(131644);
      return;
    }
    if (swU.swX >= 1536L) {}
    for (int i = 1;; i = 0)
    {
      String str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt), Long.valueOf(paramLong1), Integer.valueOf(0), Integer.valueOf(i), Long.valueOf(swU.swX), Long.valueOf(swU.swY), Long.valueOf(swU.swZ), Long.valueOf(swU.sxa), Long.valueOf(swU.sxb), Long.valueOf(paramLong2) });
      ac.v("MicroMsg.FTS.FTSReportApiLogic", "reportKVSearchTime: %d %s", new Object[] { Integer.valueOf(14175), str });
      com.tencent.mm.plugin.report.e.wTc.kvStat(14175, str);
      AppMethodBeat.o(131644);
      return;
    }
  }
  
  public static final class a
  {
    public long swX = 0L;
    public long swY = 0L;
    public long swZ = 0L;
    public long sxa = 0L;
    public long sxb = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.e
 * JD-Core Version:    0.7.0.1
 */