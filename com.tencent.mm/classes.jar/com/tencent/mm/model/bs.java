package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class bs
{
  private static final Queue<Integer> omm;
  public static final long[] omn;
  public static final int[] omo;
  public static final int[] omp;
  public static final int[] omq;
  public static final int[] omr;
  private static bs oms;
  public long[] omt;
  public long[] omu;
  
  static
  {
    AppMethodBeat.i(42979);
    omm = new ConcurrentLinkedQueue();
    omn = new long[] { 0L, 2000L, 5000L, 10000L, 30000L, 60000L, 180000L, 300000L, 600000L, 1800000L, 3600000L };
    omo = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    omp = new int[] { 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 };
    omq = new int[] { 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170 };
    omr = new int[] { 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200 };
    AppMethodBeat.o(42979);
  }
  
  private bs()
  {
    AppMethodBeat.i(42978);
    Object localObject = (String)h.baE().ban().get(at.a.adfI, "0,0,0,0,0,0,0,0,0,0,0,0");
    this.omt = new long[12];
    localObject = ((String)localObject).split(",");
    int i = 0;
    if (localObject.length < 12) {}
    for (int j = localObject.length;; j = 12)
    {
      if (i >= j) {
        break label93;
      }
      this.omt[i] = Util.getLong(localObject[i], 0L);
      i += 1;
      break;
    }
    label93:
    localObject = (String)h.baE().ban().get(at.a.adfJ, "0,0,0,0,0,0,0,0,0,0,0,0");
    this.omu = new long[12];
    localObject = ((String)localObject).split(",");
    i = k;
    if (localObject.length < 12) {}
    for (j = localObject.length;; j = 12)
    {
      if (i >= j) {
        break label175;
      }
      this.omu[i] = Util.getLong(localObject[i], 0L);
      i += 1;
      break;
    }
    label175:
    AppMethodBeat.o(42978);
  }
  
  public static bs bCO()
  {
    AppMethodBeat.i(42977);
    if (oms == null) {
      oms = new bs();
    }
    bs localbs = oms;
    AppMethodBeat.o(42977);
    return localbs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bs
 * JD-Core Version:    0.7.0.1
 */