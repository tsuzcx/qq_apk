package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class bm
{
  private static final Queue<Integer> hKd;
  public static final long[] hKe;
  public static final int[] hKf;
  public static final int[] hKg;
  public static final int[] hKh;
  public static final int[] hKi;
  private static bm hKj;
  public long[] hKk;
  public long[] hKl;
  
  static
  {
    AppMethodBeat.i(42979);
    hKd = new ConcurrentLinkedQueue();
    hKe = new long[] { 0L, 2000L, 5000L, 10000L, 30000L, 60000L, 180000L, 300000L, 600000L, 1800000L, 3600000L };
    hKf = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    hKg = new int[] { 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 };
    hKh = new int[] { 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170 };
    hKi = new int[] { 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200 };
    AppMethodBeat.o(42979);
  }
  
  private bm()
  {
    AppMethodBeat.i(42978);
    Object localObject = (String)g.ajR().ajA().get(am.a.JdV, "0,0,0,0,0,0,0,0,0,0,0,0");
    this.hKk = new long[12];
    localObject = ((String)localObject).split(",");
    int i = 0;
    if (localObject.length < 12) {}
    for (int j = localObject.length;; j = 12)
    {
      if (i >= j) {
        break label93;
      }
      this.hKk[i] = bu.getLong(localObject[i], 0L);
      i += 1;
      break;
    }
    label93:
    localObject = (String)g.ajR().ajA().get(am.a.JdW, "0,0,0,0,0,0,0,0,0,0,0,0");
    this.hKl = new long[12];
    localObject = ((String)localObject).split(",");
    i = k;
    if (localObject.length < 12) {}
    for (j = localObject.length;; j = 12)
    {
      if (i >= j) {
        break label175;
      }
      this.hKl[i] = bu.getLong(localObject[i], 0L);
      i += 1;
      break;
    }
    label175:
    AppMethodBeat.o(42978);
  }
  
  public static bm aCw()
  {
    AppMethodBeat.i(42977);
    if (hKj == null) {
      hKj = new bm();
    }
    bm localbm = hKj;
    AppMethodBeat.o(42977);
    return localbm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bm
 * JD-Core Version:    0.7.0.1
 */