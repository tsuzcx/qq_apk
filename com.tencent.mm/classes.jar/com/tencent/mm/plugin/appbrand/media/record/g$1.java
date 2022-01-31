package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;

final class g$1
  implements j.b
{
  public final void hB(long paramLong)
  {
    AppMethodBeat.i(141589);
    h.qsU.idkeyStat(689L, paramLong, 1L, true);
    AppMethodBeat.o(141589);
  }
  
  public final void n(ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(141590);
    h.qsU.b(paramArrayList, true);
    AppMethodBeat.o(141590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.g.1
 * JD-Core Version:    0.7.0.1
 */