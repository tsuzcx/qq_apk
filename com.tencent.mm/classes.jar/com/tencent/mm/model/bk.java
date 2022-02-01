package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class bk
{
  private static final Queue<Integer> hHl;
  public static final long[] hHm;
  public static final int[] hHn;
  public static final int[] hHo;
  public static final int[] hHp;
  public static final int[] hHq;
  private static bk hHr;
  public long[] hHs;
  public long[] hHt;
  
  static
  {
    AppMethodBeat.i(42979);
    hHl = new ConcurrentLinkedQueue();
    hHm = new long[] { 0L, 2000L, 5000L, 10000L, 30000L, 60000L, 180000L, 300000L, 600000L, 1800000L, 3600000L };
    hHn = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    hHo = new int[] { 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 };
    hHp = new int[] { 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170 };
    hHq = new int[] { 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200 };
    AppMethodBeat.o(42979);
  }
  
  private bk()
  {
    AppMethodBeat.i(42978);
    Object localObject = (String)g.ajC().ajl().get(al.a.IJp, "0,0,0,0,0,0,0,0,0,0,0,0");
    this.hHs = new long[12];
    localObject = ((String)localObject).split(",");
    int i = 0;
    if (localObject.length < 12) {}
    for (int j = localObject.length;; j = 12)
    {
      if (i >= j) {
        break label93;
      }
      this.hHs[i] = bt.getLong(localObject[i], 0L);
      i += 1;
      break;
    }
    label93:
    localObject = (String)g.ajC().ajl().get(al.a.IJq, "0,0,0,0,0,0,0,0,0,0,0,0");
    this.hHt = new long[12];
    localObject = ((String)localObject).split(",");
    i = k;
    if (localObject.length < 12) {}
    for (j = localObject.length;; j = 12)
    {
      if (i >= j) {
        break label175;
      }
      this.hHt[i] = bt.getLong(localObject[i], 0L);
      i += 1;
      break;
    }
    label175:
    AppMethodBeat.o(42978);
  }
  
  public static bk aCg()
  {
    AppMethodBeat.i(42977);
    if (hHr == null) {
      hHr = new bk();
    }
    bk localbk = hHr;
    AppMethodBeat.o(42977);
    return localbk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bk
 * JD-Core Version:    0.7.0.1
 */