package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.u;

final class af$9
  extends af.b
{
  af$9(af paramaf)
  {
    super(paramaf, (byte)0);
  }
  
  public final r v(u paramu)
  {
    AppMethodBeat.i(175597);
    if (!paramu.jKS())
    {
      paramu = r.qMR;
      AppMethodBeat.o(175597);
      return paramu;
    }
    if (paramu.isDirectory())
    {
      paramu = r.qML;
      AppMethodBeat.o(175597);
      return paramu;
    }
    paramu = r.qMT;
    AppMethodBeat.o(175597);
    return paramu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.af.9
 * JD-Core Version:    0.7.0.1
 */