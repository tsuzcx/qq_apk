package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class bj
{
  private static final Queue<Integer> hoT;
  public static final long[] hoU;
  public static final int[] hoV;
  public static final int[] hoW;
  public static final int[] hoX;
  public static final int[] hoY;
  private static bj hoZ;
  public long[] hpa;
  public long[] hpb;
  
  static
  {
    AppMethodBeat.i(42979);
    hoT = new ConcurrentLinkedQueue();
    hoU = new long[] { 0L, 2000L, 5000L, 10000L, 30000L, 60000L, 180000L, 300000L, 600000L, 1800000L, 3600000L };
    hoV = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    hoW = new int[] { 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 };
    hoX = new int[] { 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170 };
    hoY = new int[] { 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200 };
    AppMethodBeat.o(42979);
  }
  
  private bj()
  {
    AppMethodBeat.i(42978);
    Object localObject = (String)g.agR().agA().get(ah.a.GWr, "0,0,0,0,0,0,0,0,0,0,0,0");
    this.hpa = new long[12];
    localObject = ((String)localObject).split(",");
    int i = 0;
    if (localObject.length < 12) {}
    for (int j = localObject.length;; j = 12)
    {
      if (i >= j) {
        break label93;
      }
      this.hpa[i] = bs.getLong(localObject[i], 0L);
      i += 1;
      break;
    }
    label93:
    localObject = (String)g.agR().agA().get(ah.a.GWs, "0,0,0,0,0,0,0,0,0,0,0,0");
    this.hpb = new long[12];
    localObject = ((String)localObject).split(",");
    i = k;
    if (localObject.length < 12) {}
    for (j = localObject.length;; j = 12)
    {
      if (i >= j) {
        break label175;
      }
      this.hpb[i] = bs.getLong(localObject[i], 0L);
      i += 1;
      break;
    }
    label175:
    AppMethodBeat.o(42978);
  }
  
  public static bj azc()
  {
    AppMethodBeat.i(42977);
    if (hoZ == null) {
      hoZ = new bj();
    }
    bj localbj = hoZ;
    AppMethodBeat.o(42977);
    return localbj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bj
 * JD-Core Version:    0.7.0.1
 */