package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.a.b;
import a.f.b.k;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"verify", "", "", "invoke"})
final class f$i
  extends k
  implements b<Long, String>
{
  f$i(f paramf)
  {
    super(1);
  }
  
  public final String hZ(long paramLong)
  {
    AppMethodBeat.i(14817);
    if (f.a(this.kbu, paramLong))
    {
      AppMethodBeat.o(14817);
      return String.valueOf(paramLong);
    }
    AppMethodBeat.o(14817);
    return "NaN";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.f.i
 * JD-Core Version:    0.7.0.1
 */