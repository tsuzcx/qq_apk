package com.tencent.mm.plugin.appbrand.luggage.c;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;

public final class a
  implements com.tencent.mm.plugin.appbrand.o.a
{
  private final long[] ioN;
  
  public a()
  {
    AppMethodBeat.i(154855);
    this.ioN = new long[] { 1088L };
    AppMethodBeat.o(154855);
  }
  
  public final void b(ArrayList<IDKey> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(132154);
    h.qsU.b(paramArrayList, paramBoolean);
    AppMethodBeat.o(132154);
  }
  
  public final void idkeyStat(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(143455);
    h.qsU.idkeyStat(paramLong1, paramLong2, paramLong3, paramBoolean);
    long[] arrayOfLong = this.ioN;
    int j = arrayOfLong.length;
    int i = 0;
    if (i < j) {
      if (arrayOfLong[i] != paramLong1) {}
    }
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        e.a(null, 0, 0, paramLong1, paramLong2, paramLong3);
      }
      AppMethodBeat.o(143455);
      return;
      i += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.c.a
 * JD-Core Version:    0.7.0.1
 */