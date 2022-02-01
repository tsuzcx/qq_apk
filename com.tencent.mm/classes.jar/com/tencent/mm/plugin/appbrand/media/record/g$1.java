package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import java.util.ArrayList;

final class g$1
  implements j.b
{
  public final void D(ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(146150);
    g.yxI.b(paramArrayList, true);
    AppMethodBeat.o(146150);
  }
  
  public final void rd(long paramLong)
  {
    AppMethodBeat.i(146149);
    g.yxI.idkeyStat(689L, paramLong, 1L, true);
    AppMethodBeat.o(146149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.g.1
 * JD-Core Version:    0.7.0.1
 */