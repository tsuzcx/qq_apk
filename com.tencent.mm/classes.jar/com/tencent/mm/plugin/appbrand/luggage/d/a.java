package com.tencent.mm.plugin.appbrand.luggage.d;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a
  implements com.tencent.mm.plugin.appbrand.u.a
{
  private final long[] kPY;
  
  public a()
  {
    AppMethodBeat.i(47576);
    this.kPY = new long[] { 1088L };
    AppMethodBeat.o(47576);
  }
  
  public final void b(ArrayList<IDKey> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(47579);
    com.tencent.mm.plugin.report.service.h.vKh.b(paramArrayList, paramBoolean);
    AppMethodBeat.o(47579);
  }
  
  public final void idkeyStat(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    AppMethodBeat.i(47578);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(paramLong1, paramLong2, paramLong3, paramBoolean);
    long[] arrayOfLong = this.kPY;
    int j = arrayOfLong.length;
    int i = 0;
    if (i < j) {
      if (arrayOfLong[i] != paramLong1) {}
    }
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        com.tencent.mm.plugin.appbrand.report.h.a(null, 0, 0, paramLong1, paramLong2, paramLong3);
      }
      AppMethodBeat.o(47578);
      return;
      i += 1;
      break;
    }
  }
  
  public final void ni(long paramLong)
  {
    AppMethodBeat.i(47577);
    com.tencent.mm.plugin.report.service.h.vKh.m(807L, paramLong, 1L);
    AppMethodBeat.o(47577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.d.a
 * JD-Core Version:    0.7.0.1
 */