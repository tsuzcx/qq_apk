package com.tencent.mm.plugin.fts.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.math.BigInteger;
import java.util.ArrayList;

public final class e
{
  public static final int[] HrK;
  public static final a HrL;
  public static long HrM;
  public static long HrN;
  public static String HrO;
  
  static
  {
    AppMethodBeat.i(131651);
    HrK = new int[] { 8, 9, 10, 11, 12, 14, 19, 20, 21, 22, 24, 25, 26, 15, 28, 29 };
    HrL = new a();
    HrM = 0L;
    HrN = 0L;
    HrO = "";
    AppMethodBeat.o(131651);
  }
  
  public static void Wf(int paramInt)
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
      f.Ozc.b(localArrayList, false);
      AppMethodBeat.o(131647);
      return;
      localIDKey = new IDKey();
      localIDKey.SetID(146);
      localIDKey.SetKey(1);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
    }
  }
  
  public static final void Wg(int paramInt)
  {
    AppMethodBeat.i(131648);
    Log.i("MicroMsg.FTS.FTSReportApiLogic", "reportCommonChatroom: %d %d", new Object[] { Integer.valueOf(14731), Integer.valueOf(paramInt) });
    f.Ozc.b(14731, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(131648);
  }
  
  public static void aA(int paramInt, long paramLong)
  {
    AppMethodBeat.i(131645);
    if (paramInt > 0)
    {
      int i = (paramInt - 1) * 2 + 1;
      Log.v("MicroMsg.FTS.FTSReportApiLogic", "reportIDKeySearchTime: reportKey=%d taskId=%d time=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
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
      f.Ozc.b(localArrayList, false);
    }
    AppMethodBeat.o(131645);
  }
  
  public static void aB(int paramInt, long paramLong)
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
      f.Ozc.b(localArrayList, false);
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
  
  public static final void fxt()
  {
    AppMethodBeat.i(131649);
    Log.i("MicroMsg.FTS.FTSReportApiLogic", "reportIDKeyFTSData %d %d %d %d %d", new Object[] { Long.valueOf(HrL.HrP), Long.valueOf(HrL.HrQ), Long.valueOf(HrL.HrR), Long.valueOf(HrL.HrT), Long.valueOf(HrL.HrS) });
    ArrayList localArrayList = new ArrayList();
    i(localArrayList, 0);
    if (HrL.HrP > 1536L) {
      i(localArrayList, 1);
    }
    if (HrL.HrQ >= 10000L) {
      i(localArrayList, 2);
    }
    if (HrL.HrR >= 5000L) {
      i(localArrayList, 3);
    }
    if (HrL.HrT >= 10000L) {
      i(localArrayList, 4);
    }
    if (HrL.HrS >= 1000000L) {
      i(localArrayList, 5);
    }
    f.Ozc.b(localArrayList, false);
    AppMethodBeat.o(131649);
  }
  
  public static String fxu()
  {
    AppMethodBeat.i(265531);
    if ((HrO == null) || ("".equals(HrO))) {
      HrO = System.currentTimeMillis();
    }
    String str = HrO;
    AppMethodBeat.o(265531);
    return str;
  }
  
  public static void fxv()
  {
    HrO = "";
  }
  
  public static String fxw()
  {
    AppMethodBeat.i(265532);
    String str = rr(HrM);
    AppMethodBeat.o(265532);
    return str;
  }
  
  private static final void i(ArrayList<IDKey> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(131650);
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(729);
    localIDKey.SetKey(paramInt);
    localIDKey.SetValue(1L);
    paramArrayList.add(localIDKey);
    AppMethodBeat.o(131650);
  }
  
  public static final void n(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(131644);
    if (!d.e(paramInt, HrK))
    {
      AppMethodBeat.o(131644);
      return;
    }
    h.baC();
    long l = new p(b.getUin()).longValue();
    if (com.tencent.mm.protocal.d.Yxi)
    {
      if (l % 100L != 1L) {
        AppMethodBeat.o(131644);
      }
    }
    else if ((com.tencent.mm.protocal.d.Yxj) && (l % 10L != 1L))
    {
      AppMethodBeat.o(131644);
      return;
    }
    if (HrL.HrP >= 1536L) {}
    for (int i = 1;; i = 0)
    {
      String str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt), Long.valueOf(paramLong1), Integer.valueOf(0), Integer.valueOf(i), Long.valueOf(HrL.HrP), Long.valueOf(HrL.HrQ), Long.valueOf(HrL.HrR), Long.valueOf(HrL.HrS), Long.valueOf(HrL.HrT), Long.valueOf(paramLong2) });
      Log.v("MicroMsg.FTS.FTSReportApiLogic", "reportKVSearchTime: %d %s", new Object[] { Integer.valueOf(14175), str });
      f.Ozc.kvStat(14175, str);
      AppMethodBeat.o(131644);
      return;
    }
  }
  
  public static String rr(long paramLong)
  {
    AppMethodBeat.i(265533);
    String str = new BigInteger(Long.toBinaryString(paramLong), 2).toString();
    AppMethodBeat.o(265533);
    return str;
  }
  
  public static final class a
  {
    public long HrP = 0L;
    public long HrQ = 0L;
    public long HrR = 0L;
    public long HrS = 0L;
    public long HrT = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.e
 * JD-Core Version:    0.7.0.1
 */