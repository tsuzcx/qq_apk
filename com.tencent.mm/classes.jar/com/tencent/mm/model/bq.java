package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class bq
{
  private static final Queue<Integer> iEN;
  public static final long[] iEO;
  public static final int[] iEP;
  public static final int[] iEQ;
  public static final int[] iER;
  public static final int[] iES;
  private static bq iET;
  public long[] iEU;
  public long[] iEV;
  
  static
  {
    AppMethodBeat.i(42979);
    iEN = new ConcurrentLinkedQueue();
    iEO = new long[] { 0L, 2000L, 5000L, 10000L, 30000L, 60000L, 180000L, 300000L, 600000L, 1800000L, 3600000L };
    iEP = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    iEQ = new int[] { 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 };
    iER = new int[] { 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170 };
    iES = new int[] { 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200 };
    AppMethodBeat.o(42979);
  }
  
  private bq()
  {
    AppMethodBeat.i(42978);
    Object localObject = (String)g.aAh().azQ().get(ar.a.OnB, "0,0,0,0,0,0,0,0,0,0,0,0");
    this.iEU = new long[12];
    localObject = ((String)localObject).split(",");
    int i = 0;
    if (localObject.length < 12) {}
    for (int j = localObject.length;; j = 12)
    {
      if (i >= j) {
        break label93;
      }
      this.iEU[i] = Util.getLong(localObject[i], 0L);
      i += 1;
      break;
    }
    label93:
    localObject = (String)g.aAh().azQ().get(ar.a.OnC, "0,0,0,0,0,0,0,0,0,0,0,0");
    this.iEV = new long[12];
    localObject = ((String)localObject).split(",");
    i = k;
    if (localObject.length < 12) {}
    for (j = localObject.length;; j = 12)
    {
      if (i >= j) {
        break label175;
      }
      this.iEV[i] = Util.getLong(localObject[i], 0L);
      i += 1;
      break;
    }
    label175:
    AppMethodBeat.o(42978);
  }
  
  public static bq aVU()
  {
    AppMethodBeat.i(42977);
    if (iET == null) {
      iET = new bq();
    }
    bq localbq = iET;
    AppMethodBeat.o(42977);
    return localbq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bq
 * JD-Core Version:    0.7.0.1
 */