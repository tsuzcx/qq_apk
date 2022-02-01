package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;

final class g$1
  implements j.b
{
  public final void J(ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(146150);
    h.CyF.b(paramArrayList, true);
    AppMethodBeat.o(146150);
  }
  
  public final void yU(long paramLong)
  {
    AppMethodBeat.i(146149);
    h.CyF.idkeyStat(689L, paramLong, 1L, true);
    AppMethodBeat.o(146149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.g.1
 * JD-Core Version:    0.7.0.1
 */