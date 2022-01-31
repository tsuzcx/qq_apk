package com.tencent.mm.plugin.fts.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.a.o;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class e
{
  public static final int[] kvv = { 8, 9, 10, 11, 12, 14, 19, 20, 21, 22, 24, 25, 26 };
  public static final e.a kvw = new e.a();
  public static String kvx = "";
  
  public static final void aVx()
  {
    y.i("MicroMsg.FTS.FTSReportApiLogic", "reportIDKeyFTSData %d %d %d %d %d", new Object[] { Long.valueOf(kvw.kvy), Long.valueOf(kvw.kvz), Long.valueOf(kvw.kvA), Long.valueOf(kvw.kvC), Long.valueOf(kvw.kvB) });
    ArrayList localArrayList = new ArrayList();
    d(localArrayList, 0);
    if (kvw.kvy > 1536L) {
      d(localArrayList, 1);
    }
    if (kvw.kvz >= 10000L) {
      d(localArrayList, 2);
    }
    if (kvw.kvA >= 5000L) {
      d(localArrayList, 3);
    }
    if (kvw.kvC >= 10000L) {
      d(localArrayList, 4);
    }
    if (kvw.kvB >= 1000000L) {
      d(localArrayList, 5);
    }
    f.nEG.b(localArrayList, false);
  }
  
  private static final void d(ArrayList<IDKey> paramArrayList, int paramInt)
  {
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(729);
    localIDKey.SetKey(paramInt);
    localIDKey.SetValue(1L);
    paramArrayList.add(localIDKey);
  }
  
  public static final void g(int paramInt, long paramLong1, long paramLong2)
  {
    if (!d.c(paramInt, kvv)) {}
    long l;
    do
    {
      return;
      g.DN();
      l = new o(a.CK()).longValue();
      if (!com.tencent.mm.protocal.d.spb) {
        break;
      }
    } while (l % 100L != 1L);
    if (kvw.kvy >= 1536L) {}
    for (int i = 1;; i = 0)
    {
      String str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt), Long.valueOf(paramLong1), Integer.valueOf(0), Integer.valueOf(i), Long.valueOf(kvw.kvy), Long.valueOf(kvw.kvz), Long.valueOf(kvw.kvA), Long.valueOf(kvw.kvB), Long.valueOf(kvw.kvC), Long.valueOf(paramLong2) });
      y.v("MicroMsg.FTS.FTSReportApiLogic", "reportKVSearchTime: %d %s", new Object[] { Integer.valueOf(14175), str });
      f.nEG.aC(14175, str);
      return;
      if ((!com.tencent.mm.protocal.d.spc) || (l % 10L == 1L)) {
        break;
      }
      return;
    }
  }
  
  public static void rv(int paramInt)
  {
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
      f.nEG.b(localArrayList, false);
      return;
      localIDKey = new IDKey();
      localIDKey.SetID(146);
      localIDKey.SetKey(1);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
    }
  }
  
  public static final void rw(int paramInt)
  {
    y.i("MicroMsg.FTS.FTSReportApiLogic", "reportCommonChatroom: %d %d", new Object[] { Integer.valueOf(14731), Integer.valueOf(paramInt) });
    f.nEG.f(14731, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void y(int paramInt, long paramLong)
  {
    if (paramInt > 0)
    {
      int i = (paramInt - 1) * 2 + 1;
      y.v("MicroMsg.FTS.FTSReportApiLogic", "reportIDKeySearchTime: reportKey=%d taskId=%d time=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
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
      f.nEG.b(localArrayList, false);
    }
  }
  
  public static void z(int paramInt, long paramLong)
  {
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
        break label111;
      }
      localIDKey = new IDKey();
      localIDKey.SetID(602);
      localIDKey.SetKey(paramInt + 1);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
    }
    for (;;)
    {
      f.nEG.b(localArrayList, false);
      return;
      label111:
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.e
 * JD-Core Version:    0.7.0.1
 */