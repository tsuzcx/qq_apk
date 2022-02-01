package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;

final class g$1
  implements j.b
{
  public final void ln(long paramLong)
  {
    AppMethodBeat.i(146149);
    h.vKh.idkeyStat(689L, paramLong, 1L, true);
    AppMethodBeat.o(146149);
  }
  
  public final void y(ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(146150);
    h.vKh.b(paramArrayList, true);
    AppMethodBeat.o(146150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.g.1
 * JD-Core Version:    0.7.0.1
 */