package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class br
{
  private static final Queue<Integer> luP;
  public static final long[] luQ;
  public static final int[] luR;
  public static final int[] luS;
  public static final int[] luT;
  public static final int[] luU;
  private static br luV;
  public long[] luW;
  public long[] luX;
  
  static
  {
    AppMethodBeat.i(42979);
    luP = new ConcurrentLinkedQueue();
    luQ = new long[] { 0L, 2000L, 5000L, 10000L, 30000L, 60000L, 180000L, 300000L, 600000L, 1800000L, 3600000L };
    luR = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    luS = new int[] { 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 };
    luT = new int[] { 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170 };
    luU = new int[] { 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200 };
    AppMethodBeat.o(42979);
  }
  
  private br()
  {
    AppMethodBeat.i(42978);
    Object localObject = (String)h.aHG().aHp().get(ar.a.VCO, "0,0,0,0,0,0,0,0,0,0,0,0");
    this.luW = new long[12];
    localObject = ((String)localObject).split(",");
    int i = 0;
    if (localObject.length < 12) {}
    for (int j = localObject.length;; j = 12)
    {
      if (i >= j) {
        break label93;
      }
      this.luW[i] = Util.getLong(localObject[i], 0L);
      i += 1;
      break;
    }
    label93:
    localObject = (String)h.aHG().aHp().get(ar.a.VCP, "0,0,0,0,0,0,0,0,0,0,0,0");
    this.luX = new long[12];
    localObject = ((String)localObject).split(",");
    i = k;
    if (localObject.length < 12) {}
    for (j = localObject.length;; j = 12)
    {
      if (i >= j) {
        break label175;
      }
      this.luX[i] = Util.getLong(localObject[i], 0L);
      i += 1;
      break;
    }
    label175:
    AppMethodBeat.o(42978);
  }
  
  public static br beX()
  {
    AppMethodBeat.i(42977);
    if (luV == null) {
      luV = new br();
    }
    br localbr = luV;
    AppMethodBeat.o(42977);
    return localbr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.br
 * JD-Core Version:    0.7.0.1
 */